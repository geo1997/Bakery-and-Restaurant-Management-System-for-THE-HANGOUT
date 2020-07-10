package Employee.PermEmpSal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Employee.Attendance.Attendance;
import Employee.EmpDetails.EmDet;
import Employee.Emp_leaves.EmpLeaves;
import Employee.Dashboard.EmployeeManagement;
import Employee.Report_emp.EmployeeManagamentDash_Reports;
import Employee.Report_emp.Report_emp;
import Employee.TempEmpSal.TempEmpSal;
import Hangout.Home.Home;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import ui.Home;

/**
 *
 * @author BEYOND
 */
public class EmpSal extends javax.swing.JFrame {
    
    

    /**
     * Creates new form MenuManagement
     */
    public EmpSal() {
        initComponents();
        jPanel1.setBackground(new Color(255, 102, 0, 180));
        jPanel2.setBackground(new Color(0, 0, 0, 150));
        jLabel1.setBackground(new Color(0, 0, 0, 100));
        //jPanel3.setBackground(new Color(255,102,0,180));
        jPanel3.setBackground(new Color(255, 102, 0, 180));
        jPanel4.setBackground(new Color(255, 102, 0, 180));

        Emp_Det.setBackground(new Color(255, 102, 0, 180));
        jButton5.setBackground(new Color(255, 102, 0, 180));
        jButton7.setBackground(new Color(255, 102, 0, 180));
        jButton6.setBackground(new Color(255, 102, 0, 180));
        jButton9.setBackground(new Color(255, 102, 0, 180));
        jButton10.setBackground(new Color(255, 102, 0, 180));
        //jTextField7.setBackground(new Color(255, 102, 0, 180));
        comboBoxMonth.setBackground(new Color(255, 102, 0, 180));
        
         logout_btn.setBackground(new Color(255, 102, 0, 180));

        table_sal.getTableHeader().setDefaultRenderer(new HeaderColor());
        
        jButton6.setBackground(Color.white);
        
        fillClientJtable(table_sal);

        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public Connection getConnection(){
        Connection conn = null;
        
        String db = "hangout";
        String url = "jdbc:mysql://localhost:3306/"+db;
        String username = "root";
        String password = "root";
        
        try {
            conn = DriverManager.getConnection(url,username,password);
            return conn;
        } catch (SQLException e) {
            return null;
        }
    }

    public class autoFilldetails{
   
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public ResultSet find(String s){
        try {
            
        con = DriverManager.getConnection("jdbc:mysql://localhost/hangout","root","root");
        ps = con.prepareStatement("select e.fname,e.lname,pt.basicSalary from permanentemp pt ,employee e where e.id=pt.peid and  pt.peid =? ");
        ps.setString(1, s);
        //ps.setString(2, s);
        rs=ps.executeQuery();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
     
        return rs;
    }    
}
    //Prepopulate
    public void fillClientJtable(JTable table){
    
    String valToSearch=tfSearch.getText();
    PreparedStatement ps;
    ResultSet rs;
    String selectQuery = "Select e.id,e.fname,e.lname,p.year,p.month,p.netSal from employee e, permanentemp p where e.id = p.peid and concat(e.id,e.fname,e.lname,p.year,p.month,p.netSal)LIKE '%"+valToSearch+"%' "
            + "order by p.month ";
    
   
        try {
            
              Connection con = getConnection();
             ps=con.prepareStatement(selectQuery);
            
              rs=ps.executeQuery();
        
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        
        Object[] row;
       
        while(rs.next()){
            row = new Object[6];
            row[0]=rs.getInt(1);
            row[1]=rs.getString(2);
            row[2]=rs.getString(3);
            row[3]=rs.getString(4);
            row[4]=rs.getString(5);
            row[5]=rs.getDouble(6);
            
            tableModel.addRow(row);
            
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpLeaves.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      

     
}
    
    public boolean verifyBonus()
    {
     
        try{
            double sal = Double.parseDouble(tfBonus.getText());
            labelBonus.setText("");
            return true;
        }catch(NumberFormatException ex){
                labelBonus.setText("Invalid bonus enetered");
                return false;
                }
    }
    
    public boolean verifyHrate()
    {
     
        try{
            double sal = Double.parseDouble(tfHrate.getText());
            labelHrate.setText("");
            return true;
        }catch(NumberFormatException ex){
                labelHrate.setText("Invalid hourly rate enetered");
                return false;
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
        jLabel2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Emp_Det = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        userwelcomejlabel = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfEid = new javax.swing.JTextField();
        tfLname = new javax.swing.JTextField();
        tfFname = new javax.swing.JTextField();
        tfBasicSal = new javax.swing.JTextField();
        tfOt = new javax.swing.JTextField();
        tfNetSal = new javax.swing.JTextField();
        tfBonus = new javax.swing.JTextField();
        tfEpf = new javax.swing.JTextField();
        tfHours = new javax.swing.JTextField();
        tfHrate = new javax.swing.JTextField();
        tfEtf = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jYearChooser = new com.toedter.calendar.JYearChooser();
        btn_search_det = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelBonus = new javax.swing.JLabel();
        labelHrate = new javax.swing.JLabel();
        comboBoxMonth = new com.toedter.calendar.JMonthChooser();
        jPanel4 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_sal = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        jLabel2.setToolTipText("");

        jButton10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton10.setText("Employee Reports");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton9.setText("Temporary Employee Salary");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton6.setText("Permanenet Employee Salary");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton7.setText("Employee Attendance");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton5.setText("Leave Managment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Emp_Det.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Emp_Det.setText("Employee Details");
        Emp_Det.setFocusPainted(false);
        Emp_Det.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Emp_DetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Emp_DetMouseExited(evt);
            }
        });
        Emp_Det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emp_DetActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Chiller", 1, 60)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Employee Management");

        userwelcomejlabel.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        userwelcomejlabel.setForeground(new java.awt.Color(255, 255, 255));

        logout_btn.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        logout_btn.setText("Log Out");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
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
                        .addGap(29, 29, 29)
                        .addComponent(Emp_Det, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(622, 622, 622)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(userwelcomejlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(125, 125, 125))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(userwelcomejlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Emp_Det, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel8.setText("Permanent Employee Salary");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel3.setText("Employee ID");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setText("Basic Salary");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel7.setText("Bonus");

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel10.setText("ETF");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel11.setText("EPF");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel12.setText("Extra Hours");

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel13.setText("Hourly Rate");

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel14.setText("Overtime");

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel15.setText("Net Salary");

        tfEid.setBackground(new java.awt.Color(255, 204, 102));

        tfLname.setEditable(false);
        tfLname.setBackground(new java.awt.Color(255, 204, 102));

        tfFname.setEditable(false);
        tfFname.setBackground(new java.awt.Color(255, 204, 102));

        tfBasicSal.setEditable(false);
        tfBasicSal.setBackground(new java.awt.Color(255, 204, 102));

        tfOt.setEditable(false);
        tfOt.setBackground(new java.awt.Color(255, 204, 102));

        tfNetSal.setEditable(false);
        tfNetSal.setBackground(new java.awt.Color(255, 204, 102));

        tfBonus.setBackground(new java.awt.Color(255, 204, 102));
        tfBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBonusKeyPressed(evt);
            }
        });

        tfEpf.setEditable(false);
        tfEpf.setBackground(new java.awt.Color(255, 204, 102));

        tfHours.setBackground(new java.awt.Color(255, 204, 102));

        tfHrate.setBackground(new java.awt.Color(255, 204, 102));
        tfHrate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfHrateKeyPressed(evt);
            }
        });

        tfEtf.setEditable(false);
        tfEtf.setBackground(new java.awt.Color(255, 204, 102));

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_calculator_38px.png"))); // NOI18N
        jButton8.setText("Calculate");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel18.setText("Select Month");

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel19.setText("Select Year");

        jYearChooser.setBackground(new java.awt.Color(255, 204, 102));

        btn_search_det.setBackground(new java.awt.Color(0, 0, 0));
        btn_search_det.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_search_det.setForeground(new java.awt.Color(255, 255, 255));
        btn_search_det.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_38px.png"))); // NOI18N
        btn_search_det.setText("Search");
        btn_search_det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_detActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_refresh_38px_1.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(77, 77, 77))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfBasicSal, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(tfLname)
                                .addComponent(tfEid)
                                .addComponent(tfFname)
                                .addComponent(tfBonus, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(tfOt, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(tfEpf, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(tfHours, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(tfHrate, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(tfEtf, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(jYearChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfNetSal, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(btn_search_det, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelBonus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelHrate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_search_det)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfEid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(labelBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEpf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEtf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHours, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfHrate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHrate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfNetSal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(25, 25, 25)))
                .addComponent(jButton3)
                .addGap(127, 127, 127))
        );

        tfSearch.setBackground(new java.awt.Color(255, 204, 102));
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchKeyPressed(evt);
            }
        });

        table_sal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Year", "Month", "Net Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_sal.setRowHeight(40);
        table_sal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_salMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_sal);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_32px_1.png"))); // NOI18N
        jLabel16.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(420, 420, 420))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel17)
                .addGap(71, 71, 71)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(240, 240, 240));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 1090);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1960, 1110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

       EmployeeManagamentDash_Reports rep = new EmployeeManagamentDash_Reports();
        rep.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        TempEmpSal temSal = new TempEmpSal();
        temSal.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        Attendance atten = new Attendance();
        atten.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        EmpLeaves leaves = new EmpLeaves();
        leaves.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Emp_DetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Emp_DetMouseEntered
        // TODO add your handling code here:
        Emp_Det.setBackground(Color.white);
    }//GEN-LAST:event_Emp_DetMouseEntered

    private void Emp_DetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Emp_DetMouseExited
        // TODO add your handling code here:
        Emp_Det.setBackground(new Color(255, 102, 0, 180));
    }//GEN-LAST:event_Emp_DetMouseExited

    private void Emp_DetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_DetActionPerformed

        EmDet e1 = new EmDet();
        e1.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_Emp_DetActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
      
            
            Double basicSal=Double.parseDouble(tfBasicSal.getText());
            Double bonus =Double.parseDouble((tfBonus.getText()));
            Double hours = Double.parseDouble(tfHours.getText());
            Double rate = Double.parseDouble(tfHrate.getText());
            Double ot = hours*rate;
            Double epf = Double.parseDouble(tfEpf.getText());
            
            String finalOt = String.valueOf(ot);
            tfOt.setText(finalOt);
            Double tot =(basicSal+ot+bonus-epf);
            String val=String.valueOf(tot);
        
            tfNetSal.setText(val);
        //tfNetSal.setTex);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        EmployeeManagement emp = new EmployeeManagement();
        emp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    public void getextraHours(){
         PreparedStatement ps;
        ResultSet rs;
        Connection con;
        
        
      // String sql = "select "
        
        
    }
    
    
    private void btn_search_detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_detActionPerformed
        // TODO add your handling code here:
        
        tfHrate.setText(null);
        tfOt.setText(null);
        tfNetSal.setText(null);

        autoFilldetails a = new autoFilldetails();
        ResultSet rs = null;

