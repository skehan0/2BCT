#!/bin/bash
#creating arguements
id=$1
friends=$2

#if statement that checks if the arguement is not the directory
if [ ! -d "$1" ]; then
	echo "nok: user "$1" does not exist"
	
#elif statement that checks if the arguement is not the directory
elif [ ! -d "$2" ]; then
	echo "nok: user '$friend' does not exist"
else
#if statement that checks if the user is inside of the friend file
	if grep "^$2" "$1"/friend > /dev/null; then
		echo "already exists"
		exit 0
	else 
	#adding the arguement into the file
		echo "$2" >> "$1"/friend
		echo "ok:friend added"
		exit 0
	fi
fi

		
