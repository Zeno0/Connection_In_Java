import java.io.*;
import java.net.*;
import java.util.*;
public class improvedserver {
    
    ArrayList clientout;
    
    public class clienthandler implements Runnable{
        BufferedReader re;  // Instance variables 
        Socket sc;
        
        // Constructor
        public clienthandler(Socket clsc){
            try{
                sc = clsc;
                InputStreamReader ir = new InputStreamReader(sc.getInputStream());  // InputStreamReader 'ir' contains Socket 'sc' 
                re = new BufferedReader(ir);                                        // infromation using .getInputStream() method
           // re = new BufferedReader(new InputStreamReader(clsc.getInputStream()));
            }catch(Exception ex){ex.printStackTrace();}
        }
        
        //  run() method 
        public void run(){  
            String msg; 
            try{
                while((msg = re.readLine()) != null){  // while message is available
                    System.out.println("read "+msg);   // print it
                    telleveryone(msg);        // use telleveryone method to orint ressage to all ckients         
                }
            }catch(Exception ex){ex.printStackTrace();}
        }
    }
    public void telleveryone(String msg){
        
        Iterator it = clientout.iterator(); // 'clientout' ArrayList is iterated to Iterator 'it'
        while(it.hasNext()){
            try{
                PrintWriter pw = (PrintWriter) it.next();  // Iterator object is casted to PrintWriter 'pw'
                pw.println(msg); // print msg
                pw.flush();
            }catch(Exception ex){ex.printStackTrace();}
        }
        
    }
    
    public void go(){
        clientout = new ArrayList();  // arraylist initialized
        try{
            ServerSocket ss = new ServerSocket(5000);  // create server socket '5000' for client
            
            while(true){
                    Socket clsc = ss.accept();  // accept the request of client and save it in 'clsc' Socket variable
                    PrintWriter w =new PrintWriter(clsc.getOutputStream());  // use .getOutputStream() method in 'clsc' Socket in PrintWriter 'w'
                    clientout.add(w);  // add it ArrayList 'clientout'
                    
                    Thread t = new Thread(new clienthandler(clsc));   // 't' Thread for with clienthandler class
                    t.start();  
                    System.out.println("got a connection");
                    }
        }catch(Exception ex){ ex.printStackTrace();}
    }
    

       //main thread
        public static void main(String[] args){
        new improvedserver().go();
    }
    
}