package com.vikram.experimental.lucene.indexer;

import com.vikram.experimental.models.MusicItem;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
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

import lombok.RequiredArgsConstructor;

/**
 * @author Vikram Singh
 * Date: 8/12/2018
 */
@RequiredArgsConstructor
public class BillBoardIndexWriterImpl implements BillBoardIndexWriter {

    private final String indexDirectory;

    @Override
    public void write(List<MusicItem> items) throws IOException {
        IndexWriter writer = createWriter();
        //Let's clean everything first
        writer.deleteAll();

        List<Document> documents = items.stream()
                                        .map(this::createDocument)
                                        .collect(Collectors.toList());
        writer.addDocuments(documents);
        writer.commit();
        writer.close();
    }

    private IndexWriter createWriter() throws IOException {
        FSDirectory dir = FSDirectory.open(Paths.get(indexDirectory));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        return new IndexWriter(dir, config);
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
