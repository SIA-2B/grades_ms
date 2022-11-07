# GradesMs
Microservicio de calificaciones

## Instrucciones
1. Descagar la imagen oficial de MySQL - `docker pull mysql`
2. Dentro de la carpeta raiz del proyecto crear la imagen del microservicio - `docker build -t grades_ms_image .`
3. Correr la imagen de MySQL en un contenedor - `docker run --name grades_db_container -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=grades_db -e MYSQL_USER=sa -e MYSQL_PASSWORD=1234 -d mysql`
4. Comando para verificar los logs del contenedor - `docker logs -f grades_db_container`
5. Correr el contenedor del microservicio - `docker run -p 8082:8082 --name grades_ms_container -d grades_ms_image`
6. Comando para verificar los logs del contenedor - `docker logs -f grades_ms_container`
7. Realizar pruebas en postman para verificar la conexión
