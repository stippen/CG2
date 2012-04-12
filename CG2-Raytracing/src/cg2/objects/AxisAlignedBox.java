package cg2.objects;

import java.util.ArrayList;
import java.util.List;

import cg2.raytracer.Hit;
import cg2.raytracer.Ray;
import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public class AxisAlignedBox implements IShape {
	private Vector p;
	private Vector q;
	private Color color;
	private Plane[] planes = new Plane[6];
	
	public AxisAlignedBox(Vector p, Vector q, Color color) {
		this.p = p;
		this.q = q;
		this.color = color;
		splitBox();
	}
	

	private void splitBox() {
		this.planes[0] = new Plane(p, new Vector(0,0,-1), color);
		this.planes[1] = new Plane(p, new Vector(0,-1,0), color);
		this.planes[2] = new Plane(p, new Vector(-1,0,0), color);
		this.planes[3] = new Plane(q, new Vector(0,0,1), color);
		this.planes[4] = new Plane(q, new Vector(0,1,0), color);
		this.planes[5] = new Plane(q, new Vector(1,0,0), color);
	}


	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Hit intersection(Ray r) {
		List<Hit> hits = new ArrayList<Hit>();
		Hit reselut = new Hit(null, null, 0);

		for (Plane plane : planes) {
			float orient = plane.getNormalizeNormal().dot(r.getOrigin().sub(plane.getPoint()));
			if(orient > 0){
				Hit hit = plane.intersection(r);
				if (hit != null){
					hits.add(hit);
				}
			}
		}
		for (Hit hit : hits) {
			if(reselut.getDistance() < hit.getDistance()){
				reselut = hit;
			}
		}
		
		if( koordinatentest(r.getPoint(reselut.getDistance())) ){
			return reselut;
		} else {
			return null;
		}
	}


	private boolean koordinatentest(Vector point) {
		boolean x = point.x < p.x && point.x > q.x;
		boolean y = point.y < p.y && point.y > q.y;
		boolean z = point.z < p.z && point.z > q.z;
		return x && y && z;
	}

}
