package hu.isrv.survey.service.impl;

import hu.isrv.survey.processor.impl.GameProcessor;
import hu.isrv.survey.processor.impl.Structure;
import hu.isrv.survey.service.api.GolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Service
public class GolServiceImpl implements GolService {

    @Autowired
    GameProcessor gameProcessor;

    @Override
    public Structure computeSequentStructure(Structure structure) {
        return gameProcessor.execute(structure);
    }
}
