package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PIEZAS")
public class Pieza {

    @Id
    @Column(name = "ID_PIEZA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPieza;
    @Column(name = "NOMBRE_PIEZA")
    private String nombrePieza;
    @ManyToMany(mappedBy = "listaPiezas")
    private List<Mueble> listaMuebles;


    @ManyToOne
    @JoinColumn(name="ID_ESTANTE", nullable = false)
    private Estante estante;

    public Pieza(String nombrePieza, Estante estante) {
        this.estante=estante;
        this.nombrePieza = nombrePieza;
    }

    public Pieza() {

    }

    public Long getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Long idPieza) {
        this.idPieza = idPieza;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public List<Mueble> getListaMuebles() {
        return listaMuebles;
    }

    public void setListaMuebles(List<Mueble> listaMuebles) {
        this.listaMuebles = listaMuebles;
    }

    public Estante getEstante() {
        return estante;
    }


    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "idPieza=" + idPieza +
                ", nombrePieza='" + nombrePieza + '\'' +
                '}';
    }
}
