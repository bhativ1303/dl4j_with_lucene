package com.vikram.experimental.main.billboard;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vikram Singh
 * Date: 9/20/2018
 */
public class BillBoardAnalyzer {

    Analyzer makeIndexTimeAnalyzer() {
        Map<String, Analyzer> perFieldAnalyzers = new HashMap<>();

        CharArraySet stopWords = new CharArraySet(Arrays.asList("a", "an", "the"), true);
        perFieldAnalyzers.put("pages", new StopAnalyzer(stopWords));
        perFieldAnalyzers.put("title", new WhitespaceAnalyzer());

        return new PerFieldAnalyzerWrapper(new StandardAnalyzer(), perFieldAnalyzers);
    }

    Analyzer makeSearchTimeAnalyzer() {
        Map<String, Analyzer> perFieldAnalyzers = new HashMap<>();

        CharArraySet stopWords = new CharArraySet(Arrays.asList("a", "an", "the"), true);
        perFieldAnalyzers.put("pages", new StopAnalyzer(stopWords));
        perFieldAnalyzers.put("title", new WhitespaceAnalyzer());

        return new PerFieldAnalyzerWrapper(new StandardAnalyzer(), perFieldAnalyzers);
    }
}
