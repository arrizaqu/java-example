#Json Parse As Return

##Rest with json return.
	- RestController Annotation.
	- XML Configure in applicationContext
		1. Add Depedency Json for convert data object to json format
		2. Enable WebMVC
		3. Activate properti json @WebMVC.
		4. Spring RestController example :  

##code : 	
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
		
	2. 2 and 3 code 
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
