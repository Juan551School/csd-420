//Juan Macias Vasquez
//Bellevue University 
//CSD420-H323 Advanced Java Programming (2261-DD)
//Jack Lusby
//December 14th, 2025
//FanApp.java 

package module10program;

import javax.swing.*;
import java.awt.*;

public class FanApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtId = new JTextField(10);
    private JTextField txtFirst = new JTextField(20);
    private JTextField txtLast = new JTextField(20);
    private JTextField txtTeam = new JTextField(20);

    private JButton btnDisplay = new JButton("Display");
    private JButton btnUpdate = new JButton("Update");

    private FanDAO dao = new FanDAO();

    //The Display for the User 
    public FanApp() {
        setTitle("Fan Viewer / Updater");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        // The Information that is filled out by the User and what the user sees 
        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("First Name:"));
        panel.add(txtFirst);
        panel.add(new JLabel("Last Name:"));
        panel.add(txtLast);
        panel.add(new JLabel("Favorite Team:"));
        panel.add(txtTeam);

        //The Buttons on the Display Window 
        panel.add(btnDisplay);
        panel.add(btnUpdate);

        add(panel);

        btnDisplay.addActionListener(e -> displayFan());
        btnUpdate.addActionListener(e -> updateFan());
    }

    private void displayFan() {
        String idText = txtId.getText().trim();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an ID.");
            return;
        }

        // Error messages and making sure the user puts in an int 
        try {
            int id = Integer.parseInt(idText);
            Fan fan = dao.getFanById(id);

            if (fan != null) {
                txtFirst.setText(fan.getFirstName());
                txtLast.setText(fan.getLastName());
                txtTeam.setText(fan.getFavoriteTeam());
            } else {
                JOptionPane.showMessageDialog(this, "Fan not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID must be a number.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    
    
    private void updateFan() {
        String idText = txtId.getText().trim();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an ID.");
            return;
        }

        try {
            int id = Integer.parseInt(idText);

            Fan fan = new Fan(
                    id,
                    txtFirst.getText().trim(),
                    txtLast.getText().trim(),
                    txtTeam.getText().trim()
            );

            boolean updated = dao.updateFan(fan);
            // In case it messes up again / Error Codes 
            if (updated) {
                JOptionPane.showMessageDialog(this, "Record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Update failed. Check the ID.");
            }
            
        // Make sure a proper input is added 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID must be a number.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FanApp().setVisible(true));
    }
}
