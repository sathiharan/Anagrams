package com.smdg.anagrams.controller;

import com.smdg.anagrams.AnagramResults;
import com.smdg.anagrams.OutputDisplay;
import com.smdg.anagrams.service.AnagramsMatcherImpl;
import com.smdg.anagrams.filescanner.FileScanner;
import com.smdg.anagrams.service.AnagramsMatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author haran
 */
public class AnagramController {

    List<String> wordsList = new ArrayList<>();

    public void run() {

        OutputDisplay outputDisplay = new OutputDisplay();
        AnagramResults anagramResults = new AnagramResults();

        try {

            Scanner input = new Scanner(System.in);
            System.out.println("Specify location of the sample.txt file");
            System.out.println("Enter the location:");
            String fileLocation = input.nextLine();

            FileScanner fileScanner = new FileScanner();
            wordsList = fileScanner.scaneFile(fileLocation).collect(Collectors.toList());
            outputDisplay.print("------------------------------------- start -------------------------------------------------");
            outputDisplay.print("The Words in the file are:");
            wordsList.forEach(wordList -> {
                outputDisplay.print(wordList);
            });

            AnagramsMatcher anagramsMatcher = new AnagramsMatcherImpl();
            anagramsMatcher.matchAnagram(wordsList, anagramResults);
            outputDisplay.print("------------------OUTPUT: ANAGRAM WORDS------------------");
            List<List<String>> angrmResults = anagramResults.getResults();
            angrmResults.forEach(resultItem -> {
                outputDisplay.print("The output is : " + resultItem);
            });
            outputDisplay.print("------------------------------------- End -------------------------------------------------");
        } catch (IOException e) {
            System.out.println("ERROR: The following error has occured:" + e);

        }
    }
}
