package com.ims.rallyModels.servicio.coche;

import com.ims.rallyModels.modelo.CocheEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;

import java.util.List;

public interface ICocheServicio {

    public List<CocheEntity> listAll();

    public CocheEntity guardarCoche(CocheEntity maqueta);

    public CocheEntity obtenerCochePorId(Integer id);

    public CocheEntity actualizarCoche(CocheEntity maqueta);

    public void eliminarCoches(Integer id);

}
