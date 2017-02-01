package hu.isrv.survey.controller.impl.rest;

import hu.isrv.survey.controller.api.rest.GolController;
import hu.isrv.survey.core.Entry;
import hu.isrv.survey.processor.impl.Structure;
import hu.isrv.survey.service.api.EntryService;
import hu.isrv.survey.service.api.GolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@RestController
@RequestMapping("/api/game")
public class GolControllerImpl implements GolController {

//    private final static Logger log = LoggerFactory.getLogger(GolControllerImpl.class);

    @Autowired
    private GolService golService;

    @Autowired
    private EntryService entryService;

    @Override
    @RequestMapping(value = "/compute", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Structure calculate(@RequestBody Structure structure) {
        List<Entry> entryList = entryService.findAll();
//        log.info("NUMBER OF ENTRIES: " + entryList.size());

        long startTime = System.nanoTime();
        Structure calculatedStructure = golService.computeSequentStructure(structure);
        long duration = System.nanoTime() - startTime;
        entryService.saveEntry(calculatedStructure.getItems().size(), duration);

        return calculatedStructure;
    }
}
