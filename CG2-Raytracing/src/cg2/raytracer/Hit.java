package cg2.raytracer;

import cg2.objects.IShape;

public class Hit {
	private IShape hitobjcet;
	private Ray ray;
	private float distance;
	
	public Hit(IShape s, Ray r, float d){
		this.hitobjcet = s;
		this.ray = r;
		this.distance = d;
	}

	public IShape getHitobjcet() {
		return hitobjcet;
	}

	public float getDistance() {
		return distance;
	}
	
}
