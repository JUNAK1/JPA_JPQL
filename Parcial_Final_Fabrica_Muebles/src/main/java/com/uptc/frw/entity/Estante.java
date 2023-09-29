package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ESTANTE")
public class Estante {
    @Id
    @Column(name = "ID_ESTANTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstante;
    @Column(name = "PASILLO")
    private int pasillo;

    @OneToMany(mappedBy = "estante")
    private List<Pieza> listaPiezas;

    /**
     * Método constructor de la clase Estante
     * @param pasillo
     */

    public Estante( int pasillo) {
        this.pasillo = pasillo;
    }

    public Estante() {

    }

    //Métodos getter y setter
    public Long getIdEstante() {
        return idEstante;
    }

    public void setIdEstante(Long idEstante) {
        this.idEstante = idEstante;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public List<Pieza> getListaPiezas() {
        return listaPiezas;
    }

    public void setListaPiezas(List<Pieza> listaPiezas) {
        this.listaPiezas = listaPiezas;
    }

    @Override
    public String toString() {
        return "Estante{" +
                "idEstante=" + idEstante +
                ", pasillo=" + pasillo +
                '}';
    }
}
