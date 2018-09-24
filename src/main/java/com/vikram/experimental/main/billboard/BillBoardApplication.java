package com.vikram.experimental.main.billboard;

import com.vikram.experimental.main.billboard.luc.BillBoardAnalyzerFactory;
import com.vikram.experimental.main.billboard.luc.BillBoardIndexWriter;
import com.vikram.experimental.main.billboard.luc.Constants;
import com.vikram.experimental.main.billboard.luc.MusicItem;
import com.vikram.experimental.main.utils.Reader;

import java.io.IOException;
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
            getIndexWriter().write(getItems());
        } catch (Exception e) {
            LOGGER.error("Error while reading the file : {}", e.getMessage());
        }
    }

    private static BillBoardIndexWriter getIndexWriter() throws IOException {
        return new BillBoardIndexWriter(
                        BillBoardAnalyzerFactory.makeIndexTimeAnalyzer()
        );
    }

    private static List<MusicItem> getItems() throws java.io.FileNotFoundException {
        return Reader.readCsvToBean(
                        Constants.FILE_PATH,
                        MusicItem.class
        );
    }
}
