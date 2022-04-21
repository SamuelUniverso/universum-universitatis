package dev.asor.univitatis;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.view.MainView;
import dev.asor.univitatis.view.gui.splash.SplashInitializer;

/**
 * @calss UnivitatisApp
 * @author dev.asor
 * @since february.2022
 */
public class UnivitatisApp 
{
    private static String imagemMascote = "mascote-univates.jpg";
    private static String imagemLogoUni = "univates_logo.jpg";
    
	public static void main(String[] args) 
	{
	    new SplashInitializer(imagemMascote, 442, 442, 2500);
	    
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
					PictureHandler picHandler = new PictureHandler();
					
					MainView frame = new MainView();
					
		            frame.setIconImage(picHandler.resizeImage(128, 128, imagemLogoUni));
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
