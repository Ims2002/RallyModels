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
    private String marca;
    private String modelo;
    private String piloto;
    private String image;
    @ManyToOne
    private CompraEntity compra;
    @Basic
    @Column(name = "fk_idCompeticion", nullable = false)
    private int fkIdCompeticion;
    @Basic
    @Column(name = "precio", nullable = true, precision = 0)
    private Double precio;

    @ManyToOne
    private CompeticionEntity competicion;


    public MaquetaEntity() {

    }

    public MaquetaEntity(String descripcion, Double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public MaquetaEntity(String descripcion, CompraEntity compra, Double precio) {
        this.descripcion = descripcion;
        this.compra = compra;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCompeticion(CompeticionEntity competicion) {
        this.competicion = competicion;
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

    public CompeticionEntity getCompeticion() {
        return competicion;
    }

    public CompraEntity getCompra() {
        return compra;
    }

    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "MaquetaEntity{" +
                "idMaqueta=" + idMaqueta +
                ", descripcion='" + descripcion + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", piloto='" + piloto + '\'' +
                ", image='" + image + '\'' +
                ", compra=" + compra +
                ", fkIdCompeticion=" + fkIdCompeticion +
                ", precio=" + precio +
                ", competicion=" + competicion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaquetaEntity that = (MaquetaEntity) o;

        if (idMaqueta != that.idMaqueta) return false;
        if (fkIdCompeticion != that.fkIdCompeticion) return false;
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
        return result;
    }
}
