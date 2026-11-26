mport javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class IPAddressGeneratorApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("IP Address Generator");

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel titleLabel = new JLabel("IP Address Generator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel ipDisplayLabel = new JLabel("192.168.1.1");
        ipDisplayLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton generateButton = new JButton("Generate IP");
        generateButton.setFont(new Font("Arial", Font.PLAIN, 14));

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Random rand = new Random();

                int first = rand.nextInt(254) + 1;
                int second = rand.nextInt(256);
                int third = rand.nextInt(256);
                int fourth = rand.nextInt(254) + 1;

                String randomIp = first + "." + second + "."
                        + third + "." + fourth;

                ipDisplayLabel.setText(randomIp);
            }
        });

        frame.add(titleLabel);
        frame.add(ipDisplayLabel);
        frame.add(generateButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
