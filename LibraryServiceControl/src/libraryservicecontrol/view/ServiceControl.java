package libraryservicecontrol.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import libraryservicecontrol.database.CategoriaDAO;
import libraryservicecontrol.database.ElementoDAO;
import libraryservicecontrol.database.HistoricoPrestamoDAO;
import libraryservicecontrol.database.UsuarioDAO;
import libraryservicecontrol.model.Categoria;
import libraryservicecontrol.model.Elemento;
import libraryservicecontrol.model.HistoricoPrestamo;
import libraryservicecontrol.model.Usuario;
import libraryservicecontrol.model.VistaTablaElemento;
import libraryservicecontrol.model.VistaTablaHistoricoPrestamo;
import libraryservicecontrol.model.VistaTablaUsuario;

public class ServiceControl extends javax.swing.JFrame {

    private Usuario usuario;
    private Usuario  usuarioConsultado;
    private List<Elemento> elementosConsultados;
    private List<HistoricoPrestamo> historicoUsuarioConsultado;
    private UsuarioDAO usuarioDao;
    private ElementoDAO elementoDao;
    private CategoriaDAO categoriaDao;
    private HistoricoPrestamoDAO historicoPrestamoDao;
    
    /**
     * Creates new form Admin
     */
    public ServiceControl() {
        initComponents();
    }
    
    /**
     * Creates new form Admin
     */
    public ServiceControl(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        lblNombreUsuario.setText(usuario.getNombreCompleto());
        usuarioDao = new UsuarioDAO();
        elementoDao = new ElementoDAO();
        categoriaDao = new CategoriaDAO();
        historicoPrestamoDao = new HistoricoPrestamoDAO();
        btnRegistrarUsuario.setVisible(false);
        tblUsuario.setVisible(false);
        tblHistoricoPrestamos.setVisible(false);
        tblDisponibles.setVisible(false);
        
        List<String> tiposDocumento = new ArrayList<String>();
        tiposDocumento.add("CEDULA");
        tiposDocumento.add("CEDULA EXTRANJERIA");
        tiposDocumento.add("TARJETA IDENTIDAD");
        selTipoDocumento.setModel(new DefaultComboBoxModel(tiposDocumento.toArray()));
        
        List<String> categorias = new ArrayList<String>();
        for(Categoria categoria : categoriaDao.buscarTodos()){
            categorias.add(categoria.getCategoria());
        }
        selCategoria.setModel(new DefaultComboBoxModel(categorias.toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        btnVolver1 = new javax.swing.JButton();
        lblConsultar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selTipoDocumento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        lblHistoricoPrestamos = new javax.swing.JLabel();
        lblDisponibilidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnRegistrarUsuario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistoricoPrestamos = new javax.swing.JTable();
        lblCategoria = new javax.swing.JLabel();
        selCategoria = new javax.swing.JComboBox();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnConsultarDisponibilidad = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDisponibles = new javax.swing.JTable();
        lblHistoricoPrestamosNoResultados = new javax.swing.JLabel();
        btnGuardarControlService = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("CONTROL DE SERVICIOS");

        lblNombreUsuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblNombreUsuario.setText("nombre_usuario");

        lblSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(102, 153, 255));
        lblSalir.setText("Salir");
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        btnVolver1.setText("Volver");
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        lblConsultar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblConsultar.setText("Consultar Usuario : ");

        jLabel2.setText("Tipo Documento ");

        selTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selTipoDocumentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Documento");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblHistoricoPrestamos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblHistoricoPrestamos.setText("Historico de Prestamos : ");

        lblDisponibilidad.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDisponibilidad.setText("Consultar Disponibilidad");

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUsuario);

        btnRegistrarUsuario.setText("Registrar Usuarios");
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        tblHistoricoPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHistoricoPrestamos);

        lblCategoria.setText("Categoria");

        selCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCodigo.setText("Código");

        lblNombre.setText("Nombre");

