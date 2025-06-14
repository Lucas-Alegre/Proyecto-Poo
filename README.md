# 🚍 Proyecto Transporte Rutas S.A.

Sistema de gestión de transporte de pasajeros, desarrollado con enfoque en **Programación Orientada a Objetos (POO)** y arquitectura por capas. Permite administrar viajes, reservas, empresas, choferes y vehículos, simulando una API interna y una interfaz de usuario por consola.

---

## 👥 Integrantes del grupo

- Carolina Latour  
- Lucas Alegre  
- Benjamín Aquino  

---

## 🧱 Estructura del Proyecto

```
src/
└── transportesa/
    ├── app/               # Punto de entrada del sistema (Main.java)
    ├── entidades/         # Clases del dominio (Empresa, Viaje, Reserva, Chofer, Vehiculo, etc.)
    ├── servicios/         # Lógica de negocio
    ├── controladores/     # Simulación de endpoints (GET, POST, PUT, DELETE)
    ├── excepciones/       # Excepciones personalizadas
    ├── configuracion/     # Configuración del sistema (modo TEST o PRODUCCIÓN)
    └── ui/
        ├── consola/       # Interfaz de usuario por consola
        └── grafica/       # (En desarrollo) Interfaz gráfica
```

---

## 🚦 Flujo de Ejecución

1. `Main.java` inicia el programa.
2. Se lee el modo de configuración (TEST o PRODUCCIÓN).
3. Se inicializan entidades, servicios y controladores.
4. Se muestra el menú de opciones en consola.
5. El usuario interactúa con el sistema.
6. El menú llama a controladores, que delegan en los servicios.
7. Los servicios manipulan entidades y persisten datos si es necesario.

---

## 📌 Estado del Desarrollo

| Módulo                  | Estado       |
|------------------------|--------------|
| Modelo de dominio      | ✅ Completo  |
| Servicios de negocio   | ✅ Base lista |
| Controladores          | ⚙️ En desarrollo |
| Excepciones            | ✅ Listas     |
| Interfaz de consola    | ⏳ Próximo paso |
| Persistencia (JSON/TXT)| 🔜 A definir  |
| Configuración          | 🔜 A implementar |

---

## 🧪 Tecnologías y buenas prácticas

- **Lenguaje:** Java
- **Paradigma:** Programación Orientada a Objetos
- **Patrones aplicados:** MVC, Servicios, Controladores, Excepciones personalizadas
- **Separación por capas:** clara separación de responsabilidades
- **Escalable:** preparada para agregar interfaz gráfica o integración con BD

---

## 🎯 Próximos pasos

- [ ] Completar controladores (simulación CRUD)
- [ ] Crear menú interactivo en consola
- [ ] Definir y aplicar lógica de persistencia (archivos)
- [ ] Incorporar configuración por entorno
- [ ] Realizar pruebas integrales con datos simulados

---

## 📩 Contacto

Para consultas, sugerencias o contribuciones, pueden comunicarse con cualquiera de los integrantes por GitHub.

---

📝 *Este proyecto fue desarrollado como trabajo práctico de la materia Programación Orientada a Objetos.*