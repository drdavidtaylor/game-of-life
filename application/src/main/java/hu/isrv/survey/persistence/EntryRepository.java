package hu.isrv.survey.persistence;

import hu.isrv.survey.core.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
public interface EntryRepository extends CrudRepository<Entry, Long> {

    List<Entry> findByNumberOfElements(int numberOfElements);
}
