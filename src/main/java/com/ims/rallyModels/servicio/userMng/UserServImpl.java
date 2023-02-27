package com.ims.rallyModels.servicio.userMng;

import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.repositorio.IUserRepository;
import com.ims.rallyModels.servicio.userMng.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServImpl implements IUsuarioServicio {

    @Autowired
    IUserRepository repositorio;

    @Override
    public UserModel findByNombre(String nombre) {
        return null;
    }

    public UserModel findById(int id) {
        return repositorio.findById(id).get();
    }

}
