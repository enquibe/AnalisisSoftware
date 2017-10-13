using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestorDeTesting
{
    public class Metodo
    {
        public Metodo(String[] lineas, String nombre){
            lineasMetodo = lineas.ToList();
            nombreMetodo = nombre;
        }

        private List<String> lineasMetodo {get;set;}

        private String nombreMetodo { get; set; }
        
        public override String ToString(){ return nombreMetodo; }

        public String obtenerLinea(int index){ return this.lineasMetodo[index]; }

        public int obtenerCantidadLineas() { return this.lineasMetodo.Count; }

        public List<String> getLineasMetodo() { return this.lineasMetodo; }
    }

    
}
