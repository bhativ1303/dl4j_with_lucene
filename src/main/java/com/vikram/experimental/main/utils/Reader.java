package com.vikram.experimental.main.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import lombok.experimental.UtilityClass;

/**
 * @author Vikram Singh
 * Date: 8/12/2018
 */
@UtilityClass
public class Reader {

    public <T> List<T> readCsvToBean(String location, Class<T> returnType) throws FileNotFoundException {
        FileReader fileReader = new FileReader(location);
        CsvToBean csvToBean = new CsvToBeanBuilder(fileReader).withThrowExceptions(false)
                                                              .withType(returnType)
                                                              .build();
        return csvToBean.parse();
    }
}
