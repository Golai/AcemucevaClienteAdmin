package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;

import interfaces.IEvento;
import interfaces.IregistroE;
import persistence.Evento;
import persistence.RegistroE;

public class RegistroE_Control {

	private RegistroE res=null;
	private IregistroE ir=null;
	
	public RegistroE_Control()throws RemoteException, NotBoundException{
		Registry r=LocateRegistry.getRegistry(10000);
		ir=(IregistroE) r.lookup("registroE");
	}
	
	public boolean regsitroEventos(int id_registro,
								int id_evento,
								int id_miembro,
								int id_asistente,
								Date fecha_registro,
								boolean asistencia){
		
		boolean registra=false;
		try{
			registra=ir.registroEventos(id_registro, id_evento, id_miembro, id_asistente, fecha_registro, asistencia);
		}
		catch(RemoteException e){
			e.printStackTrace();
			registra=false;
		}
		return registra;
	}
	
	public RegistroE searchAsisE(int id_asistente){
		try{
			res=ir.seachAsisEvento(id_asistente);
		}
		catch(RemoteException e){
			e.printStackTrace();
			res=null;
		}
		return res;
	}
	
	public boolean updateRegistroEvento(int cedula, int id_evento, boolean asistencia){
		boolean update=true;
		try{
			if(!ir.updateRegistroEvento(cedula, id_evento, asistencia));
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	
	
	public boolean delRegistroEvento(int cedula, int id_evento){
		boolean del=true;
		try{
			if(!ir.delRegistroEvento(cedula, id_evento))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	
	public boolean addRegistroEvento(int cedula, int id_evento){
		boolean add=true;
		try{
			if(!ir.addRegistroEvento(cedula, id_evento))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}
}
