package input.components.point;

import utilities.math.MathUtilities;

/**
 * A 2D Point (x, y).
 */
public class PointNode
{
	protected static final String ANONYMOUS = "__UNNAMED";

	protected double _x;
	public double getX() { return this._x; }

	protected double _y; 
	public double getY() { return this._y; }

	protected String _name; 
	public String getName() { return _name; }

	/**
	 * Create a new Point with the specified coordinates.
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y) { this(ANONYMOUS, x, y); }

	/**
	 * Create a new Point with the specified coordinates.
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y){
		
		_name = name;
		
		_x = x;
		
		_y = y;
		
	}

	@Override
	public int hashCode(){
		
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}

	public boolean equals(Object o){
		
		
		if(o instanceof PointNode && o != null) {
			
			PointNode node = (PointNode) o;
			
			Double thisX = MathUtilities.removeLessEpsilon(_x);
			
			Double thatX = MathUtilities.removeLessEpsilon(node._x);
			
			Double thisY = MathUtilities.removeLessEpsilon(_y);
			
			Double thatY = MathUtilities.removeLessEpsilon(node._y);
			
			return MathUtilities.doubleEquals(thisX, thatX) && MathUtilities.doubleEquals(thisY, thatY);
			
		}
		
		return false;
		
	}

    @Override
    public String toString(){
    	
		String str = "";
		
		return str + _name + _x + _y;
		
	}
}