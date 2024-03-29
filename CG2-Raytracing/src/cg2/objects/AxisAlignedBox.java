package cg2.objects;

import java.util.ArrayList;
import java.util.List;

import cg2.lib.vecmath.Color;
import cg2.lib.vecmath.Vector;
import cg2.raytracer.Hit;
import cg2.raytracer.Ray;

/**
 * Eine Achsen parallele Box im Raum
 */
public class AxisAlignedBox implements IShape {
	private Vector p;
	private Vector q;
	private Color color;
	private Plane[] planes = new Plane[6];
	private float toleranz; //5 Prozent der Kürzesten Seite
	
	/**
	 * Erzeugt eine Achsen Parallele Box im Raum für die Gelten muss:</br>
	 * 		alle Werte von des Ersten Paramerters müssen kleiner sein als die von zwietern Parameter
	 * @param p die kleinere Ecke der Box
	 * @param q die größere Ecke der Box
	 * @param color die Farbe der Box
	 */
	public AxisAlignedBox(Vector p, Vector q, Color color) {
		this.p = p;
		this.q = q;
		this.color = color;
		splitBox();
		genrateToleranz();
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Hit intersection(Ray r) {
		List<Hit> hits = new ArrayList<Hit>();

		for (Plane plane : planes) { //Ermittelt die Ebenen die in der Scene im Vordergrund liegen
			float orient = plane.getNormalizeNormal().dot(r.getOrigin().sub(plane.getPoint()));
			if (orient > 0) {
				Hit hit = plane.intersection(r);
				if (hit != null) {
					hits.add(hit);
				}
			}
		}
		if (hits.size() > 0) {
			Hit reselut = hits.get(0);
			
			for (int i = 1; i < hits.size(); i++){//Ermittelt dis Vorderste Fläche die Geschnitten wird 
				if (reselut.getDistance() < hits.get(i).getDistance()) {
					reselut = hits.get(i);
				}
			}

			if (koordinatentest(r.getPoint(reselut.getDistance()))) {
				return reselut;
		
			}
		}
		return null;
		
	}

	private boolean koordinatentest(Vector point) {
		boolean x = point.x >= p.x - this.toleranz && point.x <= q.x + this.toleranz;
		boolean y = point.y >= p.y - this.toleranz && point.y <= q.y + this.toleranz;
		boolean z = point.z >= p.z - this.toleranz && point.z <= q.z + this.toleranz;
		return x && y && z;
	}

	private void splitBox() {
		this.planes[0] = new Plane(p, new Vector(0, 0, -1), color);
		this.planes[1] = new Plane(p, new Vector(0, -1, 0), color);
		this.planes[2] = new Plane(p, new Vector(-1, 0, 0), color);
		this.planes[3] = new Plane(q, new Vector(0, 0, 1), color);
		this.planes[4] = new Plane(q, new Vector(0, 1, 0), color);
		this.planes[5] = new Plane(q, new Vector(1, 0, 0), color);
	}

	
	private void genrateToleranz() {
		float x = q.x - p.x;
		float y = q.y - p.y;
		float z = q.z - p.z;
		
		float min = Math.min(x, Math.min(y, z));
		this.toleranz = min * 0.05f;
	}
}