package com.ims.rallyModels.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "maqueta", schema = "proyecto", catalog = "")
public class MaquetaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMaqueta", nullable = false)
    private int idMaqueta;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = true, precision = 0)
    private Double precio;
    @Basic
    @Column(name = "fk_idCompeticion", nullable = false)
    private int fkIdCompeticion;
	@Basic
    @Column(name = "fk_idCoche", nullable = false)
    private int fkIdCoche;

    public MaquetaEntity() {

    }

    public int getIdMaqueta() {
        return idMaqueta;
    }

    public void setIdMaqueta(int idMaqueta) {
        this.idMaqueta = idMaqueta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getFkIdCompeticion() {
        return fkIdCompeticion;
    }

    public void setFkIdCompeticion(int fkIdCompeticion) {
        this.fkIdCompeticion = fkIdCompeticion;
    }

    public int getFkIdCoche() {
        return fkIdCoche;
    }

    public void setFkIdCoche(int fkIdCoche) {
        this.fkIdCoche = fkIdCoche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaquetaEntity that = (MaquetaEntity) o;

        if (idMaqueta != that.idMaqueta) return false;
        if (fkIdCompeticion != that.fkIdCompeticion) return false;
        if (fkIdCoche != that.fkIdCoche) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMaqueta;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + fkIdCompeticion;
        result = 31 * result + fkIdCoche;
        return result;
    }
}
