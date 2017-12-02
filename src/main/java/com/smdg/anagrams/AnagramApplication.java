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
