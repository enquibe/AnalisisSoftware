using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestorDeTesting
{
    public class Metodo
    {
        private string Firma;
        private Clase clase;

        public Metodo(String[] lineas, String nombre){
            lineasMetodo = lineas.ToList();
            nombreMetodo = nombre;
        }

        public Metodo(Clase clase)
        {
            this.clase = clase;
        }

        private List<String> lineasMetodo {get;set;}
        // private List<String> lineasMetodo2 { get; set; }

        private String nombreMetodo { get; set; }
        
        // public override String ToString(){ return nombreMetodo; }

        public String obtenerLinea(int index){ return this.lineasMetodo[index]; }

        public int obtenerCantidadLineas() { return this.lineasMetodo.Count; }

        public List<String> getLineasMetodo() { return this.lineasMetodo; }

        /*public String getCodigoToPrint()
        {
            var sb = new StringBuilder();
            sb.AppendLine(this.Firma);
            this.lineasMetodo2.ForEach(x => sb.AppendLine(x));
            return sb.ToString();
        }*/

        public string getCodigoToPrint()
        {
            var sb = new StringBuilder();
            sb.AppendLine(this.Firma);
            this.lineasMetodo.ForEach(x => sb.AppendLine(x));
            return sb.ToString();
        }

        public override string ToString()
        {
            return this.Firma;
        }

        public void Procesar(List<string> lineasCodigo)
        {
            this.lineasMetodo = new List<string>();
            // this.lineasMetodo2 = lineasCodigo;
            // Empieza un metodo
            this.Firma = lineasCodigo[0];
            // Obtener nombre del metodo
            var aux = this.Firma.Substring(0, this.Firma.LastIndexOf("("));
            this.nombreMetodo = aux.Substring(aux.LastIndexOf(" ") + 1);

            string linea;
            int contadorLlaves = 0;
            do
            {
                // Borrar primer linea
                lineasCodigo.RemoveAt(0);

                linea = lineasCodigo[0];
                switch (linea)
                {
                    case "{":
                        contadorLlaves++;
                        break;
                    case "}":
                        contadorLlaves--;
                        break;
                    default:
                        // procesar linea del metodo

                        break;
                }
                this.lineasMetodo.Add(linea);
            } while (contadorLlaves != 0);
        }
    }

    
}
