##Java web starter with maven

- create pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.javaweb</groupId>
	<artifactId>build-web-app</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>web-application</name>
	<description>my web myapplication</description>
</project>

note : 
- create src/main/{java, webapp}
- run : mvn clean tomcat:run
- if you see comflict with oracle port can chage with plsql like this : 
SQL> connect system@xe
SQL> begin
  2  dbms_xdb.sethttpport('9090');
  3  end;
  4  /
  
## full Spring boot xml POM Configuration
	code : 
		<?xml version="1.0" encoding="UTF-8"?>
			<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
				<modelVersion>4.0.0</modelVersion>
				<groupId>com.javaweb</groupId>
				<artifactId>build-web-app</artifactId>
				<version>0.0.1-SNAPSHOT</version>
				<packaging>war</packaging>
				<name>web-application</name>
				<description>my web myapplication</description>
				   
					<parent>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-parent</artifactId>
					<version>1.3.5.RELEASE</version>
					<relativePath/> <!-- lookup parent from repository -->
				</parent>
					
					<dependencies>
					<dependency>
						<groupId>org.springframework.boot</groupId>
						<artifactId>spring-boot-starter-data-jpa</artifactId>
					</dependency>
					
					<dependency>
						<groupId>org.springframework.boot</groupId>
						<artifactId>spring-boot-starter-test</artifactId>
						<scope>test</scope>
					</dependency>
				</dependencies>
				   
					 <build>
						<plugins>
						  <plugin>
							<groupId>org.apache.maven.plugins</groupId>
							<artifactId>maven-war-plugin</artifactId>
							<configuration>
							  <failOnMissingWebXml>false</failOnMissingWebXml>
							</configuration>
						  </plugin>
						</plugins>
					  </build>
					
			</project>

