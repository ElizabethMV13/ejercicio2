# ejercicio2

<h1># INDICE</h1>

<h2>1. Elementos extras</h2>
<h2>2. Requerimientos generales</h2>
<h2>3. Ejercicio opcional</h2>

<h1>1. Elementos extras</h1>
--> Se hizo uso de fragmentos para la creación de un menú inferior con button

![menu](https://github.com/ElizabethMV13/ejercicio2/assets/93019559/1b47e5c9-23f2-4265-9c8b-8ba7b3b90ae6)

--> Inserción y manejo de audio en MainActivity 

Esto permite que el audio pueda estar presente en los 3 fragmentos correspondiente al menú

--> Manejo del audio en el primer fragment por medio de un switch toggle, eso también permite modificar el texto e icono según ese pausado o en reproducción 

![WhatsApp Image 2023-06-10 at 11 17 16 AM (2)](https://github.com/ElizabethMV13/ejercicio2/assets/93019559/9ab03d4c-dcfd-40d1-973f-3a44b3b4632c)
![sinaudio](https://github.com/ElizabethMV13/ejercicio2/assets/93019559/7f971e3a-5927-43ab-a804-16c255e2567b)


--> Se agrego uso de GIFs para hacer llamativo el splash 

Esto se esto se usó en el slash (esto con el fin de no ver una imagen en plano) 
![WhatsApp Image 2023-06-10 at 11 21 44 AM (1)](https://github.com/ElizabethMV13/ejercicio2/assets/93019559/17174c80-c204-444d-9158-66dacf122c31)


--> Creación de APK (modificación del nombre del icono de la aplicación al descargarla).

![WhatsApp Image 2023-06-10 at 11 53 04 AM](https://github.com/ElizabethMV13/ejercicio2/assets/93019559/2efc208a-41df-424a-b939-c74228368d8f)

https://drive.google.com/drive/folders/1-LRy0awYDim-KKsxln0-_96GMTSyvizo?usp=sharing

--> Uso de un switch toggle para activar y desactiva el modo oscuro

![modoOsc](https://github.com/ElizabethMV13/ejercicio2/assets/93019559/43ec3e99-caeb-4361-ba8f-0c066246ba75)

--> Modificación de estilos según la casa a la que pertenece y en caso de no tiene una asignada, se colocan colores por defecto (tanto en Recyclerview, como en la card individual)

--> Se realizo la inserción de datos e imagen cuando el request no contenga ese valor ""



<h1>2. Requerimientos generales</h1>

Realizar una aplicación con Android Studio que consuma el API REST de Harry Potter ubicado en:

https://hp-api.onrender.com/

En la primera pantalla, mostrar 2 opciones para visualizar lo siguiente:

- Estudiantes de Hogwarts (conexión: https://hp-api.onrender.com/api/characters/students)

- Personal de Hogwarts (conexión: https://hp-api.onrender.com/api/characters/staff)

Al seleccionar cada opción se mostrará un listado utilizando un RecyclerView con los datos obtenidos
mediante el API REST. En el diseño de cada elemento deberán mostrarse, como mínimo, los siguientes 
tres datos:


<h3>Ejemplo de datos a ingresar:</h3>

```
- Imagen

- Nombre del personaje

- Actor que lo interpreta
 ```

Una vez presentado al usuario cada listado (estudiantes o personal de Hogwarts), implementar un mecanismo 
para poder mostrar información de por lo menos seis características del personaje deseado o seleccionado 
(ustedes tienen la libertad de elegir los que deseen):


 ```
Nombre
 
Imagen
 
Actor

Especie

Género

Casa

Varita

Patronus

Ascendencia

 ```


<h3>3. Consideraciones adicionales:</h3>

Se calificará que haya manejo de errores generales.
Para este ejercicio el nivel mínimo de API será 23.
Pueden definir todos los elementos gráficos o multimedia que deseen para hacer la interfaz más atractiva.
No deben existir elementos de texto en hard-coding.

<h1>2. Ejercicio opcional</h1>

Implementar la siguiente funcionalidad adicional a su proyecto del ejercicio 2:

- Ingreso con autenticación mediante la utilización de un correo electrónico y contraseña.

- La autenticación se llevará a cabo mediante la herramienta FirebaseAuth de Firebase.

- No se permitirá el acceso al menú para visualizar los estudiantes o el personal de Hogwarts a menos que el usuario cree su cuenta y/o se autentique posteriormente con ella.

<h3>Consideraciones adicionales:</h3>

-Se calificará que haya manejo de errores generales.

-Pueden definir todos los elementos gráficos que deseen para hacer la interfaz para el sign in/sign up más 
atractiva.

-No deben existir elementos de texto en hard-coding.

-Evitar subir el archivo de configuración JSON de Firebase a su repositorio en Github (si entregan el proyecto de 
esta forma).

-Solamente se tomarán en cuenta proyectos opcionales que cumplan con la funcionalidad mínima solicitada. En caso de 
entregarlo sin cumplir estos requerimientos, simplemente se tomará como no entregado y se calificará normalmente.


