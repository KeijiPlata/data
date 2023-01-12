/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package joysis_ams;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JAYCEE
 */
public class Student extends javax.swing.JFrame {
    static String viewqry;
    static String strDate ;
     public void qryDate(String Date){
         try{
            String db = "jdbc:mysql://localhost:3306/joysis_ams";
            Connection conn = DriverManager.getConnection(db, "root", null);
            String qry = "SELECT * FROM attendance WHERE date = ?";
            PreparedStatement ps = conn.prepareStatement(qry);
            ps.setString(1, Date);
            ResultSet rslt = ps.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel)jtbl.getModel();
            tbl.setRowCount(0);
            while(rslt.next()){
                String date = rslt.getString("date");
                String stats = rslt.getString("status");
                String remarks = rslt.getString("remarks");
                
                String data[] = {date, stats, remarks};
                tbl.addRow(data);
            }
            
         }
         catch(Exception a){
            JOptionPane.showMessageDialog(null, a);
            a.printStackTrace();
         }
     }
     public void viewTable(String qry, String id){
          try{
            String db = "jdbc:mysql://localhost:3306/joysis_ams";
            Connection conn = DriverManager.getConnection(db, "root", null);
            PreparedStatement ps = conn.prepareStatement(qry);
            ps.setString(1, id);
            ResultSet rslt = ps.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel)jtbl.getModel();
            tbl.setRowCount(0);
            while(rslt.next()){
                String date = rslt.getString("date");
                String stats = rslt.getString("status");
                String remarks = rslt.getString("remarks");
                
                String data[] = {date, stats, remarks};
                tbl.addRow(data);
            }
         }
         catch(Exception a){
            JOptionPane.showMessageDialog(null, a);
            a.printStackTrace();
         }

     }

     public void ComboBoxqry(){
        String selected = studentstatus.getSelectedItem().toString();
         switch(selected){
             case "Present":
                 viewqry = "SELECT * FROM attendance WHERE student_id = ? AND status = 'Present'";
                 break;
             case "Absent":
                 viewqry = "SELECT * FROM attendance  WHERE student_id = ? AND status = 'Absent'";
                 break;
                 
             case "Late":
                 viewqry = "SELECT * FROM attendance  WHERE student_id = ? AND status = 'Late'";
                 break;
                 
             default:
                 viewqry = "SELECT * FROM attendance  WHERE student_id = ?";
                 break;        
         }
     }
    /**
     * Creates new form Student
     */
    public Student() {
        initComponents();
         
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
        studentName = new javax.swing.JLabel();
        studentId = new javax.swing.JLabel();
        studentSection = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl = new javax.swing.JTable();
        studentDate = new com.toedter.calendar.JDateChooser();
        studentstatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        studentName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        studentName.setText("Student Name");
        studentName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentNameMouseClicked(evt);
            }
        });

        studentId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentId.setText("(Student ID)");

        studentSection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentSection.setText("Section");

        jtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Status", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbl);

        studentDate.setDateFormatString("yyyy-mm-dd");
        studentDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentDateMouseClicked(evt);
            }
        });

        studentstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Present", "Late", "Absent" }));
        studentstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentstatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentName)
                            .addComponent(studentstatus, 0, 104, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(studentId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(studentSection)))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentName)
                    .addComponent(studentId)
                    .addComponent(studentSection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentstatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        login lg = new login();
        ConnectionDB cdb = new ConnectionDB();
        String username = lg.username1;
        String studentid = Integer.toString(cdb.id);
        cdb.getUsername(username);
        ComboBoxqry();
        viewTable(viewqry, studentid);
        studentName.setText(cdb.fname + " " + cdb.mname + " " + cdb.lname);
        studentId.setText(Integer.toString(cdb.id));
        studentSection.setText(cdb.sec);
     
    }//GEN-LAST:event_formWindowOpened

    private void studentNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameMouseClicked

    private void studentstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentstatusActionPerformed
        // TODO add your handling code here:
        login lg = new login();
        ConnectionDB cdb = new ConnectionDB();
        String username = lg.username1;
        String studentid = Integer.toString(cdb.id);
        cdb.getUsername(username);
        ComboBoxqry();
        viewTable(viewqry, studentid);
    }//GEN-LAST:event_studentstatusActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
     
        
    }//GEN-LAST:event_formWindowActivated

    private void studentDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentDateMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_studentDateMouseClicked

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbl;
    private com.toedter.calendar.JDateChooser studentDate;
    private javax.swing.JLabel studentId;
    private javax.swing.JLabel studentName;
    private javax.swing.JLabel studentSection;
    private javax.swing.JComboBox<String> studentstatus;
    // End of variables declaration//GEN-END:variables
}
