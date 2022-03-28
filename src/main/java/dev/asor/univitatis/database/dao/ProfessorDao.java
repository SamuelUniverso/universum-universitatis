package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.AlunoDaoHelper;
import dev.asor.univitatis.database.dao.helper.PessoaDaoHelper;
import dev.asor.univitatis.database.dao.helper.ProfessorDaoHelper;
import dev.asor.univitatis.database.dao.interfaces.CrudObjectInterface;
import dev.asor.univitatis.database.exceptions.AlunoException;
import dev.asor.univitatis.database.exceptions.GenericDaoException;
import dev.asor.univitatis.database.exceptions.PessoaException;
import dev.asor.univitatis.database.exceptions.ProfessorException;
import dev.asor.univitatis.database.exceptions.errors.AlunoExceptionMessages;
import dev.asor.univitatis.database.exceptions.errors.GenericErrors;
import dev.asor.univitatis.database.exceptions.errors.PessoaExceptionMessages;
import dev.asor.univitatis.database.exceptions.errors.ProfessorExceptionMessages;
import dev.asor.univitatis.model.Aluno;
import dev.asor.univitatis.model.Professor;

/**
 * @class ProfessorDao
 * @author dev.asor
 * @since 17.march.2022
 */
public class ProfessorDao extends GenericDao implements CrudObjectInterface<Professor>
{
    private final EntityEnum entity = EntityEnum.ALUNOS;
    
    public ProfessorDao(DatabaseConnector connector)
    {
        setConnector(connector);
    }

    @Override
    public void insert(Professor professor, Boolean rollback)
    {
        PessoaDao pessoaDao = new PessoaDao(getConnector()); /* passa conector do ProfessorDao para PessoaDao */
        
        try
        {
            if(professor.getPessoa() == null) /* Aluno precisa conter Pessoa */
            {
                throw new ProfessorException(ProfessorExceptionMessages.ERROR_PROFESSOR_NOT_DEFINED.getMessage());
            }
            pessoaDao.insert(professor.getPessoa(), rollback);
             
            String sql = ProfessorDaoHelper.createPreparedStatementProfessor();
            PreparedStatement statement = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            statement.setInt   (1, pessoaDao.getLastUsedId()); /* professor.fk_pessoa */
            statement.setString(2, professor.getMatriculaFuncionario());
            
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            try
            {
                getConnector().getConnection().rollback();
            }
            catch(SQLException e1)
            {
                e1.printStackTrace();
                throw new ProfessorException(GenericErrors.ERROR_ROLLBAK_CONNECTION.getMessage());
            }
        }
        finally 
        {
            try
            {
                if(!rollback)
                {
                    getConnector().getConnection().commit();
                }
                else
                {
                    getConnector().getConnection().rollback();
                }
                
                getConnector().getConnection().close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                throw new ProfessorException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
            }
        }
    }

    @Override
    public Professor fetchById(Integer id) 
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getNextId()
    {
        return super.getNextId(this.getEntity());
    }

    @Override
    public Integer getLastUsedId()
    {
        return super.getLastUsedId(this.getEntity());
    }

    @Override
    public EntityEnum getEntity()
    {
        return this.entity;
    }

   
}
