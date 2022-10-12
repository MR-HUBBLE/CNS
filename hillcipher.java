// import java.util.Random;
import java.util.Scanner;

public class hillcipher {
    private static String ciphered_text="";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 2;
        int[][] key = {{7,8},{11,11}};
        printarr(key);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // key[i][j]=sc.nextInt();
            }
        }
        String text="mp";
        int[][] matrix_text=new int[n][text.length()/n];
        for (int i = 0,k=0; i < matrix_text[0].length; i++) {
            for (int j = 0; j < matrix_text.length; j++)
                matrix_text[j][i]=(text.charAt(k++))%97;

        }
        int[][] matrix_cipher=matrix_multiply(key,matrix_text);
        // int[][] matrix_cipher=encrypt(text,key,n);
        System.out.println("Ciphered Text: "+ciphered_text);
        Decrypt(cipher, key,matrix_cipher);
        System.out.println("Decrypted Text: "+ciphered_text);
    }
    public static int[][] encrypt(String text,int[][] key,int n) {
        // while(text.length()%n!=0) text+='x';
        // int[][] matrix_text=new int[n][text.length()/n];
        // for (int i = 0,k=0; i < matrix_text[0].length; i++) {
        //     for (int j = 0; j < matrix_text.length; j++)
        //         matrix_text[j][i]=(text.charAt(k++))%97;

        // }
        // printarr(matrix_text);
        // text="";
        // int[][] matrix_cipher=matrix_multiply(key,matrix_text);
        return key;
    }
    public static int[][] matrix_multiply(int[][] key,int[][] matrix_text) {
        int[][] matrix_cipher=new int[key.length][matrix_text[0].length];
        ciphered_text="";
        for (int i = 0; i < matrix_text[0].length; i++) {
            for (int j = 0; j < key.length; j++) {
                int value=0;
                for (int k = 0; k <key.length ; k++) 
                    value+=key[j][k]*matrix_text[k][i];
                matrix_cipher[j][i]=(value%26);
                ciphered_text+=(char) ((value%26)+97);
                // ciphered_text.c
            }
        }
        return matrix_cipher;
    }
    public static void Decrypt(String cipher,int[][] key,int[][] matrix_cipher) {
        findinverse(key);
        matrix_multiply(key, matrix_cipher);
    }
    public static int[][] findinverse(int[][] key) {
        int det = ((((key[0][0]*key[1][1])-(key[0][1]*key[1][0]))+26)%26);
        System.out.println(det);
        // int det =23;
        for (int i = 1; i < det; i++) {
            int temp=det*i;
            if(temp%26==1){
                det=i;
                break;
            }
        }
        System.out.println(det);
        int temp = key[0][0];
        key[0][0]=key[1][1];
        key[1][1]=temp;
        key[1][0]*=-1;
        key[0][1]*=-1;
        printarr(key);
        for (int i = 0; i < key.length; i++) {
            for(int j=0;j<key.length;j++)
                key[i][j]=(key[i][j]*det)%26;
        }
        printarr(key);
        return key;
    }

    public static void printarr(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }
    }
}
