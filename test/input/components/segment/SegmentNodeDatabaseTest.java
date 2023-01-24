package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeDatabaseTest
{
    public SegmentNodeDatabase build()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }
 
	@Test
	void testNumUndirectedEdges()
	{
		SegmentNodeDatabase db = build();
		// makes sure the size of the built database is correct
		assertEquals(10, db.numUndirectedEdges());
		
		// makes sure the size doesn't change when adding an existing point
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	db.addUndirectedEdge(a, b);
    	assertEquals(10, db.numUndirectedEdges());
	}
	
	@Test
	void testAddAdjacencyList() {
		// makes an adjacency list for a new point
		// the list encompasses a new point and two points already in the map
		SegmentNodeDatabase db = build();
		
		PointNode f = new PointNode("F", 6, 6);
		PointNode g = new PointNode("G", 8, 8);
		PointNode a = new PointNode("A", 3, 6);
		PointNode e = new PointNode("E", 6, 0);
		db.addAjacencyList(f, Arrays.asList(a, e, g));
		
		assertEquals(13, db.numUndirectedEdges());
		
		// makes sure it doesn't re-add a list of existing points
		db.addAjacencyList(f, Arrays.asList(a, e, g));
		assertEquals(13, db.numUndirectedEdges());
	}
	
	@Test
	void testAsSegmentList() {
		// makes sure there it makes an empty list for an empty db
		SegmentNodeDatabase empty = new SegmentNodeDatabase();
		assertEquals(0, empty.asSegmentList().size());
		
		// the segment list has each segment twice: forwards and backwards
		// so the list's size should be double (20) the amount of undirected edges in the map (10)
		SegmentNodeDatabase db = build();
		
		assertEquals(20, db.asSegmentList().size());
	}
	
	@Test
	void testAsUniqueSegmentList() {
		// makes sure there it makes an empty list for an empty db
		SegmentNodeDatabase empty = new SegmentNodeDatabase();
		assertEquals(0, empty.asUniqueSegmentList().size());
				
		// the segment list has each segment once
		// so the list's size should be the amount of undirected edges in the map (10)
		SegmentNodeDatabase db = build();
		
		assertEquals(10, db.asUniqueSegmentList().size());
	}
	
	@Test
	void testConstructor() {
		// makes sure it handles passing null into the constructor
		SegmentNodeDatabase empty = new SegmentNodeDatabase();
		assertEquals(0, empty.numUndirectedEdges());
		
		// makes sure it handles passing null into the constructor
		SegmentNodeDatabase dbWithNull = new SegmentNodeDatabase(null);
		assertEquals(0, dbWithNull.numUndirectedEdges());
	}
}
