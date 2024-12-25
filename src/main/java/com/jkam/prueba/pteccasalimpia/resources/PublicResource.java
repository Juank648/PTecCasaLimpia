package com.jkam.prueba.pteccasalimpia.resources;

import com.jkam.prueba.pteccasalimpia.model.Productos;
import com.jkam.prueba.pteccasalimpia.service.ProductosService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author 
 */
@Path("public")
public class PublicResource {
    
    @EJB
    ProductosService productosService;
    
    @GET
    @Path("productosEntidad")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Productos> getProductosEntidad(){
        return productosService.getProductosEntidad();
    }
}
