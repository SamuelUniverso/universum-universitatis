package dev.asor.univitatis;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.view.MainView;
import dev.asor.univitatis.view.splash.SplashInitializer;

/**
 * @calss UnivitatisApp
 * @author dev.asor
 * @since february.2022
 */
public class UnivitatisApp 
{
	public static void main(String[] args) 
	{
	    new SplashInitializer(442, 442, 2500);
	    
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
					
					MainView frame = new MainView();
					
					PictureHandler picHandler = new PictureHandler();
		            frame.setIconImage(picHandler.resizeImage(128, 128, "favicon/favicon_128x128.png"));
		            
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
