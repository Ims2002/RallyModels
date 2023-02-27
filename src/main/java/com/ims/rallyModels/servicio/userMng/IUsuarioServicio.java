package com.ims.rallyModels.servicio.userMng;

import com.ims.rallyModels.modelo.CompraEntity;
import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.modelo.UsuarioEntity;

import java.util.List;

public interface IUsuarioServicio {
    public UserModel findByNombre(String nombre);
}
