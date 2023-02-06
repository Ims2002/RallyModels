package com.ims.rallyModels.repositorio;

import com.ims.rallyModels.modelo.MaquetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaquetasRepositorio extends JpaRepository<MaquetaEntity, Integer> { }
