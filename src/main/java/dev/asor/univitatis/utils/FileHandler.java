package dev.asor.univitatis.utils;

import java.io.File;
import java.io.IOException;

/**
 * @author dev.asor
 * @since april.2022
 */
public class FileHandler
{
    /**
     * Initializes empty file in the FileSystem
     * @param String filePath
     */
    public void createEmptyFile(String filePath)
    {
        try
        {
            File file = new File(filePath);
            file.createNewFile();
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
}
