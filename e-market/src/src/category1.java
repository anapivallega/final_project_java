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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static src.Unapproveusers.jTable10;
import static src.cashierusers.jTable12;
//import static src.cashierregistrants.jTable2;
import static src.inventorypage.jTable4;
import static src.inventorypersonregistrants.jTable3;
import static src.soldadmin.jTable9;
import static src.soldproducts.jTable5;

/**
 *
 * @author 1styrGroupB
 */
public class category1 extends javax.swing.JFrame {

    /**
     * Creates new form category
     */
    public category1() {
        initComponents();
        
          Connect();
     availproducts();
     able();
    }
     public category1(String username) {
        initComponents();
          Connect();
     availproducts();
       able();
     jusername.setText(username);
    }
    
     public static void AddRowToJinventorypageTable(Object[] dataRow)   
     {
       DefaultTableModel model5 = (DefaultTableModel)jTable6.getModel(); 
       model5.addRow(dataRow);
     }
      public static void AddRowToJcategoryTable(Object[] dataRow)   
     {
       DefaultTableModel model6 = (DefaultTableModel)jTable6.getModel(); 
       model6.addRow(dataRow);
     }
     Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst9;
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
     public void updateproductsales(){
        String sql ="select from `products`";
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
     
      public void offeredproducts(){
          
          String price2 = "";
           try {
            Statement st = con.createStatement();
            String query1 = "select * from `offered_products`";
            ResultSet rs1 = st.executeQuery(query1);

            while(rs1.next()){
                //data wil added until finished..

                String bid = rs1.getString("product_id");
                String bookn = rs1.getString("product_name");
                String des = rs1.getString("description");
                String qty = rs1.getString("quantity");
                String price1 = rs1.getString("price");
                String tots = rs1.getString("total_amount");
                String image = rs1.getString("product_image");
                String sup = rs1.getString("supplier");

                //string array for store data into jtable..
                String tbData[] = {bid,bookn,des,qty,price1,price2,tots,image,sup};
                DefaultTableModel tblModel = (DefaultTableModel)jTable6.getModel();

                //add string array data into jtable..

                tblModel.addRow(tbData);
                
                
             

            }

//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      
      public void able(){
          
         String val = jchoose.getSelectedItem().toString();
           jdecline.setEnabled(false);
           jadd.setEnabled(false);
           
       
      }
     
     
      
      public void productapp() {
//
        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
       
        String timee = time.getText();
        String bname = jbname.getText();
        String desc = jdescription.getText();
        String buyingprice = jbuyprice.getText();
        String sellingprice = jsellprice.getText();
        String supp = jsupplier.getText();
        String img1 = jproduct1.getText();
        String cost = jtotalamountcost.getText();
//   
        try {
  
String query6 = "insert into `approved_products` (product_name,description,quantity,buyingprice,sellingprice,totalamount_cost,product_image,supplier)values(?,?,?,?,?,?,?,?);";
            pst = con.prepareStatement(query6, Statement.RETURN_GENERATED_KEYS);
            pst9 = con.prepareStatement(query6);   
            pst9.setString(1, bname);
            pst9.setString(2, desc);
            pst9.setInt(3, Integer.parseInt(jquantity.getText()));
            pst9.setString(4, buyingprice);
            pst9.setString(5, sellingprice);
             pst9.setString(6, cost);
            pst9.setString(7, img1);
            pst9.setString(8, supp);
            pst9.executeUpdate();
//            rs = pst.getGeneratedKeys();

            JOptionPane.showMessageDialog(this, "Offered product approve!");

        } catch (SQLException e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
//      
        }
    }
      
      public void productdec() {
//
        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
       
        String timee = time.getText();
        String bname = jbname.getText();
        String desc = jdescription.getText();
        String buyingprice = jbuyprice.getText();
        String sellingprice = jsellprice.getText();
        String supp = jsupplier.getText();
        String img1 = jproduct1.getText();
        String cost = jtotalamountcost.getText();
//   
        try {
  
String query6 = "insert into `decli` (product_name,description,quantity,price,totalamount_cost,product_image,supplier)values(?,?,?,?,?,?,?);";
            pst = con.prepareStatement(query6, Statement.RETURN_GENERATED_KEYS);
            pst9 = con.prepareStatement(query6);   
            pst9.setString(1, bname);
            pst9.setString(2, desc);
            pst9.setInt(3, Integer.parseInt(jquantity.getText()));
            pst9.setString(4, buyingprice);
    
             pst9.setString(5, cost);
            pst9.setString(6, img1);
            pst9.setString(7, supp);
            pst9.executeUpdate();
//            rs = pst.getGeneratedKeys();

            JOptionPane.showMessageDialog(this, "Offered product declined!");

        } catch (SQLException e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
//      
        }
    }
      
       public void availproducts(){
           try {
            Statement st = con.createStatement();
            String query1 = "select * from `products`";
            ResultSet rs1 = st.executeQuery(query1);

            while(rs1.next()){
                //data wil added until finished..

                String bid = rs1.getString("barcode");
                String bookn = rs1.getString("product_name");
                String des = rs1.getString("description");
                String qty = rs1.getString("quantity");
                String price1 = rs1.getString("buyingprice");
                String price2 = rs1.getString("sellingprice");
                String tots = rs1.getString("totalamount_cost");
                String image = rs1.getString("productImage");
                String sup = rs1.getString("supplier");

                //string array for store data into jtable..
                String tbData[] = {bid,bookn,des,qty,price1,price2,tots,image,sup};
                DefaultTableModel tblModel = (DefaultTableModel)jTable6.getModel();

                //add string array data into jtable..

                tblModel.addRow(tbData);

            }

//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
     }


      
     public void products(){
           try {
            Statement st = con.createStatement();
            String query1 = "select * from `products`";
            ResultSet rs1 = st.executeQuery(query1);

            while(rs1.next()){
                //data wil added until finished..

                String bid = rs1.getString("barcode");
                String bookn = rs1.getString("product_name");
                String des = rs1.getString("description");
                String qty = rs1.getString("quantity");
                String price1 = rs1.getString("buyingprice");
                String price2 = rs1.getString("sellingprice");
                String tots = rs1.getString("totalamount_cost");
                String image = rs1.getString("productImage");
                String sup = rs1.getString("supplier");

                //string array for store data into jtable..
                String tbData[] = {bid,bookn,des,qty,price1,price2,tots,image,sup};
                DefaultTableModel tblModel = (DefaultTableModel)jTable6.getModel();

                //add string array data into jtable..

                tblModel.addRow(tbData);

            }

//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void salesupdate(){
           try{
           pst = con.prepareStatement("select * from `products`");
           rs = pst.executeQuery();
           
           ResultSetMetaData rsd = rs.getMetaData();
           int c;
           
           c = rsd.getColumnCount();
           DefaultTableModel de = (DefaultTableModel)jTable6.getModel();
           de.setRowCount(0);
           
           while(rs.next())
           {
               Vector v2 = new Vector();
               for(int i=1; i<=c; i++)
               {
                   v2.add(rs.getString("barcode"));
                   v2.add(rs.getString("product_name"));
                   v2.add(rs.getString("buyingprice"));
                   v2.add(rs.getString("sellingprice"));
                     v2.add(rs.getString("description"));
                      v2.add(rs.getString("totalamount_cost"));
                   v2.add(rs.getString("productImage"));
                   v2.add(rs.getString("supplier"));
                   

                   
                   
               }
               de.addRow(v2);
           }
       } catch (SQLException ex) {
            Logger.getLogger(inventorypage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }
     
      public void updateproduct(){
        String sql ="select from `offered_products`";
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
        jdelete = new javax.swing.JButton();
        jupdate = new javax.swing.JButton();
        jexit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbuyprice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jquantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jproduct1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jphoto1 = new javax.swing.JLabel();
        jtotalamountcost = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdescription = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jsupplier = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jsellprice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jclear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jusername = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel67 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jchoose = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jadd = new javax.swing.JButton();
        jdecline = new javax.swing.JButton();
        jinput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jsold = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdelete.setBackground(new java.awt.Color(102, 102, 102));
        jdelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jdelete.setForeground(new java.awt.Color(153, 255, 102));
        jdelete.setText("Delete");
        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, 81, 35));

        jupdate.setBackground(new java.awt.Color(102, 102, 102));
        jupdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jupdate.setForeground(new java.awt.Color(153, 255, 102));
        jupdate.setText("Update");
        jupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdateActionPerformed(evt);
            }
        });
        jPanel1.add(jupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 83, 35));

        jexit.setBackground(new java.awt.Color(102, 102, 102));
        jexit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jexit.setForeground(new java.awt.Color(153, 255, 102));
        jexit.setText("Exit");
        jexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexitActionPerformed(evt);
            }
        });
        jPanel1.add(jexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, 75, 37));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jbuyprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 91, 181, 34));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buying Price");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 99, 91, -1));
        jPanel3.add(jquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 52, 181, 33));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Quantity");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 52, 91, 33));
        jPanel3.add(jbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 6, 181, 34));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Booke Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, -1, -1));
        jPanel3.add(jproduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 425, 278, 34));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Product");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 336, 59, -1));

        jphoto1.setBackground(new java.awt.Color(255, 255, 255));
        jphoto1.setOpaque(true);
        jPanel3.add(jphoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 323, 172, 90));
        jPanel3.add(jtotalamountcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 180, 34));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Total cost");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 88, -1));

        jdescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 223, 184, 32));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Description");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 229, 88, -1));

        jsupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 273, 181, 32));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Suppier");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 284, 88, 25));
        jPanel3.add(jsellprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 137, 180, 34));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Selling Price");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 145, 88, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 290, 480));

        jclear.setBackground(new java.awt.Color(102, 102, 102));
        jclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jclear.setForeground(new java.awt.Color(153, 255, 102));
        jclear.setText("Clear");
        jclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jclearActionPerformed(evt);
            }
        });
        jPanel1.add(jclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, -1, 33));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Available Product/Sales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jPanel6.setBackground(new java.awt.Color(204, 255, 102));

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

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Approval for users");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jusername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jusername.setForeground(new java.awt.Color(255, 0, 0));
        jusername.setText("User Name");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImageIcon_1.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel17)
                .addGap(79, 79, 79)
                .addComponent(jLabel18)
                .addGap(143, 143, 143)
                .addComponent(jusername)
                .addGap(35, 35, 35))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jusername)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 90));

        jTable6.setBackground(new java.awt.Color(204, 255, 153));
        jTable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Description", "Quatity", "Buying Price", "Sellintg Price", "TotalamountCost", "Image", "Supplier"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(6).setResizable(false);
            jTable6.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 670, 263));

        jPanel67.setBackground(new java.awt.Color(51, 51, 51));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Date:");

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Time:");

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

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        jchoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available Products", "Offered Products" }));
        jPanel1.add(jchoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 190, 40));

        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, 40));

        jadd.setBackground(new java.awt.Color(102, 102, 102));
        jadd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jadd.setForeground(new java.awt.Color(153, 255, 102));
        jadd.setText("Approve");
        jadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaddActionPerformed(evt);
            }
        });
        jPanel1.add(jadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 550, 110, 37));

        jdecline.setBackground(new java.awt.Color(102, 102, 102));
        jdecline.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jdecline.setForeground(new java.awt.Color(153, 255, 102));
        jdecline.setText("Decline");
        jdecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeclineActionPerformed(evt);
            }
        });
        jPanel1.add(jdecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 110, 37));

        jinput.setText("Search for products....");
        jinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jinputActionPerformed(evt);
            }
        });
        jPanel1.add(jinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 180, 40));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, -1, 40));

        jsold.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jsold.setForeground(new java.awt.Color(255, 204, 153));
        jsold.setText("Sold Products");
        jsold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsoldMouseClicked(evt);
            }
        });
        jPanel1.add(jsold, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeleteActionPerformed
        // TODO add your handling code here:
     if(jTable6.getSelectedRowCount() == 1){
        int row =jTable6.getSelectedRow();
        String cell = jTable6.getModel().getValueAt(row, 0).toString();
        String sql="DELETE FROM `products` where barcode= " + cell;

        try{

            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
            updateproductsales();

        }catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }finally{
            try{
                pst.close();
                rs.close();

            }catch (Exception e){
            }

            DefaultTableModel model = (DefaultTableModel)jTable6.getModel();
            //delete row
            if(jTable6.getSelectedRowCount()==1){
                //if single row is selected then delete
                model.removeRow(jTable6.getSelectedRow());
                jbname.setText("");
                jquantity.setText("");
                jbuyprice.setText("");
       
        }
        }
     } 
         else{
         
           if(jTable6.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty!");
           }else 
                   {
                    JOptionPane.showMessageDialog(null, "Please select a single row to delete!");
           }
       }
        
    }//GEN-LAST:event_jdeleteActionPerformed

    private void jupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdateActionPerformed
        // TODO add your handling code here:
         if(jTable6.getSelectedRowCount() == 1){
        DefaultTableModel model2 = (DefaultTableModel) jTable6.getModel();
        int Myindex = jTable6.getSelectedRow();
        int Mycolumn = jTable6.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();
        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
        String bname = jbname.getText();
        String qty = jquantity.getText();
        String bprice = jbuyprice.getText();
        String sprice = jtotalamountcost.getText();
        String des = jdescription.getText();
        String imgl = jproduct1.getText();
  

        try{
            pst = con.prepareStatement("UPDATE `products` set product_name= ?, quantity= ?, buyingprice= ?,sellingprice= ?,description= ?,productImage= ? where barcode= ?");
            //
            pst.setString(1, bname);
            pst.setString(2, qty);
            pst.setString(3,bprice);
            pst.setString(4,sprice);
            pst.setString(5,des);
            pst.setString(6,imgl);
            pst.setInt(7, id);

            int k= pst.executeUpdate();

            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Successfully Updated");
                jbname.setText("");
                 jsupplier.setText("");
                jquantity.setText("");
                  jphoto1.setText("");
                jbuyprice.setText("");
                jtotalamountcost.setText("");
                 jdescription.setText("");
                 jproduct1.setText("");
                jbname.requestFocus();

                salesupdate();
//               invetorytransacupdate();
            }  
               
        } catch (SQLException ex) {
            Logger.getLogger(inventorypage.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         else{
         
           if(jTable6.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty!");
           }
    }
     
    }//GEN-LAST:event_jupdateActionPerformed

    private void jexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jexitActionPerformed

    private void jclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jclearActionPerformed
        // TODO add your handling code here:
        jbname.setText("");
        jquantity.setText("");
        jtotalamountcost.setText("");
        jbuyprice.setText("");
        jdescription.setText("");
        jproduct1.setText("");
        jphoto1.setText("");
        jsupplier.setText("");
    }//GEN-LAST:event_jclearActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        adminpage admin = new adminpage(jusername.getText());
        admin.show();
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

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:

       
        DefaultTableModel model2 = (DefaultTableModel) jTable6.getModel();
