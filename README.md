#Json Parse As Return
1. Configuration
2. Example Code

##configuration.
	- RestController Annotation.
	- XML Configure in applicationContext
		1. Add Depedency Json for convert data object to json format
		2. Enable WebMVC
		3. Activate properti json @WebMVC.
		4. Activate JsonIgnore

##POM.XML : 	
	1. Add Depedency
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.4.3</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.4.3</version>
		</dependency>
		
##Application Context
		<mvc:annotation-driven>
			 <mvc:message-converters>
					<bean class="org.springframework.http.converter.StringHttpMessageConverter"/>
					<bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
		   </mvc:message-converters>
		</mvc:annotation-driven>
		
	3. Spring RestController example : 
		@RestController
		public class RestEmployee {
			@RequestMapping("/restdata")
			public Map<String, Object> index(){
				Map<String, Object> data = new HashMap<>();
				List<String> listString = new ArrayList<>();
				listString.add("masyda arrizaqu");
				listString.add("padang");
				listString.add("lampung");
				listString.add("palembang");
				
				data.put("name","masyda arrizaqu");
				data.put("email", "arrizaqu@yahoo.com");
				data.put("cities", listString);
				return data;
			}
		}

##Example Code with Rest Controller
	- code : 
		@RestController
		@RequestMapping("/employee")
		public class DataEmployee {

			@Autowired
			private EmployeeService employeeService;
			
			@RequestMapping(value = "/data", method = RequestMethod.GET)
			@ResponseStatus(HttpStatus.OK)
			public List<Employee> index(){
				
				return employeeService.findAll();
			}

			@RequestMapping(value="/insert", method = RequestMethod.POST)
			@ResponseStatus(HttpStatus.CREATED)
			public void insert(@RequestBody Employee employee){
				employeeService.save(employee);
			}
			
			@RequestMapping(value = "/delete/{id}", method= RequestMethod.DELETE )
			@ResponseStatus(HttpStatus.OK)
			public void delete(@PathVariable("id") int id, @RequestParam(value= "param", required = false) String param){
					employeeService.delete(id);
			}
		}
	