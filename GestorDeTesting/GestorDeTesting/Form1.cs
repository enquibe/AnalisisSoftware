﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;



namespace GestorDeTesting
{
    public partial class Form1 : Form
    {

        //private List<Clase> clases;
        private List<Archivo> archivos;
        
        public Form1()
        {
            InitializeComponent();
        }

        private void toolStripMenuItem3_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog fdBrowserDialog = new FolderBrowserDialog();

            DialogResult dr = fdBrowserDialog.ShowDialog();

            if (dr == DialogResult.OK && !string.IsNullOrWhiteSpace(fdBrowserDialog.SelectedPath))
            {
                this.clearScreen();
                string[] files = Directory.GetFiles(fdBrowserDialog.SelectedPath);
                //this.clases = new List<Clase>();
                this.archivos = new List<Archivo>();
                foreach (var item in files)
                {
                    if (Path.GetExtension(item) == ".java")
                    {
                        /*string codigo = File.ReadAllText(item);
                        codigo.Replace('\t', ' ');
                        codigo.Replace('\r', ' ');
                        string[] lineas = codigo.Split('\n');
                        List<Metodo> metodos = obtenerMetodos(lineas);
                        this.clases.Add(new Clase(metodos,Path.GetFileName(item)));*/
                        this.archivos.Add(new Archivo(item));
                    }
                }

                //listBox3.SelectedIndex = 0;
                this.listBox1.DisplayMember = "Nombre";
                if (this.archivos.Count != 0)
                {

                    if (listBox3.Items.Count > 0)
                    {
                        for (int i = listBox3.Items.Count - 1; i >= 0; i--)
                        {
                            listBox3.Items.RemoveAt(i);
                        }
                    }
                    foreach (Archivo archivo in this.archivos)
                    {
                        listBox3.Items.Add(archivo);
                    }

                    if (listBox2.Items.Count > 0)
                    {
                        for (int i = listBox2.Items.Count - 1; i >= 0; i--)
                        {
                            listBox2.Items.RemoveAt(i);
                        }
                    }
               
                }

                // string filename = "";
                // OpenFileDialog ofd = new OpenFileDialog();
                //ofd.Multiselect = false;

                //DialogResult dr = ofd.ShowDialog();
                /*filename = ofd.FileName;
                string codigo = File.ReadAllText(filename);
                codigo.Replace('\t', ' ');
                codigo.Replace('\r', ' ');
                string[] lineas = codigo.Split('\n');
                List<Metodo> metodos = obtenerMetodos(lineas);
                if (listBox1.Items.Count > 0)
                {
                    for (int i = listBox1.Items.Count - 1; i >= 0; i--)
                    {
                        listBox1.Items.RemoveAt(i);
                    }
                }
                foreach (Metodo metodo in metodos)
                {
                    listBox1.Items.Add(metodo);
                }*/

            }else
            {
                MessageBox.Show("Directorio inválido","Error");
            }

        }

