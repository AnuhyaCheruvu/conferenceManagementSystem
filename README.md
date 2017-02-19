## Conference Track Management

### Prerequisites for Building
* Java 1.8 or above
* Maven (for building)
* JUnit (for test dependencies, resolves while building the project using Maven)
* Mockito (for test dependencies, resolves while building the project using Maven)

### Prerequisites for Executing the Program
* Java 1.8 or above

### How to Build

```bash
cd /path/to/project-root
mvn clean install
```

This build task compiles the code, builds a jar file in `project-root/target` directory, and executes the
tests.

### How to Run the Program

After `mvn clean install`:

```bash
java -jar /path/to/conference-track-management-1.0-SNAPSHOT.jar /path/to/input_file
```
### Constraints on input
Input file should contains diffents talks. Each talk should start with the talk name followed by white space and end with duration in a new line. For example:
```bash
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
```

### Output

```bash
The Congerence schedulewill be available in /parent-path/to/input_file/Output.txt
```

###Design

#### ConferenceScheduler

* The `ConferenceScheduler` class provides a method called `scheduleConference()` as an API to create a
  `Conference` object representing a scheduled conference with tracks for the provided input
* The alogorith behind scheduling the events in sessions is first-fit. 
* The Conference object contains the different tracks for the conference
* Example use of the API:
```java
BufferedReader reader = new BufferedReader(new FileReader("/path/to/input_file"));
Conference conference = new ConferenceScheduler().scheduleConference(reader);
System.out.println(conference);
```

#### Conference

* A `Conference` object containss lists of tracks

#### Track

* An object representation of a single track of a conference. Each `Track` object contains sessions. For now, the object contains morning session, lunch sessions, afternoon session and networking session.

#### Session

* A `session` represents a group of events in a `Track` with a fixed start and end time. E.g.: the
  morning session starting at 9 AM and ending at 12 PM with multiple events in it

#### Event

* An event of the conference with specfied duration in min/lightning

