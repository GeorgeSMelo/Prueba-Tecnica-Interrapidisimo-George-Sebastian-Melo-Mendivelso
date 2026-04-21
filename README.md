# Prueba Técnica Interrapidisimo 

A continuación voy a explicar cómo desarrollé cada uno de los puntos solicitados en la Prueba Técnica para desarrollador Android Senior y cada una de las librerías o componentes que se usaron para cumplir con el reto.

Author: George Sebastian Melo Mendivelso.

# Tecnologias Utilizadas 

- Kotlin.
- Jetpack Compose.
- hilt.
- Room. 
- Retrofit.
- ViewModel + LiveData.
- Pruebas unitarias.
- Navigation Compose.

# Instrucciones para ejecutar la aplicación

1. Clonar el repositorio: git clone https://github.com/GeorgeSMelo/Prueba-Tecnica-Interrapidisimo-George-Sebastian-Melo-Mendivelso
2. Abrir el proyecto en Android Studio.
3. Ejecutar la aplicación desde Android Studio.

# Explicación de las decisiones técnicas

1. Pantalla principal - LoginScreen
   - Se utilizó una API para obtener el control de versiones. 
   - Se utilizó la API para la autenticación de usuario. 
   - Se guarda la información del usuario en la base de datos ROOM. 
   - Toda la pantalla principal LoginScreen se desarrolló con Jetpack Compose. 
   - Se agregaron 2 botones:
     * Validar versión: Valida la versión local con la versión remota del endpoint. 
     * Login: Redirige al HomeScreen. 
   - En caso de que haya ocurrido un error o se valide una versión, este mostrará un mensaje. 
   - Se creó un Snackbar que alerta al usuario si la versión remota es mayor, menor o igual a la versión local o cuando una de las APIs del login falla.
  
2. Pantalla Home
   - Esta pantalla también está construida con Jetpack Compose y obtiene los datos del usuario desde una base de datos local implementada con Room.
   - Muestra la información de usuario en los campos de texto de Usuario, Identificación y Nombre. 
   - Se utilizó una API pública para consultar los esquemas de las tablas. 
   - Guarda la información de los esquemas en una base de datos local. 
   - Se crearon 2 botones:
     * Tablas: Redirige a TablasScreen. 
     * Localidades: Redirige a LocalidadesScreen.

3. Pantalla Tablas
   - Esta pantalla también está construida con Jetpack Compose y obtiene los datos de los esquemas de las tablas desde una base de datos local implementada con Room. 
   - Muestra la información de las tablas en un LazyColumn.

4. Pantalla Localidades
   - Se utilizó una API para las localidades y muestra la información de las localidades en un LazyColumn. 
   - Esta pantalla también está construida con Jetpack Compose.
   
5. Test
- Se realizaron pruebas unitarias solo al LoginViewModel.

6. Se solicitó el mensaje de error cuando la API de autenticación falla; esto se cumple en la LoginRemoteRepository, que es capaz de extraer el mensaje de error y enviarlo a la View.

7. Se hizo uso de try-catch en las clases LoginRemoteRepository, HomeRemoteRepository y LocalidadesRemoteRepository para controlar si una consulta API llegara a fallar.

8. Se solicitó crear una base de datos con SQLite y, para cumplir esto, se hizo uso de la librería ROOM.

9. Integración de librerías externas.
   - ROOM: Se integró la librería ROOM para cumplir con el criterio de integrar una base de datos con SQLite y almacenar los registros de la información del usuario y los esquemas de las tablas retornados por los endpoints.
   - Navigation Compose: Se implementó para poder navegar entre pantallas de tipo Compose.
   - ViewModel: Implementada para crear la clase de tipo ViewModel y que esta controle la lógica de la pantalla y persista sus datos.
   - Retrofit: Usada para crear la conexión entre las consultas API y la aplicación.
   - Converter-gson: Librería utilizada para transformar los datos retornados de la API en JSON que pueda manejar la aplicación.
   - Hilt: Utilizada para implementar la inyección de dependencias en el proyecto.
   - LiveData: Librería utilizada para crear variables que pueden notificarle a la pantalla cuando debe mostrar un valor.