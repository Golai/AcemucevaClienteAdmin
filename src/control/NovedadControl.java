package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import interfaces.INovedad;
import persistence.Evento;
import persistence.Novedad;

public class NovedadControl {

	private Novedad nov=null;
	private INovedad ir=null;
	
	public NovedadControl()throws RemoteException, NotBoundException{
		Registry r=LocateRegistry.getRegistry(10000);
		ir=(INovedad) r.lookup("Novedad");
	}
	
	public Novedad searchEvento(int id_novedad){
		try{
			nov=ir.searchNovedad(id_novedad);
		}
		catch(RemoteException e){
			e.printStackTrace();
			nov=null;
		}
		return nov;
	}
	
	public List<Novedad> searchNovedades() throws RemoteException {
		List<Novedad> l=null;
		l=ir.searchNovedades();
		return l;
		
	}
	
	public boolean updateEvento(int id_novedades, int id_encargado, 
								String titulo, String descripcion, String tipo_novedad){
		boolean update=true;
		try{
			if(!ir.updateNovedad(id_novedades, id_encargado, titulo, descripcion, tipo_novedad));
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	
	public boolean delNovedad(int id_novedades){
		boolean del=true;
		try{
			if(!ir.delNovedad(id_novedades))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	
	public boolean addNovedad(int id_novedades, int id_encargado, 
							String titulo, String descripcion, String tipo_novedad){
		boolean add=true;
		try{
			if(!ir.addNovedad(id_novedades, id_encargado, titulo, descripcion, tipo_novedad))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}
	
}
