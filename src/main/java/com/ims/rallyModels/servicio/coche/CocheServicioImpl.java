package com.ims.rallyModels.servicio.coche;

import com.ims.rallyModels.modelo.CocheEntity;
import com.ims.rallyModels.repositorio.ICocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheServicioImpl implements ICocheServicio {

    @Autowired
    private ICocheRepositorio repositorio;

    @Override
    public List<CocheEntity> listAll() {
        return repositorio.findAll();
    }

    @Override
    public CocheEntity guardarCoche(CocheEntity maqueta) {
        return repositorio.save(maqueta);
    }

    @Override
    public CocheEntity obtenerCochePorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public CocheEntity actualizarCoche(CocheEntity maqueta) {
        //primero se busca y luego se edita y guarda
        return repositorio.save(maqueta);
    }

    @Override
    public void eliminarCoches(Integer id) {
        repositorio.deleteById(id);
    }

}
