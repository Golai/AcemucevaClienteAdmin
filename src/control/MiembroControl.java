package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;

import interfaces.IEvento;
import interfaces.IMiembro;
import persistence.Evento;
import persistence.Miembro;

public class MiembroControl {

	private Miembro mie=null;
	private IMiembro ir=null;
	
	public MiembroControl()throws RemoteException, NotBoundException{
		Registry r=LocateRegistry.getRegistry(10000);
		ir=(IMiembro) r.lookup("Miembro");
	}
	
	public Miembro searchMiembro(int cedula){
		System.out.println("cedula en el control: "+ cedula);
		try{
			mie=ir.searchMiembro(cedula);
		}
		catch(RemoteException e){
			e.printStackTrace();
			mie=null;
		}
		System.out.println("miembro llego al control: "+ mie);
		return mie;
	}
	
	public boolean updateMiembro(int cedula,int id_cargo, String nombre, int celular, int semestre, int puntos){
		boolean update=true;
		try{
			if(!ir.updateMiembro(cedula, id_cargo, nombre, celular, semestre, puntos));
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	
	public boolean delMiembro(int cedula){
		boolean del=true;
		try{
			if(!ir.delMiembro(cedula))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	
	public boolean addMiembro(int cedula, int id_cargo, String nombre, int celular,String email, int semestre, int puntos){
		boolean add=true;
		try{
			if(!ir.addMiembro(cedula, id_cargo, nombre, celular, email, semestre, puntos))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}
}
