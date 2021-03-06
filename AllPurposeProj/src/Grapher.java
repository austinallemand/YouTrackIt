
import allpurposeproj.ConnectDb;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JCheckBox;

import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Austin
 */



public class Grapher extends javax.swing.JFrame {

Connection connectDb = null;
ResultSet rs = null;
PreparedStatement pst = null;
ArrayList<JCheckBox> gLab2 = new ArrayList<>();
private ArrayList<String> graphVars = new ArrayList<>(); 
    
    
    
    /**
     * Creates new form Grapher
     */
    public Grapher() {
        initComponents();
        connectDb = ConnectDb.connectDB();
        gLab2.add(column1);
        gLab2.add(column2);
        gLab2.add(column3);
        gLab2.add(column4);
        getColumn();
        updateTable();
    }
    
    private void updateTable() {
        
        try {
        String sql = "select * from StorePOS";
        pst = connectDb.prepareStatement(sql);
        rs = pst.executeQuery();
        Graph_Table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        } finally {
            try{
                rs.close();
                    pst.close();
            }
            catch(Exception e) {
                
            }
        }
    }
    
    
    
    
    
       private void getColumnNames(ResultSet rs) throws SQLException{
        

        

        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numColumns = rsMetaData.getColumnCount();
        
        for(int i = 1; i<numColumns + 1; i++){
           
            String columnName = rsMetaData.getColumnName(i);
               
            
            gLab2.get(i-1).setText(columnName);
  
            }
        
        rs.close();
        pst.close();
    }
    
    private void getColumn() {
        
        try{
        String sql = "select * from StorePOS";
        pst = connectDb.prepareStatement(sql);
        rs = pst.executeQuery();
        getColumnNames(rs);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
                }finally {
            try{
                rs.close();
                    pst.close();
            }
            catch(Exception e) {
                
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
        Graph_Table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        column1 = new javax.swing.JCheckBox();
        column2 = new javax.swing.JCheckBox();
        column4 = new javax.swing.JCheckBox();
        column3 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        lineGraph = new javax.swing.JCheckBox();
        barGraph = new javax.swing.JCheckBox();
        pieChart = new javax.swing.JCheckBox();
        cmd_Graph = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Graph_Table.setModel(new javax.swing.table.DefaultTableModel(
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
        Graph_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Graph_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Graph_Table);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "What to Display", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        column1.setText("Column1");

        column2.setText("Column 2");

        column4.setText("Column 4");

        column3.setText("Column 3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(column1)
                    .addComponent(column2)
                    .addComponent(column4)
                    .addComponent(column3))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {column1, column3, column4});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(column1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(column2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(column3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(column4)
                .addContainerGap())
        );

        lineGraph.setText("Line Graph");

        barGraph.setText("Bar Graph");

        pieChart.setText("Pie Chart");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineGraph)
                    .addComponent(barGraph)
                    .addComponent(pieChart))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {barGraph, lineGraph, pieChart});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pieChart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barGraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineGraph)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {barGraph, lineGraph, pieChart});

        cmd_Graph.setText("Graph");
        cmd_Graph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_GraphActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cmd_Graph)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmd_Graph)))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_GraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_GraphActionPerformed
        
        
       
       if(pieChart.isSelected()) {
           DefaultPieDataset pieDataSet = new DefaultPieDataset();
           if(column1.isSelected()) {
           pieDataSet.setValue("ItemNum",new Integer(graphVars.get(0)));
           }
           
            if(column3.isSelected()) {
                pieDataSet.setValue("Quantity",new Integer(graphVars.get(2)));
            }
           if(column4.isSelected()) {
               pieDataSet.setValue("Price",new Double(graphVars.get(3)));
           }
           JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", pieDataSet,true,true,true);
           
           ChartFrame frame = new ChartFrame("Pie Chart",chart);
           frame.setVisible(true);
           frame.setSize(500,450);
           
       }
       
       if(barGraph.isSelected()) {
           DefaultCategoryDataset chart = new DefaultCategoryDataset();
           
           if(column1.isSelected()) {
           chart.setValue((Integer.valueOf(graphVars.get(0))),"Number of", "Item Number");
           }
          
           
            if(column3.isSelected()) {
                chart.setValue((Integer.valueOf(graphVars.get(2))),"Number of", "Quantity");
            }
           if(column4.isSelected()) {
               chart.setValue((new Double(graphVars.get(3))),"Number of", "Price");
           }
           
           JFreeChart chart2 = ChartFactory.createBarChart3D("Item Inventory","Test#1","Number Of", chart, PlotOrientation.VERTICAL, false, true, false);
           CategoryPlot p2 = chart2.getCategoryPlot();
          
           ChartFrame frame = new ChartFrame("Bar Chart for Table", chart2);
           frame.setVisible(true);
           frame.setSize(500,450);
       }
       
       if(lineGraph.isSelected()) {
           DefaultCategoryDataset chart = new DefaultCategoryDataset();
           
           if(column1.isSelected()) {
           chart.setValue((Integer.valueOf(graphVars.get(0))),"Number of", "Item Number");
           }
          
           
            if(column3.isSelected()) {
                chart.setValue((Integer.valueOf(graphVars.get(2))),"Number of", "Quantity");
            }
           if(column4.isSelected()) {
               chart.setValue((new Double(graphVars.get(3))),"Number of", "Price");
           }
           
           JFreeChart chart2 = ChartFactory.createLineChart("Item Inventory","Test#1","Number Of", chart, PlotOrientation.VERTICAL, false, true, false);
           CategoryPlot p2 = chart2.getCategoryPlot();
          
           ChartFrame frame = new ChartFrame("Bar Chart for Table", chart2);
           frame.setVisible(true);
           frame.setSize(500,450);
       }
       
       
               
    }//GEN-LAST:event_cmd_GraphActionPerformed

    private void Graph_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Graph_TableMouseClicked
        try{
            
            int row = Graph_Table.getSelectedRow();
            String Table_click = (Graph_Table.getModel().getValueAt(row, 0).toString());
            String sql = "select * from StorePOS where ItemNum = '" +Table_click+ "' ";
            pst = connectDb.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                
                String add1 = rs.getString("ItemNum");
                graphVars.add(add1);
                String add2 = rs.getString("ItemName");
                graphVars.add(add2);
                String add3 = rs.getString("Quantity");
                graphVars.add(add3);
                String add4 = rs.getString("Price");
                graphVars.add(add4);
            }
            
            
            
            
        }catch(Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Graph_TableMouseClicked

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
            java.util.logging.Logger.getLogger(Grapher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grapher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grapher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grapher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grapher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Graph_Table;
    private javax.swing.JCheckBox barGraph;
    private javax.swing.JButton cmd_Graph;
    private javax.swing.JCheckBox column1;
    private javax.swing.JCheckBox column2;
    private javax.swing.JCheckBox column3;
    private javax.swing.JCheckBox column4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox lineGraph;
    private javax.swing.JCheckBox pieChart;
    // End of variables declaration//GEN-END:variables
}
