package HallFunc.HallFunct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.sun.xml.internal.bind.v2.model.impl.ModelBuilder;
import HallFunc.Dashboard.DashboardBooking;
import HallFunc.Report.Report_rash;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import HallFunc.mycode.DBconnect;
import Hangout.Home.Home;
import net.proteanit.sql.DbUtils;
import java.util.regex.*;
import javax.swing.UIManager;

/**
 *
 * @author BEYOND
 */
public class HallFunc extends javax.swing.JFrame {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    /**
     * Creates new form MenuManagement
     */
    public HallFunc() {
        initComponents();
        
        //connect to DB
        con=DBconnect.connect();

        
        tableload();
        custTableLoad();
       
        
        jPanel1.setBackground(new Color(255,102,0,180));
        jPanel2.setBackground(new Color(0,0,0,150));
        jLabel1.setBackground(new Color (0,0,0,100));
        jPanel3.setBackground(new Color(255,102,0,180));
        jPanel4.setBackground(new Color(255,102,0,180));
        btnBookingReport.setBackground(new Color(255,102,0,180));
        btnBookingManagement.setBackground(Color.WHITE);
        logout_btn10.setBackground(new Color(255,102,0,180));
       
        table.getTableHeader().setDefaultRenderer(new HeaderColor());
            
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void loadFunctionID(){

//   String functionID = txtFunctionID.getText();
//        int billNumber = Integer.valueOf(functionID);
//        functionID = Integer.toString(++billNumber);
//        txtFunctionID.setText("functionID");

                              
    this.setExtendedState(MAXIMIZED_BOTH);
}
  

    public  void tableload(){
     
        try {
            String sql="SELECT functionID,phone,custID,cust_name,func_date,func_time,packageID,menuID,no_of_people,amount,advance,tax,serviceCharge,total FROM hall_function";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
        
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            
        }
        
            
    }
    
     public  void custTableLoad(){
        try {
           String sql="SELECT customerID,cus_name,Phone FROM customer";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        custTable.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            
        }
     }
    
    public boolean deleteFunctionid(String phone){
        PreparedStatement st;
        String deleteQuery = "DELETE FROM hall_function WHERE phone=?";
        
        try {
            st = con.prepareStatement(deleteQuery);
            st.setString(1, phone);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            //Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

     public boolean updateFunction(String phone,String customerID,String customerName,String date,String time,String packages,String menuID,int noOfPeople,double amount,double  advance,double tax,double  serviceCharge,double  total,String functionID){
        
        PreparedStatement st;
        String editQuery = "UPDATE hall_function SET phone=?,customerID=?,customerName=?=date=?,time=?,packages=?,menuID=?,noOfPeople=?,amount=?,advance=?,tax=?,serviceCharge=?,total=? WHERE functionID=?";
        
        try {
            st = con.prepareStatement(editQuery);
            
            st.setString(1, phone);
            st.setString(2, customerID);
            st.setString(3, customerName);
            st.setString(4, date);
            st.setString(5, time);
            st.setString(6, packages);
            st.setString(7, menuID);
            st.setInt(8, noOfPeople);
            st.setDouble(9, amount);
            st.setDouble(10, advance);
            st.setDouble(11, tax);
            st.setDouble(12, serviceCharge);
            st.setDouble(13, total);
	    st.setString(14, functionID);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            //Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBookingReport = new javax.swing.JButton();
        btnBookingManagement = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        logout_btn10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFunctionID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtCustID = new javax.swing.JTextField();
        txtCustName = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        txtNoOfPeople = new javax.swing.JTextField();
        txtAdvance = new javax.swing.JTextField();
        txtTax = new javax.swing.JTextField();
        txtServiceCharge = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtPackage = new javax.swing.JComboBox<>();
        txtMenuID = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        btnSearch2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();
        txtCustSearch = new javax.swing.JTextField();
        btnSearch1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HallFunc/HallFunct/Logo.png"))); // NOI18N
        jLabel2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Chiller", 1, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FUNCTION HALL MANAGEMENT");

        btnBookingReport.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnBookingReport.setText("BOOKING REPORTS");
        btnBookingReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingReportActionPerformed(evt);
            }
        });

        btnBookingManagement.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnBookingManagement.setText("BOOKING MANAGEMENT");
        btnBookingManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingManagementActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        logout_btn10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        logout_btn10.setText("Log Out");
        logout_btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btn10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                        .addComponent(btnBookingManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnBookingReport, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(699, 699, 699))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout_btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(logout_btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBookingReport, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBookingManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_40px.png"))); // NOI18N
        btnAdd.setText(" Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_refresh_38px.png"))); // NOI18N
        btnUpdate.setText(" Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_sign_38px_1.png"))); // NOI18N
        btnDelete.setText(" Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Booking Information");

        txtFunctionID.setEditable(false);
        txtFunctionID.setBackground(new java.awt.Color(255, 204, 102));
        txtFunctionID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFunctionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFunctionIDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel6.setText("Function ID");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setText("Advance");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setText("Remaining");

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setText("Time");

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel14.setText("Package");

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel15.setText("Number of people");

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel16.setText("Menu ID");

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel17.setText("Amount");

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel18.setText("Tax");

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel19.setText("Phone");

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel20.setText("Customer ID");

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel21.setText("Date");

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel22.setText("Customer Name");

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel23.setText("Service charge");

        txtCustID.setEditable(false);
        txtCustID.setBackground(new java.awt.Color(255, 204, 102));
        txtCustID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCustID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustIDActionPerformed(evt);
            }
        });

        txtCustName.setEditable(false);
        txtCustName.setBackground(new java.awt.Color(255, 204, 102));
        txtCustName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtTime.setBackground(new java.awt.Color(255, 204, 102));
        txtTime.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtAmount.setBackground(new java.awt.Color(255, 204, 102));
        txtAmount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
        });

        txtNoOfPeople.setBackground(new java.awt.Color(255, 204, 102));
        txtNoOfPeople.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNoOfPeople.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoOfPeopleKeyPressed(evt);
            }
        });

        txtAdvance.setBackground(new java.awt.Color(255, 204, 102));
        txtAdvance.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAdvance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdvanceKeyPressed(evt);
            }
        });

        txtTax.setEditable(false);
        txtTax.setBackground(new java.awt.Color(255, 204, 102));
        txtTax.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTaxKeyPressed(evt);
            }
        });

        txtServiceCharge.setBackground(new java.awt.Color(255, 204, 102));
        txtServiceCharge.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtServiceCharge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtServiceChargeKeyPressed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 204, 102));
        txtTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });

        txtPhone.setEditable(false);
        txtPhone.setBackground(new java.awt.Color(255, 204, 102));
        txtPhone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtPackage.setBackground(new java.awt.Color(255, 204, 102));
        txtPackage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "package 1", "package 2", "package 3", "package 4" }));
        txtPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPackageActionPerformed(evt);
            }
        });

        txtMenuID.setBackground(new java.awt.Color(255, 204, 102));
        txtMenuID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fast food special", "Biriyani", "Chef's special", "Apperizers", "Sandwiches" }));

        txtDate.setForeground(new java.awt.Color(255, 204, 0));
        txtDate.setDateFormatString("yyyy/MM/dd");
        txtDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDateMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDateMousePressed(evt);
            }
        });

        btnSearch2.setBackground(new java.awt.Color(255, 204, 102));
        btnSearch2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSearch2.setText("Search");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel13))
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel18))
                                .addGap(95, 95, 95)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(txtMenuID, 0, 164, Short.MAX_VALUE)
                                    .addComponent(txtPhone)
                                    .addComponent(txtAmount)
                                    .addComponent(txtTax)
                                    .addComponent(txtServiceCharge)
                                    .addComponent(txtTotal)
                                    .addComponent(txtFunctionID)
                                    .addComponent(txtAdvance)
                                    .addComponent(txtTime)
                                    .addComponent(txtCustName)
                                    .addComponent(txtCustID)
                                    .addComponent(txtPackage, 0, 164, Short.MAX_VALUE)
                                    .addComponent(txtNoOfPeople, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(btnSearch2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnUpdate)
                        .addGap(40, 40, 40)
                        .addComponent(btnDelete)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnUpdate});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtFunctionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel21)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMenuID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNoOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(txtTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtServiceCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnUpdate});

        table.setBackground(new java.awt.Color(240, 240, 240));
        table.setFont(new java.awt.Font("Calibri", 0, 18));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Function ID", "Phone", "CustID", "Customer Name", "Date", "Time", "Package", "Menu", "No Of People", "Amount", "Advance", "Tax", "Service Charge", "Total", "func_status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        txtSearch.setBackground(new java.awt.Color(255, 204, 102));
        txtSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearch.setPreferredSize(new java.awt.Dimension(308, 43));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 0, 0));
        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_38px_1.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CustID", "Customer Name", "phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        custTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(custTable);

        txtCustSearch.setBackground(new java.awt.Color(255, 204, 102));
        txtCustSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCustSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCustSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCustSearch.setPreferredSize(new java.awt.Dimension(308, 43));
        txtCustSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustSearchActionPerformed(evt);
            }
        });
        txtCustSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustSearchKeyPressed(evt);
            }
        });

        btnSearch1.setBackground(new java.awt.Color(0, 0, 0));
        btnSearch1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_38px_1.png"))); // NOI18N
        btnSearch1.setText("Search");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("registered customer details");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1311, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(410, 410, 410)
                            .addComponent(txtCustSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSearch1))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(490, 490, 490)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Booking Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 79, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 1090);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HallFunc/HallFunct/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1960, 1110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        //String functionID=txtFunctionID.getText();
        String phone=txtPhone.getText();
        String customerID=txtCustID.getText();
        String customerName=txtCustName.getText();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=dateFormat.format(txtDate.getDate());
        String time=txtTime.getText();
        String packages=txtPackage.getSelectedItem().toString();
        String menuID=txtMenuID.getSelectedItem().toString();
        String noOfPeople=txtNoOfPeople.getText();
        String amount=txtAmount.getText();
        String advance=txtAdvance.getText();
        String tax=txtTax.getText();
        String serviceCharge=txtServiceCharge.getText();
        String total=txtTotal.getText();
        
        Pattern p=Pattern.compile("^[0-1][0-9]{10}$");
        Matcher m=p.matcher(txtPhone.getText());
        
        System.out.println(date);
       /* 
        if(m.matches()){
            JOptionPane.showMessageDialog(null, "Invalid mobile number");
        }
        */
        if( txtPhone.getText().toString().equals(" ") || txtCustID.getText().toString().equals(" ") || 
                txtCustName.getText().toString().equals(" ") || txtTime.getText().toString().equals(" ") || txtPackage.getSelectedItem().equals(" ")|| txtMenuID.getSelectedItem().equals(" ")|| txtNoOfPeople.getText().toString().equals( "")|| txtAmount.getText().toString().equals( "")|| txtAdvance.getText().toString().equals( "")|| txtTax.getText().toString().equals( "")||  txtServiceCharge.getText().toString().equals( "")|| txtTotal.getText().toString().equals( "")/*|| jDateChooser2.getDate().toString().equals(" ")*/){
                JOptionPane.showMessageDialog(rootPane, "Required fields cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        
        try {
            String q="insert into hall_function (phone,custID,cust_name,func_date,func_time,packageID,menuID,no_of_people,amount,advance,tax,serviceCharge,total) "
                    + "values('"+phone+"','"+customerID+"','"+customerName+"','"+date+"','"+time+"','"+packages+"','"+menuID+"',"
                    + "'"+noOfPeople+"','"+amount+"','"+advance+"','"+tax+"','"+serviceCharge+"','"+total+"') ";
            pst=con.prepareStatement(q);
           // testDate();
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Added");
            tableload();
        } 
        catch (Exception e) {
             System.out.println(e+"Not added successfully");
             //JOptionPane.showMessageDialog(rootPane, "Select the date", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        /*catch(NullPointerException ex){
            JOptionPane.showMessageDialog(rootPane, "Select the expiry date", "Warning", JOptionPane.WARNING_MESSAGE);
       }*/
        txtFunctionID.setText("");
        txtPhone.setText("");
        txtCustID.setText("");
        txtCustName.setText("");
        txtDate.setDateFormatString("");
        txtTime.setText("");
        txtPackage.setSelectedItem("");
        txtMenuID.setSelectedItem("");
        txtNoOfPeople.setText("");
        txtAmount.setText("");
        txtAdvance.setText("");
        txtTax.setText("");
        txtServiceCharge.setText("");
        txtTotal.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void btnBookingReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingReportActionPerformed
        // TODO add your handling code here:
        new Report_rash().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBookingReportActionPerformed

    private void btnBookingManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingManagementActionPerformed
        // TODO add your handling code here:
        new HallFunc().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBookingManagementActionPerformed

    private void txtPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPackageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPackageActionPerformed

    private void txtFunctionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFunctionIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFunctionIDActionPerformed

    private void txtCustIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustIDActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
//        
//        int r=table.getSelectedRow();
//        
//        String funcID=table.getValueAt(r, 0).toString();
//        String phone=table.getValueAt(r, 1).toString();
//        String custID=table.getValueAt(r, 2).toString();
//        String name=table.getValueAt(r, 3).toString();
//        String date=table.getValueAt(r, 4).toString();
//        String time=table.getValueAt(r, 5).toString();
//        String packages=table.getValueAt(r, 6).toString();
//        String menu=table.getValueAt(r, 7).toString();
//        String num=table.getValueAt(r, 8).toString();
//        String amount=table.getValueAt(r, 9).toString();
//        String advance=table.getValueAt(r, 10).toString();
//        String tax=table.getValueAt(r, 11).toString();
//        String serviceCharge=table.getValueAt(r, 12).toString();
//        String total=table.getValueAt(r, 13).toString();
//        
//        txtFunctionID.setText(funcID);
//        txtPhone.setText(phone);
//        txtCustID.setText(custID);
//        txtCustName.setText(name);
//        txtDate.setDateFormatString(date);
//        txtTime.setText(time);
//        txtPackage.setSelectedItem(packages);
//        txtMenuID.setSelectedItem(menu);
//        txtNoOfPeople.setText(num);
//        txtAmount.setText(amount);
//        txtAdvance.setText(advance);
//        txtTax.setText(tax);
//        txtServiceCharge.setText(serviceCharge);
//        txtTotal.setText(total);
//        
mouseClick();
    }//GEN-LAST:event_tableMouseClicked

    public void mouseClick(){
         int r=table.getSelectedRow();
        
        String funcID=table.getValueAt(r, 0).toString();
        String phone=table.getValueAt(r, 1).toString();
        String custID=table.getValueAt(r, 2).toString();
        String name=table.getValueAt(r, 3).toString();
        String date=table.getValueAt(r, 4).toString();
        String time=table.getValueAt(r, 5).toString();
        String packages=table.getValueAt(r, 6).toString();
        String menu=table.getValueAt(r, 7).toString();
        String num=table.getValueAt(r, 8).toString();
        String amount=table.getValueAt(r, 9).toString();
        String advance=table.getValueAt(r, 10).toString();
        String tax=table.getValueAt(r, 11).toString();
        String serviceCharge=table.getValueAt(r, 12).toString();
        String total=table.getValueAt(r, 13).toString();
        
        txtFunctionID.setText(funcID);
        txtPhone.setText(phone);
        txtCustID.setText(custID);
        txtCustName.setText(name);
        txtDate.setDateFormatString(date);
        txtTime.setText(time);
        txtPackage.setSelectedItem(packages);
        txtMenuID.setSelectedItem(menu);
        txtNoOfPeople.setText(num);
        txtAmount.setText(amount);
        txtAdvance.setText(advance);
        txtTax.setText(tax);
        txtServiceCharge.setText(serviceCharge);
        txtTotal.setText(total);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
                  
            String functionID=txtFunctionID.getText();
            String phone=txtPhone.getText();
            String customerID=txtCustID.getText();
            String customerName=txtCustName.getText();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date=dateFormat.format(txtDate.getDate());
            String time=txtTime.getText();
            String packages=txtPackage.getSelectedItem().toString();
            String menuID=txtMenuID.getSelectedItem().toString();
            int noOfPeople=Integer.parseInt(txtNoOfPeople.getText());
            double amount=Double.parseDouble(txtAmount.getText());
            double advance=Double.parseDouble(txtAdvance.getText());
            double tax=Double.parseDouble(txtTax.getText());
            double serviceCharge=Double.parseDouble(txtServiceCharge.getText());
            double total=Double.parseDouble(txtTotal.getText());

        PreparedStatement st;
        String editQuery = "UPDATE hall_function SET phone=?,custID=?,cust_name=?,func_date=?,func_time=?,packageID=?,menuID=?,no_of_people=?,amount=?,advance=?,tax=?,serviceCharge=?,total=? WHERE functionID=?";
         
        // UPDATE `hall_function` SET `functionID`=[value-1],`phone`=[value-2],`custID`=[value-3],`cust_name`=[value-4],`func_date`=[value-5],`func_time`=[value-6],`packageID`=[value-7],`menuID`=[value-8],`no_of_people`=[value-9],`amount`=[value-10],`advance`=[value-11],`tax`=[value-12],`serviceCharge`=[value-13],`total`=[value-14],`func_status`=[value-15],`paymentID`=[value-16] WHERE phone
        try {
            st = con.prepareStatement(editQuery);
           
           st.setString(1, phone);
            st.setString(2, customerID);
            st.setString(3, customerName);
            st.setString(4, date);
            st.setString(5, time);
            st.setString(6, packages);
            st.setString(7, menuID);
            st.setInt(8, noOfPeople);
            st.setDouble(9, amount);
            st.setDouble(10, advance);
            st.setDouble(11, tax);
            st.setDouble(12, serviceCharge);
            st.setDouble(13, total);
	   
            st.setString(14, functionID);
           // return (st.executeUpdate() > 0);
            int rowsUpdated = st.executeUpdate();
            
            if (rowsUpdated > 0) {
                tableload();
                JOptionPane.showMessageDialog(rootPane, "Updated successfully", "Remove product", JOptionPane.INFORMATION_MESSAGE);
            }
        }       
        catch (SQLException ex) {
            Logger.getLogger(HallFunc.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    
    
    
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        int row = table.getSelectedRow();
        String phone = (String) table.getValueAt(row, 1);
        
        if(deleteFunctionid(phone)){
            JOptionPane.showMessageDialog(rootPane, "Removed successfully", "Remove product", JOptionPane.INFORMATION_MESSAGE);
            tableload();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Function could not be removed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        txtFunctionID.setText("");
        txtPhone.setText("");
        txtCustID.setText("");
        txtCustName.setText("");
        txtDate.setDateFormatString("");
        txtTime.setText("");
        txtPackage.setSelectedItem("");
        txtMenuID.setSelectedItem("");
        txtNoOfPeople.setText("");
        txtAmount.setText("");
        txtAdvance.setText("");
        txtTax.setText("");
        txtServiceCharge.setText("");
        txtTotal.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        if(txtSearch.getText().equals("")) {
            tableload();
        }      
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtServiceChargeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServiceChargeKeyPressed
        // TODO add your handling code here:
        double netpay;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double a = Double.parseDouble(txtAmount.getText());
        double b = Double.parseDouble(txtAdvance.getText()); 
        // double x = Double.parseDouble(txtTax.getText()); 
        double y = Double.parseDouble(txtServiceCharge.getText()); 
        double x=a*0.2;
        String d = String.valueOf(numberFormat.format(x));
        netpay = a-b+x+y; 
        String netpayy = String.valueOf(numberFormat.format(netpay));
        txtTax.setText(d);
        txtTotal.setText(netpayy);
    }//GEN-LAST:event_txtServiceChargeKeyPressed

    private void txtAdvanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdvanceKeyPressed
        // TODO add your handling code here:
        double a = Double.parseDouble(txtAmount.getText());
        double b = Double.parseDouble(txtAdvance.getText());
        
        if(a>b){
            cal();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Inavalid data", "Error", JOptionPane.ERROR_MESSAGE);
            txtAdvance.setText("");
            txtAmount.setText("");
            txtTax.setText("");
            txtAmount.setText("");
            txtServiceCharge.setText("");
        }
    }//GEN-LAST:event_txtAdvanceKeyPressed

    private void txtTaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaxKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTaxKeyPressed

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed
        // TODO add your handling code here:
        double netpay;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double a = Double.parseDouble(txtAmount.getText());
        
        double x=a*0.2;
        //double advance=a*0.35;
        String d = String.valueOf(numberFormat.format(x));
        //String e = String.valueOf(numberFormat.format(advance));
        
        txtTax.setText(d);
        //txtAdvance.setText(e);
    }//GEN-LAST:event_txtAmountKeyPressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new DashboardBooking().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        String phone=txtSearch.getText();
        String sql="SELECT functionID,phone,custID,cust_name,func_date,func_time,packageID,menuID,no_of_people,amount,advance,tax,serviceCharge,total FROM hall_function where phone like '%"+phone+"%'";
        
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
                
            table.setModel(DbUtils.resultSetToTableModel(rs));
            mouseClick();
                
        } 
        catch (Exception e){
                
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_txtDateMouseClicked

    private void txtDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateMousePressed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_txtDateMousePressed

    private void txtCustSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustSearchActionPerformed

    private void txtCustSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustSearchKeyPressed
        // TODO add your handling code here:
        String phone=txtCustSearch.getText();
        String sql="SELECT customerID,cus_Name,Phone FROM customer where Phone like '%"+phone+"%'";
        
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
                
            custTable.setModel(DbUtils.resultSetToTableModel(rs));
            mouseClick();
                
        } 
        catch (Exception e) 
         {
                
         } 
    }//GEN-LAST:event_txtCustSearchKeyPressed

    private void custTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custTableMouseClicked
        // TODO add your handling code here:
        int r=custTable.getSelectedRow();
        
        String custID=custTable.getValueAt(r, 0).toString();
        String name=custTable.getValueAt(r, 1).toString();
        String phone=custTable.getValueAt(r, 2).toString();
        
        txtCustID.setText(custID);
        txtCustName.setText(name);
        txtPhone.setText(phone);
        
        
        
    }//GEN-LAST:event_custTableMouseClicked

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtNoOfPeopleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfPeopleKeyPressed
//        // TODO add your handling code here:
//        String value = txtNoOfPeople.getText();
//        int l = value.length();
//        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
//            txtNoOfPeople.setEditable(true);
//            txtNoOfPeople.setText("");
//        } else {
//            txtNoOfPeople.setEditable(false);
//            txtNoOfPeople.setText("* Enter only numeric digits");
//    }
    }//GEN-LAST:event_txtNoOfPeopleKeyPressed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String d = dateFormat.format(txtDate.getDate());
        System.out.println(d);
        //String date=dateFormat.format(txtDate.getDate());
        try {
            String q="SELECT * FROM hall_function where func_date=?";
            pst=con.prepareStatement(q);
            pst.setString(1, d);
            
            rs=pst.executeQuery();
                
            if(rs.next()){
                    
                    JOptionPane.showMessageDialog(rootPane, "Already taken", "Check date", JOptionPane.INFORMATION_MESSAGE);
                    
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Available", "Check date", JOptionPane.INFORMATION_MESSAGE);
            }
                
        } 
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void logout_btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btn10ActionPerformed

        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);

        JOptionPane.showMessageDialog(null, "You have successfully Log out");
    }//GEN-LAST:event_logout_btn10ActionPerformed

    public void cal(){
        double netpay;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double a = Double.parseDouble(txtAmount.getText());
        double b = Double.parseDouble(txtAdvance.getText()); 
        double x = Double.parseDouble(txtTax.getText()); 
        double y = Double.parseDouble(txtServiceCharge.getText()); 

        netpay = a -b+x+y; 
        String netpayy = String.valueOf(numberFormat.format(netpay));

        txtTotal.setText(netpayy);
    }
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
            java.util.logging.Logger.getLogger(HallFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HallFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HallFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HallFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HallFunc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBookingManagement;
    private javax.swing.JButton btnBookingReport;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable custTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JButton logout_btn10;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAdvance;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCustID;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtCustSearch;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtFunctionID;
    private javax.swing.JComboBox<String> txtMenuID;
    private javax.swing.JTextField txtNoOfPeople;
    private javax.swing.JComboBox<String> txtPackage;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtServiceCharge;
    private javax.swing.JTextField txtTax;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    static public class HeaderColor extends DefaultTableCellRenderer{
        public HeaderColor(){
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable jTable1,Object value,boolean selected,boolean foused,int row,int column){
            super.getTableCellRendererComponent(jTable1, value, selected, foused, row, column);
            setBackground(new java.awt.Color(255,102,0,180));
            setFont(new Font("Calibri",Font.BOLD,17));
            return this;
        }
    }
}
