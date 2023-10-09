#!/bin/bash
#creating arguements
request=$1
args1=$2
args2=$3
args3=$4

#using echo to print out the statements to instruct you on what to do
echo "1. create $id"
echo "2. add $id $friend"
echo "3. post $sender $receiver message"
echo "4. display $id wall"

#endless loop
while true;do
	#prompt to enter the request
	read -p "enter request: " request args1 args2 args3
	
	#if statement to check if "create" exist and if it exists it will 			 output it from the file
	if [ $request == "create" ]; then
		$HOME/assignment1/create.sh "$args1"
		
	#elif statement to check if "add" exist and if it exists it will 			 output it from the file 
	elif [ $request == "add" ]; then
		$HOME/assignment1/add_friend.sh "$args1" "$args2"
		
	#elif statement to check if "post" exist and if it exists it will 			 output it from the file 
	elif [ $request == "post" ]; then
		$HOME/assignment1/post_message.sh "$args1" "$args2" "$args3"
		
		#elif statement to check if "display" exist and if it exists it will output it from the file 
	elif [ $request == "display" ]; then
		$HOME/assignment1/display_wall.sh "$args1"
	#else statement to output this if all factors are not met
	else
		echo "accepted commands: {create|add|post|display|}"
		exit 1;
	fi
done
	
