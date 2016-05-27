##Send Js Object to Spring Controller with JSON jackson mapper.

#library : 
	* Maven : 
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-mapper-asl</artifactId>
			<version>1.9.13</version>
		</dependency>
		
	* Manual (download)
		- http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.7.4/jackson-core-2.7.4.jar
		- http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.7.4/jackson-databind-2.7.4.jar
		- http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.7.4/jackson-annotations-2.7.4.jar
		
#Javascript :  
	* code : 
	
		var userlogin = {
			username: "masyda arrizaqu",
			password: "jum'ata afsdf#$%^&*()"
		};
	
		var userToSubscribe = {
			username: "newuser",
			password: "newpassword",
			email: "user@1and1.es"
		};

		var openid = "myopenid";
		$.ajax({
			type:'POST',
			url:'/ajax/',
			//dataType: 'json',
			contentType: 'application/json',
		   data: JSON.stringify(
				   {  userlogin: userlogin, 
					   userToSubscribe: userToSubscribe, 
					   openid: openid 
					}), 
			success:function(data){
				console.log(data);
			}
		});

#Java Spring Controller
	* code : 
		@Controller
		public class testController{

			@RequestMapping(value ="/ajax/", method = RequestMethod.POST/*, consumes="application/json",headers = "content-type=application/x-www-form-urlencoded"*/)
			public @ResponseBody String index(@RequestBody String employee, Model model){
				ObjectMapper mapper = new ObjectMapper();
				try{
					//jika hanya single entity
					JsonNode node = mapper.readTree(employee);
					UserLogin userLogin = mapper.convertValue(node.get("userlogin"), UserLogin.class);
						System.out.println("name : "+ userLogin.getUsername());
						System.out.println("password : "+ userLogin.getPassword());
				} catch(Exception e){
					e.printStackTrace();
				}
				
				return  "successfully loaded..!!";
			}
		}

		class UserLogin{
			public String username;
			public String password;
			
			public void setPassword(String password) {
				this.password = password;
			}
			
			public void setUsername(String username) {
				this.username = username;
			}
			
			public String getPassword() {
				return password;
			}
			
			public String getUsername() {
				return username;
			}
		}
		
#Reference
http://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects
http://stackoverflow.com/questions/19654120/problems-sending-multiple-objects-through-post-and-spring-mvc

