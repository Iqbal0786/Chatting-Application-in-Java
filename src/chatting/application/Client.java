/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatting.application;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Client extends JFrame implements ActionListener{
      JPanel p1; static JTextArea area;JTextField jt;JButton b1;
      static Socket socket;
      static DataInputStream din;
      static DataOutputStream dout;
    public Client() { 
      
        p1= new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94, 84));
        p1.setBounds(0,0,450,70);
        add(p1);
        
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
        Image i2= i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
       JLabel l1= new JLabel(i3);
       l1.setBounds(5,25,25,25);
        p1. add(l1);
        l1.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
            
                System.exit(0);
            
            }
            });
        
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/2.png"));
        Image i5= i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
       JLabel l2= new JLabel(i6);
       l2.setBounds(40,5,60,60);
        p1. add(l2);
        
        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
        Image i8= i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
       JLabel l3= new JLabel(i9);
       l3.setBounds(290,20,30,30);
        p1. add(l3);
        ImageIcon i10= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
        Image i11= i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i12= new ImageIcon(i11);
       JLabel l4= new JLabel(i12);
       l4.setBounds(350,20,30,30);
        p1. add(l4);
        
        ImageIcon i15= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
        Image i16= i15.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
        ImageIcon i17= new ImageIcon(i16);
       JLabel l5= new JLabel(i17);
       l5.setBounds(410,20,13,25);
        p1. add(l5);
        
        JLabel l6= new JLabel("Bunty");
        l6.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        l6.setForeground(Color.WHITE);
        l6.setBounds(110,15,100,18);
        p1.add(l6);
        JLabel l7= new JLabel("Active Now");
        l7.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        l7.setForeground(Color.WHITE);
        l7.setBounds(110,35,100,25);
        p1.add(l7);
        
        area= new JTextArea();
        area.setBounds(5,70,450,475);
        area.setFont(new Font("SEN_SERIF",Font.PLAIN, 16));
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        add(area);
        jt= new JTextField();
        jt.setBounds(5,555,310,40);
        jt.setFont(new Font("SAN_SARIF", Font.PLAIN, 16));
        add(jt);
        b1= new JButton("Send");
        b1.setBounds(320,555,120,40);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN)SANIF", Font.BOLD, 16));
        b1.addActionListener(this);
        add(b1);
       
          setLayout(null);
        setSize(450,600);
        setLocation(800,130);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
      }
    
    public static void main(String[] args) {
        new Client().setVisible(true);
        String inputmessage="";
        try {
            socket= new Socket("127.0.0.1",6001);
            din= new DataInputStream(socket.getInputStream());
            dout= new DataOutputStream(socket.getOutputStream());
            inputmessage=din.readUTF();
            area.setText(area.getText()+"\n"+inputmessage);
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
             String out=jt.getText();
        area.setText(area.getText()+"\n\t\t\t"+out);
        dout.writeUTF(out);
        jt.setText("");
        
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}




