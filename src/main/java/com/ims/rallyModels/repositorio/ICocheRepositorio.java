package com.ims.rallyModels.repositorio;

import com.ims.rallyModels.modelo.CocheEntity;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICocheRepositorio extends JpaRepository<CocheEntity,Integer> {}
