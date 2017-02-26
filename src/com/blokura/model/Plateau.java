package com.blokura.model;

/**
 * Created by imanol on 15/02/2017.
 */
public class Plateau {

    private static final int ORIGIN_X = 0;
    private static final int ORIGIN_Y = 0;

    private final int width;
    private final int height;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean includes(int x, int y) {
        return isXInside(x) && isYInside(y);
    }

    private boolean isXInside(final int x) {
        return ORIGIN_X <= x && x <= width;
    }

    private boolean isYInside(final int y) {
        return ORIGIN_Y <= y && y <= height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Plateau plateau = (Plateau) o;

        if (width != plateau.width) {
            return false;
        }
        return height == plateau.height;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        return result;
    }

    public static class PlateauBuilder {

        private int height = 1;
        private int width = 1;

        public PlateauBuilder withHeight(final int height) {
            if (height < 1) {
                throw new IllegalArgumentException("Min height must be 1");
            }
            this.height = height;
            return this;
        }

        public PlateauBuilder withWidth(final int width) {
            if (width < 1) {
                throw new IllegalArgumentException("Min width must be 1");
            }
            this.width = width;
            return this;
        }

        public Plateau build(){
            return new Plateau(width, height);
        }

    }
}
