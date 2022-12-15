/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import static src.cashierregistrants.jTable2;
import javax.swing.table.TableRowSorter;
import static src.category.jTable6;
//import static src.categorycashier.jTable56;
import static src.inventorypage.jTable4;
import static src.soldproducts.jTable5;

/**
 *
 * @author 1styrGroupB
 */
public class cashierpage1 extends javax.swing.JFrame {

//    private static TableModel resultSetToTableModel(ResultSet RS) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /**
     * Creates new form bookshop
     */
    public cashierpage1() {
        initComponents();
        Connect();
//        sales();
        dt();
        time();
//      
    }
    public cashierpage1(String usernamee) {
        initComponents();
        Connect();

        jusername.setText(usernamee);
        dt();
        time();
//     

    }
    
    
     public static void AddRowToJcategoryTable(Object[] dataRow)   
     {
       DefaultTableModel model6 = (DefaultTableModel)jTable6.getModel(); 
       model6.addRow(dataRow);
     }
     
     URL ic =getClass().getResource("/images/ImageIcon_1.png");
     Icon ci = new ImageIcon(ic);
    
      
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    ResultSet rs;
    DefaultTableModel df;
    
    Connection con1 = null;
    Statement st = null;
    ResultSet RS = null;
    
  public void Connect()
  {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/marketsystem", "root", "");
    } catch (ClassNotFoundException ex){
         Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (SQLException ex) {
            Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, ex);
        }

  }
  
  
  private void pos(){
      String nme= jcode.getText();
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/marketsystem", "root", "");
          pst = con.prepareStatement("select * from products where barcode=?");
          pst.setString(1, nme);
          rs = pst.executeQuery();
          
          while(rs.next())
          {
              int currentquanti;
              currentquanti = rs.getInt("quantity");
//              int minimumquan;
//              minimumquan = rs.getInt("quantity");

              int price2 = Integer.parseInt(jbuyp.getText());
              int price = Integer.parseInt(jprice.getText());
              int qtynew = Integer.parseInt(quantity.getValue().toString()); 
              
              int tot = price * qtynew;
              int btot = price2 * qtynew;
               jtot.setText(String.valueOf(btot));
              if(qtynew >= currentquanti)
              {
                  JOptionPane.showMessageDialog(this,"Available Products" + " =" + currentquanti);
                  JOptionPane.showMessageDialog(this,"Quantity is not enough!!");
              }else if(currentquanti == 10 ){
                  JOptionPane.showMessageDialog(this,"Available Products" + " =" + currentquanti);
                  JOptionPane.showMessageDialog(this,"Limited stock! you can't sell beyond minimum allowable threshold \n product quantity.  Wait for new stock arrival!");
              }
              else{
                  String na = jbname.getText();
                  String pric = jprice.getText();
                  String quan = jtquantity.getText();

                  Date da = new Date();
                  String datet = da.toString();
                  jreciept.setText(jreciept.getText() + "\n______________________________________\n\n");
                  jreciept.setText(jreciept.getText() + "Flower Name  --------------- : " + na + "\n\n");
                  jreciept.setText(jreciept.getText() + "Price        --------------- : " + pric + "\n\n");
                  jreciept.setText(jreciept.getText() + "Quatity      --------------- : " + quan + "\n\n");

        
                  DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
                  model.addRow(new Object[]
                          {
                        jcode.getText(),
                        jbname.getText(),
                         jbuyp.getText(),
                        jprice.getText(),
                        quantity.getValue(),
                        tot,
                          });
//                        jcode.setText("");
//                        jbname.setText("");
//                        jprice.setText("");
//                        quantity.setValue("");
//                        jcode.requestFocus();
                  
            
              int sum = 0;
              int sum1 = 0;
              for (int i = 0; i < jTable2.getRowCount(); i++) {
                  sum1 = sum1 + Integer.parseInt(jTable2.getValueAt(i, 4).toString());
                  sum = sum + Integer.parseInt(jTable2.getValueAt(i, 5).toString());
              }
              jtcost.setText(String.valueOf(sum));
              jtquantity.setText(String.valueOf(sum1));

              }
              
            
              
          
          }
          
//       
        
      } catch (SQLException ex) {
            Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
 
  public void cashiertransac() {

           Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
        String timee = time.getText();
        String prod = jbname.getText();
         String rolee = jposition.getText();
       
        String username = jusername.getText();
//        double qty = Double.parseDouble(quantity.getValue().toString()); 
         int quan = Integer.parseInt(quantity.getValue().toString()); 
         
//        Double qty = quantity.getValue().toString();
        String type = "Get products";

        try {


            String query = "insert into transactions(InventoryID,quantity,type_transaction,UserID,date,time,username,role)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst = con.prepareStatement(query);
//            pst.setInt(1, codee);
            pst.setInt(1, Integer.parseInt(jcode.getText()));
            pst.setInt(2, quan);
            pst.setString(3, type);
            pst.setInt(4, new LoginUsers().ID());//username id...
            pst.setString(5, date);
            pst.setString(6, timee);
            pst.setString(7, username);
            pst.setString(8, rolee);
            pst.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, e);
        }
    }
  
  public void cashiertransaccancel() {

        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
        String timee = time.getText();
        String prod = jbname.getText();
        String rolee = jposition.getText();
        String username = jusername.getText();
         int quan = Integer.parseInt(quantity.getValue().toString()); 
         String type = "returned sales";
        try {

            String query = "insert into transactions(InventoryID,quantity,type_transaction,UserID,date,time,username,role)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst = con.prepareStatement(query);
//            pst.setInt(1, codee);
            pst.setInt(1, Integer.parseInt(jcode.getText()));
            pst.setInt(2, quan);
            pst.setString(3, type);
            pst.setInt(4, new LoginUsers().ID());//username id...
            pst.setString(5, date);
            pst.setString(6, timee);
             pst.setString(7, username);
            pst.setString(8, rolee);
            pst.executeUpdate();
        } catch (Exception e) {
           
            Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, e);
     
        }
    }
  
   public void cashiertransacsold() {

        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dt.format(now);
        String timee = time.getText();
        String prod = jbname.getText();
          String rolee = jposition.getText();
        String username = jusername.getText();
        int quan = Integer.parseInt(quantity.getValue().toString()); 
        String type = "sold products";
        try {
            String query = "insert into transactions(InventoryID,quantity,type_transaction,UserID,date,time,username,role)values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(jcode.getText()));
            pst.setInt(2, quan);
            pst.setString(3, type);
            pst.setInt(4, new LoginUsers().ID());//username id...
            pst.setString(5, date);
            pst.setString(6, timee);
            pst.setString(7, username);
            pst.setString(8, rolee);
            pst.executeUpdate();
            
//            JOptionPane.showMessageDialog(null,"Product has been sold");
        } catch (Exception e) {
           
            Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, e);
     
        }
    }


  public void sales()
  {
//      int bup = Integer.parseInt(jbuyp.getText());
        Calendar cal = new GregorianCalendar();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date1 = dt.format(now);
        String totalcostbuy = jtot.getText();
        String totalcost = jtcost.getText();
        String pay1 = jpay.getText();
//       int bal = Integer.parseInt(jbalance.getText().toString());
        String bal = jbalance.getText();
      int damm =0;
      
       

      try{
          String query ="insert into sales(subtotal,pay,balance) values (?,?,?)";
          pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
          pst.setString(1, totalcost);
//          pst.setInt(2, pay);
          pst.setString(2, pay1);
          pst.setString(3, bal);
          pst.executeUpdate();
          rs = pst.getGeneratedKeys();
          
       
         
          if(rs.next())
          {
              damm = rs.getInt(1);
              
          }
            
            int rows = jTable2.getRowCount();
             
          
          String query1 = "insert into `sales_products`(sales_id, product_name,buyingprice,price, quantity, total, date, userid) values (?,?,?,?,?,?,?,?);";
          pst1 = con.prepareStatement(query1);

          String bname = "";
          
          String price;
          String costbuying;
          int qty;
          String id;
            int total = 0;
            for(int i = 0; i<jTable2.getRowCount(); i++)
            {
                id = (String)jTable2.getValueAt(i, 0);
                bname = (String)jTable2.getValueAt(i, 1);
//               costbuying = (String)jTable2.getValueAt(i, 2);
                price = (String)jTable2.getValueAt(i, 3);
                qty = (int)jTable2.getValueAt(i, 4);
                total = (int)jTable2.getValueAt(i,5);
                
//                pst1.setString(1, id);
                pst1.setInt(1, damm);
                pst1.setString(2, bname);
                pst1.setString(3, totalcostbuy);
                pst1.setString(4, price);
                pst1.setInt(5, qty);
                pst1.setInt(6, total);
                pst1.setString(7, date1);
                pst1.setInt(8, new LoginUsers().ID());
                pst1.executeUpdate();
                
//                     JOptionPane.showMessageDialog(this, "Sales completed");
//                
            }
//            
            String query4="update products set quantity= quantity-? where barcode =?";
            pst2=con.prepareStatement(query4);
            
            for (int i=0; i<jTable2.getRowCount(); i++)
            {
                id = (String)jTable2.getValueAt(i, 0);
                qty=(int)jTable2.getValueAt(i, 4);
                
                pst2.setInt(1, qty);
                pst2.setString(2, id);
                pst2.execute();
            }
            JOptionPane.showMessageDialog(this, "Sales completed");
          
      }catch(SQLException ex){
            
           Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
   public void dt(){
         
         Date d = new Date();
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         
         String dd = sdf.format(d);
         date.setText(dd);
     }
         Timer t;
         SimpleDateFormat stt;
          public void time(){
              t = new Timer(0, new ActionListener(){
              
                  @Override
                  public void actionPerformed(ActionEvent e){
                      Date dt = new Date();
                      stt = new SimpleDateFormat("hh-mm-ss a");
                      String tt =stt.format(dt);
                      time.setText(tt);
                      
                  }
              });
                  t.start();    
          }

        public void updateproductsales() {
        String sql = "select from `orders`";
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantity = new javax.swing.JSpinner();
        jcode = new javax.swing.JTextField();
        jbname = new javax.swing.JTextField();
        jprice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtcost = new javax.swing.JTextField();
        jpay = new javax.swing.JTextField();
        jbalance = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtquantity = new javax.swing.JTextField();
        jadd = new javax.swing.JButton();
        jButtondelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jusername = new javax.swing.JLabel();
        jposition = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jbuyp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtot = new javax.swing.JTextField();
        jPanel68 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jinput = new javax.swing.JTextField();
        jsearch = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jreciept = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jinput1 = new javax.swing.JTextField();
        jsearch1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentHidden(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Product Code");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Product name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 75, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Price");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 125, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 175, -1, 28));

        quantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 101, 29));

        jcode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcodeActionPerformed(evt);
            }
        });
        jcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcodeKeyPressed(evt);
            }
        });
        jPanel2.add(jcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 155, 36));

        jbname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 155, 31));

        jprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 155, 31));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Total Cost");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Pay");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 49, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Balance");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        jtcost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtcost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtcostMouseClicked(evt);
            }
        });
        jPanel2.add(jtcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 114, 31));

        jpay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 114, 31));

        jbalance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jbalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 114, 29));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Total Qty");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jtquantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 114, 36));

        jadd.setBackground(new java.awt.Color(255, 255, 153));
        jadd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jadd.setText("Add");
        jadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaddActionPerformed(evt);
            }
        });
        jPanel2.add(jadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 79, 30));

        jButtondelete.setBackground(new java.awt.Color(255, 255, 153));
        jButtondelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtondelete.setText("Cancel");
        jButtondelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtondelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, 31));

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 79, 31));

        jLabel11.setText("kg");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, 30));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 580, 210));

        jTable2.setBackground(new java.awt.Color(204, 255, 153));
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Product_Name", "Buying price", "Price", "Quantity(per kg)", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 655, 120));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 255, 102));
        jButton1.setText("Print Invoice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 467, 130, 40));

        jPanel5.setBackground(new java.awt.Color(204, 255, 102));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Exit");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImageIcon_1.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Cashier Management");

        jusername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jusername.setForeground(new java.awt.Color(255, 0, 0));
        jusername.setText("Cashieruser");

        jposition.setText("Cashier");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel19)
                .addGap(74, 74, 74)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jposition, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jposition)))
                .addGap(18, 18, 18))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 100));

        jTable7.setBackground(new java.awt.Color(204, 255, 153));
        jTable7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "order_id", "Cus-ID", "customer_name", "barcode", "product_name", "description", "qty", "price", "payment", "supplier"
            }
        ));
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable7);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 660, 130));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 102));
        jLabel14.setText("Show Orders");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 102, 26));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 255, 102));
        jLabel15.setText("Hide Products");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 102, 26));

        jbuyp.setBackground(new java.awt.Color(204, 255, 153));
        jbuyp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(jbuyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 125, 35));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Total");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 89, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Buying Price");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 124, -1));

        jtot.setBackground(new java.awt.Color(204, 255, 153));
        jtot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(jtot, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 125, 35));

        jPanel68.setBackground(new java.awt.Color(51, 51, 51));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Date:");

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Time:");

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

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 370, -1));

        jinput.setText("Search Customer name");
        jPanel4.add(jinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 180, 30));

        jsearch.setText("SEARCH");
        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });
        jPanel4.add(jsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, 30));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        jreciept.setBackground(new java.awt.Color(204, 255, 153));
        jreciept.setColumns(20);
        jreciept.setRows(5);
        jScrollPane3.setViewportView(jreciept);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, 270, 260));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "barcode", "Product name", "description", "Supplier", "Buying price"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 200, 460, 90));

        jButton3.setText("Product List");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, -1, -1));

        jinput1.setText("search product..");
        jPanel4.add(jinput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 160, 30));

        jsearch1.setText("Search");
        jsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearch1ActionPerformed(evt);
            }
        });
        jPanel4.add(jsearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1255, 673));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentHidden

    private void jcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try{
                String bcode = jcode.getText();
                pst = (PreparedStatement) con.prepareStatement("select * from products where barcode = ?");
                pst.setString(1, bcode);
                rs = pst.executeQuery();
                
                if(rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this, "Product not Found");
                }
                else
                {
                    String bname = rs.getString("product_name");
                    jbname.setText(bname.trim());
                    
                    String price = rs.getString("sellingprice");
                    jprice.setText(price.trim());
                    
                    quantity.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(cashierpage1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jcodeKeyPressed

    private void jaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaddActionPerformed
   
        String buying = jbuyp.getText();
        String cost = jcode.getText();
        if (buying.trim().equals("") || buying.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Buying Price!");

        } else {
            pos();
            cashiertransac();
        }
        jbuyp.setText("");

        if (jTable7.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "select the process order from the table!");
        } else {

            if (jTable7.getSelectedRowCount() == 1) {
//             if select from the table proceed

                int row = jTable7.getSelectedRow();
                String cell = jTable7.getModel().getValueAt(row, 3).toString();
                String sql = "DELETE FROM `orders` where product_id= " + cell;

                try {

                    pst = con.prepareStatement(sql);
                    pst.execute();
                    updateproductsales();
                    JOptionPane.showMessageDialog(null, "order " + cost + " processed!");

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e);

                } finally {
                    try {
                        pst.close();
                        rs.close();

                    } catch (Exception e) {
                    }

                    DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
                    //delete row
                    if (jTable7.getSelectedRowCount() == 1) {
                        //if single row is selected then delete
                        model.removeRow(jTable7.getSelectedRow());

                    }

                }
            }

        }


 
              
    }//GEN-LAST:event_jaddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cashiertransacsold();
        String payment = jpay.getText();
       
         if (payment.trim().equals("") || payment.trim().equals(""))
               {
            JOptionPane.showMessageDialog(null, "Enter Payment!");
            
        }
         else {
             
        int pay = Integer.parseInt(jpay.getText());
        int totalcost = Integer.parseInt(jtcost.getText());
        sales();
        int bal = pay - totalcost;
        jbalance.setText(String.valueOf(bal));
        String na=  jbname.getText();
        String pric = jprice.getText();
        String quan= jtquantity.getText();
        String cost = jtcost.getText();
        String balanc = jbalance.getText();
        String cash = jpay.getText();
       
               
        
      
        
        
        Date da = new Date();
        String datet =da.toString();
  
//        jreciept.setText(jreciept.getText() + "\n====================================\n\n");
//        jreciept.setText(jreciept.getText() + "              \n  " + datet + "           \n\n");
        jreciept.setText(jreciept.getText() + "\n______________________________________\n\n");
//        jreciept.setText(jreciept.getText() + "Flower Name  --------------- :" + na + "\n\n");
//        jreciept.setText(jreciept.getText() + "Price        --------------- : " + pric + "\n\n");
//        jreciept.setText(jreciept.getText() + "Quatity      --------------- : " + quan + "\n\n");

        jreciept.setText(jreciept.getText() + "+++++++++BEBIE'S FLOWER SHOP+++++++++++++\n");
        jreciept.setText(jreciept.getText() + "Total Cost   --------------- : " + cost + "\n\n");
        jreciept.setText(jreciept.getText() + "Cash         --------------- : " + cash + "\n\n");
        jreciept.setText(jreciept.getText() + "-------------------------------------------------\n\n");
        jreciept.setText(jreciept.getText() + "Change       --------------- : " + balanc + "\n\n");
        jreciept.setText(jreciept.getText() + "______________________________________________\n\n");
        jreciept.setText(jreciept.getText() + "Save and Purchase\n\n");
        jreciept.setText(jreciept.getText() + "Thank you Come again!!\n\n");
        
               jcode.setText("");
               jbname.setText("");
               jprice.setText("");
               quantity.setValue(0);
               jtcost.setText("");
               jpay.setText("");
              jtquantity.setText("");
         } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
     
     
            DefaultTableModel model1 = (DefaultTableModel)jTable2.getModel();
            int Myindex = jTable2.getSelectedRow();
            int Mycolumn = jTable2.getSelectedColumn();
            
            String value = model1.getValueAt(Myindex, Mycolumn).toString();
            jcode.setText(model1.getValueAt(Myindex, 0).toString());
            jbname.setText(model1.getValueAt(Myindex, 1).toString());
                 jbuyp.setText(model1.getValueAt(Myindex, 2).toString());
            jprice.setText(model1.getValueAt(Myindex, 3).toString());
            int quantity_ = Integer.parseInt(model1.getValueAt(Myindex, 4).toString());
            quantity.setValue((int)quantity_);
       
