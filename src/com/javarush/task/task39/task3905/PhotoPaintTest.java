package com.javarush.task.task39.task3905;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhotoPaintTest {

    @Test
    public void paintFill() {
        Color[][] image = {
                {Color.YELLOW, Color.YELLOW, Color.VIOLET, Color.VIOLET},
                {Color.YELLOW, Color.YELLOW, Color.VIOLET, Color.VIOLET},
                {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
                {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
        };
        PhotoPaint pp = new PhotoPaint();
        pp.paintFill(image, 0, 0, Color.INDIGO);
        Color[][] expected = {
                {Color.INDIGO, Color.INDIGO, Color.VIOLET, Color.VIOLET},
                {Color.INDIGO, Color.INDIGO, Color.VIOLET, Color.VIOLET},
                {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
                {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
        };
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                assertEquals(expected[i][j], image[i][j]);
            }
        }
    }
}