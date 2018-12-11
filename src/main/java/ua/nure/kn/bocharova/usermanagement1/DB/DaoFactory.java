package ua.nure.kn.bocharova.usermanagement1.DB;

import java.io.IOException;
import java.util.Properties;

public abstract class DaoFactory {
	private static final String DAO_FACTORY = "dao.Factory";
	protected static final String USER_DAO = "dao.ua.nure.kn.bocharova.usermanagement1.UserDao";
	protected static Properties properties;
	
	
	
	private  static DaoFactory instance;
	
	static {
		properties= new Properties();
		try {
			properties.load(DaoFactory.class.getClassLoader().getResourceAsStream("settings.properties"));
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public static synchronized DaoFactory getInstance() {
		if(instance==null) {
			Class<?> factoryClass;
			try {
				factoryClass= Class.forName(properties.getProperty(DAO_FACTORY));
				instance=(DaoFactory)factoryClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	   return instance;
	}
	
	protected DaoFactory() {
		//constructor deleted
		
		
	}
	
	protected ConnectionFactory getConnectionFactory() {
		
		return new ConnectionFactoryImplementation(properties);
	}

	public abstract UserDAO getUserDao();
	
	public static void init(Properties prop) {
		properties=prop;
		instance=null;
	}
	
}
