package com.superyaz.lacoquetasas.model;

import java.util.UUID;

public class Venta {
    private String id;
    private String atraccion; //
    private String tipoBoleta; // Familiar, Adulto Mayor, Normal
    private boolean jornadaNocturna; //
    private int cantidad; //
    private double valorTotal; //

    public Venta() {
        this.id = UUID.randomUUID().toString();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAtraccion() { return atraccion; }
    public void setAtraccion(String atraccion) { this.atraccion = atraccion; }

    public String getTipoBoleta() { return tipoBoleta; }
    public void setTipoBoleta(String tipoBoleta) { this.tipoBoleta = tipoBoleta; }

    public boolean isJornadaNocturna() { return jornadaNocturna; }
    public void setJornadaNocturna(boolean jornadaNocturna) { this.jornadaNocturna = jornadaNocturna; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
}