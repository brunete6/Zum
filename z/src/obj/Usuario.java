package obj;

public class Usuario {
	private int id;
	private String nombre, apellido, corroe, telefono, metodop;
	private boolean estado;
	public Usuario(int id, String nombre, String apellido, String corroe, String telefono, String metodop, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.corroe = corroe;
		this.telefono = telefono;
		this.metodop = metodop;
		this.estado = estado;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub1
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorroe() {
		return corroe;
	}
	public void setCorroe(String corroe) {
		this.corroe = corroe;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMetodop() {
		return metodop;
	}
	public void setMetodop(String metodop) {
		this.metodop = metodop;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
