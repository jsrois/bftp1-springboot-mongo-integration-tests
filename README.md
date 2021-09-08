# SpringBoot + MongoDB 

Ejemplo basado en https://www.bezkoder.com/spring-boot-mongodb-crud.

Test de integración con Embedded MongoDB basado en https://jcompetence.com/2021/03/08/integration-testing-with-springboot-embedded-mongo-mockmvc/

### Lanzar el servidor localmente usando docker para MongoDB

#### Crear la base de datos

```bash
docker run --rm -d -p 27017:27017 --name=mongo-db mongo:4.2
```

_No es necesaria configuración: SpringBoot utiliza el puerto 27017 para conectar con MongoDB por defecto_ 