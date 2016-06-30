#Java HTTP Request
1. Add Depedency HttpComponent 
	- HttpClient
	- HttpClient Cache
	- HttpMime
	- Fluent HC
	
2. Add Depedency JsonObject & JsonArray
	- JSON Object

3. JSONObject / JSONArray example 


##Add Depedency HttpComponent 
	- maven : 
		<!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime -->
		<dependency>
		  <groupId>org.apache.httpcomponents</groupId>
		  <artifactId>httpclient</artifactId>
		  <version>4.5.2</version>
		</dependency>
		<dependency>
		  <groupId>org.apache.httpcomponents</groupId>
		  <artifactId>httpclient-cache</artifactId>
		  <version>4.5.2</version>
		</dependency>
		<dependency>
		  <groupId>org.apache.httpcomponents</groupId>
		  <artifactId>httpmime</artifactId>
		  <version>4.5.2</version>
		</dependency>
		<dependency>
		  <groupId>org.apache.httpcomponents</groupId>
		  <artifactId>fluent-hc</artifactId>
		  <version>4.5.2</version>
		</dependency>
	
## Add Depedency JsonObject & JsonArray
	- code : 
		<dependency>
		    <groupId>org.json</groupId>
		    <artifactId>json</artifactId>
		    <version>20151123</version>
		</dependency>
	
## JSONObject / JSONArray example 
	- code : 
		HttpGet httpGet = new HttpGet("http://localhost:8080/web_apps/trus");
		 try {
	            HttpResponse response = httpClient.execute(httpGet);
	            // write response to log
	            HttpEntity entity = response.getEntity();
	            String data = EntityUtils.toString(entity, "UTF-8");
	          
	            JSONArray dJson = new JSONArray(data);
	            for(int i =0; i < dJson.length(); i++){
	            	JSONObject myObj = dJson.getJSONObject(i);
	            	String email = myObj.getString("email");
	            	System.out.println("email : "+ email);
	           }
	            
	        } catch (Exception e) {
	            // Log exception
	            e.printStackTrace();
	        }
		
##Referency
1. https://hc.apache.org/httpcomponents-client-ga/download.html
