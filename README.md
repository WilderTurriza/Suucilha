# Requisitos funcionales
## Sistema
- RF-001. Permitir acceder como administrador
  - El sistema debe permitir el ingreso del administrador, ofreciendo funcionalidades para la gestión del establecimiento en general (Descritas con más detalles en las funcionalidades RF-013, RF-014 y RF-015), así como para la gestión y administración de reservaciones de habitaciones.
- RF-002. Crear cuenta
  - El sistema debe proporcionar a los usuarios la opción de crear una cuenta en el sitio web para poder acceder a las funcionalidades. Al crear una cuenta, los usuarios deberán proporcionar su nombre completo, fecha de nacimiento, correo electrónico y contraseña.
- RF-003. Cerrar sesión
   - El sistema debe permitir a los usuarios cerrar sesión en el sitio web para garantizar la privacidad y seguridad de su información personal.
- RF-004. Actualizar cuenta
   - El sistema debe permitir la actualización de los datos de la cuenta de usuario.
- RF-005. Recuperación de contraseña
   - El sistema debe facilitar a los usuarios un proceso sencillo para recuperar su contraseña en caso de olvido. Esta funcionalidad se realizará mediante el envío de la contraseña al correo electrónico registrado por el usuario.
- RF-006. Visualizar hotel
   - El sistema proporcionará una página de inicio que mostrará una presentación del hotel. Esta presentación incluirá imágenes del hotel, detalles sobre los servicios que ofrece, información de contacto, enlaces a las redes sociales del hotel y un mapa interactivo que muestra la ubicación del hotel utilizando Google Maps.
- RF-007. Visualizar habitaciones
   - El usuario podrá observar cada una de las habitaciones existentes, así como sus características, descripción y disponibilidad.
- RF-008. Filtrar habitaciones
  - El sistema debe permitir a los usuarios aplicar filtros de búsqueda para encontrar información sobre las habitaciones disponibles de acuerdo con sus intereses y necesidades. Los filtros deben incluir las siguientes opciones: cantidad de personas (1, 2, 4), costo (de $1000 a $2000 MXN), fecha disponible. Los resultados de la búsqueda deben ser precisos y relevantes para el usuario.
- RF-009. Reservar habitaciones
  - El usuario podrá realizar la reservación de alguna habitación, siempre y cuando esté disponible en la fecha que seleccione. Para esto, deberá indicar el número de días que reservarán la habitación.
- RF-010. Pagar reservación
  - Para poder realizar la reservación (funcionalidad RF-008), el sistema deberá validar el pago del usuario. Este proceso se llevará a cabo mediante la integración de PayPal como método de pago.
- RF-011. Visualizar historial de reservaciones
  - El usuario podrá visualizar todas las reservaciones que ha hecho anteriormente con su cuenta. 
- RF-012. Cancelar reservación
  - El usuario podrá cancelar la reservación 48 horas antes de su fecha de llegada prevista.
## Administrador
- RF-013. Visualizar reservaciones
  - El administrador podrá visualizar todas las reservaciones hechas por fechas. 
- RF-014. Gestionar habitaciones
  - El administrador podrá modificar y crear habitaciones. Para llevar a cabo esta tarea, el sistema solicitará los siguientes datos sobre la habitación: nombre, número máximo de personas permitidas, costo y descripción.
- RF-015. Subir imágenes
  - El administrador podrá subir de 1 a 4 imágenes en formato .png por habitación para una mejor descripción de su interior.

# Priorización de requisitos
## Método MoSCow
### Fase 1 / `Versión 1.0`
#### Must have
- RF-001. Permitir acceder como administrador
- RF-002. Crear cuenta
- RF-003. Cerrar sesión
- RF-005. Recuperación de contraseña
- RF-006. Visualizar hotel
- RF-007. Visualizar habitaciones
- RF-008. Filtrar habitaciones
- RF-009. Reservar habitaciones
- RF-013. Visualizar reservaciones
- RF-014. Gestionar habitaciones
- RF-015. Subir imágenes
### Fase 2 / `Versión 1.1`
#### Should have
- RF-004. Actualizar cuenta
- RF-010. Pagar reservación
- RF-011. Visualizar historial de reservaciones
### Fase 3 / `Versión 2.0`
#### Could have
- RF-012. Cancelar reservación
### Fase 4 / `Versión 3.0` y posteriores
#### Won't have this time
- Funcionalidades adicionales en la interfaz de usuario

