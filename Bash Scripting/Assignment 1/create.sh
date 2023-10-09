#!/bin/bash
#creating arguements
id=$1

#if statement to check if the number of arguements passed true equates to 0
if [ $# -eq 0 ]; then
	echo "nok: no identifier found"
	exit 1
	
#elif statemet to check if the user is inside of the files
elif [ -d "$1" ]; then
	echo "user already exist"
	exit 1
else

#if the user does not exist a new user will be created
	mkdir "$id"
	cd "$id"
	touch wall.txt
	touch friends.txt
	echo "ok: user was created"	 
fi
