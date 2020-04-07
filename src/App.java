public class App {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(60);
        bst.add(55);
        bst.add(100);
        bst.add(45);
        bst.add(57);
        bst.add(67);
        bst.add(107);

        System.out.println("Original: ");
        bst.inOrder();

        bst.remove(45);
        System.out.println("\nAfter remove 40: ");
        bst.inOrder();

        bst.remove(60);
        System.out.println("\nAfter remove 60: ");
        bst.inOrder();
    }
}
