import java.net.ServerSocket;
import java.net.*;
import java.io.*;

public abstract class conn extends Thread{
    DataOutputStream out;
    Socket s;
    boolean isServer;
    String IP;


    @Override
    public void run() {
        // TODO Auto-generated method stub
    try{
        if(isServer){
            // Create Server Socket
        ServerSocket sock = new ServerSocket(2211);
        System.out.println("Server Started");

        // Accept Connection and Store in var s
        s =  sock.accept();
        System.out.println("Connected ... Client 0");
        
        // Create Input and output Stream for s
        
        
        }else{
        
        s =  new Socket(IP,2211);
        // Create Input and output Stream for s
        
        }

            out  = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());
        while(true){
            String info = in.readUTF();
            if(info.equals("stop")){
                break;
            }
            rcv(info);
            
            
        }

        in.close();
    }catch(IOException e){
        e.printStackTrace();
    }
    
    
    }
    public conn(boolean isServer,String IP){this.IP = IP; this.isServer=isServer;}
 

    public abstract String rcv(String msg);

    public boolean send(String Msg){
    try {
        out.writeUTF(Msg);
        out.flush();
        return true;
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
    }


    }



}
