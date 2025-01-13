# Validaciones con spring

Las validaciones en Spring son un aspecto esencial del desarrollo de aplicaciones robustas y confiables. 
Spring ofrece soporte para validaciones tanto a nivel de datos (en entidades, DTOs, etc.) como a nivel de lógica de negocio. 
A continuación, se explica detalladamente cómo funcionan y cómo implementarlas:

## Validaciones con Anotaciones (Bean Validation)

Spring integra el estándar de Java Bean Validation (JSR 303 y JSR 380) mediante Hibernate Validator, su implementación por defecto.

### Pasos para usar validaciones con anotaciones:
- **Añadir dependencias:** Incluye la dependencia de Hibernate Validator en tu proyecto.
- **Anotar las clases del modelo o DTO:** Usa anotaciones para definir reglas de validación directamente en los atributos.
- **Validar en controladores:** Anota el parámetro del método del controlador con @Valid o @Validated para aplicar las validaciones.
- **Manejo de errores de validación:** Cuando las validaciones fallan, Spring lanza una excepción MethodArgumentNotValidException. 
Puedes manejarla con un @ControllerAdvice.

## Validaciones Personalizadas
A veces, las reglas predeterminadas no son suficientes, y necesitas crear tus propias validaciones.

### Pasos para crear validaciones personalizadas:
- **Crear una anotación personalizada:** Define una anotación con **@Constraint.**
- **Implementar el validador:** Crea una clase que implemente **ConstraintValidator.**
- **Usar la validación personalizada:** Aplica la nueva anotación a los atributos.

## Validaciones a Nivel de Servicio
Las anotaciones cubren validaciones simples, pero la lógica de negocio más compleja debe implementarse en los servicios.

## Habilitación de Validaciones Programáticas
Además de las validaciones automáticas, puedes validar manualmente usando el objeto
**Validator.**

## Pruebas de Validación
Usa pruebas unitarias para asegurar que las validaciones funcionen correctamente.

# Jakarta Bean validation
Las validaciones en Jakarta Bean Validation son una parte esencial para garantizar la integridad de los datos en aplicaciones Java. 
Es una especificación estándar integrada en Jakarta EE (anteriormente Java EE) que se utiliza para definir 
y aplicar reglas de validación en clases de datos, como entidades o DTOs.

A continuación, te explico en detalle cómo funcionan las validaciones en Jakarta Bean Validation, cómo configurarlas, y cómo usarlas:

## Conceptos Básicos de Jakarta Bean Validation

### ¿Qué es Jakarta Bean Validation?
Es una especificación que permite definir reglas de validación mediante anotaciones directamente en las clases del modelo. 
Se integra con frameworks como Spring, Jakarta EE, Hibernate, y más.

### Principales características:
- Basada en anotaciones para una fácil integración.
- Proporciona validaciones estándar como @NotNull, @Size, @Email, etc.
- Admite validaciones personalizadas.
- Compatible con validaciones programáticas (manuales).

## Configuración de Jakarta Bean Validation
Si estás usando Jakarta Bean Validation en un entorno Java SE o Jakarta EE, es necesario incluir las dependencias correspondientes.
Hibernate Validator es una de las implementaciones más populares de Jakarta Bean Validation.

## Uso de Validaciones Estándar
Jakarta Bean Validation proporciona varias anotaciones estándar que puedes usar en tus clases.

## Validación Programática
Jakarta Bean Validation permite validar objetos manualmente usando el objeto
**Validator.**

## Validaciones Personalizadas
Si necesitas reglas específicas que no estén cubiertas por las validaciones estándar, puedes crear tus propias anotaciones.
- Crear una anotación personalizada
- Implementar el validador

## Validaciones en Jakarta EE
En aplicaciones Jakarta EE, las validaciones se aplican automáticamente en entidades JPA o en parámetros de métodos.

### Validar parámetros de métodos
Jakarta EE permite usar validaciones en métodos de EJBs o REST endpoints con
**@Valid.**

## Manejo de Errores de Validación
Para capturar y manejar errores de validación en Jakarta EE, puedes usar un
**ExceptionMapper.**

