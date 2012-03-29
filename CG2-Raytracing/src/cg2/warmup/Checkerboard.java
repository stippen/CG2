package cg2.warmup;

import cg2.vecmath.Color;


public class Checkerboard implements Painter {
	
	public Color pixelColorAt(final int i, final int j, final int width, final int height) {
		final double rectwidth =  Math.floor((double) i / (double) (width / 8.0));
		final double rectheight =  Math.floor((double) j / (double) (height / 8.0));
		
		if(rectwidth % 2 + rectheight % 2 == 1) {
			return new Color(0, 0, 0);
		} else {
			return new Color(1, 1, 1);
		}
	  
	  
    
  }

}
