import java.nio.file.Files;
import java.nio.file.Paths;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class StajSifreCozme {
    public static void main(String[] args) {
        try {
            // Şifreli dosyayı oku
            byte[] encryptedHash = Files.readAllBytes(Paths.get("Albil_staj_hash_encrypted.txt"));

            // Anahtarı oku
            byte[] keyBytes = Files.readAllBytes(Paths.get("secretKey.key"));
            SecretKey secretKey = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");

            // Şifreyi çöz
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedHash = cipher.doFinal(encryptedHash);

            // Şifre çözülmüş hash'i string olarak al
            String decryptedHashString = new String(decryptedHash);
            System.out.println("Sifre cozulmus hash: " + decryptedHashString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
