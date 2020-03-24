package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }


    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }


    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertTrue(0 <= p1.x);
        assertTrue(0 <= p1.y);
        assertTrue(0 <= p2.x);
        assertTrue(0 <= p2.y);
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 10, -3);
        Point p1 = testPoints.getPoint(0);
        testPoints.copy(0, 1);
        Point p2 = testPoints.getPoint(1);
        assertEquals(10, p2.x);
        assertEquals(-3, p2.y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        double distance = testPoints.distance();
        int xDiff = p2.x - p1.x;
        int yDiff = p2.y - p1.y;
        double distanceEx = Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
        assertEquals(distanceEx, distance, 0.1);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        double slope = testPoints.slope();
        int xDiff = p2.x - p1.x;
        int yDiff = p2.y - p1.y;
        double slopeEx = yDiff / xDiff;
        assertEquals(slopeEx, slope, 0.1);
    }
}