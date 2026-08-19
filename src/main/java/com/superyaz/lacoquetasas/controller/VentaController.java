package com.superyaz.lacoquetasas.controller;

import com.superyaz.lacoquetasas.model.Venta;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    // Colección en memoria para almacenar las ventas temporalmente
    private List<Venta> coleccionVentas = new ArrayList<>();

    // Método para calcular el total aplicando tarifas e incrementos
    private double calcularTotal(String tipoBoleta, boolean nocturna, int cantidad) {
        double tarifaBase = 0;
        double incremento = 0;

        // Tarifas base e incrementos nocturnos según el requerimiento
        if (tipoBoleta.equalsIgnoreCase("Familiar")) {
            tarifaBase = 8000; //
            if (nocturna) incremento = 0.15; // Incremento del 15% en nocturno
        } else if (tipoBoleta.equalsIgnoreCase("Adulto Mayor")) {
            tarifaBase = 4500; //
            if (nocturna) incremento = 0.08; // Incremento del 8% en nocturno
        } else if (tipoBoleta.equalsIgnoreCase("Normal")) {
            tarifaBase = 12500; //
            if (nocturna) incremento = 0.12; // Incremento del 12% en nocturno
        }

        double precioUnitario = tarifaBase + (tarifaBase * incremento);
        return precioUnitario * cantidad; //
    }

    // 1. Registrar una nueva venta calculando el total automáticamente
    @PostMapping
    public Venta registrarVenta(@RequestBody Venta venta) {
        double total = calcularTotal(venta.getTipoBoleta(), venta.isJornadaNocturna(), venta.getCantidad());
        venta.setValorTotal(total);
        
        coleccionVentas.add(venta);
        return venta;
    }

    // 2. Consultar todas las ventas realizadas
    @GetMapping
    public List<Venta> consultarVentas() {
        return coleccionVentas;
    }

    // 3. Modificar los datos de una venta y recalcular el cobro
    @PutMapping("/{id}")
    public Venta modificarVenta(@PathVariable String id, @RequestBody Venta ventaActualizada) {
        for (Venta ventaExistente : coleccionVentas) {
            if (ventaExistente.getId().equals(id)) {
                ventaExistente.setAtraccion(ventaActualizada.getAtraccion());
                ventaExistente.setTipoBoleta(ventaActualizada.getTipoBoleta());
                ventaExistente.setJornadaNocturna(ventaActualizada.isJornadaNocturna());
                ventaExistente.setCantidad(ventaActualizada.getCantidad());
                
                double nuevoTotal = calcularTotal(ventaActualizada.getTipoBoleta(), ventaActualizada.isJornadaNocturna(), ventaActualizada.getCantidad());
                ventaExistente.setValorTotal(nuevoTotal);
                
                return ventaExistente;
            }
        }
        return null; 
    }

    // 4. Cancelar o eliminar el registro de una venta
    @DeleteMapping("/{id}")
    public String eliminarVenta(@PathVariable String id) {
        boolean eliminada = coleccionVentas.removeIf(venta -> venta.getId().equals(id));
        if (eliminada) {
            return "Venta eliminada correctamente.";
        } else {
            return "Venta no encontrada.";
        }
    }
}