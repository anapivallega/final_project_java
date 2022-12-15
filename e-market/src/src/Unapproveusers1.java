/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import static src.Customer.jTable11;

import static src.category.jTable6;


/**
 *
 * @author 1styrGroupB
 */
public class Unapproveusers1 extends javax.swing.JFrame {

    /**
     * Creates new form Unapproveusers
     */
    public Unapproveusers1() {
        initComponents();
        Connect();
        disabled();
         dt();
        time();
//        toapproveuser();
    }
    
     public Unapproveusers1(String usernameu) {
        initComponents();
        juserun.setText(usernameu);
          Connect(); 
          disabled();
           dt();
        time();
    }
    
    public void disabled(){
        jname.setEnabled(false);
        jpassword.setEnabled(false);
        jemailid.setEnabled(false);
        jgender.setEnabled(false);
        jage.setEnabled(false);
        jrole.setEnabled(false);
        jphone.setEnabled(false);
        jdate.setEnabled(false);
           
        
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
    
     public static void AddRowToJcategoryTable(Object[] dataRow)   
     {
       DefaultTableModel model10 = (DefaultTableModel)jTable10.getModel(); 
       model10.addRow(dataRow);
     }
     
//      public static void AddRowToJapprovedTable(Object[] dataRow)   
//     {
//       DefaultTableModel model11 = (DefaultTableModel)jTable11.getModel(); 
//       model11.addRow(dataRow);
//     }
      
       public void dt() {

        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String dd = sdf.format(d);
        date1.setText(dd);
    }
    Timer t;
    SimpleDateFormat st;

    public void time() {
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                st = new SimpleDateFormat("hh-mm-ss a");
                String tt = st.format(dt);
                time1.setText(tt);

            }
        });
        t.start();
    }
      public void toapproveuser()
  {
      
      
       String username = jname.getText();
       String password = jpassword.getText();
       String email_id = jemailid.getText();
       String gender = jgender.getText();
       String age = jage.getText();
       String phone = jdate.getText();
        String dta = date1.getText();
     
       String role1;
       role1=jrole.getSelectedItem().toString();
      
//       String status;
//       status=jstatus.getSelectedItem().toString();
      
      try{
        
          String query ="insert into `registered_user`(username,password,email,phone_number,date,gender,age,role,status)values(?,?,?,?,?,?,?,?,?);";
          pst = con.prepareStatement(query);
          
          pst.setString(1, username);
          pst.setString(2, password);
          pst.setString(3, email_id);
           pst.setString(4, phone);
          pst.setString(5, dta);
          pst.setString(6, gender);
          
          pst.setString(7, age);
//          pst.setInt(5, Integer.valueOf(jage.getText()));
       
          pst.setString(8, role1);
          
      
          pst.setString(9, "Active");
          pst.executeUpdate();

          
          
          
          
//          pst.setString(1, username);
//          pst.setString(2, password);
//          pst.setString(3, email_id);
//          pst.setString(4, gender);
//          pst.setString(5, age);
////          pst.setInt(5, Integer.valueOf(jage.getText()));
//          pst.setString(6, role1);
//          pst.setString(7, status);
//          pst.executeUpdate();

//           int i=pst.executeUpdate();
           
            
//            JOptionPane.showMessageDialog(null, "inserted");
                  
//            else{
//                      JOptionPane.showMessageDialog(null, username+"  You are NOT! successfully registered as Admin User!" + "Failed with User id as Email id"+email_id); 
//                    }
          
      }catch(SQLException ex){
           Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, ex);
      }
  
  }
