package StreamsFilesandDirectoriesExercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class wordCount06 {
    public static void main(String[] args) throws IOException {
        Scanner wordScanner = new Scanner(new FileReader("src/StreamsFilesandDirectoriesExercise/words.txt"));
        String[] wordsToSearch = wordScanner.nextLine().split(" ");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : wordsToSearch) {
            map.put(word.toLowerCase(), 0);
        }

        Scanner fileScanner = new Scanner(new FileReader("src/StreamsFilesandDirectoriesExercise/text.txt"));
        String singleWord = fileScanner.next().toLowerCase();
        while(fileScanner.hasNext()){
            if(map.containsKey(singleWord)){
                int occurrences = map.get(singleWord);
                occurrences++;
                map.put(singleWord, occurrences);
            }
            singleWord = fileScanner.next();
        }
        PrintWriter pw = new PrintWriter(new FileWriter("src/StreamsFilesandDirectoriesExercise/result.txt"));
        map.entrySet()
                .stream()
                .sorted((f, s) -> s.getValue() - f.getValue())
                .forEach(entry -> pw.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        fileScanner.close();
        wordScanner.close();
        pw.close();


    }
}
