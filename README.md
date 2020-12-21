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

## Tutorial

* Run the Server file. Server starts listening

![GitHub editor](tutorial/0.png)

* Run the Client File. Registeration form appears.Register with name and press submit.

![GitHub editor](tutorial/1.png)

* Server sends a message to Client, that no one is Online.

![GitHub editor](tutorial/2.png)

* If you are running it on the same machine. Run Client file  a 2nd time and register again.

![GitHub editor](tutorial/3.png)

* If any Client is Online. Server shows it in the Online Client window

![GitHub editor](tutorial/4.png)

* When  you Click any of the client. Server sends a request to that client with a proper message.

![GitHub editor](tutorial/5.png)

* When other client accepts the Request chat starts between the Clients and both clients' status is set to Busy, no other client will see these client in their online client window.

![GitHub editor](tutorial/6.png)

* A visualization of inter-cient chatting.

![GitHub editor](tutorial/7.png)

* If one of the client presses (X) or end_Chat button. other client recieves a message.

![GitHub editor](tutorial/8.png).

* Server side behaviour during all this processing.

![GitHub editor](tutorial/9.png)
## Bugs Yet to be fixed

* Handle, Removing clients from server data structure.
* Handle, Thread-safe variable. i.e. Critical Section Management between Threads.
