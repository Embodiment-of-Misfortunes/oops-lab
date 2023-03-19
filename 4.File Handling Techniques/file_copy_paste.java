import java.io.*; 
public class filecopypaste {
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Get the input filename from the user
        System.out.println("Enter the input filename:");
        String inputFileName = "";
        try {
            inputFileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading input filename: " + e.getMessage());
            return;
        }

        // Get the output filename from the user
        System.out.println("Enter the output filename:");
        String outputFileName = "";
        try {
            outputFileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading output filename: " + e.getMessage());
            return;
        }

        // Prompt the user to enter some text
        System.out.println("Enter some text in the first file:");
        String text = "";
        try {
            text = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading user input: " + e.getMessage());
            return;
        }

        // Write the text to the first file
        try {
            FileWriter fileWriter = new FileWriter(inputFileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating input file: " + e.getMessage());
            return;
        }

        // Read the text from the first file
        String inputText = "";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(inputFileName));
            inputText = fileReader.readLine();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        // Write the text to a new file
        try {
            FileWriter fileWriter = new FileWriter(outputFileName);
            fileWriter.write(inputText);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating output file: " + e.getMessage());
            return;
        }

        System.out.println("Text copied successfully from " + inputFileName + " to " + outputFileName + ".");
        System.out.println("The text in " + outputFileName + " is: " + inputText);
}

}
