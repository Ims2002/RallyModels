package com.ims.rallyModels.repositorio;

import com.ims.rallyModels.modelo.CompraEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMaquetasRepositorio extends JpaRepository<MaquetaEntity, Integer> {

    List<MaquetaEntity> findByCompra(CompraEntity c);

}
