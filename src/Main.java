import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        L2List l = new L2List(n);
        for(int i = 0; i < n; i++) {
            l.insertFront((int) (Math.random() * 10));
        }
        try {
            for(int i = 0; i < n; i++){
                if(l.end())
                    l.toFront();
                System.out.println(l.after());
                l.forward();
            }
        }
        catch (Exception e){
            l.toFront();
        }
        System.out.println();
        try {
            l.toBack();
            for(int i = 0; i < n; i++){
                if(l.begin())
                    l.toBack();
                System.out.println(l.before());
                l.backward();
            }
        }
        catch (Exception e){
            l.toBack();
        }
    }
}
