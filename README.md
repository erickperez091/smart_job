### Pasos Para Ejecución

__Script de base de datos se encuentra en src/main/resources con el nombre de data.sql__ </br>
__Expresion regular para email y contraseña se encuentran en el archivo application.properties bajo el folder src/main/resources__ </br>


1. Estar en la carpeta inicial del proyecto (/smart_job) 
2. Ejecutar el comando mvn clean package o mvn clean install
3. Una vez finalizado el paso anterior moverse a la carpeta /target
4. Cuando nos encontremos dentro de la carpeta /target ejecutar el siguiente comando `java -jar smart_job-0.0.1-SNAPSHOT.jar`
5. Una vez iniciada la aplicación mediante ejecutar el siguiente comando `
   curl --location 'localhost:8080/user/v1/' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "name": "Juan Rodriguez",
   "email": "juan@rodriguez.org",
   "password": "hunter2",
   "phones": [
   {
   "number": "1234567",
   "cityCode": "1",
   "countryCode": "57"
   }
   ]
   }'
`