/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.net.URI;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONArray;

/**
 *
 * @author jcpleitez
 */
public class ArchivoRest {

    //comentariooo
    Client cliente;
    WebTarget target;
    final static String URL_RESOURCE = "http://localhost/ws/mantenimiento";

    public ArchivoRest() {
        this.cliente = ClientBuilder.newClient();
        this.target = cliente.target(URL_RESOURCE);
    }

    public URI postLista(List<List<String>> lista) {
        if (lista != null && !lista.isEmpty()) {
            //JsonObject nuevo = Json.createObjectBuilder().add("nombre", "Juan").build();
            JSONArray jsonArray = new JSONArray();

            for (List<String> list : lista) {
                jsonArray.put(new JSONArray(list));
            }

            Response respuesta = target.path("holaJuan").
                    request(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON).
                    post(Entity.json(jsonArray));
            if (respuesta.getStatus() == Response.Status.CREATED.getStatusCode() && respuesta != null) {
                return respuesta.getLocation();
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public URI postTexto(String texto) {
        JsonObject nuevo = Json.createObjectBuilder().add("nombre", "Carlos").build();
        if (texto != null && texto.trim().isEmpty()) {
            Response salida = target.path("prueba").request(MediaType.APPLICATION_JSON).post(Entity.json(nuevo));
            if (salida != null && salida.getStatus()==Response.Status.CREATED.getStatusCode()) {
                return salida.getLocation();
            }
        }
        return null;
    }

}
