package dev.asor.univitatis.database.connector.interfaces;

import java.sql.Connection;

/**
 * @interface ConectorBancoInterface
 * @author dev.asor
 * @since 17.march.2022
 */
public interface DatabaseConnectorInterace
{
	Connection getConnection();
	
	void closeConnection();
}
