import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventDriven extends JFrame {

    private JLabel lblFirst, lblLast, lblMiddle, lblMobile, lblEmail;
    private JTextField txtFirst, txtLast, txtMiddle, txtMobile, txtEmail;
    private JFButton btnSubmit, btnClearAll;

    private JFrame outputFrame;
    private JTextArea txtOutput;
    private JButton btnOkay;

    public EventDriven() {
        super(" INPUT ");
        setSize(260, 360);
        setLocation(200, 150);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblFirst = makeLabel("First Name:");
        lblLast = makeLabel("Last Name:");
        lblMiddle = makeLabel("Middle Name:");
        lblMobile = makeLabel("Mobile No.:");
        lblEmail = makeLabel("Email Address:");

        txtFirst = new JTextField();
        txtLast = new JTextField();
        txtMiddle = new JTextField();
        txtMobile = new JTextField();
        txtEmail = new JTextField();

        btnSubmit = new JButton("Submit");
        btnClearAll = new JButton("Clear All");

        JPanel fieldsPanel = new JPanel(new GridLayout(10, 1, 0, 3));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));
        fieldsPanel.add(lblFirst);
        fieldsPanel.add(txtFirst);
        fieldsPanel.add(lblLast);
        fieldsPanel.add(txtLast);
        fieldsPanel.add(lblMiddle);
        fieldsPanel.add(txtMiddle);
        fieldsPanel.add(lblMobile);
        fieldsPanel.add(txtMobile);
        fieldsPanel.add(lblEmail);
        fieldsPanel.add(txtEmail);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClearAll);

        setLayout(new BorderLayout());
        add(fieldsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        btnSubmit.addActionListener(new SubmitListener());
        btnClearAll.addActionListener(new ClearListener());

        buildOutputFrame();
    }

    private JLabel makeLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 13));
        return label;
    }

    private void buildOutputFrame() {
        outputFrame = new JFrame("OUTPUT");
        outputFrame.setSize(600, 450);
        outputFrame.setResizable(false);
        outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtOutput.setMargin(new Insets(8, 8, 8, 8));

        btnOkay = new JButton("Okay");
        btnOkay.addActionListener(new OkayListener());

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        bottom.add(btnOkay);

        outputFrame.setLayout(new BorderLayout());
        outputFrame.add(new JScrollPane(txtOutput), BorderLayout.CENTER);
        outputFrame.add(bottom, BorderLayout.SOUTH);
    }

    private void resetInput() {
        txtFirst.setText("");
        txtLast.setText("");
        txtMiddle.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
        btnSubmit.setEnabled(true);
        txtFirst.requestFocusInWindow();
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtOutput.setText(
                    "First Name:\t" + txtFirst.getText() + "\n" +
                            "Last Name:\t" + txtLast.getText() + "\n" +
                            "Middle Name:\t" + txtMiddle.getText() + "\n" +
                            "Mobile No.:\t" + txtMobile.getText() + "\n" +
                            "Email Add:\t" + txtEmail.getText());

            outputFrame.setLocationRelativeTo(EventDriven.this);
            outputFrame.setVisible(true);

            btnSubmit.setEnabled(false);
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetInput();
            if (outputFrame.isVisible()) {
                outputFrame.setVisible(false);
            }
        }
    }

    class OkayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            outputFrame.setVisible(false);
            resetInput();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventDriven().setVisible(true));
    }
}
