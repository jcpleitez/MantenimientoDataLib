/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.net.URI;
import java.util.List;
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
    WebTarget raiz;
    final static String URL_RESOURCE = "http://192.168.1.7/ws/mantenimiento";

    public ArchivoRest() {
        this.cliente = ClientBuilder.newClient();
        this.raiz = cliente.target(URL_RESOURCE);
    }

    public URI postLista(List<List<String>> lista) {
        if (lista != null && !lista.isEmpty()) {
            //JsonObject nuevo = Json.createObjectBuilder().add("nombre", "Juan").build();
            JSONArray jsonArray = new JSONArray();

            for (List<String> list : lista) {
                jsonArray.put(new JSONArray(list));
            }

            Response respuesta = raiz.path("holaJuan").
                    request(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON).
                    post(Entity.json(jsonArray));
            if (respuesta.getStatus() == Response.Status.CREATED.getStatusCode() && respuesta != null) {
                return respuesta.getLocation();
            }
        }
        return null;
    }

}
