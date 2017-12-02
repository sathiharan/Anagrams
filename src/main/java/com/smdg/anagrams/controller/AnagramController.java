/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smdg.anagrams.controller;

import com.smdg.anagrams.AnagramResults;
import com.smdg.anagrams.OutputDisplay;
import com.smdg.anagrams.service.AnagramsMatcherImpl;
import com.smdg.anagrams.filescanner.FileScanner;
import com.smdg.anagrams.service.AnagramsMatcher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author haran
 */
public class AnagramController {
    
      String line;
        List<String> wordsList = new ArrayList<>();
        List<String> cpyWordsList = new ArrayList<>();
        List<String> anagramsWordsList;
        
        
        public void run(){
            
            OutputDisplay outputDisplay = new OutputDisplay();
            AnagramResults anagramResults = new AnagramResults();
            
            
            try {
                
            // READING THE FILE FROM THE LOCATION
            Scanner input = new Scanner(System.in);
            System.out.println("Specify location of the sample.txt file");
            System.out.println("Enter the location:");
            String fileLocation = input.nextLine();
            
            FileScanner fileScanner = new FileScanner();
            wordsList = fileScanner.scaneFile(fileLocation).collect(Collectors.toList());
            System.out.println("wordList:" + wordsList);
            
            
        //    FileReader file = new FileReader(fileLocation);
        //    BufferedReader br = new BufferedReader(file);

            // READING THE CONTENT OF THE FILE AND INSERTING THE WORDS INTO LIST
        //    while ((line = br.readLine()) != null) {
        //        line.split(" ");
        //        wordsList.add(line);
        //    }
        
                //AnagramsMatcherImpl anagramsMatcher = new AnagramsMatcherImpl();
                //anagramsMatcher.matchAnagram(wordsList,anagramResults,outputDisplay);
                
                AnagramsMatcher anagramsMatcher = new AnagramsMatcherImpl();
                anagramsMatcher.matchAnagram(wordsList,anagramResults,outputDisplay);
                outputDisplay.print("------------------------------------- start -------------------------------------------------");
                for (List<String> angrmResults : anagramResults.getResults()) {                   
                    outputDisplay.print("The output is : " + angrmResults);                    
                }
                outputDisplay.print("------------------------------------- End -------------------------------------------------");
              

                

        } catch (IOException e) {
            System.out.println("ERROR: The Location or filename you have enter is wrong \n" + e);

        }
    }
}
    

