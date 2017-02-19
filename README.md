## Conference Track Management

### Pre-requisites for Building
* Java 1.8 or above
* Maven (for building)
* JUnit version-4.12 (for test dependencies, resolves while building the project using Maven)
* Mockito version-1.9.5(for test dependencies, resolves while building the project using Maven)

### Pre-requisites for Executing the Program
* Java 1.8 or above

### How to Build

* After extracting the zip file. Follow the below steps:
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
The input file contains different talks which are to be scheduled. Each talk should start with the talk name followed by white space and end with duration in a new line. For example:
```bash
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python lightning
```
If the input file doesn't match the pattern then ```IllegalArgumentException``` is thrown.

### Output

```bash
The Conference schedule for the given input will be available in /parent-path/to/input_file/Output.txt
```

###Design

### ConferenceSchedulerMain
* Helper class to schedule an conference from a given input file which contains the talks that should be scheduled.
* Throws ```IOException``` and ```IllegalArgumentException```

#### ConferenceScheduler

* The `ConferenceScheduler` class provides a method called `scheduleConference()` as an API to create a
  `Conference` object representing a scheduled conference with tracks for the provided input
* The algorithm behind scheduling the events in sessions is first-fit.
* The Conference object contains the different tracks for the conference
* Example use of the API:
```java
BufferedReader reader = new BufferedReader(new FileReader("/path/to/input_file"));
Conference conference = new ConferenceScheduler().scheduleConference(reader);
System.out.println(conference);
```

#### Conference

* An `Conference` object contains lists of tracks. The toString method prints the details of the conference object.

#### Track

* An object representation of a single track of a conference. Each `Track` object contains sessions. For now, the object contains morning session, lunch sessions, afternoon session and networking session.

#### Session

* A `session` represents a group of events in a `Track` with a fixed start and end time. E.g.: the
  morning session starting at 9 AM and ending at 12 PM with multiple events in it

#### Event

* An event of the conference with specified duration in min/lightning. 1 lightning = 5 min.

### TestCases
* Both unitTests and acceptanceTests are included

