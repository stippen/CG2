package cg2.objects;

import cg2.raytracer.Hit;
import cg2.raytracer.Ray;
import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public class Sphere implements Shape {
	private float radius;
	private Vector center;
	private Color color;

	public Sphere(Vector center, Color color, float radius) {
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

		if (q < 0.0f) {
			return null;
		} else if (q == 0 && -p > 0) {
			return new Hit(this, r, -p);
		} else {
			t1 = -p + (float) Math.sqrt(q);
			t2 = -p - (float) Math.sqrt(q);

			if (t1 < t2 && t1 > 0) {
				return new Hit(this, r, t1);
			} else if(t2 > 0){
				return new Hit(this, r, t2);
			} else {
				return null;
			}
		}
	}

}
