package vegasBaby;

import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable 
{
		//Integer (represents the color)
		//red = 0
		//orange = 1
		//blue = 2
		//yellow = 3
		//green = 4
		

		//Zero-Square
		//One - Circle
		private int color;
		
		//Strings for shapes
		//Code:
		//Zero-Square
		//One - Circle
		private int shape;
		
		/**
		 * @param take in an integer to later represent the color of a shape
		 * @return this function returns the value of pHeight when called 
		 */
		public int getColor() 
		{
			return color;
		}
			
		
		
		/**
		 * @return this function returns the value of the first shape in the lineup
		 */
		public int getShape() 
		{
			return shape;
		}
		
		
		//Setters 
		
		/**
		 * @param this function takes a string value to represent the shape
		 * this function sets the value of shape when called 
		 */
		public void setShape(int one) 
		{
			shape = one;
		}
		
			
		/**
		 * @param this function takes an integer value to represent the color of the shape
		 * this function sets the value of color when called 
		 */
		public void setColor(int c) 
		{
			color=c;
		}
		
		/**
		 * this function randomly assigned a color and shape of a tile.
		 * For colors; red = 0, orange = 1, blue = 2, yellow = 3, green = 4.
		 * For shapes; zero is a square, and one is a circle
		 */
		public void setRandomly()
		{
			Random rand = new Random();
			
			setColor((rand.nextInt(5)));
			setShape(rand.nextInt(2));
		}
		
		/**
		 * this function formats a string so that it outputs the numbers for shape and color
		 */
		public String toString()
		{
			return String.format("%d %d", color, shape);
		}
		
		
		/**
		 * this creates an initial shape and sets the color to red and shape to square
		 */
		public Tile() 
		{
			color = 0;
			shape = 0;
		}
		
		/**
		 * @param this function takes in an integer x for the color
		 * @param this function takes in an integer y for the shape
		 * this function sets the tile equal to the specified parameters
		 */
		public Tile(int x, int y) 
		{
			setColor(x);
			setShape(y);
		}
	}

