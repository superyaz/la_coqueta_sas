# API REST - Taquilla "La Coqueta S.A.S." 🎢🎟️

Este repositorio contiene la solución al **Examen 1 (10%)** de la asignatura **Programación Web** en la *Institución Universitaria Marco Fidel Suarez*, impartida por el docente Walter Gómez[cite: 2]. 

El proyecto consiste en un prototipo de software backend para digitalizar la gestión de ventas de boletería de la empresa de atracciones y parque de diversiones "La Coqueta S.A.S."[cite: 2].

---

## 🚀 Lógica de Negocio y Tarifas

El sistema administra las ventas en taquilla basándose en el siguiente esquema de precios base:
* Boleta Familiar: $8.000[cite: 2].
* Boleta Adulto Mayor: $4.500[cite: 2].
* Boleta Normal: $12.500[cite: 2].

Además, la API calcula automáticamente recargos si el servicio de la atracción se presta en horario nocturno:
* Incremento del 15% para la boleta tipo Familiar en servicio nocturno[cite: 2].
* Incremento del 8% para la boleta de Adulto Mayor en horario nocturno[cite: 2].
* Incremento del 12% sobre la tarifa base para cualquier otra combinación en horario nocturno[cite: 2].

---

## ⚙️ Operaciones del Sistema (Endpoints)

La API permite a los cajeros realizar las siguientes operaciones de gestión de datos:
* **Registrar Venta:** Permite ingresar una nueva venta indicando la atracción, tipo de boleta, si es jornada nocturna y la cantidad comprada[cite: 2]. El sistema calcula automáticamente el valor total a pagar[cite: 2].
* **Consultar Ventas:** Endpoint para listar todas las ventas realizadas hasta el momento[cite: 2].
* **Modificar Venta:** Permite actualizar los datos de una venta en caso de error, recalculando automáticamente el cobro total[cite: 2].
* **Cancelar Venta:** Ruta para eliminar el registro de una venta específica[cite: 2].

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java
* **Framework:** Spring Boot (Spring Web)
* **Persistencia:** Almacenamiento temporal en memoria mediante colecciones de objetos, tal como lo requiere el prototipo inicial[cite: 2].
* **Pruebas:** Todas las operaciones y validaciones de la API están diseñadas para ser probadas mediante Postman[cite: 2].
