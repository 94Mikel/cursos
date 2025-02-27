using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Threading.Tasks;
using ManejoPresupuesto.Validaciones;
using Microsoft.AspNetCore.Mvc;

namespace ManejoPresupuesto.Models
{
    public class TipoCuenta//: IValidatableObject
    {

        /*
            NOTE
            Con Remote llamamos al metodo get de VerificarExisteTipoCuenta para verificar si existe el nombre.
            Con esto realizamos la validación cuando se pierde el foco del input text.
        */

        public int Id { get; set; }
        [Required(ErrorMessage = "El campo {0} es requerido")]//requerir el campo nombre
        [Remote(action: "VerificarExisteTipoCuenta", controller:"TipoCuenta")]
        // [PrimeraLetraMayuscula]
        public string Nombre { get; set; }
        public int IdUsuario { get; set; }
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