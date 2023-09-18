## Obtener clientes por identificación

```sh
    curl -X GET '{{host}}/api/client/{identificacion}' 
```

### Parameters

| Campo  | Tipo                  | Descripción                                               |
|--------|-----------------------|-----------------------------------------------------------|
| identification | `string` **required** | ID del cliente |

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