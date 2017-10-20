using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestorDeTesting
{
    public class Clase
    {
        public Archivo Archivo;

        public string Nombre { get; private set; }
        public string Firma { get; private set; }
        public List<Metodo> Metodos { get; set; }

        public Clase(Archivo archivo)
        {
            this.Archivo = archivo;
            this.Metodos = new List<Metodo>();
        }

        internal void Procesar(List<string> lineas)
        {
            // Empieza una clase
            this.Firma = lineas[0];
            // Limpiar extends de la firma
            var indexExtends = this.Firma.IndexOf(" extends ");
            var firmaSinExtends = indexExtends < 0
                ? this.Firma
                : this.Firma.Substring(0, indexExtends);
            // Obtener nombre de la clase
            this.Nombre = firmaSinExtends.Substring(firmaSinExtends.LastIndexOf(" ") + 1);

            string linea;
            int contadorLlaves = 0;
            do
            {
                // Borrar primer linea
                lineas.RemoveAt(0);
                linea = lineas[0];
                switch (linea)
                {
                    case "{":
                        contadorLlaves++;
                        break;
                    case "}":
                        contadorLlaves--;
                        break;
                    default:
                        // procesar linea de la clase
                        if (linea.EndsWith(")") || linea.Replace(" ", "").EndsWith(")throwsException"))
                        {
                            // Metodo
                            var metodo = new Metodo(this);
                            metodo.Procesar(lineas);
                            this.Metodos.Add(metodo);
                        }
                        break;
                }
            } while (contadorLlaves != 0);
        }

        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.AppendLine(this.Firma);
            sb.AppendLine("{");
            this.Metodos.ForEach(x => sb.AppendLine(x.ToString()));
            sb.AppendLine("}");
            return sb.ToString();
        }
    }
}
