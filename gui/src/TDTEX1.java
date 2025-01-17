package sage;

import java.awt.Insets;
import com.borland.jbcl.layout.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.text.Document;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;
import java.util.*;

public class TDTEX1
    extends SageFilePanel
    implements DocumentListener, ActionListener {
  IconNode analysis_node;
  IconNode errorF_node;
  IconNode errorpedigree_node;
  IconNode pedi_node;

  XYLayout xYLayout1 = new XYLayout();

  public TDTEX1(sage_analysis_info data, IconNode inputnode, IconNode errornode) {
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
    Datamodel.setValue("output_name", OutputNameField.getText());
  }

  void jbInit() throws Exception {
     NodeInfo outputfolder = new NodeInfo("Output", "OutputFolder", "TDTEX",
                                         Analysis_object, "");
    outputF_node = new IconNode(outputfolder, "OutputFolder");
    this.setLayout(xYLayout1);
    xYLayout1.setWidth(500);
    xYLayout1.setHeight(560);
    jTextFieldPara.addMouseListener(new TDTEX1_jTextField1_mouseAdapter(this));
    jTextFieldPed.addMouseListener(new TDTEX1_jTextField2_mouseAdapter(this));
    jButtonPara.addActionListener(this);
    jButtonPed.addActionListener(this);

    OutputNameField.addMouseListener(new TDTEX1_OutputNameField_mouseAdapter(this));
    OutputNameField.setToolTipText(
        "Specifies the name of the output file generated by this analysis.");
    OutputNameField.setText("tdtex");
    Datamodel.setValue("output_name", "pedinfo");

    jNextButton.setHorizontalTextPosition(SwingConstants.LEFT);
    jNextButton.setIcon(error_image);
    jNextButton.setMargin(new Insets(2, 2, 2, 2));
    jNextButton.setText("Next");
    jNextButton.addActionListener(this);

    this.add(jLabelPara, new XYConstraints(20, 20, 142, 20));
    this.add(jLabelPed, new XYConstraints(20, 50, 116, 20));
    this.add(jLabelOutputName, new XYConstraints(20, 90, 109, 20));
    this.add(jTextFieldPara,  new XYConstraints(155, 20, 280, 20));
    this.add(jTextFieldPed,  new XYConstraints(155, 50, 280, 20));
    this.add(jButtonPed,  new XYConstraints(445, 50, 30, 20));
    this.add(jButtonPara,  new XYConstraints(445, 20, 30, 20));
    this.add(OutputNameField, new XYConstraints(155, 90, 280, 20));
    this.add(jNextButton, new XYConstraints(420, 520, 60, 25));

    jTextFieldPara.getDocument().addDocumentListener(this);
    jTextFieldPed.getDocument().addDocumentListener(this);
    OutputNameField.getDocument().addDocumentListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    if (ob == jButtonPara)
      jButton1_actionPerformed();
    else if (ob == jButtonPed)
      jButton2_actionPerformed();
    else if (ob == jNextButton)
      jNextButton_actionPerformed();
  }

  void jNextButton_actionPerformed() {
    MyInternalFrame mf = (MyInternalFrame) Frame1.mainFrame1.activeinframe;
    mf.jTabbedPane1.setSelectedIndex(1);
  }

  void jButton1_actionPerformed() {
    jFileChooser1.setCurrentDirectory(new File(Frame1.mainFrame1.path_forFileChooser));
    jFileChooser1.setFileFilter(ParaFilter);
    jFileChooser1.setDialogTitle("Add Parameter File");

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

    jFileChooser1.setCurrentDirectory(importFile);
    Frame1.mainFrame1.path_forFileChooser = FilePath;

    jTextFieldPara.setText(FilePath);

    Analysis_object.para_file_path = FilePath;
    Analysis_object.input_file.add(FilePath);

    if (Analysis_object.create_input_folder == false) {
      NodeInfo nodeinfo = new NodeInfo("Input", "InputFolder", "TDTEX",
                                       Analysis_object, "");
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
          Analysis_object.create_error_folder= false;
        errorF_node.removeFromParent();
        treeModel.nodeStructureChanged(analysis_node);
        TreePath p = new TreePath(para_node.getPath());
        Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);

        NodeInfo n = (NodeInfo) analysis_node.getUserObject();
        TDTEX2 f2 = (TDTEX2) n.component_vector.get(1);
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
    TDTEX2 f2 = (TDTEX2) n.component_vector.get(1);

    f2.jComboBox9.removeAllItems();
    f2.jComboBox10.removeAllItems();

    f2.jComboBox9.addItem("");
    f2.jComboBox10.addItem("");

    DataCollectionModel dm = (DataCollectionModel) source.infomodel;

    if (dm.hasValue("Marker_array") || dm.hasValue("Allele_array"))
    {
      int length1=0;
      int length2=0;

      Vector total_array = new Vector();
      if (dm.hasValue("Marker_array")) {
        Vector Marker_array = (Vector) dm.getValue("Marker_array");
        length1 = Marker_array.size();
        for (Enumeration e = Marker_array.elements(); e.hasMoreElements();) {
          String temp = e.nextElement().toString();
          total_array.add(temp);
        }
      }

      if(dm.hasValue("Allele_array"))
      {
        Vector Allele_array = (Vector) dm.getValue("Allele_array");

        length2 = Allele_array.size();
        for (Enumeration e = Allele_array.elements(); e.hasMoreElements(); ) {
          String temp = e.nextElement().toString();
          total_array.add(temp);
        }
      }

      int total_length = length1 + length2;

      CheckableItem[] total_items = new CheckableItem[total_length];
      int i=0;
      for (Enumeration e = total_array.elements(); e.hasMoreElements();i++) {
        String temp = e.nextElement().toString();
        VariableData temp2 = new VariableData(temp, "marker");
        total_items[i] = new CheckableItem(temp2);
      }

      f2.jMarkerComboBox.setData(total_items);
    }

    if (dm.hasValue("Trait_array")) {
      Vector Trait_array = (Vector) dm.getValue("Trait_array");
      int i = 0;
      for (Enumeration e = Trait_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.jComboBox9.addItem(temp);
        f2.jComboBox10.addItem(temp);
      }
    }

    if (dm.hasValue("Covariate_array")) {
      Vector Covariate_array = (Vector) dm.getValue("Covariate_array");
      int i = 0;
      for (Enumeration e = Covariate_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.jComboBox9.addItem(temp);
        f2.jComboBox10.addItem(temp);
      }
    }

    if (dm.hasValue("Phenotype_array")) {
      Vector Phenotype_array = (Vector) dm.getValue("Phenotype_array");
      int i = 0;
      for (Enumeration e = Phenotype_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.jComboBox9.addItem(temp);
        f2.jComboBox10.addItem(temp);
      }
    }

    if (dm.hasValue("Trait_Farray")) {
      Vector Trait_array = (Vector) dm.getValue("Trait_Farray");
      int i = 0;
      for (Enumeration e = Trait_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.jComboBox9.addItem(temp);
        f2.jComboBox10.addItem(temp);
      }
    }

    if (dm.hasValue("Covariate_Farray")) {
      Vector Covariate_array = (Vector) dm.getValue("Covariate_Farray");
      int i = 0;
      for (Enumeration e = Covariate_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.jComboBox9.addItem(temp);
        f2.jComboBox10.addItem(temp);
      }
    }

    if (dm.hasValue("Phenotype_Farray")) {
      Vector Phenotype_array = (Vector) dm.getValue("Phenotype_Farray");
      int i = 0;
      for (Enumeration e = Phenotype_array.elements(); e.hasMoreElements(); i++) {
        String temp = e.nextElement().toString();
        f2.jComboBox9.addItem(temp);
        f2.jComboBox10.addItem(temp);
      }
    }

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
    Analysis_object.input_file.add(FilePath);

    if (Analysis_object.create_input_folder == false) {
      NodeInfo nodeinfo = new NodeInfo("Input", "InputFolder", "TDTEX",
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
          Analysis_object.create_error_folder= false;
        errorF_node.removeFromParent();
        treeModel.nodeStructureChanged(analysis_node);
        TreePath p = new TreePath(pedi_node.getPath());
        Frame1.mainFrame1.activeinframe.MyTree1.scrollPathToVisible(p);

        NodeInfo n = (NodeInfo) analysis_node.getUserObject();
        TDTEX2 f2 = (TDTEX2) n.component_vector.get(1);
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

    SetMarkerList(source);
    SetCovariateList(source);
  }


  void SetCovariateList(NodeInfo source)
  {
      NodeInfo n = (NodeInfo) analysis_node.getUserObject();
      TDTEX2 f2 = (TDTEX2) n.component_vector.get(1);

      NodeInfo para = (NodeInfo)para_node.getUserObject();
      DataCollectionModel dm = (DataCollectionModel) para.infomodel;

      try {
          ArrayList list = GetCovariateList(dm, (File) source.file, true);
          int list_size = list.size();

          if (list.size()>0)
          {
              for (int i = 0; i<list_size; i++)
              {
                  String temp = list.get(i).toString();
                  f2.jComboBox9.addItem(temp);
                  f2.jComboBox10.addItem(temp);
              }
          }

      } catch (Exception exe) {
          exe.printStackTrace();
      }
  }
  void SetMarkerList(NodeInfo source)
  {
      NodeInfo n = (NodeInfo) analysis_node.getUserObject();
      TDTEX2 f2 = (TDTEX2) n.component_vector.get(1);

      NodeInfo para = (NodeInfo)para_node.getUserObject();
      DataCollectionModel dm = (DataCollectionModel) para.infomodel;

      try {
          ArrayList list = GetMarkerList(dm, (File) source.file, true);

          CheckableItem[] list_model = f2.jMarkerComboBox.ListData;
          int original_size = list_model.length;

          if (list.size()>0)
          {
              int list_size = list.size();
              CheckableItem[] total_items = new CheckableItem[list_size+original_size];

              for (int i = 0; i<original_size; i++)
              {
                  String temp = list_model[i].toString();
                  VariableData temp2 = new VariableData(temp, "marker");
                  total_items[i] = new CheckableItem(temp2);
              }

              for (int i = 0; i<list_size; i++)
              {
                  String temp = list.get(i).toString();
                  VariableData temp2 = new VariableData(temp, "marker");
                  total_items[i+original_size] = new CheckableItem(temp2);
              }
              f2.jMarkerComboBox.setData(total_items);
          }
      } catch (Exception exe) {
          exe.printStackTrace();
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
                Datamodel.removeValue("pedi_path");
        }
    }
    if (document == OutputNameField.getDocument()) {
      Datamodel.setValue("output_name", OutputNameField.getText());
    }

    if (Datamodel.hasValue("para_path") && Datamodel.hasValue("pedi_path") &&
        Datamodel.hasValue("output_name")) {
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

  void jTextField1_mouseClicked(MouseEvent e) {
      Frame1.mainFrame1.pdfframe.setTextonPage("parameter fil", false, 365);
  }

  void jTextField2_mouseClicked(MouseEvent e) {
      Frame1.mainFrame1.pdfframe.setTextonPage("pedigree data fil", false, 365);
  }

  void OutputNameField_mouseClicked(MouseEvent e) {
      Frame1.mainFrame1.pdfframe.setTextonPage("out ", false, 366);
  }

}

class TDTEX1_jTextField1_mouseAdapter
    extends java.awt.event.MouseAdapter {
  TDTEX1 adaptee;

  TDTEX1_jTextField1_mouseAdapter(TDTEX1 adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.jTextField1_mouseClicked(e);
  }
}

class TDTEX1_jTextField2_mouseAdapter
    extends java.awt.event.MouseAdapter {
  TDTEX1 adaptee;

  TDTEX1_jTextField2_mouseAdapter(TDTEX1 adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.jTextField2_mouseClicked(e);
  }
}

class TDTEX1_OutputNameField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  TDTEX1 adaptee;

  TDTEX1_OutputNameField_mouseAdapter(TDTEX1 adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.OutputNameField_mouseClicked(e);
  }
}
