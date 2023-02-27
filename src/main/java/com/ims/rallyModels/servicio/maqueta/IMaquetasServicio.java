package com.ims.rallyModels.servicio.maqueta;

import com.ims.rallyModels.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMaquetasServicio {

    public List<MaquetaEntity> listAll();

    public MaquetaEntity guardarMaqueta(MaquetaEntity maqueta);

    public MaquetaEntity obtenerMaquetaPorId(Integer id);

    public MaquetaEntity actualizarMaqueta(MaquetaEntity maqueta);

    public void eliminarMaquetas(Integer id);

    public List<MaquetaEntity> variosPorId(List<Integer>  ids);

    public List<MaquetaEntity> productosDeUnaCompra(CompraEntity c);

}
