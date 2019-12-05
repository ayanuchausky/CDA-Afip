package examen.Afip.dominio;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class impuesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idimpuesto;
	
	@Column(name ="descripcion")
	private String descripcion;
	
	@Column(name ="fecha")
	private Date fecha;

	public int getId_impuesto() {
		return idimpuesto;
	}

	public void setId_impuesto(int id_impuesto) {
		this.idimpuesto = id_impuesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getDate() {
		return fecha;
	}

	public void setDate(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
