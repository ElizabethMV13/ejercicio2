# ejercicio2

<h1># INDICE</h1>


<h2>1. Requerimientos generales</h2>
<h2>2. Ejercicio opcional</h2>
<h2>3. Elementos extras</h2>



<h1>1. Requerimientos generales</h1>

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


<h3>Consideraciones adicionales:</h3>

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


<h1>3. Elementos extras</h1>


--> Manejo de recyclerView para el uso del target

--> Uso de Clases para el llenado de las recyclerView

Por medio de una clase recupera los datos por medio de un listOf de les da formato y se visualiza en la opción de lisa de carreras

--> Inserción y manejo de audio en MainActivity

El audio se muestra solo en esa ventana, se detiene al cerrar la app o presionar algunos de los botones del menú

--> Se agrego uso de GIFs

Esto se esto se usó en el slash (esto con el fin de no ver una imagen en plano) y dentro de la view que se da en "Quienes somos"

--> Creación de APK

--> Se modifico el icono de la aplicación al descargarla

No pude lograr ver mi app en mis dispositivos para debuggear, por lo que decidí realizar el APK para poder instalarlo y ver que todo funcionara bien

--> Inserción de imágenes por medio de una URL con GLIDE

La imagen que se inserta en la respuesta del formulario es obtenida por internet, solo se necesita la URL 

--> envió y recepción de datos entre vistas por Parcelable implementación generador
