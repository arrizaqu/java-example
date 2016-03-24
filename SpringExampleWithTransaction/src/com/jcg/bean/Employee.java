package com.jcg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee
{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "employee_id")
		private long employeeId;

		@Column(name="employee_name")
		private String employeeName;

		public Employee()
    {
    }

		public Employee(String employeeName)
		{
				this.employeeName = employeeName;
		}

		public long getEmployeeId()
		{
				return this.employeeId;
		}

		public void setEmployeeId(long employeeId)
		{
				this.employeeId = employeeId;
		}

		public String getEmployeeName()
		{
				return this.employeeName;
		}

		public void setEmployeeName(String employeeName)
		{
				this.employeeName = employeeName;
		}


		@Override
    public String toString()
    {
		    return "Employee [employeeId=" + this.employeeId + ", employeeName=" + this.employeeName + "]";
    }
}
