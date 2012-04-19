package cg2.objects;

import cg2.lib.vecmath.Color;
import cg2.lib.vecmath.Vector;
import cg2.raytracer.Hit;
import cg2.raytracer.Ray;

/**
 * ein Dreieck im Raum
 */
public class Triangle implements IShape {
	private Vector point0;
	private Vector point1;
	private Vector point2;
	private Color color;
	
	/**
	 * Erzeugt ein Dreieck im Raum
	 * @param point0 Erster Eckpunkt des Dreiecks
	 * @param point1 Zweiter Eckpunkt des Dreiecks
	 * @param point2 Dritter Eckpunkt des Dreiecks
	 * @param color Farbe des Dreiecks
	 */
	public Triangle(Vector point0, Vector point1, Vector point2, Color color) {
		this.point0 = point0;
		this.point1 = point1;
		this.point2 = point2;
		this.color = color;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Hit intersection(Ray r) {
		// Berechnung der Ebene, die des Dreieck einspannt
		Vector e1 = this.point1.sub(this.point0);
		Vector e2 = this.point2.sub(this.point0);

		// Berechnung des Ergebnis des linearen Gleichungssystems
		Vector s = r.getOrigin().sub(this.point0);
		Vector p = r.getNormalizeDirection().cross(e2);
		Vector q = s.cross(e1);
		Vector x = new Vector(q.dot(e2), p.dot(s), q.dot(r.getNormalizeDirection()));
		Vector tvu = x.mult(1 / p.dot(e1));

		float t = tvu.x;
		float u = tvu.y;
		float v = tvu.z;

		if (u > 0 && v > 0 && u + v < 1.0f) { //Liegt der Strahl im Dreieck?
			return new Hit(this, r, t);
		}

		return null;
	}

}
