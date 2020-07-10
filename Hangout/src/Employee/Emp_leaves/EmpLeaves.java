package Employee.Emp_leaves;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import Attend.Attendance;
//import EmpDetails.EmDet;
//import EmpSal.EmpSal;
import Employee.Attendance.Attendance;
import Employee.Dashboard.EmployeeManagement;
import Employee.EmpDetails.EmDet;
//import Employee.EmployeeManagement;
import Employee.PermEmpSal.EmpSal;
import Employee.Report_emp.EmployeeManagamentDash_Reports;
import Employee.Report_emp.Report_emp;
import Employee.TempEmpSal.TempEmpSal;
import Hangout.Home.Home;
//import Report_emp.Report_emp;
//import TempEmpSal.TempEmpSal;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;




import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author BEYOND
 */
public class EmpLeaves extends javax.swing.JFrame {

    /**
     * Creates new form MenuManagement
     */
    public EmpLeaves() {
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
        //jComboBox1.setBackground(new Color(255, 102, 0, 180));
        //jComboBox2.setBackground(new Color(255, 102, 0, 180));
       

         logout_btn.setBackground(new Color(255, 102, 0, 180));
        jTable1.getTableHeader().setDefaultRenderer(new HeaderColor());
        
        jButton5.setBackground(Color.white);
        
        this.setExtendedState(MAXIMIZED_BOTH);
        //btn_search_det.addActionListener(this);
        
        
        fillClientJtable(jTable1);

    }
    
