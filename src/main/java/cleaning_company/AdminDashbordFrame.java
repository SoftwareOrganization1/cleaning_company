
package cleaning_company;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AdminDashbordFrame extends javax.swing.JFrame {

    User user;
   
    public AdminDashbordFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jTabbedPane1.setName(""); 

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "Name", "Desc", "Quantity", "Worker", "Status", "Address", "Clean Cost", "Delivery Cost", "Discount", "Total amount", "Is Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton5.setText("Create invoice");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Set as paid");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "waiting", "in treatment", "complete", " " }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Orders", jPanel1);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Email", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Customers", jPanel2);

        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Email", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Workers", jPanel3);

        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Value"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("statistics", jPanel4);

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        AddEditCustomerDialog dialog = new AddEditCustomerDialog(this, rootPaneCheckingEnabled);
        dialog.setVisible(rootPaneCheckingEnabled);
        System.out.println(" the result" + dialog.result);
        if (dialog.result.equals("added")) {
            showCustomers();
        }
    }

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {
       
        showCustomers();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
        int selRow = jTable1.getSelectedRow();
        System.out.println(selRow);
        boolean found = false;
        Customer customer = null;
        if (selRow == -1) {
            JOptionPane.showMessageDialog(null,"Please select customer" );
        }
        if (selRow > -1) {
            String customer_id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            
            for (int i = 0; i < CleaningCompanyApp.customers.size(); i++) {
                Customer c1 = CleaningCompanyApp.customers.get(i);
                if (String.valueOf(c1.id).equals(customer_id)){
                   customer = c1;
                   found = true;
                   break;
                }
            }
        }
        
        if (found) {
            AddEditCustomerDialog dialog = new AddEditCustomerDialog(this, rootPaneCheckingEnabled);
            dialog.customer = customer;
            dialog.setVisible(true);
            System.out.println(" the result" + dialog.result);
            if (dialog.result.equals("updated")) {
                showCustomers();
            }
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        
        int selRow = jTable1.getSelectedRow();
        boolean found = false;
        if (selRow == -1) {
            JOptionPane.showMessageDialog(null,"Please select customer" );
        }
        
        int index = -1;
        if (selRow > -1) {
            String customer_id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            
            for (int i = 0; i < CleaningCompanyApp.customers.size(); i++) {
                Customer c1 = CleaningCompanyApp.customers.get(i);
                if (String.valueOf(c1.id).equals(customer_id)){
                   found = true;
                   index = i;
                   break;
                }
            }
        }
        if(found && JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this Customer", "confirm to delete", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
            CleaningCompanyApp.customers.remove(index);
            showCustomers();
        }
        
    }

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {
       
        showWorkers();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginJFrame f = new LoginJFrame();
        f.setVisible(true);
        this.dispose();
    }

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {
      
        
        String status = jComboBox1.getSelectedItem().toString();
        showOrders(status);
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        
        Product p = getProductFromTable();
        if (p != null) {
            if (p.price > 0) {
                JOptionPane.showMessageDialog(null,"This Order already hase invoice" );
                return;
            }
            InvoiceDialog iDialog = new InvoiceDialog(this, rootPaneCheckingEnabled);
            iDialog.p = p;
            iDialog.setVisible(true);
            showOrders("all");
        }
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        Product p = getProductFromTable();
        if (p !=null) {
             
        
            if (p.isPaid) {
                JOptionPane.showMessageDialog(null,"This Order already paid" );
                return;
            }

            Product temp = CleaningCompanyApp.paidOrder(p.id);
            if (temp.isPaid) {
                JOptionPane.showMessageDialog(null,"This Order mark as paid" );
            } else {
               JOptionPane.showMessageDialog(null,"Create Invocie first" ); 
            }

            showOrders("all");
        }
        
    }

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
        String status = jComboBox1.getSelectedItem().toString();
        showOrders(status);
    }

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {
        
        showStatistics();
        
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashbordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashbordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashbordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashbordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashbordFrame().setVisible(true);
            }
        });
    }
    
    public void showCustomers() {
        CleaningCompanyApp.loadUsers();
        
        DefaultTableModel tbmode1=(DefaultTableModel)jTable1.getModel();
        while(tbmode1.getRowCount() > 0){
            tbmode1.removeRow(0);
        }
        for (int i = 0; i < CleaningCompanyApp.customers.size(); i++) {
            String tbData[] = CleaningCompanyApp.customers.get(i).toArrayString();
            tbmode1.addRow(tbData);
        }
    }
    
    public void showStatistics() {
        CleaningCompanyApp.loadUsers();
        ArrayList<StatisticItem> statistics = CleaningCompanyApp.getStatistics();
        
        DefaultTableModel tbmode1=(DefaultTableModel)jTable4.getModel();
        while(tbmode1.getRowCount() > 0){
            tbmode1.removeRow(0);
        }
        for (int i = 0; i < statistics.size(); i++) {
            StatisticItem item = statistics.get(i);
            String tbData[] = {item.name, item.value};
            tbmode1.addRow(tbData);
        }
    }
    
    
    
    public void showWorkers() {
        CleaningCompanyApp.loadUsers();
        
        DefaultTableModel tbmode1=(DefaultTableModel)jTable3.getModel();
        while(tbmode1.getRowCount() > 0){
            tbmode1.removeRow(0);
        }
        for (int i = 0; i < CleaningCompanyApp.workers.size(); i++) {
            String tbData[] = CleaningCompanyApp.workers.get(i).toArrayString();
            tbmode1.addRow(tbData);
        }
    }
    
    public void showOrders(String status) {
        CleaningCompanyApp.loadUsers();
        
        DefaultTableModel tbmode1=(DefaultTableModel)jTable2.getModel();
        while(tbmode1.getRowCount() > 0){
            tbmode1.removeRow(0);
        }
        ArrayList<Product> orders =  CleaningCompanyApp.getOrderByStatus (status);
        for (int i = 0; i < orders.size(); i++) {
            String tbData[] = orders.get(i).toArrayString(true);
            tbmode1.addRow(tbData);
        }
    }
    
    public Product getProductFromTable() {
        int selRow = jTable2.getSelectedRow();
        System.out.println(selRow);
        boolean found = false;
        Product product = null;
        if (selRow == -1) {
            JOptionPane.showMessageDialog(null,"Please select Product" );
            return null;
        }
        if (selRow > -1) {
            String product_id = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
            product = CleaningCompanyApp.getProduct(Integer.parseInt(product_id));
            System.out.println(product.name);
        }
        
        return product;
    }
    
    

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
   
}
