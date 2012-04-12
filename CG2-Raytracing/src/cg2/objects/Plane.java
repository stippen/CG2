package cg2.objects;

import cg2.raytracer.Hit;
import cg2.raytracer.Ray;
import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public class Plane implements Shape {
	private Vector point;
	private Vector normal;
	private Color color;
	private float d;
	
	public Plane(Vector p, Vector n, Color color){
		this.point = p;
		this.normal = n.normalize();
		this.color = color;
		this.d = this.normal.dot(this.point);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Hit intersection(Ray r) {
		
		return null;
	}

}
