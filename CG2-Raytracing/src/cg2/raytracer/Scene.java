package cg2.raytracer;

import java.util.List;

import cg2.objects.Shape;

public class Scene {
	private List<Shape> shapeList;
	
	public void addShape(Shape s){
		this.shapeList.add(s);
	}

	public List<Shape> getShapeList() {
		return shapeList;
	}
	
	public Hit intersect(Ray ray){
		return null;
	}

	
}
