import javax.swing.*;

/** CT2109 NUI Galway:
 * Class to demonstrate the use of BinaryTree code. 
 * Based on code by Carrano & Savitch.
 * @author Michael Madden.
 * and gavin skehan
 */

public class GuessingGame
{
	public static void main(String[] args) 
	{
		// Create a tree
		System.out.println("Constructing a test tree ...");
		BinaryTree<String> testTree = new BinaryTree<String>();
		createTree1(testTree);
		
		// Display some statistics about it
		System.out.println("\nSome statistics about the test tree ...");
		displayStats(testTree);
		
		// Perform in-order traversal
		System.out.println("\nIn-order traversal of the test tree, printing each node when visiting it ...");
		testTree.inorderTraverse();

		question(testTree);
		
	} // end of File

	public static void createTree1(BinaryTree<String> tree)
	{
		BinaryTree<String> hTree = new BinaryTree<>("Is it a dog?");
		BinaryTree<String> iTree = new BinaryTree<>("Is it a lion?");
		BinaryTree<String> jTree = new BinaryTree<>("Is it an eagle?");
		BinaryTree<String> kTree = new BinaryTree<>("Is it a snake?");
		BinaryTree<String> lTree = new BinaryTree<>("Is it a car?");
		BinaryTree<String> mTree = new BinaryTree<>("Is it a house?");
		BinaryTree<String> nTree = new BinaryTree<>("Is it a laptop?");
		BinaryTree<String> oTree = new BinaryTree<>("Is it a hammer?");

	    // First the leaves
		BinaryTree<String> dTree = new BinaryTree<String>("Is it a pet?", hTree, iTree);
		BinaryTree<String> eTree = new BinaryTree<String>("Is it a bird?", jTree, kTree);
		BinaryTree<String> fTree = new BinaryTree<String>("Does it have wheels?", lTree, mTree);
		BinaryTree<String> gTree = new BinaryTree<String>("Is it technology?", nTree, oTree);

		// Now the subtrees joining leaves:
		BinaryTree<String> bTree = new BinaryTree<String>("Is it a mammal?", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<String>("Is it an object?", fTree, gTree);

		// Now the root
		tree.setTree("Are you thinking of an animal?", bTree, cTree);
	}

	// handling user errors in the user input
	public static String getInput(String question) {
		String input = JOptionPane.showInputDialog(null, question);
		if (input == null)
			System.exit(0);
		else if (input.equals("")){
			JOptionPane.showMessageDialog(null, "Please enter a valid input");
			return getInput(question);
		} else {
			return input;
		}
		return input;
	}

	public static void question(BinaryTree<String> tree){
		// loop until process is broken or finished
		while(true){
			BinaryNodeInterface<String> currentNode = tree.getRootNode();
			String answer;
			while(!currentNode.isLeaf()){
				answer = FilePanel.getInput(currentNode.getData());
				if(answer.equals("yes")){
					currentNode = currentNode.getLeftChild();
				} else if (answer.equals("no")) {
					currentNode = currentNode.getRightChild();
				} else {
					JOptionPane.showMessageDialog(null, "Please enter yes or no. \n");
				}
			}
			answer = FilePanel.getInput(currentNode.getData());

			if(answer.equals("yes")){
				JOptionPane.showMessageDialog(null, "The tree guessed correctly!\n");
				answer = FilePanel.getInput("Would you like to:\n\t1. Play again.\n\t2. Store the tree.\n\t3. Load a stored tree\n\t4. Quit.\n");
				if (answer.equals("1")) currentNode = tree.getRootNode();
				if (answer.equals("2")) {
					FilePanel.storeTree(tree);
					currentNode = tree.getRootNode();
				}
				if(answer.equals("4"))
					System.exit(0);
			}
			else if (answer.equals("no")){
				answer = FilePanel.getInput("I don't know: what is the correct answer?\n");
				currentNode.setLeftChild(new BinaryNode<>("Is it a " + answer));
				currentNode.setRightChild(new BinaryNode<>(currentNode.getData()));
				answer = FilePanel.getInput("Distinguishing question?\n");
				currentNode.setData(answer);
				currentNode = tree.getRootNode();
			} else {
				JOptionPane.showMessageDialog(null, "Please enter yes or no.\n");
			}
		}
	}
	public static void displayStats(BinaryTree<String> tree)
	{
		if (tree.isEmpty())
			System.out.println("The tree is empty");
		else
			System.out.println("The tree is not empty");
		
		System.out.println("Root of tree is " + tree.getRootData());
		System.out.println("Height of tree is " + tree.getHeight());
		System.out.println("No. of nodes in tree is " + tree.getNumberOfNodes());
	} // end displayStats 
}
