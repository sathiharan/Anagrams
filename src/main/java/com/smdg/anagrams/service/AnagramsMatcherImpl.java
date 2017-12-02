
package com.smdg.anagrams.service;

import com.smdg.anagrams.AnagramResults;
import com.smdg.anagrams.OutputDisplay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author haran
 */
public class AnagramsMatcherImpl implements AnagramsMatcher{
    
    List<String> duplicateList = new ArrayList<>();
    
    @Override
    public void matchAnagram(List<String> wordsList,AnagramResults anagramResults) throws NullPointerException{
        duplicateList.addAll(wordsList);
        
        Iterator<String> wordsListIterator = wordsList.iterator();
        
        while(wordsListIterator.hasNext()){
//            outputDisplay.print("Itr1:" + itr1.next());
            Iterator<String> duplicateListIterator = duplicateList.iterator();
            ArrayList<String> anagramsWordsList = new ArrayList<>();
            String anagramWord = wordsListIterator.next();
            while (duplicateListIterator.hasNext()) {
                String anagramDuplicateWord = duplicateListIterator.next();
                //outputDisplay.print("Itr1:" + anaWord + "----" +"Itr2:" + anaCpyWord); 
                String anagramsWord = findingAnagram(anagramWord, anagramDuplicateWord);
                    if (!anagramsWord.isEmpty() && anagramsWord != null) {
                        anagramsWordsList.add(anagramsWord);
                    }
            }
            if (anagramsWordsList.size() > 1) {
                    duplicateList.removeAll(anagramsWordsList);
                    Collections.sort(anagramsWordsList);
                    anagramResults.uppend(anagramsWordsList);
                }
        }
          
    }
    
    private String findingAnagram(String iString, String jString) {
        if (iString.length() != jString.length()) {
            return "";
        } else {
            char[] iStringArray = iString.toLowerCase().toCharArray();
            char[] jStringArray = jString.toLowerCase().toCharArray();
            Arrays.sort(iStringArray);
            Arrays.sort(jStringArray);
            if (Arrays.equals(iStringArray, jStringArray)) {
                return jString;
            }
        }
        return "";
    }
}
