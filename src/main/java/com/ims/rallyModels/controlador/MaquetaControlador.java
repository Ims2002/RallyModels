package com.ims.rallyModels.controlador;

import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.servicio.IMaquetasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MaquetaControlador {

    /*
    HTTP GET /users – returns all the users in the system.
    HTTP GET /users/{id} – returns a user by specified id.
    HTTP POST /users – creates a new user in the system.

    @ para path
    $ para objetos

    */
    @Autowired
    private IMaquetasServicio servicio;

    @GetMapping({"/maquetas",""})//url path
    public String listarMaquetas(Model model) {
        model.addAttribute("maquetas",servicio.listAll());
        return "maqueta";//html path
    }

    @GetMapping({"/maquetas/nuevo"})
    public String mostrarFormRegistroMaqueta(Model model) {
        //maqueta que le pasaremos al formulario
        MaquetaEntity maqueta = new MaquetaEntity();
        model.addAttribute("maqueta",maqueta);
        return "crear_maqueta";
    }

    @PostMapping("/maquetas")
    public String guardarMaqueta(@ModelAttribute("maqueta")MaquetaEntity maqueta) {
        //recibimos el objeto que creamos para el formulario
        //agregamos métodos útiles a la Interfaz de servicio
        servicio.guardarMaqueta(maqueta);
        return "redirect:/maquetas";//volvemos a la página inicial
    }

    @GetMapping("/maquetas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("maqueta",servicio.obtenerMaquetaPorId(id));
        return "editar_maqueta";
    }

    @PostMapping("/maquetas/{id}")
    public String actualizarMaqueta(@PathVariable Integer id,
                                    @ModelAttribute("maqueta") MaquetaEntity maqueta,
                                    Model modelo) {
        MaquetaEntity maquetaExistente = servicio.obtenerMaquetaPorId(id);
        maquetaExistente.setIdMaqueta(maqueta.getIdMaqueta());
        maquetaExistente.setDescripcion(maqueta.getDescripcion());
        servicio.actualizarMaqueta(maquetaExistente);

        return "redirect:/maquetas";
    }

    @GetMapping("/maquetas/{id}")
    public String eliminarMaqueta(@PathVariable Integer id) {
        servicio.eliminarMaquetas(id);
        return "redirect:/maquetas";
    }

}
