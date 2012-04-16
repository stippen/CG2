package cg2.objects;

import cg2.lib.vecmath.Color;
import cg2.raytracer.Hit;
import cg2.raytracer.Ray;

public interface IShape {
	public Color getColor();
	public Hit intersection(Ray r); 
}
