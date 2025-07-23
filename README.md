# 🚍 Sistema de Autobuses UTPL 

🔹 *Sistema de gestión de transporte universitario que permite buscar rutas por parada o línea, administrar Autobuses/paradas.* 

## Arquitectura MVC 
````plaintext
src/
├── principal/
│ ├── java/
│ │ ├── Controlador/ # Entidades y Lógica
│ │ │ ├── Administrador.java
│ │ │ ├── Bus.java
│ │ │ ├── Buscador.java
│ │ │ ├── Chofer.java
│ │ │ ├── Estudiante.java
│ │ │ ├── Horario.java
│ │ │ ├── Línea.java
│ │ │ ├── ModificaciónRutas.java
│ │ │ ├── OptimizaciónRutas.java
│ │ │ ├── Parada.java
│ │ │ └── Persona.java
│ │ ├── Modelo/ # Persistencia con Bases de Datos
│ │ │ ├── Conexion.java
│ │ │ └── DatosRutas.java
│ │ ├── Vista/ # Interfaz de usuario por consola
│ │ │ ├── VistaAdmin.java
│ │ │ ├── VistaBusqueda.java
│ │ │ ├── VistaPrincipal.java
│ │ │ ├── main.java
│ │ │ └── VistaRutas.java
│ │ └── Recursos/ # Datos a utilizar
│ │ ├── Bus.csv
│ │ ├── Choferes.csv
│ │ ├── Horario.csv 
│ │ └── Lineasbu.csv
│ └── Depedencias/ 
└──prueba/ 
````
## 🛠️ Tecnologías 
![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)  
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql&logoColor=white)  
![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36?logo=apache-maven)  

## 📌 Funcionalidades Principales 
- **Búsqueda de rutas** por parada o línea de autobús. 
- **Gestión de líneas**: Crear, eliminar y agregar paradas a líneas existentes. 
- **Asignación de choferes** a líneas creadas. 

## 🔥 **Fases**  
1. **Fase 1**: Resultado mediante consola. Culminada. 
2. **Fase 2**: Integración de más paradigmas e interfaz gráfica con javaFX . 
3. **Fase 3**: Integración de Mapas mediante API de Mapas. 
## 🚀 Instalación y Ejecución 
1. Clona el repositorio: 
   ```bash
   clon git https://github.com/POO-C-AA25/aab2-proyecto-grupo_1.git

## Autores

[@Cristhian Quizhpe](https://github.com/Cristhian23456) - Desarrollo.

[@Lennin Salinas](https://github.com/Stalinn99) - Desarrollo.