        private List<Metodo> obtenerMetodos(String[] lineasArchivo)
        {
            //string regexp = "^\\s*(public|private|protected|public static){1}\\s+(void|int|double|boolean|float|char|([A-Z]{1}[a-z]*)*){1}\\s+([a-z]*([A-Z]{1}[a-z]*)*)\\s*\\({1}.*";
            string regexp = "((public|private|protected|static|final|native|synchronized|abstract|transient)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^\\)]*\\)?\\s*\\{?[^\\}]*\\}?";
            string ctorRegExp = "(public|protected|private|static|\\s)\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";

            Regex p = new Regex(regexp, RegexOptions.IgnoreCase);
            Match m;

            Regex p2 = new Regex(ctorRegExp, RegexOptions.IgnoreCase);
            Match m2;

            List<Metodo> metodos = new List<Metodo>();
            bool enComentarioMultilinea = false;
            bool enMetodo = false;
            int cantidadLlaves = 0;
            int indiceDelUltimoComentario = 1;
            int indiceComienzoMetodo = 0;
            /*String linea : lineasArchivo*/
            for (int j = 0; j < lineasArchivo.Length; j++)
            {

                bool lineaContada = false;
                bool enComillas = false;


                m = p.Match(lineasArchivo[j]);
                m2 = p2.Match(lineasArchivo[j]);
                if (m.Success && !enMetodo &&
                        !enComentarioMultilinea &&
                        !enComillas)
                {
                    enMetodo = true;
                    Console.WriteLine("Metodo Encontrado" + lineasArchivo[j]);
                    indiceComienzoMetodo = j;
                }
                /*else if (m2.Success && !enMetodo &&
                        !enComentarioMultilinea &&
                        !enComillas)
                {
                    enMetodo = true;
                    Console.WriteLine("Metodo Encontrado" + lineasArchivo[j]);
                    indiceComienzoMetodo = j;
                }*/

                if (enMetodo)
                {
                    for (int i = 0; i < lineasArchivo[j].Length; i++)
                    {

                        if (abreLlave(lineasArchivo[j], i))
                        {
                            cantidadLlaves++;
                        }

                        if (cierraLlave(lineasArchivo[j], i) && cantidadLlaves > 0)
                        {
                            cantidadLlaves--;
                            Console.WriteLine("cuento linea que cierra");
                            if (cantidadLlaves == 0)
                            {
                                String nombreDelMetodo = "";
                                String[] datos = lineasArchivo[indiceComienzoMetodo].Split(' ');
                                foreach (string dato in datos)
                                {
                                    if (dato.Contains('(') && nombreDelMetodo == "")
                                    {
                                        nombreDelMetodo = dato.Split('(')[0];
                                    }
                                }
                                if (indiceDelUltimoComentario != 0)
                                {
                                    if (hayJavaDoc(indiceDelUltimoComentario, indiceComienzoMetodo, lineasArchivo))
                                    {
                                        List<String> lineasMetodo = new List<String>();
                                        for (int z = indiceDelUltimoComentario; z <= j + 1; z++)
                                        {
                                            lineasMetodo.Add(lineasArchivo[z]);
                                        }
                                        Metodo aux = new Metodo(lineasMetodo.ToArray(),
                                                   nombreDelMetodo);
                                        metodos.Add(aux);
                                        Console.WriteLine("Creo Metodo " + nombreDelMetodo);
                                        enMetodo = false;
                                        cantidadLlaves = 0;
                                    }
                                    else
                                    {
                                        List<String> lineasMetodo = new List<String>();
                                        for (int z = indiceComienzoMetodo; z <= j + 1; z++)
                                        {
                                            lineasMetodo.Add(lineasArchivo[z]);
                                        }
                                        Metodo aux = new Metodo(lineasMetodo.ToArray(),
                                                                        nombreDelMetodo);

                                        metodos.Add(aux);
                                        Console.WriteLine("Creo Metodo " + nombreDelMetodo);
                                        enMetodo = false;
                                        cantidadLlaves = 0;
                                    }


                                }
                            }
                        }
                    }
                }
                else
                {
                    for (int i = 0; i < lineasArchivo[j].Length - 1; i++)
                    {

                        if (tieneComillas(lineasArchivo[j], i))
                        {
                            enComillas = !enComillas;
                        }

                        if (enComillas)
                            continue;

                        if (!lineaContada &&
                                !enComillas &&
                                tieneComentario(lineasArchivo[j], i))
                        {
                            indiceDelUltimoComentario = j;
                            lineaContada = true;
                            continue;
                        }

                        if (!enComentarioMultilinea &&
                                arrancaComentarioMultilinea(lineasArchivo[j], i))
                        {
                            enComentarioMultilinea = true;
                            indiceDelUltimoComentario = j;
                        }

                        if (enComentarioMultilinea && !lineaContada)
                        {
                            lineaContada = true;
                        }

                        if (terminaComentarioMultilinea(lineasArchivo[j], i))
                        {
                            enComentarioMultilinea = false;
                        }
                    }
                }

            }
            return metodos;
        }


        /**
         * Busca si hay java doc asociado a un metodo, asi agrega la parte del texto al nuevo nodo metodo
         * @param indiceDelUltimoComentario
         * @param indiceComienzoMetodo
         * @param lineasArchivo
         */
        private bool hayJavaDoc(int indiceDelUltimoComentario, int indiceComienzoMetodo, String[] lineasArchivo)
        {
            bool metodoNoEsperado = false;
            while (indiceComienzoMetodo != indiceDelUltimoComentario && !metodoNoEsperado)
            {
                for (int i = 0; i < lineasArchivo[indiceComienzoMetodo].Length; i++)
                    if (cierraLlave(lineasArchivo[indiceComienzoMetodo], i))
                        metodoNoEsperado = true;
                indiceComienzoMetodo--;
            }
            if (indiceComienzoMetodo == indiceDelUltimoComentario)
                return true;
            else
                return false;
        }

