package com.informatorio.ApiRest.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="startup")
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    private double objetivo;
    private boolean publicado;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tags> tags = new ArrayList<>();
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public double getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(double objetivo) {
        this.objetivo = objetivo;
    }
    public boolean isPublicado() {
        return publicado;
    }
    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
    public List<Tags> getTags() {
        return tags;
    }
    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
    
    @Override
    public String toString() {
        return "Startup [contenido=" + contenido + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion
                + ", id=" + id + ", nombre=" + nombre + ", objetivo=" + objetivo + ", publicado=" + publicado
                + ", tags=" + tags + "]";
    }
}
