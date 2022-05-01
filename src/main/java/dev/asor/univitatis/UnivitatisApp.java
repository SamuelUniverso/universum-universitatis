package dev.asor.univitatis;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.utils.ScreenHandler;
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
     * Monta janela principal e exibe na telsa
	 */
	private static void starProgram(boolean showSplash, GuiModeConfig guiMode)
	{
	    ScreenHandler screen = new ScreenHandler();
	    
	    int width = screen.getScreenWidth();
	    int height = screen.getScreenHeight();
	    
	    if(showSplash)
	    {
	        new SplashInitializer(imagemMascote, (height / 2), (height / 2), 2500);
	    }
	    
		SwingUtilities.invokeLater(() -> {
		                                   configureLookAndFeel(guiMode);
		                                   buildMainWindowFrame(width, height); 
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
			else if(guiMode == GuiModeConfig.CROSS_PLATAFORM)
			{
			    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			}
			else if(guiMode == GuiModeConfig.SYSTEM_NATIVE)
			{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		}
		catch(  ClassNotFoundException 
		      | InstantiationException
		      | IllegalAccessException
		      | UnsupportedLookAndFeelException
		      | ClassCastException
		      | NullPointerException e )
		{
			e.printStackTrace();
		}
	}

	private static void buildMainWindowFrame(Integer width, Integer height)
	{
		try
		{
			PictureHandler picHandler = new PictureHandler();

			MainFrame2 frame = new MainFrame2(width, height);
			frame.setIconImage(picHandler.resizeImage(72, 72, imagemLogoUni));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize((width / 2), (int) (Math.round(height / 1.5)));
			frame.setLocationRelativeTo(null);
			frame.setResizable(true);
			frame.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
