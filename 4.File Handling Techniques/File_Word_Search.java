import java.io.*;
import java.util.Scanner;

public class Filewordsearch {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        // Get the filename from the user
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();

        // Get the text to write to the file
        System.out.print("Enter the text to write to the file: ");
        String text = scanner.nextLine();

        // Write the text to the file
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }

        // Get the keyword to search for
        System.out.print("Enter the keyword to search for: ");
        String keyword = scanner.nextLine();

        // Search for the keyword in the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 1;
            int position = -1;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(keyword)) {
                        count++;
                        System.out.println("Keyword found at line " + lineNumber + ", position " + i + ".");
                    }
                }
                lineNumber++;
            }
            reader.close();

            if (count == 0) {
                System.out.println("Keyword not found in file.");
            } else {
                System.out.println("Keyword found " + count + " times in file.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
}
}
}
