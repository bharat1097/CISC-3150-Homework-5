/*
 * Student Name: Bharat Edupghanti
 *
 * I got information on creating random numbers from: https://stackoverflow.com/questions/12458383/java-random-numbers-using-a-seed
 * 
 * This program assumes that the circle is centered at the origin (0, 0). The radius of the circle is 1 unit, since the random
 * 2-D points generated are between [0,1). Side of square = 1 unit, which is equal to r
 * 
 * ratio of area of top right quadrant of circle to area of square = (PIr^2/4)/r^2  => PI/4 ≈ 0.78539816339 
 * 
 * => This implies that PI = 4 * ratio, where ratio = PI/4
 *
 */

import java.util.Random;

public class MonteCarlo {
	public static void main(String[] args) {
		
		long dotsInsideCircle = 0;
		long dotsInsideSquare = 0;
		long totalDots = 0;
		double areaRatio;

		// Generates a double between [0, 1).
		Random randomX = new Random(System.currentTimeMillis());	
		// Generates a double between [0, 1). The seed has been omitted to enhance randomness. 
		Random randomY = new Random();								
		
		for(totalDots = 0; totalDots < 4000000000L; totalDots++) {
			
			double x = randomX.nextDouble();
			double y = randomY.nextDouble();
			
			// If the point is inside the circle of radius 1, increment dotsInsideCircle.
			if(x*x + y*y <= 1)										
				dotsInsideCircle++;
			else
				dotsInsideSquare++;
		}
		
		areaRatio = (double) dotsInsideCircle/totalDots;
		
		System.out.println("Dots that hit the circle: " + dotsInsideCircle);
		System.out.println("Dots that hit the square: " + dotsInsideSquare);
		System.out.println("Ratio of areas (PI/4) = " + areaRatio);
		System.out.println("The estimated value of PI = 4 X (PI/4): " + 4*areaRatio);
	}
}
