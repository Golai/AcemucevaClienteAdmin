package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.EventoControl;
import control.NovedadControl;
import persistence.Evento;
import persistence.Novedad;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class novedadesGUI {

	private JFrame frame;
	private JTextField idNovedadAg;
	private JTextField idEncargadoAg;
	private JTextField tituloAg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField idEncargadoActu;
	private JTextField tituloActu;
	private JTextField descripcionActu;
	private JTextField novedadActu;
	private JTextField idEncargadoBuscar;
	private JTextField idNoveadBuscar;
	private JTextField tituloBuscar;
	private JTextField descripcionBuscar;
	private JTextField tipoNovedadBuscar;
	
	//////////declaraciones
	private NovedadControl novedadControl=null;
	private String tip_novedad="";
	private JTextField descripcionAg;
	private Novedad ItemNovedadEliminar=null;
	private List<Novedad> listaNovedades=null;
	//private String idEncargadoS="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					novedadesGUI window = new novedadesGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 */
	public novedadesGUI() throws RemoteException, NotBoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 */
	private void initialize() throws RemoteException, NotBoundException {
		novedadControl = new NovedadControl();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novedades");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 34, 93, 27);
		panel.add(lblNewLabel);
		
		JPanel PanelBuscar = new JPanel();
		PanelBuscar.setBounds(148, 11, 276, 239);
		panel.add(PanelBuscar);
		PanelBuscar.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("id Encargado");
		lblNewLabel_11.setBounds(10, 57, 84, 14);
		PanelBuscar.add(lblNewLabel_11);
		
		idEncargadoBuscar = new JTextField();
		idEncargadoBuscar.setEditable(false);
		idEncargadoBuscar.setBounds(100, 54, 86, 20);
		PanelBuscar.add(idEncargadoBuscar);
		idEncargadoBuscar.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("id Novedad");
		lblNewLabel_12.setBounds(10, 14, 71, 14);
		PanelBuscar.add(lblNewLabel_12);
		
		idNoveadBuscar = new JTextField();
		idNoveadBuscar.setBounds(100, 11, 86, 20);
		PanelBuscar.add(idNoveadBuscar);
		idNoveadBuscar.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Titulo");
		lblNewLabel_13.setBounds(10, 85, 46, 14);
		PanelBuscar.add(lblNewLabel_13);
		
		tituloBuscar = new JTextField();
		tituloBuscar.setEditable(false);
		tituloBuscar.setBounds(100, 82, 166, 20);
		PanelBuscar.add(tituloBuscar);
		tituloBuscar.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Descripcion");
		lblNewLabel_14.setBounds(10, 110, 71, 14);
		PanelBuscar.add(lblNewLabel_14);
		
		descripcionBuscar = new JTextField();
		descripcionBuscar.setEditable(false);
		descripcionBuscar.setBounds(100, 107, 166, 20);
		PanelBuscar.add(descripcionBuscar);
		descripcionBuscar.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("tipo novedad");
		lblNewLabel_15.setBounds(10, 135, 84, 14);
		PanelBuscar.add(lblNewLabel_15);
		
		tipoNovedadBuscar = new JTextField();
		tipoNovedadBuscar.setEditable(false);
		tipoNovedadBuscar.setBounds(100, 132, 166, 20);
		PanelBuscar.add(tipoNovedadBuscar);
		tipoNovedadBuscar.setColumns(10);
		
		JButton BotonBuscar = new JButton("Buscar");
		BotonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Novedad n=new Novedad();
				int id=Integer.parseInt(idEncargadoBuscar.getText());
				n=novedadControl.searchEvento(id);
				idEncargadoBuscar.setText(n.getId_encargado()+"");
				tituloBuscar.setText(n.getTitulo());
				descripcionBuscar.setText(n.getDescripcion());
				tipoNovedadBuscar.setText(n.getTipo_novedad());
				
			}
		});
		BotonBuscar.setBounds(72, 186, 89, 23);
		PanelBuscar.add(BotonBuscar);
		
		JPanel PanelAgregar = new JPanel();
		PanelAgregar.setBounds(148, 11, 276, 239);
		panel.add(PanelAgregar);
		PanelAgregar.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Id Novedad");
		lblNewLabel_1.setBounds(10, 11, 68, 14);
		PanelAgregar.add(lblNewLabel_1);
		
		idNovedadAg = new JTextField();
		idNovedadAg.setBounds(88, 8, 86, 20);
		PanelAgregar.add(idNovedadAg);
		idNovedadAg.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("id Encargado");
		lblNewLabel_2.setBounds(10, 50, 68, 14);
		PanelAgregar.add(lblNewLabel_2);
		
		idEncargadoAg = new JTextField();
		idEncargadoAg.setBounds(88, 47, 86, 20);
		PanelAgregar.add(idEncargadoAg);
		idEncargadoAg.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Titulo");
		lblNewLabel_3.setBounds(10, 87, 46, 14);
		PanelAgregar.add(lblNewLabel_3);
		
		tituloAg = new JTextField();
		tituloAg.setBounds(88, 84, 86, 20);
		PanelAgregar.add(tituloAg);
		tituloAg.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("tipo de novedad");
		lblNewLabel_4.setBounds(10, 152, 86, 14);
		PanelAgregar.add(lblNewLabel_4);
		
		JButton BotonAgregar = new JButton("agregar");
		BotonAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id=Integer.parseInt(idNovedadAg.getText());
				int iE=Integer.parseInt(idEncargadoAg.getText());
				novedadControl.addNovedad(id,iE
						,tituloAg.getText(),
						descripcionAg.getText(), tip_novedad);
			}
		});
		BotonAgregar.setBounds(177, 178, 89, 23);
		PanelAgregar.add(BotonAgregar);
		
		JRadioButton RadioArticuloAg = new JRadioButton("Articulo");
		RadioArticuloAg.setBounds(97, 148, 61, 23);
		PanelAgregar.add(RadioArticuloAg);
		
		JRadioButton RadioNovedadAg = new JRadioButton("Novedad");
		RadioNovedadAg.setBounds(177, 148, 74, 23);
		PanelAgregar.add(RadioNovedadAg);
		
		JLabel lblNewLabel_16 = new JLabel("descripcion");
		lblNewLabel_16.setBounds(10, 112, 68, 14);
		PanelAgregar.add(lblNewLabel_16);
		
		descripcionAg = new JTextField();
		descripcionAg.setBounds(88, 109, 86, 20);
		PanelAgregar.add(descripcionAg);
		descripcionAg.setColumns(10);
		
		JPanel PanelActualizar = new JPanel();
		PanelActualizar.setBounds(148, 11, 276, 239);
		panel.add(PanelActualizar);
		PanelActualizar.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Novedad a Modificar");
		lblNewLabel_6.setBounds(10, 11, 110, 14);
		PanelActualizar.add(lblNewLabel_6);
		
		JComboBox comboBoxActualizar = new JComboBox();
		comboBoxActualizar.setBounds(106, 36, 160, 22);
		PanelActualizar.add(comboBoxActualizar);
		
		JLabel lblNewLabel_7 = new JLabel("id Encargado");
		lblNewLabel_7.setBounds(10, 76, 75, 14);
		PanelActualizar.add(lblNewLabel_7);
		
		idEncargadoActu = new JTextField();
		idEncargadoActu.setBounds(106, 73, 160, 20);
		PanelActualizar.add(idEncargadoActu);
		idEncargadoActu.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Titulo");
		lblNewLabel_8.setBounds(10, 112, 46, 14);
		PanelActualizar.add(lblNewLabel_8);
		
		tituloActu = new JTextField();
		tituloActu.setBounds(106, 109, 160, 20);
		PanelActualizar.add(tituloActu);
		tituloActu.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("descripcion");
		lblNewLabel_9.setBounds(10, 137, 75, 14);
		PanelActualizar.add(lblNewLabel_9);
		
		descripcionActu = new JTextField();
		descripcionActu.setBounds(106, 134, 160, 20);
		PanelActualizar.add(descripcionActu);
		descripcionActu.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("tipo Novedad");
		lblNewLabel_10.setBounds(10, 162, 84, 14);
		PanelActualizar.add(lblNewLabel_10);
		
		novedadActu = new JTextField();
		novedadActu.setBounds(106, 159, 160, 20);
		PanelActualizar.add(novedadActu);
		novedadActu.setColumns(10);
		
		JButton BotonActualizar = new JButton("Actuaizar");
		BotonActualizar.setBounds(69, 205, 89, 23);
		PanelActualizar.add(BotonActualizar);
		
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBounds(148, 11, 276, 239);
		panel.add(panelEliminar);
		panelEliminar.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Novedad a eliminar");
		lblNewLabel_5.setBounds(10, 27, 107, 14);
		panelEliminar.add(lblNewLabel_5);
		
		JComboBox comboBoxEliminar = new JComboBox();
		comboBoxEliminar.setBounds(93, 52, 149, 22);
		panelEliminar.add(comboBoxEliminar);
		
		JButton BotonEliminar = new JButton("Eliminar");
		BotonEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id=ItemNovedadEliminar.getId_novedades();
				try {
					novedadControl=new NovedadControl();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				novedadControl.delNovedad(id);
			}
		});
		BotonEliminar.setBounds(93, 177, 89, 23);
		panelEliminar.add(BotonEliminar);
		////////////////////////////////////////////////RADIO BUTONS DE SALIDA///////////////////////////////////////////////
		JRadioButton RadioAgregarNovedad = new JRadioButton("Agregar Novedad");
		RadioAgregarNovedad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelAgregar.setVisible(true);
				panelEliminar.setVisible(false);
				PanelActualizar.setVisible(false);
				PanelBuscar.setVisible(false);
			}
		});
		buttonGroup.add(RadioAgregarNovedad);
		RadioAgregarNovedad.setBounds(10, 81, 119, 23);
		panel.add(RadioAgregarNovedad);
		
		JRadioButton RadioEliminarNovedad = new JRadioButton("Eliminar Novedad");
		RadioEliminarNovedad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelAgregar.setVisible(false);
				panelEliminar.setVisible(true);
				PanelActualizar.setVisible(false);
				PanelBuscar.setVisible(false);
				
				Novedad s = new Novedad();
				try {
					novedadControl=new NovedadControl();
				} catch (RemoteException | NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					listaNovedades=novedadControl.searchNovedades();
					System.out.println("listaEventos: "+listaNovedades);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=0;i<listaNovedades.size();i++) {
					s=listaNovedades.get(i);
					comboBoxEliminar.addItem(s.getTipo_novedad());
				}
				int item=comboBoxEliminar.getSelectedIndex();
				ItemNovedadEliminar=listaNovedades.get(item);
			}
		});
		buttonGroup.add(RadioEliminarNovedad);
		RadioEliminarNovedad.setBounds(10, 124, 109, 23);
		panel.add(RadioEliminarNovedad);
		
		JRadioButton RadioActualizarNovedad = new JRadioButton("Actualizar Novedad");
		RadioActualizarNovedad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelAgregar.setVisible(true);
				panelEliminar.setVisible(false);
				PanelActualizar.setVisible(true);
				PanelBuscar.setVisible(false);
			}
		});
		buttonGroup.add(RadioActualizarNovedad);
		RadioActualizarNovedad.setBounds(10, 162, 119, 23);
		panel.add(RadioActualizarNovedad);
		
		JRadioButton RadioBuscarNovedad = new JRadioButton("Buscar Novedad");
		RadioBuscarNovedad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelAgregar.setVisible(false);
				panelEliminar.setVisible(false);
				PanelActualizar.setVisible(false);
				PanelBuscar.setVisible(true);
			}
		});
		buttonGroup.add(RadioBuscarNovedad);
		RadioBuscarNovedad.setBounds(10, 199, 109, 23);
		panel.add(RadioBuscarNovedad);
	}
}
