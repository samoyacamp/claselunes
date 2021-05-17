/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.modelos.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author sergi
 */
public class PrestamoController {

    private static Usuario user;
    private static LibroDAO ldao;
    private Libros librosSel;
    @FXML
    private ListView listaLibro;
    @FXML
    private TextField id;

    @FXML
    private void back() throws SQLException, IOException {
        librosSel = (Libros) listaLibro.getSelectionModel().getSelectedItem();
    }

    public PrestamoController(Usuario u) {
        user = u;
        conectarBD();

    }

    private static void conectarBD() {
        ldao = new LibroDAO() {};
        try {
            ldao.conectar();
        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            AlertsUtil.mostrarError("Error al iniciar la aplicación");
        } catch (IOException ioe) {
            AlertsUtil.mostrarError("Error al cargar la configuración");
        }

    }

    public void initLists() {

        listaLibro.getItems().clear();
        try {
            conectarBD();
            List<Libros> libro = ldao.listLibros();
            listaLibro.setItems(FXCollections.observableList(libro));

        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("Error cargando los datos de la aplicación");
        }
    }

    @FXML
    private void pedir() throws SQLException, IOException {
//        librosSel = (Libros) listaLibro.getSelectionModel().getSelectedItem();
//        if (librosSel == null) {
//            AlertsUtil.mostrarError("No se ha seleccionado nigun libro");
//            return;
//        }
//        ldao.pedirLibro(new Libros((Integer.parseInt(id.getText()))));
//        initLists();
//    }
    }
}
