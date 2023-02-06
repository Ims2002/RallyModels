package com.ims.rallyModels.servicio;

import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMaquetasServicio {

    public List<MaquetaEntity> listAll();

    public MaquetaEntity guardarMaqueta(MaquetaEntity maqueta);

    public MaquetaEntity obtenerMaquetaPorId(Integer id);

    public MaquetaEntity actualizarMaqueta(MaquetaEntity maqueta);

    public void eliminarMaquetas(Integer id);

}
