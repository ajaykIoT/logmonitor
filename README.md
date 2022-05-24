
**The program should:**
* Take the path to logfile.txt as an input argument
* Parse the contents of logfile.txt
* Flag any long events that take longer than 4ms
* Write the found event details to file-based HSQLDB (http://hsqldb.org/) in the working folder
  * The application should create a new table if necessary and store the following values:
    * Event id
    * Event duration
    * Type and Host if applicable
    * Alert (true if the event took longer than 4ms, otherwise false)


**Scope for improvement:**
 * Use of producer and consumer with multithreading
