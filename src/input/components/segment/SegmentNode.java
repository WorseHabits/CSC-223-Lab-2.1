/**
* Creates a class for the object SegmentNode.
*
* <p>Bugs: none known
*
* @author Sam Luck-Leonard, Mason Taylor, and Josh Berger
* @date 1/27/2023
*/
package input.components.segment;

import input.components.point.PointNode;

/**
 * A utility class only for representing ONE segment
 */
public class SegmentNode
{
	protected PointNode _point1;
	protected PointNode _point2;
	
	public PointNode getPoint1() { return _point1; }
	public PointNode getPoint2() { return _point2; }
	
	public SegmentNode(PointNode pt1, PointNode pt2){
		
		_point1 = pt1;
		_point2 = pt2;
		
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o == null) return false; 
		
		if(!(o instanceof SegmentNode)) return false;
		
		SegmentNode segment = (SegmentNode) o;
		
		return((_point1.equals(segment._point1) || _point1.equals(segment._point2)) 
				&& (_point2.equals(segment._point1) || _point2.equals(segment._point2)));
		
	}
	
}