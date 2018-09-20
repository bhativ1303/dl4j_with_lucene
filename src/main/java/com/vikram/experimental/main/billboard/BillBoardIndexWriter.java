package com.vikram.experimental.main.billboard;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vikram Singh
 * Date: 8/12/2018
 */
class BillBoardIndexWriter {

    private final IndexWriter writer;

    BillBoardIndexWriter(Analyzer analyzer) throws IOException {
        FSDirectory dir = FSDirectory.open(Paths.get(Constants.INDEX_DIR));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        this.writer = new IndexWriter(dir, config);
    }

    void write(List<MusicItem> items) throws IOException {
        writer.deleteAll();

        List<Document> documents = items.stream()
                                        .map(this::createDocument)
                                        .collect(Collectors.toList());
        writer.addDocuments(documents);
        writer.commit();
        writer.close();
    }

    private Document createDocument(MusicItem item) {
        Document document = new Document();
        document.add(new StringField("rank", String.valueOf(item.getRank()), Field.Store.YES));
        document.add(new TextField("artist", item.getArtist(), Field.Store.YES));
        document.add(new TextField("song", item.getSong(), Field.Store.YES));
        document.add(new StringField("year", String.valueOf(item.getYear()), Field.Store.YES));
        document.add(new TextField("source", item.getSource(), Field.Store.YES));
        document.add(new TextField("lyrics", item.getLyrics(), Field.Store.YES));
        return document;
    }
}
