package dev.asor.univitatis;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dev.asor.univitatis.view.MainView;

/**
 * @calss UnivitatisApp
 * @author dev.asor
 * @since 23.february.2022
 */
public class UnivitatisApp 
{
	public static void main(String[] args) 
	{
		criarJanela();
	}
	
	/**
	 * Monta janela principal e exibe na tela
	 * @method criarJanela
	 * @return void
	 */
	public static void criarJanela()
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					File arquivo 
					    = new File(UnivitatisApp.class
					                            .getResource("/images/favicon/favicon_128x128.png")
					                            .getFile());
					
			        Image icone = ImageIO.read(arquivo);
			            
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
