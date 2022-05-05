package dev.asor.univitatis.view;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;

/**
 * @author dev.asor
 * @since april.2022
 */
public class GlobalFontChanger
{
    /**
     * Modificar globalmente fonte da UI Swing  
     * @method setGlobalFont
     */
    public static void setGlobalFont(Font font) 
    {  
        Enumeration<?> keys = UIManager.getDefaults().keys();  
        while (keys.hasMoreElements()) 
        {  
            Object key = keys.nextElement();  
            Object value = UIManager.get(key);  
            if (value instanceof Font) 
            {  
                UIManager.put(key, font);  
            }  
        }  
    }  
}
