package com.ims.rallyModels.repositorio;

import com.ims.rallyModels.modelo.CompraEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICompraRepositorio extends JpaRepository<CompraEntity,Integer> {
}
