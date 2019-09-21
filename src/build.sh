#!/bin/bash

# Build and run TestDriver from command line.
function Main() {
    cd $(dirname ${0})
    javac -d ../target/ main/java/edu/utdallas/emse/hw1/*/*.java test/java/edu/utdallas/emse/hw1/*.java
    java -cp ../target -ea edu.utdallas.emse.hw1.TestDriver
}

Main $@
