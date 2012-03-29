package cg2.objects;

import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public class Sphere extends Shape {
	private int radius;
	
	public Sphere(Vector center, Color color, int radius){
		this.center = center;
		this.color = color;
		this.radius = radius;
		
	}
	
	public int getRadius() {
		return radius;
	}	
	
}
