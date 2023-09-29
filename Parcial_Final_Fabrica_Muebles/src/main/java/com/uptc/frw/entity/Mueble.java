package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MUEBLES")
public class Mueble {

    @Id
    @Column(name = "ID_MUEBLE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMueble;
    @Column(name = "NOMBRE_MUEBLE")
    private String nombreMueble;
    @Column(name = "PRECIO_MUEBLE")
    private float precioMueble;
    @ManyToOne
    @JoinColumn(name="ID_CATEGORIA", nullable = false)
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "MUEBLE_PIEZA",
            joinColumns = @JoinColumn(name = "ID_PIEZA"),
            inverseJoinColumns = @JoinColumn(name="ID_MUEBLE"))
    private List<Pieza> listaPiezas;

    public Mueble( String nombreMueble, float precioMueble, Categoria categoria) {

        this.nombreMueble = nombreMueble;
        this.precioMueble = precioMueble;
        this.categoria = categoria;
    }

    public Mueble() {

    }

    //Métodos getter y setter
    public Long getIdMueble() {
        return idMueble;
    }

    public void setIdMueble(Long idMueble) {
        this.idMueble = idMueble;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }

    public float getPrecioMueble() {
        return precioMueble;
    }

    public void setPrecioMueble(float precioMueble) {
        this.precioMueble = precioMueble;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Pieza> getListaPiezas() {
        return listaPiezas;
    }

    public void setListaPiezas(List<Pieza> listaPiezas) {
        this.listaPiezas = listaPiezas;
    }

    @Override
    public String toString() {
        return "Mueble{" +
                "idMueble=" + idMueble +
                ", nombreMueble='" + nombreMueble + '\'' +
                ", precioMueble=" + precioMueble +
                ", categoria=" + categoria +
                '}';
    }
}
