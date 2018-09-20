package com.vikram.experimental.main.billboard;

import com.vikram.experimental.lucene.indexer.BillBoardIndexWriterImpl;
import com.vikram.experimental.main.reader.CsvReaderImpl;
import com.vikram.experimental.models.MusicItem;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Vikram Singh
 * Date: 8/14/2018
 */
@Slf4j
public class BillBoardApplication {

    private static String FILE_PATH = "/files/billboard_lyrics_1964-2015.csv";
    private static final String INDEX_DIR = "sdf";

    public static void main(String[] args) {
        CsvReaderImpl reader = new CsvReaderImpl();
        try {
            List<MusicItem> items = reader.read(FILE_PATH, MusicItem.class);
            BillBoardIndexWriterImpl indexWriter = new BillBoardIndexWriterImpl(INDEX_DIR);
            indexWriter.write(items);

        } catch (Exception e) {
            LOGGER.error("Error while reading the file : {}", e.getMessage());
        }
    }
}
