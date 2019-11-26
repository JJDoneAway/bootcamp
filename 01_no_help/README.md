# No help at all
This is coding back to the beginning of java with no tool support except eclipse.
If you what to do this exercise 
* just download eclipse, 
* start it and 
* create a new java project.
* don't use any library 
* Implement the interactive game tic tac toe. You should do it test driven but don't use any test framework like junit

# the pain you should feel:
* wrong or no use of classes will make your code hard to read and complex
* no test framework will force you to implement the boiler plate again and again to test your code snippets 
* no code management will hinder you to build, test, run and share your code 
  * project relevant settings of your IDE can not be restored
  * the test must be started manually and can be forgotten
  * you must compile the code manually to get your classes
  * you must start the program in a very inconvenient way
  * automation is far away 

# If you would like to inspect the example
* clone it to any directory
* create a new java project with the name Tic_Tac_Toe
* run the tests in `com.mt_ag.tic_tac_toe.Tests`
* to run the game:
  * safe any change in eclipse (will compile the code) 
  * open your command and cd into the `bin` folder
  * call `java com.mt_ag.tic_tac_toe.Play Player_A Player_B`