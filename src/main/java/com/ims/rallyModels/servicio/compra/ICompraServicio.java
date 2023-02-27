package com.ims.rallyModels.servicio.compra;

import com.ims.rallyModels.modelo.CompraEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.modelo.UsuarioEntity;

import java.util.List;

public interface ICompraServicio {
    public List<CompraEntity> listAll();

    public CompraEntity guardarCompra(CompraEntity compra);

    public CompraEntity insertar(CompraEntity c, UserModel u);

    public CompraEntity obtenerCompraPorId(Integer id);

    public CompraEntity actualizarCompra(CompraEntity compra);

    public void eliminarCompra(Integer id);

    public List<CompraEntity> findByPropietario(UsuarioEntity propietario);

    public MaquetaEntity addMaquetaCompra(MaquetaEntity p, CompraEntity c);

    public void addMaquetaCompraTest(MaquetaEntity p, CompraEntity c);


}