    public Connection getConnection(){
        Connection con = null;
        
          String db="hangout";
        String url="jdbc:mysql://localhost:3306/"+db;
        String username="root";
        String password="root";
        
        
        try{
            con=DriverManager.getConnection(url, username, password);
            //JOptionPane.showMessageDialog(null, "Connected");
            return con;
                
        }catch(SQLException e){
            // JOptionPane.showMessageDialog(null, "Not connected");
                return null;
        }
    }

    
    //check inputs
    public boolean checkInputs(){
        if(EmpIDTxtField.getText() ==null || FnameTxtField.getText() ==null
                || lnameTxtField.getText()==null 
                ||leave_type_combo.getSelectedItem()==null || leave_jdatechooser.getDate()==null){
            
            return false;
        }
        else{
            try{
                Integer.parseInt(EmpIDTxtField.getText());
                return true;
            }catch(Exception e){
                return false;
            }
        }
    }
    
    
     public boolean getattencount(){
     
        try {
            // TODO add your handling code here:
            PreparedStatement ps;
            ResultSet rs;
            String sql="Select noofleaves from leavecount where eid=? and month=? ";
            
            Connection con = getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, EmpIDTxtField.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
            String val=dateFormat.format(leave_jdatechooser.getDate());
            ps.setString(2, val);
            
            
            rs=ps.executeQuery();   
            //System.out.println("run");
            if(rs.next()){
                int c=rs.getInt("noofleaves");
                //System.out.println("This statement pkay");
                //System.out.println(c);
                if(c >= 2){ 
                    //JOptionPane.showMessageDialog(null, "Maximum number of leaves is 2");
                    //System.out.println("This statement");
                     return false;
                  
                }else
                    return true;
                
              
            }
              
           
        } catch (SQLException ex) {
           
            Logger.getLogger(EmpLeaves.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
       
        return true;
      }
    
    /**
     * 
     * 
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
        logout_btn = new javax.swing.JButton();
        userwelcomejlabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EmpIDTxtField = new javax.swing.JTextField();
        lnameTxtField = new javax.swing.JTextField();
        FnameTxtField = new javax.swing.JTextField();
        leave_jdatechooser = new com.toedter.calendar.JDateChooser();
        btn_addleaves = new javax.swing.JButton();
        emp_update = new javax.swing.JButton();
        delete_leave = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        leave_type_combo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        btn_search_det = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        LeaveIdtxt = new javax.swing.JTextField();
        Completed_jtable = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jtableSearchLabel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex, columnIndex);

                if(columnIndex ==6){
                    if(value.equals("In Progress")){
                        //component.setBackground(Color.GREEN);
                        component.setForeground(Color.GREEN);
                    }
                    else if(value.equals("Updated")){
                        component.setForeground(Color.ORANGE);
                        Map attributes = (new Font("Serif", Font.PLAIN, 12)).getAttributes();
                        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                        component.setFont(new Font(attributes));

                    }

                }
                else if(isRowSelected(rowIndex)){
                    component.setBackground(new Color(255,102,0));
                }
                else  {

                    component.setBackground(Color.white);
                    component.setForeground(Color.BLACK);
                }

                return component;
            }

        };
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
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

        logout_btn.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        logout_btn.setText("Log Out");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        userwelcomejlabel.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        userwelcomejlabel.setForeground(new java.awt.Color(255, 255, 255));

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
                        .addGap(620, 620, 620)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(userwelcomejlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(122, 122, 122))))
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
        jLabel8.setText("Employee Leave Details");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel3.setText("Employee ID");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel5.setText("Last Name");

        EmpIDTxtField.setBackground(new java.awt.Color(255, 204, 102));
        EmpIDTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpIDTxtFieldActionPerformed(evt);
            }
        });

        lnameTxtField.setBackground(new java.awt.Color(255, 204, 102));
        lnameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTxtFieldActionPerformed(evt);
            }
        });

        FnameTxtField.setBackground(new java.awt.Color(255, 204, 102));
        FnameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FnameTxtFieldActionPerformed(evt);
            }
        });

        leave_jdatechooser.setBackground(new java.awt.Color(255, 204, 102));
        leave_jdatechooser.setDateFormatString("yyyy-MM-dd");

        btn_addleaves.setBackground(new java.awt.Color(0, 0, 0));
        btn_addleaves.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btn_addleaves.setForeground(new java.awt.Color(255, 255, 255));
        btn_addleaves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_38px.png"))); // NOI18N
        btn_addleaves.setText("Add");
        btn_addleaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addleavesActionPerformed(evt);
            }
        });

        emp_update.setBackground(new java.awt.Color(0, 0, 0));
        emp_update.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        emp_update.setForeground(new java.awt.Color(255, 255, 255));
        emp_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_refresh_38px_1.png"))); // NOI18N
        emp_update.setText("Update");
        emp_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_updateActionPerformed(evt);
            }
        });

        delete_leave.setBackground(new java.awt.Color(0, 0, 0));
        delete_leave.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        delete_leave.setForeground(new java.awt.Color(255, 255, 255));
        delete_leave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_sign_38px.png"))); // NOI18N
        delete_leave.setText("Delete");
        delete_leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_leaveActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel17.setText("Type Of Leaves");

        leave_type_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Day", "Half Day" }));
        leave_type_combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                leave_type_comboMouseReleased(evt);
            }
        });
        leave_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leave_type_comboActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel18.setText("Date");

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

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel7.setText("Leave ID");

        LeaveIdtxt.setEditable(false);
        LeaveIdtxt.setBackground(new java.awt.Color(255, 204, 102));
        LeaveIdtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveIdtxtActionPerformed(evt);
            }
        });

        Completed_jtable.setBackground(new java.awt.Color(0, 0, 0));
        Completed_jtable.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Completed_jtable.setForeground(new java.awt.Color(255, 255, 255));
        Completed_jtable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_checkmark_38px.png"))); // NOI18N
        Completed_jtable.setText("Completed ");
        Completed_jtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Completed_jtableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lnameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FnameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leave_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leave_jdatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(EmpIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btn_search_det, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LeaveIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btn_addleaves, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(emp_update, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(delete_leave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Completed_jtable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(LeaveIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmpIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btn_search_det))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FnameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leave_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(leave_jdatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(641, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addleaves)
                    .addComponent(emp_update)
                    .addComponent(delete_leave)
                    .addComponent(Completed_jtable))
                .addGap(129, 129, 129))
        );

        jtableSearchLabel.setBackground(new java.awt.Color(255, 204, 102));
        jtableSearchLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtableSearchLabelKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leave ID", "Employee ID", "First Name", "Last Name", "Type Of leave", "Date", "Status"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(5);
        jTable1.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_38px.png"))); // NOI18N
        jLabel16.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addComponent(jtableSearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(359, 359, 359))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtableSearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(725, 725, 725)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
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
        EmpSal e = new EmpSal();
        e.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        Attendance atten = new Attendance();
        atten.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
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

    private void emp_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_updateActionPerformed
        // TODO add your handling code here:
        if(checkInputs() && EmpIDTxtField.getText() !=null){
            
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
             
            try {
                   UpdateQuery = "Update empleaves set  leave_type = ? ,leave_date = ?, leave_status = 'Updated'"
                    + "where leaveid = ?";
                ps = con.prepareStatement(UpdateQuery);
                
                ps.setString(1, (String) leave_type_combo.getSelectedItem());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String addDate = dateFormat.format(leave_jdatechooser.getDate());
                
                
                ps.setString(2, addDate);
                ps.setInt(3, Integer.parseInt(LeaveIdtxt.getText()));
                
                ps.executeUpdate();
                
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                fillClientJtable(jTable1);
                
                
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
          
            
        }else{
             JOptionPane.showMessageDialog(null, "One or More Fields Are Empty or Wrong");
             
        }
        
       
        
    }//GEN-LAST:event_emp_updateActionPerformed

    private void leave_type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leave_type_comboActionPerformed
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_leave_type_comboActionPerformed

    private void lnameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameTxtFieldActionPerformed

    private void EmpIDTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpIDTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpIDTxtFieldActionPerformed

    private void FnameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FnameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FnameTxtFieldActionPerformed

    private void btn_addleavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addleavesActionPerformed
        // TODO add your handling code here:
        
        
        
        //add a new leave
        if(checkInputs() ){
            if(getattencount()){
           
                
            try {
                Connection con =getConnection();
                PreparedStatement ps = con.prepareStatement("call addleaves(?,?,?,?,?)");
                ps.setString(1, EmpIDTxtField.getText());
                ps.setString(2, FnameTxtField.getText());
                ps.setString(3, lnameTxtField.getText());
                
                ps.setString(4, (String)leave_type_combo.getSelectedItem());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String addDate = dateFormat.format(leave_jdatechooser.getDate());
                ps.setString(5, addDate);
            
                ps.executeUpdate();
                
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                fillClientJtable(jTable1);
                
                
                 JOptionPane.showMessageDialog(null, "Data added");
            
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
                
          
            } else{
                     JOptionPane.showMessageDialog(null, "Only Maximum amount of 2 leaves are provided");
    
 
                    }  
            
        }else{
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
        }
          
       
    }//GEN-LAST:event_btn_addleavesActionPerformed

    private void btn_search_detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_detActionPerformed
        // TODO add your handling code here:
        
        autoFilldetails a = new autoFilldetails();
        ResultSet rs = null;
        
//        String fname = "fname";
//        String lname="lname";
        
        rs = a.find(EmpIDTxtField.getText());
        try{
            if(rs.next()){
                FnameTxtField.setText(rs.getString("fname"));
                lnameTxtField.setText(rs.getString("lname"));
            }
            else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID  and Only Permanent Employees are allowed ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }//GEN-LAST:event_btn_search_detActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
           //Display the selected row data in jtextfields
        
              DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        //get selected row index
              int rIndex = jTable1.getSelectedRow();
        
        //display data
      
              LeaveIdtxt.setText(model.getValueAt(rIndex,0).toString());
              EmpIDTxtField.setText(model.getValueAt(rIndex,1).toString());
              FnameTxtField.setText(model.getValueAt(rIndex,2).toString());
              lnameTxtField.setText(model.getValueAt(rIndex,3).toString());
              leave_type_combo.setSelectedItem(model.getValueAt(rIndex, 4).toString());
       
     
        try {
            
         
              //int srow = jTable1.getSelectedRow();
              Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rIndex, 5).toString());
              leave_jdatechooser.setDate(date);
              
            
              
      
              
        } catch (ParseException ex) {
            Logger.getLogger(EmpLeaves.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            
      
      
      
       

    }//GEN-LAST:event_jTable1MouseClicked

    private void LeaveIdtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveIdtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LeaveIdtxtActionPerformed

    private void delete_leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_leaveActionPerformed
        // TODO add your handling code here:
        
          //Display the selected row data in jtextfields
        
              DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        //get selected row index
              int rIndex = jTable1.getSelectedRow();
        
        //display data
        
     
        try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("call deleteleaves(?)");
                 ps.setString(1,model.getValueAt(rIndex,0).toString());
         
                 ps.executeUpdate();
                // ((DefaultTableModel)myJTable.getModel()).removeRow(rowToRemove);
              //int srow = jTable1.getSelectedRow();
           
             
                model.setRowCount(0);
                fillClientJtable(jTable1);
              
               JOptionPane.showMessageDialog(null, "Deleted Successfully");
      
              
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
      
            
        //model.removeRow(rIndex);
        
    }//GEN-LAST:event_delete_leaveActionPerformed

    private void Completed_jtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Completed_jtableActionPerformed
        // TODO add your handling code here:
        
        Removed_leaves rl = new Removed_leaves();
        rl.setVisible(true);
    }//GEN-LAST:event_Completed_jtableActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        EmployeeManagement emp = new EmployeeManagement();
        emp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtableSearchLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableSearchLabelKeyPressed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
        fillClientJtable(jTable1);
    }//GEN-LAST:event_jtableSearchLabelKeyPressed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed

        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);

        //JOptionPane.showMessageDialog(null, "You have successfully Log out");
    }//GEN-LAST:event_logout_btnActionPerformed

    private void leave_type_comboMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leave_type_comboMouseReleased
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_leave_type_comboMouseReleased

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
            java.util.logging.Logger.getLogger(EmpLeaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpLeaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpLeaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpLeaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new EmpLeaves().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Completed_jtable;
    private javax.swing.JTextField EmpIDTxtField;
    private javax.swing.JButton Emp_Det;
    private javax.swing.JTextField FnameTxtField;
    private javax.swing.JTextField LeaveIdtxt;
    private javax.swing.JButton btn_addleaves;
    private javax.swing.JButton btn_search_det;
    private javax.swing.JButton delete_leave;
    private javax.swing.JButton emp_update;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtableSearchLabel;
    private com.toedter.calendar.JDateChooser leave_jdatechooser;
    private javax.swing.JComboBox<String> leave_type_combo;
    private javax.swing.JTextField lnameTxtField;
    private javax.swing.JButton logout_btn;
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


public class autoFilldetails{
   
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public ResultSet find(String s){
        try {
            
        con = DriverManager.getConnection("jdbc:mysql://localhost/hangout","root","root");
        ps = con.prepareStatement("select e.fname,e.lname from permanentemp pt ,employee e where e.id=pt.peid and  pt.peid =? ");
        ps.setString(1, s);
        //ps.setString(2, s);
        rs=ps.executeQuery();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
     
        return rs;
    }
    
}
 
//create a function to populate jtable
public void fillClientJtable(JTable table){
    
    String valToSearch=jtableSearchLabel.getText();
    PreparedStatement ps;
    ResultSet rs;
    String selectQuery = "Select el.leaveid,pl.pempid,e.fname,e.lname,el.leave_type,el.leave_date,el.leave_status "
            + "from permanentleave pl inner join empleaves el on pl.leave_id= el.leaveid "
            + "inner join employee e on pl.pempid=e.id "
            + "where el.leave_status not in('Completed') and e.department not in('admin') and "
            + "concat(el.leaveid,pl.pempid,e.fname,e.lname,el.leave_type,el.leave_date,el.leave_status)LIKE '%"+valToSearch+"%' "
            + "ORDER BY leaveid ASC ";
    
   
        try {
            
              Connection con = getConnection();
             ps=con.prepareStatement(selectQuery);
            
              rs=ps.executeQuery();
        
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        
        Object[] row;
       
        while(rs.next()){
            row = new Object[7];
            row[0]=rs.getInt(1);
            row[1]=rs.getInt(2);
            row[2]=rs.getString(3);
            row[3]=rs.getString(4);
            row[4]=rs.getString(5);
            row[5]=rs.getDate(6);
            row[6]=rs.getString(7);
            
            
            tableModel.addRow(row);
            
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpLeaves.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      

     
}


//public void searchFilter (){
//    
//    try{
//        
//        Connection con = getConnection();
//        String query = "select * from employee where concat(id,fname,lname,type,status) LIKE '%\"+valToSearch+\"%'"
//        PreparedStatement ps = 
//        
//        
//    }catch
//    
//    
//}


}


