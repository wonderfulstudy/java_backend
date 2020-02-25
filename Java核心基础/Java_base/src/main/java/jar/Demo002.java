package jar;

public class Demo002{
    public static void main(String[] args) {
        int x=10;
        double y=20.2;
        long z=10L;
        String str=""+x+y*z;//y*z自动提升为double类型
        System.out.println(str);
    }
}