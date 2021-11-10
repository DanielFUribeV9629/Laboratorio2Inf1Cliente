package presentacion.modelo;

import logica.Conexion;
import presentacion.vista.Vista;

public class ResponseEstadoLuces {
    
    private boolean luzRoja, luzAmarilla, luzVerde;
    private int grupoId;

    public ResponseEstadoLuces() {
    }

    public ResponseEstadoLuces(boolean luzRoja, boolean luzAmarilla, boolean luzVerde, int grupoId) {
        this.luzRoja = luzRoja;
        this.luzAmarilla = luzAmarilla;
        this.luzVerde = luzVerde;
        this.grupoId = grupoId;
    }

    public boolean isLuzRoja() {
        return luzRoja;
    }

    public void setLuzRoja(boolean luzRoja) {
        this.luzRoja = luzRoja;
    }

    public boolean isLuzAmarilla() {
        return luzAmarilla;
    }

    public void setLuzAmarilla(boolean luzAmarilla) {
        this.luzAmarilla = luzAmarilla;
    }

    public boolean isLuzVerde() {
        return luzVerde;
    }

    public void setLuzVerde(boolean luzVerde) {
        this.luzVerde = luzVerde;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }
    
}
