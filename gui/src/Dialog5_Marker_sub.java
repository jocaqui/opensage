package sage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.borland.jbcl.layout.*;
import java.awt.event.*;

public class Dialog5_Marker_sub extends JDialog implements ActionListener{
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jTopPanel = new JPanel();
  JPanel jCenterPanel = new JPanel();
  JPanel jBottomPanel = new JPanel();
  EdgeBorder lineborder = new EdgeBorder();
  XYLayout xYLayout1 = new XYLayout();
  JButton jButton1 = new JButton();
  XYLayout xYLayout3 = new XYLayout();

  TitledBorder titledBorder1;
  DataCollectionModel Datamodel;

  ButtonGroup bg = new ButtonGroup();
  JLabel jLabel3 = new JLabel();

  JButton jButton2 = new JButton();
  JRadioButton jRadioButton1 = new JRadioButton();
  JRadioButton jRadioButton2 = new JRadioButton();
  BorderLayout borderLayout2 = new BorderLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();

  boolean ok_clicked = false;

  public Dialog5_Marker_sub(Frame frame, String title, boolean modal) {
      super(frame, title, modal);
      try {
          jbInit();
          pack();
      }
      catch(Exception ex) {
          ex.printStackTrace();
      }
  }

  public Dialog5_Marker_sub() {
      this(null, "", false);
  }


  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");

    panel1.setLayout(borderLayout1);
    this.setSize(new Dimension(330, 260));
    this.setResizable(false);

    jRadioButton1.setFocusPainted(false);
    jRadioButton2.setFocusPainted(false);

      jTopPanel.setPreferredSize(new Dimension(330, 40));
      jTopPanel.setLayout(borderLayout2);
      jTopPanel.setBackground(Color.white);
      jCenterPanel.setLayout(xYLayout1);
      jCenterPanel.setPreferredSize(new Dimension(330,180));
      jCenterPanel.setBorder(lineborder);
      jBottomPanel.setBorder(lineborder);
      jBottomPanel.setPreferredSize(new Dimension(330, 40));
      jBottomPanel.setLayout(xYLayout3);

      jButton1.setText("OK");
      jButton1.addActionListener(this);
      jButton2.addActionListener(this);
      jLabel3.setBorder(new EmptyBorder(0,15,0,0));
    jLabel3.setText("What is the type of information in this column?");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.setText("Cancel");
    jRadioButton1.setSelected(true);
    jRadioButton1.setText("Codominant marker");
    jRadioButton2.setText("Noncodominant marker");
    jLabel1.setIcon(new ImageIcon(Dialog5_Marker_sub.class.getResource("required_marker.png")));
    jLabel1.setText("If you choose non codominant, a locus description file");
    jLabel2.setText("must be used with all programs that read marker data.");
    getContentPane().add(panel1);
      panel1.add(jTopPanel,  BorderLayout.NORTH);
    jTopPanel.add(jLabel3, BorderLayout.CENTER);
      panel1.add(jCenterPanel,  BorderLayout.CENTER);
        jCenterPanel.add(jRadioButton2,          new XYConstraints(20, 60, 270, 20));
        panel1.add(jBottomPanel, BorderLayout.SOUTH);
    jBottomPanel.add(jButton1,                new XYConstraints(110, 7, 50, 25));
    jBottomPanel.add(jButton2,      new XYConstraints(170, 7, 50, 25));

    bg.add(jRadioButton1);
    bg.add(jRadioButton2);
        jCenterPanel.add(jRadioButton1, new XYConstraints(20, 30, 270, 20));
        jCenterPanel.add(jLabel1, new XYConstraints(25, 90, 280, 20));
        jCenterPanel.add(jLabel2, new XYConstraints(45, 110, 268, 20));
    }

  void set_dataModel(DataCollectionModel input)
  {
    this.Datamodel = input;
  }

  public void actionPerformed(ActionEvent e) {
    Object button = e.getSource();
    ok_clicked = false;

    if (button == jButton1) {
      ok_clicked = true;
      dispose();
    }
    else if (button == jButton2) {
      dispose();
    }
  }

}
