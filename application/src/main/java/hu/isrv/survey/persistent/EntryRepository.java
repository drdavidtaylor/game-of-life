package hu.isrv.survey.persistent;

import hu.isrv.survey.core.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
//@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {

    List<Entry> findByNumberOfElements(int numberOfElements);
}
