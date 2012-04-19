package cg2.objects;

import cg2.lib.vecmath.Color;
import cg2.raytracer.Hit;
import cg2.raytracer.Ray;

/**
 * Ein Obekt in der Scene
 */
public interface IShape {
	
	/**
	 * Gibt die Farbe des Objektes Zurück
	 * @return die Farbe des Objektes
	 */
	public Color getColor();
	
	/**
	 * Diese Funktion ermittelt ob dieses Objekt von dem Strahl getroffenen wurde
	 * @param r der zu untersuchende Strahl
	 * @return ein Hit object wenn dieses Shape getrofenen wurde, dem Strahl und der Distranz</br>
	 * 		   null wenn kein Objekt getroffen wurde
	 */
	public Hit intersection(Ray r); 
}
