package libraryservicecontrol.model;

import java.sql.Date;

public class HistoricoPrestamo {
	
    private Integer id;
    private Integer elementoId;
    private Integer usuarioId;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;
    private Elemento elementoAsociado;

    public Integer getId() {
            return id;
    }
    public void setId(Integer id) {
            this.id = id;
    }
    public Integer getElementoId() {
            return elementoId;
    }
    public void setElementoId(Integer elementoId) {
            this.elementoId = elementoId;
    }
    public Integer getUsuarioId() {
            return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
            this.usuarioId = usuarioId;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public Date getFechaDevolucion() {
            return fechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
            this.fechaDevolucion = fechaDevolucion;
    }
    public String getEstado() {
            return estado;
    }
    public void setEstado(String estado) {
            this.estado = estado;
    }
    public Elemento getElementoAsociado() {
        return elementoAsociado;
    }
    public void setElementoAsociado(Elemento elementoAsociado) {
        this.elementoAsociado = elementoAsociado;
    }

}
