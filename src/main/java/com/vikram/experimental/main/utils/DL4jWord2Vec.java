package com.vikram.experimental.main.utils;

import com.vikram.experimental.main.billboard.luc.Constants;

import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;

import java.io.IOException;
import java.util.Collection;

import lombok.experimental.UtilityClass;

/**
 * @author Vikram Singh
 * Date: 9/20/2018
 */
@UtilityClass
public class DL4jWord2Vec {

    void a() throws IOException {
        SentenceIterator iter = new BasicLineIterator(Constants.FILE_PATH);

        Word2Vec vec = new Word2Vec.Builder()
                        .layerSize(100)
                        .windowSize(5)
                        .iterate(iter)
                        .build();

        vec.fit();

        String[] words = new String[] { "guitar", "love", "rock" };
        for (String w : words) {
            Collection lst = vec.wordsNearest(w, 2);
            System.out.println("2 Words closest to '" + w + "': " + lst);
        }
    }
}
