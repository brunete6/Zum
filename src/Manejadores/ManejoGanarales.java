package Manejadores;

import java.sql.SQLException;
import java.util.ArrayList;

import db.Generalidades;


public class ManejoGanarales {
	
	
public static ArrayList<String> obtenerTodosMetodos() throws SQLException{
		
		return Generalidades.Metodos();
	}

}
