
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.modelos;

/**
 *
 * @author sergi
 */
//Codigo_Usuarios INT NOT NULL UNIQUE auto_increment,
//Nombre  VARCHAR(45) NOT NULL,
//Email VARCHAR(45)NOT NULL,
//Pwd VARCHAR(45) NOT NULL,
//Apellido VARCHAR(45),
//DNI  VARCHAR(45) NOT NULL,
//Domicilio VARCHAR(45),
//Ciudad VARCHAR(45),
//Provincia VARCHAR(45),
//Puesto VARCHAR(45),
public class Usuario {
    private int codigo_usuarios;
    private String nombre;
    private String email;
    private String password;
    private String apellido;
    private String DNI;
    private String domicilio;
    private String ciudad;
    private String provincia;

    public Usuario(int codigo_usuarios, String nombre, String email, String password, String apellido, String DNI, String domicilio, String ciudad, String provincia) {
        this.codigo_usuarios = codigo_usuarios;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.apellido = apellido;
        this.DNI = DNI;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{nombre=").append(nombre);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

//    public Usuario(int id, String nombre, String email, String password) {
//        this.nombre = nombre;
//        this.email = email;
//        this.password = password;
//        this.codigo_usuarios = id;
//    }

    public Usuario() {
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
        public boolean checkNombre(String nombre){
        return nombre.length() >= 6;
    }
    
    public  boolean checkEmail(String email){
        //return email.matches("@+");
        boolean ok = false;
        if (email.matches("[-\\w\\.]+@\\w+\\.\\w+")) 
            ok = true;
        return ok;
    }
    
    
    public boolean checkPassword(String pwd){
     boolean ok = false;
        if (pwd.matches(".*[A-Z].*") && pwd.length() >=8) 
            ok = true;
        return ok;
    }

   
    /**
     * @return the codigo_usuarios
     */
    public int getCodigo_usuarios() {
        return codigo_usuarios;
    }

    /**
     * @param codigo_usuarios the codigo_usuarios to set
     */
    public void setCodigo_usuarios(int codigo_usuarios) {
        this.codigo_usuarios = codigo_usuarios;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


}