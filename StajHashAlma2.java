import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class StajHashAlma2 {

    public static void main(String[] args) {
        try {
            // Hash hesapla
            byte[] fileBytes = Files.readAllBytes(Paths.get("Albil_staj.txt"));
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(fileBytes);
            StringBuilder hashString = new StringBuilder();
            for (byte b : hashBytes) {
                hashString.append(String.format("%02x", b));
            }

            // Hash'i dosyaya yazdır
            FileWriter writer = new FileWriter("Albil_staj_hash_2.txt");
            writer.write(hashString.toString());
            writer.close();
            System.out.println("Degistirilmis dosyanin hash'i Albil_staj_hash_2.txt dosyasina yazildi.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
