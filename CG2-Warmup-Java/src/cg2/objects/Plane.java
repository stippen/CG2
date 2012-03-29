package cg2.objects;

import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public class Plane extends Shape {
	private int height;
	private int width;
	
	public Plane(Vector center, Color color, int height, int width){
		this.center = center;
		this.color = color;
		this.height = height;
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
