# with maven
Maven will manage the full development life cycle for you: 
* validate - validate the project is correct and all necessary information is available
* compile - compile the source code of the project
* test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
* package - take the compiled code and package it in its distributable format, such as a JAR.
* verify - run any checks on results of integration tests to ensure quality criteria are met
* install - install the package into the local repository, for use as a dependency in other projects locally
* deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects. 

On top maven helps you a lot with its tools
* prepare the code for your IDE
* it manages your dependencies
* it manages your dependency versions
* it makes your code available for other coders (repositories) 

Now you are able to share the project and create a simple executable out of the compiled classes

# how to build
1. Open eclipse
2. select `import new maven project`
3. run in your console `mvn test` to test
4. run in jour console `mvn package` to create an executable
5. cd into the `target` folder
6. run `java -jar TicTacToe.jar Hans Peter`

# JUnit Tests
JUnit tests will help you to test your code with just a few lines. It supports a test driven development easy.
If you learn to implement test driven you'll see that your code is getting more and more structured in the right granularity. If your code blocks are to big you are not able to implement small and focused tests. If your code is to fine grained you'll mess with to many small method calls. Then the complexity of the choreography is to much to handle.

Further more you can use the code coverage tool from eclipse to give you hints about untested code. 



# just a hint
[https://dzone.com/articles/using-github-as-maven-repository]