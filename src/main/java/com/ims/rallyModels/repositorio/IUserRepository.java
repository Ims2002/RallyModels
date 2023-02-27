package com.ims.rallyModels.repositorio;

import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.modelo.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface IUserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
}
