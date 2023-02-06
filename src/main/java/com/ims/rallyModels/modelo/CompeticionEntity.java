package com.ims.rallyModels.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "competicion", schema = "proyecto", catalog = "")
public class CompeticionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCompeticion", nullable = false)
    private int idCompeticion;
    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "lugar", nullable = true, length = 45)
    private String lugar;
    @Basic
    @Column(name = "mejor_resultado", nullable = true, length = 45)
    private String mejorResultado;
    @Basic
    @Column(name = "anio", nullable = true, length = 50)
    private String anio;

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getMejorResultado() {
        return mejorResultado;
    }

    public void setMejorResultado(String mejorResultado) {
        this.mejorResultado = mejorResultado;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompeticionEntity that = (CompeticionEntity) o;

        if (idCompeticion != that.idCompeticion) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (lugar != null ? !lugar.equals(that.lugar) : that.lugar != null) return false;
        if (mejorResultado != null ? !mejorResultado.equals(that.mejorResultado) : that.mejorResultado != null)
            return false;
        if (anio != null ? !anio.equals(that.anio) : that.anio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompeticion;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (lugar != null ? lugar.hashCode() : 0);
        result = 31 * result + (mejorResultado != null ? mejorResultado.hashCode() : 0);
        result = 31 * result + (anio != null ? anio.hashCode() : 0);
        return result;
    }
}
