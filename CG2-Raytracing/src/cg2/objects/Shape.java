package cg2.objects;

import cg2.raytracer.Ray;
import cg2.vecmath.Color;

public interface Shape {
	public Color getColor();
	public float intersection(Ray r); 
}
