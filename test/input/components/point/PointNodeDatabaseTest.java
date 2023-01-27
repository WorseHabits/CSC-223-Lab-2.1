package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PointNodeDatabaseTest {

    @Test
    void testPointNodeDatabase() {
        PointNodeDatabase _database = new PointNodeDatabase();
        assertNotNull(_database);
        //verifying the database to be initialized
        assertTrue(_database._points.isEmpty());
        //making sure the points are initialized as empty
    }

    @Test
    void testPointNodeDatabase2() {
        PointNode point1 = new PointNode("A", 1, 2);
        PointNode point2 = new PointNode("B", 3, 4);
        List<PointNode> points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        //creating a base set of points to work with throughout the tests

        PointNodeDatabase _database = new PointNodeDatabase(points);
        assertNotNull(_database);
        assertEquals(points.size(), _database._points.size());
        //ensuring that the points variable is the same size for both points and _points
        assertTrue(_database._points.containsAll(points));
        //further assurance with checking that they are the same list of points
    }

    @Test
    void testPut() {
        PointNodeDatabase _database = new PointNodeDatabase();
        PointNode point1 = new PointNode("A", 1, 2);
        _database.put(point1);
        assertTrue(_database._points.contains(point1));
        //making sure that put() successfully adds a point
    }

    @Test
    void testContainsPointNode() {
        PointNode point1 = new PointNode("A", 1, 2);
        PointNode point2 = new PointNode("B", 3, 4);
        List<PointNode> points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        PointNodeDatabase _database = new PointNodeDatabase(points);
        assertTrue(_database.contains(point1));
        //ensuring that the database will return true if the point is inside of it
        assertFalse(_database.contains(new PointNode("C", 5, 6)));
        //ensuring that the database will return false if the point is not inside of it
    }

    @Test
    void testContainsXY() {
        PointNode point1 = new PointNode("A", 1, 2);
        PointNode point2 = new PointNode("B", 3, 4);
        List<PointNode> points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        PointNodeDatabase _database = new PointNodeDatabase(points);
        assertTrue(_database.contains(1, 2));
        //ensuring the database will return true if the point exists with those parameters
        assertFalse(_database.contains(5, 6));
        //ensuring the database will return false if the point does not exist with those parameters
      }
    @Test
    void testGetPointNode() {
        PointNode point1 = new PointNode("A", 1, 2);
        PointNode point2 = new PointNode("B", 3, 4);
        List<PointNode> points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        PointNodeDatabase _database = new PointNodeDatabase(points);
        assertEquals(point1, _database.getPoint(1, 2));
        //ensuring that the correct point is returned when searching by x and y coordinates
        assertNull(_database.getPoint(5, 6));
        //ensuring that a null value is returned if the point does not exist in the database
    }
    @Test
    void testGetNamePointNode() {
        PointNode point1 = new PointNode("A", 1, 2);
        PointNode point2 = new PointNode("B", 3, 4);
        List<PointNode> points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        PointNodeDatabase _database = new PointNodeDatabase(points);
        assertEquals("A", _database.getName(point1));
        //verifying that the correct name is returned
        assertNotEquals("B", _database.getName(point1));
        //verifying that the incorrect name is not returned
    }

    @Test
    void testGetNameXY() {
        PointNode point1 = new PointNode("A", 1, 2);
        PointNode point2 = new PointNode("B", 3, 4);
        List<PointNode> points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        PointNodeDatabase _database = new PointNodeDatabase(points);
        assertEquals("A", _database.getName(1, 2));
        //verifying that the correct name is returned
        assertNotEquals("B", _database.getName(1, 2));
        //verifying that the incorrect name is not returned
    }

    @Test
    void testGetPointXY() {
        PointNode point1 = new PointNode("A", 1, 2);
        PointNode point2 = new PointNode("B", 3, 4);
        List<PointNode> points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        PointNodeDatabase _database = new PointNodeDatabase(points);
        assertEquals(point1, _database.getPoint(1, 2));
        //verifying that the correct point is returned
        assertNotEquals(point2, _database.getPoint(1, 2));
        //verifying that the incorrect point is not returned
    }
}

