package presentacion.modelo;

import logica.Conexion;
import presentacion.vista.Vista;

public class RequestSemaforo {

    private int cantSemaforos, luzRojaFalla, luzAmarillaFalla, luzVerdeFalla, grupoId, clienteId;
    private Vista vistaPrincipal;
    private Conexion conexion;

    public Vista getVentanaPrincipal() {
        if (vistaPrincipal == null) {
            vistaPrincipal = new Vista(this);
        }
        return vistaPrincipal;
    }

    public Conexion getConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public void iniciar() {
        getVentanaPrincipal().setVisible(true);
        getVentanaPrincipal().setLocationRelativeTo(null);
    }

    public RequestSemaforo(int cantSemaforos, int luzRojaFalla, int luzAmarillaFalla, int luzVerdeFalla, int grupoId, int clienteId) {
        this.cantSemaforos = cantSemaforos;
        this.luzRojaFalla = luzRojaFalla;
        this.luzAmarillaFalla = luzAmarillaFalla;
        this.luzVerdeFalla = luzVerdeFalla;
        this.grupoId = grupoId;
        this.clienteId = clienteId;
    }

    public boolean enviar() {
        /*RequestSemaforo semaforo1 = new RequestSemaforo();
        semaforo1.setCantSemaforos(Integer.parseInt(getVentanaPrincipal().getTxtCantSemaforos1().getText()));
        semaforo1.setLuzRojaFalla(Integer.parseInt(getVentanaPrincipal().getTxtLuzRojaMal1().getText()));
        semaforo1.setLuzAmarillaFalla(Integer.parseInt(getVentanaPrincipal().getTxtLuzAmaMal1().getText()));
        semaforo1.setLuzVerdeFalla(Integer.parseInt(getVentanaPrincipal().getTxtLuzVerdeMal1().getText()));
        semaforo1.setGrupoId(1);
        semaforo1.setClienteId(1111);

        RequestSemaforo semaforo2 = new RequestSemaforo();
        semaforo2.setCantSemaforos(Integer.parseInt(getVentanaPrincipal().getTxtCantSemaforos2().getText()));
        semaforo2.setLuzRojaFalla(Integer.parseInt(getVentanaPrincipal().getTxtLuzRojaMal2().getText()));
        semaforo2.setLuzAmarillaFalla(Integer.parseInt(getVentanaPrincipal().getTxtLuzAmaMal2().getText()));
        semaforo2.setLuzVerdeFalla(Integer.parseInt(getVentanaPrincipal().getTxtLuzVerdeMal2().getText()));
        semaforo2.setGrupoId(2);
        semaforo2.setClienteId(1111);
        
        System.out.println("Entre a enviar");

        boolean operacionEnviar = getConexion().enviar(semaforo1, semaforo2);
        
        System.out.println("sali a enviar");
        
        if (operacionEnviar){
            //getConexion().recepcion();
        }*/
        return true;
    }
    
    public void recibir(ResponseDeServidor[] response){
        for (int i=0 ; i<response.length ; i++){
            System.out.println("res" + response);
        }
    }

    public RequestSemaforo() {
    }

    public int getCantSemaforos() {
        return cantSemaforos;
    }

    public void setCantSemaforos(int cantSemaforos) {
        this.cantSemaforos = cantSemaforos;
    }

    public int getLuzRojaFalla() {
        return luzRojaFalla;
    }

    public void setLuzRojaFalla(int luzRojaFalla) {
        this.luzRojaFalla = luzRojaFalla;
    }

    public int getLuzAmarillaFalla() {
        return luzAmarillaFalla;
    }

    public void setLuzAmarillaFalla(int luzAmarillaFalla) {
        this.luzAmarillaFalla = luzAmarillaFalla;
    }

    public int getLuzVerdeFalla() {
        return luzVerdeFalla;
    }

    public void setLuzVerdeFalla(int luzVerdeFalla) {
        this.luzVerdeFalla = luzVerdeFalla;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

}
