package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import GUI.NuevoUsuario;
public class pruebagui extends JFrame {
	
	private final JPanel jContentPane = new JPanel(); 
	private JButton btnNuevoU = null, btnfactura=null;
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			 try{  
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());   new pruebagui();  
			  }catch(Exception e) {  
			  e.printStackTrace();  
			  }  

		}
	public pruebagui() {
		 this.setVisible(true);  
		 this.setTitle("MENÚ");  
		 this.setSize(400, 400);  
		 this.setLocationRelativeTo(null);  
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		 this.setContentPane(getJContentPane());  
		 this.setVisible(true);  
	}
	
	private JPanel getJContentPane() { 
		jContentPane.setLayout(null);
		jContentPane.add(NuevoU(), null);
		jContentPane.add(Factura());
		return jContentPane;
	}
	
	private JButton NuevoU(){
		btnNuevoU = new JButton("Nuevo Usuario");  
		btnNuevoU.setBounds(new Rectangle(30, 30, 130, 20));  
		btnNuevoU.addActionListener(new ActionListener() {  
		 public void actionPerformed(ActionEvent e) {  
			 try{  
				  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());   new NuevoUsuario();  
				  }catch(Exception a) {  
				  a.printStackTrace();  
				  }
		 }  
		 });  
		 return btnNuevoU; 
		
		
	}
	
	private JButton Factura(){
		btnfactura = new JButton("Facturar");  
		btnfactura.setBounds(new Rectangle(30, 60, 130, 20));  
		btnfactura.addActionListener(new ActionListener() {  
		 public void actionPerformed(ActionEvent e) {  
			 try{  
				  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());   new Facturacion();  
				  }catch(Exception a) {  
				  a.printStackTrace();  
				  }
		 }  
		 });  
		 return btnfactura; 
		
		
	}
	
}
