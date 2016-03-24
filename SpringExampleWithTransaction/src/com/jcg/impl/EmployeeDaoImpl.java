package com.jcg.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jcg.bean.Employee;
import com.jcg.dao.EmployeeDao;

@Repository("EmployeeDaoImpl")
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDaoImpl implements EmployeeDao
{
		@PersistenceContext
		private EntityManager entityManager;


		@Override
		public void save(Employee employee)
		{
				entityManager.persist(employee);
		}

		@Override
		public Employee findByPrimaryKey(long id)
		{
				Employee employee = entityManager.find(Employee.class, id);

				return employee;
		}

		/**
		 * @return the entityManager
		 */
    public EntityManager getEntityManager()
    {
		    return entityManager;
    }

		/**
		 * @param entityManager the entityManager to set
		 */
    public void setEntityManager(EntityManager entityManager)
    {
		    this.entityManager = entityManager;
    }
}
