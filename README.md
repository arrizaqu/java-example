#Java Validation 

##Validation
1. JSR 303 
	- Add dependency hibernate validator.
	
2. JQUERY Validation
	- Rest
	- Controller

##JSR 303
	- Dependency :
		<dependency>
		    <groupId>org.hibernate</groupId>
		    <artifactId>hibernate-validator</artifactId>
		    <version>4.3.2.Final</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
		<dependency>
		    <groupId>javax.validation</groupId>
		    <artifactId>validation-api</artifactId>
		    <version>1.0.0.GA</version>
		</dependency>
		
	- example code 1:
		- Entity :
			@NotNull
			@NotEmpty
			@Size(min=3, max=10)
			private String name;
			@Email(message = "email not valid..!!")
			private String email;
			
		- controller : 
			public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult result){
				if(result.hasErrors()){
					return "employee";
				}
				
				return "redirect:/employee";
			}

		- view / JSP example : 
			<form:form action="${pageContext.request.contextPath}/employee/add" commandName="employee">
				<form:errors path="*" cssClass="error" />
				<form:input path="name" />
				<form:input path="email"/>
					<form:errors path="email" cssClass="error" />
				<input type="submit" name="submit">
			</form:form>
			
	
	- example code 2: 
	
##Reference 
1. http://docs.oracle.com/javaee/6/tutorial/doc/gircz.html
2. https://jqueryvalidation.org/