        private bool tieneComentario(String linea, int indice)
        {
            return linea[indice] == '/' && linea[indice + 1] == '/';
        }

        private bool tieneComillas(String linea, int indice)
        {
            return linea[indice] != '\\' && linea[indice + 1] == '"';
        }

        private bool arrancaComentarioMultilinea(String linea, int indice)
        {
            return linea[indice] == '/' && linea[indice + 1] == '*';
        }

        private bool terminaComentarioMultilinea(String linea, int indice)
        {
            return linea[indice] == '*' && linea[indice + 1] == '/';
        }

        private bool abreLlave(String linea, int indice)
        {
            return linea[indice] == '{';
        }

        private bool cierraLlave(String linea, int indice)
        {
            return linea[indice] == '}';
        }

        private void checkedListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void cambioMetodoSeleccionado(object sender, EventArgs e)
        {
            Metodo metodo = (Metodo)listBox1.SelectedItem;

            List<Metodo> metodosTotales = new List<Metodo>();
            foreach (Metodo item in listBox1.Items)
            {
                metodosTotales.Add(item);
            }
            //richTextBox1.Clear();
            this.txtCodigo.ResetText();
            if (metodo != null)
            {
                /*for (int i = 0; i < metodo.obtenerCantidadLineas(); i++)
                    richTextBox1.AppendText(metodo.obtenerLinea(i) + "\n");*/
                //richTextBox1.AppendText(metodo.ToString());
                this.txtCodigo.Text = metodo.getCodigoToPrint();
            }
            if (metodo != null)
            {

                // Calcular complejidad ciclomática.
                lblCiclomatica.Text = calcularComplejidadCiclomatica(metodo.getLineasMetodo()).ToString();

                // Calcular cantidad de comentarios.
                int lineasDeCodigo = getCantidadDeLineasNoComentadas(metodo.getLineasMetodo());
                int cantidadComentarios = calcularComentarios(metodo.getLineasMetodo());
                lblComentarios.Text = cantidadComentarios.ToString() +
                                      "/" +
                                      lineasDeCodigo.ToString() +
                                      //metodo.obtenerCantidadLineas().ToString() +
                                      " ( " +
                                      (((float)cantidadComentarios / lineasDeCodigo) * 100).ToString() +
                                      "% )";

                // Calcular Fan In.
                lblFanIn.Text = calcularFanIn(metodo, metodosTotales).ToString();
                // Calcular Fan Out.
                lblFanOut.Text = calcularFanOut(metodo.getLineasMetodo()).ToString();
                // Calcular medidas Halstead.
                MetricaHalstead medidasHalstead = calcularLongitudVolumen(metodo.getLineasMetodo());
                lblLongitud.Text = medidasHalstead.getLongitud().ToString() +
                                   " ( Operadores: " +
                                   medidasHalstead.getCantidadOperadores().ToString() +
                                   " - Operandos: " +
                                   medidasHalstead.getCantidadOperandos() +
                                   " )";
                lblVolumen.Text = medidasHalstead.getVolumen().ToString();
                string operadores = "";
                foreach(string operador in medidasHalstead.getOperadores()) {
                    if (operador == "&&")
                        operadores += "&&&&";
                    else
                        operadores += operador.ToString();

                    operadores += " , ";
                }
                lblOperadores.Text = operadores;
            }
        }


