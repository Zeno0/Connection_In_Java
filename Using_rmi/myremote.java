package Using_rmi;

import java.rmi.*;
public interface myremote extends Remote {
     public String sayHello() throws RemoteException;
}