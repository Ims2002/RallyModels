package com.ims.rallyModels.servicio.competicion;

import com.ims.rallyModels.modelo.CompeticionEntity;

import java.util.List;

public interface ICompeticionService {

    public List<CompeticionEntity> listAll();

    public CompeticionEntity guardarCompeticion(CompeticionEntity competicion);

    public CompeticionEntity obtenerCompeticionPorId(Integer id);

    public CompeticionEntity actualizarCompeticion(CompeticionEntity competicion);

    public void eliminarCompeticion(Integer id);

}
