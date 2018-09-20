package com.vikram.experimental.main.reader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @author Vikram Singh
 * Date: 8/12/2018
 */
public class CsvReaderImpl implements CsvReader {

    @Override
    public <T> List<T> read(String location, Class<T> returnType) throws FileNotFoundException {
        FileReader fileReader = new FileReader(location);
        CsvToBean csvToBean = new CsvToBeanBuilder(fileReader).withThrowExceptions(false)
                                                              .withType(returnType)
                                                              .build();
        return csvToBean.parse();
    }
}
