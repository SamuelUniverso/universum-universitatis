package dev.asor.univitatis.utils;

import org.junit.Test;

/**
 * @author dev.asor
 */
public class MD5HasherTest
{
    @Test
    public void testMd5Hashing()
    {
        MD5Hasher hasher = new MD5Hasher("admin");
        System.out.println(hasher.getHash());
    }
    
    @Test
    public void testMd5HashEquality()
    {
        MD5Hasher hasher = new MD5Hasher("admin");
        boolean equal = hasher.checkHashesEquality("21232f297a57a5a743894a0e4a801fc3");
        System.out.println(equal);
    }
}
