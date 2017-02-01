package hu.isrv.survey.controller.impl;

import hu.isrv.survey.controller.api.GolController;
import hu.isrv.survey.service.api.GolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@RestController
@RequestMapping("/api/samples")
public class GolControllerImpl implements GolController {

    @Autowired
    private GolService golService;



}
