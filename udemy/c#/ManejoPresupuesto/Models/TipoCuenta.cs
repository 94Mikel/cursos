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

        //NOTE: Remote
        /*
            Con Remote llamamos al metodo get de VerificarExisteTipoCuenta para verificar si existe el nombre.
            Con esto realizamos la validación cuando se pierde el foco del input text.
        */

        public int Id { get; set; }
        [Required(ErrorMessage = "El campo {0} es requerido")]//requerir el campo nombre
        [Remote(action: "VerificarExisteTipoCuenta", controller:"TiposCuentas")]
        // [PrimeraLetraMayuscula]
        public string Nombre { get; set; }
        public int UsuarioId { get; set; }
        public int Orden { get; set; }
        
    }
}