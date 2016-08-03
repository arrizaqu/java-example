#Java Issue and More
1. Java Cannot load any files @assets 
2. Generate Value with UUID

##Java Cannot load any files @assets 
	- solution : add default servlet mapping with star. 
		<servlet-mapping>
			<servlet-name>default</servlet-name>
			<url-pattern>/assets/*</url-pattern>
		</servlet-mapping>

##Generate Value with UUID
	- java code example : 
		@Id
		@GeneratedValue(generator="uuid")
		@GenericGenerator(name="uuid", strategy="uuid2")
		private String id;
	
#Refference 
1. http://stackoverflow.com/questions/22965738/how-to-serve-static-files-in-my-web-application-on-tomcat