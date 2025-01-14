# Manejo de varios idiomas(i18n) con Spring y Thymeleaf

Los pasos para agregar internacionalización al proyecto en general son correctas, pero hay
que actualizar la sintaxis en la clase WebConfig.java si manda un warning o un mensaje de
depreciado:

En lugar de la línea de código:
slr.setDefaultLocale(new Locale("es"));

Se debe reemplazar con la nueva línea de código:
slr.setDefaultLocale(Locale.forLanguageTag("es"));

Razón del cambio: La clase Locale en Java ofrece varios métodos para crear instancias de
locales, y Locale.forLanguageTag("es") es uno de esos métodos. Este método acepta un
language tag que sigue el estándar IETF BCP 47, el cual es más flexible y descriptivo para
identificar idiomas y regiones. 
Usar forLanguageTag es generalmente preferible en aplicaciones modernas por las siguientes razones:

## Ventajas de Locale.forLanguageTag
- **Compatibilidad con Estándares Modernos:** 

forLanguageTag utiliza el estándar BCP 47 para etiquetas de idioma, que es más moderno y ampliamente reconocido. 
Esto permite una mejor compatibilidad con otros sistemas y herramientas que también siguen este estándar.

- **Claridad y Precisión:**

Las etiquetas de idioma pueden incluir más información que
solo el idioma, como región, script o variantes, lo cual es útil para aplicaciones que
necesitan manejar localizaciones específicas. Por ejemplo,
Locale.forLanguageTag("en-US") es claramente Estados Unidos inglés, mientras
que Locale.forLanguageTag("en-GB") es Reino Unido inglés.

- **Evolución de la API de Java:** 

A medida que la API de Java ha evolucionado, se
han introducido métodos más descriptivos y compatibles con estándares
internacionales, como forLanguageTag. Esto puede ser parte de una tendencia hacia
la deprecación de métodos más antiguos y menos descriptivos como el constructor new Locale(String).

## ¿Por Qué new Locale(String) Podría No Ser Ideal?

Aunque new Locale(String) no está oficialmente deprecado, puede que no maneje todas las
posibilidades de especificación de idioma y región con la misma claridad y precisión que
forLanguageTag. Además, en algunos entornos o versiones de bibliotecas, podría haber
advertencias de uso preferido de métodos más modernos, aunque esto depende del entorno
y las configuraciones del IDE.

