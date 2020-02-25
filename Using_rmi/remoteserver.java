package Using_rmi;

import java.rmi.*;
import java.rmi.server.*;

public class remoteserver extends UnicastRemoteObject implements myremote{

    public String sayHello() {

        return "Server says, 'hello'";
    }

    public remoteserver() throws RemoteException{}

    public static void main (String args[]){

        try{
            myremote service = new remoteserver();
            Naming.rebind("Remote hello ",service);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
