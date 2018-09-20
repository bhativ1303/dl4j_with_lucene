package com.vikram.experimental.main.billboard;

import com.vikram.experimental.main.utils.Reader;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Vikram Singh
 * Date: 8/14/2018
 */
@Slf4j
public class BillBoardApplication {


    public static void main(String[] args) {
        try {
            List<MusicItem> items = Reader.readCsvToBean(Constants.FILE_PATH, MusicItem.class);
            BillBoardIndexWriter indexWriter = new BillBoardIndexWriter(Constants.INDEX_DIR);
            indexWriter.write(items);

        } catch (Exception e) {
            LOGGER.error("Error while reading the file : {}", e.getMessage());
        }
    }
}
