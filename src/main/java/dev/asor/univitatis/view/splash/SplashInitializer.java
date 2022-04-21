package dev.asor.univitatis.view.splash;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import dev.asor.univitatis.utils.PictureHandler;

/**
 * @class SplashInitializer
 * @author dev.asor
 * @since april.2022
 */
public class SplashInitializer
{
    private String splashBackgroundImagePath = "mascote-univates.jpg";
    private Integer splashDuartionMsec;
    
    private JWindow window = null;
    private JPanel panel = null;
    
    /**
     * @param width
     * @param height
     * @param durationMsec
     */
    public SplashInitializer(Integer width, Integer height, Integer durationMsec)
    {
        setSplashDuartion(durationMsec);
        
        showSplash(width, height);
        try
        {
            Thread.sleep(getSplashDuartion());
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        disposeSplash();
    }
    
    private void showSplash(Integer width, Integer height)
    {
        window = new JWindow();
        panel = new JPanel();
        
        
        PictureHandler picHandler = new PictureHandler();
        ImageIcon icon = picHandler.resizeIcon(width, height, splashBackgroundImagePath);

        JLabel labelSplash = new JLabel();
        labelSplash.setIcon(icon);
        labelSplash.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        panel.add(labelSplash);
        
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    private void disposeSplash()
    {
        this.window.setVisible(false);
    }
    
    private Integer getSplashDuartion()
    {
        return splashDuartionMsec;
    }
    private void setSplashDuartion(Integer duartion)
    {
        this.splashDuartionMsec = duartion;
    }
}