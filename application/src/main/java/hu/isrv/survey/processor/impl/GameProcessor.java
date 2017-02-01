package hu.isrv.survey.processor.impl;

import hu.isrv.survey.processor.api.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Component
public class GameProcessor implements Processor<Structure> {
    private final static Logger log = LoggerFactory.getLogger(GameProcessor.class);

    @Override
    public Structure execute(Structure structure) {
        Structure calculatedStructure = updateItemsAndNeighbors(structure);
        return calculatedStructure;
    }

    private void reviveItem(int x, int y, boolean[][] structureArray, boolean[][] revivedItems,
                                 List<Item> newItems) {
        int edgeLength = structureArray.length;
        if (x >= 0 && x < edgeLength && y >= 0 && y < edgeLength) {
            if (!revivedItems[x][y]) {
                if (3 == neighborsNumber(x, y, structureArray)) {
                    revivedItems[x][y] = true;
                    newItems.add(new Item(x, y));
                }
            }
        }
    }

    private int neighborsNumber(int x, int y, boolean[][] structureArray) {

        int edgeLength = structureArray.length;
        assert x >= 0 && x < edgeLength && y >= 0 && y < edgeLength;

        int neighborsNumber = 0;

        if (x > 0) {
            if (structureArray[x - 1][y]) {
                neighborsNumber++;
            }
            if (y > 0 && structureArray[x - 1][y - 1]) {
                neighborsNumber++;
            }
            if (y < edgeLength - 1 && structureArray[x - 1][y + 1]) {
                neighborsNumber++;
            }
        }
        if (y > 0) {
            if (structureArray[x][y - 1]) {
                neighborsNumber++;
            }
        }
        if (y < edgeLength - 1) {
            if (structureArray[x][y + 1]) {
                neighborsNumber++;
            }
        }
        if (x < edgeLength - 1) {
            if (structureArray[x + 1][y]) {
                neighborsNumber++;
            }
            if (y > 0 && structureArray[x + 1][y - 1]) {
                neighborsNumber++;
            }
            if (y < edgeLength - 1 && structureArray[x + 1][y + 1]) {
                neighborsNumber++;
            }
        }
        return neighborsNumber;
    }

    private void reviveNeighbors(Item item, boolean[][] structureArray, boolean[][] revivedItems,
                                 List<Item> newItems) {
        int x = item.getX();
        int y = item.getY();
        int edgeLength = structureArray.length;
        assert x >= 0 && x < edgeLength && y >= 0 && y < edgeLength;

        reviveItem(x - 1, y - 1, structureArray, revivedItems, newItems);
        reviveItem(x - 1, y, structureArray, revivedItems, newItems);
        reviveItem(x - 1, y + 1, structureArray, revivedItems, newItems);
        reviveItem(x, y - 1, structureArray, revivedItems, newItems);
        reviveItem(x, y + 1, structureArray, revivedItems, newItems);
        reviveItem(x + 1, y - 1, structureArray, revivedItems, newItems);
        reviveItem(x + 1, y, structureArray, revivedItems, newItems);
        reviveItem(x + 1, y + 1, structureArray, revivedItems, newItems);
    }


    private Structure updateItemsAndNeighbors(Structure structure) {
        List<Item> newItems = new ArrayList<>();

        int edgeLength = structure.getEdgeLength();
        boolean[][] structureArray = new boolean[edgeLength][edgeLength];
        boolean[][] revivedItems = new boolean[edgeLength][edgeLength];

        structure.getItems().forEach(e -> markItemOnArray(e.getX(), e.getY(), structureArray));

        structure.getItems().forEach(e -> {
            if (shouldSurvive(e, edgeLength, structureArray)) {
                newItems.add(e);
            }
            reviveNeighbors(e, structureArray, revivedItems, newItems);
        });

        Structure newStructure = new Structure();
        newStructure.setEdgeLength(edgeLength);
        newStructure.setItems(newItems);
        return newStructure;
    }

    private void markItemOnArray(int x, int y, boolean[][] structureArray) {
        try {
            structureArray[x][y] = true;
        } catch (IndexOutOfBoundsException exception) {
            log.error("Hibás elem a listában.", exception.getMessage());
        }
    }

    private boolean shouldSurvive(Item item, int edgeLength, boolean[][] structureArray) {
        int n = neighborsNumber(item.getX(), item.getY(), structureArray);
        if (2 == n || 3 == n) {
            return true;
        }
        return false;
    }

}
