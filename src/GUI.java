import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public void swingInterface() {
        JFrame frame = new JFrame("Caesar Cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Створення підписів для полів
        JLabel inputLinkLabel = new JLabel("Enter a link to the file:");
        JLabel inputKeyLabel = new JLabel("Enter the key:");
        JLabel outputLabel = new JLabel("Output:");

        // Створення текстових полів
        JTextField inputFieldLink = new JTextField(20);
        JTextField inputFieldKey = new JTextField(20);

        // Створення кнопок
        JButton buttonEncrypt = new JButton("Encrypt");
        JButton buttonDecrypt = new JButton("Decrypt");
        JButton buttonBruteForce = new JButton("Brute Force");

        // Створення поля для виводу
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        // Створення повзунка для поля виводу
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Додавання подій до кнопок
        buttonEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                String output = new Implementation().launchCaesarCipher("e", inputFieldLink.getText(), Integer.parseInt(inputFieldKey.getText()));
                outputArea.append(output);
            }
        });

        buttonDecrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                String output = new Implementation().launchCaesarCipher("d", inputFieldLink.getText(), Integer.parseInt(inputFieldKey.getText()));
                outputArea.append(output);
            }
        });

        buttonBruteForce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                int key = new Implementation().launchBruteForce(inputFieldLink.getText());
                outputArea.append("Key: " + String.valueOf(key));
            }
        });

        // Створення панелі та додавання елементів
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(inputLinkLabel, gbc);

        gbc.gridx = 1;
        panel.add(inputFieldLink, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(inputKeyLabel, gbc);

        gbc.gridx = 1;
        panel.add(inputFieldKey, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(outputLabel, gbc);

        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panel.add(buttonEncrypt, gbc);

        gbc.gridx = 1;
        panel.add(buttonDecrypt, gbc);

        gbc.gridx = 2;
        panel.add(buttonBruteForce, gbc);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}