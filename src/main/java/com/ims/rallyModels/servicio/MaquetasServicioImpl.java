package com.ims.rallyModels.servicio;

import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.repositorio.IMaquetasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquetasServicioImpl implements IMaquetasServicio {

    @Autowired
    private IMaquetasRepositorio repositorio;

    @Override
    public List<MaquetaEntity> listAll() {
        return repositorio.findAll();
    }

    @Override
    public MaquetaEntity guardarMaqueta(MaquetaEntity maqueta) {
        return repositorio.save(maqueta);
    }

    @Override
    public MaquetaEntity obtenerMaquetaPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public MaquetaEntity actualizarMaqueta(MaquetaEntity maqueta) {
        //primero se busca y luego se edita y guarda
        return repositorio.save(maqueta);
    }

    @Override
    public void eliminarMaquetas(Integer id) {
        repositorio.deleteById(id);
    }

}
