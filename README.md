README
---


Introduction
-- 
This program has been designed to the specification as requested in the "Dev Tech test.pdf" (pdf 
also included in the zip file).


Summary:
--
This project has been created using Maven. Eclipse project has also been created using Maven plug-in.


* Proxy settings:
--
As the application making external calls. Ensure proxy is setup if run inside a closed network.

* How to run the test (From the command-line type:)
-- 
$mvn test

* How to run the app
--
$mvn exec:java

* Dependencies
--
Dependencies are listed in the pom.xml however I am going to list them here as well:
** org.jsoup 1.8.3
** junit 4.11
** json-api 1.0
** glassfish 1.0.4 (json implementation)	
** powermock 1.5.1	

When running for the first time, Maven will download all the dependencies.
The assumption here is that the machine running this application will have Maven setup.
