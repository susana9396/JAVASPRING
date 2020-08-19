package cl.inacap.demo.models;

public class Activity {
	
	private String mensaje;
	private String color;
	
	public Activity() {
	}
	public Activity(String m, String c) {
		this.mensaje = m;
		this.color = c;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
