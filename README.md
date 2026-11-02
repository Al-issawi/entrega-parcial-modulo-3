# Entrega parcial - Modulo 3

Este repositorio incluye la biblioteca Java, su Javadoc, una aplicacion web de catalogo y tres registros exportados de Git Bash.

## Biblioteca Java

Requiere JDK 17+ y Maven. Desde la carpeta biblioteca-java:

    mvn package javadoc:javadoc

El Javadoc incluido esta en biblioteca-java/docs/apidocs/index.html.

## Aplicacion web

Abre app/index.html en un navegador. Permite anadir libros y alternar entre disponible y prestado. El navegador conserva los datos en almacenamiento local.

## Repositorios y publicacion
La app aun no esta publicada en Internet; enlace-publicacion.txt indica la URL.

Esta carpeta es el repositorio principal. El repositorio Git companero esta en ../otro-repo-biblioteca. El historial de Git Bash registra su ubicacion local.

## Laboratorios

Los laboratorios de argumentos de terminal y JUnit se excluyen de esta entrega segun la instruccion "LABS - no presentar".

## GitHub Pages

La carpeta docs/index.html contiene una copia lista para publicar de app/index.html. En Settings > Pages, selecciona Deploy from a branch, branch master y carpeta /docs. Cuando el despliegue termine, guarda la URL publicada en enlace-publicacion.txt.