//          InputStream is=new FileInputStream(new File(photopath));
//          pst.setBlob(5, is);
        int Myindex = jTable6.getSelectedRow();
        int Mycolumn = jTable6.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();
        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
        jbname.setText(model2.getValueAt(Myindex, 1).toString());
          jdescription.setText(model2.getValueAt(Myindex, 2).toString());
        jquantity.setText(model2.getValueAt(Myindex, 3).toString());
        jbuyprice.setText(model2.getValueAt(Myindex, 4).toString());
        jtotalamountcost.setText(model2.getValueAt(Myindex, 6).toString());
        jsellprice.setText(model2.getValueAt(Myindex, 5).toString());
      
        jproduct1.setText(model2.getValueAt(Myindex, 7).toString());
        
        jsupplier.setText(model2.getValueAt(Myindex, 8).toString());
         
        //        byte[] img =
    }//GEN-LAST:event_jTable6MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:

        Unapproveusers admin = new Unapproveusers(jusername.getText());
        admin.show();
        dispose();

        try {
            Statement st = con.createStatement();
            String query1 = "select * from `user_applicant`";
            ResultSet rs1 = st.executeQuery(query1);

            while(rs1.next()){
                //data wil added until finished..
                String bid = rs1.getString("user_id");
                String username1 = rs1.getString("username");
                String password1 = rs1.getString("password");
                String email_id1 = rs1.getString("email");
                String phone = rs1.getString("phone_number");
                String dts = rs1.getString("date");
                String gen= rs1.getString("gender");
                String ag= rs1.getString("age");
                String ro= rs1.getString("role");
                String sta= rs1.getString("status");
                
                String tbData[] = {bid,username1,password1,email_id1,phone,dts,gen,ag,ro,sta};

                DefaultTableModel modelu = (DefaultTableModel)jTable10.getModel();

                //add string array data into jtable..

                modelu.addRow(tbData);

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        LoginUsers cashregis = new  LoginUsers();
        cashregis.setVisible(true);
        cashregis.pack();
        cashregis.setLocationRelativeTo(null);
        cashregis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

     DefaultTableModel df = (DefaultTableModel)jTable6.getModel();
      df.setRowCount(0);
         try{
             
          
             
//             String st = jchoose.getSelectedItem().toString();
       if (jchoose.getSelectedIndex() == 0) {
         availproducts();
            jadd.setEnabled(false);
              jupdate.setEnabled(true);
              jdelete.setEnabled(true);
             jdecline.setEnabled(false);
          
          
        }else if(jchoose.getSelectedIndex() == 1) {
          offeredproducts();
            jadd.setEnabled(true);
              jdecline.setEnabled(true);
              jupdate.setEnabled(false);
           jdelete.setEnabled(false);
           
        }
           
            
      
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
         
         
       
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaddActionPerformed
        // TODO add your handling code here:
        
        String sellingprice = jsellprice.getText();

        if (sellingprice.equals("")) {
            JOptionPane.showMessageDialog(null, "You forgot to put selling price!");
        } else {

            productapp();

            int row = jTable6.getSelectedRow();

            String cell = jTable6.getModel().getValueAt(row, 0).toString();

            String sql = "DELETE FROM `offered_products` where product_id= " + cell;

            try {
                pst = con.prepareStatement(sql);
                pst.execute();

                updateproduct();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (Exception e) {
                }

                DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
                //delete row
                if (jTable6.getSelectedRowCount() == 1) {
                    //if single row is selected then delete
                    model.removeRow(jTable6.getSelectedRow());
                    jbname.setText("");
                    jbuyprice.setText("");
                    jquantity.setText("");
                    jsellprice.setText("");
                    jproduct1.setText("");
                    jdescription.setText("");
                    jsupplier.setText("");
                    jtotalamountcost.setText("");
                } else {
                    if (jTable6.getSelectedRowCount() == 0) {
                        //if table is empty np data the show message..
                        JOptionPane.showMessageDialog(null, "Table is empty!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No row selected!");

                    }
                }
            }
        }


    }//GEN-LAST:event_jaddActionPerformed

    private void jdeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeclineActionPerformed
        // TODO add your handling code here:
        productdec();
        
         int row = jTable6.getSelectedRow();

            String cell = jTable6.getModel().getValueAt(row, 0).toString();

            String sql = "DELETE FROM `offered_products` where product_id= " + cell;

            try {
                pst = con.prepareStatement(sql);
                pst.execute();

                updateproduct();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (Exception e) {
                }

                DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
                //delete row
                if (jTable6.getSelectedRowCount() == 1) {
                    //if single row is selected then delete
                    model.removeRow(jTable6.getSelectedRow());
                    jbname.setText("");
                    jbuyprice.setText("");
                    jquantity.setText("");
                    jsellprice.setText("");
                    jproduct1.setText("");
                    jdescription.setText("");
                    jsupplier.setText("");
                    jtotalamountcost.setText("");
                } else {
                    if (jTable6.getSelectedRowCount() == 0) {
                        //if table is empty np data the show message..
                        JOptionPane.showMessageDialog(null, "Table is empty!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No row selected!");

                    }
                }
            }
        


        
        
    }//GEN-LAST:event_jdeclineActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
          String st = jinput.getText();
          
          
         
        DefaultTableModel model = (DefaultTableModel)jTable6.getModel();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(model);
        jTable6.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(st.trim()));
        
