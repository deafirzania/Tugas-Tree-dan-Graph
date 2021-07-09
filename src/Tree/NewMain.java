/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class NewMain {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Tree a = new Tree();
        char ch;

        System.out.println("Program Urutan Presentasi Mahasiswa");
        do {
            System.out.println("\nMenu");
            System.out.println("1. Input NIM");
            System.out.println("2. Liat urutan berdasaran Preorder Traversal");
            System.out.println("3. Liat urutan berdasaran Inorder Traversal");
            System.out.println("4. Liat urutan berdasaran Postorder Traversal");
            System.out.print("Pilihan : ");
            int menu = in.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Masukkan Jumlah Mahasiswa : ");
                    int jml = in.nextInt();
                    long nim[] = new long[jml];
                    for (int i = 0; i < jml; i++) {
                        System.out.print("Masukkan NIM Mahasiswa : ");
                        nim[i] = in.nextLong();
                        a.insert(nim[i]);
                    }
                    break;
                case 2:
                    System.out.print("Urutan Presentasi berdasaran ");
                    a.traverse(1);
                    break;
                case 3:
                    System.out.print("Urutan Presentasi berdasaran ");
                    a.traverse(2);
                    break;
                case 4:
                    System.out.print("Urutan Presentasi berdasaran ");
                    a.traverse(3);
                    break;
                default:
                    System.out.println("Mohon maaf inputan salah.");
            }
            System.out.println("\nApakah kamu ingin melanjutkan? (ketik y atau n) \n");
            ch = in.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

}
