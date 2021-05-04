#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.bhugo.avajlauncher.Simulator scenario.txt