//          jtquantity.setText(model1.getValueAt(Myindex, 2).toString());
            
       
   
      
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButtondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondeleteActionPerformed
        // TODO add your handling code here:
                 cashiertransaccancel();
         DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
         //delete row
         if(jTable2.getSelectedRowCount()==1){
             //if single row is selected then delete
             model.removeRow(jTable2.getSelectedRow());
             jcode.setText("");
             jbname.setText("");
             jprice.setText("");
             quantity.setValue(0);
              
            //to subtract the total cost from the deleted sales
            int numrow = jTable2.getRowCount();
            double tot = 0;
            double tot1 = 0;
            
            for (int i = 0; i<numrow; i++){
                double val = Double.valueOf(jTable2.getValueAt(i, 3).toString());
                double val1 = Double.valueOf(jTable2.getValueAt(i, 2).toString());
                tot += val;   
                tot1 += val1; 
            }          
            jtcost.setText(Double.toString(tot));
            jtquantity.setText(Double.toString(tot1));
//            jtotalc.setText(Double.toString(tot));
//            jtotalq.setText(Double.toString(tot1));
       
            JOptionPane.showMessageDialog(this, "Order Cancelled!!");
            
  
            }else{
             if(jTable2.getRowCount()==0){
                 //if table is not empty(no data) than display message
                 JOptionPane.showMessageDialog(this, "Table is empty.");
             }else{
                 //if table is not empty but row is not selected or multiple row is selected
                 
                  JOptionPane.showMessageDialog(this, "Please select a single row to delete.");
                  
             }
         }
       
    }//GEN-LAST:event_jButtondeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
               jcode.setText("");
               jbname.setText("");
               jprice.setText("");
               quantity.setValue(0);
             
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcodeActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
               System.exit(0);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        
         LoginUsers main = new  LoginUsers();
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        
         LoginUsers cashregis = new LoginUsers();
        cashregis.setVisible(true);
        cashregis.pack();
        cashregis.setLocationRelativeTo(null);
        cashregis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jtcostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtcostMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtcostMouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        
         DefaultTableModel df = (DefaultTableModel)jTable7.getModel();
         df.setRowCount(0);
        try {
            Statement st = con.createStatement();
            String query1 = "select * from `orders`";
            ResultSet rs1 = st.executeQuery(query1);

            while(rs1.next()){
                //data wil added until finished..

                String bid = rs1.getString("order_id");
                String custid = rs1.getString("customer_id");
                String cusname = rs1.getString("customername");
                   String pid = rs1.getString("product_id");
                String pname = rs1.getString("product_name");
               
                  String des = rs1.getString("product_description");
                   String qtyy = rs1.getString("qty");
                   String pric = rs1.getString("price");
               String paydes = rs1.getString("payment_description");
                   String supp = rs1.getString("supplier");

                //string array for store data into jtable..
                String tbData[] = {bid,custid,cusname,pid,pname,des,qtyy,pric,paydes,supp};
                DefaultTableModel tblModel = (DefaultTableModel)jTable7.getModel();

                //add string array data into jtable..

                tblModel.addRow(tbData);

            }

//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        
           DefaultTableModel df = (DefaultTableModel)jTable7.getModel();
           df.setRowCount(0);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
        // TODO add your handling code here:
        
             
          String st = jinput.getText();
          
          
        DefaultTableModel model = (DefaultTableModel)jTable7.getModel();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(model);
        jTable7.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(st.trim()));
    }//GEN-LAST:event_jsearchActionPerformed

    private void jsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearch1ActionPerformed
        // TODO add your handling code here:
        
            String st = jinput1.getText();
          
          
        DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(model);
        jTable3.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(st.trim()));
    }//GEN-LAST:event_jsearch1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


        // TODO add your handling code here:
    
        
           DefaultTableModel df = (DefaultTableModel)jTable3.getModel();
             df.setRowCount(0);

            
            try {
            Statement st7 = con.createStatement();
            String query1 = "select *  from `products`";
            ResultSet rs1 = st7.executeQuery(query1);

            while (rs1.next()) {
                //data wil added until finished..
              String id = rs1.getString("barcode");
                String hh = rs1.getString("product_name");
                String des1 = rs1.getString("description");
                 String supppl = rs1.getString("supplier");
                String buy = rs1.getString("buyingprice");
               
            

                //string array for store data into jtable..
                String tbData[] = {id, hh, des1, supppl, buy};
                DefaultTableModel tblModel = (DefaultTableModel) jTable3.getModel();

                //add string array data into jtable..
                tblModel.addRow(tbData);

            
            }
             
         
         }catch (SQLException ex) {
            Logger.getLogger(cashierusers.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(cashierpage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashierpage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashierpage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashierpage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashierpage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtondelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable7;
    private javax.swing.JButton jadd;
    private javax.swing.JTextField jbalance;
    private javax.swing.JTextField jbname;
    private javax.swing.JTextField jbuyp;
    private javax.swing.JTextField jcode;
    private javax.swing.JTextField jinput;
    private javax.swing.JTextField jinput1;
    private javax.swing.JTextField jpay;
    private javax.swing.JLabel jposition;
    private javax.swing.JTextField jprice;
    private javax.swing.JTextArea jreciept;
    private javax.swing.JButton jsearch;
    private javax.swing.JButton jsearch1;
    private javax.swing.JTextField jtcost;
    private javax.swing.JTextField jtot;
    private javax.swing.JTextField jtquantity;
    private javax.swing.JLabel jusername;
    private javax.swing.JSpinner quantity;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables

//    private void SelectedCat() {
//       try{
//        con = DriverManager.getConnection("jdbc:mysql://localhost/bebieinventorysystem", "root", "");
//        st= con.createStatement();
//        RS=st.executeQuery("select * from `sales_products`");
//        jTable2.setModel(cashierpage.resultSetToTableModel(RS));
//       }catch(SQLException e){
//           e.printStackTrace();
//             
//       }
//    }
}
