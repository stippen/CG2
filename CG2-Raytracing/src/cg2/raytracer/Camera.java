package cg2.raytracer;

import cg2.lib.vecmath.Vector;

public class Camera {
	private Vector positon;
	private Vector direction;
	private Vector up;
	private float fieldOfViewX;
	private float w = 1;
	private float z;

	public Camera(float fieldOfViewX){
		this.fieldOfViewX = fieldOfViewX;
		this.positon = new Vector(0, 0, 0);
		this.direction = new Vector(0, 0, -1).normalize();
		this.up = new Vector(0, 1, 0).normalize();
		
		this.z = (float) -(this.w/(2.0 * Math.tan(Math.toRadians(fieldOfViewX) / 2.0f)));
	}
	
//	public Camera(Vector p, Vector d, Vector u, float w){
//		this.positon = p;
//		this.direction = d.normalize();
//		this.up = u.normalize();
//		this.fieldOfViewX = w;
//	}
	
	public Vector getPositon() {
		return positon;
	}
	
	public Vector getNormalizeDirection() {
		return direction;
	}
	
	public Vector getNormalizeUp() {
		return up;
	}
	
	public float getFieldOfViewX() {
		return fieldOfViewX;
	}
	
	public Ray generateRay(int i, int j, int width, int height){
		float h = (height * this.w) / width;
		float x = (- this.w / 2.0f) + ((float)i + 0.5f) * this.w / width;
		float y = (- h / 2.0f) + ((float)j + 0.5f) * h / height;
		
		Ray reselut = new Ray(this.positon, new Vector(x, y, this.z));
		
		return reselut;
	}
	
}
