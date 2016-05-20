##Ajax-Json di Java Spring Controller.

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
		//untuk html.
		<input type="text" name="search" id="search" />
			<script type="text/javascript">
			
			// untuk jquery event listener.
			$(document).ready(function(){
				element = $('#search');
				element.on('keyup', function(){
					data = element.val();
					$.ajax({
						type:'GET',
						header:{
							Accept: "application/json; charset=utf-8",
							"Content-Type":"application/json; charset=utf-8",
						},
						url:'${pageContext.request.contextPath}/ajax/'+data,
						success:function(data){
							console.log(data);
							nama = data.name;
							email = data.email;
							alert(nama);
							alert(email)
						},
						dataType: 'json'
					});
				});
			});
		</script>
		
#Java Spring Controller
	* code : 
		@Controller
		public class testController {

			@RequestMapping(value ="/ajax/{noref}",produces = "application/json")
			public @ResponseBody String index(@PathVariable(value="noref") String noref, Model model){
				
				ObjectMapper mapper = new ObjectMapper();
				//jika diperlukan untuk fileter
				//String data = noref;
				
				// example jika menghasilkan data single
				List<User> data = new ArrayList();
				User user = new User();
				user.setName("arrizaqu");
				user.setEmail("example@xml.com");
				user.setPassword("fasdfasdf");
				
				// contoh jika menghasilkan data lebih daripada satu
				String myreturn = null;
				try{
					//untuk data yang menghasilkan single.
					myreturn = mapper.writeValueAsString(user);
					
					//untuk data yang menghasiilkan banyak.
					/*
					List<User> ct= new ArrayList<>();
					User users1 = new User();
					users1.setName("arrizaqu");
					users1.setEmail("example@xml1.com");
					users1.setPassword("fasdfasdf");
					
					User users2 = new User();
					users2.setName("arrizaqu2");
					users2.setEmail("example@xml2.com");
					users2.setPassword("fasdfasdf");
					
					User users3 = new User();
					users3.setName("arrizaqu3");
					users3.setEmail("example@xml3.com");
					users3.setPassword("fasdfasdf");
					
					ct.add(users1);
					ct.add(users2);
					ct.add(users3);
					
					myreturn = mapper.writeValueAsString(ct);
					*/
				}catch(Exception e){}
				
				return   myreturn;
			}
		}
	
## good luck..!!!
