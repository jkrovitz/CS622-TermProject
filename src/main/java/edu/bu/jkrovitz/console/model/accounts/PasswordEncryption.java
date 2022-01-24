package edu.bu.jkrovitz.console.model.accounts;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;


public class PasswordEncryption {

    private static final String SECRET_KEY = "my_super_secret_key";
    private static final String SALT = "ssshhhhhhhhhhh!!!!";

    public static String encrypt(String strToEncrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }






//    private static final Random random = new SecureRandom();
//    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//    private static final int iterations = 10000;
//    private static final int keylength = 256;
//
//    /* Method to generate the salt value. */
//    public static String getSaltvalue(int length)
//    {
//        StringBuilder finalval = new StringBuilder(length);
//
//        for (int i = 0; i < length; i++)
//        {
//            finalval.append(characters.charAt(random.nextInt(characters.length())));
//        }
//
//        return new String(finalval);
//    }
//
//    /* Method to generate the hash value */
//    public static byte[] hash(char[] password, byte[] salt)
//    {
//        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);
//        Arrays.fill(password, Character.MIN_VALUE);
//        try
//        {
//            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//            return skf.generateSecret(spec).getEncoded();
//        }
//        catch (NoSuchAlgorithmException | InvalidKeySpecException e)
//        {
//            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
//        }
//        finally
//        {
//            spec.clearPassword();
//        }
//    }
//
//    /* Method to encrypt the password using the original password and salt value. */
//    public static String generateSecurePassword(String password, String salt)
//    {
//        String finalval = null;
//
//        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
//
//        finalval = Base64.getEncoder().encodeToString(securePassword);
//
//        return finalval;
//    }
//
//    /* Method to verify if both password matches or not */
//    public static boolean verifyUserPassword(String providedPassword,
//                                             String securedPassword, String salt)
//    {
//        boolean finalval = false;
//
//        /* Generate New secure password with the same salt */
//        String newSecurePassword = generateSecurePassword(providedPassword, salt);
//
//        /* Check if two passwords are equal */
//        finalval = newSecurePassword.equalsIgnoreCase(securedPassword);
//
//        return finalval;
//    }

//    public String setPassword(String password){
//        String salt = "1234";
//        int iterations = 10000;
//        int keyLength = 512;
//        char[] passwordChars = password.toCharArray();
//        byte[] saltBytes = salt.getBytes();
//        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
//        return Hex.encodeHexString(hashedBytes);
//    }
//
//    public static byte[] hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) {
//
//        try {
//            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
//            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
//            SecretKey key = skf.generateSecret( spec );
//            return key.getEncoded( );
//        } catch ( NoSuchAlgorithmException | InvalidKeySpecException e ) {
//            throw new RuntimeException( e );
//        }
//    }
}
