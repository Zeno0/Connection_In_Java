import java.io.*;
import java.net.*;
public class server {
                   // Create an Instance Variable 'advicelist' from which server will fetch advice
    String [] advicelist = {"watch anime","relax properly","ignore people","get a good haircut","sleep properly"
                             ,"be like natsu","love yourself","oregairu is best anime","no god exist"};    
    
    public void go(){
        
        try{
            ServerSocket ss= new ServerSocket(4242);  // Create a server socket '4242' which will be used by client 
                                                      // and it makes server listen to client's request
            while(true){
                
                Socket sock = ss.accept(); // accept() method listens the request and waits until a connection is made
                                           // returns the socket used to communicate with client
                                           
                PrintWriter writer = new PrintWriter(sock.getOutputStream());  // 'writer' variable is used to execute println method
                String advice = getadvice(); 
                writer.println(advice);  
                writer.close();  // close the writer 
                System.out.println(advice);
                
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    // getadvice() is used to get advice from 'advicelist'
    private String getadvice(){
            int r = (int)(Math.random()* advicelist.length);  // randomly generate an advice
            return advicelist[r];
        }
    
    // main thread
    public static void main (String [] args){
        server sss = new server();
        sss.go();
    }
}
