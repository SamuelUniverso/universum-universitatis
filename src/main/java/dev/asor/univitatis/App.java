package dev.asor.univitatis;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dev.asor.univitatis.view.MainView;

/**
 * @author dev.asor
 * @since 23.feb.2022
 */
public class App 
{
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        Image icone = ImageIO.read(new File(App.class.getResource("/images/favicon/favicon_128x128.png").getFile()));
			            
					MainView frame = new MainView();
		            frame.setIconImage(icone);
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
