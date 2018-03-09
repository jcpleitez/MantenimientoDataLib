/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;


import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.Mantenimiento;

/**
 *
 * @author jcpleitez
 */
public class ArchivoRest {
    
    Client cliente;    
    
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
    
    @GET
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public Mantenimiento getMantenimiento(String uri){
        if(uri != null && !uri.trim().isEmpty()){
            WebTarget target = cliente.target(uri);
            Mantenimiento jsonObject = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(new Mantenimiento(), MediaType.APPLICATION_JSON), Mantenimiento.class);
            return jsonObject;
        }
        return null;
    }
    
}
