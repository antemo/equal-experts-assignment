Equal Experts - Mars Rover Kata
---
This is coding assignment for Equal Experts, version 1.2, implementing simple Mars rover simulation, which will accept starting position
and command string from which it will compute the final position of the rover.

Further description and requirements of assignment can be found [here](doc/Candidate_Instructions.pdf).<br>


### Initial setup

Application uses Java 15 and Maven 3.8.3 which should be installed (and configured) on system building/running application.

### Building application

Application can be built using following command:
```
mvn clean verify
```

Application as such can't be run, since this is only a single component which doesn't implement any I/O operations.
If there is any need to run additional tests, those should be implemented as JUnit tests and added to the project.