//        String fname = "fname";
//        String lname="lname";
//        String basicSalary="basicSalary;

        rs = a.find(tfEid.getText());
        try{
            if(rs.next()){
                tfFname.setText(rs.getString("fname"));
                tfLname.setText(rs.getString("lname"));
                tfBasicSal.setText(rs.getString("basicSalary"));
                
                Double basicSal = Double.parseDouble(tfBasicSal.getText());
                               
                Double epf = basicSal * 0.08;
                Double etf = basicSal * 0.03;
                
                String finalEpf = String.valueOf(epf);
                tfEpf.setText(finalEpf);
                
                String finalEtf = String.valueOf(etf);
                tfEtf.setText(finalEtf);
                
              Double val=  CalExtrahours(Integer.parseInt(tfEid.getText()));
              tfHours.setText(String.valueOf(val));
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No Data For This ID  and Only Permanent Employees are allowed ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btn_search_detActionPerformed

    public Double CalExtrahours(int id){
        
        Double ExHours=0.0;
        try {
            Connection conn= getConnection();
            ResultSet rs;
            PreparedStatement ps;
            
            
            String sql = "Select sum(Distinct(hour(clockout)-hour(clockin)-9)) as exHours "
                    + "from attendance a ,permanentemp perm "
                    + "where a.atd_eid=perm.peid "
                    + "and month(presentdate)=? and year(presentdate)=? "
                    + "and atten not in ('Absent') "
                    + "and perm.peid=? "
                    + "group by atd_eid ";
            
            
            ps=conn.prepareStatement(sql);
            
            ps.setInt(1, (comboBoxMonth.getMonth()+1));
            System.out.println(comboBoxMonth.getMonth()+1);
            ps.setInt(2, jYearChooser.getYear());
            System.out.println(jYearChooser.getYear());
            ps.setInt(3, id);
            System.out.println(id);
            
            rs= ps.executeQuery();
            
            if(rs.next()){
                
                Double exHours=rs.getDouble("exHours");
                System.out.println(exHours);
                ExHours=exHours;
                
                
            }
          
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpSal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return ExHours;
      
    }
    
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        

       repaint();
       if(verifyBonus() || verifyHrate())
       {
           try{
           int month=comboBoxMonth.getMonth()+1;
               System.out.println(month);
           if(month ==1){
           
             String updateQuery = null;
            PreparedStatement ps = null;
            Connection conn = getConnection();
               
             updateQuery="update permanentemp set bonus=?,epf=?,etf=?,basicSalary=?,hours=?,hrate=?,ot=?,netSal=? where peid=? ";
             
               ps = conn.prepareStatement(updateQuery);
             
           
            ps.setDouble(1, Double.parseDouble(tfBonus.getText()));
            
            ps.setDouble(2, Double.parseDouble(tfEpf.getText()));
            
            ps.setDouble(3, Double.parseDouble(tfEtf.getText()));
            
             ps.setDouble(4, Double.parseDouble(tfBasicSal.getText()));
            
            
            ps.setDouble(5, Double.parseDouble(tfHours.getText()));
            ps.setDouble(6, Double.parseDouble(tfHrate.getText()));
           
            ps.setDouble(7, Double.parseDouble(tfOt.getText()));
            ps.setDouble(8, Double.parseDouble(tfNetSal.getText()));
              ps.setString(9, tfEid.getText());
              
              
               ps.executeUpdate();
               
                DefaultTableModel model = (DefaultTableModel)table_sal.getModel();
                model.setRowCount(0);
                fillClientJtable(table_sal);
                
                
                 JOptionPane.showMessageDialog(null, "Data added");
             
            }
           else{
       
            // TODO add your handling code here:
            Connection con =getConnection();
            PreparedStatement ps = con.prepareStatement("insert into permanentemp (peid,year,month,bonus,epf,etf,basicSalary,hours,hrate,ot,netSal) values (?,?,?,?,?,?,?,?,?,?,?) ");
            
            ps.setString(1, tfEid.getText());
            ps.setString(2,String.valueOf(jYearChooser.getYear()));
            ps.setInt(3,  comboBoxMonth.getMonth()+1);
            ps.setDouble(4, Double.parseDouble(tfBonus.getText()));
            
            ps.setDouble(5, Double.parseDouble(tfEpf.getText()));
            
            ps.setDouble(6, Double.parseDouble(tfEtf.getText()));
            
             ps.setDouble(7, Double.parseDouble(tfBasicSal.getText()));
            
            
            ps.setDouble(8, Double.parseDouble(tfHours.getText()));
            ps.setDouble(9, Double.parseDouble(tfHrate.getText()));
           
            ps.setDouble(10, Double.parseDouble(tfOt.getText()));
            ps.setDouble(11, Double.parseDouble(tfNetSal.getText()));
            
             ps.executeUpdate();
                
                DefaultTableModel model = (DefaultTableModel)table_sal.getModel();
                model.setRowCount(0);
                fillClientJtable(table_sal);
                
                
                 JOptionPane.showMessageDialog(null, "Data added");
            
        
           }
           
          } catch (SQLException ex) {
            Logger.getLogger(EmpSal.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
       //comboBoxMonth.setSelectedItem("");
       tfEid.setText("");
        tfFname.setText("");
        tfLname.setText("");
        tfBasicSal.setText("");
        tfBonus.setText("");
        tfEpf.setText("");
        tfEtf.setText("");
        tfHours.setText("");
        tfHrate.setText("");
        tfOt.setText("");
        tfNetSal.setText("");
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyPressed

        DefaultTableModel model = (DefaultTableModel)table_sal.getModel();
                model.setRowCount(0);
        fillClientJtable(table_sal);// TODO add your handling code here:
    }//GEN-LAST:event_tfSearchKeyPressed

    private void tfBonusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBonusKeyPressed

        repaint();
        verifyBonus();// TODO add your handling code here:
    }//GEN-LAST:event_tfBonusKeyPressed

    private void tfHrateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHrateKeyPressed

        repaint();
        verifyHrate();// TODO add your handling code here:
    }//GEN-LAST:event_tfHrateKeyPressed

    private void table_salMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_salMouseClicked

        try {
            //Display the selected row data in jtextfields
         
            
            DefaultTableModel model = (DefaultTableModel)table_sal.getModel();
            
               
            int index = table_sal.getSelectedRow();
            
             String Table_click=(model.getValueAt(index, 0).toString());
            
            String sql = "select p.year,p.month,p.peid,e.fname,e.lname,p.basicSalary,p.bonus,p.epf,p.etf,p.hours,p.hrate,p.ot,p.netSal from permanentemp p,employee e where p.peid = e.id and p.peid = ? ";
            Connection conn = getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            
            ps.setString(1, Table_click);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                   // String date = rs.getString("year");
                   // jYearChooser.setText(date);
                    
                    int month = rs.getInt("month");
                    comboBoxMonth.setMonth(month);
                    
                    String id = rs.getString("peid");
                     tfEid.setText(id);
                     String fname = rs.getString("fname");
                     tfFname.setText(fname);
                     String lname = rs.getString("lname");
                     tfLname.setText(lname);
                     
                     String sal =rs.getString("basicSalary");
                        tfBasicSal.setText(sal);
                        
                     String bonus = rs.getString("bonus");
                     tfBonus.setText(bonus);
                     
                     String epf = rs.getString("epf");
                     tfEpf.setText(epf);
                     
                     String etf = rs.getString("etf");
                     tfEtf.setText(etf);
                     
                     String hour = rs.getString("hours");
                     tfHours.setText(hour);
                     
                     String rate = rs.getString("hrate");
                     tfHrate.setText(rate);
                     
                     String ot = rs.getString("ot");
                     tfOt.setText(ot);
                     
                     String net = rs.getString("netSal");
                     tfNetSal.setText(net);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpSal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_salMouseClicked

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed

        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);

        //JOptionPane.showMessageDialog(null, "You have successfully Log out");
    }//GEN-LAST:event_logout_btnActionPerformed

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
            java.util.logging.Logger.getLogger(EmpSal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpSal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpSal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpSal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new EmpSal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Emp_Det;
    private javax.swing.JButton btn_search_det;
    private com.toedter.calendar.JMonthChooser comboBoxMonth;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooser;
    private javax.swing.JLabel labelBonus;
    private javax.swing.JLabel labelHrate;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTable table_sal;
    private javax.swing.JTextField tfBasicSal;
    private javax.swing.JTextField tfBonus;
    private javax.swing.JTextField tfEid;
    private javax.swing.JTextField tfEpf;
    private javax.swing.JTextField tfEtf;
    private javax.swing.JTextField tfFname;
    private javax.swing.JTextField tfHours;
    private javax.swing.JTextField tfHrate;
    private javax.swing.JTextField tfLname;
    private javax.swing.JTextField tfNetSal;
    private javax.swing.JTextField tfOt;
    private javax.swing.JTextField tfSearch;
    public static javax.swing.JLabel userwelcomejlabel;
    // End of variables declaration//GEN-END:variables
static public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable jTable1, Object value, boolean selected, boolean foused, int row, int column) {
            super.getTableCellRendererComponent(jTable1, value, selected, foused, row, column);
            setBackground(new java.awt.Color(255, 102, 0, 180));
            setFont(new Font("Calibri", Font.BOLD, 20));

            return this;
        }

    }

}
