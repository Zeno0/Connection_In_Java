import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
public class improvedclient {
    
    JTextArea in;                     // create all the instance variables
    JTextField out;
    BufferedReader re;
    PrintWriter wr;
    Socket sc;
    
    
    
    public void go(){               //  This method creates the GUI interface and sets up networking
                                    //  between client and server
        
        JFrame f = new JFrame();
        JPanel jp = new JPanel();
        
        in = new JTextArea(15,30);
        in.setLineWrap(true);
        in.setWrapStyleWord(true);
        in.setEditable(false);
        
        JScrollPane jsp = new JScrollPane();
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        out = new JTextField(20);
        
        JButton b = new JButton("send");
        b.addActionListener(new blisten());
        
        jp.add(jsp);
        jp.add(out);
        jp.add(b);
        jp.add(in);
        
        setupnetworking();   // create networking
        
        Thread rt = new Thread(new reader());   // this thread is for priniting information at the terminal
        rt.start();
        
        f.getContentPane().add(BorderLayout.CENTER,jp);
        f.setSize(500,500);
        f.setVisible(true);
          
    }
    // create networking method
    private void setupnetworking(){  
        
        try{
            
            sc= new Socket("127.0.0.1",5000);   // client socket connection with server socket
            InputStreamReader ir = new InputStreamReader(sc.getInputStream());
            re = new BufferedReader(ir);
            wr = new PrintWriter(sc.getOutputStream());
            System.out.println("network established");
            
        }catch(Exception e){e.printStackTrace();}
    }

    // method for performing action event of button
    
    public class blisten implements ActionListener{  
        public void actionPerformed(ActionEvent ev){
            try{
            wr.println(out.getText());
            wr.flush();
            }catch(Exception ex){ex.printStackTrace();}
            out.setText("");
            out.requestFocus();
        }
    }
    
    public class reader implements Runnable{ // used by Thread 'rt'
        public void run(){
            String msg;
            try{
              
                while((msg = re.readLine()) != null){
                    System.out.println("read "+msg);
                    in.append(msg+"\n");
                }
                
            }catch(Exception ex){ex.printStackTrace();}
        }
    }
    //main thread
    public static void main(String [] args){
        improvedclient ic = new improvedclient();
        ic.go();
    }
    
    
}