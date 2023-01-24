package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PointNodeDatabaseTest {
	
	private PointNodeDatabase _database;
    private PointNode point1;
    private PointNode point2;
    private List<PointNode> points;

    @Before
    public void setUp() {
        point1 = new PointNode("A", 1, 2);
        point2 = new PointNode("B", 3, 4);
        points = new ArrayList<PointNode>();
        points.add(point1);
        points.add(point2);
        //creating a base set of points to work with throughout the tests
    }

	@Test
	void testPointNodeDatabase() {
		_database = new PointNodeDatabase();
        assertNotNull(_database);
        //verifying the database to be initialized
        assertTrue(_database._points.isEmpty());
        //making sure the points are initialized as empty
	}

	@Test
	void testPointNodeDatabase2() {
		_database = new PointNodeDatabase(points);
        assertNotNull(_database);
        assertEquals(points.size(), _database._points.size());
        //ensuring that the points variable is the same size for both points and _points
        assertTrue(_database._points.containsAll(points));
        //further assurance with checking that they are the same list of points
	}

	@Test
	void testPut() {
		_database = new PointNodeDatabase();
        _database.put(point1);
        assertTrue(_database._points.contains(point1));
        //making sure that put() successfully adds a point
	}

	@Test
	void testContainsPointNode() {
		_database = new PointNodeDatabase(points);
        assertTrue(_database.contains(point1));
        //ensuring that the database will return true if the point is inside of it
        assertFalse(_database.contains(new PointNode("C", 5, 6)));
        //ensuring that the database will return false if the point is not inside of it
	}

	@Test
	void testContainsXY() {
		 _database = new PointNodeDatabase(points);
	     assertTrue(_database.contains(1, 2));
	     //ensuring the database will return true if the point exists with those parameters
	     assertFalse(_database.contains(5, 6));
	     //ensuring the database will return false if the point does not exist with those parameters
	}

	@Test
	void testGetNamePointNode() {
		_database = new PointNodeDatabase(points);
        assertEquals("A", _database.getName(point1));
        //ensuring the database will accurately return the name of a given point
        assertNull(_database.getName(new PointNode("C", 5, 6)));
        //ensuring the database will not return a name if the point does not exist
        
	}

	@Test
	void testGetNameXY() {
		_database = new PointNodeDatabase(points);
        assertEquals("A", _database.getName(1, 2));
        //ensuring the database will accurately return the name of a point with those parameters
        assertNull(_database.getName(5, 6));
        //ensuring the database will return null if there is not a database with those parameters
	}

	@Test
	void testGetPointPointNode() {
		 _database = new PointNodeDatabase(points);
	     assertEquals(point1, _database.getPoint(point1));
	     //ensuring the database will return a point if given the point
	     assertNull(_database.getPoint(new PointNode("C", 5, 6)));
	     //ensuring the database will return null if a the point being requested does not exist
	}

	@Test
	void testGetPointDoubleDouble() {
		 _database = new PointNodeDatabase(points);
	     assertEquals(point1, _database.getPoint(1, 2));
	     //ensuring the database will return a point with the given parameters
	     assertNull(_database.getPoint(5, 6));
	     //ensuring the database will return null if a the point being requested does not exist
	}

}
