## Crear cuenta

```sh
    curl -X POST '{{host}}/api/account' \
         -H 'Content-Type: application/json' \
         --data-raw '{{request_payload}}'
```

### Parameters

| Campo | Tipo                  | Descripción                                       |
|-------|-----------------------|---------------------------------------------------|
| numberAccount  | `string` **required** | Número de cuenta          |
| typeAccount | `string` **required** | Tipo de cuenta |
| initialBalance  | `string` **optional** | Saldo inicial de la cuenta  |
| status  | `string` **required** | Estado de la cuenta  |
| client  | `string` **optional** | ID del cliente al que se le va a crear la cuenta  |


### Request Payload

```json
{
    "numberAccount": "478758",
    "typeAccount": "Ahorro",
    "initialBalance": 2000,
    "status": true,
    "client": "1000000000"
}

```

### Response
```json
{
    "numeroCuenta": "478758",
    "tipo": "Ahorro",
    "saldoInical": 2000.0,
    "estado": true,
    "cliente": "Jose Lema"
}
```

<br>

[`Back`](../README.md)