package dev.asor.univitatis.utils;

import org.junit.Test;

import dev.asor.univitatis.utils.PictureHandler;

public class PictureHandlerTest
{

    @Test
    public void testLoadImagemMascote()
    {
        String filename = "mascote-univates.jpg";
        
        PictureHandler picHandler = new PictureHandler();
        picHandler.resizeImage(442, 442, filename);
    }
    
    @Test
    public void testLoadImagemLogo()
    {
        String filename = "univates_logo.jpg";
        
        PictureHandler picHandler = new PictureHandler();
        picHandler.resizeImage(442, 442, filename);  
    }
}
