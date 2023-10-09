#!/bin/bash

#creating arguements
sender=$1
receiver=$2
message=$3

#if statemeent to check if 3 arguements are being passed through
if [ $# -eq 3 ]; then

	#if statement that checks if the arguement is in the directory
	if [ -d "$1" ]; then
	
		#if statement that checks if the arguement is in the directory
		if [ -d "$2" ]; then
		
			#if statement that checks if the sender is inside of the receivers friend file
			if grep "^$1" "$2"/friend > /dev/null; then
				
				#adding the message into the wall.txt file
				echo $3 >> $2/wall.txt
				echo "ok: message posted!"
			else
				#output for if the users are not friends
				echo "nok: user "$1" is not a friend of "$2""
			fi
		
		#checking if sender does not exist
		else [ ! -d "$1" ]; 
			echo  nok: sender does not exist
		fi
		
	#checking if receiver does not exist
	else [ ! -d "$2" ]; 
		echo nok: receiver does not exist
	fi
fi
	

	
