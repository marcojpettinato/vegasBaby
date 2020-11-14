package vegasBaby;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class TilePanel extends JPanel implements MouseListener, MouseMotionListener 
{
	
	//Integers
	private static int color; 
	private static int shape;
	private static int count = 4;
	private int x;
	private int y;
	
	//Tile
	private static Tile tile = new Tile();
	
	//ArrayList
	private static ArrayList <Tile> tiles = new ArrayList<Tile>();
	public static ArrayList <Integer> colors = new ArrayList<Integer>(Collections.nCopies(5, 0));
	public static ArrayList <Integer> shapes = new ArrayList<Integer>(Collections.nCopies(5, 0));
	
	
	public TilePanel() 
	{
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public ArrayList<Tile> getTiles() 
	{
		return tiles;
	}
	
	public void setTiles(ArrayList<Tile> listOfTiles) 
	{
		tiles = listOfTiles;
	}

	/**
	 *  fill an arrayList of tiles and array lists of shapes and colors
	 */
	public static void setTileArray()
	{
		for(int i =0; i < count; i++)
		{
			tile.setRandomly();
			
			color = tile.getColor();
			colors.set(i,color);
			
			shape = tile.getShape();
			shapes.set(i,shape);
			
			Tile placeHolder = new Tile(color,shape);
			
			tiles.add(i, placeHolder);
		}
		count = 0;
	}
	
	
	@Override
	/**
	 * @param this function takes an graphic value to allow the program to create the shapes using graphics
	 * this function uses the randomly generated values for the shapes and creates a panel of them
	 */
	public void paintComponent(Graphics g) 
	{
		//red = 0
		//orange = 1
		//blue = 2
		//yellow = 3
		//green = 4
	

		//Zero-Square
		//One - Circle
		
		super.paintComponent(g);
		while(count < 4)
		{	
			if(colors.get(count) == 0)
			{
				g.setColor(Color.RED);
			}
			
			else if(colors.get(count) == 1)
			{
				g.setColor(Color.ORANGE);
			}
			
			else if(colors.get(count) == 2)
			{
				g.setColor(Color.BLUE);
			}
			
			else if(colors.get(count) == 3)
			{
				g.setColor(Color.YELLOW);
			}
			
			else if(colors.get(count) == 4)
			{
				g.setColor(Color.GREEN);
			}
			
			if(shapes.get(count) == 0)
			{
				g.fillRect((count*250)+25, 100, 200, 200);
			}
			
			else if(shapes.get(count) == 1)
			{
				g.fillOval((count*250)+25, 100, 200, 200);
			}
			count ++;
		}
		count = 0;
	}


	@Override
	public void mouseDragged(MouseEvent e) 
	{

	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{

	}

	@Override
	/**
	 * @param this function takes an mouse event to allow the user to use the mouse in a way
	 * this function allows the user to change a shape by clicking on it
	 */
	public void mouseClicked(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
		int tileNum = -1;
		boolean clicked = true;
		
		while(clicked)
		{
			if((x >= ((count*250)+25) && x<= (((count+10)*9)*25))  && (y>= 100 && y<=300))
			{
				if( (x>= 25 && x<= 225) && (y>= 100 && y<=300))
				{
					tileNum=0;
				}
				
				else if((x>= 275 && x<= 475) && (y>= 100 && y<=300))
				{
					tileNum=1;
				}
				
				else if((x>= 525 && x<= 725) && (y>= 100 && y<=300))
				{
					tileNum=2;
				}
				
				else if((x>= 775 && x<= 975) && (y>= 100 && y<=300))
				{
					tileNum=3;
				}
				
				tile.setRandomly();
				color = tile.getColor();
				colors.set(tileNum,color);
				shape = tile.getShape();
				shapes.set(tileNum,shape);
				repaint();
				clicked = false;
			}
			count++;
		}
		count=0;
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{

	}

	@Override
	public void mousePressed(MouseEvent e) 
	{

	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{

	}
}

	
