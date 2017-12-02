/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smdg.anagrams;

import com.smdg.anagrams.controller.AnagramController;
import java.io.IOException;

/**
 *
 * @author haran
 */
public class AnagramApplication {
    
    public static void main(String[] args) throws IOException {
        
        AnagramController anagramController = new AnagramController();
        anagramController.run();
        
        
    }
}
