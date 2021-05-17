/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.modelos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author power
 */
@DisplayName("asdas")
public class UsuarioTest {

    public UsuarioTest() {
    }

    /**
     * Test of checkPassword method, of class Usuario.
     */
//    @DisplayName("Mis test de password")
//    class TestPWD {
    @Test
    @DisplayName("Test que siempre es correcto en password")
    public void testCheckPasswordtrue() {
        String pwd = "Pacojuanito123";
        Usuario instance = new Usuario();
        boolean result = instance.checkPassword(pwd);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test que siempre falla en password")
    public void testCheckPasswordfake() {
        String pwd = "paco";
        Usuario instance = new Usuario();
        boolean result = instance.checkPassword(pwd);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test de email que siempre sale bien")
    public void testEmailCorrecto() {
        String email = "p@gmail.com";
        Usuario instance = new Usuario();
        boolean result = instance.checkEmail(email);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test de email que siempre sale mal")
    public void testEmailFalso() {
        String email = "pacocom";
        Usuario instance = new Usuario();
        boolean result = instance.checkEmail(email);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test de nombre que siempre sale mal")
    public void testNombreCorrecto() {
        String nombre = "Pacopaco";
        
    }

}
