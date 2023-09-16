## Obtener clientes por identificacion

```sh
    curl -X GET 'http://13.57.234.164:8080/api/client/{identificacion}' 
```

### Query Parameters

| Field  | Type                  | Description                                               |
|--------|-----------------------|-----------------------------------------------------------|
| identificacion | `string` **required** | ID del cliente |

### Response

```json
{
    "nombres": "Jose Lema",
    "dirección": "Otavalo sn y principal",
    "teléfono": "098254785",
    "contraseña": "1234",
    "estado": true
}
```

<br>

[`Back`](../README.md)