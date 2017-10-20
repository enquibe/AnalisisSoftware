using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestorDeTesting
{
    public class Archivo
    {
        private string archivoOriginal;
        private string archivo;
        private List<string> lineas;

        public string Nombre { get; private set; }
        public Dictionary<string, Clase> Clases { get; private set; }

        public Archivo(string pathArchivo)
        {
            this.Nombre = Path.GetFileName(pathArchivo);
            this.Clases = new Dictionary<string, Clase>();

            this.archivoOriginal = File.ReadAllText(pathArchivo, Encoding.GetEncoding(1252));
            this.LimpiarArchivo();

            this.lineas = this.archivo.Split(new string[] { "\r\n" }, StringSplitOptions.RemoveEmptyEntries)
                .Select(x => x.Trim())
                .Where(x => !string.IsNullOrWhiteSpace(x))
                .ToList();

            string linea;
            while (this.lineas.Count > 0)
            {
                linea = this.lineas[0];
                if (linea.StartsWith("class ") || linea.Contains(" class "))
                {
                    var clase = new Clase(this);
                    clase.Procesar(this.lineas);
                    this.Clases.Add(clase.Nombre, clase);
                }
                this.lineas.RemoveAt(0);
            }
        }

        private void LimpiarArchivo()
        {
            this.archivo = this.archivoOriginal
                .Replace("{", "\r\n{\r\n")
                .Replace("}", "\r\n}\r\n");
        }
    }
}
