package com.example.prueba_smart_job.dto;

public class ErrorDTO {

    private String mensaje;

    public ErrorDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje( String mensaje ) {
        this.mensaje = mensaje;
    }
}
