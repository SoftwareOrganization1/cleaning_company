
package cleaning_company;

import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class LoginJFrame extends javax.swing.JFrame {
	
	String num="123123";
	String segoeUI="Segoe UI";
	private static final Logger logger = Logger.getLogger(LoginJFrame.class.getName());


    public LoginJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        
        jTextField1.setText("customer1@app.com");
        jPasswordField1.setText(num);
    }

   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

    	javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    	javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font(segoeUI, 0, 36)); 
        jLabel1.setText("Welcome");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font(segoeUI, 0, 18)); 
        jLabel2.setText("Email");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
        	
        	@Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked();
            }
        });

        jLabel3.setFont(new java.awt.Font(segoeUI, 0, 18)); 
        jLabel3.setText("Password");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
        	
        	@Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked();
            }
        });

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed();
            }
        });

        jButton2.setText("SignUp");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jPasswordField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(324, 324, 324))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed() {

        String email = jTextField1.getText();
        String password = new String(jPasswordField1.getPassword());
        
        Object result = CleaningCompanyApp.login(email, password);
        
        if (result == null) {
            JOptionPane.showMessageDialog(rootPane, "Invalid Email or Password");
        } else {
            String userType  = CleaningCompanyApp.getUserType(result);
            
            if (userType .equals("Customer")) {
                CustomerFrame cFrame = new CustomerFrame();
                cFrame.customer = (Customer) result;
                cFrame.setVisible(true);
            } else if (userType .equals("Admin")) {
                AdminDashbordFrame aFrame = new AdminDashbordFrame();
                aFrame.user = (User) result;
                aFrame.setVisible(true);
            } else {
                WorkerFrame aFrame = new WorkerFrame();
                aFrame.worker = (Worker) result;
                aFrame.setVisible(true);
            }
            this.dispose();
        }
        logger.info((String) result);

    }

    private void jButton2ActionPerformed() {

        SignUpFrame frame = new SignUpFrame();
        frame.setVisible(true);
        this.dispose();
    }

    private void jLabel2MouseClicked() {

        jTextField1.setText("admin@app.com");
        jPasswordField1.setText(num);
    }

    private void jLabel3MouseClicked() {

        jTextField1.setText("customer1@app.com");
        jPasswordField1.setText(num);
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
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }


    
    
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    
}
