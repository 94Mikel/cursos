using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ManejoPresupuesto.Models
{
    public class IndiceCuentasViewModel
    {
        public string TipoCuenta { get; set; }
        public IEnumerable<Cuenta> Cuentas { get; set; }

        //NOTE: Suma balance model
        /*
            Balance => es la sumatoria de los balances.
            Valor Balance es igual a la suma de los distintos balances de las cuentas pertenecientes a este tipo.
            Se calcula automáticamente 
        */
        public decimal Balance => Cuentas.Sum( x => x.Balance);
        public decimal BalancePositivo => Cuentas.Where(i => i.Balance > 0).Sum(i => i.Balance);
        public decimal BalanceNegativo => Cuentas.Where(i => i.Balance < 0).Sum(i => i.Balance);
    }
}