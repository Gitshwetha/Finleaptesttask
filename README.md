# maven-testNG 

This is a maven project built using TestNG framework and Selenium-webdriver with data driven framework format.
This project  follows PageObjectModel structure

To run testcases:
Clone the repository and import in Eclipse.

In the TestBase class mention the chrome driver path. 
Since the testdata is fetched from Excel file, mention the testdatasheet path in TestUtil class

This project can be run as a Maven test or TestNG Test by right clicking on the project folder

This can also be run from Jenkins by integrating with git repository, creating a job.

Testcases are written in Testcases.xlsx for both Signup and Login Test.

index.html under Test-output folder will show thre test results.


