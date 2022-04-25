package dev.asor.univitatis;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.view.config.GuiModeConfig;
import dev.asor.univitatis.view.gui.cardpanel.MainFrame2;
import dev.asor.univitatis.view.gui.splash.SplashInitializer;

/**
 * @class UnivitatisApp
 * @author dev.asor
 * @since february.2022
 */
public class UnivitatisApp 
{
    private static final String imagemMascote = "mascote-univates.jpg";
    private static final String imagemLogoUni = "univates-logo.jpg";

	public static void main(String[] args) 
	{
	    starProgram(true, GuiModeConfig.LIGHT_MODE);
	}

	/**
     * Monta janela principal e exibe na tela
	 */
	private static void starProgram(boolean showSplash, GuiModeConfig guiMode)
	{
	    if(showSplash)
	    {
	        new SplashInitializer(imagemMascote, 442, 442, 2500);
	    }
	    
		SwingUtilities.invokeLater(() -> {
		                                   configureLookAndFeel(guiMode);
		                                   buildMainWindowFrame(); 
    				                      });
	}

	private static void configureLookAndFeel(GuiModeConfig guiMode)
	{
		try
		{
			if(guiMode == GuiModeConfig.DARK_MODE)
			{
				UIManager.setLookAndFeel(new FlatDarkFlatIJTheme());
			}
			else if(guiMode == GuiModeConfig.LIGHT_MODE)
			{
				UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
			}
			else
			{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void buildMainWindowFrame()
	{
		try
		{
			PictureHandler picHandler = new PictureHandler();

			MainFrame2 frame = new MainFrame2();
			frame.setIconImage(picHandler.resizeImage(72, 72, imagemLogoUni));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.pack();
			frame.setResizable(true);
			frame.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
