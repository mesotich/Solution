package com.javarush.task.task39.task3905;

public class PhotoPaint {

    private Color replaceColor;

    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (image == null || !checkBorder(image, x, y))
            return false;
        Color color = image[y][x];
        if (color.equals(desiredColor))
            return false;
        if (replaceColor == null)
            replaceColor = color;
        if (color.equals(replaceColor)) {
            image[y][x] = desiredColor;
            paintFill(image, x - 1, y, desiredColor);
            paintFill(image, x + 1, y, desiredColor);
            paintFill(image, x, y - 1, desiredColor);
            paintFill(image, x, y + 1, desiredColor);
        }
        return true;
    }

    private boolean checkBorder(Color[][] image, int x, int y) {
        return x >= 0 && y >= 0 && x < image[0].length && y < image.length;
    }
}