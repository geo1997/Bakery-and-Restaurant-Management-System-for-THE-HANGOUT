/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestuarantBakery;

import Hangout.Home.Home;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author BEYOND
 */
public class BakBill extends javax.swing.JFrame {

    /**
     * Creates new form Background
     */
    public BakBill() {
        initComponents();
        fillComboBox();
        fillComboBox2();
      
     
        lblcashNo.setText("0040");
        jPanel1.setBackground(new Color(255,102,0,180));
        jPanel3.setBackground(new Color(0,0,0,150));
        jPanel2.setBackground(new Color(255,102,0,180));
        jPanel4.setBackground(new Color(255,102,0,180));
        jTable2.getTableHeader().setDefaultRenderer(new BakBill.HeaderColor());
           
        this.setExtendedState(MAXIMIZED_BOTH);
        repaint();
    }
     public Connection MySqlConnection(){
        Connection conn = null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hangout",
                    "root","root");
             System.out.println("Db Connection Successful");
            
            return conn;
        }
        catch(Exception e){
            System.out.println("Db Connection fail");
            return null;
        }
    
     }
     
      public void fillComboBox(){
      
          try {
                String q="select * from bak_pro";
                Connection conn=MySqlConnection();
                Statement st=conn.prepareStatement(q);
                ResultSet rs=st.executeQuery(q);
                
                while(rs.next()){
                    
                    cmbbaked.addItem(rs.getString("product"));
                    repaint();
                }
                
          } catch (Exception e) {
          }
          
      }
     //FIll details to the item combo box
     public void fillComboBox2(){
      
          try {
                String q="select * from restitem";
                Connection conn=MySqlConnection();
                Statement st=conn.prepareStatement(q);
                ResultSet rs=st.executeQuery(q);
                
                while(rs.next()){
                    
                    cmbbaverages.addItem(rs.getString("rItem"));
                    repaint();
                }
                
          } catch (Exception e) {
          }
          
      }
     
     
      
    public ArrayList<Bill>retrieveData(){
        ArrayList<Bill> b1=null;
        b1=new ArrayList<Bill>();
        try{
            Connection conn=MySqlConnection();
            String q="select item,ppu,qty,cost from bill ";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(q);
            Bill bill;
            
            while(rs.next()){
                bill=new Bill(rs.getString("item"),rs.getInt("qty"),
                        rs.getFloat("ppu"),rs.getFloat("cost"));
                b1.add(bill);
                 
            }
            
        }
        catch(Exception e){
            System.out.println("Error RetrieveData"+e);
        
        }
        return b1;
    }
    
       
        public void fillTable(){
    
        ArrayList<Bill> b1;
        b1 = retrieveData();
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[4];
        for(int i =0;i<b1.size();i++){
            row[0]=b1.get(i).getName();
            row[1]=b1.get(i).getPpu();
            row[2]=b1.get(i).getQty();
            row[3]=b1.get(i).getCost();
            model.addRow(row);
            
        }
    }
    public void BillHeader(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        txtAreaBill.setText("======================================================================="+"\n"+
                "\t\t\t"+"The Hangout-Bakery"+"\n\n"+"Bill No: "+txtBillID.getText()+"\n"+
                "Date and Time: "+dateFormat.format(currentDate)+"\n"+
                "Contact No. - 0129388888"+"\n"+
                "Address - "+"\n"+"======================================================================="+"\n"+"\t"+String.format("%-20s%-15s%-8s%-10s%n",
                "Item","Unit Price","Qty","Cost"));
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblChashId = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnAddItem = new javax.swing.JButton();
        txticost = new javax.swing.JTextField();
        txtiqty = new javax.swing.JTextField();
        txtppitum = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnCalculate = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnprintPreview = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblBNetTot = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbbaverages = new javax.swing.JComboBox<>();
        txtBillID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cmbbaked = new javax.swing.JComboBox<>();
        txtppbitum = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtbqty = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtbcost = new javax.swing.JTextField();
        btnAddItem1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        lblcashNo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaBill = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        btnconf = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnClear1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1920, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        jLabel2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Chiller", 1, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bakery");

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_left_arrow_38px.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 102, 0));
        btnLogout.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("Bill");

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton2.setText("Request Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(477, 477, 477)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1379, Short.MAX_VALUE)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(782, 782, 782))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLogout)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblChashId.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblChashId.setText("Chashier ID:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Bill ID:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setText("Select beverages");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setText("Price per Unit");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setText("Qty");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setText("Cost");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setText("Add Item");

        btnAddItem.setBackground(new java.awt.Color(0, 0, 0));
        btnAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_buy_30px.png"))); // NOI18N
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        txticost.setBackground(new java.awt.Color(255, 204, 102));
        txticost.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtiqty.setBackground(new java.awt.Color(255, 204, 102));
        txtiqty.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtiqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtiqtyKeyReleased(evt);
            }
        });

        txtppitum.setBackground(new java.awt.Color(255, 204, 102));
        txtppitum.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_clear_shopping_cart_30px.png"))); // NOI18N
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearMouseExited(evt);
            }
        });
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setText("Clear");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item/Menu", "Price per Unit", "Qty", "Cost"
            }
        ));
        jTable2.setRowHeight(40);
        jScrollPane2.setViewportView(jTable2);

        btnCalculate.setBackground(new java.awt.Color(255, 255, 255));
        btnCalculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-calculate-48.png"))); // NOI18N
        btnCalculate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCalculateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCalculateMouseExited(evt);
            }
        });
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel21.setText("Net Total(Rs.) :");

        btnprintPreview.setBackground(new java.awt.Color(0, 0, 0));
        btnprintPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_fine_print_30px_2.png"))); // NOI18N
        btnprintPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintPreviewActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setText("Print Preview");

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel23.setText("Calculate Total");

        lblBNetTot.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bill");

        cmbbaverages.setBackground(new java.awt.Color(255, 204, 102));
        cmbbaverages.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbbaveragesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbbaverages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbbaveragesMouseClicked(evt);
            }
        });

        txtBillID.setBackground(new java.awt.Color(255, 204, 102));
        txtBillID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBillID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBillIDKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setText("Select Sweet Items");

        cmbbaked.setBackground(new java.awt.Color(255, 204, 102));
        cmbbaked.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbbakedPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbbaked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbbakedMouseClicked(evt);
            }
        });

        txtppbitum.setBackground(new java.awt.Color(255, 204, 102));
        txtppbitum.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setText("Price per Unit");

        txtbqty.setBackground(new java.awt.Color(255, 204, 102));
        txtbqty.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtbqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbqtyKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel27.setText("Qty");

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel28.setText("Cost");

        txtbcost.setBackground(new java.awt.Color(255, 204, 102));
        txtbcost.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnAddItem1.setBackground(new java.awt.Color(0, 0, 0));
        btnAddItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_buy_30px.png"))); // NOI18N
        btnAddItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItem1ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel29.setText("Add Item");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBNetTot, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnprintPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(557, 557, 557)))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbbaverages, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(txtppitum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtiqty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txticost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(199, 199, 199)
                            .addComponent(txtppbitum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtbqty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtbcost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(101, 101, 101)
                            .addComponent(btnAddItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbbaked, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(lblChashId, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblcashNo))
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(96, 96, 96)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(97, 97, 97)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(249, 249, 249)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(81, 81, 81)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(128, 128, 128)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(33, 33, 33)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtBillID, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtBillID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lblChashId)
                        .addComponent(lblcashNo)))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel27)
                        .addComponent(jLabel28)
                        .addComponent(jLabel26)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddItem1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtppbitum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbqty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbcost, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbbaked, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(13, 13, 13))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtppitum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtiqty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txticost, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbbaverages, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnprintPreview)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel22))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCalculate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(lblBNetTot, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnClear))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        txtAreaBill.setColumns(20);
        txtAreaBill.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtAreaBill.setRows(5);
        jScrollPane1.setViewportView(txtAreaBill);

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel25.setText("Confirm Print");

        btnconf.setBackground(new java.awt.Color(0, 0, 0));
        btnconf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_print_30px.png"))); // NOI18N
        btnconf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Print Preview");

        btnClear1.setBackground(new java.awt.Color(255, 255, 255));
        btnClear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_broom_38px.png"))); // NOI18N
        btnClear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClear1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClear1MouseExited(evt);
            }
        });
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setText("Clear");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnconf, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel5)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClear1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnconf))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel25))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel24)))))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(737, 737, 737))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 1920, 1050);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1040);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        // TODO add your handling code here:
        btnClear.setBackground(new Color(102,102,102,50));
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        // TODO add your handling code here:
        btnClear.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnClearMouseExited

    private void btnCalculateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalculateMouseEntered
        // TODO add your handling code here:
        btnCalculate.setBackground(new Color(102,102,102,50));
    }//GEN-LAST:event_btnCalculateMouseEntered

    private void btnCalculateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalculateMouseExited
        // TODO add your handling code here:
        btnCalculate.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnCalculateMouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new Restaurant().setVisible(true);
        this.setVisible(false);
                
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cmbbaveragesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbbaveragesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
        String tmp=(String)cmbbaverages.getSelectedItem();
        String sql="Select * from restitem where rItem=?";

        try {
            Connection conn=MySqlConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, tmp);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                txtppitum.setText(rs.getString("rUnitPrice"));
                repaint();
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbbaveragesPopupMenuWillBecomeInvisible

    private void cmbbaveragesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbbaveragesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbaveragesMouseClicked

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:
        try{
            Connection conn = MySqlConnection();
            String qry="select sum(cost)as tot from bill";
            PreparedStatement ps;
            ps = conn.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){

               lblBNetTot.setText(rs.getString("tot"));
                repaint();
            }
                
               
        }
        catch(Exception e){}
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnprintPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintPreviewActionPerformed
        // TODO add your handling code here:
        try {
             ArrayList<Bill> b1;
        b1 = retrieveData();
            
        BillHeader();
      for(int i =0;i<=b1.size();i++){
           
            txtAreaBill.append("\n"+"\t"+String.format("%-20s%-15s%-8s%-10s%n",b1.get(i).getName(),
            b1.get(i).getPpu(),
            b1.get(i).getQty(),
            b1.get(i).getCost()));
           
          }
           
            
        } catch (Exception e) {
        }
         txtAreaBill.append("\n"+"-----------------------------------------------------------------------"+"\n"+"\t\t\t\t\t"+
                 "Total:"+lblBNetTot.getText()+"\n"+"\t\t\t\t\t\t"+"==========");
        
      
     
    }//GEN-LAST:event_btnprintPreviewActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
         model.setRowCount(0);
         lblBNetTot.setText("");    
         txtppitum.setText("");
         txtiqty.setText("");
         txticost.setText("");
         repaint();
         try{
            Connection conn = MySqlConnection();
            String qry="truncate bill";
            PreparedStatement ps;
            ps = conn.prepareStatement(qry);
           ps.executeUpdate();
             
           
        }
        catch(Exception e){}
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtiqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiqtyKeyReleased
        // TODO add your handling code here:
         float price=Float.parseFloat(txtppitum.getText());
        int qty=Integer.parseInt(txtiqty.getText());

        float cost=price*qty;

        String cs=String.valueOf(cost);

        txticost.setText(cs);
    }//GEN-LAST:event_txtiqtyKeyReleased

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
      try {
                Connection conn = MySqlConnection();
                String qry="insert into bill(item,ppu,qty,cost)values"
                        + "(?,?,?,?)";
                PreparedStatement ps;
            ps = conn.prepareStatement(qry);
            ps.setString(1,cmbbaverages.getSelectedItem().toString());
            ps.setInt(3,Integer.parseInt(txtiqty.getText()));
            ps.setFloat(2,Float.parseFloat(txtppitum.getText()));
            ps.setFloat(4,Float.parseFloat(txticost.getText()));
                
                int res=ps.executeUpdate();
                fillTable();
                
         txtppitum.setText("");
         txtiqty.setText("");
         txticost.setText("");
                
        } catch (SQLException ex) {
            Logger.getLogger(RestBill2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnconfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfActionPerformed
        // TODO add your handling code here:
     JOptionPane.showMessageDialog(null,"Bill Confirmed!","Warning",JOptionPane.INFORMATION_MESSAGE);
     
          try{
            Connection conn = MySqlConnection();
            String qry="insert into payment(tot_amnt,Type) values(?,'Bakery')";
            PreparedStatement ps;
            ps = conn.prepareStatement(qry);
            
            ps.setFloat(1,Float.parseFloat(lblBNetTot.getText()));
            txtAreaBill.print();  
            ps.executeUpdate();
            
           
        }
        catch(Exception e){}
        
    }//GEN-LAST:event_btnconfActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        
        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnClear1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClear1MouseEntered
        // TODO add your handling code here:
         btnClear1.setBackground(new Color(102,102,102,50));
    }//GEN-LAST:event_btnClear1MouseEntered

    private void btnClear1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClear1MouseExited
        // TODO add your handling code here:
         btnClear1.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnClear1MouseExited

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
         model.setRowCount(0);
         lblBNetTot.setText("");
         txtppitum.setText("");
         txtiqty.setText("");
         txticost.setText("");
         txtAreaBill.setText("");
         txtppbitum.setText("");
         txtbqty.setText("");
         txtbcost.setText("");
         repaint();
         try{
            Connection conn = MySqlConnection();
            String qry="truncate bill";
            PreparedStatement ps;
            ps = conn.prepareStatement(qry);
           ps.executeUpdate();
             
          
        }
        catch(Exception e){}
        
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new OrderReqForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtBillIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillIDKeyReleased

    private void cmbbakedPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbbakedPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String tmp=(String)cmbbaked.getSelectedItem();
        String sql="Select * from bak_pro where product=?";

        try {
            Connection conn=MySqlConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, tmp);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                txtppbitum.setText(rs.getString("unitPrice"));
                repaint();
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbbakedPopupMenuWillBecomeInvisible

    private void cmbbakedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbbakedMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_cmbbakedMouseClicked

    private void txtbqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbqtyKeyReleased
        // TODO add your handling code here:
        float price=Float.parseFloat(txtppbitum.getText());
        int qty=Integer.parseInt(txtbqty.getText());

        float cost=price*qty;

        String cs=String.valueOf(cost);

        txtbcost.setText(cs);
    }//GEN-LAST:event_txtbqtyKeyReleased

    private void btnAddItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItem1ActionPerformed
        // TODO add your handling code here:
          try {
                Connection conn = MySqlConnection();
                String qry="insert into bill(item,ppu,qty,cost)values"
                        + "(?,?,?,?)";
                PreparedStatement ps;
            ps = conn.prepareStatement(qry);
            ps.setString(1,cmbbaked.getSelectedItem().toString());
            ps.setInt(3,Integer.parseInt(txtbqty.getText()));
            ps.setFloat(2,Float.parseFloat(txtppbitum.getText()));
            ps.setFloat(4,Float.parseFloat(txtbcost.getText()));
                
                int res=ps.executeUpdate();
                fillTable();
                
         txtppbitum.setText("");
         txtbqty.setText("");
         txtbcost.setText("");
                
        } catch (SQLException ex) {
            Logger.getLogger(RestBill2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(BakBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BakBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BakBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BakBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BakBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddItem1;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnconf;
    private javax.swing.JButton btnprintPreview;
    private javax.swing.JComboBox<String> cmbbaked;
    private javax.swing.JComboBox<String> cmbbaverages;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblBNetTot;
    private javax.swing.JLabel lblChashId;
    private javax.swing.JLabel lblcashNo;
    private javax.swing.JTextArea txtAreaBill;
    private javax.swing.JTextField txtBillID;
    private javax.swing.JTextField txtbcost;
    private javax.swing.JTextField txtbqty;
    private javax.swing.JTextField txticost;
    private javax.swing.JTextField txtiqty;
    private javax.swing.JTextField txtppbitum;
    private javax.swing.JTextField txtppitum;
    // End of variables declaration//GEN-END:variables
 static public class HeaderColor extends DefaultTableCellRenderer{
        public HeaderColor(){
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable jTable1,Object value,boolean selected,boolean foused,int row,int column){
            super.getTableCellRendererComponent(jTable1, value, selected, foused, row, column);
            setBackground(new java.awt.Color(255,102,0,180));
            setFont(new Font("Calibri",Font.BOLD,20));
            return this;
        }
     }

}

