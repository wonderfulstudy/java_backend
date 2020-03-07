package jar;

class Person{
    /**
     * 建立一个人类（Person）和学生类（Student）功能要求如下：
     *  1.Person中包含4个私有型的数据成员name、addr、sex、age，分别为
     *      字符串、字符串、字符、及整型，表示姓名、地址、性别和年龄。
     *      一个4参构造方法、一个两参构造方法、一个无参构造方法、
     *      一个输出方法显示4中属性。
     *  2.Student类继承Person类，并增加成员math、English存放数学和英语成绩。
     *      一个6参构造方法、一个两参构造方法、一个无参构造方法和重写输出方法用
     *      于显示6中属性。
     * @param args
     */
    private String name;
    private String addr;
    private char sex;
    private int age;

    public Person(){}
    public Person(String name, String addr){
        this(name, addr, '男', 18);
    }
    public Person(String name, String addr, char sex, int age){
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
    }

    // getter、setter略

    public String getInfo(){
        return "姓名："+this.name+"、住址："+this.addr+"、性别："+this.sex+"、年龄："+this.age;
    }
}

class Student extends Person{
    private double math;
    private double english;

    public Student(){}
    public Student(String name, String addr){
        super(name, addr);
    }
    public Student(String name, String addr, char sex, int age, double math, double english){
        super(name, addr, sex, age);
        this.math = math;
        this.english = english;
    }

    // getter、setter略

    public String getInfo(){
        return super.getInfo()+"、数学成绩："+this.math+"、英语成绩："+this.english;
    }
}

public class Demo008{
    public static void main(String[] args) {
        Student stu = new Student("李杰", "成都市", '男', 23, 80.00, 95.00);
        System.out.println(stu.getInfo());
    }
}