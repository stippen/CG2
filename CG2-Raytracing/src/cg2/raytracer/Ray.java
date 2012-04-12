package cg2.raytracer;

import cg2.vecmath.Vector;

public class Ray {
	private Vector origin;
	private Vector direction;
	
	public Ray(Vector o, Vector d){
		this.origin = o;
		this.direction = d.normalize();
	}
	
	public Vector getOrigin() {
		return origin;
	}
	public Vector getNormalizeDirection() {
		return direction;
	}
	
	public Vector getPoint(float t){
		return this.origin.add(this.direction.mult(t));
	}

}
