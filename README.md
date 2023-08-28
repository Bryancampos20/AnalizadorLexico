## ¡Hola a todos! 👋

Mi nombre es Bryan Campos Castro y soy estudiante del curso Compiladores e Interpretes.
## Información Personal

- Nombre: Bryan Campos Castro
- Carnet: 2019341558

## Analizador Sintáctico

Este programa en Java implementa un analizador léxico para procesar líneas de código y reconocer diferentes tokens en ellas. El programa recibe un archivo de entrada y genera un archivo de salida que contiene información sobre los tokens encontrados en cada línea, junto con su tipo correspondiente.

## Instrucciones

1. Asegúrate de tener Java instalado en tu sistema.
2. Descarga el archivo faseLexica.java a tu directorio local.
3. Abre una terminal y navega al directorio donde se encuentra el archivo faseLexica.java.
4. Ejecuta el siguiente comando para compilar y ejecutar el programa: 

```bash
javac faseLexica.java
java faseLexica [ARCHIVO_DE_ENTRADA] [ARCHIVO_DE_SALIDA]
```

Reemplaza `[ARCHIVO_DE_ENTRADA]` con la ruta al archivo que deseas analizar y `[ARCHIVO_DE_SALIDA]` con la ruta donde deseas guardar los resultados del análisis.

## Resultados

El programa generará un archivo de salida que contiene información sobre los tokens encontrados en cada línea del archivo de entrada. Los resultados estarán en el formato:

```bash
Token: [TOKEN], Tipo: [TIPO]
```

Donde [TOKEN] es el token identificado y [TIPO] es el tipo correspondiente del token.

Si se encuentra algún token no reconocido o algún error léxico en una línea, se mostrará un mensaje de error indicando la línea en la que se encuentra y el lexema no reconocido.

## Tabla de simbolos

El programa también mantiene una tabla de símbolos para almacenar identificadores encontrados en el código. Los identificadores se agregan a la tabla de símbolos junto con su valor (inicialmente `null`). Si se encuentra el token de asignación (`=`), el programa actualiza el valor del último identificador agregado en la tabla.

¡Disfruta utilizando el programa para analizar tus líneas de código y entender la fase léxica del proceso de compilación! Si tienes preguntas o sugerencias, no dudes en ponerte en contacto conmigo.

¡Happy coding! 🚀