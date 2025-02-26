using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Threading.Tasks;
using ManejoPresupuesto.Validaciones;

namespace ManejoPresupuesto.Models
{
    public class TipoCuenta//: IValidatableObject
    {
        public int Id { get; set; }
        [Required(ErrorMessage = "El campo {0} es requerido")]//requerir el campo nombre
        // [PrimeraLetraMayuscula]
        public string Nombre { get; set; }
        public int UsuarioId { get; set; }
        public int Orden { get; set; }
        /*
        public IEnumerable<ValidationResult> Validate(ValidationContext validationContext)
        {
            if (Nombre != null && Nombre.Length > 0)
            {
                var primeraLetra = Nombre[0].ToString();

                if (primeraLetra != primeraLetra.ToUpper())
                {
                    // new[] {nameof(Nombre)} => para indicar que le afecta al campo nombre.
                    //Error a nivel de campo
                    yield return new ValidationResult(
                        "La primera letra debe ser mayúscula",
                        new[] { nameof(Nombre) }
                    );

                    //Error a nivel de modelo
                    //Son perfecto para indecar un errores generales(no de campo)
                    yield return new ValidationResult(
                        "La primera letra debe ser mayúscula"
                    );
                }
            }
        }
        */
        
    }
}