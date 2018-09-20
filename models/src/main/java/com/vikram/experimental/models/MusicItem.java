package com.vikram.experimental.models;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Vikram Singh
 * Date: 8/12/2018
 */
@Data
@RequiredArgsConstructor
public class MusicItem {

    @CsvBindByName(column = "Rank")
    private long rank;

    @CsvBindByName(column = "Song")
    private String song;

    @CsvBindByName(column = "Artist")
    private String artist;

    @CsvBindByName(column = "Year")
    private int year;

    @CsvBindByName(column = "Lyrics")
    private String lyrics;

    @CsvBindByName(column = "Source")
    private String source;
}
