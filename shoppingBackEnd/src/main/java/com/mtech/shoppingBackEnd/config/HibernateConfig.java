package com.mtech.shoppingBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.mtech.shoppingBackEnd.dto" })
@EnableTransactionManagement
public class HibernateConfig {
	public final static String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public final static String DATABASE_DRIVER = "oracle.jdbc.OracleDriver";
	public final static String DATABASE_DIALECT = "org.hibernate.dialect.Oracle10gDialect";
	public final static String DATABASE_USERNAME = "hr";
	public final static String DATABASE_PASSWORD = "m1234";

//	public final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/buyOnline";
//	public final static String DATABASE_DRIVER = "org.h2.Driver";
//	public final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
//	public final static String DATABASE_USERNAME = "sa";
//	public final static String DATABASE_PASSWORD = "";
//    @Autowired
//	DataSource dataSource;
    
	@Bean("DataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;
	}

	// SessionFactory will be Available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getgetHibernateProperties());
		builder.scanPackages("com.mtech.shoppingBackEnd.dto");
		return builder.buildSessionFactory();
	}

	// All the hibernate properties will be returned in this method
	public Properties getgetHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		//properties.put("hibernate.hbm2ddl.auto", "create");

		return properties;
	}

	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
