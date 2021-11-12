/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;
import logica.Conexion;
import java.io.IOException;

public class Modelo {

    private Conexion miSistema;

    
    public Conexion getMiSistema() {
        if(miSistema == null){
            miSistema = new Conexion();
        }
        return miSistema;
    }
    
    
    public void iniciar() {
            getMiSistema().conectar();
    }
    
}
