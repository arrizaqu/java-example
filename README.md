#Java Issue and More
##Java Cannot load any files @assets 
	- solution : add default servlet mapping with star. 
		<servlet-mapping>
			<servlet-name>default</servlet-name>
			<url-pattern>/assets/*</url-pattern>
		</servlet-mapping>

#Refference 
1. http://stackoverflow.com/questions/22965738/how-to-serve-static-files-in-my-web-application-on-tomcat