package cg2.raytracer;

import cg2.objects.IShape;

/**
 * Ein Treffer Objekt, aus Getroffenen Objekt, Strahl von dem Ausgegengen wird
 * und der Distanz vom ursprung des Strahls bis zum getronnenen Punkt des
 * Objektes
 */
public class Hit {
	private IShape hitobjcet;
	private Ray ray;
	private float distance;

	public Hit(IShape s, Ray r, float d) {
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
