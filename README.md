# Proyecto carrito de compras #

Se debe ejecutar, normal sin docker, al compilar el proyecto se debe crear el scrit en la bd Mysql, para insertar un nuevo usuario.
INSERT INTO `carritocompras`.`usuario` (`id`, `usuario`) VALUES ('1', 'admin');

![alt text](tablasBD.PNG "Prueba Exitosa")

Se debe generar el enpoint para conocer el token de la siguiente manera.
![alt text](autenticación.PNG "Prueba Exitosa Cliente")

Luego llama al siguiente Enpoint enviando en el nuevo token generado, al igual que los demas enpoint.
![alt text](tokenServicio.PNG "Prueba Exitosa Cliente")

![alt text](ventaRest.PNG "Prueba Exitosa Cliente")

# Ejecucion de pruebas unitarias #
![alt text](EjecucionPruebasUnitarias.PNG "Prueba Exitosa")

Prueba Crear cliente exitosa

![alt text](exitosaPruebaCliente.PNG "Prueba Exitosa Cliente")
![alt text](pruebaUnitariaClienteExitosa.PNG "Prueba Exitosa Cliente")

Caso de prueba error de producto

![alt text](pruebasUnitariasERRORproducto.PNG "Prueba Exitosa producto")

Caso de prueba error para venta

![alt text](PruebaUnitariaErrorVenta.PNG "Prueba Exitosa venta")


![alt text](tokenServicio.PNG "siiiiii")
