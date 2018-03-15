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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionControl;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionHistorico;

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

    public URI postMigracionControl(List<MigracionControl> lista) {
        if (lista != null && !lista.isEmpty()) {
            if (target != null) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(new JSONArray(lista));
                Response respuesta = target.path("migracionControl").
                        request(MediaType.APPLICATION_JSON).
                        post(Entity.json(jsonArray));
                if (respuesta.getStatus() == Response.Status.CREATED.getStatusCode() && respuesta != null) {
                    return respuesta.getLocation();
                }
            }
        }
        return null;
    }

    public URI postMigracionHistorico(List<MigracionHistorico> lista) {
        if (lista != null && !lista.isEmpty()) {
            if (target != null) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(new JSONArray(lista));
                Response respuesta = target.path("migracionHistorico").
                        request(MediaType.APPLICATION_JSON).
                        post(Entity.json(jsonArray));
                if (respuesta.getStatus() == Response.Status.CREATED.getStatusCode() && respuesta != null) {
                    return respuesta.getLocation();
                }
            }
        }
        return null;
    }

}