        public int calcularComplejidadCiclomatica(List<String> lineasArchivo)
        {
            bool hasThrowOrCatch = false;
            bool enComentario = false;
            //La complejidad ciclomÃ¡tica mÃ­nima.
            int CC = 1;
            //Listado de palabras que representan un salto en el curso de decision.
            String[] keywords = { "if", "else", "case", "default", "for", "while", "catch", "throw" };
            String[] condiciones = { "&&", "||" };
            int cantidad;

            foreach (String linea in lineasArchivo)
            {
                if (linea.StartsWith(@"//"))
                    continue;
                
                if (linea.StartsWith(@"/*"))
                    enComentario = true;

                if (linea.EndsWith(@"*/"))
                    enComentario = false;

                if (enComentario)
                    continue;

                Console.WriteLine("Leyendo lÃ­nea " + linea);
                string regexp = ".*\\W*(if|else|case|default|while|for|catch|throw)\\W.*";

                Regex p = new Regex(regexp, RegexOptions.IgnoreCase);
                Match m;
                m = p.Match(linea);
                if (m.Success)
                {
                    string regexp2 = ".*(&&|\\|\\|).*";
                    p = new Regex(regexp2, RegexOptions.IgnoreCase);
                    m = p.Match(linea);
                    if (!m.Success)
                    {
                        foreach (String palabra in keywords)
                        {
                            cantidad = (linea.Length - linea.SafeReplace(palabra, "", true).Length) / palabra.Length;
                            if (cantidad > 0)
                            {

                                if (palabra != "throw") {
                                    if(palabra != "catch" || hasThrowOrCatch == false) {
                                        CC += cantidad;
                                        Console.WriteLine(cantidad + " " + palabra + " encontrado/s.");
                                    } else {
                                        hasThrowOrCatch = true;
                                    }
                                } else {
                                    if (!hasThrowOrCatch)
                                        hasThrowOrCatch = true;
                                }
                            }
                        }
                    }
                    else
                    {
                        foreach (String simbolo in condiciones)
                        {
                            cantidad = (linea.Length - linea.Replace(simbolo, "").Length) / simbolo.Length;
                            if (cantidad > 0)
                            {
                                CC += cantidad;
                                Console.WriteLine(cantidad + " " + simbolo + " encontrado/s.");
                            }
                        }
                        CC += 1;
                    }
                }
                else
                {
                    string regexp2 = ".*(&&|\\|\\|).*";
                    p = new Regex(regexp2, RegexOptions.IgnoreCase);
                    m = p.Match(linea);
                    if (m.Success)
                    {
                        foreach (String simbolo in condiciones)
                        {
                            cantidad = (linea.Length - linea.Replace(simbolo, "").Length) / simbolo.Length;
                            if (cantidad > 0)
                            {
                                CC += cantidad;
                                Console.WriteLine(cantidad + " " + simbolo + " encontrado/s.");
                            }
                        }
                        CC += 1;
                    }
                }

                /*string regexp2 = ".*(&&|\\|\\|).*";
                p = new Regex(regexp2, RegexOptions.IgnoreCase);
                m = p.Match(linea);
                if (m.Success)
                {
                    foreach (String simbolo in condiciones)
                    {
                        cantidad = (linea.Length - linea.Replace(simbolo, "").Length) / simbolo.Length;
                        if (cantidad > 0)
                        {
                            CC += cantidad + 1;
                            Console.WriteLine(cantidad + " " + simbolo + " encontrado/s.");
                        }
                    }
                }*/
            }
            return CC;
        }

        public int calcularComentarios(List<String> lineasArchivo)
        {
            int cantidadLineas = 0;
            
            // Indica si estamos en un comentario /* */
            bool enComentarioMultilinea = false;
            foreach (String linea in lineasArchivo)
            {
                Console.WriteLine("Leyendo línea " + linea);
                // Indica si la línea ya se ha contado como de comentario.
                bool lineaContada = false;

                // Indica si estamos dentro de un par de comillas.
                bool enComillas = false;
                for (int i = 0; i < linea.Length - 1; i++)
                {
                    // Buscamos comillas.
                    if (tieneComillas(linea, i))
                    {
                        Console.WriteLine("Encontrada comilla no escapada");
                        enComillas = !enComillas;
                        Console.WriteLine("En comillas: " + enComillas);
                    }

                    if (enComillas)
                        continue;

                    if (!lineaContada &&
                        !enComillas &&
                        tieneComentario(linea, i))
                    {
                        Console.WriteLine("Encontrado comentario //");
                        cantidadLineas++;
                        lineaContada = true;
                        continue;
                    }

                    if (!enComentarioMultilinea &&
                        arrancaComentarioMultilinea(linea, i))
                    {
                        Console.WriteLine("Encontrado comentario multilínea");
                        enComentarioMultilinea = true;
                    }
                    if (enComentarioMultilinea && !lineaContada)
                    {
                        Console.WriteLine("Esta línea tiene un comentario. Se cuenta");
                        lineaContada = true;
                        cantidadLineas++;
                    }
                    if (terminaComentarioMultilinea(linea, i))
                    {
                        Console.WriteLine("Se termina el comentario multilínea");
                        enComentarioMultilinea = false;
                    }
                }
            }
            return cantidadLineas;
        }

