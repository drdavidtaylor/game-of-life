package hu.isrv.survey.processor.impl;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
public class Item {

    private int x;
    private int y;

	public Item() {

    }

	public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item))
            return false;
        if (obj == this)
            return true;
        Item item = (Item) obj;

        return this.x == item.getX() && this.y == item.getY();
    }
}