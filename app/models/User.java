package models;

import java.security.*;
import java.util.Random;

import javax.persistence.*;

import org.apache.commons.codec.binary.Base64;
import play.api.libs.Crypto;
import play.data.validation.Constraints.Email;
import play.db.ebean.Model;

@Entity
public class User extends Model {


    @Id
    @Email
    private String email;


    private String passwordHash;


    private String salt;

    public User(String email, String password) {
        this.email = email;
        setPassword(password);
    }


    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);


    private String getHash(String s) {
        return SHA256(s);
    }


    public void setPassword(String password) {
        this.salt = genSalt();
        this.passwordHash = getHash(password + salt);

    }


    private boolean checkPassword(String password) {
        if(!password.isEmpty() && (this.passwordHash.equals(getHash(password + this.salt)))){
            return true;
        }
        else {return false;}
       // return !password.isEmpty();
    }



    public static String authenticate(String email, String password) {
        User user = find.byId(email);
        if( user == null) {
            return "No Account with this E-Mail";
        }
        if( !user.checkPassword(password)){
            return "Wrong Password";
        }
        return null;
    }



    public static boolean emailAvailable(String email) {
        return find.byId(email) == null;
    }


    public static String SHA256(String str) {
         try {
             MessageDigest digest = MessageDigest.getInstance("SHA-256");
             digest.update(str.getBytes());
             return javax.xml.bind.DatatypeConverter.printHexBinary(digest.digest());
         } catch (NoSuchAlgorithmException e) {
             throw new RuntimeException(e);
         }
    }

    public static String SHA1(String str){
        //Используется класс Crypto из пакета, встроенного в Play
        return Crypto.sign(str);
    }


    public static String genSalt(){
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        return Base64.encodeBase64String(salt);
    }
}
