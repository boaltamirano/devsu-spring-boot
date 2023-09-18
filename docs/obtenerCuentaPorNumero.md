## Obtener cuenta por número

```sh
    curl -X GET '{{host}}/api/account/{numberAccount}' 
```

### Parameters

| Campo  | Tipo                  | Descripción                                               |
|--------|-----------------------|-----------------------------------------------------------|
| numberAccount | `string` **required** | Número de la cuenta|

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