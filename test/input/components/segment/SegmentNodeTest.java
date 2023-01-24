package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeTest {

	@Test
	void equalsSimpleTest() {
		
		PointNode node1 = new PointNode(0.0, 1.0);

		PointNode node2 = new PointNode(1.0, 1.0);
		
		PointNode node3 = new PointNode(0.1, 1.0);
		
		SegmentNode seg1 = new SegmentNode(node1, node2);
		
		SegmentNode seg2 = new SegmentNode(node1, node3);
		
		SegmentNode sameSeg1 = seg1;
		
		assertTrue(seg1.equals(seg1));
		
		assertFalse(seg1.equals(seg2));
		
		assertTrue(seg1.equals(sameSeg1));
		
	}
	
	@Test
	void equalsRemoveLessEpsilonTest() {
		
		PointNode piNode = new PointNode(Math.PI, Math.PI);
		
		PointNode root2 = new PointNode(Math.sqrt(2), Math.sqrt(2));
		
		SegmentNode piSegment = new SegmentNode(piNode, piNode);
		
		SegmentNode piRoot2 = new SegmentNode(piNode, root2);
		
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
