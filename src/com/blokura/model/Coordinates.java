package com.blokura.model;

/**
 * Created by imanol on 19/02/2017.
 */
public class Coordinates {

    private int x;
    private int y;

    private Heading heading;

    public Coordinates(final int x, final int y, Heading heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + heading.name();
    }
}
