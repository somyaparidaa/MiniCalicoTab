import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class View extends JFrame {
    public View() {
        setTitle("All Registrations");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JTable teamTable = new JTable(new DefaultTableModel(new String[]{"Team", "Speaker 1", "Speaker 2", "Speaker 3", "Institution"}, 0));
        JTable adjTable = new JTable(new DefaultTableModel(new String[]{"Name", "Institution"}, 0));

        loadFileIntoTable("data/teams.txt", (DefaultTableModel) teamTable.getModel());
        loadFileIntoTable("data/adjudicators.txt", (DefaultTableModel) adjTable.getModel());

        add(new JScrollPane(teamTable));
        add(new JScrollPane(adjTable));
        setVisible(true);
    }

    private void loadFileIntoTable(String path, DefaultTableModel model) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                model.addRow(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
