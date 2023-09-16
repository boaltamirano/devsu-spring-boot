## Crear movimiento

```sh
    curl -X POST 'http://13.57.234.164:8080/api/movements' \
         -H 'Content-Type: application/json' \
         --data-raw '{{request_payload}}'
```

### Parameters

| Campo | Tipo                  | Descripcion                                       |
|-------|-----------------------|---------------------------------------------------|
| typeMove  | `string` **required** | Tipo de movimiento que se va a realizar          |
| valueMove | `string` **required** | Valor del movimiento |
| account  | `string` **required** | Numero de cuenta  |


### Request Payload

```json
{
    "typeMove": "Retiro",
    "valueMove": 575,
    "account": "478758"
}

```

### Response
```json
{
    "numeroCuenta": "478758",
    "tipo": "Ahorro",
    "saldoInical": 2000.0,
    "estado": true,
    "movimiento": "Retiro de 575.0"
}
```

<br>

[`Back`](../README.md)