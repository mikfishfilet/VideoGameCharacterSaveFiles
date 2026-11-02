import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<GameCharacter> characters = new ArrayList<>();

        // Create characters
        characters.add(new GameCharacter("Brutus", "Warrior", 5, 120, 18, 250));
        characters.add(new GameCharacter("Elara", "Mage", 7, 80, 25, 400));
        characters.add(new GameCharacter("Rowan", "Archer", 4, 95, 16, 175));

        System.out.println("Video Game Character Save Files");
        System.out.println("-------------------------------");

        System.out.println("\nCharacters created:");

        for (GameCharacter character : characters) {
            System.out.println(character);
        }

        try {
            // Save JSON file
            StringBuilder json = new StringBuilder("[\n");

            for (int i = 0; i < characters.size(); i++) {
                GameCharacter c = characters.get(i);

                json.append("  {\n");
                json.append("    \"name\": \"").append(c.getName()).append("\",\n");
                json.append("    \"characterClass\": \"").append(c.getCharacterClass()).append("\",\n");
                json.append("    \"level\": ").append(c.getLevel()).append(",\n");
                json.append("    \"health\": ").append(c.getHealth()).append(",\n");
                json.append("    \"attackPower\": ").append(c.getAttackPower()).append(",\n");
                json.append("    \"gold\": ").append(c.getGold()).append("\n");
                json.append("  }");

                if (i < characters.size() - 1) {
                    json.append(",");
                }

                json.append("\n");
            }

            json.append("]");

            Files.writeString(Path.of("characters.json"), json.toString());

            System.out.println("\ncharacters.json created successfully.");

            // Save XML file
            StringBuilder xml = new StringBuilder();
            xml.append("<characters>\n");

            for (GameCharacter c : characters) {
                xml.append("  <character>\n");
                xml.append("    <name>").append(c.getName()).append("</name>\n");
                xml.append("    <characterClass>").append(c.getCharacterClass()).append("</characterClass>\n");
                xml.append("    <level>").append(c.getLevel()).append("</level>\n");
                xml.append("    <health>").append(c.getHealth()).append("</health>\n");
                xml.append("    <attackPower>").append(c.getAttackPower()).append("</attackPower>\n");
                xml.append("    <gold>").append(c.getGold()).append("</gold>\n");
                xml.append("  </character>\n");
            }

            xml.append("</characters>");

            Files.writeString(Path.of("characters.xml"), xml.toString());

            System.out.println("characters.xml created successfully.");

            // Read and display JSON file
            System.out.println("\nReading JSON file:");
            System.out.println(Files.readString(Path.of("characters.json")));

            // Read and display XML file
            System.out.println("\nReading XML file:");
            System.out.println(Files.readString(Path.of("characters.xml")));

        } catch (IOException e) {
            System.out.println("An error occurred while saving or reading files.");
            e.printStackTrace();
        }
    }
}

