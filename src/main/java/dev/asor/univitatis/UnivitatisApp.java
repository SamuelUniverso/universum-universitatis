package dev.asor.univitatis;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

import dev.asor.univitatis.utils.PictureHandler;
import dev.asor.univitatis.utils.ScreenHandler;
import dev.asor.univitatis.view.config.enums.GuiModeConfig;
import dev.asor.univitatis.view.gui.cardpanel.MainWindow;
import dev.asor.univitatis.view.gui.login.LoginScreen;
import dev.asor.univitatis.view.gui.splash.SplashInitializer;

/**
 * @class UnivitatisApp
 * @author dev.asor
 * @since february.2022
 */
public class UnivitatisApp 
{
    private static final String imagemMascote = "mascote-talini.jpg";
    private static final String imagemLogoUni = "univates-logo.jpg";
    
    private static GuiModeConfig guiMode;
    private static int width;
    private static int height;
    
	public static void main(String[] args) 
	{
	    starProgram(true, GuiModeConfig.DRACULA);
	}

	/**
     * Monta janela principal e exibe na tela
	 */
	private static void starProgram(boolean showSplash, GuiModeConfig guiMode)
	{
	    ScreenHandler screen = new ScreenHandler();

	    UnivitatisApp.guiMode = guiMode;
	    UnivitatisApp.width = screen.getScreenWidth();
	    UnivitatisApp.height = screen.getScreenHeight();
	    
	    if(showSplash) {
	        new SplashInitializer(imagemMascote, (height / 2), (height / 2), 2500);
	    }
	    
	    configureLookAndFeel(guiMode);

	    /**
	     * Invocando tela de login
	     */
	    new LoginScreen();
	}
	
	public static void afterLogin()
	{
	    SwingUtilities.invokeLater(() -> {
            configureLookAndFeel(UnivitatisApp.guiMode);
            buildMainWindowFrame(UnivitatisApp.width, UnivitatisApp.height); 
        });
	}

	/**
 	 * Configura estetica da UI
 	 * @method configureLookAndFeel
	 */
	private static void configureLookAndFeel(GuiModeConfig guiMode)
	{
		try
		{
		    /* Modifica fonte Global para Segoe UI */
		    UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Segoe UI", Font.PLAIN, 12));
		    
			if(guiMode == GuiModeConfig.DARK_MODE)
			{
				UIManager.setLookAndFeel(new FlatDarkFlatIJTheme());
			}
			else if(guiMode == GuiModeConfig.LIGHT_MODE)
			{
				UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
			}
			else if(guiMode == GuiModeConfig.DRACULA)
            {
                UIManager.setLookAndFeel(new FlatDraculaIJTheme());
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

			MainWindow frame = new MainWindow(width, height);
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
