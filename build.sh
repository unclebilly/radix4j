#!/bin/bash
javac -d target -classpath .:lib/hamcrest-core-1.3.jar:lib/junit-4.12.jar src/radix/*.java src/test/RadixTest.java || exit $?
java -classpath .:lib/hamcrest-core-1.3.jar:lib/junit-4.12.jar:target org.junit.runner.JUnitCore test.radix.RadixTest
