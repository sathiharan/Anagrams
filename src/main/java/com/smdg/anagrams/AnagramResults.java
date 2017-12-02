/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smdg.anagrams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haran
 */
public class AnagramResults {
    
    
    
    List<List<String>> results =  new ArrayList<>();

    public List<List<String>> getResults() {
        return results;
    }

    public void setResults(List<List<String>> results) {
        this.results = results;
    }
    
   
    public void uppend(List<String> result){
        results.add(result);
    }
    
    
}
