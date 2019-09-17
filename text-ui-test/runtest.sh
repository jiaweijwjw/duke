#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "/Users/jiawei/Desktop/duke/bin" ]
then
    mkdir /Users/jiawei/Desktop/duke/bin
fi

# delete output from previous run
if [ -e "./ACTUAL.TXT" ]
then
    rm ACTUAL.TXT
fi

# compile the code into the bin folder, terminates if error occurred
if ! javac -cp /Users/jiawei/Desktop/duke/src -Xlint:none -d /Users/jiawei/Desktop/duke/bin /Users/jiawei/Desktop/duke/src/main/java/*.java
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

# run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath /Users/jiawei/Desktop/duke/bin Duke < input.txt > ACTUAL.TXT

# compare the output to the expected output
diff ACTUAL.TXT EXPECTED.TXT
if [ $? -eq 0 ]
then
    echo "Test result: PASSED"
    exit 0
else
    echo "Test result: FAILED"
    exit 1
fi