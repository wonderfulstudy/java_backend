package jar;

class Person{
    String name;
    int age;
    long number;
    String classRoom;

    public Person(){
        this("无名氏",-1,001,"未分班");
    }
    public Person(String name,int age){
        this(name,age,001,"未分班");
    }
    public Person(String name,int age,long number){
        this(name,age,number,"未分班");
    }
    public Person(String name,int age,long number,String classRoom){
        this.name=name;
        this.age=age;
        this.number=number;
        this.classRoom=classRoom;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public long getNumber(){
        return this.number;
    }
    public void setNumber(long number){
        this.number=number;
    }

    public String getClassRoom(){
        return this.classRoom;
    }
    public void setAge(String classRoom){
        this.classRoom=classRoom;
    }

    public void tell(){
        System.out.println("姓名："+this.name+
                            "、年龄："+this.age+
                            "、学号："+this.number+
                            "、班级："+this.classRoom);
    }
}

public class Demo006{
    /**
     * Java实战：简单的Java类的实现
     * 
     */
    public static void main(String[] args){
        Person per=new Person("李杰",18,10000,"通信161班");
        per.tell();
    }
}