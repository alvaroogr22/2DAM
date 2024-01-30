package modelo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "producto")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "codigo_fabricante", nullable = false)
    private Fabricante fabricante;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Compra> compras = new ArrayList<>();
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    // Constructor sin el parámetro codigo_fabricante
    public Productos() {
    }

    // Constructor con Fabricante como parámetro
    public Productos(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    // Getters y setters

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fabricante=" + fabricante.getNombre() + // Muestra el nombre del fabricante en lugar de código
                '}';
    }
}