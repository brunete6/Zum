package GUI;

import java.awt.Component;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import obj.Usuario;
import javax.swing.*;

import Manejadores.ManejoGanarales;
import Manejadores.manejoUsu;
import db.Generalidades;
import obj.Usuario;

public class NuevoUsuario extends JFrame {
	private final JPanel jContentPane = new JPanel(); 
	private JLabel lblNombre = null, lblApellido=null, lblCorreo=null, lblTelefono=null, lblEstado=null, lblMetodo=null;
	private JTextField txtNombre = null, txtApellido=null, txtCorreo=null, txtTelefono=null;
	private JButton btnNuevo=null,btnSalir=null,btnLimpiar=null;
	 private JRadioButton radioActivo = null, radioDesctivo = null; 
	private  ButtonGroup grupo1= null;
	private JComboBox metodos=null;
	public NuevoUsuario() {
		this.setVisible(true);  
		 this.setTitle("Nuevo Usuario");  
		 this.setSize(720, 480);  
		 this.setLocationRelativeTo(null);  
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		 this.setContentPane(getJContentPane());  
		 this.setVisible(true);  
		 
	}
	private JPanel getJContentPane() {  
		//label
		jContentPane.setLayout(null);  
		lblNombre = new JLabel("Nombre: ");  
		lblNombre.setBounds(20, 30, 50, 20);
		lblApellido = new JLabel("Apellido: ");  
		lblApellido.setBounds(20, 60, 50, 20); 
		lblCorreo = new JLabel("Correo: ");  
		lblCorreo.setBounds(20, 90, 50, 20); 
		lblTelefono = new JLabel("Telefono: ");  
		lblTelefono.setBounds(20, 120, 50, 20); 
		lblEstado = new JLabel("Estado: ");  
		lblEstado.setBounds(20, 150, 50, 20); 
		lblMetodo = new JLabel("Metodo: ");  
		lblMetodo.setBounds(20, 180, 50, 20); 
		//Textos
		txtNombre = new JTextField();  
		txtNombre.setBounds(90, 30, 250, 20);
		txtApellido = new JTextField();  
		txtApellido.setBounds(90, 60, 250, 20);
		txtCorreo = new JTextField();  
		txtCorreo.setBounds(90, 90, 250, 20);
		txtTelefono = new JTextField();  
		txtTelefono.setBounds(90, 120, 250, 20);
	
		
		radioActivo=new JRadioButton("Activo",true);
		radioDesctivo=new JRadioButton("Desactivo",false);
		radioActivo.setBounds(90,150, 75, 20);
		radioActivo.setSelected(true);
		radioDesctivo.setBounds(170,150, 100, 20);
		grupo1 = new ButtonGroup();
		grupo1.add(radioActivo);
		grupo1.add(radioDesctivo);
		
		try {
			jContentPane.add(Combo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jContentPane.add(radioActivo);
		jContentPane.add(radioDesctivo);
		jContentPane.add(AgregarUsuario());
		jContentPane.add(txtTelefono);
		jContentPane.add(txtCorreo);
		jContentPane.add(txtApellido);
		jContentPane.add(txtNombre);
		jContentPane.add(lblMetodo);
		jContentPane.add(lblEstado);
		jContentPane.add(lblTelefono);
		jContentPane.add(lblCorreo);
		jContentPane.add(lblNombre);
		jContentPane.add(lblApellido);
		jContentPane.add(AgregarUsuario());
		jContentPane.add(Limpiar());
		jContentPane.add(Salir());
		 return jContentPane;  

	}
	private JComboBox Combo() throws SQLException {
		JComboBox<String>metodos = new JComboBox();
		metodos.setBounds(90, 180, 100, 20);
		
		for (String a : ManejoGanarales.obtenerTodosMetodos()) {
			metodos.addItem(a);
		
		}
		
		return metodos;
		
	}
	private JButton AgregarUsuario() {
		btnNuevo= new JButton("Agregar Usuario");
		btnNuevo.setBounds(60, 210, 150, 35);
		btnNuevo.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			String nombre = txtNombre.getText();			
			String Apellido = txtApellido.getText().trim();	
			String Correo = txtCorreo.getText().trim();
			String Telefono = txtTelefono.getText().trim();
			boolean estado=false;
			if (radioActivo.isSelected()) {
				estado=true;
				
			}
			String metodo = null;
			try {
				metodo= (String) Combo().getSelectedItem();
				System.out.println("se selecciono"+metodo);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (nombre.equals("")||Apellido.equals("")||Correo.equals("")||Telefono.equals("")) {
				System.out.println("faltan datos");
				
			}else {
			Usuario result = new Usuario(8,nombre,Apellido,Correo,metodo,Telefono,estado);
			try {
				manejoUsu.AgregarUsuario(result);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		 }

		
		 }); 
		return btnNuevo;
		
	}
	
	private JButton Limpiar() {
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.setBounds(220, 210, 150, 35);
		btnLimpiar.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			txtTelefono.setText("");
			txtCorreo.setText("");
			txtApellido.setText("");
			txtNombre.setText("");
			
		 }  
		 }); 

		return btnLimpiar;
		
	}
	private JButton Salir() {
		btnSalir= new JButton("Salir");
		btnSalir.setBounds(380, 210, 150, 35);
		btnSalir.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			dispose();
		 }  
		 }); 

		
		return btnSalir;
		
	}
}