/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

//import com.ibm.icu.util.Calendar;
//import com.ibm.icu.util.GregorianCalendar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static src.LoginUsers.id;
import static src.Unapproveusers.jTable10;

import static src.category.jTable6;
import static src.inventorypersonregistrants.jTable3;
import static src.soldadmin.jTable9;
import static src.soldproducts.jTable5;

/**
 *
 * @author 1styrGroupB
 */
public class inventorypage1 extends javax.swing.JFrame {

    String filename = null;
    byte[] product_image = null;

    public inventorypage1() {
        
         initComponents();

        Connect();
  
   
        dt();
        time();
    
     }
    
     public inventorypage1(String usernamee) {
        initComponents();
        jusernamee.setText(usernamee);
          Connect();
           dt();
        time();
     
    }
    
     
      public class flowers{
        int id;
        String name;
        public flowers(int id, String name)
        {
            this.id =id;
            this.name = name;
            
        }
        public String toString(){
            return name;
        }
    }
//    public void availflowers(){
//    try{
//        pst=con.prepareStatement("SELECT * FROM flowerslists");
//        rs = pst.executeQuery();
//        jflowers.removeAllItems();
//        
//        while (rs.next())
//        {
//            jflowers.addItem(new flowers(rs.getInt(1), rs.getString(2)));
//        }
//    }   catch (SQLException ex) {
//            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//}
 
//    public void display() {
//        try {
//            Statement st = con.createStatement();
//            String query1 = "select * from `approved_products`";
//            ResultSet rs1 = st.executeQuery(query1);
////         
////
//            while (rs1.next()) {
//                //data wil added until finished..
//                String id = rs1.getString("barcode");
//                String hh = rs1.getString("product_name");
//                String des1 = rs1.getString("description");
//                String trr = rs1.getString("quantity");
//                String buy = rs1.getString("buyingprice");
//                String sell1 = rs1.getString("sellingprice");
//                String pro = rs1.getString("productImage");
//
//                //string array for store data into jtable..
//                String tbData[] = {id,hh, des1, trr, buy, sell1, pro};
//                DefaultTableModel tblModel = (DefaultTableModel) jTable4.getModel();
//
//                //add string array data into jtable..
//                tblModel.addRow(tbData);
////
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(cashierusers.class.getName()).log(Level.SEVERE, null, ex);
//        }
////
//    }
      
      
      
