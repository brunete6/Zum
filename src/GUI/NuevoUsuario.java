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
import db.usaurio;
import obj.Usuario;

public class NuevoUsuario extends JFrame {
	protected static final Component Jframe = null;
	private final JPanel jContentPane = new JPanel(); 
	private JLabel lblci=null,lblNombre = null, lblApellido=null, lblCorreo=null, lblTelefono=null, lblEstado=null, lblMetodo=null;
	private JTextField txtci=null,txtNombre = null, txtApellido=null, txtCorreo=null, txtTelefono=null;
	private JButton btnNuevo=null,btnSalir=null,btnLimpiar=null,btnBuscar=null,btnModificar=null;
	 private JRadioButton radioActivo = null, radioDesctivo = null; 
	private  ButtonGroup grupo1= null;
	private JComboBox<String> metodos=null;
	private String res ;
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
		lblci=new JLabel("CI: ");
		lblci.setBounds(20, 20, 50, 20);
		lblNombre = new JLabel("Nombre: ");  
		lblNombre.setBounds(20, 50, 50, 20);
		lblApellido = new JLabel("Apellido: ");  
		lblApellido.setBounds(20, 80, 50, 20); 
		lblCorreo = new JLabel("Correo: ");  
		lblCorreo.setBounds(20, 110, 50, 20); 
		lblTelefono = new JLabel("Telefono: ");  
		lblTelefono.setBounds(20, 140, 50, 20); 
		lblEstado = new JLabel("Estado: ");  
		lblEstado.setBounds(20, 170, 50, 20); 
		lblMetodo = new JLabel("Metodo: ");  
		lblMetodo.setBounds(20, 200, 50, 20); 
		//Textos
		txtNombre = new JTextField();  
		txtNombre.setBounds(90, 50, 250, 20);
		txtci= new JTextField();
		txtci.setBounds(90, 20, 250, 20);
		txtApellido = new JTextField();  
		txtApellido.setBounds(90, 80, 250, 20);
		txtCorreo = new JTextField();  
		txtCorreo.setBounds(90, 110, 250, 20);
		txtTelefono = new JTextField();  
		txtTelefono.setBounds(90, 140, 250, 20);
	
