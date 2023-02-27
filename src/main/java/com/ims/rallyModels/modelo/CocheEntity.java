package com.ims.rallyModels.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "coche", schema = "proyecto", catalog = "")
public class CocheEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCoche", nullable = false)
    private int idCoche;
    @Basic
    @Column(name = "marca", nullable = true, length = 45)
    private String marca;
    @Basic
    @Column(name = "modelo", nullable = true, length = 45)
    private String modelo;
    @Basic
    @Column(name = "piloto", nullable = true, length = 45)
    private String piloto;

    private String image;

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CocheEntity that = (CocheEntity) o;

        if (idCoche != that.idCoche) return false;
        if (marca != null ? !marca.equals(that.marca) : that.marca != null) return false;
        if (modelo != null ? !modelo.equals(that.modelo) : that.modelo != null) return false;
        if (piloto != null ? !piloto.equals(that.piloto) : that.piloto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCoche;
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (piloto != null ? piloto.hashCode() : 0);
        return result;
    }
}