        btnConsultarDisponibilidad.setText("Consultar");
        btnConsultarDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDisponibilidadActionPerformed(evt);
            }
        });

        tblDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblDisponibles);

        lblHistoricoPrestamosNoResultados.setText("El usuario no tiene prestamos asociados");

        btnGuardarControlService.setText("Guardar");
        btnGuardarControlService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarControlServiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultar)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(lblSalir)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver1)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblDisponibilidad))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnRegistrarUsuario)
                                        .addGap(278, 278, 278))
                                    .addComponent(btnConsultarDisponibilidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(selTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblConsultar)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblHistoricoPrestamos)
                                            .addGap(47, 47, 47)
                                            .addComponent(lblHistoricoPrestamosNoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblCategoria)
                                            .addGap(18, 18, 18)
                                            .addComponent(selCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31)
                                            .addComponent(lblCodigo)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblNombre)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardarControlService, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblSalir))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(lblConsultar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarUsuario)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblHistoricoPrestamos)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblDisponibilidad)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(selCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultarDisponibilidad))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblHistoricoPrestamosNoResultados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarControlService)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        JOptionPane.showMessageDialog(this, "Acaba de cerrar sesión");
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        if(usuario != null){
            Adviser adviser = new Adviser(usuario);
            adviser.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        
        if(txtDocumento.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor ingrese un numero de documento");
            return ;
        }
        
        String tipoDocumento = (String)selTipoDocumento.getSelectedItem();
        String documento = txtDocumento.getText();
        usuarioConsultado = usuarioDao.buscarPorDocumento(tipoDocumento, documento);
        
        if(usuarioConsultado == null){
            JOptionPane.showMessageDialog(this, "No se encontraron registros");
            btnRegistrarUsuario.setVisible(true);
            tblUsuario.setVisible(false);
        }else{
            List<Usuario> usuarios = new ArrayList<Usuario>();
            usuarios.add(usuarioConsultado);
            VistaTablaUsuario vista = new VistaTablaUsuario(usuarios);
            tblUsuario.setModel(vista);
            btnRegistrarUsuario.setVisible(false);
            tblUsuario.setVisible(true);
            
            // Historico de restamos
            List<HistoricoPrestamo> historicos = historicoPrestamoDao.buscarPorUsuario(usuarioConsultado.getId());
            if(historicos.size() > 0){
                VistaTablaHistoricoPrestamo vistaHistorico = new VistaTablaHistoricoPrestamo(historicos);
                tblHistoricoPrestamos.setModel(vistaHistorico);
                tblHistoricoPrestamos.setVisible(true);
                lblHistoricoPrestamosNoResultados.setVisible(false);
            }else{
                lblHistoricoPrestamosNoResultados.setVisible(true);
                tblHistoricoPrestamos.setVisible(false);
            }
            
        }
        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void selTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selTipoDocumentoActionPerformed

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        UserRegister userRegister = null;
        if(usuario != null){
            userRegister = new UserRegister(usuario);
        }else{
            userRegister = new UserRegister();
        }
        userRegister.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void btnConsultarDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDisponibilidadActionPerformed
        
        String categoria = (String) selCategoria.getSelectedItem();
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        
        elementosConsultados = elementoDao
                        .buscarPorCategoriaCodigoNombre(categoria, codigo, nombre);
        
        if(elementosConsultados.size() > 0){
            VistaTablaElemento vista = new VistaTablaElemento(elementosConsultados);
            tblDisponibles.setModel(vista);
            tblDisponibles.setVisible(true);
            
            tblDisponibles.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                Integer seleccionado = tblDisponibles.getSelectedRow();
                if(seleccionado >= 0){
                    System.out.println(" Seleccion => " + tblDisponibles.getSelectedRow());
                    Boolean isAsignado = elementosConsultados.get(seleccionado).isAsignado();
                    elementosConsultados.get(seleccionado).setAsignado(!isAsignado);
                    VistaTablaElemento vista = new VistaTablaElemento(elementosConsultados);
                    tblDisponibles.setModel(vista);
                }
            }
            });
        }else{
            JOptionPane.showMessageDialog(this, "No se encontraron elementos disponibles");
            tblDisponibles.setVisible(false);
        }
        
    }//GEN-LAST:event_btnConsultarDisponibilidadActionPerformed

    private void btnGuardarControlServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarControlServiceActionPerformed
        
        if(usuarioConsultado == null
           || elementosConsultados == null
           ){
           JOptionPane.showMessageDialog(this, "Por favor consulte un usuario y asocie un Elemento");
           return ;
        }
        
        List<Elemento> elementosAsociados = new ArrayList<>();
        for(Elemento elemento : elementosConsultados){
            if(elemento.isAsignado()){
                elementosAsociados.add(elemento);
            }
        }
        
        if(elementosAsociados.size() == 0){
           JOptionPane.showMessageDialog(this, "Por favor asocie un elemento");
           return ;
        }
        
        Calendar fechaPrestamo = Calendar.getInstance();
        HistoricoPrestamo historico = new HistoricoPrestamo();
        historico.setUsuarioId(usuarioConsultado.getId());
        historico.setElementoId(elementosAsociados.get(0).getId());
        historico.setFechaPrestamo(new Date(fechaPrestamo.getTimeInMillis()));
        historico.setEstado("PRESTADO");
        
        if(historicoPrestamoDao.crearHistorico(historico)){
            JOptionPane.showMessageDialog(this, "Prestamo realizado exitosamente");
        }else{
            JOptionPane.showMessageDialog(this, "Ocurrio un error realizando el prestamo");
        }
        
    }//GEN-LAST:event_btnGuardarControlServiceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServiceControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceControl().setVisible(true);
            }
        });
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarDisponibilidad;
    private javax.swing.JButton btnGuardarControlService;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConsultar;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblHistoricoPrestamos;
    private javax.swing.JLabel lblHistoricoPrestamosNoResultados;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JComboBox selCategoria;
    private javax.swing.JComboBox selTipoDocumento;
    private javax.swing.JTable tblDisponibles;
    private javax.swing.JTable tblHistoricoPrestamos;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
