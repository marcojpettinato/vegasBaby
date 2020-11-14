package vegasBaby;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SlotMachineFrame extends JFrame 
{
	private TilePanel pan;
	
	/**
	 * @param this function takes an integer value to represent the desired width of the frame.
	 * @param this function takes an integer value to represent the desired height of the frame.
	 * this function takes the input values and creates a frame that size centered in the screen of the machine using it.
	 */
	public void centerFrame(int width, int height)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDim = tk.getScreenSize();
		int screenWidth = (int) screenDim.getWidth();
		int screenHeight = (int) screenDim.getHeight();
		
		int left = (screenWidth - width)/2;
		int top = (screenHeight - height)/2;
		setBounds(left,top,width,height);
		TilePanel.setTileArray();
	}
	
	/**
	 * this function sets of the contents and takes in the users input and displays a pumpkin on the running of the program
	 */
	public void setupMenu()
	{
		//create a menu
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		
		//Create drop down items with options that perform actions
		JMenuItem miLoad = new JMenuItem("Load Tiles");
		miLoad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser jfc = new JFileChooser();
				TileReader tr;
				ArrayList<Tile> tilesRead;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tr = new TileReader();
					tilesRead = tr.read(jfc.getSelectedFile());
					if (tilesRead == null) 
					{
						JOptionPane.showMessageDialog(null,"Could not read.");
					} 
					else 
					{
						pan.setTiles(tilesRead);
						for(int i = 0; i < tilesRead.size(); i++)
						{
							int color = tilesRead.get(i).getColor();
							TilePanel.colors.set(i,color);
							int shape = tilesRead.get(i).getShape();
							TilePanel.shapes.set(i, shape);
						}
						repaint();
					}
				}
			}
		});
		
		JMenuItem miSave = new JMenuItem("Save Tiles");
		miSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser jfc = new JFileChooser();
				TileWriter tw;
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
				{
					tw = new TileWriter();
					if (TileWriter.write(jfc.getSelectedFile(),pan.getTiles())) 
					{
						JOptionPane.showMessageDialog(null,"Tiles were written.");
					} 
					else 
					{
						JOptionPane.showMessageDialog(null,"Tiles could not be written.");
					}
				}
			}
		});
		
		JMenuItem miPrint = new JMenuItem("Print");
		miPrint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		//Add to the menu bar
		mnuFile.add(miLoad);
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		
		//Add help tab to the menu bar
		JMenu mnuHelp = new JMenu("About");
		JMenuItem miHelp = new JMenuItem("Help");
		miHelp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "My Name: Marco Pettinato. Github Link: https://github.com/marcojpettinato/firstname_lastname");
			}
		});
		
		//Add help tab
		mnuHelp.add(miHelp);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	
	
	/**
	 * 
	 * this function sets of the contents and takes in the users input and displays a pumpkin on the running of the program
	 */
	public void setupLook() 
	{
		//Create Initial Frame
		centerFrame(1025,500);
		setTitle("Vegas Baby Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new TilePanel();
		c.add(pan,BorderLayout.CENTER);
		//c.add(panCenter,BorderLayout.CENTER);
		
		//Set the option boxes
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		
		JButton btnMax = new JButton("Max");
		btnMax.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
		
				} 
				catch (Exception ex) 
				{
					JOptionPane.showMessageDialog(null,"The window dimmensions must be integers.");
				}
				repaint(); 
				// repaints the entire window's contents. For example, 
				//panCenter will be repainted --> paintComponent for TextPanel
				//will be automatically called.
			}
		}	
		);
		panSouth.add(btnMax);
		c.add(panSouth,BorderLayout.SOUTH);
	
		JButton btnMid = new JButton("Mid");
		btnMid.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
		
				} 
				catch (Exception ex) 
				{
					JOptionPane.showMessageDialog(null,"The window dimmensions must be integers.");
				}
				repaint(); 
				// repaints the entire window's contents. For example, 
				//panCenter will be repainted --> paintComponent for TextPanel
				//will be automatically called.
			}
		}	
		);
		panSouth.add(btnMid);
		c.add(panSouth,BorderLayout.SOUTH);
		
		JButton btnMin = new JButton("Min");
		btnMin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
		
				} 
				catch (Exception ex) 
				{
					JOptionPane.showMessageDialog(null,"The window dimmensions must be integers.");
				}
				repaint(); 
				// repaints the entire window's contents. For example, 
				//panCenter will be repainted --> paintComponent for TextPanel
				//will be automatically called.
			}
		}	
		);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		
	
		JLabel lblHeight = new JLabel("$:");
		panSouth.add(lblHeight);
		JTextField txtHeight = new JTextField(5);
		panSouth.add(txtHeight);
		setupMenu();
	}

	/**
	 * this creates the frame for the slot machine
	 */
	public SlotMachineFrame() 
	{
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
