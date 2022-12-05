/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static src.Unapproveusers.jTable10;
import static src.adminregistrants.jTable1;
import static src.inventorypersonregistrants.jTable3;
//import static src.cashierregistrants.jTable2;

/**
 *
 * @author 1styrGroupB
 */
public class cashierusers extends javax.swing.JFrame {

    /**
     * Creates new form cashierusers
     */
    public cashierusers() {
        initComponents();
        Connect();
    }
    
     public cashierusers(String username) {
        initComponents();
        Connect();
        jusername.setText(username);
    }
    
    public static void AddRowToJadminTable(Object[] dataRow)   
     {
       DefaultTableModel model1 = (DefaultTableModel)jTable1.getModel(); 
       model1.addRow(dataRow);
     }
     public static void AddRowToJcashierTable(Object[] dataRow)   
     {
       DefaultTableModel model1 = (DefaultTableModel)jTable12.getModel(); 
       model1.addRow(dataRow);
     }
     
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    DefaultTableModel df;
    
    public void Connect()
  {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/marketsystem", "root", "");
    } catch (ClassNotFoundException ex){
         Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (SQLException ex) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }
     public void cashieruser()
  {
      String username = jname.getText();
      String password = jpassword.getText();
//      String conpassword = jconfirmpassword.getText();
      String email_id = jemailid.getText();
      String gender = jgender.getText();
      String age = jage.getText();
      
      try{
          
          String query ="insert into `cashier_users`(Username,Password,Email_id,Gender,Age)values(?,?,?,?,?);";
          pst = con.prepareStatement(query);
          pst.setString(1, username);
          pst.setString(2, password);
          pst.setString(3, email_id);
          pst.setString(4, gender);
          pst.setString(5, age);
          pst.executeUpdate();

//           int i=pst.executeUpdate();
           
            
            JOptionPane.showMessageDialog(null,  username+"  has been successfully registered User as Cashier! " + "Successful with User id as Email id   "+email_id);
                  
//            else{
//                      JOptionPane.showMessageDialog(null, username+"  You are NOT! successfully registered as Admin User!" + "Failed with User id as Email id"+email_id); 
//                    }
          
      }catch(SQLException ex){
           Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
     
      public void deletecashierusers(){
        String sql ="select user_id, username, password, email, gender,age,status from `registered_user` where role='Cashier'";
        try{
            pst=con.prepareStatement(sql);
            rs = pst.executeQuery();
//            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
//           JOptionPane.showMessageDialog(null, e);
        }finally{
        try{
            rs.close();
            pst.close();
            
        }catch(Exception e){
            
        }
    }
    
      }
        public void cashiersupdate(){
       try{
           pst = con.prepareStatement("select user_id, username, password, email, gender,age,status from `registered_user` where role='Cashier'");
           rs = pst.executeQuery();
           
           ResultSetMetaData rsd = rs.getMetaData();
           int c;
           
           c = rsd.getColumnCount();
           DefaultTableModel de = (DefaultTableModel)jTable12.getModel();
           de.setRowCount(0);
           
           while(rs.next())
           {
               Vector v2 = new Vector();
               for(int i=1; i<=c; i++)
               {
                   v2.add(rs.getString("user_id"));
                   v2.add(rs.getString("username"));
                   v2.add(rs.getString("password"));
                   v2.add(rs.getString("email"));
                   v2.add(rs.getString("gender"));
                   v2.add(rs.getString("age"));
                   v2.add(rs.getString("status"));
                   
               }
               de.addRow(v2);
           }
       } catch (SQLException ex) {
            Logger.getLogger(inventorypage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jusername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jemailid = new javax.swing.JTextField();
        jage = new javax.swing.JTextField();
        jgender = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jstatus = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jclear = new javax.swing.JButton();
        jUpdate = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 102));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        jusername.setBackground(new java.awt.Color(255, 255, 102));
        jusername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jusername.setForeground(new java.awt.Color(204, 0, 0));
        jusername.setText("Username");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Home");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Add User Admin");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Sign-out");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Approve  New Users");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImageIcon_1.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(59, 59, 59)
                .addComponent(jLabel13)
                .addGap(50, 50, 50)
                .addComponent(jLabel15)
                .addGap(51, 51, 51)
                .addComponent(jLabel8)
                .addGap(92, 92, 92)
                .addComponent(jusername)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jusername)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel15)
                                .addComponent(jLabel13)
                                .addComponent(jLabel16))))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Username");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Email ID");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Gender");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Age");

        jemailid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jgender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jpassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cashier User Data");

        jstatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Status");

        jname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jgender, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jage, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jemailid, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jemailid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jgender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jTable12.setBackground(new java.awt.Color(204, 255, 153));
        jTable12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Username", "Password", "Email_id", "Gender", "Age", "Status"
            }
        ));
        jTable12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable12MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable12);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 610, 284));

        jclear.setBackground(new java.awt.Color(102, 102, 102));
        jclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jclear.setForeground(new java.awt.Color(153, 255, 102));
        jclear.setText("Clear");
        jclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jclearActionPerformed(evt);
            }
        });
        jPanel1.add(jclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 83, 33));

        jUpdate.setBackground(new java.awt.Color(102, 102, 102));
        jUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jUpdate.setForeground(new java.awt.Color(153, 255, 102));
        jUpdate.setText("Update");
        jUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, -1, 35));

        jDelete.setBackground(new java.awt.Color(102, 102, 102));
        jDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jDelete.setForeground(new java.awt.Color(153, 255, 102));
        jDelete.setText("Delete");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 510, 83, 34));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Cashier Users");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable12MouseClicked
        // TODO add your handling code here:
         jname.setEnabled(false);
          jpassword.setEnabled(false);
           jemailid.setEnabled(false);
            jgender.setEnabled(false);
             jage.setEnabled(false);
        int Myindex = jTable12.getSelectedRow();
        TableModel model2 = (TableModel) jTable12.getModel();

        int Mycolumn = jTable12.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();

