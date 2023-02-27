package com.ims.rallyModels.servicio.competicion;

import com.ims.rallyModels.modelo.CompeticionEntity;
import com.ims.rallyModels.repositorio.ICompeticionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompeticionServicioImpl implements ICompeticionService {

    @Autowired
    private ICompeticionRepositorio repositorio;

    @Override
    public List<CompeticionEntity> listAll() {
        return repositorio.findAll();
    }

    @Override
    public CompeticionEntity guardarCompeticion(CompeticionEntity competicion) {
        return repositorio.save(competicion);
    }

    @Override
    public CompeticionEntity obtenerCompeticionPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public CompeticionEntity actualizarCompeticion(CompeticionEntity competicion) {
        return repositorio.save(competicion);
    }

    @Override
    public void eliminarCompeticion(Integer id) {
        repositorio.deleteById(id);
    }
}
