/***
 * 
 * 使用for循环实现数组操作降序排序
 */

public class demo001 {
    public static void main(String[] args){
        int[] ns = {1,4,9,16,25};
        for (int i=ns.length-1; i>=0; i--){
            System.out.println(ns[i]);
        }
    }
}