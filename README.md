## 📦 Generación del JAR con `./mvnw`

Este proyecto utiliza el **Maven Wrapper** (`mvnw`) para compilar y empaquetar el código en un archivo `.jar`.

---

## ❓ ¿Por qué usar `./mvnw` en lugar de `mvn` directamente?

El **Maven Wrapper** permite ejecutar Maven sin necesidad de tenerlo instalado previamente en el sistema. Esto garantiza que todos los desarrolladores usen la misma versión de Maven definida por el proyecto.

Ventajas de usar `./mvnw`:
- Evita problemas de compatibilidad entre versiones de Maven.
- Simplifica el setup inicial del proyecto.
- Facilita la integración continua (CI) en entornos automatizados.

---

## 🛠️ Requisitos de instalación

No es necesario instalar Maven manualmente. Solo necesitas tener:

- Java 17 o superior instalado ([Instalar Java](https://adoptium.net/temurin/releases/))
- Un sistema UNIX-like (Linux, macOS) o Git Bash/WSL en Windows

Para verificar que tienes Java instalado:

```bash
java -version
```

## 📘 Uso general

```bash
./mvnw [opción]
```

Opciones comunes:

### install

Instala el `.jar` del proyecto en el repositorio local de Maven, utilizando los datos definidos en `pom.xml` (`groupId`, `artifactId`, `version`).

Esto permite utilizar este proyecto como dependencia en otros proyectos Java.

Ejemplo de `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.web.curso.springboot.webapp</groupId>
  <artifactId>springboot-web</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>springboot-web</name>
  <description>Demo project for Spring Boot</description>

  <!-- otras configuraciones -->
</project>
```

### package
Genera el archivo `.jar` en la carpeta `target/`, con el nombre del proyecto y la versión configurada.

```bash
./mvnw package
```

### clean
Elimina la carpeta `target/`, que contiene los archivos generados de la compilación

```bash
./mvnw clean
```

## 🔧 Comando completo recomendado

Para limpiar y generar el `.jar`, se utiliza:

```bash
./mvnw clean package
```
Esto produce un archivo como:

```bash
target/<artifactId>-<version>.jar
```
Ejemplo: `target/springboot-web-0.0.1-SNAPSHOT.jar`

## ▶️ Ejecutar el JAR generado

Una vez generado el archivo, puedes iniciar la aplicación Spring Boot con:

```bash
java -jar target/springboot-web-0.0.1-SNAPSHOT.jar
```
