package input.components.point;

import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class PointNodeDatabase {
	Set<PointNode> _points;
	
	public PointNodeDatabase() 
	{
		_points = new LinkedHashSet<PointNode>();
	}
	
	public PointNodeDatabase(List<PointNode> points) 
	{
	    if(points == null) {_points = new LinkedHashSet<PointNode>();} 
	    else {_points = new LinkedHashSet<PointNode>(points);}
	}
	
	public void put(PointNode point)
	{
		_points.add(point);
	}
	
	public boolean contains(PointNode point)
	{
		return _points.contains(point);
	}
	
	public boolean contains(double x, double y)
	{
		for (PointNode point:_points)
		{
			//checking for if the point with the given x and y exists
			if (point.getX() == x && point.getY() == y) {return true;}
		}
		return false;
	}
	
	public String getName(PointNode point)
	{
		return point.getName();
	}
	
	public String getName(double x, double y)
	{
		for (PointNode point:_points)
		{
			//checking for if the point with the given x and y exists
			if (point.getX() == x && point.getY() == y) {return point.getName();}
		}
		return null;
	}
	
	public PointNode getPoint(PointNode point)
	{
		for (PointNode point1:_points)
		{
			if(point1.equals(point)) {return point1;}
		}
		return null;
	}

	public PointNode getPoint(double x, double y)
	{
		for (PointNode point:_points)
		{
			//checking for if the point with the given x and y exists
			if (point.getX() == x && point.getY() == y) {return point;}
		}
		return null;
	}
	
	
}