        int getCantidadDeLineasNoComentadas(List<String> lineas)
        {
            bool enComentario = false;
            int cLineas = 0;
            foreach (String linea in lineas)
            {
                if (linea.StartsWith(@"//"))
                    continue;

                if (linea.StartsWith(@"/*"))
                    enComentario = true;

                if (linea.EndsWith(@"*/"))
                    enComentario = false;

                if (enComentario)
                    continue;

                cLineas++;
            }

            return cLineas;
        }

        public int calcularFanIn(Metodo metodoActual, List<Metodo> metodosTotales)
        {
            int fanIn = 0;
            Console.WriteLine("entro fanin");
            bool enComentarioMultilinea = false;
            foreach (Metodo metodo in metodosTotales)
            {
                Console.WriteLine("leo metodo" + metodo.ToString());
                foreach (String linea in metodo.getLineasMetodo())
                {

                    bool lineaContada = false;
                    bool enComillas = false;

                    for (int i = 0; i < linea.Length - 1; i++)
                    {
                        if (tieneComillas(linea, i))
                        {
                            enComillas = !enComillas;
                        }
                        if (enComillas)
                            continue;
                        if (!lineaContada &&
                            !enComillas &&
                            tieneComentario(linea, i))
                        {
                            lineaContada = true;
                            continue;
                        }
                        if (!enComentarioMultilinea &&
                            arrancaComentarioMultilinea(linea, i))
                        {
                            enComentarioMultilinea = true;
                        }
                        if (enComentarioMultilinea && !lineaContada)
                        {
                            lineaContada = true;
                        }
                        if (terminaComentarioMultilinea(linea, i))
                        {
                            enComentarioMultilinea = false;
                        }
                    }

                    //matchDeclaracion = patronDeclaracion.matcher(linea);
                    //matchPalabraReservada = patronesPalabraReservada.matcher(linea);

                    if (!enComentarioMultilinea &&
                            !enComillas)
                    {
                        String[] datos1 = linea.Split(metodoActual.ToString().ToArray());
                       
                        if (linea.Contains(metodoActual.ToString()) && metodo.ToString() != metodoActual.ToString())
                        {
                            fanIn++;
                        }
                    }
                }
            }

            return fanIn;
        }

        public int calcularFanOut(List<String> lineasArchivo) {
    	int fanOut = 0;
        string regexpDeclaracion = "^\\s*(public|private|protected){1}\\s+(void|int|double|boolean|float|char|([A-Z]{1}[a-z]*)*){1}\\s+([a-z]*([A-Z]{1}[a-z]*)*)\\s*\\({1}.*";
        string regexpPalabraReservada = "^.*(if|while|catch|for\\s*\\({1}|try\\s*\\({1}|return\\s*\\({1}.*\\){1}).*";
    	Regex pDeclaracion = new Regex(regexpDeclaracion, RegexOptions.IgnoreCase);
        Regex pPalabraReservada = new Regex(regexpPalabraReservada, RegexOptions.IgnoreCase);
        Match matchDeclaracion;
        Match matchPalabraReservada;
    	///Reutilizo lógica de CantidadComentarios
        bool enComentarioMultilinea = false;
        foreach (String linea in lineasArchivo) {
        	
        	bool lineaContada = false;
    		bool enComillas = false;
    		
    		for (int i = 0; i < linea.Length - 1; i++) {
    			if (tieneComillas(linea, i)) {
                    enComillas = !enComillas;
                }
                if (enComillas)
                    continue;
                if (!lineaContada &&
                    !enComillas &&
                    tieneComentario(linea, i)) {
                    lineaContada = true;
                    continue;
                }
                if (!enComentarioMultilinea &&
                    arrancaComentarioMultilinea(linea, i)) {
                    enComentarioMultilinea = true;
                }
                if (enComentarioMultilinea && !lineaContada) {
                    lineaContada = true;
                }
                if (terminaComentarioMultilinea(linea, i)) {
                    enComentarioMultilinea = false;
                }
            }
    		
    		matchDeclaracion = pDeclaracion.Match(linea);
            matchPalabraReservada = pPalabraReservada.Match(linea);
            
            if(!matchDeclaracion.NextMatch().Success &&
        			!enComentarioMultilinea &&
        			!enComillas){
            	String [] datos = linea.Split("\\(".ToCharArray());
            	fanOut += datos.Length - 1;
            	Console.WriteLine("Sumo "+ (datos.Length - 1).ToString() +" fanOut" + linea);
            }
            	
            while(matchPalabraReservada.NextMatch().Success &&
            		!matchDeclaracion.Success &&
        			!enComentarioMultilinea &&
        			!enComillas){
            	fanOut--;
            	Console.WriteLine("resto fanOut" + linea);
            }
            
        }
        return fanOut;
    }

