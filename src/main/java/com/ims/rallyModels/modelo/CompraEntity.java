package com.ims.rallyModels.modelo;

import com.ims.rallyModels.servicio.UserDetailsImpl;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)//para la auto fecha
@Table(name = "compra", schema = "proyecto", catalog = "")
public class CompraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCompra", nullable = false)
    private int idCompra;
    @Basic
    @Column(name = "precio_total", nullable = true, length = 45)
    private String precioTotal;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Date fecha;
    @Basic
    @Column(name = "fk_idUsuario", nullable = false)
    private int fkIdUsuario;
    @Basic
    @Column(name = "fk_idMetodos_Pago", nullable = false)
    private int fkIdMetodosPago;

    @OneToMany
    private List<MaquetaEntity> productos;
    @ManyToOne
    private UserModel usuario;

    @ManyToOne
    private MetodosPagoEntity metodoPago;

    public List<MaquetaEntity> getProductos() {
        return productos;
    }

    public MetodosPagoEntity getMetodoPago() {
        return metodoPago;
    }

    public CompraEntity() {
        productos = new ArrayList<>();
        usuario = new UserDetailsImpl(usuario).getUser();
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public int getFkIdMetodosPago() {
        return fkIdMetodosPago;
    }

    public void setFkIdMetodosPago(int fkIdMetodosPago) {
        this.fkIdMetodosPago = fkIdMetodosPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompraEntity that = (CompraEntity) o;

        if (idCompra != that.idCompra) return false;
        if (fkIdUsuario != that.fkIdUsuario) return false;
        if (fkIdMetodosPago != that.fkIdMetodosPago) return false;
        if (precioTotal != null ? !precioTotal.equals(that.precioTotal) : that.precioTotal != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompra;
        result = 31 * result + (precioTotal != null ? precioTotal.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + fkIdUsuario;
        result = 31 * result + fkIdMetodosPago;
        return result;
    }
}
