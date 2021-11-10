package logica.labinforma2cliente;

import presentacion.modelo.RequestSemaforo;
import presentacion.vista.Vista;

public class LabInforma2Cliente {
    
    private RequestSemaforo miApp;
    
    public LabInforma2Cliente() {
        miApp = new RequestSemaforo();
        miApp.iniciar();        
    }

    public static void main(String[] args) {
        new LabInforma2Cliente();
        //Vista view = new Vista();       
        //ControladorParticion control= new ControladorParticion(view, mod);
        //control.iniciar();
        //view.setVisible(true);   
    }    
}

