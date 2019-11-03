import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateRemover {
    private Set<String>uniqueWords; //using set of strings

    public void remove (String dataFile) throws FileNotFoundException {
        uniqueWords = new HashSet<String>();
        Scanner scnr = new Scanner(new File(dataFile));
        String input;
        while (scnr.hasNext()) { //traverse through the list
            input = scnr.next();
            uniqueWords.add(input); //any duplicates added will be ignored
        }
        scnr.close();
    }
    public void write (String outputFile) throws IOException {
        File newFile = new File(outputFile);
        FileWriter fileWriter;
        Iterator iteration = uniqueWords.iterator();
        if (newFile.exists()) {
            fileWriter = new FileWriter(newFile, false);
            while (iteration.hasNext()) {
                String words = (String)iteration.next(); //storing word into variable to print into file
                fileWriter.write(words + "\n");
            }
            fileWriter.close();
            System.out.println("File has been created/updated.");
        }
        else {
            newFile.createNewFile();
            fileWriter = new FileWriter(newFile);
            while (iteration.hasNext()) {
                String words = (String)iteration.next(); //storing word into variable to print into file
                fileWriter.write(words + "\n");
            }
            fileWriter.close();
            System.out.println("File has been created/updated.");
        }
    }
}