# Creating_Connection_In_Java

Creating a basic Connection between client and a server using java.net package.

## class improvedserver
 ### go() method
 Create a Server Socket and accept the request from the user and adds it to the ArrayList. Create a Thread 
 using clienthandler class.
## class clienthandler
It has a constructor which is used to get input stream from the client socket,
 ### run() method
 Prints the String.
 ### telleveryone() method
 print message for every connected client using PrintWriter class



PS: Run client, after running the server
Source: Head First Java book by O'Reily

