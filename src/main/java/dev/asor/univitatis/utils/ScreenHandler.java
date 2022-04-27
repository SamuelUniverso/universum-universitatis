package dev.asor.univitatis.utils;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

/**
 * Permite reconhecer as dimensoes do monitor
 * @class ScreenHandler
 * @author dev.asor
 * @since april.2022
 */
public class ScreenHandler
{
    private Dimension screenInfo;
    
    public ScreenHandler()
    {
        try
        {
            this.screenInfo = Toolkit.getDefaultToolkit().getScreenSize();
        }
        catch(HeadlessException e)
        {
            e.printStackTrace();
        }
    }
    
    private Dimension getScreenInfo()
    {
        return screenInfo;
    }
    
    public Integer getScreenWidth()
    {
        return (int) Math.round(getScreenInfo().getWidth());
    }
    
    public Integer getScreenHeight()
    {
        return (int) Math.round(getScreenInfo().getHeight());  
    }
}
