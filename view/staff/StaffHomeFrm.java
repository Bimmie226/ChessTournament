package view.staff;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Staff;

public class StaffHomeFrm extends JFrame implements ActionListener{
  private JButton btnUpdateMatchResults;
  private Staff staff;

  public StaffHomeFrm(Staff staff) {
    super("Staff Home");

    this.staff = staff; 

    // Tạo panel chính chứa toàn bộ UI 
    JPanel mainPanel = new JPanel(); 
    // Sắp xếp các component trong layout 
    mainPanel.setLayout(new BoxLayout(mainPanel, 3)); 

    // Tạo panel header 
    JPanel headerPanel = new JPanel(); 
    headerPanel.setLayout(new BoxLayout(headerPanel, 2)); 

    // Tạo khoảng trống ngang trên header 
    headerPanel.add(Box.createRigidArea(new Dimension(450, 0)));
    
    // Label user 
    JLabel userLabel = new JLabel("Loged in as: " + staff.getFullName()); 
    // Căn phải Label User theo trục X để hiển thị bên phải 
    userLabel.setAlignmentX(1.0F);

    // Thêm Label user vào panel header 
    headerPanel.add(userLabel); 

    // Thêm panel header vào panel main 
    mainPanel.add(headerPanel); 

    // Tạo khoảng cách dọc trong panel main 
    mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); 

    // Tạo label tiêu đề chính "Staff Home Frm"
    JLabel mainTitle = new JLabel("Staff's home");
    // Canh tiêu đề chính vào giữa 
    mainTitle.setAlignmentX(0.5F);
    // Tăng font size của tiêu đề chính lên 28 
    mainTitle.setFont(mainTitle.getFont().deriveFont(28.0F)); 
    // Thêm tiêu đề chính vào panel main 
    mainPanel.add(mainTitle); 

    // Tạo khoảng cách dọc trong panel main 
    mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); 

    // Tạo button Update Match Results 
    this.btnUpdateMatchResults = new JButton("Update Match Results");
    // Canh button này vào giữa 
    this.btnUpdateMatchResults.setAlignmentX(0.5F);
    // Gắn listener cho button -> Swing sẽ gọi actionPerformed(...)
    this.btnUpdateMatchResults.addActionListener(this);
    // Thêm button vào mainPanel 
    mainPanel.add(btnUpdateMatchResults); 

    // Set size window rộng 600, cao 300
    this.setSize(600, 300); 
    // Set vị trí màn hình 
    this.setLocation(200, 10);

    // Add mainPanel vào giữa JFrame: Center = BorderLayout.CENTER
    this.add(mainPanel, "Center"); 

    // Đóng cửa sổ: 2 = JFrame.DISPOSE_ON_CLOSE
    this.setDefaultCloseOperation(2);
  }

  public void actionPerformed(ActionEvent e) { 
    if (e.getSource() instanceof JButton && ((JButton)e.getSource()).equals(this.btnUpdateMatchResults)) {
      (new StaffHomeFrm(this.staff)).setVisible(true);
      this.dispose();
    } else {
      JOptionPane.showMessageDialog(this, "This function is under construction!");
    }
  }
}
