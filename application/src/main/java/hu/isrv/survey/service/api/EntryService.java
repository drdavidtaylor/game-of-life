package hu.isrv.survey.service.api;

import hu.isrv.survey.core.Entry;

import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
public interface EntryService {

    void saveEntry(int elementsNumber, long nanoTime);

    List<Entry> findAll();

    List<Entry> findByElementsNumber(int elementsNumber);

}
