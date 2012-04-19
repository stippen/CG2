package cg2.objects;

import cg2.lib.vecmath.Color;
import cg2.lib.vecmath.Vector;
import cg2.raytracer.Hit;
import cg2.raytracer.Ray;

/**
 * Eine Kugel im Raum
 */
public class Sphere implements IShape {
	private float radius;
	private Vector center;
	private Color color;

	/**
	 * Erzeugt eine Kugel im Raum
	 * @param center Mittelpunkt der Kugel
	 * @param radius Radius der Kugel
	 * @param color Farbe der Kugel
	 */
	public Sphere(Vector center, float radius, Color color) {
		this.center = center;
		this.color = color;
		this.radius = radius;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Hit intersection(Ray r) {
		float t1, t2;
		Vector rayCenter = r.getOrigin().sub(this.center);

		float p = rayCenter.dot(r.getNormalizeDirection());
		float q = p * p - ((rayCenter.dot(rayCenter)) - this.radius * this.radius);

		if (q < 0.0f) {//Wenn die Kugel nicht getroffen wurde
			return null;
		} else if (q == 0 && -p > 0) {//Wenn der Strahl die Kugel nur Streift
			return new Hit(this, r, -p);
		} else {
			t1 = -p + (float) Math.sqrt(q);
			t2 = -p - (float) Math.sqrt(q);

			if (t1 > t2 && t1 > 0) {
				return new Hit(this, r, t1);
			} else if(t2 > 0){
				return new Hit(this, r, t2);
			} else {
				return null;
			}
		}
	}

}
