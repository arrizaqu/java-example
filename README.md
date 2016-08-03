#Java Issue and More
1. Java Cannot load any files @assets 
2. Generate Value with UUID
3. Conflict port 8080 with Oracle 
4. Jetty Mortbay on maven pom configuration 

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

##Conflict port 8080 with Oracle
	- oracle sql :
		change port Oracle: 
        SQL> connect system@xe
        SQL> begin
          2  dbms_xdb.sethttpport('9090');
          3  end;
          4  /

##Jetty Mortbay on maven pom configuration 
	- code :
		<build>
			<plugins>
					<plugin>
						<groupId>org.mortbay.jetty</groupId>
						<artifactId>maven-jetty-plugin</artifactId>
						<version>6.1.10</version>
						<configuration>
							<scanIntervalSeconds>5</scanIntervalSeconds>
							<stopKey>foo</stopKey>
							<stopPort>9999</stopPort>
						</configuration>
						<executions>
							<execution>
								<id>start-jetty</id>
								<phase>pre-integration-test</phase>
								<goals>
									<goal>run</goal>
								</goals>
								<configuration>
									<scanIntervalSeconds>0</scanIntervalSeconds>
									<daemon>true</daemon>
								</configuration>
							</execution>
							<execution>
								<id>stop-jetty</id>
								<phase>post-integration-test</phase>
								<goals>
									<goal>stop</goal>
								</goals>
							</execution>
						</executions>
					</plugin>
				<!-- Build war -->
					<plugin>
						<artifactId>maven-war-plugin</artifactId>
						<groupId>org.apache.maven.plugins</groupId>
						<version>2.1.1</version>
					</plugin>
			</plugins>
		</build>

#Refference 
1. http://stackoverflow.com/questions/22965738/how-to-serve-static-files-in-my-web-application-on-tomcat