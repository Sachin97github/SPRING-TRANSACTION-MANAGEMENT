package com.nit.config;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistanceConfig {

	@Bean("oracleXAConfig")
	@ConfigurationProperties(prefix = "dtx.oradtx")
	public AtomikosDataSourceBean createOracleDataSource() {
		AtomikosDataSourceBean ds = null;
		ds = new AtomikosDataSourceBean();
		return ds;

	}

	@Bean("mysqlXAConfig")
	@ConfigurationProperties(prefix = "dtx.mysqldtx")
	public AtomikosDataSourceBean createMySqlDataSource() {
		AtomikosDataSourceBean ds = null;
		ds = new AtomikosDataSourceBean();
		return ds;
	}

	@Bean("oracleJt")
	public JdbcTemplate createOraJt() {
		return new JdbcTemplate(createOracleDataSource());
	}

	@Bean("mysqlJt")
	public JdbcTemplate createMysqlJt() {
		return new JdbcTemplate(createMySqlDataSource());
	}

}
