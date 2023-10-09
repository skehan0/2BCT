#!/bin/bash

# checking if the arguement is inside the files
if [ -d "$1" ]; then
	
	#if the arguement is inside the files, wall.txt will be displayed
	cat "$1"/wall.txt
	
	#if not the following statement will be printed
else [ ! -d "$1" ];
	echo "nok: user "$1" does not exist"
fi
