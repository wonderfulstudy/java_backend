package jar;

public class Demo001{
    public static void main(String[] args) {
        int i=1;
        int j=i++;//j=1,i=2
        if(i==(++j)&&(i++)==j){//i==2&&i=j,i=2,j=2
            //if结果为true,i=3,j=2
            i+=j;//i=5
        }
        System.out.println("i="+i);
    }
}