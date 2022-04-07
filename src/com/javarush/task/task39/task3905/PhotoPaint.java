package com.javarush.task.task39.task3905;

public class PhotoPaint {

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
        final Color replaceColor = ReplaceColor.getInstance(color);
        if (color.equals(replaceColor)) {
            image[y][x] = desiredColor;
            paintFill(image, x - 1, y, desiredColor);
            paintFill(image, x + 1, y, desiredColor);
            paintFill(image, x, y - 1, desiredColor);
            paintFill(image, x, y + 1, desiredColor);
        }
        return true;
    }

    private static class ReplaceColor {

        private static Color instance;

        public static Color getInstance(Color color) {
            if (instance == null) {
                instance = color;
            }
            return instance;
        }

        private ReplaceColor() {
        }
    }
}