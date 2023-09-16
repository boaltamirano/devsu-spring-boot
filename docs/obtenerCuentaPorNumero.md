## Obtener cuenta por numero

```sh
    curl -X GET 'http://13.57.234.164:8080/api/account/{numberAccount}' 
```

### Query Parameters

| Field  | Type                  | Description                                               |
|--------|-----------------------|-----------------------------------------------------------|
| numberAccount | `string` **required** | Numero de la cuenta|

### Response

```json
{
    "numeroCuenta": "585545",
    "tipo": "Corriente",
    "saldoInical": 1000.0,
    "estado": true,
    "cliente": "Jose Lema"
}
```

<br>

[`Back`](../README.md)