package sage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.io.File;
import java.net.URL;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Dialog2_Relationship2 extends JInternalFrame implements ItemListener, ActionListener{
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jTopPanel = new JPanel();
  JPanel jCenterPanel = new JPanel();
  JPanel jBottomPanel = new JPanel();
  XYLayout xYLayout1 = new XYLayout();
  JLabel jLabel1 = new JLabel();
  JComboBox jComboBox1 = new JComboBox();
  JComboBox jComboBox2 = new JComboBox();
  JLabel jLabel4 = new JLabel();
  MyComboBox jComboBox4 = new MyComboBox();
  JPanel jPanel4 = new JPanel();
  TitledBorder titledBorder1;
  XYLayout xYLayout2 = new XYLayout();
  JPanel jPanel5 = new JPanel();
  ButtonGroup bp = new ButtonGroup();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  DataCollectionModel model;

  EdgeBorder lineborder = new EdgeBorder();

  MakePedigreeStep2 parent;
  JButton jButton3 = new JButton();

  String person1 = new String();
  String person2 = new String();

  jxl.write.Number number1;
  jxl.write.Number number2;
  FlowLayout flowLayout1 = new FlowLayout();
  static SimpleAttributeSet RED = new SimpleAttributeSet();
  static SimpleAttributeSet BLACK = new SimpleAttributeSet();
  JPanel jButtonPanel = new JPanel();
  XYLayout xYLayout3 = new XYLayout();
  JRadioButton jRadioButton1 = new JRadioButton();
  JRadioButton jRadioButton2 = new JRadioButton();
  JRadioButton jRadioButton3 = new JRadioButton();
  JRadioButton jRadioButton4 = new JRadioButton();
  JRadioButton jRadioButton5 = new JRadioButton();
  JLabel jLabel3 = new JLabel();

  MouseTooltip mouselistener = new MouseTooltip();


  // Best to reuse attribute sets as much as possible.
  static {
    StyleConstants.setForeground(RED, Color.red);
    StyleConstants.setFontFamily(RED, "Dialog");
    StyleConstants.setFontSize(RED, 10);
    StyleConstants.setForeground(BLACK, Color.black);
    StyleConstants.setFontFamily(BLACK, "Dialog");
    StyleConstants.setFontSize(BLACK, 10);
  }
  public void showDialog() {
     //center
     int xlocation = (JWizardProject.wizardProject.getWidth() - this.getWidth())/2 + JWizardProject.locationx;
     int ylocation = (JWizardProject.wizardProject.getHeight() - this.getHeight())/2 + JWizardProject.locationy ;
     this.setLocation(xlocation, ylocation);
     setVisible(true);
 }

  public Dialog2_Relationship2(MakePedigreeStep2 parent, String title) {
    //super(Frame1.mainFrame1, title, true);
    setTitle(title);
    setModel(new PropertyDataModel());
    this.parent = parent;
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public void setModel(DataCollectionModel model)
  {
          this.model = model;
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setSize(new Dimension(380,330));
    jComboBox4.setWidth(100);

    jTopPanel.setBackground(Color.white);
    jTopPanel.setPreferredSize(new Dimension(380,40));
    jCenterPanel.setPreferredSize(new Dimension(380,250));
    jCenterPanel.setLayout(xYLayout1);
    jCenterPanel.setBorder(lineborder);
    jBottomPanel.setBorder(lineborder);
    jBottomPanel.setPreferredSize(new Dimension(380,40));
    jBottomPanel.setLayout(flowLayout1);
    panel1.setLayout(borderLayout1);
    jLabel1.setIcon(new ImageIcon(Dialog2_Relationship2.class.getResource("person1.png")));
    jLabel1.setIconTextGap(4);
    jLabel1.setText("ID");
    jLabel4.setIcon(new ImageIcon(Dialog2_Relationship2.class.getResource("person2.png")));
    jLabel4.setText("ID(s)");
    jPanel4.setBorder(titledBorder1);
    jPanel4.setLayout(xYLayout2);
    jPanel5.setBorder(titledBorder1);
    jPanel5.setLayout(xYLayout2);
    jButton1.setText("Yes");
    jButton2.setToolTipText("");
    jButton1.setPreferredSize(new Dimension(60, 25));
    jButton2.setPreferredSize(new Dimension(60, 25));
    jButton3.setPreferredSize(new Dimension(60, 25));
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.setText("No");
    jButton3.setText("Done");
    jButtonPanel.setLayout(xYLayout3);
    jRadioButton1.setSelected(true);
    jRadioButton1.setText("Father-Offspring");
    jRadioButton2.setText("Mother-Offspring");
    jRadioButton3.setText("Full-Sibling");
    jRadioButton4.setText("Maternal-Half-Sib");
    jRadioButton5.setText("Paternal-Half-Sib");
    jLabel3.setText("PID");
    getContentPane().add(panel1);
    panel1.add(jTopPanel,  BorderLayout.NORTH);
    panel1.add(jCenterPanel, BorderLayout.CENTER);
    panel1.add(jBottomPanel, BorderLayout.SOUTH);
    jBottomPanel.add(jButton1, null);
    jBottomPanel.add(jButton2, null);
    jBottomPanel.add(jButton3, null);
    jComboBox1.addItemListener(this);

    jButton1.addActionListener(this);
    jButton2.addActionListener(this);
    jButton3.addActionListener(this);
    jRadioButton1.addActionListener(this);
    jRadioButton2.addActionListener(this);
    jRadioButton3.addActionListener(this);
    jRadioButton4.addActionListener(this);
    jRadioButton5.addActionListener(this);
    bp.add(jRadioButton1);
    jButtonPanel.add(jRadioButton1, new XYConstraints(10, 10, 120, 20));
    jButtonPanel.add(jRadioButton2, new XYConstraints(10, 40, 120, 20));
    jButtonPanel.add(jRadioButton3, new XYConstraints(10, 70, 120, 20));
    jButtonPanel.add(jRadioButton4, new XYConstraints(10, 100, 120, 20));
    jButtonPanel.add(jRadioButton5, new XYConstraints(10, 130, 120, 20));
    bp.add(jRadioButton2);
    bp.add(jRadioButton3);
    bp.add(jRadioButton4);
    bp.add(jRadioButton5);
    jPanel4.add(jLabel1, new XYConstraints(5, 4, 50, 20));
    jPanel5.add(jLabel4, new XYConstraints(5, 4, 50, 20));
    jPanel4.add(jComboBox2, new XYConstraints(60, 4, 100, 20));
    jPanel5.add(jComboBox4, new XYConstraints(60, 4, 100, 20));
    jCenterPanel.add(jLabel3, new XYConstraints(20, 20, 50, 20));
    jCenterPanel.add(jPanel4, new XYConstraints(20, 70, 180, 40));
    jCenterPanel.add(jPanel5, new XYConstraints(20, 180, 180, 40));
    jCenterPanel.add(jButtonPanel, new XYConstraints(220, 65, 120, 160));
    jCenterPanel.add(jComboBox1, new XYConstraints(85, 20, 250, 20));

    jButtonPanel.addMouseMotionListener(mouselistener);

  }

  public void actionPerformed(ActionEvent e)
  {
    Object ob = e.getSource();
    /*    setToolTipText();
    if(ob == jRadioButton1)
    {
      setPersonString();
      String relationship = "<html>"+person1 + "<br>is the father of <br>" + person2;// + ".\n"+"Is this correct?";
      jRadioButton1.setToolTipText(relationship);

    }
    else if(ob == jRadioButton2)
    {
      setPersonString();
      String relationship = "<html>"+person1 + "<br>is the mother of <br>" + person2;// + ".\n"+"Is this correct?";
      jRadioButton2.setToolTipText(relationship);
    }
    else if(ob == jRadioButton3)
    {
      setPersonString();
      String relationship = "<html>"+person1 + "<br>and <br>" + person2 + "<br>have same parents.";//+"\nIs this correct?";
      jRadioButton3.setToolTipText(relationship);
    }
    else if(ob == jRadioButton4)
    {
      setPersonString();
      String relationship = "<html>"+person1 + "<br>and <br>" + person2 + "<br>have same mother.";//+"\nIs this correct?";
      jRadioButton4.setToolTipText(relationship);
    }
    else if(ob == jRadioButton5)
    {
      setPersonString();
      String relationship = "<html>"+person1 + "<br>and <br>" + person2 + "<br>have same father.";//+"\nIs this correct?";
      jRadioButton5.setToolTipText(relationship);
    }*/
    if(ob == jButton1)//Yes
    {
      try {
        if (jRadioButton1.isSelected())
          setFatherOffSpring();
        else if (jRadioButton2.isSelected())
          setMotherOffSpring();
        else if (jRadioButton3.isSelected())
          setFullSibling();
        else if (jRadioButton4.isSelected())
          setMaternalHalfSib();
        else if (jRadioButton5.isSelected())
          setParternalHalfSib();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    else if(ob == jButton2)//No
    {

    }
    else if(ob == jButton3)//Done
    {
      this.setVisible(false);
    }
  }

  public void itemStateChanged(ItemEvent e) {
    Object ob = e.getSource();
    if(ob == jComboBox1)
    {
      String pid = jComboBox1.getSelectedItem().toString().trim();
      Vector iid_list = ChangeStateAll(pid);
      ChangeStatejComboBox4(iid_list);
      setPersonString();
      setToolTipText();
    }
  }

  void setFatherOffSpring() throws Exception
  {
    String result_id = jComboBox2.getSelectedItem().toString();

    String index_s = model.getValue(jComboBox1.getSelectedItem().toString()).toString();
    int index = Integer.parseInt(index_s);

    ListModel model = jComboBox4.jList1.getModel();
    int n = model.getSize();
    for (int i = 0; i < n; i++) {
      CheckableItem item = (CheckableItem) model.getElementAt(i);
      if (item.isSelected()) {
          parent.dm3.setValueAt(result_id, i+index, 2); //object, row, col
          number1 = new jxl.write.Number(2,i+index+1, Integer.parseInt(result_id));
          parent.resultsheet.addCell(number1);
      }
    }
  }

  void setMotherOffSpring() throws Exception
  {
    String result_id = jComboBox2.getSelectedItem().toString();

    String index_s = model.getValue(jComboBox1.getSelectedItem().toString()).toString();
    int index = Integer.parseInt(index_s);

    ListModel model = jComboBox4.jList1.getModel();
    int n = model.getSize();
    for (int i = 0; i < n; i++) {
      CheckableItem item = (CheckableItem) model.getElementAt(i);
      if (item.isSelected()) {
          parent.dm3.setValueAt(result_id, i+index, 3); //object, row, col
          number1 = new jxl.write.Number(3,i+index+1, Integer.parseInt(result_id));
          parent.resultsheet.addCell(number1);
      }
    }
  }

  void setFullSibling() throws Exception
  {
    String parent1 = null;
    String parent2 = null;

    String index_s = model.getValue(jComboBox1.getSelectedItem().toString()).toString();
    int index = Integer.parseInt(index_s);

    ListModel model = jComboBox4.jList1.getModel();
    int n = model.getSize();
    for (int i = 0; i < n; i++) {
      CheckableItem item = (CheckableItem) model.getElementAt(i);
      if (item.isSelected()) {
        if (parent.dm3.getValueAt(i + index, 2) != null
            && parent.dm3.getValueAt(i + index, 3) != null) {

          String parent1_temp = parent.dm3.getValueAt(i + index, 2).toString();
          String parent2_temp = parent.dm3.getValueAt(i + index, 3).toString();

          parent1 = parent1_temp;
          parent2 = parent2_temp;

          break;
        }
      }
    }
  // no parent information both of them
    if(parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 2)==null ||
       parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 3)==null)
    {
      if(parent1 == null || parent2 == null)
      {
        String message = "You must specify the individual's parents first.";
        JOptionPane.showConfirmDialog(parent, message,"Warning", JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        return;
      }
      if(parent1 != null && parent2 != null)
      {
        parent.dm3.setValueAt(parent1, jComboBox2.getSelectedIndex()+index-1, 2); //object, row, col
        parent.dm3.setValueAt(parent2, jComboBox2.getSelectedIndex()+index-1, 3); //object, row, col
        number1 = new jxl.write.Number(2,jComboBox2.getSelectedIndex()+index, Integer.parseInt(parent1));
        parent.resultsheet.addCell(number1);
        number2 = new jxl.write.Number(3,jComboBox2.getSelectedIndex()+index, Integer.parseInt(parent2));
        parent.resultsheet.addCell(number2);

        for (int i = 0; i < n; i++) {
          CheckableItem item = (CheckableItem) model.getElementAt(i);
          if (item.isSelected()) {
            parent.dm3.setValueAt(parent1, i+index, 2); //object, row, col
            parent.dm3.setValueAt(parent2, i+index, 3); //object, row, col
            number1 = new jxl.write.Number(2,i+index+1, Integer.parseInt(parent1));
            parent.resultsheet.addCell(number1);
            number2 = new jxl.write.Number(3,i+index+1, Integer.parseInt(parent2));
            parent.resultsheet.addCell(number2);
          }
        }
      }
    }
    else
    {
        parent1 = parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 2).toString();
        parent2 = parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 3).toString();
        for (int i = 0; i < n; i++) {
          CheckableItem item = (CheckableItem) model.getElementAt(i);
          if (item.isSelected()) {
            parent.dm3.setValueAt(parent1, i + index, 2); //object, row, col
            parent.dm3.setValueAt(parent2, i + index, 3); //object, row, col
            number1 = new jxl.write.Number(2, i + index+1, Integer.parseInt(parent1));
            parent.resultsheet.addCell(number1);
            number2 = new jxl.write.Number(3, i + index+1, Integer.parseInt(parent2));
            parent.resultsheet.addCell(number2);
          }
        }
    }
  }

  void setMaternalHalfSib() throws Exception
  {
    String parent2 = null;

    String index_s = model.getValue(jComboBox1.getSelectedItem().toString()).toString();
    int index = Integer.parseInt(index_s);

    ListModel model = jComboBox4.jList1.getModel();
    int n = model.getSize();
    for (int i = 0; i < n; i++) {
      CheckableItem item = (CheckableItem) model.getElementAt(i);
      if (item.isSelected()) {
        if (parent.dm3.getValueAt(i + index, 3) != null) {

          String parent2_temp = parent.dm3.getValueAt(i + index, 3).toString();
          parent2 = parent2_temp;

          break;
        }
      }
    }

  // no parent information both of them
    if(parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 3)==null)
    {
      if(parent2 == null)
      {
        String message = "You must specify the individual's parents first.";
        JOptionPane.showConfirmDialog(parent, message,"Warning", JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        return;
      }
      if(parent2 != null)
      {
        parent.dm3.setValueAt(parent2, jComboBox2.getSelectedIndex()+index-1, 3); //object, row, col
        number2 = new jxl.write.Number(3,jComboBox2.getSelectedIndex()+index, Integer.parseInt(parent2));
        parent.resultsheet.addCell(number2);

        for (int i = 0; i < n; i++) {
          CheckableItem item = (CheckableItem) model.getElementAt(i);
          if (item.isSelected()) {
            parent.dm3.setValueAt(parent2, i+index, 3); //object, row, col
            number2 = new jxl.write.Number(3,i+index+1, Integer.parseInt(parent2));
            parent.resultsheet.addCell(number2);
          }
        }
      }
    }
    else
    {
        parent2 = parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 3).toString();
        for (int i = 0; i < n; i++) {
          CheckableItem item = (CheckableItem) model.getElementAt(i);
          if (item.isSelected()) {
            parent.dm3.setValueAt(parent2, i + index, 3); //object, row, col
            number2 = new jxl.write.Number(3, i + index+1, Integer.parseInt(parent2));
            parent.resultsheet.addCell(number2);
          }
        }
    }
  }

  void setParternalHalfSib() throws Exception
  {
    String parent1 = null;

    String index_s = model.getValue(jComboBox1.getSelectedItem().toString()).toString();
    int index = Integer.parseInt(index_s);

    ListModel model = jComboBox4.jList1.getModel();
    int n = model.getSize();
    for (int i = 0; i < n; i++) {
      CheckableItem item = (CheckableItem) model.getElementAt(i);
      if (item.isSelected()) {
        if (parent.dm3.getValueAt(i + index, 2) != null) {
          String parent1_temp = parent.dm3.getValueAt(i + index, 2).toString();
          parent1 = parent1_temp;
          break;
        }
      }
    }

  // no parent information both of them
    if(parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 2)==null)
    {
      if(parent1 == null)
      {
        String message = "You must specify the individual's parents first.";
        JOptionPane.showConfirmDialog(parent, message,"Warning", JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        return;
      }
      if(parent1 != null)
      {
        parent.dm3.setValueAt(parent1, jComboBox2.getSelectedIndex()+index-1, 2); //object, row, col
        number1 = new jxl.write.Number(2,jComboBox2.getSelectedIndex()+index, Integer.parseInt(parent1));
        parent.resultsheet.addCell(number1);

        for (int i = 0; i < n; i++) {
          CheckableItem item = (CheckableItem) model.getElementAt(i);
          if (item.isSelected()) {
            parent.dm3.setValueAt(parent1, i+index, 2); //object, row, col
            number1 = new jxl.write.Number(2,i+index+1, Integer.parseInt(parent1));
            parent.resultsheet.addCell(number1);
          }
        }
      }
    }
    else
    {
        parent1 = parent.dm3.getValueAt(jComboBox2.getSelectedIndex()+index-1, 2).toString();
        for (int i = 0; i < n; i++) {
          CheckableItem item = (CheckableItem) model.getElementAt(i);
          if (item.isSelected()) {
            parent.dm3.setValueAt(parent1, i + index, 2); //object, row, col
            number1 = new jxl.write.Number(2, i + index+1, Integer.parseInt(parent1));
            parent.resultsheet.addCell(number1);
          }
        }
    }
  }

  void setToolTipText()
  {
    setPersonString();
    String relationship = "<html>"+person1 + "<br>is the father of <br>" + person2;// + ".\n"+"Is this correct?";
    jRadioButton1.setToolTipText(relationship);

    String relationship2 = "<html>"+person1 + "<br>is the mother of <br>" + person2;// + ".\n"+"Is this correct?";
    jRadioButton2.setToolTipText(relationship2);

    String relationship3 = "<html>"+person1 + "<br>and <br>" + person2 + "<br>have same parents.";//+"\nIs this correct?";
    jRadioButton3.setToolTipText(relationship3);

    String relationship4 = "<html>"+person1 + "<br>and <br>" + person2 + "<br>have same mother.";//+"\nIs this correct?";
    jRadioButton4.setToolTipText(relationship4);

    String relationship5 = "<html>"+person1 + "<br>and <br>" + person2 + "<br>have same father.";//+"\nIs this correct?";
    jRadioButton5.setToolTipText(relationship5);
  }

  void setPersonString()
  {
    person1 = "";
    person2 = "";

    String person1Pid = jComboBox1.getSelectedItem().toString().trim();
    String person1Id = jComboBox2.getSelectedItem().toString().trim();

    person1 = "Pedigree("+person1Pid+")ID("+person1Id+")";

    ListModel model = jComboBox4.jList1.getModel();
    int n = model.getSize();
    for (int i = 0; i < n; i++) {
      CheckableItem item = (CheckableItem) model.getElementAt(i);
      if (item.isSelected()) {
        person2 = person2 + ", Pedigree("+person1Pid+")ID("+item.toString()+")";
      }
    }
    person2 = person2.replaceFirst(",","");
  }

  public Vector ChangeStateAll(String pid)
  {
    jComboBox2.removeAllItems();
    Vector iid_list = get_same_iid_list(pid);
    for (int i = 0; i < iid_list.size(); i++)
    {
      jComboBox2.addItem(iid_list.get(i).toString());
    }

    return iid_list;
  }

  void ChangeStatejComboBox4(Vector iid_list)
  {
    CheckableItem[] total_items = new CheckableItem[iid_list.size()-1];

    int i=0;
    String selected_list=new String();

      String iid = jComboBox2.getSelectedItem().toString();
      for (Enumeration em = iid_list.elements(); em.hasMoreElements();) {
        String temp = em.nextElement().toString();
        if(iid.compareTo(temp)!=0)
        {
          VariableData temp2 = new VariableData(temp, "id");
          total_items[i] = new CheckableItem(temp2);
          total_items[i].setSelected(true);
          selected_list = selected_list+", "+temp;
          i++;
        }
      }

      jComboBox4.jList1.setListData(total_items);
      selected_list = selected_list.replaceFirst(",", "");
      selected_list = selected_list.trim();
      jComboBox4.setSelectedItem(selected_list);
  }

  public Vector get_same_iid_list(String pid)
  {
    int row_count = parent.dm1.getDataVector().size();
    Vector result_iid_list = new Vector();

    for (int i = 0; i < row_count; i++) {
      String pid_temp = parent.dm1.getValueAt(i, 0).toString();
      if (pid_temp.compareTo(pid) == 0) {
        String id_temp = parent.dm1.getValueAt(i, 1).toString();
        result_iid_list.add(id_temp);
      }
    }
    return result_iid_list;
  }

  public void initData()
  {
    Vector pid_list = get_pid_list();
    DefaultComboBoxModel model1 = new DefaultComboBoxModel();

    for(int i=0;i<pid_list.size();i++)
    {
      model1.addElement(pid_list.get(i).toString());
    }

    jComboBox1.setModel(model1);

    Vector iid_list = ChangeStateAll(pid_list.get(0).toString());
    ChangeStatejComboBox4(iid_list);
    setPersonString();
    String relationship = person1 + " is the father of " + person2;// + ".\n"+"Is this correct?";
  }

  public Vector get_pid_list()
  {
    int row_count = parent.dm1.getDataVector().size();
    Vector result_pid_list = new Vector();
    String strPid = new String();
    String strPidNext = new String();

    for(int i=0;i<row_count;i++)
    {
      strPid = parent.dm1.getValueAt(i,0).toString();
      if(strPid.compareTo(strPidNext)!=0)
      {
          result_pid_list.add(strPid);
          model.setValue(strPid, Integer.toString(i+1));
      }
      strPidNext = strPid;
    }
    return result_pid_list;
  }

  class MouseTooltip extends MouseMotionAdapter
  {
    public void mouseMoved(MouseEvent e)
    {
        setToolTipText();
    }

  }

}

