using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ManejoPresupuesto.Models
{
    public class Transaccion
    {
        public int TransaccionId { get; set; }
        public int UsuarioId { get; set; }
        [Display(Name = "Fecha Transacción")]
        [DataType(DataType.Date)]//para poner la fecha sin la hora
        //DateTime.Parse(DateTime.Now.ToString("g")); formetar la fecha
        public DateTime FechaTransaccion { get; set; } = DateTime.Today;
        public decimal Monto { get; set; }
        //Atributos de Categoria id
        /*
            Range => El número debe ser entre 1 y maximo valor enteros.
        */
        [Range(1, maximum: int.MaxValue, ErrorMessage = "Debe seleccionar una categoría")]
        public int CategoriaId { get; set; }
        [StringLength(maximumLength:1000, ErrorMessage = "La nota no puede pasar de {1} caracteres")]
        public string Nota { get; set; }
        [Range(1, maximum: int.MaxValue, ErrorMessage = "Debe seleccionar una cuenta")]
        public int CuentaId { get; set; }
    }
}