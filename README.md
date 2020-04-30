# Ejemplo básico de un *servlet*
El siguiente ejemplo es para mostrar un servlet básico.

## Dependencias

- Java
- Jetty Server
- Gradle
  - java -> Plug-in de java
  - war -> Para empaquetar la aplicación en un WAR (Web Application Resource or Web application Archive)
  - gretty -> Plug-in de Gradle para levantar servidores

## Configuración de Gradle

```groovy
plugins {
    id 'java'
    id 'war'
    id "org.gretty" version "3.0.2"
}

group 'ac.cr.una'
version '1.0-SNAPSHOT'

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    providedCompile group: 'javax.servlet', name: 'javax.servlet-api', version: '4.0.1'
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

gretty {
    httpPort = 8080
    contextPath = '/'
}
```

## Probar el ejemplo

- Para levantar el servidor con la aplicación desde consola utilizando Gradle: `gradlew apprun`
- La aplicación va a ejecutarse por default en esta dirección: `http://localhost:8080/`

### Resultados

- http://localhost:8080/hello

![](hello.png)

- http://localhost:8080/students

![students](students.png)

