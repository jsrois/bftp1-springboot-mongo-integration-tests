# SpringBoot + MongoDB 

Ejemplo basado en https://www.bezkoder.com/spring-boot-mongodb-crud.

Test de integración con Embedded MongoDB basado en https://jcompetence.com/2021/03/08/integration-testing-with-springboot-embedded-mongo-mockmvc/

### Testing

Usar el profile 'default' (ningún profile activado).

### Lanzar el servidor localmente usando docker para MongoDB

#### Crear la base de datos

```bash
docker run --rm -d -p 27017:27017 --name=mongo-db mongo:4.2
```

#### Spring profiles

Utilizar el profile `local` para activar la configuración en `application-local.properties`
