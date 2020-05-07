package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.EventoControl;
import persistence.Evento;

import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class eventoGUI {

	private JFrame frame;
	private JTextField EventoBuscar;
	private JTextField inputTitulo;
	private JTextField inputDescripcion;
	private JTextField inputFecha;
	private JTextField inputHora;
	private JTextField inputCupos;
	private JTextField inputPuntos;
	private JTextField inputTituloActu;
	private JTextField inputDescripcionActu;
	private JTextField inputFechaActu;
	private JTextField inputHoraActu;
	private JTextField inputCuposActu;
	private JTextField inputPuntosActu;
	private JTextField inputIdEventoActu;

	/// declaracion de controles////
	private EventoControl eventoControl = null;
	private JTextField inputIdEvento;
	private Date date = null;

	///// declaracion de variables utiles/////
	String tip_evento = "";
	private JTextField LabelNombreSearch;
	private JTextField LabelDescripcionSearch;
	private JTextField LabelEncargadoSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eventoGUI window = new eventoGUI();
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
	public eventoGUI() throws RemoteException, NotBoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 */
	private void initialize() throws RemoteException, NotBoundException {
		eventoControl=new EventoControl();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Eventos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(24, 27, 83, 28);
		panel.add(lblNewLabel);

		JPanel PanelSeleccionarAsistencia = new JPanel();
		PanelSeleccionarAsistencia.setBounds(159, 27, 265, 206);
		panel.add(PanelSeleccionarAsistencia);
		PanelSeleccionarAsistencia.setLayout(null);

		JButton BuscarEvento = new JButton("Seleccionar evento");
		BuscarEvento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int buscar=Integer.parseInt(EventoBuscar.getText());
				Evento ojala = new Evento(buscar);
				
				ojala = eventoControl.searchEvento(buscar);
				System.out.println("ojala funcione diosito lindo " +ojala);
				String n=ojala.getNombre_evento();
				LabelNombreSearch.setText(n);
				String d=ojala.getDescripcion();
				LabelDescripcionSearch.setText(d);
				String e1=ojala.getId_encargado()+"";
				LabelEncargadoSearch.setText(e1);

			}
		});
		BuscarEvento.setBounds(115, 158, 140, 23);
		PanelSeleccionarAsistencia.add(BuscarEvento);

		EventoBuscar = new JTextField();
		EventoBuscar.setBounds(113, 11, 118, 20);
		PanelSeleccionarAsistencia.add(EventoBuscar);
		EventoBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Id del evento");
		lblNewLabel_4.setBounds(10, 14, 82, 14);
		PanelSeleccionarAsistencia.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("nombre");
		lblNewLabel_5.setBounds(10, 53, 46, 14);
		PanelSeleccionarAsistencia.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("descripcion");
		lblNewLabel_6.setBounds(10, 78, 65, 14);
		PanelSeleccionarAsistencia.add(lblNewLabel_6);

		LabelNombreSearch = new JTextField();
		LabelNombreSearch.setEditable(false);
		LabelNombreSearch.setBounds(115, 50, 86, 20);
		PanelSeleccionarAsistencia.add(LabelNombreSearch);
		LabelNombreSearch.setColumns(10);

		LabelDescripcionSearch = new JTextField();
		LabelDescripcionSearch.setEditable(false);
		LabelDescripcionSearch.setBounds(115, 75, 86, 20);
		PanelSeleccionarAsistencia.add(LabelDescripcionSearch);
		LabelDescripcionSearch.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Encargado");
		lblNewLabel_7.setBounds(10, 103, 65, 14);
		PanelSeleccionarAsistencia.add(lblNewLabel_7);

		LabelEncargadoSearch = new JTextField();
		LabelEncargadoSearch.setBounds(115, 100, 86, 20);
		PanelSeleccionarAsistencia.add(LabelEncargadoSearch);
		LabelEncargadoSearch.setColumns(10);

		JPanel PanelActualizarEvento = new JPanel();
		PanelActualizarEvento.setBounds(159, 11, 265, 222);
		panel.add(PanelActualizarEvento);
		PanelActualizarEvento.setLayout(null);

		JLabel Titulo_1 = new JLabel("Titulo");
		Titulo_1.setBounds(6, 27, 46, 14);
		PanelActualizarEvento.add(Titulo_1);

		inputTituloActu = new JTextField();
		inputTituloActu.setColumns(10);
		inputTituloActu.setBounds(75, 24, 176, 20);
		PanelActualizarEvento.add(inputTituloActu);

		JLabel Descripcion_1 = new JLabel("Descripcion");
		Descripcion_1.setBounds(6, 52, 65, 14);
		PanelActualizarEvento.add(Descripcion_1);

		inputDescripcionActu = new JTextField();
		inputDescripcionActu.setColumns(10);
		inputDescripcionActu.setBounds(75, 49, 176, 20);
		PanelActualizarEvento.add(inputDescripcionActu);

		JLabel Fecha_1 = new JLabel("Fecha");
		Fecha_1.setBounds(6, 77, 46, 14);
		PanelActualizarEvento.add(Fecha_1);

		inputFechaActu = new JTextField();
		inputFechaActu.setColumns(10);
		inputFechaActu.setBounds(75, 74, 176, 20);
		PanelActualizarEvento.add(inputFechaActu);

		JLabel Hora_1 = new JLabel("Hora");
		Hora_1.setBounds(6, 102, 46, 14);
		PanelActualizarEvento.add(Hora_1);

		inputHoraActu = new JTextField();
		inputHoraActu.setColumns(10);
		inputHoraActu.setBounds(75, 99, 176, 20);
		PanelActualizarEvento.add(inputHoraActu);

		JLabel Cupos_1 = new JLabel("Cupos");
		Cupos_1.setBounds(6, 127, 46, 14);
		PanelActualizarEvento.add(Cupos_1);

		inputCuposActu = new JTextField();
		inputCuposActu.setColumns(10);
		inputCuposActu.setBounds(75, 124, 176, 20);
		PanelActualizarEvento.add(inputCuposActu);

		JLabel Puntos_1 = new JLabel("Puntos");
		Puntos_1.setBounds(6, 152, 46, 14);
		PanelActualizarEvento.add(Puntos_1);

		inputPuntosActu = new JTextField();
		inputPuntosActu.setColumns(10);
		inputPuntosActu.setBounds(75, 149, 176, 20);
		PanelActualizarEvento.add(inputPuntosActu);

		JLabel lblNewLabel_1_1 = new JLabel("Tipo de evento");
		lblNewLabel_1_1.setBounds(6, 177, 83, 14);
		PanelActualizarEvento.add(lblNewLabel_1_1);

		JRadioButton RadioPrivadoActu = new JRadioButton("Privado");
		RadioPrivadoActu.setBounds(95, 176, 65, 23);
		PanelActualizarEvento.add(RadioPrivadoActu);

		JRadioButton RadioPublicoActu = new JRadioButton("Publico");
		RadioPublicoActu.setBounds(162, 173, 65, 23);
		PanelActualizarEvento.add(RadioPublicoActu);

		JButton BotonActualizar = new JButton("Guardar");
		BotonActualizar.setBounds(162, 199, 89, 23);
		PanelActualizarEvento.add(BotonActualizar);

		JButton BotonCancelar = new JButton("Cancelar");
		BotonCancelar.setBounds(0, 199, 89, 23);
		PanelActualizarEvento.add(BotonCancelar);

		JLabel lblNewLabel_2 = new JLabel("ID Evento");
		lblNewLabel_2.setBounds(6, 2, 65, 14);
		PanelActualizarEvento.add(lblNewLabel_2);

		inputIdEventoActu = new JTextField();
		inputIdEventoActu.setBounds(75, -1, 176, 20);
		PanelActualizarEvento.add(inputIdEventoActu);
		inputIdEventoActu.setColumns(10);

		JPanel PanelAgregar = new JPanel();
		PanelAgregar.setBounds(159, 11, 265, 222);
		panel.add(PanelAgregar);
		PanelAgregar.setLayout(null);

		JLabel Titulo = new JLabel("Titulo");
		Titulo.setBounds(6, 27, 46, 14);
		PanelAgregar.add(Titulo);

		inputTitulo = new JTextField();
		inputTitulo.setBounds(75, 24, 176, 20);
		PanelAgregar.add(inputTitulo);
		inputTitulo.setColumns(10);

		JLabel Descripcion = new JLabel("Descripcion");
		Descripcion.setBounds(6, 52, 65, 14);
		PanelAgregar.add(Descripcion);

		inputDescripcion = new JTextField();
		inputDescripcion.setBounds(75, 49, 176, 20);
		PanelAgregar.add(inputDescripcion);
		inputDescripcion.setColumns(10);

		JLabel Fecha = new JLabel("Fecha");
		Fecha.setBounds(6, 77, 46, 14);
		PanelAgregar.add(Fecha);

		inputFecha = new JTextField();
		inputFecha.setBounds(75, 74, 176, 20);
		PanelAgregar.add(inputFecha);
		inputFecha.setColumns(10);

		JLabel Hora = new JLabel("Hora");
		Hora.setBounds(6, 102, 46, 14);
		PanelAgregar.add(Hora);

		inputHora = new JTextField();
		inputHora.setBounds(75, 99, 176, 20);
		PanelAgregar.add(inputHora);
		inputHora.setColumns(10);

		JLabel Cupos = new JLabel("Cupos");
		Cupos.setBounds(6, 127, 46, 14);
		PanelAgregar.add(Cupos);

		inputCupos = new JTextField();
		inputCupos.setBounds(75, 124, 176, 20);
		PanelAgregar.add(inputCupos);
		inputCupos.setColumns(10);

		JLabel Puntos = new JLabel("Puntos");
		Puntos.setBounds(6, 152, 46, 14);
		PanelAgregar.add(Puntos);

		inputPuntos = new JTextField();
		inputPuntos.setBounds(75, 149, 176, 20);
		PanelAgregar.add(inputPuntos);
		inputPuntos.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tipo de evento");
		lblNewLabel_1.setBounds(6, 177, 83, 14);
		PanelAgregar.add(lblNewLabel_1);

		JRadioButton RadioPrivadoA = new JRadioButton("Privado");
		RadioPrivadoA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tip_evento = "privado";
			}
		});
		RadioPrivadoA.setBounds(99, 160, 65, 23);
		PanelAgregar.add(RadioPrivadoA);

		JRadioButton RadioPublicoA = new JRadioButton("Publico");
		RadioPublicoA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tip_evento = "publico";
			}
		});
		RadioPublicoA.setBounds(175, 160, 65, 23);
		PanelAgregar.add(RadioPublicoA);

		JButton BotonAgregar = new JButton("Guardar");
		BotonAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/////////// metodo para agregar//////////////
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				try {
					java.util.Date da = sdf.parse(inputFecha.getText());
					date = new Date(da.getTime());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					eventoControl = new EventoControl();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int id_evento = Integer.parseInt(inputIdEvento.getText());
				int id_encargado = 1;
				eventoControl.addEvento(id_evento, id_encargado, inputTitulo.getText(), inputDescripcion.getText(),
						date, "tulua", inputHora.getText(), Integer.parseInt(inputCupos.getText()),
						Integer.parseInt(inputPuntos.getText()), tip_evento);

			}
		});
		BotonAgregar.setBounds(162, 199, 89, 23);
		PanelAgregar.add(BotonAgregar);

		JButton BotonVaciarA = new JButton("Vaciar");
		BotonVaciarA.setBounds(95, 199, 65, 23);
		PanelAgregar.add(BotonVaciarA);

		JButton BotonCancelarA = new JButton("Cancelar");
		BotonCancelarA.setBounds(0, 199, 89, 23);
		PanelAgregar.add(BotonCancelarA);

		JLabel lblNewLabel_3 = new JLabel("id Evento");
		lblNewLabel_3.setBounds(6, 2, 65, 14);
		PanelAgregar.add(lblNewLabel_3);

		inputIdEvento = new JTextField();
		inputIdEvento.setBounds(78, -1, 86, 20);
		PanelAgregar.add(inputIdEvento);
		inputIdEvento.setColumns(10);

		JPanel PanelCancelarEvento = new JPanel();
		PanelCancelarEvento.setBounds(159, 27, 265, 206);
		panel.add(PanelCancelarEvento);
		PanelCancelarEvento.setLayout(null);

		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "evento1", "evento2", "evento3" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(241, 148, -217, -143);
		PanelCancelarEvento.add(list);

		JButton cancelarEv = new JButton("guardar");
		cancelarEv.setBounds(76, 160, 89, 23);
		PanelCancelarEvento.add(cancelarEv);

		JRadioButton RadioAgregar = new JRadioButton("agregar");
		RadioAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelSeleccionarAsistencia.setVisible(false);
				PanelAgregar.setVisible(true);
				PanelCancelarEvento.setVisible(false);
				PanelActualizarEvento.setVisible(false);

			}
		});
		RadioAgregar.setBounds(6, 62, 77, 23);
		panel.add(RadioAgregar);

		JRadioButton RadioSeleccionarAsistencia = new JRadioButton("seleccionar asistencia");
		RadioSeleccionarAsistencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelSeleccionarAsistencia.setVisible(true);
				PanelAgregar.setVisible(false);
				PanelCancelarEvento.setVisible(false);
				PanelActualizarEvento.setVisible(false);

				
			}
		});
		RadioSeleccionarAsistencia.setBounds(6, 88, 147, 23);
		panel.add(RadioSeleccionarAsistencia);

		JRadioButton RadioCancelarEvento = new JRadioButton("Cancelar Evento");
		RadioCancelarEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelSeleccionarAsistencia.setVisible(false);
				PanelAgregar.setVisible(false);
				PanelCancelarEvento.setVisible(true);
				PanelActualizarEvento.setVisible(false);
			}
		});
		RadioCancelarEvento.setBounds(6, 114, 109, 23);
		panel.add(RadioCancelarEvento);

		JRadioButton RadioActualizarEvento = new JRadioButton("actualizar Evento");
		RadioActualizarEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelSeleccionarAsistencia.setVisible(false);
				PanelAgregar.setVisible(false);
				PanelCancelarEvento.setVisible(false);
				PanelActualizarEvento.setVisible(true);
			}
		});
		RadioActualizarEvento.setBounds(6, 140, 109, 23);
		panel.add(RadioActualizarEvento);

	}
}
