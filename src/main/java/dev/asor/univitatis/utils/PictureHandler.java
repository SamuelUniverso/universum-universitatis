package dev.asor.univitatis.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @class PictureHandler
 * @author dev.asor
 * @since april.2022
 */
public class PictureHandler
{
    private String resourcePath = "/images/";
    
    public ImageIcon getImageFileAsIcon(String filename)
    {
        try
        {
            InputStream file = PictureHandler.class.getResourceAsStream(getResourcePath()+filename);
            BufferedImage rawpic = ImageIO.read(file); 
            
            return new ImageIcon(rawpic);
        }
        catch (IOException e)
        {
            System.out.println("Erro ao carregar imagem");
            e.printStackTrace();
        }
        
        return null;  
    }
    
    /**
     * Faz o escalonamento da imagem
     * @method resizeImage
     * @param height
     * @param width
     * @param filename
     * @return
     */
    public Image resizeImage(Integer height, Integer width, String filename)
    {
        try
        {
            InputStream file = PictureHandler.class.getResourceAsStream(getResourcePath()+filename);
            BufferedImage rawpic = ImageIO.read(file); 
            
            Image scaled = rawpic.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            
            return scaled;
        }
        catch (IOException e)
        {
            System.out.println("Erro ao carregar imagem");
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * Faz o escalonamento da imagem
     * @method resizeImage
     * @param height
     * @param width
     * @param filename
     * @return ImageIcon
     */
    public ImageIcon resizeIcon(Integer height, Integer width, String filename)
    {
        Image scaled = this.resizeImage(height, width, filename);
        if(scaled != null)
        {
            return new ImageIcon(scaled);
        }
        
        return null;
    }
    
    private String getResourcePath()
    {
        return resourcePath;
    }
}
