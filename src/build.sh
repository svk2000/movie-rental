#!/bin/bash

cd /mnt/Storage/School/EMSE/SE6329/src
javac -d /mnt/Storage/School/EMSE/SE6329/target/ /mnt/Storage/School/EMSE/SE6329/src/main/java/edu/utdallas/emse/hw1/*/*.java /mnt/Storage/School/EMSE/SE6329/src/test/java/edu/utdallas/emse/hw1/*.java
java -cp ../target edu.utdallas.emse.hw1.TestDriver
