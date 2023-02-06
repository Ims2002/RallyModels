package com.ims.rallyModels.servicio;

import com.ims.rallyModels.modelo.UsuarioEntity;
import com.ims.rallyModels.repositorio.IMaquetasRepositorio;
import com.ims.rallyModels.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioServicioImpl implements IUsuarioServicio{

    @Autowired
    private IUsuarioRepositorio repositorio;


    @Override
    public List<UsuarioEntity> listAll() {
        return repositorio.findAll();
    }
}
