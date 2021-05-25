#!/bin/bash

sudo apt-get update -y
sudo apt-get install openjdk-8-jdk -y
find * -name "*.java" > sources.txt
javac @sources.txt
java tower/AvajLauncher scenario.txt