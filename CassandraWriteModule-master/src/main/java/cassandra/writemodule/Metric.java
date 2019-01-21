package cassandra.writemodule;

public class Metric {
	
	private long readDate = System.currentTimeMillis();
	//private Date readDate;
	private double latencia;
	private String dispositivo;
	private String dominio;
	
	public Metric(long timeNow, double latencia, String dispositivo, String dominio) {
		super();		
		this.readDate = timeNow;
		this.latencia = latencia;
		this.dispositivo = dispositivo;
		this.dominio = dominio;
	}
		
	public long getReadDate() {		
		return readDate;
	}
	public double getlatencia() {
		return latencia;
	}
	public String getdispositivo() {
		return dispositivo;
	}
	public String getdominio() {
		return dominio;
	}
	@Override
	public String toString() {
		return "INSERT INTO kpscannet.latencia (dispositivo, dominio, fecha, latencia ) values ('" + dispositivo + "','"+ dominio + "'," + readDate + ","+ latencia + ");";
	}
}