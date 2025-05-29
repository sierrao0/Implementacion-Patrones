# Implementación de Patrones de Diseño - Parcial No. 2

Este repositorio contiene las soluciones desarrolladas para el Parcial No. 2 de la asignatura, enfocadas en la implementación práctica de tres patrones de diseño fundamentales:

Adapter: Unifica el acceso a datos de empleados desde fuentes heterogéneas (base de datos PostgreSQL y un servicio web REST/SOAP).

Flyweight: Optimiza el manejo de listas de reproducción, almacenando en memoria solo las más utilizadas y persistendo las menos frecuentes en PostgreSQL.

Proxy: Ofrece dos variantes de autenticación (auditable y no auditable) mediante un Factory configurable, con conexión a una base de datos real.

Estructura del Repositorio
/adapter: Implementación del patrón Adapter con clases para consultas locales y remotas.

/flyweight: Modificación del ejercicio de listas de reproducción con caché en memoria y PostgreSQL.

/proxy: Factory de proxies de autenticación y esquema de base de datos.
