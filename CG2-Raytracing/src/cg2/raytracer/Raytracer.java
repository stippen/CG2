package cg2.raytracer;

import cg2.objects.Plane;
import cg2.objects.Sphere;
import cg2.vecmath.Color;
import cg2.vecmath.Vector;

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
	

	public static void main(String[] args) {
		
		Scene scene = new Scene(new Color(0.6f, 0.7f, 1.0f));
		scene.addShape(new Sphere(new Vector(1.0f, 0.0f, -2.0f), new Color(1, 0, 0), 0.5f));
		scene.addShape(new Sphere(new Vector(1.0f, 0.0f, -5.0f), new Color(0, 0, 1), 0.5f));
		scene.addShape(new Sphere(new Vector(-0.6f, 0.6f, -2.0f), new Color(0, 1, 0), 0.6f));	
		scene.addShape(new Sphere(new Vector(0.0f, 0.0f, 1.0f), new Color(0, 1, 1), 0.1f));
		scene.addShape(new Plane(new Vector(0, -0.5f, 0), new Vector(0, 1f, 0), new Color(0, 0.4f, 0)));
		Camera camera = new Camera(90.0f);
		Image image = new Image(600, 400);
			
		
		// get the user's home directory - should work on all operating systems
		String path = new String(
				"/media/Daten/Studium/Computergrafik_II/Übung/Übungsbilder");

		String filename = path + "/" + "Raytracer.png";
		new ImageGenerator(new Raytracer(scene, camera), image.getWidth(), image.getHeight(), filename, "png");
		ImageGenerator.showImage(filename);

	}


}
