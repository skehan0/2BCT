Description on how to run my programs 
First to access my programs i had to access the folder in which they are in, from the terminal using 
To access the folder from the terminal use the command "cd assignment2" this allows you to access the folder of the assignmet in which you can access the programs from.
I then use the command "chmod u+x programme" to make the program that I wanted use executible in the terminal
To execute the program create.sh, I type "./create.sh user" this creates a new user, which also contains 2 files named "friend.txt" and "wall.txt" and if the user is already created it will output "user already exist"
To execute the program add_friend.sh, I type "./add_friend user otheruser" this allows a user to add another user to their friend.txt file and if the user does not exist it will output "user does not exist"
To execute the program ,post_message.sh I type "./post_message.sh sender receiver message" this will the user to send another user that's listed in their friend.txt file a message. The message will be posted on the receiver's wall.txt
To execute the program display_walls.sh, I type "./display_walls.sh user" this will display the text that's within the users wall.txt
To execute the program server.sh, I type "./server sh" this allows you execute the rest of the programs. In here we use named pipes to connect this server to the client server.
To execute the program client.sh I type "./client.sh" in a new terminal to the server. This allows us to read the repsonses of the sever.
To execute the program acquire.sh I type "./release.sh" the write scipt writes to the pipe created by the read scipt. It checks to make sure th pipe exists then will write to it.
To execute the program release.sh I type "./release.sh" the read script reads from a pipe. It first creates the pipe if it doesn't exist, then it reads in a loop till it sees "quit".


