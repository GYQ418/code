import java.util.Scanner;
//-------------------------------------
class MyException extends Exception//定义自己的异常
{
    MyException(String  message)
    {
        super(message);//将异常信息给父类
    }
}
//---------------------------------------
abstract class Fruit{
    int unitPrice;
    int amount;
    double discount=1;
    public abstract double count(int unitPrice,int amount,double discount);
    public abstract void display();
}
//------------------------------------------------------
abstract class People{
    int a;
    int s;
    int m;
}
//--------------------------------------------------------
class Apple extends Fruit{
    Apple(int unitPrice,int amount,double discount){
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.discount = discount;
    }
    public void display(){
        System.out.println(""+discount+"");
    }
    public double count(int unitPrice,int amount,double discount){
        return unitPrice*amount*discount;
    }
}
class StrawBerry extends Fruit{
    StrawBerry(int unitPrice,int amount,double discount){
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.discount = discount;
    }
    public void display(){
        System.out.println(""+discount+"");
    }
    public double count(int unitPrice,int amount,double discount){
        return unitPrice*amount*discount;
    }
}
class Mango extends Fruit{
    Mango(int unitPrice,int amount,double discount){
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.discount = discount;
    }
    public void display(){
        System.out.println(""+discount+"");
    }
    public double count(int unitPrice,int amount,double discount){
        return unitPrice*amount*discount;
    }
}
//------------------------------------------------------
class A extends People{
    A(int a,int s){
        this.a = a;
        this.s = s;
//        this.m = m;
        Apple apple = new Apple(8,a,1);
        StrawBerry strawberry = new StrawBerry(13,s,1);
//        Mango mango = new Mango(20,m,1);
        double Aa = apple.count(8,a,1);
        double As = strawberry.count(13,s,1);
//        double Am = mango.count(20,m,1);
        double sum = Aa+As;
        System.out.println("A购买的商品总价为"+sum+"元！");
    }
}
class B extends People{
    B(int a,int s,int m){
        this.a = a;
        this.s = s;
        this.m = m;
        Apple apple = new Apple(8,a,1);
        StrawBerry strawberry = new StrawBerry(13,s,1);
        Mango mango = new Mango(20,m,1);
        double Ba = apple.count(8,a,1);
        double Bs = strawberry.count(13,s,1);
        double Bm = mango.count(20,m,1);
        double sum = Ba+Bs+Bm;
        System.out.println("B购买的商品总价为"+sum+"元！");
    }
}
class C extends People{//---------------折扣--------------------
    C(int a,int s,int m){
        this.a = a;
        this.s = s;
        this.m = m;
        Apple apple = new Apple(8,a,1);
        StrawBerry strawberry = new StrawBerry(13,s,0.8);
        Mango mango = new Mango(20,m,1);
        double Ca = apple.count(8,a,1);
        double Cs = strawberry.count(13,s,0.8);
        double Cm = mango.count(20,m,1);
        double sum = Ca+Cs+Cm;
        System.out.println("C购买的商品总价为"+sum+"元！");
    }
}
class D extends People{////------------满减--------------------
    D(int a,int s,int m){
        this.a = a;
        this.s = s;
        this.m = m;
        Apple apple = new Apple(8,a,1);
        StrawBerry strawberry = new StrawBerry(13,s,1);
        Mango mango = new Mango(20,m,1);
        double Da = apple.count(8,a,1);
        double Ds = strawberry.count(13,s,1);
        double Dm = mango.count(20,m,1);
        double sum = Da+Ds+Dm;
        if(sum >= 100){
            sum = sum-10;
        }
        System.out.println("D购买的商品总价为"+sum+"元！");
    }
}
//-------------------------------------------------------------
public class Main{
    public static void main (String[] args) throws MyException{
        System.out.println("请输入11个0或正整数的数字并以英文逗号分隔开，结尾不用再加逗号");
        //获取输入
        Scanner in = new Scanner(System.in);//获取的是一个字符串
        //获取键盘输入的字符串
        String str = in.next();
        //将这个字符串分隔开:string.split()
        String[] strings = str.split(",");
        //将字符串组转化为整型数组
        int n = strings.length;//数组的长度
        if(n != 11){
            throw new MyException("需要输入11个数字");
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if(Double.parseDouble(strings[i]) % 1 != 0){
                throw new MyException("需要输入整数");
            }
            nums[i] = Integer.parseInt(strings[i]);
            if(nums[i] < 0){
                throw new MyException("水果斤数为大于等于0的整数");
            }
        }
        //处理输入的值，转类型
        //-----------------------------
        A a = new A(nums[0],nums[1]);
        B b = new B(nums[2],nums[3],nums[4]);
        C c = new C(nums[5],nums[6],nums[7]);
        D d = new D(nums[8],nums[9],nums[10]);
    }
}
