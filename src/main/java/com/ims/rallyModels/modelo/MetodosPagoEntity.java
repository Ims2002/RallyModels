package com.ims.rallyModels.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "metodos_pago", schema = "proyecto", catalog = "")
public class MetodosPagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMetodos_Pago", nullable = false)
    private int idMetodosPago;
    @Basic
    @Column(name = "metodo_pago", nullable = true, length = 45)
    private String metodoPago;

    public int getIdMetodosPago() {
        return idMetodosPago;
    }

    public void setIdMetodosPago(int idMetodosPago) {
        this.idMetodosPago = idMetodosPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetodosPagoEntity that = (MetodosPagoEntity) o;

        if (idMetodosPago != that.idMetodosPago) return false;
        if (metodoPago != null ? !metodoPago.equals(that.metodoPago) : that.metodoPago != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMetodosPago;
        result = 31 * result + (metodoPago != null ? metodoPago.hashCode() : 0);
        return result;
    }
}
