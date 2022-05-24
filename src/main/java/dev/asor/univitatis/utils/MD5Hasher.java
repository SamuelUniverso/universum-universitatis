package dev.asor.univitatis.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utilitarios para gerar Hashes MD5
 * 
 * @author dev.asor
 * @since april.2022
 */
public class MD5Hasher
{
    private final String MD5 = "MD5";
    
    private String stream;
    private String hash;
    
    private MessageDigest md = null;
    
    public MD5Hasher(String stream) 
    {
        try
        {
            setStream(stream);
            
            md = MessageDigest.getInstance(MD5);
            md.reset();
            md.update(stream.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest); // 1 for greater than 0 number
            String hased = bigInt.toString(16);
            
            setHash(hased);
        } 
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
    }

    public String getStream()
    {
        return stream;
    }
    private void setStream(String stream)
    {
        this.stream = stream;
    }
    
    public String getHash()
    {
        return hash;
    }
    private void setHash(String hash)
    {
        this.hash = hash;
    }
    
    /*
     * Verifica se o Hash gerado e equivalente ao parametrizado
     */
    public boolean checkHashesEquality(String hashToCompare)
    {
        return getHash().equals(hashToCompare) ? true : false;
    }
}
