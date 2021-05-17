/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.DAO;

import com.mycompany.biblio.App;
import com.mycompany.biblio.modelos.Usuario;
// import com.mycompany.biblio.modelos.Libros;
// import com.mycompany.biblio.modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author sergi
 */
public class UsuarioDAO {
    
    private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {

        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }

    public void desconectar() throws SQLException {
        conexion.close();
    }

    public boolean checkBDAdmin(String nombre, String email, String pwd) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE Nombre=? AND Pwd=? AND email=? AND PUESTO='admin' LIMIT 1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, pwd);
        sentencia.setString(3, email);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();

    }
    
    public boolean checkBDUsuario(String nombre, String email, String pwd) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE Nombre=? AND Pwd=? AND email=? LIMIT 1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, pwd);
        sentencia.setString(3, email);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();
    }
//        private String nombre;
//    private String email;
//    private String password;
//    private String apellido;
//    private String DNI;
//    private String domicilio;
//    private String ciudad;
//    private String provincia;
//    private String puesto;
    public void addUsuario(Usuario user) throws SQLException {
        String sql = "{call spNewUser (?,?,?,?,?,?,?,?,?)}";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, user.getCodigo_usuarios());
        sentencia.setString(2, user.getNombre());
        sentencia.setString(3, user.getEmail());
        sentencia.setString(4, user.getApellido());
        sentencia.setString(5, user.getPassword());
        sentencia.setString(6, user.getDNI());
        sentencia.setString(7, user.getDomicilio());
        sentencia.setString(8, user.getCiudad());
        sentencia.setString(9, user.getProvincia());
        sentencia.executeUpdate();

    }

}
