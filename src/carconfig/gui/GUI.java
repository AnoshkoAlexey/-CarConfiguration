package carconfig.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import carconfig.autoutil.FileIO;
import carconfig.exception.AutoException;
import carconfig.model.Automobile;

public class GUI {

    private JFrame frame;
    private JTextArea carDescription;
    private Automobile car;

    public void go() {

        // Create main window
        frame = new JFrame("Car Configuration");

        // Create menubar
        JMenuBar menuBar = new JMenuBar();

        // Create submenu
        JMenu fileMenu = new JMenu("File");

        // Create submenu items
        JMenuItem readTxtFileItem = new JMenuItem("Read configuration (.txt)");
        readTxtFileItem.addActionListener(new ReadTxtFileListener());

        JMenuItem serAutoItem = new JMenuItem("Serialize auto");
        serAutoItem.addActionListener(new SerAutoItemListener());

        JMenuItem deserAutoItem = new JMenuItem("Deserialize auto");
        deserAutoItem.addActionListener(new DeserAutoItemListener());

        // Add items on submenu
        fileMenu.add(readTxtFileItem);
        fileMenu.add(serAutoItem);
        fileMenu.add(deserAutoItem);

        // Add submenu on menubar
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Add text area
        carDescription = new JTextArea(20, 20);
        frame.getContentPane().add(BorderLayout.CENTER, carDescription);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public class ReadTxtFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            File selectedFile = fileOpen.getSelectedFile();
            if (selectedFile != null) {
                try {
                    car = new FileIO().readFile(selectedFile.toString());
                    carDescription.setText(car.toString());
                } catch (AutoException e) {

                }
            }
            JOptionPane.showMessageDialog(frame, "Car configuration was read successfully!");
        }
    }

    public class SerAutoItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            File selectedFile = fileSave.getSelectedFile();
            if (selectedFile != null)
                new FileIO().serializeAuto(car, selectedFile.toString());
            JOptionPane.showMessageDialog(frame, "Car configuration was serialized successfully!");
        }
    }

    public class DeserAutoItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            JFileChooser openFile = new JFileChooser();
            openFile.showOpenDialog(frame);
            File selectedFile = openFile.getSelectedFile();
            if (selectedFile != null)
                car = new FileIO().deserializeAuto(selectedFile.toString());
                carDescription.setText(car.toString());
            JOptionPane.showMessageDialog(frame, "Car configuration was deserialize successfully!");
        }
    }
}