package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @Column(name = "ID_CATEGORIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    @Column(name = "NOMBRE_CATEGORIA")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Mueble> listaMuebles;

    /**
     * Método constructor de la clase Categoria
     * @param nombreCategoria
     */
    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {

    }

    //Métodos getter y setter
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<Mueble> getListaMuebles() {
        return listaMuebles;
    }

    public void setListaMuebles(List<Mueble> listaMuebles) {
        this.listaMuebles = listaMuebles;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                '}';
    }
}
