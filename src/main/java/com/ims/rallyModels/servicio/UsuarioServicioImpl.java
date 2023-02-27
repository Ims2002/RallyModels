package com.ims.rallyModels.servicio;

import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.repositorio.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UserDetailsService {
//may cons
    @Autowired
    private IUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(user);
    }

    /*@Override
    public UsuarioEntity buscarPorNombre(String nombre) {
        return repositorio.findByName(nombre);
    }*/
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = repositorio.findByNombre(username);
        if (usuario == null) {
            throw  new UsernameNotFoundException("Usuario o password inválidos");;
        }
        return new UsuarioEntity(usuario.getNombre(), usuario.getContrasena(), mapearAutoridadesRoles(usuario.getSudo()));
    }*/

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity user = repositorio.findByNombre(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(user);
    }*/
}
