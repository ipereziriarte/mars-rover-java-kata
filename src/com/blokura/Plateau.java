package com.blokura;

/**
 * Created by imanol on 15/02/2017.
 */
public class Plateau {

    private static final int ORIGIN_X = 0;
    private static final int ORIGIN_Y = 0;

    private final int height;
    private final int width;

    public Plateau(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public boolean includes(int x, int y) {
        return isXInside(x) && isYInside(y);
    }

    private boolean isXInside(final int x) {
        return ORIGIN_X <= x && x < width;
    }

    private boolean isYInside(final int y) {
        return ORIGIN_Y <= y && y < height;
    }

    public static class PlateauBuilder {

        private int height = 0;
        private int width = 0;

        public PlateauBuilder withHeight(final int height) {
            this.height = height;
            return this;
        }

        public PlateauBuilder withWidth(final int width) {
            this.width = width;
            return this;
        }

        public Plateau build(){
            return new Plateau(height, width);
        }

    }
}
