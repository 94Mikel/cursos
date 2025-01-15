# Ejercicio:  Seguridad con spring framework y hibernate

Spring Framework y Hibernate JPA son herramientas ampliamente utilizadas en el desarrollo de aplicaciones empresariales en Java. 
Ambos tienen capacidades que contribuyen a la seguridad de las aplicaciones, 
y cuando se combinan, ofrecen una sólida base para proteger los datos y las operaciones de la aplicación. 
Aquí te explico en detalle cómo gestionar la seguridad en estas tecnologías:

## Seguridad en Spring Framework
Spring Framework, particularmente con el módulo Spring Security, ofrece una gama de características para manejar la seguridad de las aplicaciones. 
Estas son las más importantes:

### Autenticación
- Spring Security puede integrarse con varios proveedores de autenticación como bases de datos, LDAP, OAuth2, JWT, y más.
- Implementación común:
	- Configurar un UserDetailsService para cargar los usuarios desde la base de datos.
	- Usar BCryptPasswordEncoder para almacenar contraseñas de manera segura.
>
> @Bean
> public PasswordEncoder passwordEncoder() {
> 	return new BCryptPasswordEncoder();
> }
> 
> @Bean 
> public UserDetailsService userDetailsService(UserRepository userRepository) {
> 	return username -> userRepository.findByUsername(username)
> 		.orElseThrow(() -> new UsernameNotFoundException("User not found"));
> }
>

### Autorización
- Spring Security permite configurar restricciones de acceso basadas en roles o permisos.
- Esto puede hacerse a nivel de métodos (con anotaciones como
  **@PreAuthorize**), rutas HTTP (mediante reglas de seguridad web) o incluso capas personalizadas.

> 
> @EnableGlobalMethodSecurity(prePostEnabled = true)
> public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {}
> 
> @RestController
> public class AdminController {
> 	@PreAuthorize("hasRole('ADMIN')")
> 	@GetMapping("/admin")
> 	public String adminPage() {
> 		return "Welcome, Admin!";
> 	}
> }
>

### Protección contra amenazas comunes
- **CSRF (Cross-Site Request Forgery):** Protegido por defecto en formularios web.
- **CORS (Cross-Origin Resource Sharing):** Configurable para permitir o restringir peticiones entre dominios.
- **Headers de seguridad:** Protección contra ataques de tipo XSS y otras amenazas mediante políticas de encabezados HTTP.

>
> @Override
> protected void configure(HttpSecurity http) throws Exception {
> 	http.csrf().disable()
> 		.authorizeRequests()
> 		.antMatchers("/public/**").permitAll()
> 		.antMatchers("/admin/**").hasRole("ADMIN")
> 		.and()
> 		.headers().xssProtection().and().contentSecurityPolicy("script-src 'self'");
> }
>

### OAuth2 y JWT
Spring Security facilita la integración de autenticación basada en OAuth2 y el uso de tokens JWT para aplicaciones RESTful.

## Seguridad en Hibernate JPA
Hibernate JPA, como herramienta ORM, no incluye directamente medidas de seguridad, 
pero proporciona las bases para proteger las interacciones con la base de datos. 
Aquí se explican algunos aspectos clave:

### Validaciones a nivel de entidad
- Puedes usar anotaciones de validación como parte de las entidades para garantizar que los datos sean válidos antes de persistirlos.
- Spring Boot se integra con Bean Validation (Hibernate Validator).

> 
> @Entity
> public class User {
> 	@Id
> 	@GeneratedValue(strategy = GenerationType.IDENTITY)
> 	private Long id;
> 
> 	@NotNull
> 	@Size(min = 3, max = 50)
> 	private String username;
> 	
> 	@NotNull
> 	@Email
> 	private String email;
> 
> 	@NotNull
> 	@Size(min = 8)
> 	private String password;
> }
>

### Prevención de inyección SQL
- Hibernate usa consultas parametrizadas, lo que protege contra inyección SQL.
- Ejemplo de @Query seguro:

>
> @Query("SELECT u FROM User u WHERE u.username = :username")
> User findByUsername(@Param("username") String username);
> 

### Control de acceso a datos
- Puedes usar anotaciones como @EntityListeners para registrar eventos 
(por ejemplo, **@PrePersist**, **@PostLoad**) que verifiquen permisos antes de realizar operaciones.

>
> @EntityListeners(AuditListener.class)
> public class User {
> }
>

### Encriptación de datos sensibles
- Hibernate permite la integración con herramientas de encriptación para proteger datos sensibles como contraseñas o números de tarjetas.

>
> @Convert(converter = AttributeEncryptor.class)
> private String sensitiveData;
>

## Mejoras de seguridad en conjunto
Al usar Spring y Hibernate juntos, puedes aprovechar las capacidades de ambos para una solución integral:
- **Transacciones seguras:** Spring gestiona las transacciones declarativas, 
asegurando que las operaciones con la base de datos se ejecuten correctamente y se reviertan en caso de errores.
- **Capas de seguridad complementarias:** Mientras Spring protege la capa de aplicación y proporciona autenticación/autorización, 
Hibernate asegura la integridad y seguridad de los datos.
- **Política de acceso a datos:** Puedes combinar @PreAuthorize en métodos de servicios con validaciones específicas en entidades 
para asegurar que solo los datos permitidos sean accesibles.

## Resumen
La combinación de Spring Security y Hibernate JPA es poderosa para construir aplicaciones seguras. 
Spring se ocupa de la seguridad en la capa de aplicación y la gestión de usuarios, 
mientras que Hibernate protege los datos a través de consultas seguras, validación y encriptación. 
Siguiendo las mejores prácticas y configurando adecuadamente ambos frameworks, puedes construir aplicaciones altamente seguras y escalables.

