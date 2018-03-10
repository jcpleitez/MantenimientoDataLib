/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;


import java.net.URI;
import java.util.List;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jcpleitez
 */
public class ArchivoRest {
    
    Client cliente;
    WebTarget raiz;
    final static String URL_RESOURCE = "http://192.168.1.7/ws/mantenimiento";

    public ArchivoRest() {
        this.cliente = ClientBuilder.newClient();
        this.raiz = cliente.target(URL_RESOURCE);
    }
    
    public URI postLista(List<List<String>> lista){
        if(lista != null && !lista.isEmpty()){
            JsonObject nuevo = Json.createObjectBuilder().add("nombre", "Juan").build();
            
            Response respuesta = raiz.path("holaJuan").
                    request(MediaType.APPLICATION_JSON).
                    accept(MediaType.APPLICATION_JSON).
                    post(Entity.json(nuevo));            
            if(respuesta.getStatus() == Response.Status.CREATED.getStatusCode() && respuesta != null){
                return respuesta.getLocation();
            }
        }
        return null;
    }
    
    
    
//    @POST
//    @Produces({MediaType.APPLICATION_JSON +"; charset=utf-8"})
//    public Mantenimiento postMantenimiento(Mantenimiento mmt, String uri){
//        if(mmt != null){
//            WebTarget target = cliente.target(uri);
//            Mantenimiento json = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(mmt, MediaType.APPLICATION_JSON), Mantenimiento.class);
//            return json;
//        }
//        return null;
//    }
    
//    @GET
//    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
//    public Mantenimiento getMantenimiento(String uri){
//        if(uri != null && !uri.trim().isEmpty()){
//            WebTarget target = cliente.target(uri);
//            Mantenimiento jsonObject = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(new Mantenimiento(), MediaType.APPLICATION_JSON), Mantenimiento.class);
//            return jsonObject;
//        }
//        return null;
//    }

    
}
