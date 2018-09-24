package com.vikram.experimental.main.billboard.luc;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Vikram Singh
 * Date: 9/20/2018
 */
class BillBoardIndexReader {

    private final IndexReader reader;

    BillBoardIndexReader() throws IOException {
        Path path = Paths.get(Constants.INDEX_DIR);
        Directory directory = FSDirectory.open(path);
        reader = DirectoryReader.open(directory);
    }

    Document getDoc(int docId) throws IOException {
        return reader.document(docId);
    }

    Query makeQuery() throws ParseException {
        QueryParser parser = new QueryParser("title", new WhitespaceAnalyzer());
        return parser.parse("+Deep +search");
    }


}
