package cg2.raytracer;

import cg2.lib.Painter;
import cg2.lib.vecmath.Color;

public class Raytracer implements Painter{
	private Scene scene;
	private Camera camera;
	
	public Raytracer(Scene scene, Camera camera){
		this.scene = scene;
		this.camera = camera;
	}	
	@Override
	public Color pixelColorAt(int x, int y, int width, int height) {
		Ray ray = this.camera.generateRay(x, y, width, height);
		Hit hit = this.scene.intersect(ray);
		Color reselute;
		
		if(hit != null){
			reselute = hit.getHitobjcet().getColor();
		} else {
			reselute = this.scene.getColor();
		}
		return reselute;
	}
}