//    
        public void todecline()
  {
      
      
       String username = jname.getText();
       String password = jpassword.getText();
       String email_id = jemailid.getText();
       String gender = jgender.getText();
       String age = jage.getText();
       String phone = jdate.getText();
        String dta = date1.getText();
     
       String role1;
       role1=jrole.getSelectedItem().toString();
      
//       String status;
//       status=jstatus.getSelectedItem().toString();
      
      try{
        
          String query ="insert into `declined_registrants`(username,password,email,phone_number,date,gender,age,role,status)values(?,?,?,?,?,?,?,?,?);";
          pst = con.prepareStatement(query);
          
          pst.setString(1, username);
          pst.setString(2, password);
          pst.setString(3, email_id);
           pst.setString(4, phone);
          pst.setString(5, dta);
          pst.setString(6, gender);
          
          pst.setString(7, age);
//          pst.setInt(5, Integer.valueOf(jage.getText()));
       
          pst.setString(8, role1);
          
      
          pst.setString(9, "Active");
          pst.executeUpdate();

          
          
          
          
//          pst.setString(1, username);
//          pst.setString(2, password);
//          pst.setString(3, email_id);
//          pst.setString(4, gender);
//          pst.setString(5, age);
////          pst.setInt(5, Integer.valueOf(jage.getText()));
//          pst.setString(6, role1);
//          pst.setString(7, status);
//          pst.executeUpdate();

//           int i=pst.executeUpdate();
           
            
//            JOptionPane.showMessageDialog(null, "inserted");
                  
//            else{
//                      JOptionPane.showMessageDialog(null, username+"  You are NOT! successfully registered as Admin User!" + "Failed with User id as Email id"+email_id); 
//                    }
          
      }catch(SQLException ex){
           Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, ex);
      }
  
  }
 
       public void updateuserapplicant(){
        String sql ="select from `user_applicant`";
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
        public void todeclineusers(){
        String sql ="select from `user_applicant`";
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
       
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        japprove = new javax.swing.JButton();
        jremove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jemailid = new javax.swing.JTextField();
        jage = new javax.swing.JTextField();
        jgender = new javax.swing.JTextField();
        jname = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jrole = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jdate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jphone = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        juserun = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        date1 = new javax.swing.JTextField();
        time1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTable10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Username", "Password", "Email id", "phone", "date", "Gender", "Age", "Role"
            }
        ));
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable10MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable10);

        japprove.setBackground(new java.awt.Color(204, 255, 102));
        japprove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        japprove.setText("Approve");
        japprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                japproveActionPerformed(evt);
            }
        });

        jremove.setBackground(new java.awt.Color(204, 255, 102));
        jremove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jremove.setText("Remove");
        jremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jremoveActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Username");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Password");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Email ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Gender");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Age");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jemailid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jemailid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 170, 31));

        jage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 170, 32));

        jgender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 170, 32));

        jname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jnameMouseClicked(evt);
            }
        });
        jPanel3.add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 170, 30));

        jpassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpasswordMouseClicked(evt);
            }
        });
        jPanel3.add(jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 100, 170, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" User Data");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 6, -1, -1));

        jrole.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cashier", "Staff", "Supplier", "Buyer" }));
        jPanel3.add(jrole, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 170, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Role");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 170, 31));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Date");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jphone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 170, 31));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Phone");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 102));

        juserun.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        juserun.setForeground(new java.awt.Color(255, 0, 0));
        juserun.setText("Admin user");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Sign-out");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
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

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Home");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImageIcon_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(jLabel16)
                .addGap(90, 90, 90)
                .addComponent(jLabel15)
                .addGap(87, 87, 87)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(juserun, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(juserun, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Approve Users to Manage System");

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Date:");

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Time:");

        date1.setBackground(new java.awt.Color(51, 51, 51));
        date1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date1.setForeground(new java.awt.Color(204, 255, 204));
        date1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date1.setText("0");
        date1.setBorder(null);
        date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date1ActionPerformed(evt);
            }
        });

        time1.setBackground(new java.awt.Color(51, 51, 51));
        time1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        time1.setForeground(new java.awt.Color(204, 255, 204));
        time1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time1.setText("0");
        time1.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(japprove, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125)
                                .addComponent(jremove, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(japprove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jremove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(53, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1087, 685));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
        // TODO add your handling code here:
         int Myindex = jTable10.getSelectedRow();
         TableModel model2 = (TableModel) jTable10.getModel();
        
         int Mycolumn = jTable10.getSelectedColumn();
  
         String value = model2.getValueAt(Myindex, Mycolumn).toString();
       
//        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
   
        jname.setText(model2.getValueAt(Myindex, 1).toString());
        jpassword.setText(model2.getValueAt(Myindex, 2).toString());
        jemailid.setText(model2.getValueAt(Myindex, 3).toString());
        jphone.setText(model2.getValueAt(Myindex, 4).toString());
         jdate.setText(model2.getValueAt(Myindex, 5).toString());
        jgender.setText(model2.getValueAt(Myindex, 6).toString());
        jage.setText(model2.getValueAt(Myindex, 7).toString());
        
        String rolea =model2.getValueAt(Myindex, 8).toString();
        
        switch(rolea){
            case "Cashier":
                jrole.setSelectedIndex(0);
                break;
            case "Staff":
                jrole.setSelectedIndex(1);
                break;  
             case "Supplier":
                jrole.setSelectedIndex(2);
                break; 
              case "Buyer":
                jrole.setSelectedIndex(3);
                break; 
        }
        
//        String statusa = model2.getValueAt(Myindex, 7).toString();
//        switch(statusa){
//            case "Active":
//                jstatus.setSelectedIndex(0);
//                break;
//            case "Inactive":
//                jstatus.setSelectedIndex(1);
//                break;        
//        }
        
        
    }//GEN-LAST:event_jTable10MouseClicked

    private void japproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_japproveActionPerformed
        
        DefaultTableModel tbmodel = (DefaultTableModel)jTable10.getModel();
        if(jTable10.getSelectedRowCount() == 1){
          toapproveuser();
          JOptionPane.showMessageDialog(null, "Approved!");
        
          
          //      to remove approved applicants/registrants..  
        String role1;
        role1 = jrole.getSelectedItem().toString();

        int row = jTable10.getSelectedRow();

        String cell = jTable10.getModel().getValueAt(row, 0).toString();

        String sql = "DELETE FROM `user_applicant` where user_id= " + cell;

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, " New " + role1 + " Added!");
            updateuserapplicant();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();

            } catch (Exception e) {
            }
     
        
                
         DefaultTableModel model = (DefaultTableModel)jTable10.getModel();
         //delete row
         if(jTable10.getSelectedRowCount()==1){
             //if single row is selected then delete
              model.removeRow(jTable10.getSelectedRow());
              jname.setText("");
              jpassword.setText("");
              jemailid.setText("");
              jdate.setText("");
              jphone.setText("");
              jgender.setText("");
              jage.setText("");
              jrole.setSelectedIndex(0);
//              jstatus.setSelectedIndex(0);
         }
       }
      
           
       }else{
           if(jTable10.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Table is empty!");
           }else{
                    JOptionPane.showMessageDialog(null, "Please select a single row to delete!");
           }
       }
         


         
        
    }//GEN-LAST:event_japproveActionPerformed

    private void jremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jremoveActionPerformed
        // TODO add your handling code here:
         todecline();
        DefaultTableModel tbmodel = (DefaultTableModel) jTable10.getModel();
        if (jTable10.getSelectedRowCount() == 1) {
            
            String username = jname.getText();
            String role1;
            role1 = jrole.getSelectedItem().toString();
            int row = jTable10.getSelectedRow();
            String cell = jTable10.getModel().getValueAt(row, 0).toString();
            String sql = "DELETE FROM `user_applicant` where user_id= " + cell;

            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "You declined this user registration as  " + role1 + "   named    " + username + "!");
                todeclineusers();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (Exception e) {
                }

                DefaultTableModel model = (DefaultTableModel) jTable10.getModel();
                //delete row
                if (jTable10.getSelectedRowCount() == 1) {
                    //if single row is selected then delete
                    model.removeRow(jTable10.getSelectedRow());
                    jname.setText("");
                    jpassword.setText("");
                    jemailid.setText("");
                    jgender.setText("");
                    jdate.setText("");
                    jage.setText("");
                }
            }

        } else {
            if (jTable10.getSelectedRowCount() == 0) {
                //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Table is empty!");
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single row to delete!");
            }
        }

        
        
       
                
    }//GEN-LAST:event_jremoveActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        LoginUsers main = new  LoginUsers();
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        adduser admin = new adduser(juserun.getText());
        admin.show();
        dispose();

    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        adminpage admin = new adminpage(juserun.getText());
        admin.show();
        dispose();
        
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jnameMouseClicked
        // TODO add your handling code here:
        jname.setEnabled(false);
    }//GEN-LAST:event_jnameMouseClicked

    private void jpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpasswordMouseClicked
        // TODO add your handling code here:
        jpassword.setEnabled(false);
    }//GEN-LAST:event_jpasswordMouseClicked

    private void date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date1ActionPerformed

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
            java.util.logging.Logger.getLogger(Unapproveusers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unapproveusers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unapproveusers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unapproveusers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unapproveusers1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable10;
    public javax.swing.JTextField jage;
    private javax.swing.JButton japprove;
    public javax.swing.JTextField jdate;
    public javax.swing.JTextField jemailid;
    public javax.swing.JTextField jgender;
    public javax.swing.JTextField jname;
    public javax.swing.JPasswordField jpassword;
    public javax.swing.JTextField jphone;
    private javax.swing.JButton jremove;
    private javax.swing.JComboBox<String> jrole;
    public javax.swing.JLabel juserun;
    private javax.swing.JTextField time1;
    // End of variables declaration//GEN-END:variables
}
