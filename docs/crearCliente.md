## Crear Cliente

```sh
    curl -X POST '{{host}}/api/client' \
         -H 'Content-Type: application/json' \
         --data-raw '{{request_payload}}'
```

### Parameters

| Campo | Tipo                  | Descripción                                       |
|-------|-----------------------|---------------------------------------------------|
| identification  | `string` **required** | Identificación del usuario          |
| name | `string` **required** | Nombre del usuario |
| address  | `string` **optional** | Dirección del usuario  |
| age  | `string` **required** | Edad del usuario  |
| phone  | `string` **optional** | Teléfono del usuario  |
| password  | `string` **required** | Contraseña del usuario  |
| status  | `string` **optional** | Estado del usuario  |


### Request Payload

```json
{
    "identification": "1000000000",
    "name": "Juan Osorio",
    "address": "Otavalo sn y principal",
    "age": 40,
    "phone": "098874587",
    "password": "1234",
    "status": true
}

```

### Response
```json
{
    "nombres": "Juan Osorio",
    "dirección": "Otavalo sn y principal",
    "teléfono": "098874587",
    "contraseña": "1234",
    "estado": true
}
```

<br>

[`Back`](../README.md)