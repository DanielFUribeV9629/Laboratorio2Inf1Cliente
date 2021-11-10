package presentacion.modelo;

public class ResponseDeServidor {
    
    private ResponseEstadoLuces semaforo1;
    private ResponseEstadoLuces semaforo2;

    public ResponseDeServidor() {
    }

    public ResponseDeServidor(ResponseEstadoLuces semaforo1, ResponseEstadoLuces semaforo2) {
        this.semaforo1 = semaforo1;
        this.semaforo2 = semaforo2;
    }    

    public ResponseEstadoLuces getSemaforo1() {
        return semaforo1;
    }

    public void setSemaforo1(ResponseEstadoLuces semaforo1) {
        this.semaforo1 = semaforo1;
    }

    public ResponseEstadoLuces getSemaforo2() {
        return semaforo2;
    }

    public void setSemaforo2(ResponseEstadoLuces semaforo2) {
        this.semaforo2 = semaforo2;
    }
    
}