package ua.nure.kn.bocharova.usermanagement1.DB;

import java.sql.Connection;

public interface ConnectionFactory {
	Connection createConnection() throws DatabaseException;

}
