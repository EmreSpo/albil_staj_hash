import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Sifreleme {
    public static void main(String[] args) {
        try {
            // Hash dosyasını oku
            byte[] hashBytes = Files.readAllBytes(Paths.get("Albil_staj_hash.txt"));

            // Anahtar oluştur
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Şifreleme işlemini yap
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedHash = cipher.doFinal(hashBytes);

            // Şifrelenmiş dosyayı yaz
            FileOutputStream fos = new FileOutputStream("Albil_staj_hash_encrypted.txt");
            fos.write(encryptedHash);
            fos.close();
            System.out.println("Albil_staj_hash.txt dosyasi sifrelendi.");

            // Şifreleme anahtarını sakla (daha sonra şifreyi çözmek için)
            try (FileOutputStream keyOut = new FileOutputStream("secretKey.key")) {
                keyOut.write(secretKey.getEncoded());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
