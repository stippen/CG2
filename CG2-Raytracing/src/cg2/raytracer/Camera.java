package cg2.raytracer;

import cg2.vecmath.Vector;

public class Camera {
	private Vector positon;
	private Vector direction;
	private Vector up;
	
	public Camera(Vector p, Vector d, Vector u){
		this.positon = p;
		this.direction = d;
		this.up = u;
	}
	
	public Vector getPositon() {
		return positon;
	}
	
	public Vector getDirection() {
		return direction;
	}
	
	public Vector getUp() {
		return up;
	}
}
