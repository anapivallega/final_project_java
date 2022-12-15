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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import static src.Unapproveusers.jTable10;
import static src.category.jTable6;

import static src.inventorypage.jTable4;
import static src.inventorypersonregistrants.jTable3;
import static src.soldadmin.jTable9;

/**
 *
 * @author 1styrGroupB
 */
public class soldproducts1 extends javax.swing.JFrame {

    /**
     * Creates new form soldproducts
     */
    public soldproducts1() {
        initComponents();
        Connect();
//        salesupdated();
          dt();
          time();
    }
    
     public soldproducts1(String username2) {
        initComponents();
        jusername2.setText(username2);
          Connect();
           dt();
        time();
    }
    
    
    public static void AddRowToJsoldproductTable(Object[] dataRow)   
     {
       DefaultTableModel model5 = (DefaultTableModel)jTable5.getModel(); 
       model5.addRow(dataRow);
     }
     public static void AddRowToJinventorypageTable(Object[] dataRow)   
     {
       DefaultTableModel model5 = (DefaultTableModel)jTable4.getModel(); 
       model5.addRow(dataRow);
     }
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    ResultSet rs6;
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
     public void updatesoldproducts(){
        String sql ="select from `sales_products`";
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
//   
     public void salesupdated(){
           try{
           pst = con.prepareStatement("select * from `sales_products`");
           rs = pst.executeQuery();
           
           ResultSetMetaData rsd = rs.getMetaData();
           int c;
           
           c = rsd.getColumnCount();
           DefaultTableModel de = (DefaultTableModel)jTable5.getModel();
           de.setRowCount(0);
           
           while(rs.next())
           {
               Vector v2 = new Vector();
               for(int i=1; i<=c; i++)
               {
                  v2.add(rs.getString("product_id"));
                   v2.add(rs.getString("sales_id"));
                   v2.add(rs.getString("product_name"));
                   v2.add(rs.getString("buyingprice"));
                   v2.add(rs.getString("price"));
                   v2.add(rs.getString("quantity"));
                   v2.add(rs.getString("total"));
                     v2.add(rs.getString("userid"));
                       v2.add(rs.getString("supplier"));
                         v2.add(rs.getString("username"));
                   
                   
               }
               de.addRow(v2);
           }
       } catch (SQLException ex) {
            Logger.getLogger(inventorypage.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void dt(){
         
         Date d = new Date();
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         
         String dd = sdf.format(d);
         date.setText(dd);
     }
         Timer t;
         SimpleDateFormat st;
          public void time(){
              t = new Timer(0, new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e){
                      Date dt = new Date();
                      st = new SimpleDateFormat("hh-mm-ss a");
                      String tt =st.format(dt);
                      time.setText(tt);
                      
                  }
              });
                  t.start();    
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jusername2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jdelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtquantity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtotalbuying = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtsales = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jprofit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jsalesid = new javax.swing.JTextField();
        jbname = new javax.swing.JTextField();
        jprice = new javax.swing.JTextField();
        jquantity = new javax.swing.JTextField();
        junamee = new javax.swing.JTextField();
        jbuyp = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jtotal = new javax.swing.JTextField();
        juserid = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jsupplier = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Sold Products");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 255, 102));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Home");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Sign-out");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jusername2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jusername2.setForeground(new java.awt.Color(255, 0, 0));
        jusername2.setText("User Name");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImageIcon_1.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel19)
                .addGap(38, 38, 38)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 900, Short.MAX_VALUE)
                .addComponent(jusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 98));

        jdelete.setBackground(new java.awt.Color(204, 255, 102));
        jdelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jdelete.setText("Delete ");
        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, 91, 37));

        jButton2.setBackground(new java.awt.Color(204, 255, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, 91, 37));

        jButton3.setBackground(new java.awt.Color(204, 255, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 91, 38));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Date:");

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Time:");

        date.setBackground(new java.awt.Color(51, 51, 51));
        date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(204, 255, 204));
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date.setText("0");
        date.setBorder(null);
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        time.setBackground(new java.awt.Color(51, 51, 51));
        time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        time.setForeground(new java.awt.Color(204, 255, 204));
        time.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time.setText("0");
        time.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 430, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Show Total");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 125, 33));

        jLabel22.setBackground(new java.awt.Color(255, 153, 102));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 102));
        jLabel22.setText("View Profit");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 105, 29));

        jtquantity.setBackground(new java.awt.Color(255, 255, 204));
        jtquantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtquantity.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 125, 34));

        jLabel11.setBackground(new java.awt.Color(255, 153, 51));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 102));
        jLabel11.setText("Total Quantity");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 128, 29));

        jtotalbuying.setBackground(new java.awt.Color(255, 255, 204));
        jtotalbuying.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtotalbuying.setForeground(new java.awt.Color(204, 0, 0));
        jtotalbuying.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtotalbuyingActionPerformed(evt);
            }
        });
        jPanel2.add(jtotalbuying, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 125, 34));

        jLabel21.setBackground(new java.awt.Color(255, 153, 51));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 255, 102));
        jLabel21.setText("Total Cost Sales");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 157, 29));

        jtsales.setBackground(new java.awt.Color(255, 255, 204));
        jtsales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtsales.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jtsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 125, 34));

        jLabel20.setBackground(new java.awt.Color(255, 153, 51));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 255, 102));
        jLabel20.setText("Net Profit");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 105, 29));

        jprofit.setBackground(new java.awt.Color(255, 255, 204));
        jprofit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jprofit.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jprofit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 126, 34));

        jLabel10.setBackground(new java.awt.Color(255, 153, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 102));
        jLabel10.setText("Total Sales Revenue");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 154, 29));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 330, 320));

        jTable5.setBackground(new java.awt.Color(204, 255, 153));
        jTable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sales Id", "Product Name", "totalcost", "Price ", "Quantity", "Total", "date", "userID", "supplier", "username"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable5);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 620, 309));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sales Id");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 75, 32));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Product Name");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 71, 90, 32));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Price");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 86, 36));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Quantity");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, 35));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Username");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 78, 34));

        jsalesid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jsalesid, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 15, 142, 38));

        jbname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 73, 142, 32));

        jprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 181, 142, 36));

        jquantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 142, 34));

        junamee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(junamee, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 142, 34));

        jbuyp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jbuyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 131, 142, 32));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Buying Price");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 137, -1, -1));

        jtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 142, 34));

        juserid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(juserid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 142, 34));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Total");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 78, 34));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("UserID");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 78, 34));

        jsupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 142, 34));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Supplier");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 78, 34));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 300, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1425, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        
        //how to set username(active user....
        inventorypage inventory = new inventorypage(jusername2.getText());
        inventory.show();
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        LoginUsers main = new  LoginUsers();
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeleteActionPerformed
        // TODO add your handling code here:
        
        if(jTable5.getSelectedRowCount() == 1){
        int row =jTable5.getSelectedRow();
        String cell = jTable5.getModel().getValueAt(row, 0).toString();
        String sql="DELETE FROM `sales_products` where product_id= " + cell;

        try{

            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
            updatesoldproducts();

        }catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }finally{
            try{
                pst.close();
                rs.close();

            }catch (Exception e){
            }

            DefaultTableModel model = (DefaultTableModel)jTable5.getModel();
            //delete row
            if(jTable5.getSelectedRowCount()==1){
                //if single row is selected then delete
                model.removeRow(jTable5.getSelectedRow());
                jsalesid.setText("");
                jbname.setText("");
                jprice.setText("");
                 jbuyp.setText("");
                jquantity.setText("");
                jtotal.setText("");
                 junamee.setText("");
                  juserid.setText("");
                   jsupplier.setText("");
                
                
              


            }
        }
        }
         else{
         
           if(jTable5.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty! Please select from the table!");
           }
    }
    }//GEN-LAST:event_jdeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     if(jTable5.getSelectedRowCount() == 1){
        DefaultTableModel model2 = (DefaultTableModel) jTable5.getModel();
        int Myindex = jTable5.getSelectedRow();
        int Mycolumn = jTable5.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();
        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
        String sa = jsalesid.getText();
        String na=  jbname.getText();
          String buyi=  jbuyp.getText();
        String pric = jprice.getText();
        String ty = jquantity.getText();
        String tal =jtotal.getText();
           String usename =junamee.getText();
              String usid =juserid.getText();
              String supp =jsupplier.getText();
               String dat =date.getText();

        try{
            pst = con.prepareStatement("UPDATE sales_products set sales_id= ?, product_name= ?, buyingprice= ?,price= ?, quantity= ?,  total= ?, date=?, userid=?, supplier=?, username=? where product_id= ?");
            //
            pst.setString(1, sa);
            pst.setString(2, na);
            pst.setString(3,buyi);
             pst.setString(4,pric);
            pst.setString(5,ty);
            pst.setString(6,tal);
             pst.setString(7,dat);
             pst.setString(8,usid);
              pst.setString(9,supp);
               pst.setString(10,usename);
            pst.setInt(11, id);

            int k= pst.executeUpdate();

            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Successfully Updated");
                 jsalesid.setText("");
                jbname.setText("");
                jprice.setText("");
                 jbuyp.setText("");
                jquantity.setText("");
                jtotal.setText("");
                 junamee.setText("");
                  juserid.setText("");
                   jsupplier.setText("");
                
                jbname.requestFocus();
                 jtotal.requestFocus();

                salesupdated();

            }
        } catch (SQLException ex) {
            Logger.getLogger(inventorypage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        else{
         
           if(jTable5.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty! Please select from the table!");
           }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:

        LoginUsers cashregis = new LoginUsers();
        cashregis.setVisible(true);
        cashregis.pack();
        cashregis.setLocationRelativeTo(null);
        cashregis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model2 = (DefaultTableModel) jTable5.getModel();
        int Myindex = jTable5.getSelectedRow();
        int Mycolumn = jTable5.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();

        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
        jsalesid.setText(model2.getValueAt(Myindex, 1).toString());
        jbname.setText(model2.getValueAt(Myindex, 2).toString());
        jbuyp.setText(model2.getValueAt(Myindex, 3).toString());
        jprice.setText(model2.getValueAt(Myindex, 4).toString());
        jquantity.setText(model2.getValueAt(Myindex, 5).toString());
        jtotal.setText(model2.getValueAt(Myindex, 6).toString());
        jtquantity.setText(model2.getValueAt(Myindex, 5).toString());
        jtotalbuying.setText(model2.getValueAt(Myindex, 3).toString());
        jtsales.setText(model2.getValueAt(Myindex, 4).toString());
        juserid.setText(model2.getValueAt(Myindex, 8).toString());
        jsupplier.setText(model2.getValueAt(Myindex, 9).toString());
        junamee.setText(model2.getValueAt(Myindex, 10).toString());

        jprofit.setText("");

    }//GEN-LAST:event_jTable5MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:

        int numrow = jTable5.getRowCount();
        double tot = 0;
        double tot1 = 0;
        double tot2 = 0;

        for (int i = 0; i<numrow; i++){
            double val2 = Double.valueOf(jTable5.getValueAt(i, 3).toString());
            double val = Double.valueOf(jTable5.getValueAt(i, 5).toString());
            double val1 = Double.valueOf(jTable5.getValueAt(i, 6).toString());
            tot += val;
            tot1 += val1;
            tot2 += val2;
        }
        jtquantity.setText(Double.toString(tot));
        jtsales.setText(Double.toString(tot1));
        jtotalbuying.setText(Double.toString(tot2));

      

    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:

        double cost = Double.parseDouble(jtotalbuying.getText());
        double revenue = Double.parseDouble(jtsales.getText());

        double totalprofit = revenue - cost;

        jprofit.setText(String.valueOf(totalprofit));
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jtotalbuyingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtotalbuyingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtotalbuyingActionPerformed

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
            java.util.logging.Logger.getLogger(soldproducts1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(soldproducts1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(soldproducts1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(soldproducts1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soldproducts1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable5;
    private javax.swing.JTextField jbname;
    private javax.swing.JTextField jbuyp;
    private javax.swing.JButton jdelete;
    private javax.swing.JTextField jprice;
    private javax.swing.JTextField jprofit;
    private javax.swing.JTextField jquantity;
    private javax.swing.JTextField jsalesid;
    private javax.swing.JTextField jsupplier;
    private javax.swing.JTextField jtotal;
    private javax.swing.JTextField jtotalbuying;
    private javax.swing.JTextField jtquantity;
    private javax.swing.JTextField jtsales;
    private javax.swing.JTextField junamee;
    private javax.swing.JTextField juserid;
    public javax.swing.JLabel jusername2;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
