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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Hit intersection(Ray r) {		
		float t1, t2;

		float p = (r.getOrigin().sub(this.center)).dot(r.getDirection());
		float q = p * p - 2 * (r.getOrigin().dot(r.getOrigin())) - this.radius
				* this.radius;

		if (q < 0.0f) {
			return null;
		} else if (q == 0) {
			return new Hit(this, r, -p);
		} else {
			t1 = -p + (float) Math.sqrt(q);
			t2 = -p - (float) Math.sqrt(q);

			if (t1 < t2) {
				return new Hit(this, r, t1);
			} else {
				return new Hit(this, r, t2);
			}
		}
	}

}
