package Employee.EmpDetails;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import Emp_leaves.EmpLeaves;
import Employee.Attendance.Attendance;
import Employee.PermEmpSal.EmpSal;
import Employee.Emp_leaves.EmpLeaves;
import Employee.Dashboard.Employee;
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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
//import ui.Home;

/**
 *
 * @author BEYOND
 */
public class EmDet extends javax.swing.JFrame {
     
      Employee emp = new Employee();
      //FormValidation fm = new FormValidation();

    /**
     * Creates new form employees
     */
    public EmDet() {
       
      
        initComponents();
        jPanel1.setBackground(new Color(255, 102, 0, 180));
        jPanel2.setBackground(new Color(0, 0, 0, 150));
        jLabel1.setBackground(new Color(0, 0, 0, 100));
        labelLname.setBackground(new Color(255, 102, 0, 180));
        labelFname.setBackground(new Color(255, 102, 0, 180));
        labelnic.setBackground(new Color(255, 102, 0, 180));
        //jPanel3.setBackground(new Color(255,102,0,180));
        jPanel3.setBackground(new Color(255, 102, 0, 180));
        jPanel4.setBackground(new Color(255, 102, 0, 180));

        Emp_Det.setBackground(new Color(255, 102, 0, 180));
        jButton5.setBackground(new Color(255, 102, 0, 180));
        jButton7.setBackground(new Color(255, 102, 0, 180));
        jButton6.setBackground(new Color(255, 102, 0, 180));
        jButton9.setBackground(new Color(255, 102, 0, 180));
        jButton10.setBackground(new Color(255, 102, 0, 180));
        comboPosition.setBackground(new Color(255, 102, 0, 180));
        comboDepartment.setBackground(new Color(255, 102, 0, 180));
       

        jTable_Employee.getTableHeader().setDefaultRenderer(new HeaderColor());
        
        
        Emp_Det.setBackground(Color.white);
        
        
        this.setExtendedState(MAXIMIZED_BOTH);
        
        //populate jTable        
        showEmployeesInJtable();
        
         logout_btn.setBackground(new Color(255, 102, 0, 180));
      
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
    
        
    
    //Check inputs
    public boolean checkInputs(){
        if(tfFname.getText() == null || tfLname.getText() == null ||
           tfNic.getText() == null || dateDOB.getDate() == null || comboDepartment.getSelectedItem() == null || comboPosition.getSelectedItem() == null)
        {
            return false;
        }
        else{
            try{
                //Integer.parseInt(tfEid.getText());
                return true;
            }
            catch(Exception e){
                return false;
            }
            
        }
    }
    
        public ArrayList <Employee> getEmployeeList(String valToSearch)
    {
        ArrayList <Employee> list = new ArrayList<Employee>();
        Connection conn = getConnection();
        //String query = "SELECT * from employee "
               // + "order by id asc";
        String query = "select * from employee where department not in ('admin') and concat(id,fname,lname,type,status) LIKE '%"+valToSearch+"%'";
        
        Statement ps;
        ResultSet rs;
        
          try {
              ps = conn.createStatement();
              rs = ps.executeQuery(query);  
             Employee employee;
             
              while(rs.next())
              {
                 
                  employee= new Employee(rs.getInt("id"),rs.getString("fname"),
                             rs.getString("lname"),rs.getString("type"),rs.getString("status"));
                            
     
                  list.add(employee);
                
              }
          } catch (SQLException ex) {
              Logger.getLogger(EmDet.class.getName()).log(Level.SEVERE, null, ex);
          }
        return list;
    }
        
        
            //Populate the jTable 
    public void showEmployeesInJtable()
    {
        ArrayList<Employee> list = getEmployeeList(tfSearch.getText());
        DefaultTableModel model = (DefaultTableModel)jTable_Employee.getModel();
        
        Object[] row = new Object[5];
        
        for(int i = 0;i<list.size();i++)
        {
            row[0] = list.get(i).getEmpId();
            row[1] = list.get(i).getFname();
            row[2] = list.get(i).getLname();
            row[3] = list.get(i).getType();
            row[4] = list.get(i).getStatus();
            model.addRow(row);
        }
        jTable_Employee.setModel(model);
    }
    
    public boolean verifyFname()
    {
        if(tfFname.getText().matches("[a-zA-Z]+") && tfFname.getText() !=null)
        {
            labelFname.setText(null);
            return true;
            //repaint();
        }
        else{
            labelFname.setText("");
            labelFname.setText("Invalid String or Empty");
            return false;
        }  
    }
    
    public boolean verifyLname()
    {
        if(tfLname.getText().matches("[a-zA-Z]+") && tfLname.getText() !=null)
        {
            labelLname.setText(null);
            return true;
        }
        else{
            //labelLname.setText(null);
            labelLname.setText("Invalid String or Empty");
            return false;
        }  
    }
    
    public boolean verifynic()
     
          
    {
        if(tfNic.getText().matches("\\d{9}[Vv]") && tfNic.getText() !=null)
        {
            labelnic.setText(null);
            return true;
        }
        else{
           // labelnic.setText(null);
            labelnic.setText("Invalid String or Empty");
            return false;
        }  
    }
    
    public boolean verifybasicSal()
    {
     
        
        try{
            double sal = Double.parseDouble(tfBasicSal.getText());
            
            labelBasicSal.setText("");
            return true;
        }catch(NumberFormatException ex){
                labelBasicSal.setText("Invalid Salary enetered");
                return false;
                }
    }
    
    public boolean verifyHourSal()
    {
     
        
        try{
            double sal = Double.parseDouble(tfOtRate.getText());
            
            labelOtRate.setText("");
            return true;
        }catch(NumberFormatException ex){
                labelOtRate.setText("Invalid Salary enetered");
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
        logout_btn = new javax.swing.JButton();
        userwelcomejlabel = new javax.swing.JLabel();
        labelEmpDetails = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        empID = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        nic = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        deparment = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        position = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        basicSalary = new javax.swing.JLabel();
        otRate = new javax.swing.JLabel();
        tfEid = new javax.swing.JTextField();
        tfLname = new javax.swing.JTextField();
        tfFname = new javax.swing.JTextField();
        tfNic = new javax.swing.JTextField();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        comboPosition = new javax.swing.JComboBox<>();
        comboDepartment = new javax.swing.JComboBox<>();
        radioPermanent = new javax.swing.JRadioButton();
        radioTemporary = new javax.swing.JRadioButton();
        tfBasicSal = new javax.swing.JTextField();
        tfOtRate = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        labelFname = new javax.swing.JLabel();
        labelnic = new javax.swing.JLabel();
        labelOtRate = new javax.swing.JLabel();
        labelLname = new javax.swing.JLabel();
        labelBasicSal = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();
        dateDOB = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        empList = new javax.swing.JScrollPane();
        jTable_Employee = new javax.swing.JTable()
        {

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex, columnIndex);

                if(columnIndex ==4){
                    if(value.equals("Available")){
                        //component.setBackground(Color.GREEN);
                        component.setForeground(Color.GREEN);
                    }
                    else
                    if(value.equals("Unavailable")){
                        component.setForeground(Color.red);
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

        }
        ;
        btnSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/EmpDetails/Logo.png"))); // NOI18N
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
        Emp_Det.setBorderPainted(false);
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
                .addGap(29, 29, 29)
                .addComponent(Emp_Det, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(userwelcomejlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(userwelcomejlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Emp_Det, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );

        labelEmpDetails.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        labelEmpDetails.setText("Employee Details");

        empID.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        empID.setText("Employee ID");

        fname.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        fname.setText("First Name");

        lname.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lname.setText("Last Name");

        nic.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        nic.setText("NIC ");

        dob.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        dob.setText("Date of Birth");

        deparment.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        deparment.setText("Department");

        gender.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        gender.setText("Gender");

        position.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        position.setText("Position");

        type.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        type.setText("Type");

        basicSalary.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        basicSalary.setText("Basic Salary");

        otRate.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        otRate.setText("Hourly Rate");

        tfEid.setEditable(false);
        tfEid.setBackground(new java.awt.Color(255, 204, 102));
        tfEid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEidActionPerformed(evt);
            }
        });

        tfLname.setBackground(new java.awt.Color(255, 204, 102));
        tfLname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfLnameKeyPressed(evt);
            }
        });

