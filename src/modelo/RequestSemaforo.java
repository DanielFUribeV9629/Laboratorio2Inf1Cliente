package modelo;

public class RequestSemaforo {
    
    private int cantSemaforos, luzRojaFalla, luzAmarillaFalla, luzVerdeFalla, grupoId, clienteId;

    public RequestSemaforo(int cantSemaforos, int luzRojaFalla, int luzAmarillaFalla, int luzVerdeFalla, int grupoId, int clienteId) {
        this.cantSemaforos = cantSemaforos;
        this.luzRojaFalla = luzRojaFalla;
        this.luzAmarillaFalla = luzAmarillaFalla;
        this.luzVerdeFalla = luzVerdeFalla;
        this.grupoId = grupoId;
        this.clienteId = clienteId;
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
