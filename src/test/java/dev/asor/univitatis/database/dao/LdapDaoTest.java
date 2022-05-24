package dev.asor.univitatis.database.dao;

import org.junit.Test;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.model.Ldap;

public class LdapDaoTest
{
    @Test
    public void fetchLdapById()
    {
        LdapDao dao = new LdapDao(DatabaseConnector.getInstance());
        
        Ldap ldap = dao.fetchById(1);
        System.out.print(ldap);
    }
    
    @Test
    public void fetchLdapByUsername()
    {
        LdapDao dao = new LdapDao(DatabaseConnector.getInstance());
        
        Ldap ldap = dao.fetchByUsername("admin");
        System.out.print(ldap);
    }
}
