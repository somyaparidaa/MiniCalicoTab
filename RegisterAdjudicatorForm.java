import java.io.FileWriter;

import javax.swing.*;

public class RegisterAdjudicatorForm extends JFrame {
    public RegisterAdjudicatorForm() {
        setTitle("Register Adjudicator");
        setSize(400, 250);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        JLabel instLabel = new JLabel("Institution:");

        JTextField nameField = new JTextField();
        JTextField instField = new JTextField();

        JButton submitBtn = new JButton("Register");

        nameLabel.setBounds(30, 30, 100, 25);
        instLabel.setBounds(30, 70, 100, 25);

        nameField.setBounds(130, 30, 200, 25);
        instField.setBounds(130, 70, 200, 25);
        submitBtn.setBounds(130, 120, 100, 30);

        add(nameLabel);
        add(instLabel);
        add(nameField);
        add(instField);
        add(submitBtn);

        submitBtn.addActionListener(e -> {
            String name = nameField.getText();
            String inst = instField.getText();

            Adj adj = new Adj(name, inst);
            Tabmanager.adjudicators.add(adj);
            try (FileWriter fw = new FileWriter("data/adjudicators.txt", true)) {
                fw.write(name + ", " + inst + "\n");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Adjudicator Registered!");

            nameField.setText("");
            instField.setText("");
        });

        setVisible(true);
    }
}
