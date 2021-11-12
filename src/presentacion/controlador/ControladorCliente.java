package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import logica.Conexion;
import presentacion.modelo.RequestSemaforo;
import presentacion.modelo.ResponseDeServidor;
import presentacion.modelo.ResponseEstadoLuces;
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
            conexion = new Conexion();
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
                if (conectado){
                    JOptionPane.showMessageDialog(null, "Se ha conectado exitosamente");
                }else {
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
                if (conectado){
                    JOptionPane.showMessageDialog(null, "Se ha desconectado exitosamente");
                }else {
                    JOptionPane.showMessageDialog(null, "No fue posible desconectarse");
                }
            } else if (boton == vista.getBtnEnviar()) {
                getConexion().enviar(modelo, modelo);
                //enviar();
            }
        }
    }

    public void enviar() {
        if (vista.getTxtCantSemaforos1().getText().equals("") || vista.getTxtCantSemaforos2().getText().equals("") || vista.getTxtLuzRojaMal1().getText().equals("")
                || vista.getTxtLuzRojaMal2().getText().equals("") || vista.getTxtLuzAmaMal1().getText().equals("") || vista.getTxtLuzAmaMal2().getText().equals("")
                || vista.getTxtLuzVerdeMal1().getText().equals("") || vista.getTxtLuzVerdeMal2().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor en todos los campos.");
        } else {
            vista.getTxtCantSemaforos1().setEnabled(false);
            vista.getTxtCantSemaforos2().setEnabled(false);
            vista.getTxtLuzRojaMal1().setEnabled(false);
            vista.getTxtLuzRojaMal2().setEnabled(false);
            vista.getTxtLuzAmaMal1().setEnabled(false);
            vista.getTxtLuzAmaMal2().setEnabled(false);
            vista.getTxtLuzVerdeMal1().setEnabled(false);
            vista.getTxtLuzVerdeMal2().setEnabled(false);            
            
            ResponseDeServidor response = getModelo().enviar();
            
            JOptionPane.showMessageDialog(null, "Su información ha sido enviada exitosamente");
            
            if (response.getSemaforo1().isLuzRoja()){
                vista.setRadioLuzRoja1(true);
            }else if (response.getSemaforo1().isLuzAmarilla()) {
                vista.setRadioLuzRoja1(true);
            }else if (response.getSemaforo1().isLuzVerde()) {
                vista.setRadioLuzRoja1(true);
            }
            
            if (response.getSemaforo2().isLuzRoja()){
                vista.setRadioLuzRoja2(true);
            }else if (response.getSemaforo2().isLuzAmarilla()) {
                vista.setRadioLuzRoja2(true);
            }else if (response.getSemaforo2().isLuzVerde()) {
                vista.setRadioLuzRoja2(true);
            }
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
