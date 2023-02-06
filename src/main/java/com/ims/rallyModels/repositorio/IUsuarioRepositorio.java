package com.ims.rallyModels.repositorio;

import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<UsuarioEntity, Integer> {
}
