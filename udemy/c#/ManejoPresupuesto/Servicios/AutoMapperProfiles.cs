using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AutoMapper;
using ManejoPresupuesto.Models;

//NOTE: AutoMapper
/*
    A automapper hay que indicarle a que clase a que clase podemos mappear. 
    Lo hacemos en una clase profile.
    Este caso desde Cuenta a CuentaCreaciónViewModel
    Heredamos de la clase Profile.
*/

namespace ManejoPresupuesto.Servicios
{
    public class AutoMapperProfiles : Profile
    {
        public AutoMapperProfiles()
        {
            CreateMap<Cuenta, CuentaCreacionViewModel>();
        }
    }
}