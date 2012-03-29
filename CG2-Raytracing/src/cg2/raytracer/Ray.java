package cg2.raytracer;

import cg2.vecmath.Vector;

public class Ray {
	private Vector origin;
	private Vector direction;
	
	public Ray(Vector o, Vector d){
		this.origin = o;
		d.normalize();
		this.direction = d;
	}
	
	public Vector getOrigin() {
		return origin;
	}
	public void setOrigin(Vector origin) {
		this.origin = origin;
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	
	public Vector getPoint(float t){
		return this.origin.add(this.direction.mult(t));
	}

}
