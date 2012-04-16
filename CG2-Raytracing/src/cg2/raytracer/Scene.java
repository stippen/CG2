package cg2.raytracer;

import java.util.ArrayList;
import java.util.List;

import cg2.lib.vecmath.Color;
import cg2.objects.IShape;

public class Scene {
	private List<IShape> shapeList;
	private Color color;

	public Scene() {
		this.shapeList = new ArrayList<IShape>();
	}

	public Scene(Color color) {
		this.shapeList = new ArrayList<IShape>();
		this.color = color;
	}

	public void addShape(IShape s) {
		this.shapeList.add(s);
	}

	public List<IShape> getShapeList() {
		return shapeList;
	}

	public Color getColor() {
		return color;
	}

	public Hit intersect(Ray ray) {
		Hit hit = null;
		for (IShape shape : shapeList) {
			Hit temp = shape.intersection(ray);

			if (temp != null) {
				if (temp.getDistance() > 0) {
					if (hit == null) {
						hit = temp;
					} else if (temp.getDistance() < hit.getDistance()) {
						hit = temp;
					}
				}
			}
		}

		return hit;
	}

}
