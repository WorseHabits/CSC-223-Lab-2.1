package input.components.point;

import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

import utilities.math.MathUtilities;


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
		
        for(PointNode point : points) 
        {
        	put(point);
        }
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
	    PointNode point = getPoint(x, y);
	    return _points.contains(point);
	}
	
	
	public String getName(PointNode point)
	{
		for (PointNode point1:_points)
		{
			if(point1.equals(point)) {return point._name;}
		}
		return null;
		
	}
	public String getName(double x, double y)
	{
		PointNode point1 = getPoint(x,y);
		if (point1 == null) {return null;}
		return point1.getName();

	}
	
	
	public PointNode getPoint(PointNode point)
	{
		if(_points.contains(point)) {return point;}
		else {return null;}
	}
	public PointNode getPoint(double x, double y)
    {
        PointNode point1 = new PointNode(x, y);
        if (_points.contains(point1)) 
        {
            for (PointNode point:_points) 
            {
                if (point1.equals(point)) {return point;}
            }
        }
        return null;
    }
	
}
