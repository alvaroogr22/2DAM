package modelo;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras")

public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "unidades")
	private int unidades;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Productos producto;

	public Compra() {
	}

	public Compra(Date fecha, int unidades, Productos producto) {
		this.fecha = fecha;
		this.unidades = unidades;
		this.producto = producto;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Compra: " + "id= " + id + ", fecha= " + fecha + ", unidades= " + unidades + ", producto= " + producto
				+ '\'';
	}
}