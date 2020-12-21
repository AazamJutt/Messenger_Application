
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aazam Sultan
 */
public class Server {
    static ServerSocket ss;
    static Socket soc;
    static DataInputStream in;
    static DataOutputStream out;
    int clientsCount;
    //Constructor
    public Server(int port) {
        try {
            //server port ready for work
            ss = new ServerSocket(port);           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void startListening()
    {
        System.out.println("Server listening on  "+ ss.getLocalPort());
        while(true)
        {
            try {
                Server.soc = Server.ss.accept();
                clientsCount = ClientHandler.clients.size() + 1;
                Server.in = new DataInputStream(soc.getInputStream());
                Server.out = new DataOutputStream(soc.getOutputStream());
                System.out.println(clientsCount + " client(s) connected ...");
                
                //Handles the Client
                new ClientHandler().setVisible(true);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        Server s = new Server(4444);
        s.startListening();
    }
}
