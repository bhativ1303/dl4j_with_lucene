package com.vikram.experimental.main.reader;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Vikram Singh
 * Date: 8/12/2018
 */
public interface CsvReader {

    <T> List<T> read(String location, Class<T> returnType) throws FileNotFoundException;

}
