# 🚍 Sistema de Buses UTPL  

🔹 *Sistema de gestión de transporte universitario que permite buscar rutas por parada o línea, simular acceso de pasajeros, administrar líneas/paradas y asignar choferes.* 

## Arquitectura MVC 
````plaintext
src/
├── main/
│   ├── java/
│   │   ├── Controlador/            # Entidades y Lógica
│   │   │   ├── Admin.java
│   │   │   ├── Bus.java
│   │   │   ├── Buscador.java
│   │   │   ├── Chofer.java
│   │   │   ├── Estudiante.java
│   │   │   ├── Horario.java
│   │   │   ├── Linea.java
│   │   │   ├── ModificaciónRutas.java
│   │   │   ├── OptimizaciónRutas.java
│   │   │   ├── Parada.java
│   │   │   └── Persona.java
│   │   ├── Modelo/                 # Persistencia con Bases de Datos
│   │   │   ├── Conexion.java
│   │   │   └── DatosRutas.java
│   │   ├── Vista/                  # Interfaz de usuario por consola
│   │   │   ├── VistaAdmin.java
│   │   │   ├── VistaBusqueda.java
│   │   │   ├── VistaPrincipal.java
│   │   │   └── VistaRutas.java
│   │   └── Recursos/               # Datos a utilizar
│   │       ├── Bus.csv
│   │       ├── Choferes.csv
│   │       ├── Horario.csv
│   │       └── Lineasbu.csv
│   └── main.java                   # Orquestador
└── test/                         
````
## 🛠️ Tecnologías  
![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)  
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql&logoColor=white)  
![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36?logo=apache-maven)  

## 📌 Funcionalidades Principales  
- **Búsqueda de rutas** por parada o línea de bus.  
- **Simulación de acceso** de pasajeros a los buses.  
- **Gestión de líneas**: Crear, eliminar y agregar paradas a líneas existentes.  
- **Asignación de choferes** a líneas creadas.  

## 🔥 **Fases**  
1. **Fase 1**: Resultado mediante consola.  
2. **Fase 2**: Integración de mas paradigmas e interfaz grafica con javaFX .  
3. **Fase 3**: Integración de Mapas mediante API de Maps.  
## 🚀 Instalación y Ejecución  
1. Clona el repositorio:  
   ```bash
   git clone https://github.com/POO-C-AA25/aab2-proyecto-grupo_1.git

## Autores

[@Cristhian Quizhpe](https://github.com/Cristhian23456) - Desarrollo .

[@Lennin Salinas](https://github.com/Stalinn99) - Desarrollo.
