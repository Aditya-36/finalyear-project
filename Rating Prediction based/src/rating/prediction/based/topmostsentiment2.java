/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rating.prediction.based;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author java1
 */
public class topmostsentiment2 extends javax.swing.JFrame {
    
    Connection con;
    static Statement st;
    static ResultSet rs; 
    static String path;
    static int row;
static String s,name;
String filename;
    private int i;
     String interpersona1 ;
     String interpersona1_userid ;
     String interpersona1_friendid ;
     String interpersona1_totalid ;
     String interpersona2 ;
     String interpersona2_items ;
      String interpersona2_itemsid ;
      String top ;

    /**
     * Creates new form topmostsentiment2
     */
    public topmostsentiment2() {
        try {
            initComponents();
            
             con =  dobc.getConne();
                        st = (Statement) con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(topmostsentiment2.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 510, 230));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------SELECTED_ANY_ITEMS------", "BEAUTY&SPA", "HOME_SERVICE", "HOTEL&TRAVEL", "NIGHT_LIFE", "RESTAURANTS", "SHOPPING", "PETS", " " }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 280, 29));

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setText("INTERPERSONAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 130, 30));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 160, -1));

        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel3.setText(" TOP MOST INTERPERSONAL SENTIMENTAL USER ITEMS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 510, 30));

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 43, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rating/prediction/based/bgg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 440));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-636)/2, (screenSize.height-479)/2, 636, 479);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Vector col = new Vector();
        Vector data = new Vector();
        System.out.println("Connected to the database");
        String str=(String)jComboBox1.getSelectedItem();
        Object selectedItem = jComboBox1.getSelectedItem();

        if(str.equals("BEAUTY&SPA"))
        {
            interpersona1  ="beauty_freind_id";
            interpersona1_userid ="beauty_userid";
            interpersona1_friendid="beauty_friend_id";
            interpersona1_totalid="beauty_total_frienid";
            interpersona2="beauty_items";
            interpersona2_items="beauty_item_name";
            interpersona2_itemsid="beauty_items_id";
            top ="850";

        }
        else  if(str.equals("HOME_SERVICE"))
        {
            interpersona1  ="homeservic_friendid";
            interpersona1_userid ="userid";
            interpersona1_friendid="friendid";
            interpersona1_totalid="home_total_friendid";
            interpersona2="homeservi_item";
            interpersona2_items="home_item_name";
            interpersona2_itemsid="homser_item_id";
             top ="520";

        }
        else  if(str.equals("HOTEL&TRAVEL"))
        {
            interpersona1  ="hotels_userfrienid";
            interpersona1_userid ="hoteluserid";
            interpersona1_friendid="hotelsfrientid";
            interpersona1_totalid="hotel_total_friendid";
            interpersona2="hotelstravel_item";
            interpersona2_items="hote_item_name";
            interpersona2_itemsid="hotel_items_id";
             top ="850";

        }
        else  if(str.equals("NIGHT_LIFE"))
        {
            interpersona1  ="nightlightfriend_id";
            interpersona1_userid ="night_userid";
            interpersona1_friendid="night_friendid";
            interpersona1_totalid="night_total_friendid";
            interpersona2="nightlight_items";
            interpersona2_items="night_item_names";
            interpersona2_itemsid="night_items_id";
             top ="450";

        }
        else  if(str.equals("RESTAURANTS"))
        {
            interpersona1  ="restaruants_userfriend";
            interpersona1_userid ="restaruan_userid";
            interpersona1_friendid="restarun_friend_id";
            interpersona1_totalid="restaru_totalfriendid";
            interpersona2="restaruan_items";
            interpersona2_items="restaruan_item_names";
            interpersona2_itemsid="restaruan_items_id";
             top ="200";

        }
        else  if(str.equals("SHOPPING"))
        {
            interpersona1  ="shooping_userfriendid";
            interpersona1_userid ="shoopin_userid";
            interpersona1_friendid="shoopn_friendid";
            interpersona1_totalid="shoppn_total_friendid";
            interpersona2="shooping_items";
            interpersona2_items="shooping_item_names";
            interpersona2_itemsid="shoping_items_id";
             top ="420";

        }
        else  if(str.equals("PETS"))
        {
            interpersona1  ="pets_useridfriends";
            interpersona1_userid ="pets_userid";
            interpersona1_friendid="pets_useridfriends";
            interpersona1_totalid="pets_total_friendid";
            interpersona2="pets_items";
            interpersona2_items="pets_item_names";
            interpersona2_itemsid="pets_items_id";
             top ="270";

        }

        if (selectedItem.equals("------SELECTED_ANY_ITEMS------"))
        {

            JOptionPane.showMessageDialog(rootPane, "please select any items ");

        }
        else
        {
            try {
                rs = (ResultSet) st.executeQuery("SELECT "+ interpersona1+"."+interpersona1_userid+","+ interpersona1+"."+interpersona1_friendid+" ,"+ interpersona1+"."+interpersona1_totalid+" ,"+interpersona2+"."+interpersona2_items+" FROM "+ interpersona1+" INNER JOIN "+interpersona2+" ON "+ interpersona1+"."+interpersona1_userid+"="+interpersona2+"."+interpersona2_itemsid+" where  "+interpersona1+"."+interpersona1_totalid+" >="+top+"");
                ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
                int columns = md.getColumnCount();
                int count=0;
                for (int i = 1; i <= columns; i++) {
                    col.addElement(md.getColumnName(i));
                }

                while (rs.next()) {
                    count++;
                    Vector row = new Vector(columns);
                    for (int i = 1; i <= columns; i++) {
                        row.addElement(rs.getObject(i));

                    }

                    data.addElement(row);
                }
                jTextField1.setText(Integer.toString(count));

                DefaultTableModel model = new DefaultTableModel(data, col);
                jTable2.setModel(model);
                JOptionPane.showMessageDialog(null, "interpersonal sentimental product items");
                 
            } catch (SQLException ex) {
                Logger.getLogger(topmostsentiment2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new threecatego().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(topmostsentiment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(topmostsentiment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(topmostsentiment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(topmostsentiment2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new topmostsentiment2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}