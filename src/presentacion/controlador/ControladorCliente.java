package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import logica.Conexion;
import presentacion.modelo.RequestSemaforo;
import presentacion.vista.Vista;

public final class ControladorCliente implements ActionListener, ComponentListener {

    private final Vista vista;
    private final RequestSemaforo modelo;
    private Conexion conexion;

    public ControladorCliente(Vista vista) {
        this.vista = vista;
        modelo = vista.getModelo();
        conexion = getConexion();
    }   

    public Conexion getConexion() {
        if (conexion == null) {
            conexion = new Conexion(this.vista);
        }
        return conexion;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();

            if (boton == vista.getBtnConectar()) {
                vista.getTxtBienvenida().setVisible(true);
                vista.getBtnConectar().setEnabled(false);
                vista.getBtnDesconectar().setEnabled(true);
                vista.getTxtIngresaYa().setVisible(false);
                vista.getTxtCantSemaforos1().setEnabled(true);
                vista.getTxtCantSemaforos2().setEnabled(true);
                vista.getTxtLuzRojaMal1().setEnabled(true);
                vista.getTxtLuzRojaMal2().setEnabled(true);
                vista.getTxtLuzAmaMal1().setEnabled(true);
                vista.getTxtLuzAmaMal2().setEnabled(true);
                vista.getTxtLuzVerdeMal1().setEnabled(true);
                vista.getTxtLuzVerdeMal2().setEnabled(true);
                vista.getBtnEnviar().setEnabled(true);
                boolean conectado = getConexion().conectar();
                if (conectado) {
                    JOptionPane.showMessageDialog(null, "Se ha conectado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No fue posible realizar la conexión");
                }
            } else if (boton == vista.getBtnDesconectar()) {
                vista.getTxtBienvenida().setVisible(false);
                vista.getBtnConectar().setEnabled(true);
                vista.getBtnDesconectar().setEnabled(false);
                vista.getTxtIngresaYa().setVisible(true);
                vista.getTxtCantSemaforos1().setEnabled(false);
                vista.getTxtCantSemaforos2().setEnabled(false);
                vista.getTxtLuzRojaMal1().setEnabled(false);
                vista.getTxtLuzRojaMal2().setEnabled(false);
                vista.getTxtLuzAmaMal1().setEnabled(false);
                vista.getTxtLuzAmaMal2().setEnabled(false);
                vista.getTxtLuzVerdeMal1().setEnabled(false);
                vista.getTxtLuzVerdeMal2().setEnabled(false);
                vista.getBtnEnviar().setEnabled(false);
                boolean conectado = getConexion().desconectar();
                if (conectado) {
                    JOptionPane.showMessageDialog(null, "Se ha desconectado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No fue posible desconectarse");
                }
            } else if (boton == vista.getBtnEnviar()) {
                //getConexion().enviar(modelo, modelo);
                enviar();
            }
        }
    }

    public void enviar() {
        if (vista.getTxtCantSemaforos1().getText().equals("") || vista.getTxtCantSemaforos2().getText().equals("") || vista.getTxtLuzRojaMal1().getText().equals("")
                || vista.getTxtLuzRojaMal2().getText().equals("") || vista.getTxtLuzAmaMal1().getText().equals("") || vista.getTxtLuzAmaMal2().getText().equals("")
                || vista.getTxtLuzVerdeMal1().getText().equals("") || vista.getTxtLuzVerdeMal2().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor en todos los campos.");
        } else {
            /*
            vista.getTxtCantSemaforos1().setEnabled(false);
            vista.getTxtCantSemaforos2().setEnabled(false);
            vista.getTxtLuzRojaMal1().setEnabled(false);
            vista.getTxtLuzRojaMal2().setEnabled(false);
            vista.getTxtLuzAmaMal1().setEnabled(false);
            vista.getTxtLuzAmaMal2().setEnabled(false);
            vista.getTxtLuzVerdeMal1().setEnabled(false);
            vista.getTxtLuzVerdeMal2().setEnabled(false);            
             */
            //ResponseDeServidor response = getModelo().enviar();

            RequestSemaforo semaforo1 = new RequestSemaforo();
            semaforo1.setCantSemaforos(Integer.parseInt(vista.getTxtCantSemaforos1().getText()));
            semaforo1.setLuzRojaFalla(Integer.parseInt(vista.getTxtLuzRojaMal1().getText()));
            semaforo1.setLuzAmarillaFalla(Integer.parseInt(vista.getTxtLuzAmaMal1().getText()));
            semaforo1.setLuzVerdeFalla(Integer.parseInt(vista.getTxtLuzVerdeMal1().getText()));
            semaforo1.setGrupoId(1);
            semaforo1.setClienteId(1111);

            RequestSemaforo semaforo2 = new RequestSemaforo();
            semaforo2.setCantSemaforos(Integer.parseInt(vista.getTxtCantSemaforos2().getText()));
            semaforo2.setLuzRojaFalla(Integer.parseInt(vista.getTxtLuzRojaMal2().getText()));
            semaforo2.setLuzAmarillaFalla(Integer.parseInt(vista.getTxtLuzAmaMal2().getText()));
            semaforo2.setLuzVerdeFalla(Integer.parseInt(vista.getTxtLuzVerdeMal2().getText()));
            semaforo2.setGrupoId(2);
            semaforo2.setClienteId(1111);
            getConexion().enviar(semaforo1, semaforo2);
            JOptionPane.showMessageDialog(null, "Su información ha sido enviada exitosamente");
        }
    }

    public RequestSemaforo getModelo() {
        return modelo;
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
