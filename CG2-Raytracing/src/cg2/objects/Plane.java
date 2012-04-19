package cg2.objects;

import cg2.lib.vecmath.Color;
import cg2.lib.vecmath.Vector;
import cg2.raytracer.Hit;
import cg2.raytracer.Ray;

/**
 * Eine Fläche im Raum
 */
public class Plane implements IShape {
	private Vector point;
	private Vector normal;
	private Color color;
	private float d;
	
	/**
	 * Erzeugt eine Fläche
	 * @param p ein Punkt auf der Fläche
	 * @param n die Normale auf der Fläche
	 * @param color die Farbe der Fläche
	 */
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

	public Vector getPoint() {
		return point;
	}
	
	public Vector getNormalizeNormal() {
		return normal;
	}

	@Override
	public Hit intersection(Ray r) {
		float denominator = this.normal.dot(r.getNormalizeDirection());
		if (denominator == 0){ //Strahl ist Parallel zur Ebene
			return null;
		}
		float nominator = this.d - this.normal.dot(r.getOrigin());
		float t = nominator / denominator;
		if(t < r.getOrigin().z){ //Der Schnittpunkt ist hinter des Ursprung des Strahls
			return null;
		} else {
			return new Hit(this, r, t);
		}
	}

}
