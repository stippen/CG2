package cg2.raytracer;

import java.util.ArrayList;
import java.util.List;

import cg2.objects.Shape;
import cg2.vecmath.Color;

public class Scene {
	private List<Shape> shapeList;
	private Color color;
	

	public Scene(){
		this.shapeList = new ArrayList<Shape>();
	}
	
	public Scene(Color color) {
		this.shapeList = new ArrayList<Shape>();
		this.color = color;
	}

	public void addShape(Shape s){
		this.shapeList.add(s);
	}

	public List<Shape> getShapeList() {
		return shapeList;
	}

	public Color getColor() {
		return color;
	}
	
	public Hit intersect(Ray ray){
		Hit hit = null;
		for (Shape shape : shapeList) {
			Hit temp = shape.intersection(ray);
			
			if(temp != null){
				if(hit == null){
					hit = temp;
				} else if(temp.getDistance() < hit.getDistance()){
					hit = temp;
				}
			}
		}
		
		return hit;
	}

	
}
