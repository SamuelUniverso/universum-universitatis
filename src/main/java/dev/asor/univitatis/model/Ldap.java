package dev.asor.univitatis.model;

import dev.asor.univitatis.model.interfaces.DatabaseObjectInterface;

/**
 * @author dev.asor
 * @since april.2022
 */
public class Ldap implements DatabaseObjectInterface<Ldap>
{
    private Integer id;
    private String usuario;
    private String senha;
    
    public Ldap() {}
    
    public Ldap(Integer id)
    {
        setId(id);
    }
    public Ldap(Ldap ldap)
    {
        setId(ldap.getId());
    }
    
    
    public Integer getId()
    {
        return id;
    }
    private void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    @Override
    public Ldap getObject()
    {
        if (getId() != null)
        {
            return new Ldap();
        } 
        else
        {
            return this;
        }
    }
}
