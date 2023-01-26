package input.components.segment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import input.components.point.PointNode;

public class SegmentNodeDatabase {

	private Map<PointNode, Set<PointNode>> _adjLists;

	public SegmentNodeDatabase() {

		_adjLists = new HashMap<PointNode, Set<PointNode>>();

	}

	public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> adjLists) {
		
		if (adjLists == null) _adjLists = new HashMap<PointNode, Set<PointNode>>();
		else _adjLists = new HashMap<PointNode, Set<PointNode>>(adjLists);

	}

	// the adjacency map has each segment twice, so to get the actual number of segments, you should take half
	public int numUndirectedEdges() {

		int total = 0;
		
		for (Set<PointNode> adjacencies : _adjLists.values()) {

			total = total + adjacencies.size();

		}

		return total / 2;
		
	}

	// idk what the - means in the lab instructions
	private void addDirectedEdge(PointNode a, PointNode b) {

		// if the map doesn't contain point a add it with b in its adjacency list

		if(!_adjLists.containsKey(a)) {

			_adjLists.put(a, new HashSet<PointNode>(Arrays.asList(b)));

		}

		// if b is not in a's adjacency list, add it

		if(!_adjLists.get(a).contains(b)) {

			_adjLists.get(a).add(b);

		}

	}
	
	public void addUndirectedEdge(PointNode a, PointNode b) {
		
		// call directed edge both ways
		
		this.addDirectedEdge(a, b);
		
		this.addDirectedEdge(b, a);
		
	}
	
	public void addAdjacencyList(PointNode point, List<PointNode>adjLists) {
		
		if(point == null) return;
		
		if(adjLists == null) return;
		
		if(adjLists.size()== 0) return;
		
		for(PointNode node : adjLists) {
			
			this.addUndirectedEdge(point, node);
			
		}
	}

	// creates a list
	// adds each segment as the pair of each PointNode and each PointNode in its adjacency list
	// that means it would be a list of double the segments because each segment is repeated forwards and backwards
	// ie has Segment from A to B as both A to B and B to A
	public List<SegmentNode> asSegmentList() {

		List<SegmentNode> segments = new ArrayList<SegmentNode>();

		for (Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) { 

			for (PointNode p : entry.getValue()) {

				segments.add(new SegmentNode(entry.getKey(),p));

			}

		}

		return segments;

	}
	
	public List<SegmentNode> asUniqueSegmentList(){
		
		List<SegmentNode> segments = new ArrayList<SegmentNode>();
	}

	// creates a list
	// if a segment's reverse is not already in the list, add each segment to  the list
//	public List<SegmentNode> asUniqueSegmentList() {
//
//		List<SegmentNode> segments = new ArrayList<SegmentNode>();
//		List<PointNode> keys = new ArrayList<PointNode>();
//
//		for (Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) { 
//
//			keys.add(entry.getKey());
//
//			for (PointNode p : entry.getValue()) {
//
//				if (!keys.contains(p)) {
//
//					segments.add(new SegmentNode(entry.getKey(),p));
//
//				}
//
//			}
//
//		}
//
//		return segments;
//
//	}

}
