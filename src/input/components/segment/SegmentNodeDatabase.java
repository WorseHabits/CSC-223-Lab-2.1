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

		for (Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) {

			for (@SuppressWarnings("unused") PointNode point : entry.getValue()) {

				total++;

			}

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

//	public void addUndirectedEdge(PointNode a, PointNode b) {
//		// if the map doesn't contain point a
//		// add it with only b in its adjacency list
//		if (!_adjLists.containsKey(a)) {
//
//			_adjLists.put(a, new HashSet<PointNode>(Arrays.asList(b)));
//		}
//		// if the map contains point a
//		// check to see if b is in its adjacency list
//		// if not, add b to its adjacency list
//		else if (_adjLists.containsKey(a)) {
//
//			if (!_adjLists.get(a).contains(b)) {
//
//				Set<PointNode> aADJ = new HashSet<PointNode>(_adjLists.get(a));
//
//				aADJ.add(b);
//
//				_adjLists.put(a, aADJ);
//
//			}
//
//		}
//		// if the map doesn't contain point b
//		// add it with only a in its adjacency list
//		if (!_adjLists.containsKey(b)) {
//
//			_adjLists.put(b, new HashSet<PointNode>(Arrays.asList(a)));
//
//		}
//		// if the map contains point b
//		// check to see if a is in its adjacency list
//		// if not, add a to its adjacency list
//		else if (_adjLists.containsKey(b)) {
//
//			if (!_adjLists.get(b).contains(a)) {
//
//				Set<PointNode> bADJ = new HashSet<PointNode>(_adjLists.get(b));
//
//				bADJ.add(a);
//
//				_adjLists.put(b, bADJ);
//
//			}
//
//		}
//
//	}

	public void addAdjacencyList(PointNode point, List<PointNode> adjList) {
		if (point != null && adjList != null) {
		// if the map contains point
		// check to see if point already has each of the adjacencies in the passed-in list
		// if not, add them
		if (_adjLists.containsKey(point)) {

			for (PointNode adjacency : adjList) {

				if (!_adjLists.get(point).contains(adjacency)) {

					Set<PointNode> pointADJ = new HashSet<PointNode>(_adjLists.get(point));

					pointADJ.add(adjacency);

					_adjLists.put(point, pointADJ);

				}
			}
		}
		// if the map doesn't contain point
		// add it and the passed-in adjacency list as a set
		else if (!_adjLists.containsKey(point)) {

			Set<PointNode> adjSet = new HashSet<PointNode>();

			adjSet.addAll(adjList);

			_adjLists.put(point, adjSet);

		}
		// check to see if the points in the adjacency list are in the map
		// if so, check to see if the point is already in their adjacency list and if so, add it
		// if not, add them and point as the only point in their adjacency list
		for (PointNode adjacency : adjList) {

			if (_adjLists.containsKey(adjacency)) {

				Set<PointNode> adjacencyADJ = new HashSet<PointNode>(_adjLists.get(adjacency));

				adjacencyADJ.add(point);

				_adjLists.put(adjacency, adjacencyADJ);

			}

			else if (!_adjLists.containsKey(adjacency)) {

				_adjLists.put(adjacency, new HashSet<PointNode>(Arrays.asList(point)));

			}

		}
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

	// creates a list
	// if a segment's reverse is not already in the list, add each segment to  the list
	public List<SegmentNode> asUniqueSegmentList() {

		List<SegmentNode> segments = new ArrayList<SegmentNode>();
		List<PointNode> keys = new ArrayList<PointNode>();

		for (Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) { 

			keys.add(entry.getKey());

			for (PointNode p : entry.getValue()) {

				if (!keys.contains(p)) {

					segments.add(new SegmentNode(entry.getKey(),p));

				}

			}

		}

		return segments;

	}

}
