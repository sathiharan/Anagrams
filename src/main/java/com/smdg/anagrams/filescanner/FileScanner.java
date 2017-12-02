/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smdg.anagrams.filescanner;

import com.smdg.anagrams.service.AnagramsMatcherImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author haran
 */
public class FileScanner {
    
    String line;
//    ArrayList<String> wordsList = new ArrayList<>();
    Stream<String> wordsList;
    Stream<String> wordsStream;
    Stream<String> cpyStream;
            
    public FileScanner() {

    }
    
    // READING THE CONTENT OF THE FILE AND RETURN AS WORD STREAM
    public Stream<String> scaneFile(String fileLocation) throws FileNotFoundException, IOException{
        
                wordsStream = Files.lines(Paths.get(fileLocation));                                        
              
        return wordsStream;
    }
    
    public void streamnPro(){
        
        List<String> unavailable = wordsStream.filter(e -> (cpyStream
                        .filter(d -> d.equals(e))
                        .count())<1)
                        .collect(Collectors.toList());
//                        AnagramsMatcherImpl.matchAnagram((List<String>) wordsStream);

        System.out.println("The Out of stream is:" + unavailable);
        
    }
}
