# Test API Devsu

## Dependencias

- MySQL, 
- Spring boot,
- Maven
- Java 17
- Mockito
- JUnit

## Verificar conexión a la base de datos 
> application.properties

## Generar .jar

```
./mvnw clean package
```

## Levantar contenedores

```
docker compose up --build -d
```


## Detener contenedores
```
docker compose down
```

## API Documentación

### Cliente

- #### [Crear cliente](docs/crearCliente.md)

- #### [Obtener todos los clientes](docs/obtenerClientes.md)

- #### [Obtener clientes por id](docs/obtenerClientesPorId.md)


### Cuentas

- #### [Crear cuenta](docs/crearCuenta.md)

- #### [Obtener cuenta por número](docs/obtenerCuentaPorNumero.md)


### Movimientos

- #### [Crear movimiento](docs/crearMovimiento.md)


### Reportes

- #### [Generar reporte de usuario](docs/generarReportePorFechas.md)