import java.io.FileWriter;

import javax.swing.*;

public class RegisterTeamForm extends JFrame {
    public RegisterTeamForm() {
        setTitle("Register Team");
        setSize(400, 300);
        setLayout(null);

        JLabel nameLabel = new JLabel("Team Name:");
        JLabel speaker1Label = new JLabel("Speaker 1:");
        JLabel speaker2Label = new JLabel("Speaker 2:");
        JLabel speaker3Label = new JLabel("Speaker 3:");
        JLabel instituteLabel = new JLabel("Institution:");

        JTextField nameField = new JTextField();
        JTextField speaker1Field = new JTextField();
        JTextField speaker2Field = new JTextField();
        JTextField speaker3Field = new JTextField();
        JTextField instituteField = new JTextField();

        JButton submitBtn = new JButton("Register");

        nameLabel.setBounds(30, 30, 100, 25);
        speaker1Label.setBounds(30, 70, 100, 25);
        speaker2Label.setBounds(30, 110, 100, 25);
        speaker3Label.setBounds(30, 150, 100, 25);
        instituteLabel.setBounds(30, 190, 100, 25);

        nameField.setBounds(130, 30, 200, 25);
        speaker1Field.setBounds(130, 70, 200, 25);
        speaker2Field.setBounds(130, 110, 200, 25);
        speaker3Field.setBounds(130, 150, 200, 25);
        instituteField.setBounds(130, 190, 200, 25);
        submitBtn.setBounds(130, 230, 100, 30);

        add(nameLabel);
        add(speaker1Label);
        add(speaker2Label);
        add(speaker3Label);
        add(instituteLabel);
        add(nameField);
        add(speaker1Field);
        add(speaker2Field);
        add(speaker3Field);
        add(instituteField);
        add(submitBtn);

        submitBtn.addActionListener(e -> {
            String teamName = nameField.getText();
            String speaker1 = speaker1Field.getText();
            String speaker2 = speaker2Field.getText();
            String speaker3 = speaker3Field.getText();
            String institute = instituteField.getText();

            Team team = new Team(teamName, speaker1, speaker2, speaker3, institute);
            Tabmanager.teams.add(team);
            try (FileWriter fw = new FileWriter("data/teams.txt", true)) {
                fw.write(teamName + ", " + speaker1 + ", " + speaker2 + ", " + speaker3 + ", " + institute + "\n");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Team Registered!");

            nameField.setText("");
            speaker1Field.setText("");
            speaker2Field.setText("");
            speaker3Field.setText("");
            instituteField.setText("");
        });

        setVisible(true);
    }
}

