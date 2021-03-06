package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import persistence.Evento;
import persistence.Novedad;;

public interface INovedad extends Remote{
	Novedad searchNovedad(int id_novedad) throws RemoteException;
	boolean updateNovedad(int id_novedades,
						  int id_encargado,
						  String titulo,
						  String descripcion,
						  String tipo_novedad) throws RemoteException;
	boolean delNovedad(int id_novedades)throws RemoteException;
	
	List<Novedad> searchNovedades() throws RemoteException;
	
	boolean addNovedad(int id_novedades,
						  int id_encargado,
						  String titulo,
						  String descripcion,
						  String tipo_novedad)throws RemoteException;


}
