#Java Issue and More
##Java Cannot load any files @assets 
	- solution : add default servlet mapping with star. 
		<servlet-mapping>
			<servlet-name>default</servlet-name>
			<url-pattern>/assets/*</url-pattern>
		</servlet-mapping>