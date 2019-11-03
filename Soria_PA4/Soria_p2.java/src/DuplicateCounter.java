import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;

public class DuplicateCounter {
    private Map<String, Integer>wordCounter; //HashMap tp store string and int

    public void count (String dataFile) throws FileNotFoundException {
        wordCounter = new HashMap<String, Integer>();
        Scanner scnr = new Scanner(new File(dataFile));
        String input;
        while (scnr.hasNext()) { //traverse through the list
            input = scnr.next();
            if(wordCounter.containsKey(input)) {
                wordCounter.put(input, wordCounter.get(input) + 1);
            }
            wordCounter.putIfAbsent(input, 1); //any duplicates added will be ignored and count++
        }
        scnr.close();
    }
    public void write (String outputFile) throws IOException {
        File newFile = new File(outputFile);
        FileWriter fileWriter;
        if (newFile.exists()) {
            fileWriter = new FileWriter(newFile, false);
            for (String name: wordCounter.keySet()){
                String key = name.toString();
                String value = wordCounter.get(name).toString();
                fileWriter.write(key + " " + value + "\n");
            }
            fileWriter.close();
            System.out.println("File has been created/updated.");
        }
        else {
            newFile.createNewFile();
            fileWriter = new FileWriter(newFile);
            for (String name: wordCounter.keySet()){
                String key = name.toString();
                String value = wordCounter.get(name).toString();
                fileWriter.write(key + " " + value + "\n");
            }
            fileWriter.close();
            System.out.println("File has been created/updated.");
        }
    }
}
