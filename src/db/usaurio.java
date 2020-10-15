package db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import obj.Usuario;
public class usaurio {
	private static PreparedStatement consultaInsertarCliente;
	private static PreparedStatement consultaTodosClientes;
	private static PreparedStatement consultaUsuario;
	private static PreparedStatement UpdateUsuario;
	static {

		try {
			consultaInsertarCliente = bd.getConnection()
					.prepareStatement("INSERT INTO USUARIO(ID_USER,NOMBRE,APELLIDO,CORREO,METODO,TELEFONO,ESTADO) VALUES(?,?,?,?,?,?,?)");
				consultaTodosClientes = bd.getConnection().prepareStatement("SELECT * FROM USUARIO");
				consultaUsuario = bd.getConnection().prepareStatement("SELECT * FROM USUARIO WHERE ID_USER=?");
				UpdateUsuario = bd.getConnection().prepareStatement("UPDATE USUARIO SET NOMBRE = ?, APELLIDO = ?, CORREO = ?, METODO = ?, TELEFONO = ?, ESTADO = ? WHERE ID_USER = ?");
				
		} catch (SQLException e) {
			System.out.println("Error al crear consultas preparadas para Manejador de Clientes");
			e.printStackTrace();
		}
	}
	public static boolean UpdateUsuario(Usuario a) throws SQLException{
		try {
			UpdateUsuario.setInt(7, a.getId());
			UpdateUsuario.setString(1,a.getNombre());
			UpdateUsuario.setString(2,a.getApellido());
			UpdateUsuario.setString(3, a.getCorroe());
			UpdateUsuario.setString(4,a.getMetodop());
			UpdateUsuario.setString(5,a.getTelefono());
			UpdateUsuario.setBoolean(6,a.isEstado());
			UpdateUsuario.executeQuery();
			UpdateUsuario.close();
		}

	 catch (SQLException e) {
		 return false;
	 }
		return true;
	}

	public static void guardarCliente(Usuario u ) throws SQLException {

		consultaInsertarCliente.setInt(1, u.getId());
		consultaInsertarCliente.setString(2, u.getNombre());
		consultaInsertarCliente.setString(3, u.getApellido());
		consultaInsertarCliente.setString(4, u.getCorroe());
		consultaInsertarCliente.setString(5, u.getMetodop());
		consultaInsertarCliente.setString(6, u.getTelefono());
		consultaInsertarCliente.setBoolean(7, u.isEstado());
		try {
		consultaInsertarCliente.executeQuery();
		
		}catch (SQLException e) {
			System.out.println("Error al ingresar");
		}

	}
	public static  ArrayList<Usuario> obtenerTodosClientes() {

		 ArrayList<Usuario> resultado = new ArrayList<>();

		try {
			ResultSet resultadoConsulta = consultaTodosClientes.executeQuery();
			consultaTodosClientes.close();

			while (resultadoConsulta.next()) {

				int id = resultadoConsulta.getInt(1);
				String nombre = resultadoConsulta.getString(2);
				String apellido = resultadoConsulta.getString(3);
				String correo = resultadoConsulta.getString(4);
				String metodo = resultadoConsulta.getString(5);
				String telefono = resultadoConsulta.getString(6);
				boolean estado = true;
				

				Usuario c = new Usuario(id, nombre, apellido,correo,metodo,telefono,estado);
				resultado.add(c);

			}

		} catch (SQLException e) {

		}

		return resultado;
	}
	
	public static Usuario obtenerUsuario(int id) {

		Usuario resultado = null;

		try {
			System.out.println("Realizo consutla");
			System.out.println(id);
			consultaUsuario.setInt(1, id);
			ResultSet resultadoConsulta = consultaUsuario.executeQuery();
			System.out.println("traigo resultado");
			if (resultadoConsulta.next()) {
				System.out.println("traigo resultado2");
				
				String nombre = resultadoConsulta.getString(2);
				System.out.println(nombre);
				String apellido = resultadoConsulta.getString(3);
				String correo = resultadoConsulta.getString(4);
				String metodo = resultadoConsulta.getString(5);
				String telefono = resultadoConsulta.getString(6);
				String Estado = resultadoConsulta.getString(7);
				boolean estado = true;
				if (Estado.equals("0")) {
					estado=false;
				}
				resultado = new Usuario(id, nombre, apellido,correo,metodo,telefono,estado);
				consultaTodosClientes.close();
			}
			
		} catch (SQLException e) {
			System.out.println("No realizo busqueda");

		}
	
		return resultado;

	}
	
	
	
}
