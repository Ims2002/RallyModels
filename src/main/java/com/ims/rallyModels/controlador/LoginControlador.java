package com.ims.rallyModels.controlador;

import com.ims.rallyModels.modelo.UsuarioEntity;
import com.ims.rallyModels.repositorio.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping({"/login"})
    public String goToLogin(Model model){
        return "login";
    }


/*
    @Autowired
    private IUsuarioRepositorio iUserRepository;

    @GetMapping({"/login"})
    public String goToLogin(Model model){
        return "login";
    }

*/
/*
    @Autowired
    private IUsuarioRepositorio iUsuarioRepositorio;

    @GetMapping({"/login"})
    public String goToLogin(Model model) {
        return "login";
    }

    @GetMapping({"/"})
    public String verPaginaInicio(Model model) {
        return "index";
    }

    @GetMapping("/login/valid")
    public String loginValidation(String username) {
        UsuarioEntity user = iUsuarioRepositorio.findByName(username);
        return "login";
    }
*/
}
