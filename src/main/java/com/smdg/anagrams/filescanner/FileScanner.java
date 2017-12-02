
package com.smdg.anagrams.filescanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author haran
 */
public class FileScanner {

    Stream<String> wordsStream;
            
    public FileScanner() {

    }
    
    // READING THE CONTENT OF THE FILE AND RETURN AS WORD STREAM
    public Stream<String> scaneFile(String fileLocation) throws FileNotFoundException, IOException{        
                wordsStream = Files.lines(Paths.get(fileLocation));                                                     
        return wordsStream;
    }
}
