# 					[Messanger_Application](https://github.com/AazamJutt/Messanger_Application/)



### Developed By [Aazam Jutt](https://github.com/AazamJutt)

![GitHub release (latest by date)](https://img.shields.io/github/v/release/faatehsultan/github-graph-magician?style=social)

## Description

* It uses a simple server that creates a Thread as a ChatHead between clients. 
* It uses some commands for inter-server-client communication to perform and action.
* When client connects to server and ask for connection, Server ask for the name of client and registers it in local data structure (Dictionary) along with a socket connected to the client. 
* In this Dictionary Client's name act as a Key and its Socket is the value. 
* When 1st client arrives and No one is online, Server sends a message to client that "No one is online wait...". 
* When 2nd client arrives, Server registers it and displays "Online Clients" page to him/her. When client select one of the online clients. Server starts a ChatHead as a thread. Server recieves Messages from a client and sends it to another client.

## Bugs Yet to be fixed

* Handle, Removing clients from server server data structure.
* Handle, Thread-safe variable. i.e. Critical Section Management between Threads.
