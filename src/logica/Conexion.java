package logica;

import com.google.gson.Gson;
import presentacion.modelo.RequestSemaforo;
import presentacion.modelo.ResponseDeServidor;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import javax.swing.JOptionPane;
import org.json.*;
import presentacion.controlador.ControladorCliente;
import presentacion.modelo.ResponseEstadoLuces;
import presentacion.vista.Vista;

public class Conexion implements Runnable {

    private String host = "localhost";
    private int puerto = 5000;
    private Socket sock;
    private DataInputStream input_stream; //Flujo datos entrada
    private DataOutputStream output_stream; //Flujo de datos de salida
    public volatile boolean lecturaActiva;
    private Thread hiloLectura;
    byte buffer[];  // Para almacenar lo que llegue del servidor
    private ResponseDeServidor responseDeServidor;
    private ControladorCliente controladorCliente;
    private Vista vista;

    public Conexion(Vista vista) {
        lecturaActiva = true;
        hiloLectura = new Thread(this);
        this.vista = vista;
    }

    public ResponseDeServidor getResponseServidor() {
        if (responseDeServidor == null) {
            responseDeServidor = new ResponseDeServidor();
        }
        return responseDeServidor;
    }

    public ControladorCliente getControladorCliente(Vista vista) {
        if (controladorCliente == null) {
            controladorCliente = new ControladorCliente(vista);
        }
        return controladorCliente;
    }

    // enviar datos al server 
    public ResponseDeServidor enviar(RequestSemaforo semaforo1, RequestSemaforo semaforo2) {
        ResponseDeServidor estadoLuz = new ResponseDeServidor();
        // simulated json sent  
        JSONObject json1 = new JSONObject();
        json1.put("client_id", "1");
        json1.put("cant_semaforos", semaforo1.getCantSemaforos());
        json1.put("luz_red_broken", semaforo1.getLuzRojaFalla());
        json1.put("luz_yellow_broken", semaforo1.getLuzAmarillaFalla());
        json1.put("luz_green_broken", semaforo1.getLuzVerdeFalla());
        json1.put("group_id", "1");
        JSONObject json2 = new JSONObject();
        json2.put("client_id", "1");
        json2.put("cant_semaforos", semaforo2.getCantSemaforos());
        json2.put("luz_red_broken", semaforo2.getLuzRojaFalla());
        json2.put("luz_yellow_broken", semaforo2.getLuzAmarillaFalla());
        json2.put("luz_green_broken", semaforo2.getLuzVerdeFalla());
        json2.put("group_id", "2");

        JSONArray itemsArray = new JSONArray();
        itemsArray.put(json1);
        itemsArray.put(json2);

        JSONObject json = new JSONObject();
        json.put("peticion", "update");
        String temp = itemsArray.toString().replace("\"", "'");
        json.put("info", temp);
        // Datos al server 
        try {
            output_stream.write((json.toString() + "\n").getBytes());
            output_stream.flush();
            System.out.println("Enviando: " + json.toString());
            return estadoLuz;
        } catch (IOException e) {
            e.printStackTrace();
            return estadoLuz;
        }
    }

    // conectar al server    
    public boolean conectar() {
        System.out.println("Inicia conexión");
        try {
            sock = new Socket(host, puerto);
            // datos entrantes
            input_stream = new DataInputStream(sock.getInputStream());
            // datos salientes
            output_stream = new DataOutputStream(sock.getOutputStream());
            // Thread lectura
            hiloLectura.start();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //desconectar del server 
    public boolean desconectar() {
        System.out.println("Fin de la conexión");
        try {
            this.lecturaActiva = false;
            input_stream.close();
            sock.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // recibir datos   
    public boolean recibir(String data_received) {
        JSONArray json_response = new JSONArray(data_received);
        System.out.print("Recibiendo: " + json_response.toString() + "\n");
        Gson gson = new Gson();
        ResponseEstadoLuces[] estadoLuces = gson.fromJson(json_response.toString(), ResponseEstadoLuces[].class);
        /*System.out.println("Seteando Response estadoLuces: ");             
        System.out.println("Luz escogida grupo 1 roja" + estadoLuces[0].isLuzRoja());
        System.out.println("Luz escogida grupo 1 amar" + estadoLuces[0].isLuzAmarilla());
        System.out.println("Luz escogida grupo 1 verde" + estadoLuces[0].isLuzVerde());
        System.out.println("Luz escogida grupo 2 roja" + estadoLuces[1].isLuzRoja());
        System.out.println("Luz escogida grupo 2 amar" + estadoLuces[1].isLuzAmarilla());
        System.out.println("Luz escogida grupo 2 verde" + estadoLuces[1].isLuzVerde());
         */
        if (estadoLuces[0].isLuzRoja()) {
            this.vista.setRadioLuzRoja1(true);
        } else if (estadoLuces[0].isLuzAmarilla()) {
            this.vista.setRadioLuzAma1(true);
        } else if (estadoLuces[0].isLuzVerde()) {
            this.vista.setRadioLuzVerde1(true);
        }

        if (estadoLuces[1].isLuzRoja()) {
            this.vista.setRadioLuzRoja2(true);
        } else if (estadoLuces[1].isLuzAmarilla()) {
            this.vista.setRadioLuzAma2(true);
        } else if (estadoLuces[1].isLuzVerde()) {
            this.vista.setRadioLuzVerde2(true);
        }
        return true;
    }

    @Override
    public void run() {
        while (lecturaActiva) {
            try {

                buffer = new byte[1024];
                input_stream.read(buffer);
                String mensaje = new String(buffer).trim();
                this.recibir(mensaje);
            } catch (IOException e) {
                System.out.println("Socket disconnected ..");
                //e.printStackTrace();
            }
        }
    }

    public void stop() {
        lecturaActiva = false;
    }
}
