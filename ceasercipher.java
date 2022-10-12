import java.util.Scanner;

public class ceasercipher{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key =3;
        System.out.print("Enter the Plain text:  ");
        String text = sc.nextLine();
        String result ="";
        for (int i = 0; i < text.length(); i++) {
            int c='a';
            char p = text.charAt(i);
            if(p==' '){
                result+=p;
                continue;
            }
            if(Character.isUpperCase(p)){
                c='A';
            }
            int temp=p-c;
            temp+=key;
            temp%=26;
            temp+=c;
            result+=(char) (temp);
        }
        System.out.println(result);
        sc.close();
    }
}