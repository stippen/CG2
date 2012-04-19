package cg2.raytracer;

/**
 * Ein Bild mit Höhe und Breite
 */
public class Image {
	private int width;
	private int height;
	
	public Image(int width, int height){
		this.height = height;
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
