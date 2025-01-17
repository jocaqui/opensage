package snpclip;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.io.FileWriter;
/*
 * LocationDialog.java
 *
 * Created on July 17, 2008, 1:19 PM
 */

/**
 *
 * @author  suna
 */
public class LocationDialog extends javax.swing.JDialog {

    java.awt.Frame mainFrame;

    /** Creates new form LocationDialog */
    public LocationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        mainFrame = parent;
        this.setTitle("Location Dialog");
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        DataPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RegionList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        RegionLabel = new javax.swing.JLabel();
        MarkerLabel = new javax.swing.JLabel();
        PositionLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MarkerList = new javax.swing.JList();
        CriteriaPanel = new javax.swing.JPanel();
        IncludeRadioButton = new javax.swing.JRadioButton();
        ExcludeRadioButton = new javax.swing.JRadioButton();
        ApplyCheckBox = new javax.swing.JCheckBox();
        ApplyTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        MinLabel = new javax.swing.JLabel();
        MinTextField = new javax.swing.JTextField();
        MaxLabel = new javax.swing.JLabel();
        MaxTextField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        FilePathLabel = new javax.swing.JLabel();
        FilePathTextField = new javax.swing.JTextField();
        FileOpenButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));

        RegionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                RegionListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(RegionList);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 157, 185)));

        RegionLabel.setText("Region");
        RegionLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        MarkerLabel.setText("Marker");
        MarkerLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        PositionLabel.setText("Absolute position");
        PositionLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(RegionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MarkerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PositionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegionLabel)
                    .addComponent(MarkerLabel)
                    .addComponent(PositionLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

/*        MarkerList.setModel(new javax.swing.AbstractListModel() {
            String[][] strings = { {"1m1 5", "Item 2"}, {"Item 3", "Item 4"}, "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });*/


MarkerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
    public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        MarkerListtValueChanged(evt);
    }
        });
        jScrollPane2.setViewportView(MarkerList);

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DataPanelLayout.setVerticalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap())
        );

        CriteriaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Criteria"));

        IncludeRadioButton.setText("Include");
        IncludeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncludeRadioButtonActionPerformed(evt);
            }
        });
        IncludeRadioButton.setSelected(true);

        ExcludeRadioButton.setText("Exclude");

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(IncludeRadioButton);
        bg1.add(ExcludeRadioButton);

        ApplyCheckBox.setSelected(true);
        ApplyCheckBox.setText("Apply to next");

        jLabel6.setText("region(s)");

        MinLabel.setText("Start position");

        MaxLabel.setText("End position");

        javax.swing.GroupLayout CriteriaPanelLayout = new javax.swing.GroupLayout(CriteriaPanel);
        CriteriaPanel.setLayout(CriteriaPanelLayout);
        CriteriaPanelLayout.setHorizontalGroup(
            CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriteriaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ApplyCheckBox)
                    .addComponent(ExcludeRadioButton)
                    .addComponent(IncludeRadioButton)
                    .addGroup(CriteriaPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(ApplyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(CriteriaPanelLayout.createSequentialGroup()
                        .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MinLabel)
                            .addComponent(MaxLabel))
                        .addGap(24, 24, 24)
                        .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MaxTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(MinTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                .addContainerGap())
        );
        CriteriaPanelLayout.setVerticalGroup(
            CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriteriaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaxLabel)
                    .addComponent(MaxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(IncludeRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExcludeRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ApplyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(ApplyCheckBox))
                .addContainerGap())
        );

        OKButton.setText("OK");
        OKButton.setMaximumSize(new java.awt.Dimension(45, 23));
        OKButton.setMinimumSize(new java.awt.Dimension(45, 23));
        OKButton.setPreferredSize(new java.awt.Dimension(45, 23));
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.setMaximumSize(new java.awt.Dimension(45, 23));
        CancelButton.setMinimumSize(new java.awt.Dimension(45, 23));
        CancelButton.setPreferredSize(new java.awt.Dimension(45, 23));

        FilePathLabel.setText("Genome File Path");

        FileOpenButton.setText("...");
        FileOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileOpenButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CriteriaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(FilePathLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FilePathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FileOpenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilePathLabel)
                    .addComponent(FileOpenButton)
                    .addComponent(FilePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CriteriaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void IncludeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
}

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
}

    private void FileOpenButtonActionPerformed() {
        String init_dit = new String();
        String os_type = System.getProperty("os.name");
        if (os_type.indexOf("Windows") >= 0) {
            init_dit = System.getProperty("user.dir") + System.getProperty("file.separator");
        }
        else {
            init_dit = System.getProperty("user.home") + System.getProperty("file.separator");
        }
        JFileChooser jFileChooser1 = new JFileChooser();
        jFileChooser1.setCurrentDirectory(new File(init_dit));

        if (jFileChooser1.APPROVE_OPTION == jFileChooser1.showOpenDialog(this)) {

            GenomeFilePath = jFileChooser1.getSelectedFile().getPath();
            FilePathTextField.setText(GenomeFilePath);

            try {

                GenomeFileDialog fid = new GenomeFileDialog(mainFrame, "Map File Information", true);

                fid.setFilePath(GenomeFilePath);
                fid.SageRButton1ActionPerformed();
                fid.ParseFile();
                fid.setLocationRelativeTo(this);
                fid.setVisible(true);

                String delimiter = fid.getDELIMITER();

                int mp = fid.getMarkerColumn();
                int pp = fid.getPositionColumn();
                int py = fid.getPositionType();

                if (fid.returnStatus == 1) {

                    switch(fid.getFileType())
                    {
                    case 0: //SAGE Map file
                        GenomeFileParser(GenomeFilePath);
                        break;
                    case 1: //RAW DATA File
                        String temppath = CreateSageMapFile(delimiter, mp, pp, py);
                        GenomeFileParser(temppath);
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String CreateSageMapFile(String FILE_DELIMITER, int marker_col, int position_col, int position_type) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(GenomeFilePath));

        String currentLine = new String();
        String nextLine = new String();
        String[] cl = null;
        String[] nl = null;

        File tempgenome = File.createTempFile("tempmap", "txt", new File(System.getProperty("user.dir")));
        FileWriter fos = new FileWriter(tempgenome);

        fos.write("Genome = temp");
        fos.write("\n");
        fos.write("{");
        fos.write("\n");

        String markerName="";
        String position1 = "";
        String position2 = "";
        String distance;

        switch(position_type)
        {
           case 0: // Position

               fos.write("marker = "+"\""+"p-ter"+"\""+"\n");

               int count=0;
               currentLine = br.readLine();

               while ((nextLine = br.readLine()) != null && nextLine.trim().length() > 0) {

                   cl = currentLine.split(FILE_DELIMITER);
                   nl = nextLine.split(FILE_DELIMITER);

                   markerName = cl[marker_col-1];

                   position1 = cl[position_col-1];
                   position2 = nl[position_col-1];

                   double distance1 = Double.parseDouble(position1);
                   double distance2 = Double.parseDouble(position2);

                   double result = distance2 - distance1;
                   if(result == 0.0)
                     result = 0.0001;

                   distance = Double.toString(result);

                   if(count==0)
                   {
                       fos.write("distance = "+ "\""+position1+ "\""+"\n");
                   }

                   fos.write("marker = "+"\""+markerName+"\""+"\n");
                   fos.write("distance = "+ "\""+distance+ "\""+"\n");

                   currentLine = nextLine;
                   count++;
               }

               fos.write("marker = "+"\""+nl[marker_col-1]+"\""+"\n");
               fos.write("}");
               fos.close();
               break;

           case 1:
           case 2:
               currentLine = br.readLine();
               while ((nextLine = br.readLine()) != null && nextLine.trim().length() > 0) {

                   cl = currentLine.split(FILE_DELIMITER);
                   nl = nextLine.split(FILE_DELIMITER);

                   markerName = cl[marker_col-1];

                   position1 = cl[position_col-1];

                   fos.write("marker = "+"\""+markerName+"\""+"\n");
                   fos.write("distance = "+ "\""+position1+ "\""+"\n");

                   currentLine = nextLine;
               }
               fos.write("marker = "+"\""+nl[marker_col-1]+"\""+"\n");
               fos.write("}");
               fos.close();


               break;
            }


        return "";
    }

    private Vector GenomeFileParser(String filePath) throws Exception
    {
        //BufferedReader in = new BufferedReader(new FileReader(filePath));

        //System.out.println(filePath);


        String strFileLine = "";
        Vector Region_array = new Vector();

        Region_array.add("chrom#1");
        Region_array.add("chrom#2");

        Vector each = new Vector();
        each.add("1m1 5");
        each.add("0.00001");
        Marker_array1.add("1m1 5\t\t0.00001");
        Vector each1 = new Vector();
        each1.add("1m2 4");
        each1.add("0.189974");
        Marker_array1.add("1m2 4\t\t0.189974");

        Vector each2 = new Vector();
        each2.add("1m3 10");
        each2.add("0.362722");
        Marker_array1.add("1m3 10\t\t0.362722");
        Vector each3 = new Vector();
        each3.add("1m4 6");
        each3.add("0.499175");
        Marker_array1.add("1m4 6\t\t0.499175");
        Vector each4= new Vector();
        each4.add("1m5 3");
        each4.add("0.683928");
        Marker_array1.add("1m5 3\t\t0.683928");

        MarkerList.setListData(Marker_array1);

        return Region_array;

    }

    private void RegionListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // TODO add your handling code here:
        int index = RegionList.getSelectedIndex();
        if(index == 0)
        {
            MarkerList.setListData(Marker_array1);
        }
        else
        {
            MarkerList.setListData(Marker_array2);
        }
    }

    private void MarkerListtValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
        int index = MarkerList.getSelectedIndex();

        if(MarkerList.getSelectedValue()!=null)
        {
            if(index <5)
            {
                String in = MarkerList.getSelectedValue().toString();
                 StringTokenizer st = new StringTokenizer(in, "\t");
                 st.nextToken();
                 MinTextField.setText(st.nextToken());
            }
            else
            {
//            Vector in = (Vector)MarkerList.getSelectedValue();
                String in = MarkerList.getSelectedValue().toString();
                 StringTokenizer st = new StringTokenizer(in, "\t");
                 st.nextToken();

                MaxTextField.setText(st.nextToken());
            }
        }
    }


    class ListData
    {
      protected String MarkerName;
      protected String Distance;

      public ListData(String name, String dis)
      {
        MarkerName = name;
        Distance = dis;
      }

      public String getName()
      {
        return MarkerName;
      }

      public String toString()
      {
        return MarkerName + Distance;
      }
  }
    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LocationDialog dialog = new LocationDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify
    private javax.swing.JCheckBox ApplyCheckBox;
    private javax.swing.JTextField ApplyTextField;
    private javax.swing.JButton CancelButton;
    private javax.swing.JPanel CriteriaPanel;
    private javax.swing.JPanel DataPanel;
    public javax.swing.JRadioButton ExcludeRadioButton;
    private javax.swing.JButton FileOpenButton;
    private javax.swing.JLabel FilePathLabel;
    private javax.swing.JTextField FilePathTextField;
    public javax.swing.JRadioButton IncludeRadioButton;
    private javax.swing.JLabel MarkerLabel;
    private javax.swing.JList MarkerList;
    private javax.swing.JLabel MaxLabel;
    public javax.swing.JTextField MaxTextField;
    private javax.swing.JLabel MinLabel;
    public javax.swing.JTextField MinTextField;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel PositionLabel;
    private javax.swing.JLabel RegionLabel;
    private javax.swing.JList RegionList;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration

    private String GenomeFilePath;
    Vector Marker_array1 = new Vector();
    Vector Marker_array2 = new Vector();


}