		//radios
		radioActivo=new JRadioButton("Activo",true);
		radioDesctivo=new JRadioButton("Desactivo",false);
		radioActivo.setBounds(90,170, 75, 20);
		radioActivo.setSelected(true);
		radioDesctivo.setBounds(170,170, 100, 20);
		grupo1 = new ButtonGroup();
		grupo1.add(radioActivo);
		grupo1.add(radioDesctivo);
		//Jbox
		metodos= new JComboBox<String>();
		metodos.setBounds(90, 200, 100, 20);
		metodos.addItem("Seleccionar Opción");
		metodos.addItem("Clase");
		metodos.addItem("Mensual");
		
		
		jContentPane.add(metodos);
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
		jContentPane.add(txtci);
		jContentPane.add(lblci);
		jContentPane.add(Buscar());
		jContentPane.add(Modificar());
		 return jContentPane;  

	}


	private JButton AgregarUsuario() {
		btnNuevo= new JButton("Agregar Usuario");
		btnNuevo.setBounds(60, 230, 150, 35);
		btnNuevo.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();			
				String Apellido = txtApellido.getText().trim();	
				String Correo = txtCorreo.getText().trim();
				String Telefono = txtTelefono.getText().trim();
				int ci=0;
				try{
					 ci = Integer.parseInt(txtci.getText().trim());
				} catch (Exception e1){
					JOptionPane.showMessageDialog(Jframe, "La CI debe ser un número entero.", "Datos incorrectos!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				boolean estado=false;
				if (radioActivo.isSelected()) {
					estado=true;
				
				}
				res = (String) metodos.getSelectedItem();
				if (nombre.equals("")||Apellido.equals("")||Correo.equals("")||Telefono.equals("")||res.equals("Seleccionar Opción")||ci==0) {
					JOptionPane.showMessageDialog(Jframe, "Faltan datos o la cedula no puede ser 0", "Datos incompletos!",JOptionPane.WARNING_MESSAGE);
				
				}else{
					if(!manejoUsu.existeUsuario(ci)) {
						Usuario result = new Usuario(ci,nombre,Apellido,Correo,res,Telefono,estado);
						try {
							if(manejoUsu.AgregarUsuario(result)) {
								JOptionPane.showMessageDialog(Jframe, "Se agrego correctamente el usuario" + nombre, "Ingreso Correcto",JOptionPane.INFORMATION_MESSAGE);	
								Limpiar();
							}else {
								JOptionPane.showMessageDialog(Jframe, "No se pudo agregar el usuario", "ERROR FATAL!",JOptionPane.ERROR_MESSAGE);		
							}
						}catch (SQLException e1) {
							JOptionPane.showMessageDialog(Jframe, e1, "Error al Agregar!",JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(Jframe, "Ya existe un usuario con ese documento", "Atención!",JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}


		
		 }); 
		return btnNuevo;
		
	}
	
	
	private JButton Limpiar() {
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.setBounds(220, 230, 150, 35);
		btnLimpiar.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			txtTelefono.setText("");
			txtCorreo.setText("");
			txtApellido.setText("");
			txtNombre.setText("");
			txtci.setText("");
			txtci.setEditable(true);
			btnModificar.setEnabled(false);
			btnNuevo.setEnabled(true);
			
		 }  
		 }); 

		return btnLimpiar;
		
	}
	private JButton Salir() {
		btnSalir= new JButton("Salir");
		btnSalir.setBounds(380, 230, 150, 35);
		btnSalir.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			dispose();
		 }  
		 }); 

		
		return btnSalir;
		
	}
	private JButton Buscar() {
		btnBuscar= new JButton("Buscar");
		btnBuscar.setBounds(380, 30, 150, 35);
		btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ci=0;
			try{
				 ci = Integer.parseInt(txtci.getText().trim());
			} catch (Exception e1){
				JOptionPane.showMessageDialog(Jframe, "La CI debe ser un número entero.", "Datos incorrectos!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(manejoUsu.existeUsuario(ci)) {
				Usuario res = manejoUsu.obtenerUsuario(ci);
				txtTelefono.setText(res.getTelefono());
				txtCorreo.setText(res.getCorroe());
				txtApellido.setText(res.getApellido());
				txtNombre.setText(res.getNombre());
				txtci.setEditable(false);
				btnModificar.setEnabled(true);
				btnNuevo.setEnabled(false);
				
			}
			
			
		 }  
		 }); 

		
		return btnBuscar;
		
	}
	private JButton Modificar() {
		btnModificar= new JButton("Modificar");
		btnModificar.setBounds(380, 90, 150, 35);
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			String nombre = txtNombre.getText();			
			String Apellido = txtApellido.getText().trim();	
			String Correo = txtCorreo.getText().trim();
			String Telefono = txtTelefono.getText().trim();
			int ci=0;
			ci = Integer.parseInt(txtci.getText().trim());
			boolean estado=false;
			if (radioActivo.isSelected()) {
				estado=true;
			
			}
			res = (String) metodos.getSelectedItem();
			if (nombre.equals("")||Apellido.equals("")||Correo.equals("")||Telefono.equals("")||res.equals("Seleccionar Opción")) {
				JOptionPane.showMessageDialog(Jframe, "Faltan datos o la cedula no puede ser 0", "Datos incompletos!",JOptionPane.WARNING_MESSAGE);
			
			}else{
					Usuario result = new Usuario(ci,nombre,Apellido,Correo,res,Telefono,estado);
					try {
						if(manejoUsu.UpdateUser(result)) {
							JOptionPane.showMessageDialog(Jframe, "Se Modifico correctamente el usuario" + nombre, "Ingreso Correcto",JOptionPane.INFORMATION_MESSAGE);	
							Limpiar();
							txtci.setEditable(true);
							btnNuevo.setEnabled(true);
						}else {
							JOptionPane.showMessageDialog(Jframe, "No se pudo modificar el usuario", "ERROR FATAL!",JOptionPane.ERROR_MESSAGE);		
						}
					}catch (SQLException e1) {
						JOptionPane.showMessageDialog(Jframe, e1, "Error al Modificar!",JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
				
			}
		}
			
		 }  
		 }); 

		
		return btnModificar;
		
	}
}