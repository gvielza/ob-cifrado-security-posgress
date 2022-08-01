#Uso se cifrados para los password
-BCrypt
-Pbkdf2
-SCrypt
-argon2

#JWT (JSON Web token))
jwt.io/introduction
Es un estándar abierto que permite transmitir información entre dos pares

#Funcionamiento
1-Cliente envía una petición a un servidor (/api/login)
2-Servidor valida user y pass, si no son válidos genera un 401 unauthorized
3-si son válidos genera un token JWT utilizando una secret key

4-envía token al cliente
5-Cliente envía peticiones a los endpoints REST del servidor usando el token JWT en las cabeceras
6-Servidor valida el token en cada petición 

Ventajas de JWT
-El token se almacena en el cliente , consumiendo así menos recursos en el Servidor lo que 
permite mejor escalabilidad 

##Estructura del token JWT
3 partes separadas por (.) y codificadas en base 64
1.Header

```
json
{
"alg":"HS512",
"type":"JWT"
}

```

2.Payload (informacion , datos de usuario , no sensibles	)

```
json
{
"name":"Jhon Doe",
"admin":true
}

```

3.Signatura

```

HMACKSHA256(
base64UrlEncode(header)+"."+base64UrlEncode(payload),secret
)

```
El User-Agent envía el token JWT en las cabeceras:

##Configuración de Spring Boot
-Spring Security
-Spring Web 
-Devtools
-JPA
-PostgreSQL
-Dependencia JWT (manualmente)

```
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>

```














