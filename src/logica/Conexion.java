package logica;

import com.google.gson.Gson;
import presentacion.modelo.RequestSemaforo;
import presentacion.modelo.ResponseDeServidor;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import org.json.*;
//import com.google.gson.Gson;
//import com.google.gson.JsonSyntaxException;

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
        // simulated json sent          

        //String men = "{ \"peticion\":\"update\", \"info\":[ { \"cant_semaforos\":\""+semaforo1.getCantSemaforos()+"\", \"luz_red_broken\":\""+semaforo1.getLuzRojaFalla()+"\", \"luz_yellow_broken\":\""+semaforo1.getLuzAmarillaFalla()+"\", \"luz_green_broken\":\""+semaforo1.getLuzVerdeFalla()+"\", \"client_id\":\""+semaforo1.getClienteId()+"\", \"group_id\":\""+semaforo1.getGrupoId()+"\" }, { \"cant_semaforos\":\""+semaforo2.getCantSemaforos()+"\", \"luz_red_broken\":\""+semaforo2.getLuzRojaFalla()+"\", \"luz_yellow_broken\":\""+semaforo2.getLuzAmarillaFalla()+"\", \"luz_green_broken\":\""+semaforo2.getLuzVerdeFalla()+"\", \"client_id\":\""+semaforo2.getClienteId()+"\", \"group_id\":\""+semaforo2.getGrupoId()+"\" } ] }";
        
        
        String mens = "{\n"
                + "   \"peticion\":\"update\",\n"
                + "   \"info\":[\n"
                + "      {\n"
                + "         \"cant_semaforos\":\""+semaforo1.getCantSemaforos()+"\",\n"
                + "         \"luz_red_broken\":\""+semaforo1.getLuzRojaFalla()+"\",\n"
                + "         \"luz_yellow_broken\":\""+semaforo1.getLuzAmarillaFalla()+"\",\n"
                + "         \"luz_green_broken\":\""+semaforo1.getLuzVerdeFalla()+"\",\n"
                + "         \"client_id\":\""+semaforo1.getGrupoId()+"\",\n"
                + "         \"group_id\":\""+semaforo1.getClienteId()+"\"\n"
                + "      },\n"
                + "      {\n"
                + "         \"cant_semaforos\":\""+semaforo2.getCantSemaforos()+"\",\n"
                + "         \"luz_red_broken\":\""+semaforo2.getLuzRojaFalla()+"\",\n"
                + "         \"luz_yellow_broken\":\""+semaforo2.getLuzAmarillaFalla()+"\",\n"
                + "         \"luz_green_broken\":\""+semaforo2.getLuzVerdeFalla()+"\",\n"
                + "         \"client_id\":\""+semaforo2.getGrupoId()+"\",\n"
                + "         \"group_id\":\""+semaforo2.getClienteId()+"\"\n"
                + "      }\n"
                + "   ]\n"
                + "}";
        try {
            output_stream.writeUTF(mens);
            output_stream.flush();
            System.out.println("Enviando: " + mens);
            return true;
        } catch (IOException e) {
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
        RequestSemaforo modelo = new RequestSemaforo();
        Gson gsonF = new Gson();
        ResponseDeServidor[] responseServidor = gsonF.fromJson(data_received, ResponseDeServidor[].class);

        System.out.println("¿¿¿" + data_received);

        modelo.recibir(responseServidor);

        return true;
    }
/*
    public JSONObject recibir(String data_received) {                
        JSONObject json_response = new JSONObject(data_received); 
        System.out.print("Recibiendo: "+json_response.toString()+"\n");
        // sumluted received json
        JSONObject json = new JSONObject();
        json.put("luz_roja", true);
        json.put("luz_amarilla", false);
        json.put("luz_verde", false);
        json.put("group_id", "2");
        return json; 
    }
    */
    @Override
    public void run() {
        while (lecturaActiva) {
            try {
                buffer = new byte[1024];
                input_stream.read(buffer);
                String mensaje = new String(buffer).trim();
                System.out.println("Esperando servidor");
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
