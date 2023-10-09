#!/bin/bash 
id=$1

if [ $# -eq 1 ]; then
    mkfifo $id.pipe # makes new pipe
    while true; do # infinite loop
        
    trap ctrl_c INT

        # removes user named pipe and exits script
        function ctrl_c() {
            rm Pipes/"$id.pipe"
               printf "\nRemoved %s.pipe\n" "$id"
               exit 0
            }        
        read command id id2 message 
        echo $command $id $id2 $message > server.pipe
                    echo "$input"
                    echo "nok:ERROR: no input id"
                    echo "Input valid id : " && exit 1
            read output < $id.pipe
            case $output in # case command
                   'nok: problem with the number of identifiers')
                 echo ERROR: incorrect amount of identifiers submitted
                 echo please submit the correct amount of identifiers
                ;;
                   "nok: user id already exists")
                 echo ERROR: a user with the name $id already exists
                  ;;
                   "ok: user id created!")
                 echo User successfully created
                   ;;
                "nok: user id does not exist")
                 echo User with id $id does not exist
                    ;;
                  "nok: user friend does not exist")
                   echo Friend does not exist
                  ;;
                   "ok: friend added!")
                 echo Friend added!
                   ;;
                   "nok: could not add friend as friend")
                 echo You two are already friends!
                    ;;
                "nok: user sender is not a friend of receiver")
                 echo You are not a friend of the receiver
                    ;;
                "ok: message posted on receiver wall")
                 echo Message posted!
                    ;;
      
        *)
            echo "These are the only valid commands: {create|add|post|display}"

    esac
                exit 0
        
         
    done
fi
