/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smdg.anagrams.service;

import com.smdg.anagrams.AnagramResults;
import com.smdg.anagrams.OutputDisplay;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haran
 */
public interface AnagramsMatcher {
    
    
    
    public void matchAnagram(List<String> wordsList,AnagramResults anagramResults,OutputDisplay outputDisplay);
    
}
