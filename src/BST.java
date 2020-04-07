public class BST {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private Node addNodes(Node root, int element) {
        Node temp = null;
        if (root.getElement() >= element) {
            if (root.getLeft() == null) {
                root.setLeft(new Node(element));
                return root.getLeft();
            } else {
                temp = root.getLeft();
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node(element));
                return root.getRight();
            } else {
                temp = root.getRight();
            }
        }
        return addNodes(temp, element);
    }

    public void add(int element) {
        if (root == null) {
            root = new Node(element);
            return;
        }
        addNodes(root, element);
    }

    private int minValue(Node node) {
        if (node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getElement();
    }

    private Node removeNode(Node root, int element) {
        if (root == null) {
            return null;
        }
        if (element < root.getElement()) {
            root.setLeft(removeNode(root.getLeft(), element));
        } else if (element > root.getElement()) {
            root.setRight(removeNode(root.getRight(), element));
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            } else if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                int min = minValue(root.getRight());
                root.setElement(min);
                root.setRight(removeNode(root.getRight(), min));
            }
        }
        return root;
    }

    public void remove(int element) {
        removeNode(root, element);
    }

    private void doInorder(Node root) {
        if (root == null) {
            return;
        }
        doInorder(root.getLeft());
        System.out.println(root.getElement() + " ");
        doInorder(root.getRight());
    }

    public void inOrder() {
        doInorder(root);
    }
}
