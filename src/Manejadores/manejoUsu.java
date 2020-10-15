package Manejadores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import obj.Usuario;
import db.usaurio;

public class manejoUsu {
	
	public static boolean AgregarUsuario(Usuario a) throws SQLException {
		
		if(!existeUsuario(a.getId())) {
			usaurio.guardarCliente(a);
			
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	
public static ArrayList<Usuario> obtenerTodosClientesf(){
		
		return usaurio.obtenerTodosClientes();
	}

	
public static boolean existeUsuario(int id){
		
		boolean existe;
		Usuario usu = usaurio.obtenerUsuario(id);
		
		if (usu==null){
			existe = false;
		}
		else{
			existe = true;
		}
		
		return existe;
		
	
}
public static void UpdateUser(Usuario a) throws SQLException {
	System.out.println("Ejecuto");
	usaurio.UpdateUsuario(a);
	System.out.println("termino");
}

	
}
