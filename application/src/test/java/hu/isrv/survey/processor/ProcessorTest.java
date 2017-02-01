package hu.isrv.survey.processor;

import hu.isrv.survey.processor.impl.GameProcessor;
import hu.isrv.survey.processor.impl.Item;
import hu.isrv.survey.processor.impl.Structure;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
public class ProcessorTest {
    
    @Test
    public void checkDotsTree() {

        GameProcessor gameProcessor = new GameProcessor();

        List<Item> startItems = new ArrayList<Item>();
        startItems.add(new Item(8, 9));
        startItems.add(new Item(9, 9));
        startItems.add(new Item(10, 9));

        Structure startStructure = generateStruct(20, startItems);

        List<Item> expectedItems = new ArrayList<Item>();
        expectedItems.add(new Item(9, 8));
        expectedItems.add(new Item(9, 9));
        expectedItems.add(new Item(9, 10));
        Structure expectedStructure = generateStruct(20, expectedItems);


        // első iter
        Structure actualStructure = gameProcessor.execute(startStructure);
        assertTrue(expectedStructure.equals(actualStructure));

        // második iter
        Structure actualStructure2 = gameProcessor.execute(actualStructure);
        assertTrue(startStructure.equals(actualStructure2));

    }

    private Structure generateStruct(int edgeLength, List<Item> items) {

        Structure structure = new Structure();
        structure.setEdgeLength(edgeLength);
        structure.setItems(items);

        return structure;
    }
}