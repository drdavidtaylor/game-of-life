package hu.isrv.survey.service.impl;

import hu.isrv.survey.core.Entry;
import hu.isrv.survey.service.api.EntryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Service
public class EntryServiceImpl implements EntryService {

    @Override
    public void saveEntry(int elementsNumber, long nanoTime) {

    }

    @Override
    public List<Entry> findAll() {
        return null;
    }

    @Override
    public List<Entry> findByElementsNumber(int elementsNumber) {
        return null;
    }
}
