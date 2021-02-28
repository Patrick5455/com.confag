#!/bin/bash
mvn package

# if you are running this project from an ide, close before running this command as it might throw an error of port already in use
java -jar target/confagapp-0.0.1-SNAPSHOT.jar