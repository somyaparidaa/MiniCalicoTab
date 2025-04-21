import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("MiniCalicoTab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Main panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#f0f4f7"));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // Title
        JLabel title = new JLabel("Welcome to MiniCalicoTab!");
        JLabel subtitle = new JLabel("A lightweight APD-style tabbing system.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.decode("#333333"));

        panel.add(title);
        panel.add(subtitle);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        // Description
JLabel description = new JLabel("What would you like to do?");
description.setFont(new Font("SansSerif", Font.PLAIN, 14));
description.setAlignmentX(Component.CENTER_ALIGNMENT);
description.setForeground(Color.decode("#666666"));
panel.add(Box.createRigidArea(new Dimension(0, 10)));
panel.add(description);

panel.add(Box.createRigidArea(new Dimension(0, 30))); 

        // Buttons and their actions
        String[] buttons = {
            "Register as Team",
            "Register as Adjudicator",
            "View All Registrations",
            "Generate Draws"
        };

        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(250, 40));
            btn.setBackground(new Color(0x3f51b5));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btn.addActionListener(e -> {
                switch (label) {
                    case "Register as Team":
                        new RegisterTeamForm();
                        break;
                    case "Register as Adjudicator":
                        new RegisterAdjudicatorForm();
                        break;
                    case "View All Registrations":
                        new View();
                        break;
                    case "Generate Draws":
                        new DrawGenerator();
                        break;
                }
            });

            panel.add(btn);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu(); 
    }
}
