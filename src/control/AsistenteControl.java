package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IAsistente;
import persistence.Asistente;

public class AsistenteControl {
	
	
	private Asistente asis=null;
	private IAsistente ir=null;

	public AsistenteControl() throws RemoteException, NotBoundException{
		Registry r=LocateRegistry.getRegistry(100000);
		ir=(IAsistente)r.lookup("asistente");
	}
	
	
	public Asistente searchAsistente(int cedula) {
		try {
			asis=ir.searchAsistente(cedula);
		}
		catch(RemoteException e) {
			e.printStackTrace();
			asis=null;
		}
		return asis;
	}
	
}
