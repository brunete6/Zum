package z;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import Manejadores.manejoUsu;
import db.usaurio;
import obj.Usuario;
public class PREUBA {

	public static void main(String[] args) throws SQLException {
		System.out.println("HOLA MUNDO");
		Scanner ns = new Scanner(System.in);
		/*Usuario u = new Usuario();
		System.out.println("ingrese nombre");
		u.setNombre(ns.next());
		System.out.println("ingrese apellido");
		u.setApellido(ns.next());
		System.out.println("ingrese correo");
		u.setCorroe(ns.next());
		System.out.println("ingrese metodo");
		u.setMetodop(ns.next());
		System.out.println("ingrese telefono");
		u.setTelefono(ns.next());
		u.setEstado(true);
		u.setId(3);
		usaurio.guardarCliente(u);
		System.out.println("Se guardo ");*/
	/*	usaurio usuario;
		 List<Usuario> resultado = new ArrayList<>();
		 resultado=usaurio.obtenerTodosClientes();
		 ListIterator it = resultado.listIterator();
		System.out.println("Listar");
		
		while(it.hasNext()) {
			  System.out.println(it.next());
		
		
		}
		
		
		/*for (Usuario nombre :  resultado) {
			 
			 System.out.println(nombre.getNombre());
			 System.out.println("/n");
			}*/
		/*usaurio.obtenerTodosClientes().forEach(System.out::println);*/
		
		ArrayList<Usuario> u = manejoUsu.obtenerTodosClientesf();
		System.out.println(u.size());
		for (Usuario m : u) {
			System.out.println(" ");
			System.out.print(" "+ m.getApellido()+" ");
			System.out.print(m.getNombre());
			System.out.println(" ");
		}
		
		System.out.println("ingrese id a buscar");
		if (manejoUsu.existeUsuario(ns.nextInt())) {
			System.out.println("existe");
		}else {
			System.out.println("NO");
		}
		Usuario a = new Usuario(1,"hola","hola","hola","hola","hola",true);
		manejoUsu.UpdateUser(a);
		
	}

}
