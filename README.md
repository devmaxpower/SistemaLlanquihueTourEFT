![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🌎 Evaluación Final Transversal
# Sistema Llanquihue Tour

## Desarrollo Orientado a Objetos I

---

# 👤 Autor

- **Nombre:** Maximiliano Villalobos
- **Carrera:** Analista Programador Computacional
- **Institución:** Duoc UC – Campus Virtual
- **Asignatura:** Desarrollo Orientado a Objetos I
- **Evaluación:** Evaluación Final Transversal (EFT)
- **Año:** 2026

---

# 📘 Descripción del proyecto

**Sistema Llanquihue Tour** es una aplicación desarrollada en Java que permite administrar la información de una agencia de turismo, gestionando clientes, guías turísticos, proveedores, tours y reservas.

El proyecto fue desarrollado aplicando los contenidos estudiados durante la asignatura **Desarrollo Orientado a Objetos I**, utilizando una arquitectura organizada por paquetes y aplicando los principales principios de la Programación Orientada a Objetos.

Entre sus principales funcionalidades se encuentran:

- Gestión de personas.
- Administración de tours.
- Registro y control de reservas.
- Carga de información desde archivos externos.
- Validación de RUT mediante algoritmo chileno.
- Manejo de excepciones personalizadas.
- Documentación mediante JavaDoc.

---

# 🎯 Objetivos del proyecto

El sistema fue desarrollado con el propósito de demostrar la aplicación práctica de los contenidos abordados durante la asignatura, incorporando:

- Encapsulamiento.
- Herencia.
- Polimorfismo.
- Interfaces.
- Composición entre clases.
- Colecciones dinámicas.
- Lectura de archivos externos.
- Manejo de excepciones.
- Documentación JavaDoc.

---

# 🏛 Arquitectura del sistema

El proyecto fue organizado utilizando una arquitectura modular basada en paquetes, separando claramente las responsabilidades de cada componente.

```text
                     Main
                      │
          ┌───────────┴────────────┐
          │                        │
          ▼                        ▼
     Services                CargadorDatos
          │                        │
          ▼                        ▼
      Modelos               Archivos TXT
```

Esta organización facilita el mantenimiento del sistema y favorece la reutilización del código.

---

# 📁 Estructura del proyecto

```text
SistemaLlanquihueTourEFT
│
├── archivos
│   ├── clientes.txt
│   ├── guias.txt
│   └── tours.txt
│
├── src
│   ├── app
│   │   └── Main.java
│   │
│   ├── data
│   │   ├── ArchivoManager.java
│   │   └── CargadorDatos.java
│   │
│   ├── exception
│   │   └── RutInvalidoException.java
│   │
│   ├── interfaces
│   │   └── Registrable.java
│   │
│   ├── model
│   │   ├── Cliente.java
│   │   ├── Direccion.java
│   │   ├── Guia.java
│   │   ├── Itinerario.java
│   │   ├── Persona.java
│   │   ├── Proveedor.java
│   │   ├── Reserva.java
│   │   ├── Rut.java
│   │   └── Tour.java
│   │
│   ├── service
│   │   ├── PersonaService.java
│   │   ├── ReservaService.java
│   │   └── TourService.java
│   │
│   └── utils
│       └── ValidadorRut.java
│
├── docs
│
├── README.md
└── .gitignore
```

---

# 📦 Descripción de los paquetes

## 📂 app

Contiene la clase principal del sistema.

### Main

Controla la ejecución del programa y presenta el menú principal desde donde el usuario puede acceder a todas las funcionalidades.

---

## 📂 model

Representa las entidades principales del sistema.

### Persona

Clase base del sistema.

De ella heredan:

- Cliente
- Guia
- Proveedor

### Rut

Representa un RUT chileno compuesto por el número y el dígito verificador.

### Direccion

Almacena la información correspondiente a una dirección.

### Itinerario

Representa la planificación de un tour.

### Tour

Contiene la información de un recorrido turístico.

### Reserva

Relaciona un cliente con un tour, almacenando además la cantidad de personas, fecha, estado y total de la reserva.

---

## 📂 service

Implementa la lógica de negocio del sistema.

### PersonaService

Administra clientes, guías y proveedores.

Entre sus responsabilidades se encuentran:

- agregar personas;
- buscar por RUT;
- listar personas;
- eliminar registros.

### TourService

Gestiona la información relacionada con los tours.

Permite:

- agregar tours;
- buscar por ID;
- listar tours;
- modificar disponibilidad;
- consultar tours disponibles.

### ReservaService

Administra todas las reservas del sistema.

Permite:

- registrar reservas;
- confirmar reservas;
- cancelar reservas;
- calcular cupos disponibles;
- listar reservas;
- buscar reservas.

---

## 📂 data

Contiene la lógica encargada de la lectura de archivos.

### ArchivoManager

Lee los archivos de texto y convierte cada línea en objetos del sistema.

### CargadorDatos

Carga la información inicial en memoria utilizando los servicios correspondientes.

---

## 📂 utils

Contiene clases reutilizables.

### ValidadorRut

Implementa el algoritmo oficial de cálculo del dígito verificador chileno y valida los datos ingresados por el usuario.

---

## 📂 exception

### RutInvalidoException

Excepción personalizada utilizada para controlar errores relacionados con la validación del RUT.

---

## 📂 interfaces

### Registrable

Interfaz implementada por las entidades registrables del sistema.

Permite compartir un comportamiento común entre diferentes clases.

---

# 🔗 Modelo de clases

```text
                         Persona
                      /     |      \
                     /      |       \
                    ▼       ▼        ▼
              Cliente     Guia   Proveedor
                   │
                   ▼
                  Rut
                   │
                   ▼
            ValidadorRut
                   │
                   ▼
       RutInvalidoException
```

Relación entre reservas y tours:

```text
Cliente
    │
    ▼
 Reserva
    ▲
    │
   Tour
    │
    ▼
Itinerario
```

---

# 🔄 Flujo de funcionamiento

```text
Usuario
   │
   ▼
Main
   │
   ▼
Services
   │
   ▼
Modelos
   │
   ▼
Archivos TXT
```

El sistema carga inicialmente la información desde archivos externos.

Posteriormente el usuario interactúa con el menú principal para administrar personas, tours y reservas.

Toda la lógica es ejecutada por las clases del paquete **service**, mientras que los modelos representan las entidades del dominio.

---

# ⚙ Funcionalidades implementadas

- Gestión de clientes.
- Gestión de guías.
- Gestión de proveedores.
- Gestión de tours.
- Registro de reservas.
- Confirmación de reservas.
- Cancelación de reservas.
- Control de disponibilidad.
- Cálculo automático del total de una reserva.
- Cálculo de cupos disponibles.
- Lectura de información desde archivos externos.
- Validación de RUT.
- Manejo de excepciones personalizadas.
- Uso de colecciones dinámicas (`ArrayList`).
- Documentación mediante JavaDoc.

---

# 🧠 Principios de Programación Orientada a Objetos aplicados

Durante el desarrollo se aplicaron los siguientes conceptos:

- Encapsulamiento.
- Herencia.
- Polimorfismo.
- Interfaces.
- Composición.
- Sobrescritura mediante `@Override`.
- Reutilización de código.
- Separación de responsabilidades.

---

# 📄 Archivos externos

La información inicial del sistema se carga automáticamente desde los siguientes archivos:

```text
archivos/
├── clientes.txt
├── guias.txt
└── tours.txt
```

Estos archivos permiten inicializar el sistema con información previamente registrada.

---

# 🛡 Validación del RUT

El sistema incorpora una validación completa del RUT chileno.

Para ello se implementó:

- algoritmo de cálculo del dígito verificador;
- validación de formato;
- excepción personalizada (`RutInvalidoException`);
- manejo mediante bloques `try-catch`.

---

# 💻 Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Git
- GitHub
- JavaDoc

---

# ▶ Cómo ejecutar el proyecto

1. Clonar el repositorio:

```bash
git clone https://github.com/devmaxpower/SistemaLlanquihueTourEFT.git
```

2. Abrir el proyecto con IntelliJ IDEA.

3. Configurar un JDK compatible (Java 17 o superior recomendado).

4. Verificar que la carpeta **archivos** se encuentre en la raíz del proyecto.

5. Ejecutar:

```text
src/app/Main.java
```

---

# 📚 Documentación JavaDoc

Toda la documentación del proyecto fue desarrollada utilizando JavaDoc.

Incluye:

- clases;
- interfaces;
- constructores;
- métodos públicos.

La documentación generada puede encontrarse en:

```text
docs/
```

---

# 🔗 Repositorio GitHub

https://github.com/devmaxpower/SistemaLlanquihueTourEFT

---

# 📅 Fecha

Julio 2026

---

# 📄 Licencia

Proyecto desarrollado con fines académicos para la asignatura **Desarrollo Orientado a Objetos I** de **Duoc UC**.

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Evaluación Final Transversal