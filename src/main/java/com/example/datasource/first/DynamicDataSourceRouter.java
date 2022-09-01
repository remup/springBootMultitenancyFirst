package com.example.datasource.first;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Service
public class DynamicDataSourceRouter extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl{

	
	
	
	
	protected DataSource selectAnyDataSource() {

		try {
			return  MasterService.getDataSourceHashMap().get("SQL");
		} catch (SQLException e) {
			
			return null;
		}
	}

	public DynamicDataSourceRouter() {
		
		
	}

	protected DataSource selectDataSource(String tenantIdentifier) {
		
		try {
			return  MasterService.getDataSourceHashMap().get(tenantIdentifier);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	


}
