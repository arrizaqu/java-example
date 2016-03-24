package com.jcg;


import java.sql.SQLException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jcg.bean.Employee;
import com.jcg.dao.EmployeeDao;


public class SpringDataDemo
{
		public static void main(String[] args)
		{
				try
				{
						ApplicationContext context = new ClassPathXmlApplicationContext("resources\\spring-configuration.xml");

						//Fetch the DAO from Spring Bean Factory
						EmployeeDao employeeDao = (EmployeeDao)context.getBean("EmployeeDaoImpl");
						Employee employee = new Employee("Employee123");
						//employee.setEmployeeId("1");

						//Save an employee Object using the configured Data source
						employeeDao.save(employee);
						System.out.println("Employee Saved with EmployeeId "+employee.getEmployeeId());

						//find an object using Primary Key
						Employee emp = employeeDao.findByPrimaryKey(employee.getEmployeeId());
						System.out.println(emp);

						//Close the ApplicationContext
						((ConfigurableApplicationContext)context).close();

				}
				catch (BeansException | SQLException e)
				{
						e.printStackTrace();
				}
		}
}
