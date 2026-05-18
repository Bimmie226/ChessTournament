package view.staff;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Staff;

public class StaffHomeFrm extends JFrame implements ActionListener{
  private JButton btnUpdateMatchResults, btnPairScheduling, btnViewStatistic;
  private Staff staff;

  public StaffHomeFrm(Staff staff) {
    this.staff = staff;

    
  }


}
