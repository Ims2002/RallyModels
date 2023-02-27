package com.ims.rallyModels.controlador;

import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.repositorio.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroControlador {

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping({"/register"})
    public String goToregister(Model model){
        model.addAttribute("user", new UserModel());
        return "register";
    }
    @PostMapping("/process_register")
    public String processRegister(UserModel user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        iUserRepository.save(user);
        return "login";
    }

    /*@Autowired
    private IUsuarioRepositorio iUsuarioRepositorio;

    //@GetMapping
    //public String mostrarFormularioRegistro() {
        //return "login";
    //}
/*
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTU usuario) {
        usuarioServicio.guardar(usuario);
        //si logramos registrar correctamente se mandará el
        //mensaje de éxito al html del registro (l.35)
        return "redirect:/register?exito";
    }

    @GetMapping("security/user")
    public String getUser( Model model) {
        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UsuarioEntity user = iUsuarioRepositorio.findByNombre(currentUser.getUsername());
        model.addAttribute("user", user);
        return "security/user";
    }

    @GetMapping({"/register"})
    public String goToregister(Model model){
        model.addAttribute("user", new UsuarioEntity());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(UsuarioEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getContrasena());
        user.setContrasena(encodedPassword);
        iUsuarioRepositorio.save(user);
        return "index";
    }*/


}
