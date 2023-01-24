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

	@Override
	public boolean equals(Object o){
		
		if(o == null)  return false; 
		
		if(!(o instanceof PointNode))  return false; 
		
		
		PointNode node = (PointNode) o;
		
		return MathUtilities.doubleEquals(this.getX(), node.getX()) &&
				MathUtilities.doubleEquals(this.getY(), node.getY());
			
	}

    @Override
    public String toString(){
    	
		String str = "";
		
		return str + _name + _x + _y;
		
	}
}