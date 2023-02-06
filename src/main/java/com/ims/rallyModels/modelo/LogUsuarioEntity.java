package com.ims.rallyModels.modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "log_usuario", schema = "proyecto", catalog = "")
public class LogUsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idLog_Usuario", nullable = false)
    private int idLogUsuario;
    @Basic
    @Column(name = "Log_Usuariocol", nullable = true)
    private Date logUsuariocol;
    @Basic
    @Column(name = "fk_idUsuario", nullable = false)
    private int fkIdUsuario;

    public int getIdLogUsuario() {
        return idLogUsuario;
    }

    public void setIdLogUsuario(int idLogUsuario) {
        this.idLogUsuario = idLogUsuario;
    }

    public Date getLogUsuariocol() {
        return logUsuariocol;
    }

    public void setLogUsuariocol(Date logUsuariocol) {
        this.logUsuariocol = logUsuariocol;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogUsuarioEntity that = (LogUsuarioEntity) o;

        if (idLogUsuario != that.idLogUsuario) return false;
        if (fkIdUsuario != that.fkIdUsuario) return false;
        if (logUsuariocol != null ? !logUsuariocol.equals(that.logUsuariocol) : that.logUsuariocol != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLogUsuario;
        result = 31 * result + (logUsuariocol != null ? logUsuariocol.hashCode() : 0);
        result = 31 * result + fkIdUsuario;
        return result;
    }
}
