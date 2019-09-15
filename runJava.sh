#!/bin/sh
# compile java file
javac *.java
# cp java class file to DiDi directory, which is package name
cp *.class  DiDi/
rm  *.class 
#execute Main java file
java  DiDi.wordAnagram

#execute test file
java  DiDi.Test