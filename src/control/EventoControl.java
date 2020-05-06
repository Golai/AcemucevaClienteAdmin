package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;

import interfaces.IEvento;
import persistence.Evento;

public class EventoControl {

	private Evento eve=null;
	private IEvento ir=null;
	
	public EventoControl()throws RemoteException, NotBoundException{
		Registry r=LocateRegistry.getRegistry(10000);
		ir=(IEvento) r.lookup("evento");
	}
	
	public Evento searchEvento(int id_evento){
		try{
			eve=ir.searchEvento(id_evento);
		}
		catch(RemoteException e){
			e.printStackTrace();
			eve=null;
		}
		return eve;
	}
	
	public boolean updateEvento(int id_evento,int id_encargado,
								String nombre_evento,String descripcion,
								Date fecha, String lugar, String hora,
								int cupos, int puntos, String tipo_evento){
		boolean update=true;
		try{
			if(!ir.updateEvento(id_evento, id_encargado, nombre_evento, descripcion,
								fecha, lugar, hora, cupos, puntos, tipo_evento));
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	public boolean delEvento(int id_evento){
		boolean del=true;
		try{
			if(!ir.delEvento(id_evento))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	
	public boolean addEvento(int id_evento,int id_encargado,
							String nombre_evento,String descripcion,
							Date fecha, String lugar, String hora,
							int cupos, int puntos, String tipo_evento){
		boolean add=true;
		try{
			if(!ir.addEvento(id_evento, id_encargado, nombre_evento, descripcion,
							fecha, lugar, hora, cupos, puntos, tipo_evento))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}
	
}
