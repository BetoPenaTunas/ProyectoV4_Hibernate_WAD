package hibernate;

import java.io.Serializable;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable{
    @Id
    @GenericGenerator(name="idArticulo", strategy="increment")
    private int idArticulo;
    
    @Column(name = "nombreArticulo", length = 100, nullable = false)
    private String nombreArticulo;
    
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcionArticulo;
    
    @Column(name = "existencias", length = 11, nullable = false)
    private int existencias;
    
    @Column(name = "stockMinimo", length = 11, nullable = false)
    private int stockMinimo;
    
    @Column(name = "stockMaximo", length = 11, nullable = false)
    private int stockMaximo;
    
    @Column(name = "precio", nullable = false)
    private double precio;
    
    @Column(name = "idCategoria", nullable = false)
    private int idCategoria;

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }



    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    @Override
    public String toString() {
        return "\n\nArticulo{" + "idArticulo=" + idArticulo + ", nombreArticulo=" + nombreArticulo + ", descripcionArticulo=" + descripcionArticulo + ", existencias=" + existencias + ", stockMinimo=" + stockMinimo + ", stockMaximo=" + stockMaximo + ", precio=" + precio + ", idCategoria=" + idCategoria + '}';
    }

    
    
    
}
