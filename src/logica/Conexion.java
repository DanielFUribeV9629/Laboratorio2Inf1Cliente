package logica;

import presentacion.modelo.RequestSemaforo;
import presentacion.modelo.ResponseDeServidor;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import org.json.*;

public class Conexion implements Runnable {
    
    private String host = "localhost";
    private int puerto = 5000;
    private Socket sock; 
    private DataInputStream input_stream; //Flujo datos entrada
    private DataOutputStream output_stream; //Flujo de datos de salida
    public volatile boolean lecturaActiva;
    private Thread hiloLectura;
    byte buffer[];  // Para almacenar lo que llegue del servidor

    public Conexion() {
        lecturaActiva = true;
        hiloLectura = new Thread(this);
    }        
    // enviar datos al server 
    public boolean enviar(RequestSemaforo semaforo1, RequestSemaforo semaforo2) {
        ResponseDeServidor estadoLuz = new ResponseDeServidor();
        // simulated json sent
        String data = "{\"info\": [{\"cant_semaforos\": 7, \"luz_red_broken\": 1, \"luz_yellow_broken\": 2, \"client_id\": 2021051014, \"group_id\": 1, \"luz_green_broken\": 3}, {\"cant_semaforos\": 15, \"luz_red_broken\": 4, \"luz_yellow_broken\": 5, \"client_id\": 2021051014, \"group_id\": 2, \"luz_green_broken\": 6}], \"peticion\": \"update\"}";
        // create semaforo 1 json
        JSONObject client_response= new JSONObject(data);
        // Datos al server 
        try {
            output_stream.writeUTF(client_response.toString());
            output_stream.flush();
            System.out.println("Enviando: "+client_response.toString());
            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }            
    }
    // conectar al server    
    public boolean conectar() {
        System.out.println("Inicia conexión");
        try {
            sock = new Socket(host, puerto);
            // datos entrantes
            input_stream=new DataInputStream(sock.getInputStream());
            // datos salientes
            output_stream = new DataOutputStream(sock.getOutputStream());
            // Thread lectura
            hiloLectura.start();
            return true;       
        }
        catch(IOException e) {
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
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;            
        }        
    }
    // recibir datos   
    public boolean recibir(String data_received) {                
        try {
            JSONArray server_response = new JSONArray(data_received); 
            System.out.print("Recibiendo: "+server_response.toString()+"\n");
            // sumluted received json
            JSONObject json = new JSONObject();
            json.put("luz_roja", true);
            json.put("luz_amarilla", false);
            json.put("luz_verde", false);
            json.put("group_id", "2");
        } catch (Exception e) {
            System.out.print("Recibiendo: "+data_received.toString()+"\n");
            //e.printStackTrace();
        }
        return true; 
    }

    @Override
    public void run() { 
        while(lecturaActiva){
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
    
    public void stop(){
        lecturaActiva = false;
    }
}
