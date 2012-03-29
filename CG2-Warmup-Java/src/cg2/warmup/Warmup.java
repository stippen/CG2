package cg2.warmup;

public class Warmup {

	  public static void main(String[] args) {
		  
		  // get the user's home directory - should work on all operating systems
		  final String path = new String("/media/Daten/Studium/Computergrafik_II/Übung/Übungsbilder");
		  
		  // ************ test painting a checkerboard ************ 
		  {
			  String filename = path + "/" + "Checkerboard.png";
			  new ImageGenerator(new Checkerboard(), 423, 521, filename, "png");
			  ImageGenerator.showImage(filename);
		  } 
		  
		  // ************ test painting a disk ************ 
		  {
			  String filename = path + "/" + "Diskboard.png";
			  new ImageGenerator(new Diskboard(), 500, 300, filename, "png");
			  ImageGenerator.showImage(filename);	
		  }	  
		  
	  }

}
