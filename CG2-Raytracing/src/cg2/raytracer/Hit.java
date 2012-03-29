package cg2.raytracer;

import cg2.objects.Shape;

public class Hit {
	private Shape hitobjcet;
	private Ray ray;
	private float distance;
	
	public Hit(Shape s, Ray r, float d){
		this.hitobjcet = s;
		this.ray = r;
		this.distance = d;
	}

	public Shape getHitobjcet() {
		return hitobjcet;
	}

	public float getDistance() {
		return distance;
	}
	
}
