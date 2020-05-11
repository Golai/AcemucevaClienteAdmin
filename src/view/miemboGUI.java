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
import java.sql.Date;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import control.MiembroControl;
import persistence.Miembro;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class miemboGUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField idCargoAg;
	private JTextField idMiembroAg;
	private JTextField nombreAg;
	private JTextField celularAg;
	private JTextField semestreAg;
	private JTextField idMiembroEli;
	private JTextField cedulaBuscar;
	private JTextField idCargoBuscar;
	private JTextField nombreBuscar;
	private JTextField celularBuscar;
	private JTextField semestreBuscar;
	private JTextField puntosBuscar;
	private JTextField cedulaActu;
	private JTextField nombreActu;
	private JTextField semestreActu;
	private JTextField puntosActu;

	//////////////////// decalracion de variables utiles////
	private Miembro ItemMiembroEliminar = null;
	List<Miembro> listaMiembros = null;
	private MiembroControl miembroControl = null;
	private Date date = null;
	private JTextField idCargoActu;
	private JTextField celularActu;
	private JTextField emailAg;
	private JTextField emailActu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miemboGUI window = new miemboGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 */
	public miemboGUI() throws RemoteException, NotBoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws RemoteException, NotBoundException {
		miembroControl = new MiembroControl();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Miembros");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 31, 89, 33);
		panel.add(lblNewLabel);

		JPanel panelActualizar = new JPanel();
		panelActualizar.setBounds(131, 11, 293, 239);
		panel.add(panelActualizar);
		panelActualizar.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("cedula");
		lblNewLabel_13.setBounds(10, 26, 46, 14);
		panelActualizar.add(lblNewLabel_13);

		cedulaActu = new JTextField();
		cedulaActu.setBounds(90, 23, 193, 20);
		panelActualizar.add(cedulaActu);
		cedulaActu.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Cargo");
		lblNewLabel_14.setBounds(10, 51, 46, 14);
		panelActualizar.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Nombre");
		lblNewLabel_15.setBounds(10, 76, 46, 14);
		panelActualizar.add(lblNewLabel_15);

		nombreActu = new JTextField();
		nombreActu.setEditable(false);
		nombreActu.setColumns(10);
		nombreActu.setBounds(90, 73, 193, 20);
		panelActualizar.add(nombreActu);

		JLabel lblNewLabel_16 = new JLabel("Semestre");
		lblNewLabel_16.setBounds(10, 146, 46, 14);
		panelActualizar.add(lblNewLabel_16);

		semestreActu = new JTextField();
		semestreActu.setEditable(false);
		semestreActu.setBounds(90, 143, 193, 20);
		panelActualizar.add(semestreActu);
		semestreActu.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Puntos");
		lblNewLabel_17.setBounds(10, 171, 46, 14);
		panelActualizar.add(lblNewLabel_17);

		puntosActu = new JTextField();
		puntosActu.setEditable(false);
		puntosActu.setColumns(10);
		puntosActu.setBounds(90, 168, 193, 20);
		panelActualizar.add(puntosActu);

		idCargoActu = new JTextField();
		idCargoActu.setEditable(false);
		idCargoActu.setColumns(10);
		idCargoActu.setBounds(90, 48, 193, 20);
		panelActualizar.add(idCargoActu);

		

		JLabel lblNewLabel_18 = new JLabel("celular");
		lblNewLabel_18.setBounds(10, 101, 46, 14);
		panelActualizar.add(lblNewLabel_18);

		celularActu = new JTextField();
		celularActu.setEditable(false);
		celularActu.setBounds(90, 98, 193, 20);
		panelActualizar.add(celularActu);
		celularActu.setColumns(10);

		

		JLabel lblNewLabel_20 = new JLabel("email");
		lblNewLabel_20.setBounds(10, 126, 46, 14);
		panelActualizar.add(lblNewLabel_20);

		emailActu = new JTextField();
		emailActu.setBounds(90, 123, 193, 20);
		panelActualizar.add(emailActu);
		emailActu.setColumns(10);

		JPanel panelAgregar = new JPanel();
		panelAgregar.setBounds(131, 11, 293, 239);
		panel.add(panelAgregar);
		panelAgregar.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("cedula");
		lblNewLabel_1.setBounds(10, 11, 71, 14);
		panelAgregar.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("id cargo");
		lblNewLabel_2.setBounds(10, 36, 46, 14);
		panelAgregar.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("nombre");
		lblNewLabel_3.setBounds(10, 61, 46, 14);
		panelAgregar.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Celular");
		lblNewLabel_4.setBounds(10, 86, 46, 14);
		panelAgregar.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("semestre");
		lblNewLabel_5.setBounds(10, 140, 46, 14);
		panelAgregar.add(lblNewLabel_5);

		idCargoAg = new JTextField();
		idCargoAg.setBounds(91, 33, 192, 20);
		panelAgregar.add(idCargoAg);
		idCargoAg.setColumns(10);

		idMiembroAg = new JTextField();
		idMiembroAg.setColumns(10);
		idMiembroAg.setBounds(91, 8, 192, 20);
		panelAgregar.add(idMiembroAg);

		nombreAg = new JTextField();
		nombreAg.setColumns(10);
		nombreAg.setBounds(91, 58, 192, 20);
		panelAgregar.add(nombreAg);

		celularAg = new JTextField();
		celularAg.setColumns(10);
		celularAg.setBounds(91, 83, 192, 20);
		panelAgregar.add(celularAg);

		semestreAg = new JTextField();
		semestreAg.setColumns(10);
		semestreAg.setBounds(91, 137, 192, 20);
		panelAgregar.add(semestreAg);

		JLabel lblNewLabel_19 = new JLabel("email");
		lblNewLabel_19.setBounds(10, 111, 46, 14);
		panelAgregar.add(lblNewLabel_19);

		emailAg = new JTextField();
		emailAg.setBounds(91, 108, 192, 20);
		panelAgregar.add(emailAg);
		emailAg.setColumns(10);

		JPanel panelBuscar = new JPanel();
		panelBuscar.setBounds(131, 11, 293, 239);
		panel.add(panelBuscar);
		panelBuscar.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("cedula");
		lblNewLabel_7.setBounds(10, 39, 46, 14);
		panelBuscar.add(lblNewLabel_7);

		cedulaBuscar = new JTextField();
		cedulaBuscar.setBounds(119, 36, 153, 20);
		panelBuscar.add(cedulaBuscar);
		cedulaBuscar.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Id Cargo");
		lblNewLabel_8.setBounds(10, 64, 46, 14);
		panelBuscar.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Nombre");
		lblNewLabel_9.setBounds(10, 89, 46, 14);
		panelBuscar.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Celular");
		lblNewLabel_10.setBounds(10, 114, 46, 14);
		panelBuscar.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Semestre");
		lblNewLabel_11.setBounds(10, 139, 46, 14);
		panelBuscar.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Puntos");
		lblNewLabel_12.setBounds(10, 164, 46, 14);
		panelBuscar.add(lblNewLabel_12);

		idCargoBuscar = new JTextField();
		idCargoBuscar.setEditable(false);
		idCargoBuscar.setColumns(10);
		idCargoBuscar.setBounds(119, 61, 153, 20);
		panelBuscar.add(idCargoBuscar);

		nombreBuscar = new JTextField();
		nombreBuscar.setEditable(false);
		nombreBuscar.setColumns(10);
		nombreBuscar.setBounds(119, 86, 153, 20);
		panelBuscar.add(nombreBuscar);

		celularBuscar = new JTextField();
		celularBuscar.setEditable(false);
		celularBuscar.setColumns(10);
		celularBuscar.setBounds(119, 111, 153, 20);
		panelBuscar.add(celularBuscar);

		semestreBuscar = new JTextField();
		semestreBuscar.setEditable(false);
		semestreBuscar.setColumns(10);
		semestreBuscar.setBounds(119, 136, 153, 20);
		panelBuscar.add(semestreBuscar);

		puntosBuscar = new JTextField();
		puntosBuscar.setEditable(false);
		puntosBuscar.setColumns(10);
		puntosBuscar.setBounds(119, 161, 153, 20);
		panelBuscar.add(puntosBuscar);

		

		JPanel panelEliminar = new JPanel();
		panelEliminar.setBounds(131, 11, 293, 239);
		panel.add(panelEliminar);
		panelEliminar.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Cedula de miembro a eliminar");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 73, 206, 14);
		panelEliminar.add(lblNewLabel_6);

		idMiembroEli = new JTextField();
		idMiembroEli.setBounds(130, 98, 86, 20);
		panelEliminar.add(idMiembroEli);
		idMiembroEli.setColumns(10);

		

		////////////////////////////////////////////////////// BOTONES--------------------------------------------------------------
		JButton buttonAgregar = new JButton("Agregar");
		buttonAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idMiembroAg.getText());
				int idC = Integer.parseInt(idCargoAg.getText());
				int celular = Integer.parseInt(celularAg.getText());
				int semestre = Integer.parseInt(semestreAg.getText());
				try {
					guardarA(id, idC, nombreAg.getText(), celular, emailAg.getText(), semestre, 0);
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		buttonAgregar.setBounds(91, 168, 89, 23);
		panelAgregar.add(buttonAgregar);

		JButton buttonEliminar = new JButton("Eliminar");
		buttonEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int cedula = Integer.parseInt(idMiembroEli.getText());
				eliminar(cedula);
			}
		});
		buttonEliminar.setBounds(79, 159, 89, 23);
		panelEliminar.add(buttonEliminar);
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int cedula = Integer.parseInt(cedulaBuscar.getText());
				try {
					miembroControl = new MiembroControl();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Miembro m = new Miembro();
				m = miembroControl.searchMiembro(cedula);
				System.out.println("cedula en el gui" + cedula);
				System.out.println("miembro que llega al gui: " + m);
				idCargoBuscar.setText(m.getId_cargo() + "");
				nombreBuscar.setText(m.getNombre());
				celularBuscar.setText(m.getCelular() + "");
				semestreBuscar.setText(m.getSemestre() + "");
				puntosBuscar.setText(m.getPuntos() + "");

			}
		});
		buttonBuscar.setBounds(69, 192, 89, 23);
		panelBuscar.add(buttonBuscar);
		
		JButton buttonBuscarActu = new JButton("Buscar");
		buttonBuscarActu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int cedula = Integer.parseInt(cedulaActu.getText());
				try {
					miembroControl = new MiembroControl();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Miembro m = new Miembro();
				m = miembroControl.searchMiembro(cedula);
				idCargoActu.setText(m.getId_cargo() + "");
				nombreActu.setText(m.getNombre());
				celularActu.setText(m.getCelular() + "");
				semestreActu.setText(m.getSemestre() + "");
				puntosActu.setText(m.getPuntos() + "");

				// lo volvemos editables
				cedulaActu.setEditable(false);
				idCargoActu.setEditable(true);
				nombreActu.setEditable(true);
				celularActu.setEditable(true);
				semestreActu.setEditable(true);
				puntosActu.setEditable(true);
			}
		});
		buttonBuscarActu.setBounds(20, 205, 89, 23);
		panelActualizar.add(buttonBuscarActu);
		
		JButton buttonActualizar = new JButton("Actualizar");
		buttonActualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				////// guardar///
				int id = Integer.parseInt(cedulaActu.getText());
				int idC = Integer.parseInt(idCargoActu.getText());
				int celular = Integer.parseInt(celularActu.getText());
				int semestre = Integer.parseInt(semestreActu.getText());
				int puntos = Integer.parseInt(puntosActu.getText());
				try {
					guardarActu(id, idC, nombreActu.getText(), celular, semestre, puntos);
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		buttonActualizar.setBounds(157, 205, 89, 23);
		panelActualizar.add(buttonActualizar);
		
		
		
		////////////////////////////////////////////////////// RADIO BUTTONS//////////////////////////////////////////////////////////
		JRadioButton radioAgregarMiembro = new JRadioButton("Agregar miembro");
		radioAgregarMiembro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelAgregar.setVisible(true);
				panelEliminar.setVisible(false);
				panelBuscar.setVisible(false);
				panelActualizar.setVisible(false);

			}
		});
		buttonGroup.add(radioAgregarMiembro);
		radioAgregarMiembro.setBounds(6, 83, 109, 23);
		panel.add(radioAgregarMiembro);

		JRadioButton radioEliminarMiembro = new JRadioButton("Eliminar miembro");
		radioEliminarMiembro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelAgregar.setVisible(false);
				panelEliminar.setVisible(true);
				panelBuscar.setVisible(false);
				panelActualizar.setVisible(false);

				

			}
		});
		buttonGroup.add(radioEliminarMiembro);
		radioEliminarMiembro.setBounds(10, 109, 109, 23);
		panel.add(radioEliminarMiembro);

		JRadioButton radioBuscarMiembro = new JRadioButton("Buscar miembro");
		radioBuscarMiembro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelAgregar.setVisible(false);
				panelEliminar.setVisible(false);
				panelBuscar.setVisible(true);
				panelActualizar.setVisible(false);
			}
		});
		buttonGroup.add(radioBuscarMiembro);
		radioBuscarMiembro.setBounds(10, 135, 109, 23);
		panel.add(radioBuscarMiembro);

		JRadioButton radioActualizarMiembro = new JRadioButton("Actualizar miembro");
		radioActualizarMiembro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelAgregar.setVisible(false);
				panelEliminar.setVisible(false);
				panelBuscar.setVisible(false);
				panelActualizar.setVisible(true);
			}
		});
		buttonGroup.add(radioActualizarMiembro);
		radioActualizarMiembro.setBounds(10, 161, 115, 23);
		panel.add(radioActualizarMiembro);
	}

	////////////////////////////////////////////////// mewtodos
	public void guardarA(int cedula, int id_c, String nombre, int celular, String email, int semestre, int puntos)
			throws RemoteException, NotBoundException {

		miembroControl = new MiembroControl();
		miembroControl.addMiembro(cedula, id_c, nombre, celular, email, semestre, 0);
	}

	public void guardarActu(int cedula, int id_c, String nombre, int celular, int semestre, int puntos)
			throws RemoteException, NotBoundException {

		miembroControl = new MiembroControl();
		miembroControl.updateMiembro(cedula, id_c, nombreAg.getText(), celular, semestre, 0);
	}
	
	public void eliminar(int cedula) {
		

		try {
			miembroControl = new MiembroControl();
		} catch (RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		miembroControl.delMiembro(cedula);
	}
}
