#!/bin/bash

# Build and run TestDriver from command line.
function Main() {
    cd $(dirname ${0})
    rm -rf ../target
    mkdir -p ../target
    javac -d ../target $(find . -name "*.java" | xargs)
    java -cp ../target -ea edu.utdallas.emse.hw1.TestDriver
}

Main $@
