
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
    String receiver;
    DataInputStream cin;
    DataOutputStream cout;
    ChatHead(String s,String r)
    {
        sender = s;
        receiver = r;
        try {
            //Gets Sender's message
            cin = new DataInputStream(ClientHandler.clients.get(sender).getInputStream());

            //Sends message to receiver
            cout = new DataOutputStream(ClientHandler.clients.get(receiver).getOutputStream());
        } catch (Exception exception) {
            System.out.println("Exception in " + sender + ","+receiver+" --> ctr");
        }
    }
    
    private Boolean isCommand(String line)
    {
        if(line.equalsIgnoreCase(Commands.END_CHAT))
            return true;
        if(line.equalsIgnoreCase(Commands.EXIT))
            return true;
        return false;
    }
    
    //sets status of the client to Free
    static void freeClient(String name)
    {
        ClientHandler.status.put(name, ClientHandler.Status.FREE);
    }
    public void removeClient(String name)    {
        try{
            DataOutputStream out = new DataOutputStream(ClientHandler.clients.get(name).getOutputStream());
            out.writeUTF(Commands.DISCONNECT);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        ClientHandler.clients.remove(name);
        ClientHandler.status.remove(name);
    }
    
    private void runCommand(String line)
    {
        if(line.equalsIgnoreCase(Commands.END_CHAT))
        {
            try{
                cout.writeUTF("Server: \""+sender+"\" left the chat...");
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            freeClient(sender);
            freeClient(receiver);
        }
        if(line.equalsIgnoreCase(Commands.EXIT))
        {
            try{
                cout.writeUTF("Server: \""+sender+"\" exited...");
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            removeClient(sender);
            freeClient(receiver);
            System.out.println("\""+sender+"\" exitied...");
        }
    }
    @Override
    public void run() {
        String line = "";
        //Runs until Client notifies ClientHandler to end Chat
        try {
            while(!line.equalsIgnoreCase(Commands.EXIT) && !line.equalsIgnoreCase(Commands.END_CHAT))
            {
                line = cin.readUTF();
                if(isCommand(line))
                    runCommand(line);
                else
                    cout.writeUTF(sender+": "+line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
