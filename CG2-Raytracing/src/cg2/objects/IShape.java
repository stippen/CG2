package cg2.objects;

import cg2.raytracer.Hit;
import cg2.raytracer.Ray;
import cg2.vecmath.Color;

public interface IShape {
	public Color getColor();
	public Hit intersection(Ray r); 
}
