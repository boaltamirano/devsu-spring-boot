## Crear Cliente

```sh
    curl -X POST 'http://13.57.234.164:8080/api/client' \
         -H 'Content-Type: application/json' \
         --data-raw '{{request_payload}}'
```

### Parameters

| Campo | Tipo                  | Descripcion                                       |
|-------|-----------------------|---------------------------------------------------|
| identification  | `string` **required** | Idientificacion del usuario          |
| name | `string` **required** | Nombre del usaurio |
| address  | `string` **optional** | Direccion del usaurio  |
| age  | `string` **required** | Edad del usaurio  |
| phone  | `string` **optional** | Telefono del usuario  |
| password  | `string` **required** | Contra del usuario  |
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