package Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Tree {

    private Node root;

    private boolean
            isEmpty() {
        return (root == null);
    }

    public void insert(long input) {
        Node temp = new Node(input);
        if (isEmpty()) {
            root = temp;
        } else {
            Node cursor = root,
                    parent = null;
            while (cursor != null) {
                parent = cursor;
                if (input < cursor.data) {
                    cursor = cursor.left;
                } else {
                    cursor
                            = cursor.right;
                }
            }
            if (input < parent.data) {
                parent.left = temp;
                return;
            } else {
                parent.right = temp;
                return;
            }
        }
    }

    public Node find(long key) {
        Node cursor = root;
        while (cursor != null) {
            if (cursor.data == key) {
                return cursor;
            } else if (key < cursor.data) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }
        return null;
    }

    public boolean delete(long key) {
        Node cursor = root,
                parent = null;
        boolean found = false,
                isLeftChild = true;
//menandai apakah Node yang dihapus 
        //merupakan left child
        if (!isEmpty()) {
            while (cursor != null) {
                parent = cursor;
                if (key == cursor.data) {
                    found = true;
                    break;
                } else if (key < cursor.data) {
                    isLeftChild = true;
                    cursor = cursor.left;
                } else {
                    isLeftChild = false;
                    cursor = cursor.right;
                }
            }
            if (!found) {
                return false;
            } else {
                if (cursor.left == null && cursor.right == null) {
                    if (cursor == root) {
                        root = null;
                    } else if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (cursor.left == null) {
                    if (cursor == root) {
                        root = cursor.right;
                    } else if (isLeftChild) {
                        parent.left = cursor.right;
                    } else {
                        parent.right = cursor.right;
                    }
                } else if (cursor.right == null) {
                    if (cursor == root) {
                        root = cursor.left;
                    } else if (isLeftChild) {
                        parent.left = cursor.left;
                    } else {
                        parent.right = cursor.left;
                    }
                } else {
                    Node successor = getSuccessor(cursor);
                    if (cursor == root) {
                        root = successor;
                    } else if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }

                    successor.right = cursor.right;
                }
            }
        }
        return true;
    }

    private Node getSuccessor(Node localNode) {
        Node parent = null,
                successor = localNode,
                cursor = localNode.left;
        while (cursor != null) {
            parent = successor;
            successor = cursor;
            cursor = cursor.right;
        }
        if (successor != localNode.left) {
            parent.right = successor.left;
            successor.left = localNode.left;
        }
        return successor;

    }

    public void traverse(int tipe) {
        switch (tipe) {
            case 1:
                System.out.print("Preorder traversal:\n");
                preOrder(root);
                break;
            case 2:
                System.out.print("Inorder traversal:\n");
                inOrder(root);
                break;
            case 3:
                System.out.print("Postorder traversal:\n");
                postOrder(root);
                break;
        }
        System.out.println('\n');

    }

    private void preOrder(Node localRoot) {
        if (localRoot == null) {
            return;
        }
        System.out.println(localRoot.data + " ");
        preOrder(localRoot.left);
        preOrder(localRoot.right);
    }

    private void inOrder(Node localRoot) {
        if (localRoot == null) {
            return;
        }
        inOrder(localRoot.left);
        System.out.println(localRoot.data + " ");
        inOrder(localRoot.right);
    }

    private void postOrder(Node localRoot) {
        if (localRoot == null) {
            return;
        }
        postOrder(localRoot.left);
        postOrder(localRoot.right);
        System.out.println(localRoot.data + " ");
    }
}