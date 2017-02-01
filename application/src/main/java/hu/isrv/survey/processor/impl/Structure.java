package hu.isrv.survey.processor.impl;

import java.util.List;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
public class Structure {

    private int edgeLength;
    private List<Item> items;

    public int getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(int edgeLength) {
        this.edgeLength = edgeLength;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Structure))
            return false;
        if (obj == this)
            return true;
        Structure structure = (Structure) obj;

        return this.edgeLength == structure.getEdgeLength() && this.items.containsAll(structure.getItems());
    }

}