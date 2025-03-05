using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;
using ManejoPresupuesto.Validaciones;

namespace ManejoPresupuesto.Models
{
    public class Cuenta
    {
        public int cuentaId { get; set; }
        [Required(ErrorMessage = "El campo {0} es requerido")]
        [StringLength(maximumLength: 50)]
        [PrimeraLetraMayuscula]
        public string Nombre { get; set; }
        [Display(Name = "Tipo Cuenta")]
        public int TipoCuentaId { get; set; }
        [DisplayFormat(DataFormatString = "{0:N}", ApplyFormatInEditMode = true)]
        public decimal Balance { get; set; }
        [StringLength(maximumLength: 1000)]
        public string Descripcion { get; set; }

        public string TipoCuenta {get; set;}
    }
}