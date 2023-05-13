
package cleaning_company;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;

public class WorkerFrame extends javax.swing.JFrame {

	transient Worker worker;
	Logger logger = Logger.getLogger(getClass().getName());
   
    public WorkerFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

    	javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        javax.swing.JToggleButton jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
        	
        	@Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown();
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "Name", "Desc", "Quantity", "Worker", "Status", "Address", "Clean Cost", "Delivery Cost", "Discount", "Total amount", "Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
        	
        	@Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown();
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Start work");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed();
            }
        });

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed();
            }
        });

        jToggleButton1.setText("Done");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed();
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "waiting", "in treatment", "complete" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jToggleButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed() {
        
        Product temp = getProductFromTable();
        if (temp != null) {
           
            String status = jComboBox1.getSelectedItem().toString();
            showOrders(status);
        }
        
        
        
    }

    private void jButton2ActionPerformed() {

        LoginJFrame f = new LoginJFrame();
        f.setVisible(true);
        this.dispose();
    }

    private void jTable1ComponentShown() {
    	// This default constructor is intentionally left empty
    }

    private void formComponentShown() {

        showOrders("all");
    }

    private void jToggleButton1ActionPerformed() {

        Product temp = getProductFromTable();
        if (temp != null) {
          
            String status = jComboBox1.getSelectedItem().toString();
            showOrders(status);
        }
        
        
    }

    private void jComboBox1ItemStateChanged() {

        String status = jComboBox1.getSelectedItem().toString();
        showOrders(status);
    }

  
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }

        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkerFrame().setVisible(true);
            }
        });
    }
    
    
    public void showOrders(String status) {
    	 
    	logger.info("showOrders");
        CleaningCompanyApp.loadUsers();
        
        DefaultTableModel tbmode1=(DefaultTableModel)jTable1.getModel();
        while(tbmode1.getRowCount() > 0){
            tbmode1.removeRow(0);
        }
        for (int i = 0; i < CleaningCompanyApp.products.size(); i++) {
            Product p1 = CleaningCompanyApp.products.get(i);
            if (p1.workerId == worker.id && (p1.status.equals(status)|| status.equals("all") )) {
                String[] tbData = CleaningCompanyApp.products.get(i).toArrayString(true);
                tbmode1.addRow(tbData);
            }
            
        }
    }
    
    public Product getProductFromTable() {
        int selRow = jTable1.getSelectedRow();
        logger.info(String.valueOf(selRow));
       
        Product product = null;
        if (selRow == -1) {
            JOptionPane.showMessageDialog(null,"Please select Product" );
            return null;
        }
        if (selRow > -1) {
            String productId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            product = CleaningCompanyApp.getProduct(Integer.parseInt(productId));
        }
        
        return product;
    }

   
    
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTable jTable1;
    
    
}