        tfFname.setBackground(new java.awt.Color(255, 204, 102));
        tfFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFnameKeyTyped(evt);
            }
        });

        tfNic.setBackground(new java.awt.Color(255, 204, 102));
        tfNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNicKeyPressed(evt);
            }
        });

        radioMale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioMale.setText("Male");
        radioMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                radioMaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                radioMaleMouseExited(evt);
            }
        });
        radioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMaleActionPerformed(evt);
            }
        });

        radioFemale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioFemale.setText("Female");
        radioFemale.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radioFemaleFocusGained(evt);
            }
        });
        radioFemale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                radioFemaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                radioFemaleMouseExited(evt);
            }
        });
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
            }
        });

        comboPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chef", "Assistant Chef", "Cashier", "Floor Manager", "Raw material Manager", "Stock Manager", "Other", " " }));
        comboPosition.setPreferredSize(new java.awt.Dimension(100, 22));

        comboDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Restaurant and Bakery", "Raw material & Utility Management", "Catering & Order book", "Customer Management", "Finished products", "Function hall", "HRM" }));
        comboDepartment.setPreferredSize(new java.awt.Dimension(100, 22));

        radioPermanent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioPermanent.setText("Permanent");
        radioPermanent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                radioPermanentMouseExited(evt);
            }
        });
        radioPermanent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPermanentActionPerformed(evt);
            }
        });

        radioTemporary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioTemporary.setText("Temporary");
        radioTemporary.setActionCommand("Permanent");
        radioTemporary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                radioTemporaryMouseEntered(evt);
            }
        });
        radioTemporary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTemporaryActionPerformed(evt);
            }
        });

        tfBasicSal.setBackground(new java.awt.Color(255, 204, 102));
        tfBasicSal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBasicSalKeyPressed(evt);
            }
        });

        tfOtRate.setBackground(new java.awt.Color(255, 204, 102));
        tfOtRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfOtRateKeyPressed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_38px.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_refresh_38px_1.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_sign_38px.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        labelFname.setBackground(new java.awt.Color(255, 102, 0));
        labelFname.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                labelFnameComponentAdded(evt);
            }
        });
        labelFname.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                labelFnameAncestorRemoved(evt);
            }
        });
        labelFname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                labelFnameFocusLost(evt);
            }
        });
        labelFname.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                labelFnameComponentHidden(evt);
            }
        });

        labelnic.setBackground(new java.awt.Color(255, 102, 0));
        labelnic.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                labelnicComponentAdded(evt);
            }
        });

        labelOtRate.setBackground(new java.awt.Color(255, 102, 0));
        labelOtRate.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                labelOtRateComponentAdded(evt);
            }
        });

        labelBasicSal.setBackground(new java.awt.Color(255, 102, 0));
        labelBasicSal.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                labelBasicSalComponentAdded(evt);
            }
        });

        btnDelete1.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_broom_38px.png"))); // NOI18N
        btnDelete1.setText("ClearFields");
        btnDelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lname))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(empID)
                                    .addComponent(fname)
                                    .addComponent(nic)
                                    .addComponent(dob)
                                    .addComponent(gender)
                                    .addComponent(deparment)
                                    .addComponent(position)
                                    .addComponent(type)
                                    .addComponent(otRate)
                                    .addComponent(basicSalary)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(radioPermanent)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioTemporary))
                                    .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfOtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelOtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(dateDOB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(radioMale)
                                                .addGap(27, 27, 27)
                                                .addComponent(radioFemale))
                                            .addComponent(tfNic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                            .addComponent(tfLname, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfEid, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfFname, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(name)
                                            .addComponent(labelFname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelnic, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                            .addComponent(labelLname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete1)))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empID)
                    .addComponent(tfEid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fname)
                        .addComponent(tfFname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelFname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lname)
                        .addComponent(tfLname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelLname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelnic, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nic)
                        .addComponent(tfNic, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dob)
                    .addComponent(dateDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender)
                    .addComponent(radioMale)
                    .addComponent(radioFemale))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deparment)
                    .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(position)
                    .addComponent(comboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type)
                    .addComponent(radioPermanent)
                    .addComponent(radioTemporary))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(basicSalary)
                    .addComponent(labelBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(otRate)
                        .addComponent(tfOtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelOtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete1)
                    .addComponent(btnUpdate))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        tfSearch.setBackground(new java.awt.Color(255, 204, 102));
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchKeyPressed(evt);
            }
        });

        jTable_Employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Employee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Employee.setIntercellSpacing(new java.awt.Dimension(1, 5));
        jTable_Employee.setMinimumSize(new java.awt.Dimension(105, 0));
        jTable_Employee.setRowHeight(40);
        jTable_Employee.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jTable_Employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_EmployeeMouseClicked(evt);
            }
        });
        empList.setViewportView(jTable_Employee);

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_search_32px_1.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnSearch)
                .addGap(387, 387, 387))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(empList, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(27, 27, 27)
                .addComponent(empList, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(750, 750, 750)
                .addComponent(labelEmpDetails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmpDetails)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 1090);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/EmpDetails/Background.jpg"))); // NOI18N
        jLabel1.setText("fff");
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

        EmpLeaves leaves = new EmpLeaves();
        leaves.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Emp_DetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Emp_DetMouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_Emp_DetMouseEntered

    private void Emp_DetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Emp_DetMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Emp_DetMouseExited

    private void Emp_DetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_DetActionPerformed
        // TODO add your handling code here:
        
  
    }//GEN-LAST:event_Emp_DetActionPerformed

    private void radioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMaleActionPerformed
        repaint();
      radioFemale.setSelected(false);
      
    }//GEN-LAST:event_radioMaleActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      
        
        //tfEid.setEditable(false);
       
        if(checkInputs() && tfEid.getText() != null){
            String updateQuery = null;
            PreparedStatement ps = null;
            Connection conn = getConnection();
            int rIndex=jTable_Employee.getSelectedRow();
            
            try {
                if(radioPermanent.isSelected() && jTable_Employee.getValueAt(rIndex, 4).toString().equals("Available"))
                {
                updateQuery = "update employee,permanentemp set employee.fname = ? , employee.lname = ?, employee.nic = ? , employee.dob = ?, permanentemp.basicSalary = ? where employee.id = ? and permanentemp.peid = ? ";
                
                ps = conn.prepareStatement(updateQuery);
                
                ps.setString(1, tfFname.getText());
                ps.setString(2, tfLname.getText());
                ps.setString(3, tfNic.getText());
                
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dob = dateFormat.format(dateDOB.getDate());
                ps.setString(4, dob);
                ps.setDouble(5, Double.parseDouble(tfBasicSal.getText()));
                 ps.setInt(6, Integer.parseInt(tfEid.getText()));
                ps.setInt(7, Integer.parseInt(tfEid.getText()));
                
                JOptionPane.showMessageDialog(null, "Data updated successfully");
                
                }
                else if(radioTemporary.isSelected() && jTable_Employee.getValueAt(rIndex, 4).toString().equals("Available"))
                {
                    updateQuery = "update employee,tempemployee set employee.fname = ? , employee.lname = ?, employee.nic = ? , employee.dob = ?, otRate = ? where employee.id = ? and tempemployee.teid = ?  ";
                    ps = conn.prepareStatement(updateQuery);
                
                    ps.setString(1, tfFname.getText());
                    ps.setString(2, tfLname.getText());
                    ps.setString(3, tfNic.getText());


                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dob = dateFormat.format(dateDOB.getDate());
                    ps.setString(4, dob);
                    ps.setDouble(5, Double.parseDouble(tfOtRate.getText()));
                    ps.setInt(6, Integer.parseInt(tfEid.getText()));
                    ps.setInt(7, Integer.parseInt(tfEid.getText()));
                    
                    
                    JOptionPane.showMessageDialog(null, "Data updated successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Cannot be updated");
                }
  
                
                ps.executeUpdate();
                
                 DefaultTableModel model = (DefaultTableModel)jTable_Employee.getModel();
                model.setRowCount(0);
                 showEmployeesInJtable();
                
            } catch (SQLException ex) {
                Logger.getLogger(EmDet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        tfEid.setText("");
        tfFname.setText("");
        tfLname.setText("");
        tfNic.setText("");
        dateDOB.setCalendar(null);
        radioMale.setSelected(false);
        radioFemale.setSelected(false);
        comboDepartment.setSelectedItem("");
        comboPosition.setSelectedItem("");
        radioPermanent.setSelected(false);
        radioTemporary.setSelected(false);
        tfBasicSal.setText("");
        tfOtRate.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
//        labelFname.setText("");
//        labelLname.setText("");
        repaint();
        if(verifyFname() || verifyLname() || verifynic() || verifybasicSal() || verifyHourSal())
        {
                Connection conn = getConnection();
           
            try {
                if(radioTemporary.isSelected()){
                    
                     PreparedStatement ps = conn.prepareStatement("call addTemporaryEmployees(?,?,?,?,?,?,?,?,?)");
                     
                    // ps.setInt(1,Integer.parseInt(tfEid.getText()));
                     ps.setString(1, tfFname.getText());
                     ps.setString(2, tfLname.getText());
                     ps.setString(3, tfNic.getText());
                     
                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                     String dob = dateFormat.format(dateDOB.getDate());
                     ps.setString(4, dob);
                     
                     if(radioMale.isSelected())
                        ps.setString(5, radioMale.getText());
                     else
                         ps.setString(5, radioFemale.getText());
                     
                     ps.setString(6, (String) comboDepartment.getSelectedItem());
                     ps.setString(7, (String) comboPosition.getSelectedItem());
                     
                     
                      ps.setString(8, radioTemporary.getText());
                      
                      ps.setDouble(9, Double.parseDouble(tfOtRate.getText()));
                      ps.executeUpdate();
                     // showTempEmployeesInJtable();
                      
                      JOptionPane.showMessageDialog(null, "Data added successfully");
                      
                
                }
                else{
                    PreparedStatement ps = conn.prepareStatement("call addPermanentEmployees(?,?,?,?,?,?,?,?,?)");
                     
                    // ps.setInt(1,Integer.parseInt(tfEid.getText()));
                     ps.setString(1, tfFname.getText());
                     ps.setString(2, tfLname.getText());
                     ps.setString(3, tfNic.getText());
                     
                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                     String dob = dateFormat.format(dateDOB.getDate());
                     ps.setString(4, dob);
                     
                     if(radioMale.isSelected())
                        ps.setString(5, radioMale.getText());
                     else
                         ps.setString(5, radioFemale.getText());
                     
                     ps.setString(6, (String) comboDepartment.getSelectedItem());
                     ps.setString(7, (String) comboPosition.getSelectedItem());
                     
                     
                      ps.setString(8, radioPermanent.getText());
                      
                      ps.setDouble(9, Double.parseDouble(tfBasicSal.getText()));
                      ps.executeUpdate();
                      
                      JOptionPane.showMessageDialog(null, "Data added successfully");
                      
                }
                
                  DefaultTableModel model = (DefaultTableModel)jTable_Employee.getModel();
                model.setRowCount(0);
                 showEmployeesInJtable();
               
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
         else
        {
            JOptionPane.showMessageDialog(null, "Cannot add data");
        }
        
        tfEid.setText("");
        tfFname.setText("");
        tfLname.setText("");
        tfNic.setText("");
        dateDOB.setCalendar(null);
        radioMale.setSelected(false);
        radioFemale.setSelected(false);
        comboDepartment.setSelectedItem("");
        comboPosition.setSelectedItem("");
        radioPermanent.setSelected(false);
        radioTemporary.setSelected(false);
        tfBasicSal.setText("");
        tfOtRate.setText("");
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void jTable_EmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_EmployeeMouseClicked

                           
        
        try{
            DefaultTableModel model = (DefaultTableModel)jTable_Employee.getModel();
             int index = jTable_Employee.getSelectedRow();
            
             String Table_click=(model.getValueAt(index, 0).toString());
             //Integer.parseInt(Table_click);
             String sql="select type from employee where id = ? ";
             
             Connection conn = getConnection();
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, Table_click);
            ResultSet rs=pst.executeQuery();
             
             if(rs.next()){
              
                 if(rs.getString("type").equals("Permanent") ||rs.getString("type").equals("permanent")  ){
                     String sqlperm="select e.id,e.fname,e.lname,e.nic,e.dob,e.gender,e.department,e.position,e.type,pe.basicSalary "
                             + "from employee e ,permanentemp pe "
                             + "where e.id=pe.peid and e.id= ?";
                     
                     pst=conn.prepareStatement(sqlperm);
                     pst.setString(1, Table_click);
                     rs=pst.executeQuery();
                     
                     if(rs.next()){
                     
                     String id = rs.getString("id");
                     tfEid.setText(id);
                     String fname = rs.getString("fname");
                     tfFname.setText(fname);
                     String lname = rs.getString("lname");
                     tfLname.setText(lname);
                     
                     String nic = rs.getString("nic");
                     tfNic.setText(nic);
                     
                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                     Date addDate = dateFormat.parse(rs.getString("dob"));
                     dateDOB.setDate(addDate);
                     
                             radioMale.setSelected(false);
                             radioFemale.setSelected(false);
                     
                     if(null != rs.getString("gender"))switch(rs.getString("gender")){
                         case "Male":
                         case "male":
                             radioMale.setSelected(true);
                             break;
                         case "Female" :
                         case "female" :    
                             radioFemale.setSelected(true);
                             break;
                         default:
                             radioMale.setEnabled(false);
                             radioFemale.setEnabled(false);
                             break;
                     }else
                     {
                            radioFemale.setEnabled(false);
                            radioMale.setEnabled(false);
                     }
                     
                  
         
                    String dep = rs.getString("department");
                    comboDepartment.setSelectedItem(dep);
       
                    String pos = rs.getString("position");
                    comboPosition.setSelectedItem(pos);
                    
                    radioPermanent.setSelected(false);
                    radioTemporary.setSelected(false);
                    tfBasicSal.setText("");
                      tfOtRate.setText("");

                    if(rs.getString("type").equals("Permanent") || rs.getString("type").equals("permanent")){
                        radioPermanent.setSelected(true);
                         String sal =rs.getString("basicSalary");
                        tfBasicSal.setText(sal);
                    }
                  
                     else{
                         radioPermanent.setSelected(false);
                         radioTemporary.setSelected(false);
                         
                     }
                    
                   
                    
                    
                    
                     }
                 }
                 else {
                     
                      String sqltemp="select e.id,e.fname,e.lname,e.nic,e.dob,e.gender,e.department,e.position,e.type,tid.otRate "
                             + "from employee e ,tempemployee tid "
                             + "where e.id=tid.teid and e.id= ?";
                     
                       pst=conn.prepareStatement(sqltemp);
                     pst.setString(1, Table_click);
                     rs=pst.executeQuery();
                     
                     if(rs.next()){
                     String id = rs.getString("id");
                     tfEid.setText(id);
                     String fname = rs.getString("fname");
                     tfFname.setText(fname);
                     String lname = rs.getString("lname");
                     tfLname.setText(lname);
                     
                      String nic = rs.getString("nic");
                     tfNic.setText(nic);
                     
                     
                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                     Date addDate = dateFormat.parse(rs.getString("dob"));
                     dateDOB.setDate(addDate);
                     
                             radioMale.setSelected(false);
                             radioFemale.setSelected(false);
                     
                     if(null != rs.getString("gender"))switch(rs.getString("gender")){
                         case "Male":
                         case "male":
                                    radioMale.setSelected(true);
                                    break;
                         case "Female":
                         case "female":
                                    radioFemale.setSelected(true);
                                     break;
                         default:
                             radioMale.setEnabled(false);
                             radioFemale.setEnabled(false);
                             break;
                     }else
                     {
                            radioFemale.setEnabled(false);
                            radioMale.setEnabled(false);
                     }
         
                    String dep = rs.getString("department");
                    comboDepartment.setSelectedItem(dep);
       
                    String pos = rs.getString("position");
                    comboPosition.setSelectedItem(pos);
                    
                    radioPermanent.setSelected(false);
                    radioTemporary.setSelected(false);
                    tfOtRate.setText("");
                    tfBasicSal.setText("");

                   if(rs.getString("type").equals("Temporary") || rs.getString("type").equals("temporary")){
                        radioTemporary.setSelected(true);
                         String hrate =rs.getString("otRate");
                            tfOtRate.setText(hrate);
                    }
                     else{
                         radioPermanent.setSelected(false);
                         radioTemporary.setSelected(false);
                         
                     }
                    
                     }
                 }
             }
        }catch(Exception e){
             Logger.getLogger(EmDet.class.getName()).log(Level.SEVERE, null, e);
            //JOptionPane.showMessageDialog(null, e);
        }
       
        
                           
    }//GEN-LAST:event_jTable_EmployeeMouseClicked

    private void tfEidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEidActionPerformed

    private void radioTemporaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTemporaryActionPerformed
        // TODO add your handling code here:
        repaint();
        radioPermanent.setSelected(false);
            tfBasicSal.setEditable(false);
            tfOtRate.setEditable(true);
        
    }//GEN-LAST:event_radioTemporaryActionPerformed

    private void radioPermanentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPermanentActionPerformed
        // TODO add your handling code here:
       repaint();
        radioTemporary.setSelected(false);
        tfBasicSal.setEditable(true);
         tfOtRate.setEditable(false);
    }//GEN-LAST:event_radioPermanentActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
          try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement("update employee set status = 'Unavailable' where id = ? ");
              PreparedStatement ps1 = conn.prepareStatement("call disabledEmployees (?) ");
              int id = Integer.parseInt(tfEid.getText());
              ps.setInt(1, id);
              ps1.setInt(1, id);
              ps.executeUpdate();
              ps.executeUpdate();
              JOptionPane.showMessageDialog(null, "Employee disabled successfully");
          } catch (SQLException ex) {
              Logger.getLogger(EmDet.class.getName()).log(Level.SEVERE, null, ex);
          }
          
            DefaultTableModel model = (DefaultTableModel)jTable_Employee.getModel();
                model.setRowCount(0);
                 showEmployeesInJtable();
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
           DefaultTableModel model = (DefaultTableModel)jTable_Employee.getModel();
                model.setRowCount(0);
        showEmployeesInJtable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyPressed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel)jTable_Employee.getModel();
                model.setRowCount(0);
        showEmployeesInJtable();
    }//GEN-LAST:event_tfSearchKeyPressed

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFemaleActionPerformed
        // TODO add your handling code here:
       repaint();
        radioMale.setSelected(false);
       
        
    }//GEN-LAST:event_radioFemaleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EmployeeManagement emp = new EmployeeManagement();
        emp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void labelFnameComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_labelFnameComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_labelFnameComponentAdded

    private void labelnicComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_labelnicComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_labelnicComponentAdded

    private void tfFnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFnameKeyPressed
        // TODO add your handling code here:
        repaint();
        verifyFname() ;
    }//GEN-LAST:event_tfFnameKeyPressed

    private void labelOtRateComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_labelOtRateComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_labelOtRateComponentAdded

    private void labelFnameComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelFnameComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_labelFnameComponentHidden

    private void labelBasicSalComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_labelBasicSalComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBasicSalComponentAdded

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed

        tfEid.setText("");
        tfFname.setText("");
        tfLname.setText("");
        tfNic.setText("");
        dateDOB.setCalendar(null);
        radioMale.setSelected(false);
        radioFemale.setSelected(false);
        comboDepartment.setSelectedItem("");
        comboPosition.setSelectedItem("");
        radioPermanent.setSelected(false);
        radioTemporary.setSelected(false);
        tfBasicSal.setText("");
        tfOtRate.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void tfLnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLnameKeyPressed
        // TODO add your handling code here:
        repaint();
        verifyLname();
     
        
    }//GEN-LAST:event_tfLnameKeyPressed

    private void tfNicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNicKeyPressed
        // TODO add your handling code here:
        repaint();
        verifynic();
    }//GEN-LAST:event_tfNicKeyPressed

    private void tfBasicSalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBasicSalKeyPressed

        repaint();
        verifybasicSal();// TODO add your handling code here:
    }//GEN-LAST:event_tfBasicSalKeyPressed

    private void tfOtRateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOtRateKeyPressed

        repaint();
        verifyHourSal();// TODO add your handling code here:
    }//GEN-LAST:event_tfOtRateKeyPressed

    private void tfFnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFnameKeyReleased

    }//GEN-LAST:event_tfFnameKeyReleased

    private void tfFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFnameKeyTyped
        // TODO add your handling code here:
  
    }//GEN-LAST:event_tfFnameKeyTyped

    private void labelFnameAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_labelFnameAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_labelFnameAncestorRemoved

    private void labelFnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelFnameFocusLost
        // TODO add your handling code here:
     
    }//GEN-LAST:event_labelFnameFocusLost

    private void radioFemaleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioFemaleFocusGained
        // TODO add your handling code here:
        //repaint();
    }//GEN-LAST:event_radioFemaleFocusGained

    private void radioFemaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioFemaleMouseEntered
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_radioFemaleMouseEntered

    private void radioFemaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioFemaleMouseExited
        // TODO add your handling code here:
          repaint();
    }//GEN-LAST:event_radioFemaleMouseExited

    private void radioMaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioMaleMouseEntered
        // TODO add your handling code here:
         repaint();
    }//GEN-LAST:event_radioMaleMouseEntered

    private void radioMaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioMaleMouseExited
        // TODO add your handling code here:
         repaint();
    }//GEN-LAST:event_radioMaleMouseExited

    private void radioPermanentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioPermanentMouseExited
        // TODO add your handling code here:
         repaint();
    }//GEN-LAST:event_radioPermanentMouseExited

    private void radioTemporaryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTemporaryMouseEntered
        // TODO add your handling code here:
         repaint();
    }//GEN-LAST:event_radioTemporaryMouseEntered

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed

        Home h = new Home();
        h.setVisible(true);
        this.setVisible(false);

       // JOptionPane.showMessageDialog(null, "You have successfully Log out");
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
            java.util.logging.Logger.getLogger(EmDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmDet().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Emp_Det;
    private javax.swing.JLabel basicSalary;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboDepartment;
    private javax.swing.JComboBox<String> comboPosition;
    private com.toedter.calendar.JDateChooser dateDOB;
    private javax.swing.JLabel deparment;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel empID;
    private javax.swing.JScrollPane empList;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTable jTable_Employee;
    private javax.swing.JLabel labelBasicSal;
    private javax.swing.JLabel labelEmpDetails;
    private javax.swing.JLabel labelFname;
    private javax.swing.JLabel labelLname;
    private javax.swing.JLabel labelOtRate;
    private javax.swing.JLabel labelnic;
    private javax.swing.JLabel lname;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nic;
    private javax.swing.JLabel otRate;
    private javax.swing.JLabel position;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JRadioButton radioPermanent;
    private javax.swing.JRadioButton radioTemporary;
    private javax.swing.JTextField tfBasicSal;
    private javax.swing.JTextField tfEid;
    private javax.swing.JTextField tfFname;
    private javax.swing.JTextField tfLname;
    private javax.swing.JTextField tfNic;
    private javax.swing.JTextField tfOtRate;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JLabel type;
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