//        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());

        jname.setText(model2.getValueAt(Myindex, 1).toString());
        jpassword.setText(model2.getValueAt(Myindex, 2).toString());
        jemailid.setText(model2.getValueAt(Myindex, 3).toString());
        jgender.setText(model2.getValueAt(Myindex, 4).toString());
        jage.setText(model2.getValueAt(Myindex, 5).toString());

        String statusa = model2.getValueAt(Myindex, 6).toString();
        switch(statusa){
            case "active":
            jstatus.setSelectedIndex(0);
            break;
            case "inactive":
            jstatus.setSelectedIndex(1);
            break;
        }
    

    }//GEN-LAST:event_jTable12MouseClicked

    private void jclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jclearActionPerformed
        // TODO add your handling code here:
        jname.setText("");
        jpassword.setText("");
//        jconfirmpassword.setText("");
        jemailid.setText("");
        jgender.setText("");
        jage.setText("");
    }//GEN-LAST:event_jclearActionPerformed

    private void jUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateActionPerformed
        // TODO add your handling code here:
    if(jTable12.getSelectedRowCount() == 1){
        DefaultTableModel model2 = (DefaultTableModel) jTable12.getModel();
        int Myindex = jTable12.getSelectedRow();
        int Mycolumn = jTable12.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();
        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
        String uname = jname.getText();
        String pass = jpassword.getText();
        String emai1 = jemailid.getText();
        String gend = jgender.getText();
        String agedd = jage.getText();
        String status;
        status = jstatus.getSelectedItem().toString();

        try{
            pst = con.prepareStatement("UPDATE registered_user set username= ?, password= ?, email= ?, gender= ?, age= ?, status= ? where user_id= ?");
            //
            pst.setString(1, uname );
            pst.setString(2, pass);
            pst.setString(3,emai1);
            pst.setString(4, gend);
            pst.setString(5, agedd);
              pst.setString(6, agedd);
            pst.setInt(7, id);

            int k= pst.executeUpdate();

            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "User Updated");
                jname.setText("");
                jpassword.setText("");
                jemailid.setText("");
                jgender.setText("");
                jage.setText("");
                jstatus.setSelectedIndex(0);
                jname.requestFocus();

                cashiersupdate();

//                jadd.setEnabled(true);

            }
        } catch (SQLException ex) {
            Logger.getLogger(inventorypage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
         else{
         
           if(jTable12.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty!");
           }
    }
    
   
    

    }//GEN-LAST:event_jUpdateActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        // TODO add your handling code here:
        
        if(jTable12.getSelectedRowCount() == 1){
        int row =jTable12.getSelectedRow();
        String cell = jTable12.getModel().getValueAt(row, 0).toString();
        String sql="DELETE FROM `registered_user` where user_id= " + cell;

        try{
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
            deletecashierusers();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                pst.close();
                rs.close();

            }catch (Exception e){
            }

            DefaultTableModel model = (DefaultTableModel)jTable12.getModel();
            //delete row
            if(jTable12.getSelectedRowCount()==1){
                //if single row is selected then delete
                model.removeRow(jTable12.getSelectedRow());
                jname.setText("");
                jpassword.setText("");
                jemailid.setText("");
                jgender.setText("");
                jage.setText("");
            }
        }
        }
         else{
         
           if(jTable12.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty!");
           }
    }
        
        
//        jadd.setEnabled(true);

    }//GEN-LAST:event_jDeleteActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        adminpage admin = new adminpage(jusername.getText());
        admin.show();
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:

        adduser admin = new adduser(jusername.getText());
        admin.show();
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        LoginUsers main = new  LoginUsers();
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:

        Unapproveusers cashregis = new Unapproveusers(jusername.getText());
        cashregis.show();
        dispose();

        try {
            Statement st1 = con.createStatement();
            String query1 = "select * from `user_applicant`";
            ResultSet rs1 = st1.executeQuery(query1);

            while(rs1.next()){
                //data wil added until finished..
                String bid = rs1.getString("user_id");
                String username1 = rs1.getString("username");
                String password1 = rs1.getString("password");
                String email_id1 = rs1.getString("email");
                String gender1 = rs1.getString("gender");
                String age1 = rs1.getString("age");
                String rol= rs1.getString("role");
                //                String sts = rs1.getString("status");

                //string array for store data into jtable..
                String tbData[] = {bid,username1,password1,email_id1,gender1,age1,rol};

                DefaultTableModel modelu = (DefaultTableModel)jTable10.getModel();

                //add string array data into jtable..

                modelu.addRow(tbData);

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:

        LoginUsers cashregis = new LoginUsers();
        cashregis.setVisible(true);
        cashregis.pack();
        cashregis.setLocationRelativeTo(null);
        cashregis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

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
            java.util.logging.Logger.getLogger(cashierusers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashierusers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashierusers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashierusers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashierusers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable12;
    private javax.swing.JButton jUpdate;
    public javax.swing.JTextField jage;
    private javax.swing.JButton jclear;
    public javax.swing.JTextField jemailid;
    public javax.swing.JTextField jgender;
    public javax.swing.JTextField jname;
    public javax.swing.JPasswordField jpassword;
    private javax.swing.JComboBox<String> jstatus;
    public javax.swing.JLabel jusername;
    // End of variables declaration//GEN-END:variables
}
