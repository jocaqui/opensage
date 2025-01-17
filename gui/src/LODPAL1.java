package sage;

import com.borland.jbcl.layout.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.text.Document;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;
import java.util.*;

public class LODPAL1
    extends SageFilePanel
    implements DocumentListener, ActionListener {
  IconNode analysis_node;
  IconNode errorF_node;
  IconNode errorpedigree_node;
  IconNode errorlocus_node;
  IconNode pedi_node;
  IconNode ibd_node;

  XYLayout xYLayout1 = new XYLayout();
  JLabel jLabel3 = new JLabel();
  JTextField jTextField3 = new JTextField();
  JButton jButton3 = new JButton();

  public LODPAL1(sage_analysis_info data, IconNode inputnode,
                 IconNode errornode) {
    Analysis_object = data;
    analysis_node = inputnode;
    errorF_node = errornode;
    setModel(new PropertyDataModel());

    Analysis_object.create_error_folder= true;

    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void setModel(DataCollectionModel model) {
    this.Datamodel = model;
    Datamodel.setValue("output_name", "lodpal");
  }

  void jbInit() throws Exception {
    NodeInfo outputfolder = new NodeInfo("Output", "OutputFolder", "LODPAL",
                                         Analysis_object, "");
    outputF_node = new IconNode(outputfolder, "OutputFolder");

    this.setLayout(xYLayout1);

    xYLayout1.setWidth(500);
    xYLayout1.setHeight(560);
    jLabel3.setToolTipText(
        "<html>Stores identity-by-descent (IBD) distributions between pairs of related " +
        "<br>individuals at one or more marker loci.");
    jLabel3.setText("IBD sharing file");
    jTextFieldPara.addMouseListener(new LODPAL1_jTextField1_mouseAdapter(this));
    jTextFieldPed.addMouseListener(new LODPAL1_jTextField2_mouseAdapter(this));
    jTextField3.setText("");
    jTextField3.addMouseListener(new LODPAL1_jTextField3_mouseAdapter(this));
    jButton3.setText("...");
    jButtonPara.addActionListener(this);
    jButtonPed.addActionListener(this);
    jButton3.setToolTipText("Lists the alleles at each marker locus.");
    jButton3.setText("...");
    jButton3.addActionListener(this);

    OutputNameField.addMouseListener(new LODPAL1_OutputNameField_mouseAdapter(this));
    OutputNameField.setToolTipText(
        "Specifies the name of the output file generated by this analysis.");
    OutputNameField.setText("lodpal");
    jNextButton.addActionListener(this);

    this.add(jLabelPara, new XYConstraints(20, 20, 111, 20));
    this.add(jLabelPed, new XYConstraints(20, 50, 111, 20));
    this.add(jLabel3, new XYConstraints(20, 80, 111, 20));
    this.add(jLabelOutputName, new XYConstraints(20, 120, 111, 20));
    this.add(jTextFieldPara,  new XYConstraints(155, 20, 280, 20));
    this.add(jTextFieldPed,    new XYConstraints(155, 50, 280, 20));
    this.add(jTextField3,    new XYConstraints(155, 80, 280, 20));
    this.add(jButtonPed,  new XYConstraints(445, 50, 30, 20));
    this.add(jButton3,  new XYConstraints(445, 80, 30, 20));
    this.add(jButtonPara,  new XYConstraints(445, 20, 30, 20));
    this.add(OutputNameField, new XYConstraints(155, 120, 280, 20));
    this.add(jNextButton, new XYConstraints(420, 520, 60, 25));

    OutputNameField.getDocument().addDocumentListener(this);
    jTextFieldPara.getDocument().addDocumentListener(this);
    jTextFieldPed.getDocument().addDocumentListener(this);
    jTextField3.getDocument().addDocumentListener(this);

  }

  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    if (ob == jButtonPara)
      jButton1_actionPerformed();
    if (ob == jButtonPed)
      jButton2_actionPerformed();
    if (ob == jButton3)
      jButton3_actionPerformed();
    if (ob == jNextButton)
      jNextButton_actionPerformed();
  }

  void jNextButton_actionPerformed() {
    MyInternalFrame mf = (MyInternalFrame) Frame1.mainFrame1.activeinframe;
    mf.jTabbedPane1.setSelectedIndex(1);
  }

  void jButton1_actionPerformed() {
    jFileChooser1.setFileFilter(ParaFilter);
    jFileChooser1.setDialogTitle("Add Parameter File");

    jFileChooser1.setCurrentDirectory(new File(Frame1.mainFrame1.path_forFileChooser));
    if (jFileChooser1.APPROVE_OPTION == jFileChooser1.showOpenDialog(this)) {
      String filepath = jFileChooser1.getSelectedFile().getPath();
      String filename = jFileChooser1.getSelectedFile().getName();
      NodeInfo filenode = new NodeInfo(filename, "Parameter File", new File(filepath));
      insertparafile(filenode);
    }
  }

  public void insertparafile(NodeInfo source) {
    File importFile = (File) source.file;
    String FilePath = importFile.getPath();
    Datamodel.setValue("para_path", FilePath);
    jTextFieldPara.setText(FilePath);
    jFileChooser1.setCurrentDirectory(importFile);
    Frame1.mainFrame1.path_forFileChooser = FilePath;

    Analysis_object.para_file_path = FilePath;

    if (Analysis_object.create_input_folder == false) {
      NodeInfo nodeinfo = new NodeInfo("Input", "InputFolder", "LODPAL", Analysis_object, "");
      IconNode node = new IconNode(nodeinfo, "InputFolder");

      inputF_node = addObject(node, analysis_node, false);
      Analysis_object.create_input_folder = true;
    }
    if (Analysis_object.create_para_file_node == false) {
      para_node = new IconNode(source, "Parameter File");

      addObject(para_node, inputF_node, false);
      Analysis_object.create_para_file_node = true;

      treeModel.nodeStructureChanged(errorF_node);

      if (errorF_node.getChildCount() < 1) {
        errorF_node.removeFromParent();

        Analysis_object.create_error_folder= false;

        treeModel.nodeStructureChanged(analysis_node);
        TreePath p = new TreePath(para_node.getPath());
        Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);
        NodeInfo n = (NodeInfo) analysis_node.getUserObject();
        LODPAL2 f2 = (LODPAL2) n.component_vector.get(1);
        f2.jRunButton.setIcon(next_image);
      }
    }
    else {
      para_node.setUserObject(source);
      TreePath p = new TreePath(para_node.getPath());
      Frame1.mainFrame1.activeinframe.MyTree1.setSelectionPath(p);
    }
    TreePath p = new TreePath(analysis_node.getPath());
    Frame1.mainFrame1.activeinframe.MyTree1.setSelectionPath(p);

    p = new TreePath(para_node.getPath());
    Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);
    Frame1.mainFrame1.activeinframe.MyTree1.Refresh();
    SetPanel2Info(source);
  }

  void SetPanel2Info(NodeInfo source) {
    NodeInfo n = (NodeInfo) analysis_node.getUserObject();
    LODPAL2 f2 = (LODPAL2) n.component_vector.get(1);

    f2.trait_dialog.jComboBox1.removeAllItems();
    f2.cov_dialog.jComboBox1.removeAllItems();

    f2.trait_dialog.jComboBox1.addItem("");
    f2.cov_dialog.jComboBox1.addItem("");

    DataCollectionModel dm = (DataCollectionModel) source.infomodel;


    int totalsize = 0;

    if (dm.hasValue("Trait_array")) {
      Vector Trait_array = (Vector) dm.getValue("Trait_array");
      int length1 = Trait_array.size();
      totalsize = totalsize + length1;
    }

    if (dm.hasValue("Covariate_array")) {
      Vector Covariate_array = (Vector) dm.getValue("Covariate_array");
      int length1 = Covariate_array.size();
      totalsize = totalsize + length1;
    }

    if (dm.hasValue("Phenotype_array")) {
      Vector Phenotype_array = (Vector) dm.getValue("Phenotype_array");
      int length2 = Phenotype_array.size();
      totalsize = totalsize + length2;
    }

    if (dm.hasValue("Trait_Farray")) {
      Vector Trait_array = (Vector) dm.getValue("Trait_Farray");
      int length1 = Trait_array.size();
      totalsize = totalsize + length1;
    }

    if (dm.hasValue("Covariate_Farray")) {
      Vector Covariate_array = (Vector) dm.getValue("Covariate_Farray");
      int length1 = Covariate_array.size();
      totalsize = totalsize + length1;
    }

    if (dm.hasValue("Phenotype_Farray")) {
      Vector Phenotype_array = (Vector) dm.getValue("Phenotype_Farray");
      int length2 = Phenotype_array.size();
      totalsize = totalsize + length2;
    }

    CheckableItem[] items = new CheckableItem[totalsize];
    int i = 0;

    if (dm.hasValue("Trait_array")) {
      Vector Trait_array = (Vector) dm.getValue("Trait_array");
      for (Enumeration e = Trait_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.trait_dialog.jComboBox1.addItem(temp);
        f2.cov_dialog.jComboBox1.addItem(temp);

        VariableData temp2 = new VariableData(temp, "trait");
        items[i] = new CheckableItem(temp2);
      }
    }

    if (dm.hasValue("Covariate_array")) {
      Vector Covariate_array = (Vector) dm.getValue("Covariate_array");
      for (Enumeration e = Covariate_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.trait_dialog.jComboBox1.addItem(temp);
        f2.cov_dialog.jComboBox1.addItem(temp);

        VariableData temp2 = new VariableData(temp, "covariate");
        items[i] = new CheckableItem(temp2);
      }
    }

    if (dm.hasValue("Phenotype_array")) {
      Vector Phenotype_array = (Vector) dm.getValue("Phenotype_array");
      for (Enumeration e = Phenotype_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.trait_dialog.jComboBox1.addItem(temp);
        f2.cov_dialog.jComboBox1.addItem(temp);

        VariableData temp2 = new VariableData(temp, "phenotype");
        items[i] = new CheckableItem(temp2);
      }
    }

    if (dm.hasValue("Trait_Farray")) {
      Vector Trait_array = (Vector) dm.getValue("Trait_Farray");
      for (Enumeration en = Trait_array.elements(); en.hasMoreElements(); i++) {
        String temp = en.nextElement().toString();
        f2.trait_dialog.jComboBox1.addItem(temp);
        f2.cov_dialog.jComboBox1.addItem(temp);

        VariableData temp2 = new VariableData(temp, "trait");
        items[i] = new CheckableItem(temp2);
      }
    }

    if (dm.hasValue("Covariate_Farray")) {
      Vector Covariate_array = (Vector) dm.getValue("Covariate_Farray");
      for (Enumeration en = Covariate_array.elements(); en.hasMoreElements(); i++) {
        String temp = en.nextElement().toString();
        f2.trait_dialog.jComboBox1.addItem(temp);
        f2.cov_dialog.jComboBox1.addItem(temp);

        VariableData temp2 = new VariableData(temp, "covariate");
        items[i] = new CheckableItem(temp2);
      }
    }

    if (dm.hasValue("Phenotype_Farray")) {
      Vector Phenotype_array = (Vector) dm.getValue("Phenotype_Farray");
      for (Enumeration en = Phenotype_array.elements(); en.hasMoreElements(); i++) {
        String temp = en.nextElement().toString();
        f2.trait_dialog.jComboBox1.addItem(temp);
        f2.cov_dialog.jComboBox1.addItem(temp);

        VariableData temp2 = new VariableData(temp, "phenotype");
        items[i] = new CheckableItem(temp2);
      }
    }
    f2.jSubsetComboBox.setData(items);
  }

  void jButton2_actionPerformed() {
    jFileChooser1.setFileFilter(FamilyFilter);
    jFileChooser1.setDialogTitle("Add Data File");

    if (jFileChooser1.APPROVE_OPTION == jFileChooser1.showOpenDialog(this)) {
      String filepath = jFileChooser1.getSelectedFile().getPath();
      String filename = jFileChooser1.getSelectedFile().getName();
      NodeInfo filenode = new NodeInfo(filename, "Pedigree File", new File(filepath));
      insertpedigreefile(filenode);
    }
  }

  public void insertpedigreefile(NodeInfo source) {
    File importFile = (File) source.file;
    String FilePath = importFile.getPath();
    Datamodel.setValue("pedi_path", FilePath);
    jTextFieldPed.setText(FilePath);
    jFileChooser1.setCurrentDirectory(importFile);
    Frame1.mainFrame1.path_forFileChooser = FilePath;

    Analysis_object.family_file_path = FilePath;

    if (Analysis_object.create_input_folder == false) {
      NodeInfo nodeinfo = new NodeInfo("Input", "InputFolder", "LODPAL",
                                       Analysis_object, "");
      IconNode node = new IconNode(nodeinfo, "InputFolder");

      inputF_node = addObject(node, analysis_node, false);
      Analysis_object.create_input_folder = true;
    }
    if (Analysis_object.create_family_file_node == false) {
      pedi_node = new IconNode(source, "Pedigree File");

      addObject(pedi_node, inputF_node, false);
      Analysis_object.create_family_file_node = true;

      errorpedigree_node.removeFromParent();
      treeModel.nodeStructureChanged(errorF_node);

      if (errorF_node.getChildCount() < 1) {
        errorF_node.removeFromParent();

        Analysis_object.create_error_folder= false;

        treeModel.nodeStructureChanged(analysis_node);
        TreePath p = new TreePath(pedi_node.getPath());
        Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);
        NodeInfo n = (NodeInfo) analysis_node.getUserObject();
        LODPAL2 f2 = (LODPAL2) n.component_vector.get(1);
        f2.jRunButton.setIcon(next_image);
      }
    }
    else {
      pedi_node.setUserObject(source);
      TreePath p = new TreePath(pedi_node.getPath());
      Frame1.mainFrame1.activeinframe.MyTree1.setSelectionPath(p);
    }

    TreePath p = new TreePath(analysis_node.getPath());
    Frame1.mainFrame1.activeinframe.MyTree1.setSelectionPath(p);
    Frame1.mainFrame1.activeinframe.MyTree1.Refresh();

    SetCovariateList(source);
  }

  void SetCovariateList(NodeInfo source)
 {
     NodeInfo n = (NodeInfo) analysis_node.getUserObject();
     LODPAL2 f2 = (LODPAL2) n.component_vector.get(1);

     NodeInfo para = (NodeInfo)para_node.getUserObject();
     DataCollectionModel dm = (DataCollectionModel) para.infomodel;

     try {
         ArrayList list = GetCovariateList(dm, (File) source.file, true);

         CheckableItem[] list_model = f2.jSubsetComboBox.ListData;
         int original_size = list_model.length;

         if (list.size()>0)
         {
             int list_size = list.size();
             CheckableItem[] total_items = new CheckableItem[list_size+original_size];

             for (int i = 0; i<original_size; i++)
             {
                 String temp = list_model[i].toString();
                 VariableData temp2 = new VariableData(temp, "covariate");
                 total_items[i] = new CheckableItem(temp2);
             }

             for (int i = 0; i<list_size; i++)
             {
                 String temp = list.get(i).toString();
                 VariableData temp2 = new VariableData(temp, "covariate");
                 total_items[i+original_size] = new CheckableItem(temp2);

                 f2.trait_dialog.jComboBox1.addItem(temp);
                 f2.cov_dialog.jComboBox1.addItem(temp);

             }
             f2.jSubsetComboBox.setData(total_items);
         }
     } catch (Exception exe) {
         exe.printStackTrace();
     }
 }

  void jButton3_actionPerformed() {
    jFileChooser1.setFileFilter(IBDFilter);
    jFileChooser1.setDialogTitle("Add IBD File");

    if (jFileChooser1.APPROVE_OPTION == jFileChooser1.showOpenDialog(this)) {
      String filepath = jFileChooser1.getSelectedFile().getPath();
      String filename = jFileChooser1.getSelectedFile().getName();
      NodeInfo filenode = new NodeInfo(filename, "IBD Sharing File", new File(filepath));
      insertibdfile(filenode);
    }
  }

  public void insertibdfile(NodeInfo source) {
    File importFile = (File) source.file;
    String FilePath = importFile.getPath();
    Datamodel.setValue("ibd_path", FilePath);
    jTextField3.setText(FilePath);
    jFileChooser1.setCurrentDirectory(importFile);
    Frame1.mainFrame1.path_forFileChooser = FilePath;

    Analysis_object.ibd_file_path = FilePath;

    if (Analysis_object.create_input_folder == false) {
      NodeInfo nodeinfo = new NodeInfo("Input", "InputFolder", "LODPAL",
                                       Analysis_object, "");
      IconNode node = new IconNode(nodeinfo, "InputFolder");

      inputF_node = addObject(node, analysis_node, false);
      Analysis_object.create_input_folder = true;
    }
    if (Analysis_object.create_locus_file_node == false) {
      ibd_node = new IconNode(source, "IBD Sharing File");

      addObject(ibd_node, inputF_node, false);
      Analysis_object.create_locus_file_node = true;

      errorlocus_node.removeFromParent();
      treeModel.nodeStructureChanged(errorF_node);

      if (errorF_node.getChildCount() < 1) {
        Analysis_object.create_error_folder= false;

        errorF_node.removeFromParent();

        treeModel.nodeStructureChanged(analysis_node);
        TreePath p = new TreePath(ibd_node.getPath());
        Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);
        NodeInfo n = (NodeInfo) analysis_node.getUserObject();
        LODPAL2 f2 = (LODPAL2) n.component_vector.get(1);
        f2.jRunButton.setIcon(next_image);
      }
    }
    else {
      ibd_node.setUserObject(source);
      TreePath p = new TreePath(ibd_node.getPath());
      Frame1.mainFrame1.activeinframe.MyTree1.setSelectionPath(p);
    }

    TreePath p = new TreePath(analysis_node.getPath());
    Frame1.mainFrame1.activeinframe.MyTree1.setSelectionPath(p);
    Frame1.mainFrame1.activeinframe.MyTree1.Refresh();
    SetLODPAL2MarkerInfo(source); // set marker information
  }

  void SetLODPAL2MarkerInfo(NodeInfo source) {
    NodeInfo n = (NodeInfo) analysis_node.getUserObject();
    LODPAL2 f2 = (LODPAL2) n.component_vector.get(1);

    if (source.infomodel == null) {
      FavoritesPanel.Parse_IBD_File(source);
    }

    DataCollectionModel dm = (DataCollectionModel) source.infomodel;

    String para_list = null;
    CheckableItem[] para_lm = null;
    String diagno=null;

      if(f2.jMarkerComboBox.getSelectedItem()!=null)
      {
        para_list = f2.jMarkerComboBox.getSelectedItem().toString();
        para_lm = f2.jMarkerComboBox.ListData;
      }
      if(f2.jComboBox6.getItemCount()>0)
        diagno = f2.jComboBox6.getSelectedItem().toString();

    f2.jComboBox6.removeAllItems();
    f2.jComboBox6.addItem("");

    if (dm.hasValue("Marker_List")) {
      Vector v = (Vector) dm.getValue("Marker_List");
      int length = v.size();
      CheckableItem[] items = new CheckableItem[length];
      int i = 0;
      String list=new String();
      for (Enumeration e = v.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        VariableData temp2 = new VariableData(temp, "marker");
        items[i] = new CheckableItem(temp2);
        if(para_list == null || para_lm == null)
        {
          f2.jComboBox6.addItem(temp);
        }
        else
        {
          f2.jComboBox6.addItem(temp);
          StringTokenizer st = new StringTokenizer(para_list, ",");
          while (st.hasMoreTokens()) {
            String checkitem = st.nextElement().toString().trim();
            if (items[i].toString().compareTo(checkitem) == 0)
            {
              items[i].setSelected(true);
              list = list + ", " + items[i];
            }
          }
        }
      }
      list = list.replaceFirst(",","");
      list = list.trim();
      f2.jMarkerComboBox.setData(items);
      f2.jMarkerComboBox.setSelectedItem(list);

      if(diagno!=null)
      {
        for(int di=0;di<f2.jComboBox6.getItemCount();di++)
        {
          String temp = f2.jComboBox6.getItemAt(di).toString();
          if(temp.compareTo(diagno)==0)
            f2.jComboBox6.setSelectedItem(temp);
        }
      }
    }
  }

  public void changedUpdate(DocumentEvent event) {
    Document document = event.getDocument();
    if (document == jTextFieldPara.getDocument()) {
      Datamodel.setValue("para_path", jTextFieldPara.getText());
    }
    if (document == jTextFieldPed.getDocument()) {
        if(jTextFieldPed.getText().length()>0)
        {
            Datamodel.setValue("pedi_path", jTextFieldPed.getText());
        }
        else
        {
            if(Datamodel.hasValue("pedi_path"))
            {
                Datamodel.removeValue("pedi_path");
            }
        }
    }
    if (document == jTextField3.getDocument()) {
      if(jTextField3.getText().length()>0)
      {
          Datamodel.setValue("ibd_path", jTextField3.getText());
      }
      else
      {
          if(Datamodel.hasValue("ibd_path"))
              Datamodel.removeValue("ibd_path");
      }

    }
    if (document == OutputNameField.getDocument()) {
      Datamodel.setValue("output_name", OutputNameField.getText());
    }

    if (Datamodel.hasValue("para_path") && Datamodel.hasValue("pedi_path")
        && Datamodel.hasValue("output_name") && Datamodel.hasValue("ibd_path")) {
      jNextButton.setIcon(next_image);
    }
  }

  public void insertUpdate(DocumentEvent event) {
    changedUpdate(event);
  }

  public void removeUpdate(DocumentEvent event) {
    changedUpdate(event);
  }

  void detelePedNode()
  {
      if(errorpedigree_node != null && errorF_node != null)
                {
                    addObject(errorpedigree_node, errorF_node, false);

                    if(!Analysis_object.create_error_folder)
                    {
                        treeModel.insertNodeInto(errorF_node, analysis_node, 0);
                        Analysis_object.create_error_folder = true;
                    }

                    Analysis_object.create_family_file_node = false;
                    TreePath p = new TreePath(errorpedigree_node.getPath());
                    Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);
            }
  }

  void deteleIbdNode()
  {
    if(errorlocus_node != null && errorF_node != null)
    {
        addObject(errorlocus_node, errorF_node, false);
        if(!Analysis_object.create_error_folder)
        {
            treeModel.insertNodeInto(errorF_node, analysis_node, 0);
            Analysis_object.create_error_folder = true;
        }
        Analysis_object.create_locus_file_node = false;
        TreePath p = new TreePath(errorlocus_node.getPath());
        Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);
    }
  }

  void jTextField1_mouseClicked(MouseEvent e) {
      Frame1.mainFrame1.pdfframe.setTextonPage("lodpal parameter fil", false, 272);
  }

  void jTextField2_mouseClicked(MouseEvent e) {
      Frame1.mainFrame1.pdfframe.setTextonPage("pedigree data fil", false, 272);
  }

  void jTextField3_mouseClicked(MouseEvent e) {
      Frame1.mainFrame1.pdfframe.setTextonPage("ibd sharing fil", false, 272);
  }

  void OutputNameField_mouseClicked(MouseEvent e) {
      Frame1.mainFrame1.pdfframe.setTextonPage("out ", false, 273);
  }

}

class LODPAL1_jTextField1_mouseAdapter
    extends java.awt.event.MouseAdapter {
  LODPAL1 adaptee;

  LODPAL1_jTextField1_mouseAdapter(LODPAL1 adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.jTextField1_mouseClicked(e);
  }
}

class LODPAL1_jTextField2_mouseAdapter
    extends java.awt.event.MouseAdapter {
  LODPAL1 adaptee;

  LODPAL1_jTextField2_mouseAdapter(LODPAL1 adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.jTextField2_mouseClicked(e);
  }
}

class LODPAL1_jTextField3_mouseAdapter
    extends java.awt.event.MouseAdapter {
  LODPAL1 adaptee;

  LODPAL1_jTextField3_mouseAdapter(LODPAL1 adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.jTextField3_mouseClicked(e);
  }
}

class LODPAL1_OutputNameField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  LODPAL1 adaptee;

  LODPAL1_OutputNameField_mouseAdapter(LODPAL1 adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.OutputNameField_mouseClicked(e);
  }
}
