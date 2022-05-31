package dev.asor.univitatis.utils;

import java.text.ParseException;
import java.util.logging.Logger;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * @author dev.asor
 * @since may.2022
 */
public class InputMaskHandler
{
    public String removeMaskFromFormattedText(MaskFormatter mask, JFormattedTextField text)
    {
        try
        {
            text.commitEdit();
            
            return mask.stringToValue(text.getText()).toString();
        } 
        catch (ParseException e)
        {
            Logger.getLogger(InputMaskHandler.class.getName());
        }
        
        return null;
    }
}
