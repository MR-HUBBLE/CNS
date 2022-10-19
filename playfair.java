import java.util.*;

public class playfair {
    static char[][] Table = new char[5][5];
    static Scanner sc = new Scanner(System.in);
    static Map<Character, int[]> map = new HashMap<>();
    static String key = "", text = "";

    public static void main(String[] args) {
        System.out.print("Enter the keyword: ");
        key = sc.nextLine();
        System.out.print("Enter the Plain text: ");
        text = sc.nextLine();
        diagram();
        text();
        encrypt();
    }
    public static void diagram() {
        char c = 'a';
        for (int i = 0, k = 0; i < Table.length; i++) {
            for (int j = 0; j < Table.length; j++) {
                int temp[] = { i, j };
                if (k < key.length()) {
                    Table[i][j] = key.charAt(k);
                    map.put(key.charAt(k++), temp);
                    continue;
                }
                while (key.indexOf(c) > -1 || c == 'j') c++;
                Table[i][j] = c;
                map.put(c++, temp);
            }
        }
        System.out.println("The Diagram : ");
        printarr();
    }

    public static void text() {
        for (int i = 0; i < text.length() - 1; i += 2) {
            if (text.charAt(i) == text.charAt(i + 1))
                text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
        }
        if (text.length() % 2 != 0) text += 'x';
        System.out.println("Plain text: "+text);
    }

    public static void encrypt() {
        String Cipher_text = "";
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i),b = text.charAt(i + 1);
            if (a == 'j') a = 'i';
            if (b == 'j') b = 'i';
            int arow = map.get(a)[0], acol = map.get(a)[1];
            int brow = map.get(b)[0], bcol = map.get(b)[1];
            if (arow == brow) {
                acol++; bcol++;
                acol%=5;bcol%=5;
            } else if (acol == bcol) {
                arow++; brow++;
                arow%=5;brow%=5;
            } else {
                int temp = acol;
                acol = bcol;
                bcol = temp;
            }
            Cipher_text += Table[arow][acol];
            Cipher_text += Table[brow][bcol];
        }
        System.out.println("Ciphered text: " + Cipher_text);
    }
    public static void printarr() {
        for (int i = 0; i < Table.length; i++) {
            System.out.println(" --- --- --- --- ---");
            System.out.print("|");
            for (int j = 0; j < Table[0].length; j++) {
                System.out.print(" "+Table[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println(" --- --- --- --- ---");
    }
}
