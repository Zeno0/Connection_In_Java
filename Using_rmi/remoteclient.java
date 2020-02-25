package Using_rmi;

import java.rmi.*;

public class remoteclient{

    public void go(){
        try{
            myremote service = (myremote) Naming.lookup("rmi://127.0.0.1/Remote hello ");
            String s = service.sayHello();
            System.out.println(s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main (String args[]){
        new remoteclient().go();
    }
}