      public void toadd() {
        try {
            Statement st = con.createStatement();
            String query1 = "select * from `approved_products`";
            ResultSet rs1 = st.executeQuery(query1);
//         
//
            while (rs1.next()) {
                //data wil added until finished..
                String id = rs1.getString("id");
                String hh = rs1.getString("product_name");
                String des1 = rs1.getString("description");
                String trr = rs1.getString("quantity");
                String buy = rs1.getString("buyingprice");
                String sell1 = rs1.getString("sellingprice");
                 String talm = rs1.getString("totalamount_cost");
                String pro = rs1.getString("product_image");
                String sup = rs1.getString("supplier");

                //string array for store data into jtable..
                String tbData[] = {id,hh, des1, trr, buy, sell1,talm, pro,sup};
                DefaultTableModel tblModel = (DefaultTableModel) jTable4.getModel();

                //add string array data into jtable..
                tblModel.addRow(tbData);
//
            }

        } catch (SQLException ex) {
            Logger.getLogger(cashierusers.class.getName()).log(Level.SEVERE, null, ex);
        }
//
    }
//
   
//     
     public void salesupdate(){
           try{
           pst = con.prepareStatement("select * from `products`");
           rs = pst.executeQuery();
           
           ResultSetMetaData rsd = rs.getMetaData();
           int c;
           
           c = rsd.getColumnCount();
           DefaultTableModel de = (DefaultTableModel)jTable4.getModel();
           de.setRowCount(0);
           
          
           while(rs.next())
           {
               Vector v2 = new Vector();
               for(int i=1; i<=c; i++)
               {
                   v2.add(rs.getString("barcode"));
                   v2.add(rs.getString("product_name"));
                   v2.add(rs.getString("description"));
                   v2.add(rs.getString("quantity"));
                   v2.add(rs.getString("buyingprice"));
                   v2.add(rs.getString("sellingprice"));
                   v2.add(rs.getString("totalamount_cost"));
                   v2.add(rs.getString("productImage"));
                   v2.add(rs.getString("supplier"));
                   
                   
                   
               }
               de.addRow(v2);
               
           }
       } catch (SQLException ex) {
            Logger.getLogger(inventorypage1.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    public static void AddRowToJcategoryTable(Object[] dataRow) {
        DefaultTableModel model6 = (DefaultTableModel) jTable6.getModel();
        model6.addRow(dataRow);
    }

    public static void AddRowToJsoldproductTable(Object[] dataRow) {
        DefaultTableModel model5 = (DefaultTableModel) jTable5.getModel();
        model5.addRow(dataRow);
    }

    Connection con;
    PreparedStatement pst;
    PreparedStatement pst9;
    PreparedStatement pst1;
    ResultSet rs;
    DefaultTableModel df;

//    inventorypage() {
//       inventorypage in = new inventorypage();
//       
//    }

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/marketsystem", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    String photopath = "";

    public ImageIcon resetImageSize(String photopath, byte[] photo) {
        ImageIcon myPhoto = null;
        if (photopath != null) {
            myPhoto = new ImageIcon(photopath);

        } else {
            myPhoto = new ImageIcon(photo);
        }
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(jproductimage.getWidth(), jproductimage.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon ph = new ImageIcon(img1);
        return ph;
    }

    public void updateproductsales() {
        String sql = "select from `products`";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
//            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
//           JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }
    }

    public void dt() {

        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String dd = sdf.format(d);
        date.setText(dd);
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
                time.setText(tt);

            }
        });
        t.start();
    }
    
    
//    public void choice(){
//        
//           jupdate.setEnabled(false);
//           jdelete.setEnabled(false);
//             
//           jdisplay.setEnabled(false);
//        }
//       

    public void product() {
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
         String tamount = jtotalamount.getText();
        String supp = jsupplier.getText();
        String img1 = jlinkimage.getText();
//   
        try {
  
String query6 = "insert into `products`(product_name,description,quantity,buyingprice,sellingprice,totalamount_cost,productImage,supplier)values(?,?,?,?,?,?,?,?);";
            pst9 = con.prepareStatement(query6, Statement.RETURN_GENERATED_KEYS);
            pst9 = con.prepareStatement(query6);   
            pst9.setString(1, bname);
            pst9.setString(2, desc);
            pst9.setInt(3, Integer.parseInt(jquantity.getText()));
            pst9.setString(4, buyingprice);
            pst9.setString(5, sellingprice);
             pst9.setString(6, tamount);
            pst9.setString(7, img1);
            pst9.setString(8, supp);
            pst9.executeUpdate();
//            rs = pst.getGeneratedKeys();

            JOptionPane.showMessageDialog(this, "Product Added");

        } catch (SQLException e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
//      
        }
    }
     public void productdispaly() {
//
        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
       
        String timee = time.getText();
        String bname = jbname.getText();
        String desc = jdescription.getText();
//        String pid = jid.getText();
  String tamount = jtotalamount.getText();
        String sellingprice = jsellprice.getText();
        String supp = jsupplier.getText();
        String img1 = jlinkimage.getText();
//   
        try {
  
String query6 = "insert into `product_display`(barcode, product_name,description,quantity,sellingprice,totalamount_cost,productImage,supplier)values(?,?,?,?,?,?,?,?);";
            pst = con.prepareStatement(query6, Statement.RETURN_GENERATED_KEYS);
            pst9 = con.prepareStatement(query6);  
            pst9.setInt(1, Integer.parseInt(jid.getText()));
            pst9.setString(2, bname);
            pst9.setString(3, desc);
            pst9.setInt(4, Integer.parseInt(jquantity.getText()));
            pst9.setString(5, sellingprice);
             pst9.setString(6, tamount);
            pst9.setString(7, img1);
            pst9.setString(8, supp);
            pst9.executeUpdate();
//            rs = pst.getGeneratedKeys();

            JOptionPane.showMessageDialog(this, "Product displayed");

        } catch (SQLException e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
//      
        }
    }
    
    

    //create a fuction to display image into jtable
    public void displayImage(String imgPath, JLabel label) {
        ImageIcon imgicon = new ImageIcon(imgPath);
        Image img = imgicon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }

    //insert into staff transaction.......
    public void invetorytransac() {

        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
        String timee = time.getText();
        String prod =  jbname.getText();
        String username = jusernamee.getText();
        String types = "Added Products";
         String supp = jsupplier.getText();
//         String qty = jquantity.getText();
//           double d = Double.parseDouble(qty);

        int damm = 0;

   String id = jTable4.getModel().getValueAt(jTable4.getModel().getRowCount() - 1, 0).toString();
        try {

             String query = "insert into transactions(InventoryID,quantity,type_transaction,UserID,date,time,username,role)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id));//inventory id
//            pst.setInt(2, Integer.parseInt(jquantity.getText()));
            pst.setDouble(2, Double.parseDouble(jquantity.getText()));
//            pst.setDouble(2, d);
            pst.setString(3, types);
//          pst.setString(4, new LoginUsers().id);//username id...
            pst.setInt(4, new LoginUsers().ID());
            pst.setString(5, date);
            pst.setString(6, timee);
            pst.setString(7, username);
             pst.setString(8, supp);
            pst.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
     
        }
    }
    
    
    
    public void getproduct(){
        
           DefaultTableModel df = (DefaultTableModel)jTable4.getModel();
             df.setRowCount(0);

            
            try {
            Statement st7 = con.createStatement();
            String query1 = "select * from `products`";
            ResultSet rs1 = st7.executeQuery(query1);

            while (rs1.next()) {
                //data wil added until finished..
              String id = rs1.getString("barcode");
                String hh = rs1.getString("product_name");
                String des1 = rs1.getString("description");
                String trr = rs1.getString("quantity");
                String buy = rs1.getString("buyingprice");
                String sell1 = rs1.getString("sellingprice");
                String tcost = rs1.getString("totalamount_cost");
                String pro = rs1.getString("productImage");
                 String supppl = rs1.getString("supplier");

                //string array for store data into jtable..
                String tbData[] = {id, hh, des1, trr, buy, sell1,tcost, pro,supppl};
                DefaultTableModel tblModel = (DefaultTableModel) jTable4.getModel();

                //add string array data into jtable..
                tblModel.addRow(tbData);

            
            }
             
         
         }catch (SQLException ex) {
            Logger.getLogger(cashierusers.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    //insert delete type of transaction..
    public void invetorytransacdelete() {

        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
        String timee = time.getText();
        String prod =  jbname.getText();
        String username = jusernamee.getText();
        String types = "Deleted Products";
    String supp = jsupplier.getText();
//        int damm = 0;
//        int row = jTable4.getSelectedRow();
//        String prdct = jTable4.getValueAt(row, 0).toString();
    

   String id = jTable4.getModel().getValueAt(jTable4.getModel().getRowCount() - 1, 0).toString();
        try {

           String query = "insert into transactions(InventoryID,quantity,type_transaction,UserID,date,time,username,role)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id));//inventory id
            pst.setDouble(2, Double.parseDouble(jquantity.getText()));
            pst.setString(3, types);
//          pst.setString(4, new LoginUsers().id);//username id...
            pst.setInt(4, new LoginUsers().ID());
            pst.setString(5, date);
            pst.setString(6, timee);
            pst.setString(7, username);
             pst.setString(8, supp);
            pst.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
//      
        }
    }
    
     public void invetorytransacupdate() {

        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
        String timee = time.getText();
        String prod =  jbname.getText();
        String username = jusernamee.getText();
          String supp = jsupplier.getText();
//            String tots = jtotalamount.getText();
        String types = "Updated Products";

//        int damm = 0;
//        int row = jTable4.getSelectedRow();
//        String prdct = jTable4.getValueAt(row, 0).toString();
    

   String id = jTable4.getModel().getValueAt(jTable4.getModel().getRowCount() - 1, 0).toString();
        try {

            String query = "insert into transactions(InventoryID,quantity,type_transaction,UserID,date,time,username,role)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id));//inventory id
            pst.setDouble(2, Double.parseDouble(jquantity.getText()));
            pst.setString(3, types);
//          pst.setString(4, new LoginUsers().id);//username id...
            pst.setInt(4, new LoginUsers().ID());
            pst.setString(5, date);
            pst.setString(6, timee);
            pst.setString(7, username);
             pst.setString(8, supp);
            pst.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
     
        }
    }
     
      public void invetorytransacdisplay() {

        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
        String timee = time.getText();
        String prod =  jbname.getText();
        String username = jusernamee.getText();
          String supp = jsupplier.getText();
//            String tots = jtotalamount.getText();
        String types = "display Products";

//        int damm = 0;
//        int row = jTable4.getSelectedRow();
//        String prdct = jTable4.getValueAt(row, 0).toString();
    

   String id = jTable4.getModel().getValueAt(jTable4.getModel().getRowCount() - 1, 0).toString();
        try {

            String query = "insert into transactions(InventoryID,quantity,type_transaction,UserID,date,time,username,role)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id));//inventory id
            pst.setDouble(2, Double.parseDouble(jquantity.getText()));
            pst.setString(3, types);
//          pst.setString(4, new LoginUsers().id);//username id...
            pst.setInt(4, new LoginUsers().ID());
            pst.setString(5, date);
            pst.setString(6, timee);
            pst.setString(7, username);
             pst.setString(8, supp);
            pst.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(cashierpage.class.getName()).log(Level.SEVERE, null, e);
     
        }
    }

  

     
       public void updateproduct(){
        String sql ="select from `approved_products`";
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
       
       
       
        public void getproductdisplay(){
        
           DefaultTableModel df = (DefaultTableModel)jTable4.getModel();
             df.setRowCount(0);

            
            try {
            Statement st7 = con.createStatement();
            String query1 = "select * from `products`";
            ResultSet rs1 = st7.executeQuery(query1);

            while (rs1.next()) {
                //data wil added until finished..
              String id = rs1.getString("barcode");
                String hh = rs1.getString("product_name");
                String des1 = rs1.getString("description");
                String trr = rs1.getString("quantity");
                String buy = rs1.getString("buyingprice");
                String sell1 = rs1.getString("sellingprice");
                String tcost = rs1.getString("totalamount_cost");
                String pro = rs1.getString("productImage");
                 String supppl = rs1.getString("supplier");

                //string array for store data into jtable..
                String tbData[] = {id, hh, des1, trr, buy, sell1,tcost, pro,supppl};
                DefaultTableModel tblModel = (DefaultTableModel) jTable4.getModel();

                //add string array data into jtable..
                tblModel.addRow(tbData);

            
            }
             
         
         }catch (SQLException ex) {
            Logger.getLogger(cashierusers.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     }
       
       
       
       
   
     
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jsoldproduct = new javax.swing.JPanel();
        jsold = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jusernamee = new javax.swing.JLabel();
        jadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jquantity = new javax.swing.JTextField();
        jbuyprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jimageproduct = new javax.swing.JButton();
        jproductimage = new javax.swing.JLabel();
        jlinkimage = new javax.swing.JTextField();
        jsellprice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jdescription = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jupdate = new javax.swing.JButton();
        jdelete = new javax.swing.JButton();
        jPanel67 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jsupplier = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtotalamount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jbname = new javax.swing.JTextField();
        jchoose = new javax.swing.JComboBox<>();
        jshow = new javax.swing.JButton();
        jdisplay = new javax.swing.JButton();
        jid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jsoldproduct.setBackground(new java.awt.Color(204, 255, 102));

        jsold.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jsold.setForeground(new java.awt.Color(102, 102, 102));
        jsold.setText("Sold Poducts");
        jsold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsoldMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Sign-out");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImageIcon_1.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jusernamee.setBackground(new java.awt.Color(204, 204, 204));
        jusernamee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jusernamee.setForeground(new java.awt.Color(255, 0, 0));
        jusernamee.setText("Username");

        javax.swing.GroupLayout jsoldproductLayout = new javax.swing.GroupLayout(jsoldproduct);
        jsoldproduct.setLayout(jsoldproductLayout);
        jsoldproductLayout.setHorizontalGroup(
            jsoldproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jsoldproductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jsold)
                .addGap(76, 76, 76)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 576, Short.MAX_VALUE)
                .addComponent(jusernamee, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jsoldproductLayout.setVerticalGroup(
            jsoldproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jsoldproductLayout.createSequentialGroup()
                .addGroup(jsoldproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jsoldproductLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jsoldproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jsold)
                            .addComponent(jusernamee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jsoldproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 90));

        jadd.setBackground(new java.awt.Color(204, 255, 102));
        jadd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jadd.setText("Add");
        jadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaddActionPerformed(evt);
            }
        });
        jPanel1.add(jadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 90, 38));

        jTable4.setBackground(new java.awt.Color(204, 255, 153));
        jTable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Description", "Quatity", "Buying Price", "Sellintg Price", "Total cost", "Image", "Supplier"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable4);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 670, 227));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Supplier");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setText("Total cost");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        jquantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 150, 35));

        jbuyprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jbuyprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 150, 35));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Product Inventory");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jButton3.setBackground(new java.awt.Color(204, 255, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 91, 38));

        jimageproduct.setBackground(new java.awt.Color(255, 255, 204));
        jimageproduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jimageproduct.setText("Choose Product");
        jimageproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimageproductActionPerformed(evt);
            }
        });
        jPanel1.add(jimageproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, 41));

        jproductimage.setBackground(new java.awt.Color(255, 255, 204));
        jproductimage.setOpaque(true);
        jPanel1.add(jproductimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 220, 125));

        jlinkimage.setMaximumSize(new java.awt.Dimension(6, 19));
        jlinkimage.setMinimumSize(new java.awt.Dimension(6, 19));
        jPanel1.add(jlinkimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, 35));

        jsellprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jsellprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 138, 36));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 102));
        jLabel8.setText("Selling Price");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jdescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 138, 37));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 102));
        jLabel10.setText("Description");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 102));
        jLabel9.setText("Flower Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jupdate.setBackground(new java.awt.Color(204, 255, 102));
        jupdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jupdate.setText("Update");
        jupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdateActionPerformed(evt);
            }
        });
        jPanel1.add(jupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, 83, 35));

        jdelete.setBackground(new java.awt.Color(204, 255, 102));
        jdelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jdelete.setText("Delete");
        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 480, 81, 35));

        jPanel67.setBackground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, -1));

        jsupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 150, 35));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 102));
        jLabel11.setText("Quantity");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, 20));

        jtotalamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtotalamountActionPerformed(evt);
            }
        });
        jPanel1.add(jtotalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 150, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 102));
        jLabel14.setText("Buying Price");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));
        jPanel1.add(jbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 222, 140, 40));

        jchoose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jchoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Products to add", "Available products", "Products to display" }));
        jPanel1.add(jchoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 200, 40));

        jshow.setText("Show");
        jshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jshowActionPerformed(evt);
            }
        });
        jPanel1.add(jshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 170, 70, 40));

        jdisplay.setText("Display");
        jdisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdisplayActionPerformed(evt);
            }
        });
        jPanel1.add(jdisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 482, -1, 30));
        jPanel1.add(jid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 50, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 30, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaddActionPerformed
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//         String date1 = sdf.format(JDATE.getDate());
//        String date1 = date.getText();
//        String qty = jquantity.getText();
//        String timee = time.getText();
//        String bname = jbname.getText();
//        String supp = jsupplier.getText();
//        String tot = jtotalamount.getText();
//        String desc = jdescription.getText();
//        String buyingprice = jbuyprice.getText();
//        String sellingprice = jsellprice.getText();
//        String img1 = jlinkimage.getText();
//        
//         if (bname.trim().equals("") || bname.trim().equals("")
//                || qty.trim().equals("") || qty.trim().equals("")
//                || sellingprice.trim().equals("") || sellingprice.trim().equals("")
//                || img1.trim().equals("") || img1.trim().equals("")
//                 || supp.trim().equals("") || supp.trim().equals("")
//                || desc.trim().equals("") || desc.trim().equals("")
//                || buyingprice.trim().equals("") || buyingprice.trim().equals("")) {
//             JOptionPane.showMessageDialog(null, "Other fields are empty!");
//            
//        }
//             
//        else {
//             
//               product();
//               
//                int row = jTable4.getSelectedRow();
//
//        String cell = jTable4.getModel().getValueAt(row, 0).toString();
//
//        String sql = "DELETE FROM `approved_products` where id= " + cell;
//
//        try {
//            pst = con.prepareStatement(sql);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, " New product Added!");
//            updateproduct();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        } finally {
//            try {
//                pst.close();
//                rs.close();
//
//            } catch (Exception e) {
//            }
//     
//     
//          
//         
//     
//        jbname.setText("");
//        jbuyprice.setText("");
//        jquantity.setText("");
//        jsellprice.setText("");
//        jlinkimage.setText("");
//        jdescription.setText("");
//
//         }  
//         }

DefaultTableModel tbmodel = (DefaultTableModel)jTable4.getModel();
        if(jTable4.getSelectedRowCount() == 1){
         product();
          JOptionPane.showMessageDialog(null, "Approved!");
        
          
          //      to remove approved applicants/registrants..  
//        String role1;
//        role1 = jrole.getSelectedItem().toString();

        int row = jTable4.getSelectedRow();

        String cell = jTable4.getModel().getValueAt(row, 0).toString();

        String sql = "DELETE FROM `approved_products` where id= " + cell;

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, " New product Added!");
            updateproduct();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();

            } catch (Exception e) {
            }
     
        
                
         DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
         //delete row
         if(jTable4.getSelectedRowCount()==1){
             //if single row is selected then delete
              model.removeRow(jTable4.getSelectedRow());
              jbname.setText("");
        jbuyprice.setText("");
        jquantity.setText("");
        jsellprice.setText("");
        jlinkimage.setText("");
        jdescription.setText("");
//
//              jstatus.setSelectedIndex(0);
         }
       }
      
           
       }else{
           if(jTable4.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Table is empty!");
           }else{
                    JOptionPane.showMessageDialog(null, "Please select a single row!");
           }
       }
         


         
        

    }//GEN-LAST:event_jaddActionPerformed

    private void jsoldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsoldMouseClicked
        // TODO add your handling code here:
        soldproducts sold = new soldproducts(jusernamee.getText());
        sold.show();
        dispose();  

        try {
            Statement st = con.createStatement();
            String query1 = "select * from `sales_products` ";
            ResultSet rs1 = st.executeQuery(query1);

            while (rs1.next()) {
                //data wil added until finished..
                 String bid2 = rs1.getString("product_id");
                String salesid2 = rs1.getString("sales_id");
                String bookn2 = rs1.getString("product_name");
                 String buying = rs1.getString("buyingprice");
                String price2 = rs1.getString("price");
                String qty2 = rs1.getString("quantity");
                String totl2 = rs1.getString("total");
                 String date2 = rs1.getString("date");
                  String userID = rs1.getString("userid");
                  String supp = rs1.getString("supplier");
                   String use = rs1.getString("username");
                  
        
                //string array for store data into jtable..
                String tbData[] = {bid2,salesid2,bookn2,buying,price2,qty2,totl2,date2,userID,supp,use};
                DefaultTableModel tblModel = (DefaultTableModel) jTable5.getModel();

                //add string array data into jtable..
                tblModel.addRow(tbData);

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jsoldMouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        DefaultTableModel model2 = (DefaultTableModel) jTable4.getModel();
//          InputStream is=new FileInputStream(new File(photopath));
//          pst.setBlob(5, is);
        int Myindex = jTable4.getSelectedRow();
        int Mycolumn = jTable4.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();
        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
//        jbname.setSelectedItem(model2.getValueAt(Myindex, 1).toString());
        jid.setText(model2.getValueAt(Myindex, 0).toString());
        jdescription.setText(model2.getValueAt(Myindex, 2).toString());
        jquantity.setText(model2.getValueAt(Myindex, 3).toString());
         jbname.setText(model2.getValueAt(Myindex, 1).toString());

        jbuyprice.setText(model2.getValueAt(Myindex, 4).toString());
        jsellprice.setText(model2.getValueAt(Myindex, 5).toString());

        jlinkimage.setText(model2.getValueAt(Myindex, 7).toString());
        
         jsupplier.setText(model2.getValueAt(Myindex, 8).toString());
   jtotalamount.setText(model2.getValueAt(Myindex, 6).toString());
    
        
        //select image from jtable to jlabel
//        JLabel imageic = (JLabel) jTable4.getValueAt(Myindex, 6);
//        ImageIcon imagejicon = (ImageIcon) imageic.getIcon();
//        jproductimage.setIcon(imagejicon);


    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       jbname.setText("");
        jbuyprice.setText("");
        jquantity.setText("");
        jsellprice.setText("");
        jsupplier.setText("");
         jtotalamount.setText("");
          jdescription.setText("");
           jlinkimage.setText("");
          jproductimage.setText(null);
         jbname.setText("");
      jadd.setEnabled(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        LoginUsers main = new LoginUsers();
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked
//for selecting the photo
    private void jimageproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimageproductActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter(".Flower-Sales", "jpg", "png", "webp", "jpeg");
        chooser.addChoosableFileFilter(fnef);
        int ans = chooser.showSaveDialog(null);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File selectedPhoto = chooser.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();
            jproductimage.setIcon(resetImageSize(path, null));
            this.photopath = path;
            jlinkimage.setText(path);
            //or...
//            displayImage(path, jproductimage);
            System.out.println(path);

        } else {
            System.out.println("no file selected");
        }

    }//GEN-LAST:event_jimageproductActionPerformed

    private void jupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdateActionPerformed
        // TODO add your handling code here:
         if(jTable4.getSelectedRowCount() == 1){
        DefaultTableModel model2 = (DefaultTableModel) jTable4.getModel();
        int Myindex = jTable4.getSelectedRow();
        int Mycolumn = jTable4.getSelectedColumn();

        String value = model2.getValueAt(Myindex, Mycolumn).toString();
        int id = Integer.parseInt(model2.getValueAt(Myindex, 0).toString());
        String bname =  jbname.getText();
        String qty = jquantity.getText();
        String bprice = jbuyprice.getText();
        String sprice = jsellprice.getText();
        String des = jdescription.getText();
        String imgl = jlinkimage.getText();
      String ts = jtotalamount.getText();
         String supp = jsupplier.getText();
  
        invetorytransacupdate();
        
       
        try{
            pst = con.prepareStatement("UPDATE `products` set product_name= ?,description=?, quantity= ?, buyingprice= ?,sellingprice= ?,totalamount_cost=?, productImage= ?, supplier=?  where barcode= ?");
            //
            pst.setString(1, bname);
            pst.setString(2, des);
            pst.setString(3,qty);
            pst.setString(4,bprice);
            pst.setString(5,sprice);
              pst.setString(6,ts); 
              pst.setString(7,imgl); 
              
            pst.setString(8,supp);
       
            pst.setInt(9, id);

            int k= pst.executeUpdate();

            if(k==1)
            {
                JOptionPane.showMessageDialog(this, "Successfully Updated");
                 jbname.setText("");
                jquantity.setText("");
                jbuyprice.setText("");
                jsellprice.setText("");
                 jdescription.setText("");
                 jlinkimage.setText("");
                jbname.requestFocus();

                salesupdate();


            }
            
           
               
        } catch (SQLException ex) {
            Logger.getLogger(inventorypage1.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
        else{
         
           if(jTable4.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty!");
           }
    }

     
        
    }//GEN-LAST:event_jupdateActionPerformed

    private void jdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeleteActionPerformed
        // TODO add your handling code here:
        if(jTable4.getSelectedRowCount() == 1){
        invetorytransacdelete();
        int row =jTable4.getSelectedRow();
        String cell = jTable4.getModel().getValueAt(row, 0).toString();
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

            DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
            //delete row
            if(jTable4.getSelectedRowCount()==1){
                //if single row is selected then delete
                model.removeRow(jTable4.getSelectedRow());
              jbname.setText("");
                jquantity.setText("");
                jbuyprice.setText("");
                jsellprice.setText("");
                jdescription.setText("");
                jlinkimage.setText("");  
                jsupplier.setText("");  
                   jtotalamount.setText("");  
                          
        }
           
        }
    }

        else{
         
           if(jTable4.getSelectedRowCount() == 0){
               //if table is empty np data the show message..
                JOptionPane.showMessageDialog(null, "Field is empty!");
           }
           
        }
           
      
    }//GEN-LAST:event_jdeleteActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        LoginUsers cashregis = new  LoginUsers();
        cashregis.setVisible(true);
        cashregis.pack();
        cashregis.setLocationRelativeTo(null);
        cashregis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jtotalamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtotalamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtotalamountActionPerformed

    private void jshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jshowActionPerformed
        // TODO add your handling code here:
         DefaultTableModel df = (DefaultTableModel)jTable4.getModel();
      df.setRowCount(0);
        
         if (jchoose.getSelectedIndex() == 0) {
          toadd();
           jupdate.setEnabled(false);
           jdelete.setEnabled(false);
           jadd.setEnabled(true);
             jdisplay.setEnabled(false);
          
        }else if(jchoose.getSelectedIndex() == 1) {
           getproduct();
            jadd.setEnabled(false);
              jupdate.setEnabled(true);
           jdelete.setEnabled(true);
             jdisplay.setEnabled(false);
        }
         else if(jchoose.getSelectedIndex() == 2) {
           getproductdisplay();
            jadd.setEnabled(false);
            jupdate.setEnabled(true);
            jdisplay.setEnabled(true);
           jdelete.setEnabled(true);
        }
        DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(model);
        jTable4.setRowSorter(tr);
    }//GEN-LAST:event_jshowActionPerformed

    private void jdisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdisplayActionPerformed
        // TODO add your handling code here:
        productdispaly();
        invetorytransacdisplay();
    
    }//GEN-LAST:event_jdisplayActionPerformed

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
            java.util.logging.Logger.getLogger(inventorypage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventorypage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventorypage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventorypage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventorypage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable4;
    private javax.swing.JButton jadd;
    private javax.swing.JTextField jbname;
    private javax.swing.JTextField jbuyprice;
    private javax.swing.JComboBox<String> jchoose;
    private javax.swing.JButton jdelete;
    private javax.swing.JTextField jdescription;
    private javax.swing.JButton jdisplay;
    private javax.swing.JTextField jid;
    private javax.swing.JButton jimageproduct;
    private javax.swing.JTextField jlinkimage;
    private javax.swing.JLabel jproductimage;
    private javax.swing.JTextField jquantity;
    private javax.swing.JTextField jsellprice;
    private javax.swing.JButton jshow;
    private javax.swing.JLabel jsold;
    private javax.swing.JPanel jsoldproduct;
    private javax.swing.JTextField jsupplier;
    private javax.swing.JTextField jtotalamount;
    private javax.swing.JButton jupdate;
    public javax.swing.JLabel jusernamee;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
