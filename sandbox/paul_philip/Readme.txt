Write a simple TCP server that supports the following commands:

list - Lists all the files in the directory the server is running on.

pwd - Print the path of the directory the server is running on.

cat <filename> - Print the contents of the filename given as argument.

rm <filename> - Delete the filename given as argument.

touch <filename> <content> - Create a file with name and content given as argument.

time - Returns the current time on the server.

Also implement a simple client program that uses this server. The client must create a file every minute on the server with a random filename and with the content being the current server time.
Please follow our submission guidelines when sending in solutions.

Usage:
1. run the server in the cmdline using server.py
2. run the client in another cmd using client.py
3. sometimes the command typed will not yield result.In such cases re-enter it again if there is no response
4. Shutown server using ctrl+C
5. to free the port to reuse the port again after closing the server,use the command 'sudo fuser -k 9999/tcp'

