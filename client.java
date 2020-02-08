import java.io.*;
import java.net.*;
public class client {
    
    public void go(){
        try{
            Socket s =new Socket("127.0.0.1",4242);  // create a socket to connect from the server and use the same TCP '4242'
            
            InputStreamReader is = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(is);  // 'reader' gets the input stream from the socket 's'
            
            String advice = reader.readLine(); 
            System.out.println(advice); // print the advice 
            
            reader.close(); //close the 'reader'
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //main thread 
    public static void main(String [] args){
        client c = new client();
        c.go();
    }
    
}
