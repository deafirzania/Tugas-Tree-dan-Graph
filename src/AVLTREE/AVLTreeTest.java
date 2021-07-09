package AVLTREE;

/*
 *  Java Program to Implement AVL Tree
 */
import java.util.Scanner;

/* Membuat Class AVLNode */
class AVLNode {

    AVLNode left, right;
    int data;
    int height;

    /* Konstruktor */
    public AVLNode() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    /* Konstruktor */
    public AVLNode(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}

/*  Membuat Class AVLTree */
class AVLTree {

    private AVLNode root;

    /* Konstruktor */
    public AVLTree() {
        root = null;
    }

    /* Berfungsi untuk memeriksa apakah tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Membuat logis tree empty */
    public void makeEmpty() {
        root = null;
    }

    /* berfungsi untuk memasukan data */
    public void insert(int data) {
        root = insert(data, root);
    }

    /* berfungsi untuk mendapatkan height of node */
    private int height(AVLNode t) {
        return t == null ? -1 : t.height;
    }

    /* berfungsi untuk menentukan nilai maksimum di dikiri ataupun di kanan node */
    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    /* berfungsi untuk memasukan data secara rekursif */
    private AVLNode insert(int x, AVLNode t) {
        if (t == null) {
            t = new AVLNode(x);
        } else if (x < t.data) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2) {
                if (x < t.left.data) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (x > t.data) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2) {
                if (x > t.right.data) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else
           ;  // Duplicate; do nothing
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /* memutar binary tree node dengan menggunakan left child */
    private AVLNode rotateWithLeftChild(AVLNode k2) {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /* memutar binary tree node dengan menggunakan right child */
    private AVLNode rotateWithRightChild(AVLNode k1) {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * memutar binary tree node: yang pertama yaitu left child dengan
     * menggunakan right child; lalu node k3 bersama left child yang baru
     */
    private AVLNode doubleWithLeftChild(AVLNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * memutar dua kali binary tree node: pertama right child dengan menggunakan
     * left child; lalu node k1 bersama right child yang baru
     */
    private AVLNode doubleWithRightChild(AVLNode k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    /* Berfungsi untuk menghitung jumlah dari node */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(AVLNode r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    /* Berfungsi untuk mencari sebuah element */
    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(AVLNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.data;
            if (val < rval) {
                r = r.left;
            } else if (val > rval) {
                r = r.right;
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /* berfungsi untuk mencari inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(AVLNode r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + " ");
            inorder(r.right);
        }
    }

    /* Berfungsi untuk preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(AVLNode r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preorder(r.left);
            preorder(r.right);
        }
    }

    /* Berfungsi untuk postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(AVLNode r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data + " ");
        }
    }
}

/* Membuat Class AVL Tree Test */
public class AVLTreeTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Membuat objek dari of AVLTree */
        AVLTree avlt = new AVLTree();

        System.out.println("AVLTree Tree Program\n");
        char ch;
        /*  Melakukan operasi pada tree  */
        do {
            System.out.println("\nAVLTree Operations\n");
            System.out.println("1. Insert ");
            System.out.println("2. Search");
            System.out.println("3. Count Nodes");
            System.out.println("4. Check empty");
            System.out.println("5. Clear tree");
            System.out.print("Pilihan : ");
            int pilih = scan.nextInt();
            switch (pilih) {
                case 1:
                    System.out.println("Masukkan Bilangan untuk dimasukkan");
                    avlt.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Masukkan Bilangan untuk mencari");
                    System.out.println("Hasil Pencarian : " + avlt.search(scan.nextInt()));
                    break;
                case 3:
                    System.out.println("Nodes = " + avlt.countNodes());
                    break;
                case 4:
                    System.out.println("Status Kosong = " + avlt.isEmpty());
                    break;
                case 5:
                    System.out.println("\nTree Terhapus");
                    avlt.makeEmpty();
                    break;
                default:
                    System.out.println("Salah Input \n ");
                    break;
            }
            /*  Menampilkan tree  */
            System.out.print("\nPost order : ");
            avlt.postorder();
            System.out.print("\nPre order : ");
            avlt.preorder();
            System.out.print("\nIn order : ");
            avlt.inorder();

            System.out.println("\nApakah kamu ingin melanjutkan? (ketik y atau n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
