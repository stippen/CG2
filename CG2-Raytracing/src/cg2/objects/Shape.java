package cg2.objects;

import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public abstract class Shape {
	
	protected Vector center;
	protected Color color;
	
	public Vector getCenter() {
		return center;
	}
	public void setCenter(Vector center) {
		this.center = center;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
