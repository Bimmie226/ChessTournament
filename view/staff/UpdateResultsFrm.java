package view.staff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.MatchDAO;
import model.Match;
import model.Player;
import model.Round;
import model.Staff;

public class UpdateResultsFrm extends JFrame implements ActionListener {

    private Staff staff;

    private JComboBox<String> cbRound;

    private JTable tblMatches;

    private JButton btnNext;
    private JButton btnBack;

    private DefaultTableModel tableModel;

    private MatchDAO matchDAO;

    private ArrayList<Match> listMatch;

    public UpdateResultsFrm(Staff staff) {

        super("Update Match Results");

        this.staff = staff;

        matchDAO = new MatchDAO();

        // ===== MAIN PANEL =====

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(
                new BoxLayout(
                        mainPanel,
                        BoxLayout.Y_AXIS
                )
        );

        // ===== HEADER =====

        JPanel headerPanel = new JPanel();

        headerPanel.setLayout(
                new BoxLayout(
                        headerPanel,
                        BoxLayout.X_AXIS
                )
        );

        headerPanel.add(
                Box.createRigidArea(
                        new Dimension(400, 0)
                )
        );

        JLabel lbUser =
                new JLabel(
                        "Logged in as: "
                        + staff.getFirstName()
                );

        headerPanel.add(lbUser);

        mainPanel.add(headerPanel);

        // ===== TITLE =====

        mainPanel.add(
                Box.createRigidArea(
                        new Dimension(0, 20)
                )
        );

        JLabel title =
                new JLabel("Update Match Results");

        title.setAlignmentX(0.5f);

        title.setFont(
                title.getFont().deriveFont(26f)
        );

        mainPanel.add(title);

        // ===== ROUND PANEL =====

        mainPanel.add(
                Box.createRigidArea(
                        new Dimension(0, 20)
                )
        );

        JPanel roundPanel = new JPanel();

        JLabel lbRound =
                new JLabel("Select round: ");

        cbRound = new JComboBox<>();

        for (int i = 1; i <= 11; i++) {
            cbRound.addItem("Round " + i);
        }

        cbRound.addActionListener(this);

        roundPanel.add(lbRound);
        roundPanel.add(cbRound);

        mainPanel.add(roundPanel);

        // ===== TABLE =====

        String[] columns = {
                "ID",
                "Player 1",
                "Player 2",
                "Table",
                "Date",
                "Location"
        };

        tableModel =
                new DefaultTableModel(columns, 0);

        tblMatches = new JTable(tableModel);

        tblMatches.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scrollPane =
                new JScrollPane(tblMatches);

        scrollPane.setPreferredSize(
                new Dimension(600, 200)
        );

        JPanel tablePanel = new JPanel();

        tablePanel.add(scrollPane);

        mainPanel.add(tablePanel);

        // ===== BUTTON PANEL =====

        JPanel buttonPanel = new JPanel();

        btnBack = new JButton("Back");

        btnNext = new JButton("Next");

        btnBack.addActionListener(this);

        btnNext.addActionListener(this);

        buttonPanel.add(btnBack);

        buttonPanel.add(btnNext);

        mainPanel.add(buttonPanel);

        // ===== FRAME =====

        this.setLayout(new BorderLayout());

        this.add(mainPanel, BorderLayout.CENTER);

        this.setSize(750, 450);

        this.setLocation(250, 100);

        this.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ===== SELECT ROUND =====

        if (e.getSource() == cbRound) {

            int roundNo =
                    cbRound.getSelectedIndex() + 1;

            Round r = new Round();

            r.setId(roundNo);

            listMatch =
                    matchDAO.getMatchesByRound(r);

            tableModel.setRowCount(0);

            for (Match m : listMatch) {

                String p1 = "";

                String p2 = "";

                if (m.getPlayers() != null
                        && m.getPlayers().size() > 0) {

                    p1 =
                        m.getPlayers()
                         .get(0)
                         .getName();
                }

                if (m.getPlayers() != null
                        && m.getPlayers().size() > 1) {

                    p2 =
                        m.getPlayers()
                         .get(1)
                         .getName();
                }

                tableModel.addRow(
                        new Object[] {

                                m.getId(),

                                p1,

                                p2,

                                m.getTableNO(),

                                m.getDateTime(),

                                m.getLocation()
                        }
                );
            }

            if (listMatch.size() == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "No match found!"
                );
            }
        }

        // ===== NEXT =====

        else if (e.getSource() == btnNext) {

            int selectedRow =
                    tblMatches.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a match!"
                );

                return;
            }

            Match selectedMatch =
                    listMatch.get(selectedRow);

            JOptionPane.showMessageDialog(
                    this,
                    "Selected Match ID: "
                    + selectedMatch.getId()
            );

            // Sau này:
            // new MatchResultInputFrm(
            //      selectedMatch,
            //      staff
            // ).setVisible(true);
        }

        // ===== BACK =====

        else if (e.getSource() == btnBack) {

            new StaffHomeFrm(staff)
                    .setVisible(true);

            this.dispose();
        }
    }
}