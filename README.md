# pbak-simple-search

Built with:

* jdk 8_131
* maven 3.5.4

1. How to build project:

mvn clean install

2. How to run project

java -jar simple-search-1.0-SNAPSHOT-jar-with-dependencies.jar pathToDirectory

3. How application works

WORD - anything matching pattern "([A-Za-z]+)"

* Application loads all *.txt files in given directory. File loading is not recursive - it will not search directories inside given directory.
* Application extracts list of distinctive WORDs from each file
* User can search for any set of WORDs, separating each WORD with space
* Application for each file loaded calculates rank value - the percentage of users WORDs found in a file.