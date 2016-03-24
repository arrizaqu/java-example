package com.jcg.dao;

import java.sql.SQLException;

import com.jcg.bean.Employee;

public interface EmployeeDao
{
		void save(Employee employee) throws SQLException;

		Employee findByPrimaryKey(long id) throws SQLException;
}
