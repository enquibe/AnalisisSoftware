namespace GestorDeTesting
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador requerida.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén utilizando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben eliminar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido del método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.menuStrip2 = new System.Windows.Forms.MenuStrip();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem3 = new System.Windows.Forms.ToolStripMenuItem();
            this.ayudaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.salirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.lblCiclomatica = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.lblComentarios = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.lblFanIn = new System.Windows.Forms.Label();
            this.lblFanOut = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.lblLongitud = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.lblVolumen = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lblOperadores = new System.Windows.Forms.Label();
            this.lbl99 = new System.Windows.Forms.Label();
            this.listBox2 = new System.Windows.Forms.ListBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.txtCodigo = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.listBox3 = new System.Windows.Forms.ListBox();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.menuStrip2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip2
            // 
            this.menuStrip2.Dock = System.Windows.Forms.DockStyle.None;
            this.menuStrip2.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem1,
            this.ayudaToolStripMenuItem,
            this.salirToolStripMenuItem});
            this.menuStrip2.Location = new System.Drawing.Point(0, 0);
            this.menuStrip2.Name = "menuStrip2";
            this.menuStrip2.Size = new System.Drawing.Size(162, 24);
            this.menuStrip2.TabIndex = 0;
            this.menuStrip2.Text = "menuStrip2";
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem3});
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(60, 20);
            this.toolStripMenuItem1.Text = "Archivo";
            // 
            // toolStripMenuItem3
            // 
            this.toolStripMenuItem3.Name = "toolStripMenuItem3";
            this.toolStripMenuItem3.Size = new System.Drawing.Size(100, 22);
            this.toolStripMenuItem3.Text = "Abrir";
            this.toolStripMenuItem3.Click += new System.EventHandler(this.toolStripMenuItem3_Click);
            // 
            // ayudaToolStripMenuItem
            // 
            this.ayudaToolStripMenuItem.Name = "ayudaToolStripMenuItem";
            this.ayudaToolStripMenuItem.Size = new System.Drawing.Size(53, 20);
            this.ayudaToolStripMenuItem.Text = "Ayuda";
            this.ayudaToolStripMenuItem.Click += new System.EventHandler(this.ayudaToolStripMenuItem_Click);
            // 
            // salirToolStripMenuItem
            // 
            this.salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            this.salirToolStripMenuItem.Size = new System.Drawing.Size(41, 20);
            this.salirToolStripMenuItem.Text = "Salir";
            this.salirToolStripMenuItem.Click += new System.EventHandler(this.salirToolStripMenuItem_Click);
            // 
            // listBox1
            // 
            this.listBox1.DisplayMember = "Metodo.Firma";
            this.listBox1.Font = new System.Drawing.Font("Consolas", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBox1.FormattingEnabled = true;
            this.listBox1.ItemHeight = 15;
            this.listBox1.Location = new System.Drawing.Point(9, 20);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(348, 154);
            this.listBox1.TabIndex = 1;
            this.listBox1.SelectedIndexChanged += new System.EventHandler(this.cambioMetodoSeleccionado);
            // 
            // richTextBox1
            // 
            this.richTextBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.richTextBox1.BackColor = System.Drawing.Color.White;
            this.richTextBox1.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.richTextBox1.Font = new System.Drawing.Font("Consolas", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.richTextBox1.Location = new System.Drawing.Point(379, 70);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.ReadOnly = true;
            this.richTextBox1.Size = new System.Drawing.Size(860, 420);
            this.richTextBox1.TabIndex = 2;
            this.richTextBox1.Text = "";
            this.richTextBox1.Visible = false;
            this.richTextBox1.TextChanged += new System.EventHandler(this.richTextBox1_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.label1.Location = new System.Drawing.Point(11, 528);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(188, 17);
            this.label1.TabIndex = 3;
            this.label1.Text = "Complejidad Ciclomática:";
            // 
            // lblCiclomatica
            // 
            this.lblCiclomatica.AutoSize = true;
            this.lblCiclomatica.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lblCiclomatica.ForeColor = System.Drawing.Color.Teal;
            this.lblCiclomatica.Location = new System.Drawing.Point(214, 528);
            this.lblCiclomatica.Name = "lblCiclomatica";
            this.lblCiclomatica.Size = new System.Drawing.Size(0, 17);
            this.lblCiclomatica.TabIndex = 4;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.label2.Location = new System.Drawing.Point(11, 559);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(185, 17);
            this.label2.TabIndex = 5;
            this.label2.Text = "Lineas con comentarios:";
            // 
            // lblComentarios
            // 
            this.lblComentarios.AutoSize = true;
            this.lblComentarios.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lblComentarios.ForeColor = System.Drawing.Color.Teal;
            this.lblComentarios.Location = new System.Drawing.Point(214, 559);
            this.lblComentarios.Name = "lblComentarios";
            this.lblComentarios.Size = new System.Drawing.Size(0, 17);
            this.lblComentarios.TabIndex = 6;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.label3.Location = new System.Drawing.Point(402, 528);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(58, 17);
            this.label3.TabIndex = 7;
            this.label3.Text = "Fan In:";
            // 
            // lblFanIn
            // 
            this.lblFanIn.AutoSize = true;
            this.lblFanIn.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lblFanIn.ForeColor = System.Drawing.Color.Teal;
            this.lblFanIn.Location = new System.Drawing.Point(533, 528);
            this.lblFanIn.Name = "lblFanIn";
            this.lblFanIn.Size = new System.Drawing.Size(0, 17);
            this.lblFanIn.TabIndex = 8;
            // 
            // lblFanOut
            // 
            this.lblFanOut.AutoSize = true;
            this.lblFanOut.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lblFanOut.ForeColor = System.Drawing.Color.Teal;
            this.lblFanOut.Location = new System.Drawing.Point(533, 559);
            this.lblFanOut.Name = "lblFanOut";
            this.lblFanOut.Size = new System.Drawing.Size(0, 17);
            this.lblFanOut.TabIndex = 10;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.label5.Location = new System.Drawing.Point(402, 559);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(71, 17);
            this.label5.TabIndex = 9;
            this.label5.Text = "Fan Out:";
            // 
            // lblLongitud
            // 
            this.lblLongitud.AutoSize = true;
            this.lblLongitud.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lblLongitud.ForeColor = System.Drawing.Color.Teal;
            this.lblLongitud.Location = new System.Drawing.Point(832, 528);
            this.lblLongitud.Name = "lblLongitud";
            this.lblLongitud.Size = new System.Drawing.Size(0, 17);
            this.lblLongitud.TabIndex = 12;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.label6.Location = new System.Drawing.Point(701, 528);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(76, 17);
            this.label6.TabIndex = 11;
            this.label6.Text = "Longitud:";
            // 
            // lblVolumen
            // 
            this.lblVolumen.AutoSize = true;
            this.lblVolumen.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lblVolumen.ForeColor = System.Drawing.Color.Teal;
            this.lblVolumen.Location = new System.Drawing.Point(832, 559);
            this.lblVolumen.Name = "lblVolumen";
            this.lblVolumen.Size = new System.Drawing.Size(0, 17);
            this.lblVolumen.TabIndex = 14;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.label8.Location = new System.Drawing.Point(701, 559);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(75, 17);
            this.label8.TabIndex = 13;
            this.label8.Text = "Volumen:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.label4.Location = new System.Drawing.Point(12, 30);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(457, 17);
            this.label4.TabIndex = 15;
            this.label4.Text = "Seleccione una clase y método de las listas para conocer sus métricas.";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // lblOperadores
            // 
            this.lblOperadores.AutoSize = true;
            this.lblOperadores.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lblOperadores.ForeColor = System.Drawing.Color.Teal;
            this.lblOperadores.Location = new System.Drawing.Point(832, 592);
            this.lblOperadores.Name = "lblOperadores";
            this.lblOperadores.Size = new System.Drawing.Size(0, 17);
            this.lblOperadores.TabIndex = 17;
            this.lblOperadores.Click += new System.EventHandler(this.label10_Click);
            // 
            // lbl99
            // 
            this.lbl99.AutoSize = true;
            this.lbl99.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold);
            this.lbl99.Location = new System.Drawing.Point(701, 592);
            this.lbl99.Name = "lbl99";
            this.lbl99.Size = new System.Drawing.Size(99, 17);
            this.lbl99.TabIndex = 16;
            this.lbl99.Text = "Operadores:";
            this.lbl99.Click += new System.EventHandler(this.label11_Click);
            // 
            // listBox2
            // 
            this.listBox2.Font = new System.Drawing.Font("Consolas", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBox2.FormattingEnabled = true;
            this.listBox2.ItemHeight = 15;
            this.listBox2.Location = new System.Drawing.Point(9, 21);
            this.listBox2.Name = "listBox2";
            this.listBox2.Size = new System.Drawing.Size(348, 64);
            this.listBox2.TabIndex = 18;
            this.listBox2.SelectedIndexChanged += new System.EventHandler(this.listBox2_SelectedIndexChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.listBox2);
            this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.groupBox1.Location = new System.Drawing.Point(5, 218);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(363, 94);
            this.groupBox1.TabIndex = 19;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Clases";
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // groupBox2
            // 
            this.groupBox2.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox2.Controls.Add(this.txtCodigo);
            this.groupBox2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.groupBox2.Location = new System.Drawing.Point(374, 49);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(871, 447);
            this.groupBox2.TabIndex = 20;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Código";
            this.groupBox2.Enter += new System.EventHandler(this.groupBox2_Enter);
            // 
            // txtCodigo
            // 
            this.txtCodigo.BackColor = System.Drawing.Color.White;
            this.txtCodigo.Dock = System.Windows.Forms.DockStyle.Fill;
            this.txtCodigo.Location = new System.Drawing.Point(3, 19);
            this.txtCodigo.Margin = new System.Windows.Forms.Padding(2);
            this.txtCodigo.Multiline = true;
            this.txtCodigo.Name = "txtCodigo";
            this.txtCodigo.ReadOnly = true;
            this.txtCodigo.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.txtCodigo.Size = new System.Drawing.Size(865, 425);
            this.txtCodigo.TabIndex = 3;
            // 
            // button1
            // 
            this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.button1.Location = new System.Drawing.Point(1003, 662);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(225, 38);
            this.button1.TabIndex = 21;
            this.button1.Text = "Generar informe";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.listBox3);
            this.groupBox3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.groupBox3.Location = new System.Drawing.Point(5, 49);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(363, 169);
            this.groupBox3.TabIndex = 20;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Archivos";
            this.groupBox3.Enter += new System.EventHandler(this.groupBox3_Enter);
            // 
            // listBox3
            // 
            this.listBox3.DisplayMember = "Archivo.Nombre";
            this.listBox3.Font = new System.Drawing.Font("Consolas", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBox3.FormattingEnabled = true;
            this.listBox3.ItemHeight = 15;
            this.listBox3.Location = new System.Drawing.Point(6, 19);
            this.listBox3.Name = "listBox3";
            this.listBox3.Size = new System.Drawing.Size(352, 139);
            this.listBox3.TabIndex = 24;
            this.listBox3.SelectedIndexChanged += new System.EventHandler(this.listBox3_SelectedIndexChanged);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.listBox1);
            this.groupBox4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.groupBox4.Location = new System.Drawing.Point(5, 319);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(363, 177);
            this.groupBox4.TabIndex = 20;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Métodos";
            this.groupBox4.Enter += new System.EventHandler(this.groupBox4_Enter);
            // 
            // Form1
            // 
            this.AccessibleName = "";
            this.ClientSize = new System.Drawing.Size(1264, 711);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.lblOperadores);
            this.Controls.Add(this.lbl99);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.lblVolumen);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.lblLongitud);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.lblFanOut);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.lblFanIn);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblComentarios);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lblCiclomatica);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuStrip2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.richTextBox1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip2;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Gestión de Testing - Grupo 5";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.menuStrip2.ResumeLayout(false);
            this.menuStrip2.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox4.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem archivoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem abrirToolStripMenuItem;
        private System.Windows.Forms.CheckedListBox checkedListBox1;
        private System.Windows.Forms.MenuStrip menuStrip2;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem3;
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.RichTextBox richTextBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblCiclomatica;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lblComentarios;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label lblFanIn;
        private System.Windows.Forms.Label lblFanOut;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lblLongitud;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label lblVolumen;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lblOperadores;
        private System.Windows.Forms.Label lbl99;
        private System.Windows.Forms.ListBox listBox2;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.ToolStripMenuItem ayudaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem salirToolStripMenuItem;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.ListBox listBox3;
        private System.Windows.Forms.TextBox txtCodigo;
        private System.Windows.Forms.GroupBox groupBox4;
    }
}

