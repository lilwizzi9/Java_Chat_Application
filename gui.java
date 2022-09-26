import java.awt.*;

import javax.swing.*;

import javafx.scene.paint.Color;

import java.awt.event.*;

public class gui extends Thread{
    private JFrame frame;
    private JPanel util;
    private JPanel chat;

    private JButton host;
    private JButton connect;
    private JTextField ip;

    private JButton sendMsg;
    private JTextField msg;
    private conn conn;



    

    public gui(){
        // Construct all our UI Components
        frame =new JFrame();
        util = new JPanel();
        chat = new JPanel();
        host = new JButton();
        connect = new JButton();
        ip = new JTextField(16);
        ip.setText("127.0.0.1");
        sendMsg  = new JButton();
        //sendMsg.setEnabled(false);
        msg = new JTextField(16);
    }



    @Override
    public void run(){
        frame.setMinimumSize(new Dimension(300,250));
        util.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        chat.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        frame.add(chat, BorderLayout.CENTER);
        frame.add(util, BorderLayout.NORTH);


        host.setText("Host");
        connect.setText("Connect");
        sendMsg.setText("Send");

        util.add(host);
        util.add(connect);
        util.add(ip);

        chat.add(msg);
        chat.add(sendMsg);


        // Important For Buttons
        init_button();

        // Finally
        frame.setDefaultCloseOperation(3);
        frame.setTitle("Chat App Java");
        frame.pack();
        frame.setVisible(true);
        
    }

    public String getIP(){return ip.getText();}

    public void init_button(){
        // Initalizes Events For all The Buttons

        // host Button
        host.addActionListener(new event() {

            @Override
            public void action() {
                // init Conn Oject
                conn = new conn(true,ip.getText()) {

                    @Override
                    public String rcv(String msg) {
                        System.out.println(msg);
                        return null;
                    }
                    
                };
                conn.start();
            }
            
        });


        // connect Button
        connect.addActionListener(new event() {

            @Override
            public void action() {
                // init Conn Oject
                conn = new conn(false,"") {

                    @Override
                    public String rcv(String msg) {
                        System.out.println(msg);
                        return null;
                    }
                    
                };
                conn.start();

            }
            
        });

        // SendMsg Button
        sendMsg.addActionListener(new event() {

            @Override
            public void action() {
                conn.send(msg.getText());
                
            }
            
        });



    }

}


abstract class event implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        action();
        
    }

    public abstract void action();

}
