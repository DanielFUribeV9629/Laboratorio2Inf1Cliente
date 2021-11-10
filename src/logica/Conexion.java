package logica;

import presentacion.modelo.RequestSemaforo;
import presentacion.modelo.ResponseDeServidor;
import presentacion.modelo.ResponseEstadoLuces;

public class Conexion {

    public boolean conectar() {
        return true;
    }

    public boolean desconectar() {
        return true;
    }

    public ResponseDeServidor enviar(RequestSemaforo semaforo1, RequestSemaforo semaforo2) {
        String f = "Enviando";
        ResponseDeServidor estadoLuz = new ResponseDeServidor();
        System.out.println(f);
        return estadoLuz;
    }
    
}
