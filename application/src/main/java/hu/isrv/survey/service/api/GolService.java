package hu.isrv.survey.service.api;

import hu.isrv.survey.processor.impl.Structure;
import org.springframework.stereotype.Service;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
public interface GolService {

    Structure computeSequentStructure(Structure structure);

}
