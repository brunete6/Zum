package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;

import Manejadores.manejoUsu;
import obj.Usuario;

public class Facturacion extends JFrame {
	protected static final Component Jframe = null;
	private final JPanel jContentPane = new JPanel(); 
	private JButton btnFactura=null, btnBuscaruser=null, btnDesplegar=null;
	private JLabel lblId=null,lblResId = null,lblNombre = null,lblResNombre = null, lblunidad=null, lblfecha=null, lblci=null, lbltipo=null, lblTotal=null, lblResTotal=null;
	private JTextField txtci=null,txtTotal = null, txtApellido=null, txtCorreo=null, txtTelefono=null;
	private JComboBox<String> unidades=null;
	private JComboBox<String> metodos=null;
	public Facturacion() {
		 this.setVisible(true);  
		 this.setTitle("Facturación");  
		 this.setSize(720, 480);  
		 this.setLocationRelativeTo(null);  
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		 this.setContentPane(getJContentPane());  
		 this.setVisible(true);  
		 
	}
	
	private JPanel getJContentPane() { 
		jContentPane.setLayout(null);
		lblId=new JLabel("ID: ",SwingConstants.RIGHT);
		lblId.setBounds(20, 20, 120, 20);
		
		lblResId=new JLabel(" ");
		lblResId.setBounds(80, 20, 120, 20);
		
		lblci=new JLabel("Ci ",SwingConstants.RIGHT);
		lblci.setBounds(20, 50, 120, 20);
		
		txtci=new JTextField();
		txtci.setBounds(145, 50, 100, 20);
		
		lblNombre=new JLabel("Nombre Completo: ",SwingConstants.RIGHT);
		lblNombre.setBounds(20, 80, 120, 20);
		
		lblResNombre=new JLabel(" ");
		lblResNombre.setBounds(145, 80, 100, 20);
		
		lblfecha=new JLabel("Fecha: ",SwingConstants.RIGHT);
		lblfecha.setBounds(20, 110, 120, 20);
		
		lblunidad=new JLabel("cantidad de unidades: ",SwingConstants.RIGHT);
		lblunidad.setBounds(20, 140, 120, 20);
		
		lbltipo=new JLabel("Tipó de cobro: ",SwingConstants.RIGHT);
		lbltipo.setBounds(20, 170, 120, 20);
		
		lblTotal=new JLabel("Total ",SwingConstants.RIGHT);
		lblTotal.setBounds(20, 200, 120, 20);
		
		lblResTotal=new JLabel("Total ");
		lblResTotal.setBounds(145, 200, 100, 20);
		
		unidades= new JComboBox<String>();
		unidades.setBounds(145, 140, 150, 20);
		unidades.addItem("Seleccionar unidades");
		for(int i = 1; i <= 10; ++i) {
			unidades.addItem(String.valueOf(i));	
		}
		
		metodos= new JComboBox<String>();
		metodos.setBounds(145, 170, 150, 20);
		metodos.addItem("Seleccionar Opción");
		metodos.addItem("Clase");
		metodos.addItem("Mensual");
		metodos.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent itemEvent) {
				  String s=(String) metodos.getSelectedItem();
				  String a=(String) unidades.getSelectedItem();
				  if(!a.equals("Seleccionar unidades")&&!s.equals("Seleccionar Opción")) {
					  int unidad=0;
						unidad = Integer.parseInt(a.trim());
						if (s.equals("Clase")) {
							lblResTotal.setText(String.valueOf(120*unidad));
						}else {
							lblResTotal.setText(String.valueOf(350*unidad));
							
						}

						
					  
					  
				  }else {
					  lblResTotal.setText("Total");
				  }
				  
			    //tu código
			  }
			});
		unidades.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent itemEvent) {
				  String s=(String) metodos.getSelectedItem();
				  String a=(String) unidades.getSelectedItem();
				  if(!a.equals("Seleccionar unidades")&&!s.equals("Seleccionar Opción")) {
					  int unidad=0;
						unidad = Integer.parseInt(a.trim());
						if (s.equals("Clase")) {
							lblResTotal.setText(String.valueOf(120*unidad));
						}else {
							lblResTotal.setText(String.valueOf(350*unidad));
							
						}

						
					  
					  
				  }else {
					  lblResTotal.setText("Total");
				  }
				  
			    //tu código
			  }
			});
		
		jContentPane.add(metodos);
		jContentPane.add(unidades);
		jContentPane.add(lblResTotal);
		jContentPane.add(txtci);
		jContentPane.add(lblunidad);
		jContentPane.add(lblId);
		jContentPane.add(lblci);
		jContentPane.add(lblNombre);
		jContentPane.add(lblResId);
		jContentPane.add(lblResNombre);
		jContentPane.add(lblfecha);
		jContentPane.add(lbltipo);
		jContentPane.add(lblTotal);
		jContentPane.add(lblId);
		jContentPane.add(Desplegar());
		jContentPane.add(Facturar());
		jContentPane.add(BuscarU());
		return jContentPane;
	}
	
	
	private JButton Facturar() {
		btnFactura= new JButton("Ingresar Cobro");
		btnFactura.setBounds(20, 230, 150, 35);
		btnFactura.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			
		 }  
		 }); 

		return btnFactura;
		
	}
	private JButton BuscarU() {
		btnBuscaruser= new JButton("Buscar Usuario");
		btnBuscaruser.setBounds(180, 230, 150, 35);
		btnBuscaruser.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
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
				lblResNombre.setText(res.getNombre()+" "+res.getApellido());
				txtci.setEditable(false);
				
			}
		 }  
		 }); 

		return btnBuscaruser;
		
	}
	
	private JButton Desplegar() {
		btnDesplegar= new JButton("Desplegar usarios");
		btnDesplegar.setBounds(340, 230, 150, 35);
		btnDesplegar.addActionListener(new ActionListener() {   public void actionPerformed(ActionEvent e) {
			
		 }  
		 }); 

		return btnDesplegar;
		
	}

}
