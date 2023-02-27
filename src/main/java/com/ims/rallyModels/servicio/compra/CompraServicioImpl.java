package com.ims.rallyModels.servicio.compra;

import com.ims.rallyModels.modelo.CompraEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.modelo.UsuarioEntity;
import com.ims.rallyModels.repositorio.ICompraRepositorio;
import com.ims.rallyModels.servicio.maqueta.IMaquetasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServicioImpl implements ICompraServicio {

    @Autowired
    private ICompraRepositorio repositorio;

    @Autowired
    IMaquetasServicio maquetasServicio;

    @Override
    public List<CompraEntity> listAll() {
        return repositorio.findAll();
    }

    @Override
    public CompraEntity guardarCompra(CompraEntity compra) {
        return repositorio.save(compra);
    }

    @Override
    public CompraEntity insertar(CompraEntity c, UserModel u) {
        c.setUsuario(u);
        return repositorio.save(c);
    }

    @Override
    public CompraEntity obtenerCompraPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public CompraEntity actualizarCompra(CompraEntity compra) {
        return repositorio.save(compra);
    }

    @Override
    public void eliminarCompra(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<CompraEntity> findByPropietario(UsuarioEntity propietario) {
        return null;
    }

    @Override
    public MaquetaEntity addMaquetaCompra(MaquetaEntity p, CompraEntity c) {
        p.setCompra(c);
        return maquetasServicio.actualizarMaqueta(p);
    }

    @Override
    public void addMaquetaCompraTest(MaquetaEntity p, CompraEntity c) {
        c.getProductos().add(p);
    }


}
