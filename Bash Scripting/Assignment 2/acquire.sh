#!/bin/bash

#The following shell script writes to the pipe created by the read script. First, it checks to make sure the pipe exists, then it writes to the pipe. If an argument is given to the script, it writes it to the pipe; otherwise, it writes "Hello from PID"

id=$1

pipe=/tmp/testpipe

if [[ ! -p $pipe ]]; then
    echo "Reader not running"
    exit 1
fi


if [[ "$1" ]]; then
    echo "$1" >$pipe
else
    echo "Hello from $1" >$pipe
fi



if [ $# −lt 1 ]; then
    echo "This script requires atleast one parameter"
    exit 1
fi
 
for elem i n "$@" ; do
    if [ ! −e "$elem" ] ; then
        echo 1st $$ > $elem
    else
        echo next $$ >> $elem
 fi
done 

