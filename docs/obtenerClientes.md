## Obtener todos los clientes

```sh
curl -X GET 'http://13.57.234.164:8080/api/client' 
```

### Response

```json
[
    {
        "identification": "1000000000",
        "name": "Jose Lema",
        "genre": null,
        "age": 20,
        "address": "Otavalo sn y principal",
        "phone": "098254785",
        "password": "1234",
        "status": true
    },
    {
        "identification": "1000000001",
        "name": "Marianela Montalvo",
        "genre": null,
        "age": 22,
        "address": "Amazonas y  NNUU",
        "phone": "097548965",
        "password": "5678",
        "status": true
    },
    {
        "identification": "1000000002",
        "name": "Juan Osorio",
        "genre": null,
        "age": 28,
        "address": "13 junio y Equinoccial",
        "phone": "098874587",
        "password": "1245",
        "status": true
    }
]
```

<br>

[`Back`](../README.md)