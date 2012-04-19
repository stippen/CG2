package cg2.raytracer;

import cg2.lib.vecmath.Vector;

/**
 * Diese Klasse Simbolisierte einen Strahl mit Anfangspinkt und Richtung
 *
 */
public class Ray {
	private Vector origin;
	private Vector direction;
	
	public Ray(Vector o, Vector d){
		this.origin = o;
		this.direction = d.normalize();
	}
	
	public Vector getOrigin() {
		return origin;
	}
	public Vector getNormalizeDirection() {
		return direction;
	}
	
	/**
	 * Gibt den Punkt zu einer Distance auf dem Strahl zurück
	 * @param t die Distance (Abstand vom Ursprung des Strahles)
	 * @return einen Punkt mit Raum Kooerdianten
	 */
	public Vector getPoint(float t){
		return this.origin.add(this.direction.mult(t));
	}

}