//       if(!st.equals(tr)){
//             JOptionPane.showMessageDialog(null, "Seach not found!");
//       }else{
//            JOptionPane.showMessageDialog(null, "You've search for " + st);
//       }
//        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jinputActionPerformed

    private void jsoldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsoldMouseClicked
        // TODO add your handling code here:
        soldadmin admin = new soldadmin(jusername.getText());
        admin.show();
        dispose();

        try {
            Statement st = con.createStatement();
            String query1 = "select * from `sales_products`";
            ResultSet rs1 = st.executeQuery(query1);

            while(rs1.next()){
                //data wil added until finished..
                String bid2 = rs1.getString("id");
                String salesid2 = rs1.getString("sales_id");
                String bookn2 = rs1.getString("product_name");
                String buying = rs1.getString("buyingprice");
                String price2 = rs1.getString("price");
                String qty2 = rs1.getString("quantity");
                String totl2 = rs1.getString("total");
                String dae = rs1.getString("date");
                String usr2 = rs1.getString("userid");
                String sup = rs1.getString("supplier");
                //string array for store data into jtable..
                String tbData[] = {bid2,salesid2,bookn2,buying,price2,qty2,totl2,dae,usr2,sup};
                DefaultTableModel tabledata = (DefaultTableModel)jTable9.getModel();

                //add string array data into jtable..

                tabledata.addRow(tbData);

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jsoldMouseClicked
  
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
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(category1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new category1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable6;
    private javax.swing.JButton jadd;
    private javax.swing.JTextField jbname;
    private javax.swing.JTextField jbuyprice;
    private javax.swing.JComboBox<String> jchoose;
    private javax.swing.JButton jclear;
    private javax.swing.JButton jdecline;
    private javax.swing.JButton jdelete;
    private javax.swing.JTextField jdescription;
    private javax.swing.JButton jexit;
    private javax.swing.JTextField jinput;
    private javax.swing.JLabel jphoto1;
    private javax.swing.JTextField jproduct1;
    private javax.swing.JTextField jquantity;
    private javax.swing.JTextField jsellprice;
    private javax.swing.JLabel jsold;
    private javax.swing.JTextField jsupplier;
    private javax.swing.JTextField jtotalamountcost;
    private javax.swing.JButton jupdate;
    public javax.swing.JLabel jusername;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
