package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeTest {

	@Test
	void equalsSimpleTest() {
		
		assertTrue(new SegmentNode(new PointNode(0.0, 1.0), new PointNode(0.0, 1.0))
				.equals(new SegmentNode(new PointNode(0.0, 1.0), new PointNode(0.0, 1.0))));
		
		assertFalse(new SegmentNode(new PointNode(0.0, 1.0), new PointNode(0.0, 1.0))
				.equals(new SegmentNode(new PointNode(0.1, 1.0), new PointNode(0.0, 1.0))));
		
	}
	
	@Test
	void equalsRemoveLessEpsilonTest() {
		
		assertTrue(new SegmentNode(new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)), 
				new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)))
				.equals(new SegmentNode(new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)), 
						new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)))));
		
		assertTrue(new SegmentNode(new PointNode(Math.sqrt(Math.PI) + 0.00000000000000000000000001, 
				Math.sqrt(Math.PI)), new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)))
				.equals(new SegmentNode(new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)), 
						new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)))));
		
		assertTrue(new SegmentNode(new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)), 
				new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)))
				.equals(new SegmentNode(new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)), 
						new PointNode(Math.sqrt(Math.PI), Math.sqrt(Math.PI)))));
		
	}

}
