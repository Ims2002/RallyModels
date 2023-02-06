package com.ims.rallyModels.controlador;

import com.ims.rallyModels.servicio.IMaquetasServicio;
import com.ims.rallyModels.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio servicio;

    @GetMapping({"/usuarios",""})
    public String listarMaquetas(Model model) {
        model.addAttribute("usuarios",servicio.listAll());
        return "usuarios";
    }

}
