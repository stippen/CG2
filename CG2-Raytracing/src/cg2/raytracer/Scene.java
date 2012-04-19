package cg2.raytracer;

import java.util.ArrayList;
import java.util.List;

import cg2.lib.vecmath.Color;
import cg2.objects.IShape;

/**
 * Eine Scene mit einer Liste aus IShapes und einer Hintergrund Farbe
 *
 */
public class Scene {
	private List<IShape> shapeList;
	private Color color;

	/**
	 * Erzeugt eine Scene mit einem Schwarzen Hintergrund
	 */
	public Scene() {
		this.shapeList = new ArrayList<IShape>();
		this.color = new Color(0,0,0);
	}

	/**
	 * @param color Hintergrund Farbe der Scene
	 */
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

	/**
	 * Diese Funktion ermittelt das Vorderste getroffenen IShape eines Strahles
	 * @param ray der zu untersuchende Strahl
	 * @return ein Hit object mit dem getrofenen Shape, dem Strahl und der Distranz;
	 * 		   null wenn kein Objekt getroffen wurde
	 */
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
