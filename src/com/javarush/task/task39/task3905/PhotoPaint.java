package com.javarush.task.task39.task3905;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PhotoPaint {

    private Color[][] image;

    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (image == null)
            return false;
        Color color;
        try {
            color = image[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        if (color.equals(desiredColor))
            return false;
        Coordinate coordinate = new Coordinate(x, y);
        for (Coordinate crd : getChangeCoordinates(coordinate, image, color)
        ) {
            setColor(crd, image, desiredColor);
        }
        this.image = image;
        return true;
    }

    public Color[][] getImage() {
        return image;
    }

    private Set<Coordinate> getChangeCoordinates(Coordinate coordinate, Color[][] image, Color color) {
        Set<Coordinate> current = getNeighbours(coordinate, image, color);
        Set<Coordinate> result = new HashSet<>(current);
        Set<Coordinate> next = new HashSet<>();
        while (true) {
            for (Coordinate crd : current
            ) {
                next.addAll(getNeighbours(crd, image, color));
            }
            if (result.containsAll(next))
                return result;
            result.addAll(next);
            current.clear();
            current.addAll(next);
            next.clear();
        }
    }

    private Set<Coordinate> getNeighbours(Coordinate coordinate, Color[][] image, Color color) {
        Set<Coordinate> result = new HashSet<>();
        Set<Coordinate> neighbours = new HashSet<>();
        neighbours.add(new Coordinate(coordinate.x, coordinate.y - 1));
        neighbours.add(new Coordinate(coordinate.x, coordinate.y + 1));
        neighbours.add(new Coordinate(coordinate.x - 1, coordinate.y));
        neighbours.add(new Coordinate(coordinate.x + 1, coordinate.y));
        for (Coordinate crd : neighbours
        ) {
            if (checkBorder(crd, image) && getColor(crd, image).equals(color))
                result.add(crd);
        }
        return result;
    }

    private boolean checkBorder(Coordinate coordinate, Color[][] image) {
        int x = coordinate.x;
        int y = coordinate.y;
        return x >= 0 && y >= 0 && x < image[0].length && y < image.length;
    }

    private Color getColor(Coordinate coordinate, Color[][] image) {
        int x = coordinate.x;
        int y = coordinate.y;
        return image[y][x];
    }

    private void setColor(Coordinate coordinate, Color[][] image, Color desiredColor) {
        int x = coordinate.x;
        int y = coordinate.y;
        image[y][x] = desiredColor;
    }

    private static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}