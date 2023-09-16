## Generar reporte de movimientos de un cliente

```sh
curl -X GET 'http://13.57.234.164:8080/api/reports/client/{identification}?startDate=2023-09-01&endDate=2023-09-16' 
```

### Response

```json
[
    {
        "fecha": "2023-09-16",
        "saldoDisponible": 700.0,
        "saldoInicial": 100.0,
        "cliente": "Marianela Montalvo",
        "estado": true,
        "tipo": "Corriente",
        "numeroCuenta": "225487",
        "movimiento": 600.0
    },
    {
        "fecha": "2023-09-16",
        "saldoDisponible": 0.0,
        "saldoInicial": 540.0,
        "cliente": "Marianela Montalvo",
        "estado": true,
        "tipo": "Ahorro",
        "numeroCuenta": "496825",
        "movimiento": 540.0
    }
]
```

<br>

[`Back`](../README.md)