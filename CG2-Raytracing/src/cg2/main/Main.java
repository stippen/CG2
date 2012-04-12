package cg2.main;

import cg2.lib.ImageGenerator;
import cg2.objects.AxisAlignedBox;
import cg2.objects.Plane;
import cg2.objects.Sphere;
import cg2.raytracer.Camera;
import cg2.raytracer.Image;
import cg2.raytracer.Raytracer;
import cg2.raytracer.Scene;
import cg2.vecmath.Color;
import cg2.vecmath.Vector;

public class Main {
	public static void main(String[] args) {
		
		Scene scene = new Scene(new Color(0.7f, 0.8f, 1.0f));
		scene.addShape(new Sphere(new Vector(1.0f, 0.0f, -2.0f), new Color(1, 0, 0), 0.5f));
		scene.addShape(new Sphere(new Vector(1.0f, 0.0f, -5.0f), new Color(0, 0, 1), 0.5f));
		scene.addShape(new Sphere(new Vector(-0.6f, 0.6f, -2.0f), new Color(0, 1, 0), 0.6f));	
		scene.addShape(new Sphere(new Vector(0.0f, 0.0f, 1.0f), new Color(1, 1, 0), 0.1f));

		scene.addShape(new Plane(new Vector(0, -0.5f, 0), new Vector(0, 1f, 0), new Color(0, 0.6f, 0)));
		
		scene.addShape(new AxisAlignedBox(new Vector(-3f, -3f, -3f), new Vector(3f, 3f, 1f), new Color(1, 1, 0)));
		
		Camera camera = new Camera(120.0f);
		Image image = new Image(600, 400);
			
		
		// get the user's home directory - should work on all operating systems
		String path = new String(
				"/media/Daten/Studium/Computergrafik_II/Übung/Übungsbilder");

		String filename = path + "/" + "Raytracer.png";
		new ImageGenerator(new Raytracer(scene, camera), image.getWidth(), image.getHeight(), filename, "png");
		ImageGenerator.showImage(filename);

	}
}
