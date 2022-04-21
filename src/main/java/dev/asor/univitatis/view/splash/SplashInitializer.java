package dev.asor.univitatis.view.splash;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
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
    private Integer splashDuartionMsec;
    
    private JWindow window = null;
    private JPanel panel = null;
    private JProgressBar pbar = null;
    
    /**
     * @param width
     * @param height
     * @param durationMsec
     */
    public SplashInitializer(String imageFileName, Integer width, Integer height, Integer durationMsec)
    {
        setSplashDuartion(durationMsec);
        
        showSplash(imageFileName, width, height);
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
    
    private void showSplash(String imageFileName, Integer width, Integer height)
    {
        window = new JWindow();
        panel = new JPanel();
        pbar = new JProgressBar();
        
        PictureHandler picHandler = new PictureHandler();
        ImageIcon icon = picHandler.resizeIcon(width, height, imageFileName);

        JLabel labelSplash = new JLabel();
        labelSplash.setIcon(icon);
        labelSplash.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelSplash);
        
        JPanel progressPanel = new JPanel();
        
        progressPanel.add(pbar, BorderLayout.PAGE_START);
        panel.add(progressPanel);
        
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
