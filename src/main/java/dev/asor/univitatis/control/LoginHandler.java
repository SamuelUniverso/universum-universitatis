package dev.asor.univitatis.control;

import java.security.InvalidParameterException;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.LdapDao;
import dev.asor.univitatis.model.Ldap;
import dev.asor.univitatis.utils.MD5Hasher;

/**
 * @author dev.asor
 * @since april.2022
 */
public class LoginHandler
{
    private String useruid;
    private String password;
    
    public LoginHandler(String useruid, String password)
    {
        if(useruid == null || password == null) {
            throw new InvalidParameterException();
        }
        setUseruid(useruid);
        setPassword(password);
    }
    
    public boolean isLoginAllowed()
    {
        try
        {
            LdapDao ldao = new LdapDao(DatabaseConnector.getInstance());
            Ldap ldap = ldao.fetchByUsername(getUseruid());
            
            MD5Hasher hasher = new MD5Hasher(getPassword());
            
            if(hasher == null || ldap == null) {
                return false;
            }
            return hasher.checkHashesEquality(ldap.getSenha());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }

    public String getUseruid()
    {
        return useruid;
    }
    private void setUseruid(String useruid)
    {
        this.useruid = useruid;
    }

    public String getPassword()
    {
        return password;
    }
    private void setPassword(String password)
    {
        this.password = password;
    }
}
