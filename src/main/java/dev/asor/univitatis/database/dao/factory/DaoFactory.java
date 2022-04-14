package dev.asor.univitatis.database.dao.factory;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.AlunoDao;
import dev.asor.univitatis.database.dao.ProfessorDao;

/**
 * @class DaoFactory 
 * @author dev.asor
 * @since 13.april.2022
 */
public class DaoFactory 
{

    public static ProfessorDao newProfessorDao()
    {
        return new ProfessorDao(DatabaseConnector.getInstance());
    }
    
    public static AlunoDao newAlunoDao()
    {
        return new AlunoDao(DatabaseConnector.getInstance());
    }
}
