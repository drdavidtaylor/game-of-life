package hu.isrv.survey.service.impl;

import hu.isrv.survey.core.Entry;
import hu.isrv.survey.persistent.EntryRepository;
import hu.isrv.survey.service.api.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntryRepository entryRepository;

    @Override
    public void saveEntry(int numberOfElements, long nanoTime) {
        entryRepository.save(new Entry(numberOfElements, nanoTime));
    }

    @Override
    public List<Entry> findAll() {
        return (List<Entry>) entryRepository.findAll();
    }

    @Override
    public List<Entry> findByNumberOfElements(int numberOfElements) {
        return entryRepository.findByNumberOfElements(numberOfElements);
    }
}
