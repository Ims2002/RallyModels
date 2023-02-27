package com.ims.rallyModels.dtu;

public class UsuarioRegistroDTU {

    private int idUsuario;
    private String nombre;
    private String password;
    private String sudo;

    public UsuarioRegistroDTU(int idUsuario, String nombre, String password, String sudo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
        this.sudo = sudo;
    }

    public UsuarioRegistroDTU(String nombre, String password, String sudo) {
        this.nombre = nombre;
        this.password = password;
        this.sudo = sudo;
    }

    public UsuarioRegistroDTU(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioRegistroDTU() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return password;
    }

    public void setContrasena(String contrasena) {
        this.password = contrasena;
    }

    public String getSudo() {
        return sudo;
    }

    public void setSudo(String sudo) {
        this.sudo = sudo;
    }
}
