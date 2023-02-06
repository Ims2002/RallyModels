package com.ims.rallyModels.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "producto", schema = "proyecto", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "stock", nullable = true)
    private Integer stock;
    @Basic
    @Column(name = "fk_idCompra", nullable = false)
    private int fkIdCompra;
    @Basic
    @Column(name = "fk_idMaqueta", nullable = false)
    private int fkIdMaqueta;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public int getFkIdCompra() {
        return fkIdCompra;
    }

    public void setFkIdCompra(int fkIdCompra) {
        this.fkIdCompra = fkIdCompra;
    }

    public int getFkIdMaqueta() {
        return fkIdMaqueta;
    }

    public void setFkIdMaqueta(int fkIdMaqueta) {
        this.fkIdMaqueta = fkIdMaqueta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (idProducto != that.idProducto) return false;
        if (fkIdCompra != that.fkIdCompra) return false;
        if (fkIdMaqueta != that.fkIdMaqueta) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProducto;
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + fkIdCompra;
        result = 31 * result + fkIdMaqueta;
        return result;
    }
}
