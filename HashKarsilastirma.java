import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class HashKarsilastirma {
    public static void main(String[] args) {
        try {
            // İlk hashi okur
            String originalHash = new String(Files.readAllBytes(Paths.get("Albil_staj_hash.txt")),
                    StandardCharsets.UTF_8);

            // Degistirilmis hashi okur
            String modifiedHash = new String(Files.readAllBytes(Paths.get("Albil_staj_hash_2.txt")),
                    StandardCharsets.UTF_8);

            // Hashleri karsilastir
            if (originalHash.equals(modifiedHash)) {
                System.out.println("Dosyaniz degismemistir.");
            } else {
                System.out.println("Dosyaniz degistirilmistir.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}