package hu.isrv.survey.controller.impl.rest;

import hu.isrv.survey.controller.api.rest.GolController;
import hu.isrv.survey.service.api.EntryService;
import hu.isrv.survey.service.api.GolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@RestController
@RequestMapping("/api/game")
public class GolControllerImpl implements GolController {

    private final static Logger log = LoggerFactory.getLogger(GolControllerImpl.class);

    @Autowired
    private GolService golService;

    @Autowired
    private EntryService entryService;



}
