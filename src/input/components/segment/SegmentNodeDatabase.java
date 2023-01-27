/**
* Creates a database for the SegmentNodes.
*
* <p>Bugs: none known
*
* @author Sam Luck-Leonard, Mason Taylor, and Josh Berger
* @date 1/27/2023
*/
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

	/**
	 * 
	 * Adds a directed edge from node 'a' to node 'b' in the adjacency list.
	 * If the adjacency list does not contain node 'a', it will be added with node 'b' in its adjacency list.
	 * If node 'b' is not already in node 'a's adjacency list, it will be added.
	 * @param a the starting node of the directed edge
	 * @param b the ending node of the directed edge
	 */
	private void addDirectedEdge(PointNode a, PointNode b) {

		if(a == null || b == null) return;
		
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
		
		if(point == null || adjLists == null) return;
		
		if(adjLists.size()== 0) return;
		
		for(PointNode node : adjLists) {
			
			this.addUndirectedEdge(point, node);
			
		}
	}

	/**
	 * Returns a list of unique segments in the graph.
	 * @return a list of unique SegmentNodes in the graph.
	*/
	public List<SegmentNode> asUniqueSegmentList(){
		
		List<SegmentNode> segments = new ArrayList<SegmentNode>();
		
		for(Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) {
			
			for(PointNode node : entry.getValue()) {
				
				segments.add(new SegmentNode(entry.getKey(), node));
			}
			
		}
		
		return segments;
	}
	/**
	 * Returns a list of SegmentNodes representing the segments in this graph.
	 * This method iterates through the adjacency lists of the graph and creates a
	 * new SegmentNode for each unique pair of points. The segments are then added to a list and returned.
	 * @return a list of SegmentNodes objects representing the segments in this graph
	*/
	public List<SegmentNode> asSegmentList() {

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