        public MetricaHalstead calcularLongitudVolumen(List<String> lineasArchivo) {

        HashSet<String> setOperadores = new HashSet<String>();
        HashSet<String> setOperandos = new HashSet<String>();
        String[] operadores = {"if(", "else", "case", "default", "for(", "while", "catch", "throw",
							"+", "-", " * ", " / ", "==", "!=", "=", "<=", ">=", "<", ">",
							"&&", "||", " and ", " or ", "equal to"};
            // Inicializo las metricas en 0
        int cantidadOperadores = 0;
        int cantidadOperadoresUnicos = 0;
        int cantidadOperandos = 0;
        int cantidadOperandosUnicos = 0;
        List<int> indicesYaIncluidos = new List<int>();
        foreach (String linea in lineasArchivo) {
            Console.WriteLine("Leyendo línea " + linea);
            indicesYaIncluidos.Clear();
                // Busco operadores y operandos
                for (int i = 0; i < operadores.Length - 1; i++)
                {
                        if (linea.Contains(operadores[i]))
                        {
                            if (i > 7 && i < 19)
                            {
                                // Hay que cargar los operandos unicos
                                string[] aux = linea.Split(' ');
                                int j = 0;
                                foreach (string aux1 in aux)
                                {
                                    if (aux1 == operadores[i])
                                    {
                                        if (j!=0 && !indicesYaIncluidos.Contains(j - 1))
                                        {
                                            setOperandos.Add(aux[j - 1].Contains('(') ? aux[j - 1].Split('(')[1] : aux[j - 1]);
                                            cantidadOperandos++;
                                            indicesYaIncluidos.Add(j - 1);
                                        }
                                        if (!indicesYaIncluidos.Contains(j + 1))
                                            if (j + 1 != aux.Length)
                                            {
                                                setOperandos.Add(aux[j + 1].Contains(')') ? aux[j + 1].Split(')')[0] : aux[j + 1]);
                                                cantidadOperandos++;
                                                indicesYaIncluidos.Add(j + 1);
                                            }
                                            
                                            cantidadOperadores++;
                                       
                                    }
                                    setOperadores.Add(operadores[i]);
                                    j++;
                                }
                            }
                            else
                            {
                                foreach (string aux2 in linea.Split(' '))
                                {
                                    if (aux2.Contains(operadores[i]))
                                        cantidadOperadores++;
                                }
                                setOperadores.Add(operadores[i]);
                            }

                        }
                }
        }
        
        cantidadOperadoresUnicos = setOperadores.Count;
        cantidadOperandosUnicos = setOperandos.Count;

        //Longitud
        double Longitud = cantidadOperadores + cantidadOperandos;
        // Volumen
        double Volumen = (Longitud * (Math.Log(cantidadOperadoresUnicos + 
        							  Math.Log(cantidadOperandosUnicos)) / Math.Log(2)));
        					// Hago esa cuenta para calcular el log en base 2. log en base 2 = log(x) / log(2)
        Volumen = Volumen > 0 ? Volumen : 0;

        return new MetricaHalstead(Longitud,Volumen,setOperadores,setOperandos,cantidadOperadores,cantidadOperandos);
    
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label11_Click(object sender, EventArgs e)
        {

        }

        private void label9_Click(object sender, EventArgs e)
        {

        }

        private void label10_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void listBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.listBox1.DisplayMember = "nombreMetodo";
            this.clearScreen();
            this.listBox1.Items.Clear();
            var selectedItem = this.listBox2.SelectedItem as Clase;
            if (selectedItem == null)
                return;
            foreach (var metodo in selectedItem.Metodos)
                this.listBox1.Items.Add(metodo); 

            /*Clase clase = (Clase)listBox2.SelectedItem;
            if (clase != null)
            {
                if (listBox1.Items.Count > 0)
                {
                    for (int i = listBox1.Items.Count - 1; i >= 0; i--)
                    {
                        listBox1.Items.RemoveAt(i);
                    }
                }
                foreach (Metodo metodo in clase.Metodos)
                {
                    listBox1.Items.Add(metodo);
                }
            }*/
        }

