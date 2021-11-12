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
    protected DataOutputStream output_stream; //Flujo de datos de salida
    //private BufferedReader input_stream;  //Flujo datos entrada
    private DataInputStream input_stream;
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    InputStreamReader received_data;
    private Thread hiloLectura;
    private volatile boolean lecturaActiva;

    public void SistemaCliente() {
        hiloLectura = new Thread(this);               
    }
    // enviar datos al server 
    public ResponseDeServidor enviar(RequestSemaforo semaforo1, RequestSemaforo semaforo2) {
        String f = "Enviando";
        ResponseDeServidor estadoLuz = new ResponseDeServidor();
        System.out.println(f);
        // json to send 
        JSONObject json = new JSONObject();
        json.put("client_id", "1");
        json.put("cant_semaforos", "2");
        json.put("luz_red_broken", "1");
        json.put("luz_yellow_broken", "2");
        json.put("luz_green_broken", "0");
        json.put("group_id", "1");           
        // Datos al server 
        try {
            for (int i = 0; i < 2; i++) {
                //Se escribe en el servidor usando su flujo de datos            
                output_stream.writeUTF(json.toString());
            }
            return estadoLuz;
        }
        catch(IOException e) {
            e.printStackTrace();
            return estadoLuz;
        }            
    }
    // conectar al server    
    public boolean conectar() {
        System.out.println("Inicia conexión");
        byte buffer[]; 
        try {
            sock = new Socket(host, puerto);        
            lecturaActiva = true;
            // datos entrantes
            input_stream=new DataInputStream(sock.getInputStream());
            buffer = new byte[500];
            input_stream.read(buffer);
            String mensaje = new String(buffer).trim();
            System.out.println("Input Stream: "+mensaje); 
            // datos salientes
            output_stream = new DataOutputStream(sock.getOutputStream());
            for (int i = 0; i < 2; i++) {
                //Se escribe en el servidor usando su flujo de datos            
                output_stream.writeUTF("Este es el mensaje número " + (i+1));
            }            
            //hiloLectura.start();
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
            sock.close();
            input_stream.close();
            lecturaActiva = false;
            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;            
        }        
    }
    // recibir datos   
    public JSONObject recibir(String data_received) {                
        JSONObject json_response = new JSONObject(data_received);
        System.out.print(json_response);
        // received json
        JSONObject json = new JSONObject();
        json.put("luz_roja", true);
        json.put("luz_amarilla", false);
        json.put("luz_verde", false);
        json.put("group_id", "2");
        return json; 
    }

    @Override
    public void run() {
        // Para almacenar lo que llegue del servidor
        byte buffer[];                        
        while(lecturaActiva){
            try {
                buffer = new byte[500];
                input_stream.read(buffer);           
            } catch (IOException ex) {
                System.out.println("error en la comunicación");
            }
        }    
    }
    
}
