package com.smdg.anagrams.service;

import com.smdg.anagrams.AnagramResults;
import java.util.List;

/**
 *
 * @author haran
 */
public interface AnagramsMatcher {

    public void matchAnagram(List<String> wordsList, AnagramResults anagramResults);

}
