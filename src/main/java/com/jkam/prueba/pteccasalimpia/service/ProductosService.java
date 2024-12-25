/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jkam.prueba.pteccasalimpia.service;

import com.jkam.prueba.pteccasalimpia.model.Productos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author juank
 */
@Stateless
public class ProductosService {
    
    @PersistenceContext(unitName ="com.jkam.prueba_PtecCasaLimpia_war_1.0PU")
    private EntityManager em;
    
    public List<Productos> getProductosEntidad() {
        return em.createNamedQuery("Productos.findAll", Productos.class).getResultList();
    }
    
    public Productos getProductoById(Integer id) {
        return em.find(Productos.class, id);
    }
    
    public void saveProducto(Productos producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        em.persist(producto);
    }
    
    public Productos updateProducto(Productos producto) {
        if (producto == null || producto.getId() == null) {
            throw new IllegalArgumentException("El producto o su ID no pueden ser nulos.");
        }
        
        Productos productoExistente = em.find(Productos.class, producto.getId());
        if (productoExistente == null) {
            throw new EntityNotFoundException("Producto no encontrado con ID: " + producto.getId());
        }
        
        return em.merge(producto);
    }
    
}
