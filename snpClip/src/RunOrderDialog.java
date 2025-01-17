package snpclip;

import java.util.Vector;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

/*
 * RunOrderDialog.java
 *
 * Created on August 19, 2008, 1:29 PM
 */



/**
 *
 * @author  suna
 */
public class RunOrderDialog extends javax.swing.JDialog {


    // Variables declaration - do not modify
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton DownButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JButton UpButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration

    Vector run_data = new Vector();
    boolean ok_clicked = false;

    /** Creates new form RunOrderDialog */
    public RunOrderDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ordering of filters");
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UpButton = new javax.swing.JButton();
        DownButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        BottomPanel = new javax.swing.JPanel();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        TopPanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();

        Vector v_field = new Vector();
        run_data = new Vector();
        v_field.addElement("Order");
        v_field.addElement("Name");
        //v_field.addElement("Expression");
        //v_field.addElement("Type");

        //jTable1.setFont(new java.awt.Font("Monospaced", 0, 11));
        jTable1.setAutoCreateColumnsFromModel(false);
        //jTable1.setModel(new FunctionExp(run_data, v_field));
        jTable1.setModel(new FunctionExp(run_data, v_field));
        jTable1.setRowHeight(20);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (int i = 0; i < FunctionExp.headers.length; i++) {
            DefaultTableCellRenderer tr = new DefaultTableCellRenderer();
            tr.setHorizontalAlignment(FunctionExp.alignment[i]);
            TableColumn column = new TableColumn(i, FunctionExp.columnWidth[i], tr, null);
            jTable1.addColumn(column);
        }

        jScrollPane1.setViewportView(jTable1);

        UpButton.setText("Up");
        UpButton.setPreferredSize(new java.awt.Dimension(60, 23));
        UpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpButtonActionPerformed();
            }
        });

        DownButton.setText("Down");
        DownButton.setPreferredSize(new java.awt.Dimension(60, 23));
        DownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DownButton, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DownButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                )
        );

        OKButton.setText("OK");
        OKButton.setMaximumSize(new java.awt.Dimension(65, 23));
        OKButton.setMinimumSize(new java.awt.Dimension(65, 23));
        OKButton.setPreferredSize(new java.awt.Dimension(65, 23));
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed();
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout BottomPanelLayout = new javax.swing.GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CancelButton)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        BottomPanelLayout.setVerticalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        TopPanel.setBackground(new java.awt.Color(255, 255, 255));

        TitleLabel.setText("Please set the order of filtering criteria.");

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addContainerGap()
                )
        );

        pack();
    }// </editor-fold>

    private void UpButtonActionPerformed()
    {
        int current = jTable1.getSelectedRow();
        if (current > 0) {
            Vector movev = (Vector) run_data.get(current);
            Vector backup = (Vector) run_data.get(current - 1);

            run_data.setElementAt(movev, current - 1);
            run_data.setElementAt(backup, current);

            jTable1.updateUI();
        }
    }

    private void DownButtonActionPerformed()
    {
        int current = jTable1.getSelectedRow();
        if (current >= 0 && current < run_data.size() - 1) {
            Vector movev = (Vector) run_data.get(current);
            Vector backup = (Vector) run_data.get(current + 1);

            run_data.setElementAt(movev, current + 1);
            run_data.setElementAt(backup, current);

            jTable1.updateUI();
        }
    }

    private void OKButtonActionPerformed() {
        ok_clicked = true;
        dispose();
    }

    private void CancelButtonActionPerformed() {
        ok_clicked = false;
        dispose();
    }
}


class FunctionExp extends DefaultTableModel {
    //public static String[] headers = new String[] {"Name", "Expression", "Type"};
    public static String[] headers = new String[] {"Order", "Name"};
    public static int[] columnWidth = new int[] {100, 250, 90};
    static int[] alignment = new int[] {JLabel.LEFT, JLabel.LEFT, JLabel.LEFT};

    protected Vector dataVector;

    public FunctionExp(Vector data, Vector field) {
        super(data, field);
        dataVector = data;
    }

  /*  public void setValueAt(Object ob, int row, int column)
    {
        if(column == 0)
        {
            Vector rowVector = (Vector)dataVector.elementAt(row);
            rowVector.setElementAt(row+1, column);
        }
        else
        {
            Vector rowVector = (Vector)dataVector.elementAt(row);
            rowVector.setElementAt(row, column);
        }
    }*/

    public Object getValueAt(int row, int column) {
        Vector rowVector = (Vector)dataVector.elementAt(row);

        if(column == 0)
        {
            return row+1;
        }
        else
            return rowVector.elementAt(column);

    }
}
