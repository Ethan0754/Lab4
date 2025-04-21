import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Purse purse;
    private PursePanel pursePanel;
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private JComboBox<String> regionChoice;
    private String[] regions = {"US", "EU"};
    private double userInput;

    RegisterPanel() {
        // back end logic
        purse = new Purse();
        register = new USRegister(purse);

        // GUI
        pursePanel = new PursePanel(purse);

        // user input GUI
        inputPanel = new JPanel();
        input = new JTextField();

        regionChoice = new JComboBox<>(regions);
        regionChoice.addActionListener(new ChoiceListener());

        this.setBackground(Color.WHITE);

        inputPanel.setBackground(Color.BLACK);
        inputPanel.setPreferredSize(new Dimension(200, 100));

        input.setBackground(Color.WHITE);
        input.setPreferredSize(new Dimension(80, 40));
        input.addActionListener(new InputListener()); //handles the input to the gui

        pursePanel.setPreferredSize(new Dimension(1000, 1000));


        // add components to panels
        this.add(inputPanel);
        inputPanel.add(input);
        inputPanel.add(regionChoice);
        this.add(pursePanel);
    }



    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                userInput = Double.parseDouble(input.getText());
                register.Count(userInput);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    private class ChoiceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (regionChoice.getSelectedIndex()){
                case 0:
                    register = new USRegister(purse);
                    break;
                case 1:
                    register= new EURegister(purse);
                    break;

            }
            register.Count(userInput);
        }
    }
}
