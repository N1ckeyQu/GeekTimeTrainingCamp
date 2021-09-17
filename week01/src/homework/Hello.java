package homework;

/**
 * 自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for
 * 然后自己分析一下对应的字节码，有问题群里讨论
 *
 * Classfile /D:/project/GeekTimeTrainingCamp/week01/src/out/Hello.class
 *   Last modified 2021-9-14; size 626 bytes
 *   MD5 checksum 354cfccd91a10ed8743ee3c845afce12
 *   Compiled from "Hello.java"
 * public class homework.Hello
 *   minor version: 0
 *   //Java 8的版本
 *   major version: 52
 *   //修饰符
 *   flags: ACC_PUBLIC, ACC_SUPER
 * //常量池
 * Constant pool:
 *    #1 = Methodref          #7.#19         // java/lang/Object."<init>":()V
 *    #2 = Float              4.1f
 *    #3 = Fieldref           #20.#21        // java/lang/System.out:Ljava/io/PrintStream;
 *    #4 = Methodref          #22.#23        // java/io/PrintStream.println:(F)V
 *    #5 = Methodref          #22.#24        // java/io/PrintStream.println:(I)V
 *    #6 = Class              #25            // homework/Hello
 *    #7 = Class              #26            // java/lang/Object
 *    #8 = Utf8               <init>
 *    #9 = Utf8               ()V
 *   #10 = Utf8               Code
 *   #11 = Utf8               LineNumberTable
 *   #12 = Utf8               main
 *   #13 = Utf8               ([Ljava/lang/String;)V
 *   #14 = Utf8               StackMapTable
 *   #15 = Class              #27            // "[Ljava/lang/String;"
 *   #16 = Class              #28            // "[I"
 *   #17 = Utf8               SourceFile
 *   #18 = Utf8               Hello.java
 *   #19 = NameAndType        #8:#9          // "<init>":()V
 *   #20 = Class              #29            // java/lang/System
 *   #21 = NameAndType        #30:#31        // out:Ljava/io/PrintStream;
 *   #22 = Class              #32            // java/io/PrintStream
 *   #23 = NameAndType        #33:#34        // println:(F)V
 *   #24 = NameAndType        #33:#35        // println:(I)V
 *   #25 = Utf8               homework/Hello
 *   #26 = Utf8               java/lang/Object
 *   #27 = Utf8               [Ljava/lang/String;
 *   #28 = Utf8               [I
 *   #29 = Utf8               java/lang/System
 *   #30 = Utf8               out
 *   #31 = Utf8               Ljava/io/PrintStream;
 *   #32 = Utf8               java/io/PrintStream
 *   #33 = Utf8               println
 *   #34 = Utf8               (F)V
 *   #35 = Utf8               (I)V
 * {
 *   //默认生成的无参构造方法
 *   public homework.Hello();
 *     descriptor: ()V
 *     //修饰符
 *     flags: ACC_PUBLIC
 *     Code:
 *       //栈深为1，本地变量表容量为1
 *       stack=1, locals=1, args_size=1
 *          //栈操作指令，将本地变量表中的第0个位置的变量load到栈上，a表示这是个引用变量
 *          0: aload_0
 *          //#1表示常量池中的第一个常量，调用它的父类Object类的init方法
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         //字节偏移量为0的操作指令，对应实际代码中的第8行
 *         line 8: 0
 *
 *   //main方法
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     //修饰符
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       //栈的深度为4，本地变量表的容量为10
 *       stack=4, locals=10, args_size=1
 *          //常量池中第二个常量4.1f，从运行时常量池中压栈到操作数栈上
 *          0: ldc           #2                  // float 4.1f
 *          //刚才压栈的float类型的数，store到本地变量表中进行保存
 *          2: fstore_1
 *          //byte类型的数转换成int类型的数，并压栈到操作数栈上
 *          3: bipush        98
 *          //栈中第二个int类型的数，store到本地变量表中进行保存
 *          5: istore_2
 *          //本地变量表中第二个int类型的数，load到操作数栈上
 *          6: iload_2
 *          //数据从int类型转为float类型
 *          7: i2f
 *          //本地变量表中第一个float类型的数，load到操作数栈上
 *          8: fload_1
 *          //两个float类型的数字做加法
 *          9: fadd
 *         //将计算结果store到本地变量表中保存
 *         10: fstore_3
 *         //这个指令的意思是“取出字段的值，并压栈到操作数栈上”
 *         11: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         //从本地变量表中加载第3个数
 *         14: fload_3
 *         //打印刚才的加法计算结果
 *         15: invokevirtual #4                  // Method java/io/PrintStream.println:(F)V
 *         //常量压入栈中
 *         18: iconst_1
 *         //store回本地变量表中第4个
 *         19: istore        4
 *         //int值为5入栈
 *         21: iconst_5
 *         //创建int类型数组
 *         22: newarray       int
 *         //第24行到第43行，都是在往数组里灌数据
 *         24: dup
 *         //数组下标
 *         25: iconst_0
 *         //下标对应的数据
 *         26: iconst_1
 *         //将栈顶int类型值保存到指定int类型数组的指定项
 *         27: iastore
 *         28: dup
 *         29: iconst_1
 *         30: iconst_2
 *         31: iastore
 *         32: dup
 *         33: iconst_2
 *         34: iconst_3
 *         35: iastore
 *         36: dup
 *         37: iconst_3
 *         38: iconst_4
 *         39: iastore
 *         40: dup
 *         41: iconst_4
 *         42: iconst_5
 *         43: iastore
 *         //灌好数据的数组存入本地变量表
 *         44: astore        5
 *         //数组load回栈上
 *         46: aload
 *         //int[] var6 = arr;
 *         48: astore        6
 *         //加载6
 *         50: aload         6
 *         //获取一维数组长度
 *         52: arraylength
 *         //把一维数组的长度store回本地变量表
 *         53: istore        7
 *         //就是ini i=0
 *         55: iconst_0
 *         56: istore        8
 *         58: iload         8
 *         60: iload         7
 *         //判断i是否大于等于数组长度
 *         62: if_icmpge     91
 *         //进入循环，把数组load到栈上
 *         65: aload         6
 *         //i=0也load到栈上
 *         67: iload         8
 *         //从int类型数组中装载指定项的值，就是arr[i],i=0
 *         69: iaload
 *         //拿到数组中第0个元素后，store回本地变量表
 *         70: istore        9
 *         //load到栈上
 *         72: iload         9
 *         //常量2压入栈顶
 *         74: iconst_2
 *         //比较大小，结果为true继续，false直接goto
 *         75: if_icmple     85
 *         //加载i1
 *         78: iload         4
 *         //加载当前循环的arr[i]
 *         80: iload         9
 *         //i1和arr[i]相加
 *         82: iadd
 *         //将和存入本地变量表的4号slot
 *         83: istore        4
 *         //i++
 *         85: iinc          8, 1
 *         88: goto          58
 *         91: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         94: iload         4
 *         //打印
 *         96: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
 *         99: return
 *       LineNumberTable:
 *         line 11: 0
 *         line 12: 3
 *         line 13: 6
 *         line 14: 11
 *         line 17: 18
 *         line 18: 21
 *         line 19: 46
 *         line 20: 72
 *         line 21: 78
 *         line 19: 85
 *         line 24: 91
 *         line 25: 99
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *            72      13     9     i   I
 *             0     100     0  args   [Ljava/lang/String;
 *             3      97     1    f1   F
 *             6      94     2    c1   C
 *            11      89     3    f2   F
 *            21      79     4    i1   I
 *            46      54     5   arr   [I
 *       StackMapTable: number_of_entries = 3
 *         frame_type = 255 / full_frame /
 * offset_delta=58
 * locals=[class "[Ljava/lang/String;",float,int,float,int,class "[I",class "[I",int,int]
 * stack=[]
 * frame_type=26 / same /
 * frame_type=248 / chop /
 * offset_delta=5
 *
 * }
 * SourceFile:"Hello.java"
 */
public class Hello {
    public static void main(String[] args) {
        /**
         * 注释中的字节码和这里不对应，这里原本还有一段四则运算的代码，忘记commit了..
         * 但是循环的字节码是完整的
         */
        int i1 = 1;
        int[] arr = new int[]{1,2,3,4,5};
        for (int i : arr) {
            if (i > 2) {
                i1 += i;
            }
        }
        System.out.println(i1);
    }
}
