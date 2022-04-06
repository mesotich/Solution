package com.javarush.task.task39.task3905;

import org.junit.Assert;
import org.junit.Test;

public class PhotoPaintTest {

    Color[][] image = {
            {Color.YELLOW, Color.YELLOW, Color.VIOLET, Color.VIOLET},
            {Color.YELLOW, Color.YELLOW, Color.VIOLET, Color.VIOLET},
            {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
            {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
    };

    @Test
    public void paintFill() {
        PhotoPaint pp = new PhotoPaint();
        pp.paintFill(image, 0, 0, Color.INDIGO);
        Color[][] actual = pp.getImage();
        Color[][] expected = {
                {Color.INDIGO, Color.INDIGO, Color.VIOLET, Color.VIOLET},
                {Color.INDIGO, Color.INDIGO, Color.VIOLET, Color.VIOLET},
                {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
                {Color.VIOLET, Color.VIOLET, Color.YELLOW, Color.YELLOW},
        };
        Assert.assertEquals(actual.length, expected.length);
        Assert.assertEquals(actual[0].length, expected[0].length);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[0].length; j++) {
                Assert.assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}