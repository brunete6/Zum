package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import obj.Usuario;

public class Generalidades {

	private static PreparedStatement MetodosPagos;
	static {
		try {
		
			MetodosPagos = bd.getConnection().prepareStatement("SELECT * FROM METODOPAGO");
		} catch (SQLException e) {
			System.out.println("Error al crear consultas preparadas para Manejador de Clientes");
			e.printStackTrace();
		}

	}
	public static ArrayList<String> Metodos() throws SQLException{
		
		ArrayList<String> resultado = new ArrayList<>();
		try {
			ResultSet resultadoConsulta = MetodosPagos.executeQuery();
			System.out.println("Entro");

			while (resultadoConsulta.next()) {
				String ID = resultadoConsulta.getString(1);
				String metodosolo = resultadoConsulta.getString(2);
				System.out.println(metodosolo);
				resultado.add(metodosolo);

			}

		} catch (SQLException e) {
			System.out.println("error en consulta");

		}
		MetodosPagos.close();

		return resultado;
	}
	
	
		
	}
	
	