        private void clearScreen()
        {
            this.richTextBox1.Clear();
            this.txtCodigo.ResetText();
            this.lblCiclomatica.Text = "";
            this.lblComentarios.Text = "";
            this.lblFanIn.Text = "";
            this.lblFanOut.Text = "";
            this.lblLongitud.Text = "";
            this.lblOperadores.Text = "";
            this.lblVolumen.Text = "";
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void groupBox2_Enter(object sender, EventArgs e)
        {

        }

        private void ayudaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Click en Archivo -> Abrir y seleccionar un directorio con archivos .java válidos\n" +
                            "Luego seleccionar un archivo y un método del mismo para ver las métricas","Ayuda");
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Clase clase = (Clase)this.listBox2.SelectedItem;
            Metodo metodo = (Metodo)this.listBox1.SelectedItem;
            if (clase != null && metodo != null)
            {
                string fileName = "informe.html";
                string textToAdd =
                    "<html>" +
                    "<head>" +
                    "<style>" +
                    // "body {background-color: #8cb8ff;}" +
                    "h1 {font-weight: bold; text-decoration: underline;}" +
                    "h3 {font-weight: bold;}" +
                    // "p {color: white;}" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Archivo: " + clase.Nombre + "</h1>" +
                    "<h1>Metodo: " + metodo.ToString() + "</h1>" +
                    "<h3>Lineas con comentarios:</h3> <p>" + this.lblComentarios.Text + "</p>" +
                    "<h3>Complejidad ciclomatica:</h3> <p>" + this.lblCiclomatica.Text + "</p>" +
                    "<h3>Fan In:</h3> <p>" + this.lblFanIn.Text + "</p>" +
                    "<h3>Fan Out:</h3> <p>" + this.lblFanOut.Text + "</p>" +
                    "<h3>Longitud:</h3> <p>" + this.lblLongitud.Text + "</p>" +
                    "<h3>Volumen:</h3> <p>" + this.lblVolumen.Text + "</p>" +
                    "<h3>Operadores:</h3> <p>" + this.lblOperadores.Text + "</p>" +
                    "</body>" +
                    "</html>";

                using (StreamWriter writer = new StreamWriter(fileName, false))
                {
                    writer.Write(textToAdd);
                }
                System.Diagnostics.Process.Start(fileName);
                // MessageBox.Show("Informe generado correctamente", "Informe");
            }
            else
            {
                MessageBox.Show("Eliga una clase y método primero", "Error");
            }
        }

        private void groupBox3_Enter(object sender, EventArgs e)
        {

        }

        private void listBox3_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.listBox2.DisplayMember = "Nombre";
            this.listBox2.Items.Clear();
            this.listBox1.Items.Clear();
            this.clearScreen();
            var selectedItem = this.listBox3.SelectedItem as Archivo;
            if (selectedItem == null)
                return;
            foreach (var clase in selectedItem.Clases.Values)
                this.listBox2.Items.Add(clase);            
        }

        private void groupBox4_Enter(object sender, EventArgs e)
        {

        }
    }

    public static class StringExtensions
    {
        public static string SafeReplace(this string input, string find, string replace, bool matchWholeWord)
        {
            string textToFind = matchWholeWord ? string.Format(@"\b{0}\b", find) : find;
            return Regex.Replace(input, textToFind, replace);
        }
    }

}
