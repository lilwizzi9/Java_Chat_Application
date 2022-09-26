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

    public gui(){
        frame =new JFrame();
        util = new JPanel();
        chat = new JPanel();
        host = new JButton();
        connect = new JButton();
        ip = new JTextField();
    }



    @Override
    public void run(){
        frame.setMinimumSize(new Dimension(500,500));
        util.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        chat.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        chat.setLayout(new GridLayout(0,1));

        frame.add(chat, BorderLayout.CENTER);
        frame.add(util, BorderLayout.NORTH);


        host.setText("Host");
        connect.setText("Connect");
        util.add(host);
        util.add(connect);





        // Finally
        frame.setDefaultCloseOperation(3);
        frame.setTitle("Chat App Java");
        frame.pack();
        frame.setVisible(true);
        
    }

    public String getIP(){return ip.getText();}

}
