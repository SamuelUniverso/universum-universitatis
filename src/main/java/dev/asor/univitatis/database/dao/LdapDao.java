package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.messages.exceptions.dao.AlunoException;
import dev.asor.univitatis.messages.exceptions.dao.errors.AlunoExceptionMessages;
import dev.asor.univitatis.messages.exceptions.dao.errors.GenericErrors;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Ldap;
import dev.asor.univitatis.model.Pessoa;

public class LdapDao extends GenericDao implements CrudObjectInterface<Ldap>
{
    
    public LdapDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }

    @Override
    public void insert(Ldap object)
    {
        // TODO
    }

    @Override
    public Ldap fetchById(Integer id)
    {   
        Ldap ldap = null;
        try
        {
            if(id == null)
            {
                throw new IllegalArgumentException();
            }
            
            //String sql = LdapDaoHelper.createPreparedStatementSelectLdap(false);
            String sql = "SELECT id,usuario,senha FROM ldap WHERE id = ?1"; 
            PreparedStatement statement = getConnector().getConnection().prepareStatement(sql);
            
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                ldap = new Ldap(result.getInt(1));
                ldap.setUsuario(result.getString(2));
                ldap.setSenha(result.getString(3));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             try
             {
                 getConnector().getConnection().close();
             }
             catch(SQLException e)
             {
                 e.printStackTrace();
             }
        }
        
        return ldap;
    }

    @Override
    public Integer getNextId()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getLastUsedId()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EntityEnum getEntity()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Ldap> fetchAll()
    {
        // TODO Auto-generated method stub
        return null;
    }


}
