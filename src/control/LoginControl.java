package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;

import interfaces.IEvento;
import interfaces.ILogin;
import persistence.Evento;
import persistence.Login;

public class LoginControl {

	private Login lo = null;
	private ILogin ir = null;

	public LoginControl()throws RemoteException, NotBoundException{
		Registry r=LocateRegistry.getRegistry(10000);
		ir=(ILogin) r.lookup("login");
	}

	public boolean login(int cedula, String password) {
		boolean login=false;
		try {
			login= ir.login(cedula, password);
		} catch (RemoteException e) {
			e.printStackTrace();
			login=false;
		}
		return login;
	}

	public boolean registrarUsu(int cedula, String nombre, String password, String email, int celular) {
		boolean add = true;
		try {
			if (!ir.registrarUsu(cedula, nombre, password, email, celular))
				add = false;
		} catch (RemoteException e) {
			e.printStackTrace();
			add = false;
		}
		return add;
	}

}
