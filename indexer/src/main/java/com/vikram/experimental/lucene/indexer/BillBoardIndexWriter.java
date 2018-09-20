package com.vikram.experimental.lucene.indexer;

import com.vikram.experimental.models.MusicItem;

import java.io.IOException;
import java.util.List;

/**
 * @author Vikram Singh
 * Date: 8/12/2018
 */
public interface BillBoardIndexWriter {

    void write(List<MusicItem> items) throws IOException;
}
