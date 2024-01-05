/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.AutoControl;
import controlador.VendedorControl;
import controlador.VentaControl;
import controlador.listas.DynamicList;
import exeption.EmptyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.tablas.ModeloTablaAuto;
import vista.tablas.ModeloTablaVendedor;
import vista.tablas.ModeloTablaVenta;

/**
 *
 * @author darwi
 */
public class VentaAuto extends javax.swing.JFrame {

    private ModeloTablaAuto mta = new ModeloTablaAuto();
    private ModeloTablaVendedor mtv = new ModeloTablaVendedor();
    private ModeloTablaVenta mtv2 = new ModeloTablaVenta();

    private AutoControl autoControl = new AutoControl();
    private VendedorControl vendedorControl = new VendedorControl();
    private VentaControl ventaControl = new VentaControl();

    private void ordenarAuto() throws Exception {
        String criterio = cbxCritAuto.getSelectedItem().toString();
        Integer tipo = 0;
        if (btnTipoAuto.isSelected()) {
            tipo = 1;
        }
        try {
            long tiempoInicio = System.nanoTime();
            mta.setAutos(autoControl.ordenar(autoControl.getListAuto(), criterio, tipo));
            long tiempoFin = System.nanoTime();
            tbAuto.setModel(mta);
            tbAuto.updateUI();
            long tiempoTotal = tiempoFin - tiempoInicio;
            JOptionPane.showMessageDialog(rootPane, "Se ordenó correctamente, tiempo de ejecución: " + tiempoTotal + " milisegundos", "Detalle", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ordenarVendedor() throws Exception {
        String criterio = cbxCritVendedor.getSelectedItem().toString();
        Integer tipo = 0;
        if (btnTipoVendedor.isSelected()) {
            tipo = 1;
        }
        try {
            long tiempoInicio = System.nanoTime();
            mtv.setVendedores(vendedorControl.shell(vendedorControl.getListVendedor(), criterio, tipo));
            long tiempoFin = System.nanoTime();
            long tiempoTotal = tiempoFin - tiempoInicio;
            JOptionPane.showMessageDialog(rootPane, "Se ordenó correctamente, tiempo de ejecución: " + tiempoTotal + " milisegundos", "Detalle", JOptionPane.INFORMATION_MESSAGE);
            tbVendedor.setModel(mtv);
            tbVendedor.updateUI();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ordenarVeta() throws Exception {
        String criterio = cbxCritVenta.getSelectedItem().toString();
        Integer tipo = 0;
        if (jCheckBox3.isSelected()) {
            tipo = 1;
        }
        try {
            long tiempoInicio = System.nanoTime();
            mtv2.setVentas(ventaControl.shell(ventaControl.getListVenta(), criterio, tipo));
            long tiempoFin = System.nanoTime();
            long tiempoTotal = tiempoFin - tiempoInicio;
            JOptionPane.showMessageDialog(rootPane, "Se ordenó correctamente, tiempo de ejecución: " + tiempoTotal + " milisegundos", "Detalle", JOptionPane.INFORMATION_MESSAGE);
            tbVenta.setModel(mtv2);
            tbVenta.updateUI();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarAutoBinario() {
        String texto = txtTextoAuto.getText();
        String criterio = cbxCritBuscarAuto.getSelectedItem().toString();
        try {
            mta.setAutos(autoControl.busquedaBinaria(autoControl.getListAuto(), texto, criterio));
            tbAuto.setModel(mta);
            tbAuto.updateUI();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void buscarAutoLineal() {
        String texto = txtTextoAuto.getText();
        String criterio = cbxCritBuscarAuto.getSelectedItem().toString();
        try {
            mta.setAutos(autoControl.busquedaLineal(texto, autoControl.getListAuto(), criterio));
            tbAuto.setModel(mta);
            tbAuto.updateUI();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarVendedorLienal() {
        String texto = txtTextoVendedor.getText();
        String criterio = cbxBuscarVendedor.getSelectedItem().toString();
        try {
            mtv.setVendedores(vendedorControl.busquedaLineal(texto, vendedorControl.getListVendedor(), criterio));
            tbVendedor.setModel(mtv);
            tbVendedor.updateUI();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void buscarVendedorBinario() {
        String texto = txtTextoVendedor.getText();
        String criterio = cbxBuscarVendedor.getSelectedItem().toString();
        try {
            mtv.setVendedores(vendedorControl.busquedaBinaria(vendedorControl.getListVendedor(),texto , criterio));
            tbVendedor.setModel(mtv);
            tbVendedor.updateUI();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void buscarVentaBinaria() {
        String texto = txtVenta.getText();
        String criterio = cbxBuscarVenta.getSelectedItem().toString();
        try {
            mtv2.setVentas(ventaControl.busquedaBinaria(ventaControl.getListVenta(), texto, criterio));
            tbVenta.setModel(mtv2);
            tbVenta.updateUI();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void buscarVentaLienal() {
        String texto = txtVenta.getText();
        String criterio = cbxBuscarVenta.getSelectedItem().toString();
        try {
            mtv2.setVentas(ventaControl.busquedaLineal(texto, ventaControl.getListVenta(), criterio));
            tbVenta.setModel(mtv2);
            tbVenta.updateUI();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al ordenar", "NO SE PUDO ORDEAR", JOptionPane.ERROR_MESSAGE);
        }

    }
    

    public void cargarAutos(DynamicList autos) {
        mta.setAutos(autos);
        initComponents();
    }

    public void cargarVendedores(DynamicList vendedores) {
        mtv.setVendedores(vendedores);
        initComponents();
    }

    public void cargarVentas(DynamicList ventas) {
        mtv2.setVentas(ventas);
        initComponents();
    }

    public void cargarTabla() {
        mta.setAutos(autoControl.getListAuto());
        mtv.setVendedores(vendedorControl.getListVendedor());
        mtv2.setVentas(ventaControl.getListVenta());

        tbVendedor.setModel(mtv);
        tbAuto.setModel(mta);
        tbVenta.setModel(mtv2);

        tbVendedor.updateUI();
        tbVenta.updateUI();
        tbAuto.updateUI();
    }

    public VentaAuto() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAuto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxCritAuto = new javax.swing.JComboBox<>();
        btnOrdenarAuto = new javax.swing.JButton();
        btnTipoAuto = new javax.swing.JCheckBox();
        btnAgregarAuto = new javax.swing.JButton();
        txtTextoAuto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxCritBuscarAuto = new javax.swing.JComboBox<>();
        btnBuscarAuto = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnBuscarAutoLineal = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVendedor = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbxCritVendedor = new javax.swing.JComboBox<>();
        btnOrdenarVendedor = new javax.swing.JButton();
        btnTipoVendedor = new javax.swing.JCheckBox();
        btnAgregarVendedor = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbxBuscarVendedor = new javax.swing.JComboBox<>();
        txtTextoVendedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnBuscarVendedorLineal = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnBuscarVendedorBinario = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxCritVenta = new javax.swing.JComboBox<>();
        btnOrdenarVenta = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        btnAgregarVenta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtVenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbxBuscarVenta = new javax.swing.JComboBox<>();
        btnBuscarVentaLineal = new javax.swing.JButton();
        btnBuscarVentaBinaria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 51, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("VENTA DE AUTOS");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addGap(371, 371, 371)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(51, 51, 51));

        tbAuto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbAuto);

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("AUTOS");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Criterio:");

        cbxCritAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "PRECIO", "MARCA", "COLOR" }));

        btnOrdenarAuto.setText("Ordenar");
        btnOrdenarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarAutoActionPerformed(evt);
            }
        });

        btnTipoAuto.setText("Decendente");
        btnTipoAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoAutoActionPerformed(evt);
            }
        });

        btnAgregarAuto.setText("Agregar");
        btnAgregarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutoActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Texto:");

        cbxCritBuscarAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "PRECIO", "MARCA", "COLOR" }));

        btnBuscarAuto.setText("Buscar Binaria");
        btnBuscarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutoActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar por:");

        btnBuscarAutoLineal.setText("Busacar Lineal");
        btnBuscarAutoLineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutoLinealActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxCritAuto, 0, 120, Short.MAX_VALUE)
                                    .addComponent(txtTextoAuto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnTipoAuto)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnOrdenarAuto)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgregarAuto)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxCritBuscarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscarAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBuscarAutoLineal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxCritAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenarAuto)
                    .addComponent(btnTipoAuto)
                    .addComponent(btnAgregarAuto))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTextoAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbxCritBuscarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnBuscarAuto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarAutoLineal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setForeground(new java.awt.Color(51, 51, 51));

        tbVendedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbVendedor);

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("VENDEDORES");

        cbxCritVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "APELLIDO", "ID", "CEDULA", "CELULAR", "RUC" }));

        btnOrdenarVendedor.setText("Ordenar");
        btnOrdenarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarVendedorActionPerformed(evt);
            }
        });

        btnTipoVendedor.setText("Decendente");
        btnTipoVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoVendedorActionPerformed(evt);
            }
        });

        btnAgregarVendedor.setText("Agregar");
        btnAgregarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVendedorActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Criterio:");

        cbxBuscarVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "APELLIDO", "CEDULA", "RUC", "CELULAR" }));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar por:");

        btnBuscarVendedorLineal.setText("Busqueda Lineal");
        btnBuscarVendedorLineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVendedorLinealActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Texto:");

        btnBuscarVendedorBinario.setText("Busqueda Binaria");
        btnBuscarVendedorBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVendedorBinarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10)
                                .addGap(19, 19, 19)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTextoVendedor)
                                    .addComponent(cbxCritVendedor, 0, 140, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(btnTipoVendedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnOrdenarVendedor)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgregarVendedor))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscarVendedorLineal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBuscarVendedorBinario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(12, 12, 12))))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel12)
                    .addContainerGap(498, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCritVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenarVendedor)
                    .addComponent(btnTipoVendedor)
                    .addComponent(btnAgregarVendedor)
                    .addComponent(jLabel10))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTextoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cbxBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscarVendedorLineal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnBuscarVendedorBinario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(114, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addGap(98, 98, 98)))
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setForeground(new java.awt.Color(51, 51, 51));

        tbVenta.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        tbVenta.setForeground(new java.awt.Color(102, 102, 102));
        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tbVenta.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tbVenta.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setViewportView(tbVenta);

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("VENTAS");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Criterio:");

        cbxCritVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FECHA", "COMISION", "TOTAL", "ID_AUTO", "ID" }));

        btnOrdenarVenta.setText("Ordenar");
        btnOrdenarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarVentaActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Decendente");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        btnAgregarVenta.setText("Agregar");
        btnAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVentaActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Texto:");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Buscar por:");

        cbxBuscarVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FECHA", "ID_VENDEDOR", "ID_AUTO", "ID" }));

        btnBuscarVentaLineal.setText("Busqueda Lienal");
        btnBuscarVentaLineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaLinealActionPerformed(evt);
            }
        });

        btnBuscarVentaBinaria.setText("Busqueda Binaria");
        btnBuscarVentaBinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaBinariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxCritVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOrdenarVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregarVenta)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarVentaBinaria, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(btnBuscarVentaLineal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnBuscarVentaBinaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxCritVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOrdenarVenta)
                            .addComponent(btnAgregarVenta)
                            .addComponent(jCheckBox3)
                            .addComponent(cbxBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarVentaLineal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTipoAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTipoAutoActionPerformed

    private void btnTipoVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTipoVendedorActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed

    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void btnAgregarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutoActionPerformed
        new GuardarAuto().setVisible(true);
    }//GEN-LAST:event_btnAgregarAutoActionPerformed

    private void btnAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVentaActionPerformed
        try {
            new GuardarVenta().setVisible(true);
        } catch (EmptyException ex) {
            Logger.getLogger(VentaAuto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarVentaActionPerformed

    private void btnAgregarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVendedorActionPerformed
        new GuardarVendedor().setVisible(true);
    }//GEN-LAST:event_btnAgregarVendedorActionPerformed

    private void btnOrdenarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarAutoActionPerformed
        try {
            ordenarAuto();
        } catch (Exception ex) {
            Logger.getLogger(VentaAuto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOrdenarAutoActionPerformed

    private void btnOrdenarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarVendedorActionPerformed
        try {
            ordenarVendedor();
        } catch (Exception ex) {
            Logger.getLogger(VentaAuto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOrdenarVendedorActionPerformed

    private void btnOrdenarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarVentaActionPerformed
        try {
            ordenarVeta();
        } catch (Exception ex) {
            Logger.getLogger(VentaAuto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOrdenarVentaActionPerformed

    private void btnBuscarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutoActionPerformed
        buscarAutoBinario();
    }//GEN-LAST:event_btnBuscarAutoActionPerformed

    private void btnBuscarVendedorLinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVendedorLinealActionPerformed
        buscarVendedorLienal();
    }//GEN-LAST:event_btnBuscarVendedorLinealActionPerformed

    private void btnBuscarVentaLinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaLinealActionPerformed
        buscarVentaLienal();
    }//GEN-LAST:event_btnBuscarVentaLinealActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.dispose();
        new VentaAuto().setVisible(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarVentaBinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaBinariaActionPerformed
        buscarVentaBinaria();
    }//GEN-LAST:event_btnBuscarVentaBinariaActionPerformed

    private void btnBuscarVendedorBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVendedorBinarioActionPerformed
        buscarVendedorBinario();
    }//GEN-LAST:event_btnBuscarVendedorBinarioActionPerformed

    private void btnBuscarAutoLinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutoLinealActionPerformed
        buscarAutoLineal();
    }//GEN-LAST:event_btnBuscarAutoLinealActionPerformed

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
            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaAuto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarAuto;
    private javax.swing.JButton btnAgregarVendedor;
    private javax.swing.JButton btnAgregarVenta;
    private javax.swing.JButton btnBuscarAuto;
    private javax.swing.JButton btnBuscarAutoLineal;
    private javax.swing.JButton btnBuscarVendedorBinario;
    private javax.swing.JButton btnBuscarVendedorLineal;
    private javax.swing.JButton btnBuscarVentaBinaria;
    private javax.swing.JButton btnBuscarVentaLineal;
    private javax.swing.JButton btnOrdenarAuto;
    private javax.swing.JButton btnOrdenarVendedor;
    private javax.swing.JButton btnOrdenarVenta;
    private javax.swing.JCheckBox btnTipoAuto;
    private javax.swing.JCheckBox btnTipoVendedor;
    private javax.swing.JComboBox<String> cbxBuscarVendedor;
    private javax.swing.JComboBox<String> cbxBuscarVenta;
    private javax.swing.JComboBox<String> cbxCritAuto;
    private javax.swing.JComboBox<String> cbxCritBuscarAuto;
    private javax.swing.JComboBox<String> cbxCritVendedor;
    private javax.swing.JComboBox<String> cbxCritVenta;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbAuto;
    private javax.swing.JTable tbVendedor;
    private javax.swing.JTable tbVenta;
    private javax.swing.JTextField txtTextoAuto;
    private javax.swing.JTextField txtTextoVendedor;
    private javax.swing.JTextField txtVenta;
    // End of variables declaration//GEN-END:variables
}
