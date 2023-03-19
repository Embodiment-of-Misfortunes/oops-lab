import java.io.*;
import java.util.Scanner;

/*
 * @author Hp
 */
public class filesearchreplace {

    /* @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        // Get the input filename from the user
        System.out.println("Enter the input filename:");
        String inputFileName = scanner.nextLine();

        // Get the output filename from the user
        System.out.println("Enter the output filename:");
        String outputFileName = scanner.nextLine();

        // Get the text to write to the file from the user
        System.out.println("Enter the text to write to the file:");
        String textToWrite = scanner.nextLine();

        // Write the text to a file
        try {
            FileWriter fileWriter = new FileWriter(inputFileName);
            fileWriter.write(textToWrite);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating input file: " + e.getMessage());
            return;
        }

        // Read the text from the file
        String text = "";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(inputFileName));
            String line;
            while ((line = fileReader.readLine()) != null) {
                text += line + "\n";
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        // Get the search keyword from the user
        System.out.println("Enter the search keyword:");
        String searchKeyword = scanner.nextLine();

        // Find the position and line number of the search keyword
        int position = text.indexOf(searchKeyword);
        int lineNumber = text.substring(0, position).split("\n").length;

        if (position == -1) {
            System.out.println("The search keyword was not found.");
            return;
        } else {
            System.out.println("The search keyword was found at position " + position + " on line " + lineNumber + ".");
        }

        // Get the replacement word from the user
        System.out.println("Enter the replacement word:");
        String replacementWord = scanner.nextLine();

        // Replace the search keyword with the replacement word
        text = text.replace(searchKeyword, replacementWord);

        // Write the updated text to the output file
        try {
            FileWriter fileWriter = new FileWriter(outputFileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating output file: " + e.getMessage());
            return;
        }

        System.out.println("The search keyword has been replaced with the replacement word.");
        // System.out.println("file after replaceword" + outputFilename);
}

}
