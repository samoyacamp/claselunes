/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.DAO.UsuarioDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.mycompany.biblio.modelos.Usuario;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sergi
 */
public class LoginController {
    private static Usuario user;
    private static UsuarioDAO udao;
    @FXML
    private TextField nombre;
    @FXML
    private TextField email;
    @FXML
    private TextField pwd;
    @FXML
    private ImageView imagen;

    @FXML
    private void login() throws SQLException, IOException, ClassNotFoundException {
        //String usuario = nombre.getText();
        UsuarioDAO login = new UsuarioDAO();
        //Usuario u = new Usuario(-1, nombre.getText(), email.getText(), pwd.getText());
        //u.checkNombre(usuario);
        //UsuarioDAO x = new UsuarioDAO();
        //System.out.println(u.getNombre());
        //boolean correcto = u.checkBDUsuario();
        //x.checkBDUsuario(u.getNombre());
        //boolean correcto = x.checkBDUsuario(u.toString());
        // DriverManager.println(String.valueOf(correcto));
        String user = nombre.getText();
        String pass = pwd.getText();
        String correo = email.getText();
        boolean ok = true;
        boolean vale =true;
        
        
        try {
            login.conectar();
            
            ok = login.checkBDAdmin(user, correo, pass);
            vale = login.checkBDUsuario(user, correo, pass);
            if (ok) {
                App.loadLibrosWindow();
             
                //AlertsUtil.mostrarConfi("Correcto");
            }
            else if(vale)
            {
                App.loadPrestaWindow();
            }
        } catch (SQLException e) {
            AlertsUtil.mostrarConfi("Algo ha pasado mal");

        }
//        if (ok=login.checkBDUsuario(Usuario, pass, correo)) {
//            AlertsUtil.mostrarInformacion("correcto");
//            App.setUsuario(u);
//            try {
//                App.loadLibrosWindow();
//            } catch (IOException e) {
//                AlertsUtil.mostrarError(e.getMessage());
//            }
//        } else {
//            AlertsUtil.mostrarError("incorrecto");
//        }

        if (nombre.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha pueto ningun nombre");
        }
        if (email.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha puesto ningun email");
        }
        if (pwd.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha puesto ninguna contrase??a");
        }

    }

    @FXML
    private void register() throws IOException {
//        try {
        App.loadRegisterWindow();
//        } catch (IOException e) {
//            AlertsUtil.mostrarError("Algo ha pasao");
//        }
    }
//    public LoginController(Usuario u){
//        user = u;
//        conectarBD();
//    }
//    
// public void loadImage(){
//        Image img = new Image(getClass().getResourceAsStream("/images/foto.jpg"));
//        imagen.setImage(img);
//    }
// private static void conectarBD() {
//        udao = new UsuarioDAO();
//        try {
//            udao.conectar();
//        } catch (SQLException sqle) {
//            AlertsUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
//        } catch (ClassNotFoundException cnfe) {
//            AlertsUtil.mostrarError("Error al iniciar la aplicaci??n");
//        } catch (IOException ioe) {
//            AlertsUtil.mostrarError("Error al cargar la configuraci??n");
//        }
//
//    }
}
