import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class DrawGenerator extends JFrame {
    public DrawGenerator() {
        setTitle("Draw Generator");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTable drawTable = new JTable(new DefaultTableModel(new String[]{"Gov", "Opp", "Adjudicator"}, 0));
        DefaultTableModel model = (DefaultTableModel) drawTable.getModel();

        List <String[]> teams = readFile("data/teams.txt");
        List <String[]> adjs = readFile("data/adjudicators.txt");

        Collections.shuffle(teams);
        Collections.shuffle(adjs);

        for (int i = 0; i < teams.size() - 1; i += 2) {
            String gov = teams.get(i)[0];
            String opp = teams.get(i + 1)[0];
            String adj = adjs.get(i / 2 % adjs.size())[0];
            model.addRow(new String[]{gov, opp, adj});
        }

        add(new JScrollPane(drawTable));
        setVisible(true);
    }

    private List<String[]> readFile(String path) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                list.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

