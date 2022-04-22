package dev.asor.univitatis;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.github.weisj.darklaf.LafManager;

import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.view.gui.cardpanel.MainFrame;
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
	    starProgram(true);
	}
	
	/**
     * Monta janela principal e exibe na tela
     * @method starProgram
     * @param showSplash
     * @return void
	 */
	private static void starProgram(Boolean showSplash)
	{
	    if(showSplash)
	    {
	        new SplashInitializer(imagemMascote, 442, 442, 2500);
	    }
	    
		SwingUtilities.invokeLater(() -> 
		{
			try 
			{
			    //LafManager.install();
			    //LafManager.setDecorationsEnabled(true);
			    
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				PictureHandler picHandler = new PictureHandler();
				
				//FramePessoas frame = new FramePessoas(); //old
				MainFrame frame = new MainFrame();         //new
				
	            frame.setIconImage(picHandler.resizeImage(72, 72, imagemLogoUni));
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setLocationRelativeTo(null);
	            //frame.setResizable(true);
	            frame.setResizable(false);
				frame.setVisible(true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		});
	}
}
