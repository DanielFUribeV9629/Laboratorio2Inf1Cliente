package presentacion.modelo;

import logica.Conexion;
import presentacion.vista.Vista;

public class ResponseEstadoLuces {
    
    private boolean luz_roja, luz_amarilla, luz_verde;
    private int group_id;

    public ResponseEstadoLuces() {
    }

    public ResponseEstadoLuces(boolean luz_roja, boolean luz_amarilla, boolean luz_verde, int group_id) {
        this.luz_roja = luz_roja;
        this.luz_amarilla = luz_amarilla;
        this.luz_verde = luz_verde;
        this.group_id = group_id;
    }

    public boolean isLuzRoja() {
        return luz_roja;
    }

    public void setLuzRoja(boolean luz_roja) {
        this.luz_roja = luz_roja;
    }

    public boolean isLuzAmarilla() {
        return luz_amarilla;
    }

    public void setLuzAmarilla(boolean luz_amarilla) {
        this.luz_amarilla = luz_amarilla;
    }

    public boolean isLuzVerde() {
        return luz_verde;
    }

    public void setLuzVerde(boolean luz_verde) {
        this.luz_verde = luz_verde;
    }

    public int getGrupoId() {
        return group_id;
    }

    public void setGrupoId(int group_id) {
        this.group_id = group_id;
    }
    
}
