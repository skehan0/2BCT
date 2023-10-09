import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FilePanel extends JPanel {
    // handles the user's input
    public static String getInput(String question) {
        String input = JOptionPane.showInputDialog(null, question);
        if (input == null) {
            System.exit(0);
        } else if (input.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid input");
            return getInput(question);
        } else {
            return input;
        }
        return input;
    }

    // saves and stores the completed tree inside a file by serialization
    public static void storeTree(BinaryTree<String> tree) {
        String question = "Enter the name of the file to store in the directory: " + System.getProperty("user.dir");

        // serialize
        try {
            FileOutputStream fileOutput = new FileOutputStream(getInput(question));
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(tree);
            objectOutput.close();
            fileOutput.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid filename");
            System.out.println("IOException caught: " + e.getMessage());
            storeTree(tree);
        }
    }
    public static BinaryTree<String> loadTree() {
        BinaryTree<String> tree = null;
        String question = "Enter the name of the file to load from the directory: " + System.getProperty("user.dir");

        // deserialise
        try {
            FileInputStream fileInput = new FileInputStream(getInput(question));
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            tree = (BinaryTree<String>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
            return tree;
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid filename");
            System.out.println("Exception caught: " + e.getMessage());
            return loadTree();
        }
    }
}