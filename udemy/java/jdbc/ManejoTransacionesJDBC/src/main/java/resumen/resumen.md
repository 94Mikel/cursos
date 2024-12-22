#Resumen JDBC transacciones

- Una transaccion es un conjunto de instrucciones SQL agrupadas 
en bloques de ejecucion.
- Si alguna de las instrucciones falla podemos dar marcha atras haciendo rollbalk a todo 
el bloque ejecutado(sin alterar el estado de la base de datos).
- Si todo es correcto, guardamos los cambios haciendo commit de todo el bloque ejecutado.
- Uso de métodos en una transacción:
    - autocommit.(Valores true o false)(por defecto es true)(recomendable poner false)
    - commit: Guarda los cambio en la bd del bloque de ejecución.
    - rollback: Revertir los cambios realizados por el bloque de ejecución.
- Si cerramos la conexión de JDBC se hace un commit, 
**incluso si se deshabilita la propiedad autocommit** 





