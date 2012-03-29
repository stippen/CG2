package cg2.objects;

import cg2.raytracer.Hit;
import cg2.raytracer.Ray;
import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public class Plane implements Shape {
	private Vector normal;
	private Vector point;
	private Color color;
	
	public Plane(Vector n, Vector p, Color color){
		this.color = color;
		this.normal = n;
		this.point = p;
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
