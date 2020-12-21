
import java.io.DataInputStream;
import java.io.DataOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aazam Sultan
 */

//A thread, in which A client sends message and Other recieves
public class ChatHead extends Thread{
    String sender;
    String reciever;
    DataInputStream cin;
    DataOutputStream cout;
    ChatHead(String s,String r)
    {
        sender = s;
        reciever = r;
        try {
            //Gets Sender's message
            cin = new DataInputStream(ClientHandler.clients.get(sender).getInputStream());

            //Sends message to reciever
            cout = new DataOutputStream(ClientHandler.clients.get(reciever).getOutputStream());
        } catch (Exception exception) {
            System.out.println("Exception in " + sender + ","+reciever+" --> ctr");
        }
    }
    @Override
    public void run() {
        String line = "";
        //Runs until Client notifies ClientHandler to end Chat
        while(!line.equalsIgnoreCase(Commands.EXIT) && !line.equalsIgnoreCase(Commands.END_CHAT))
        {
            try {
                line = cin.readUTF();
                if(line.equalsIgnoreCase(Commands.EXIT) || line.equalsIgnoreCase(Commands.END_CHAT))
                    cout.writeUTF("Server: \""+sender+"\" exited...");
                else
                    cout.writeUTF(sender+": "+line);
            } catch (Exception ex) {
                System.out.println("Exception in " + sender + ","+reciever+" --> run()");
            }
        }
        
    }
    
    //A feature to be added
    private void setFreeStatus(String name)
    {
        ClientHandler.clients.remove(name);
        ClientHandler.status.put(name,ClientHandler.Status.FREE);
        Server.clientsCount--;
    }
}
