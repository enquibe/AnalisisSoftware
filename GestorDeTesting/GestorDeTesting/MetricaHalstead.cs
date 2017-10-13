using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestorDeTesting
{
    public class MetricaHalstead
    {
        private double Longitud;
        private double Volumen;
        private HashSet<String> operadores;
        private HashSet<String> operandos;
        private int cantidadOperadores;
        private int cantidadOperandos;

        public MetricaHalstead(double Longitud,
                                double Volumen,
                                HashSet<String> operadores,
                                HashSet<String> operandos,
                                int cantidadOperadores,
                                int cantidadOperandos) 
        {
            this.Longitud = Longitud;
            this.Volumen = Volumen;
            this.operadores = operadores;
            this.operandos = operandos;
            this.cantidadOperadores = cantidadOperadores;
            this.cantidadOperandos = cantidadOperandos;
        }

        public double getLongitud() { return this.Longitud; }
        public double getVolumen() { return this.Volumen; }
        public HashSet<String> getOperadores() { return this.operadores; }
        public HashSet<String> getOperandos() { return this.operandos; }
        public int getCantidadOperadores() { return this.cantidadOperadores; }
        public int getCantidadOperandos() { return this.cantidadOperandos; }
    }
}
