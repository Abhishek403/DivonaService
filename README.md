DivonaService
================================
*Service for managing resources and core business operation of reCycle.*

###Prerequisites
* **Gradle** - Our build manager. [Download here](http://gradle.org/downloads)

###Framework
* Mapsys uses [Dropwizard framework](http://dropwizard.codahale.com/).
* Dependency injection was achieved with [Google Guice](https://code.google.com/p/google-guice/).


###IDE Integration

* `gradle eclipse` - To generate Eclipse project structure.
* `gradle idea` - To generate Intellij IDEA project structure.

###Lifecycle

* `gradle clean` - Cleans the build directory and JARs.
* `gradle assemble` - Compiles and creates JAR, doesn't run tests.
* `gradle test` - Runs tests.
* `gradle build` - Compiles, tests and creates JAR.
* `gradle shadow` - Creates a fat JAR with all dependencies included.
* `gradle run` - Starts the server on the default port 30306, logs to /logs.
* `java -jar <jar_location> server mapsys.yml` - Run standalone.


###Swagger Integration
* Swagger provides excellent interactive API documentation.
* The interface will be hosted on `http://localhost:30306/swagger
