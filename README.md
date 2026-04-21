#Documentacion prueba tecnica InterRapidisimo
A continuación voy a explicar como desarrolle cada 1 de los puntos solicitados en la prueba tecnica para desarrollador android senior y cada 1 de las librerias o 
componentes que se usaron para cumplir con el reto
## Librerias Utilizadas
Las librerias que utilice en el proyecto y su motivo fueron las siguientes:
-ROOM: Se integro la libreria ROOM para cumplir con el criterio de integrar una base de datos con SQLite y almacenar los registros de la información del usuario y 
los esquemas de las tablas retornados por los endpoints
-Navigation Compose: Se implemento para poder navegar entre pantallas de tipo compose
-ViewModel: Implementada para crear la clase de tipo ViewModel y que esta controle la logica de la pantalla y persista sus datos.
-Retrofit: Usada para crear la conexión entre las consultas API y la aplicación.
-converter-json: libreria utilizada para transformar los datos retornados de la API en JSON que pueda manejar la aplicación.
-Hilt: Utilizada para implementar la inyeccion de dependencias en el proyecto.
-LiveData: Libreria utilizada para crear variables que pueden notificarle a la pantalla cuando debe mostrar un valor.
## Explicación de puntos solucionados
### Primer punto
#### 1. Control de versiones: Para cumplir con este requerimiento se creo una pantalla principal llamada LoginScreen la cual cuenta con 2 botones uno de los cuales tiene 
como titulo validar version y su funcion es llamar al ViewModel del login para  consultar la version remota de la app y consultarla contra la version local del proyecto
y una vez validado se muestra 3 mensajes de alerta si las version local es menor a la remota, mayor o igual. Se implementa el endpoint del login en la interfaz InterrapisimoApi y en esta misma se colocan los Headers solicitados por el consumo api y el body del usuario se 
consume en LoginViewModel.
#### 2. Se implemento en el archivo del HomeScreen la comunicación y lógica capaz de ir a consultar a la base de datos de ROOM
