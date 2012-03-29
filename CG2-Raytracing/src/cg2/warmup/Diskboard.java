package cg2.warmup;

import cg2.vecmath.Color;

public class Diskboard implements Painter {

	public Color pixelColorAt(final int i, final int j, final int width, final int height) {
		final int radius;
		//Ermitteln des Radius anhand der kürzeren Seite
		if( width < height ) {
			radius = (int) (width * 0.9) / 2;
		} else {
			radius = (int) (height * 0.9) / 2;
		}
		
		final double x_sqrt = (width / 2.0 - i) * (width / 2.0 - i);
		final double y_sqrt = (height / 2.0 - j) * (height / 2.0 - j);
		
		final double incircle = Math.sqrt(x_sqrt + y_sqrt) / radius;

		if (incircle <= 1) {
			return new Color(1, 0, 0);
		} else {
			return new Color(0.6f, 0.6f, 0.6f);
		}

	}

}
