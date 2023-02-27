package com.ims.rallyModels.repositorio;

import com.ims.rallyModels.modelo.CompeticionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompeticionRepositorio extends JpaRepository<CompeticionEntity, Integer> {
}
