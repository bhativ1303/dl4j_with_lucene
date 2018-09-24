package com.vikram.experimental.main.billboard.luc;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;

/**
 * @author Vikram Singh
 * Date: 9/20/2018
 */
public class BillBoardSearcher {

    private final IndexSearcher searcher;
    private final IndexReader reader;

    public BillBoardSearcher(IndexReader reader) {
        this.reader = reader;
        this.searcher = new IndexSearcher(reader);
    }

    void search(Query query) throws IOException {
        TopDocs hits = searcher.search(query, 10);
        for (int i = 0; i < hits.scoreDocs.length; i++) {
            ScoreDoc scoreDoc = hits.scoreDocs[i];
            Document doc = reader.document(scoreDoc.doc);
            System.out.println(doc.get("title") + " : " + scoreDoc.score);
        }
    }
}
