# Java进阶训练营第一周

## 基础知识

Java是一门面向对象、静态类型、编译执行、有VM和GC、跨平台的高级语言。所有的Java程序都应运行在Java虚拟机之上。GC直译就是垃圾回收器，它其实是Java虚拟机的内存管理器

### 和其它语言比较

- C/C++

  需要手动管理内存，有内存泄漏风险

- Java/Golang

  无需手动管理内存，由Java虚拟机帮我们管理，当内存使用有问题时，需要对JVM进行分析和调优

- Rust

  它不像Java那样有着愚蠢的NPE，因为它在编译程序的时候帮助你检查类似的错误，从而去避免它。因此写Rust时必须清楚如何根据Rust指定的规则来管理好我们的变量，因此代码不易理解，且学习成本较高

### 跨平台的核心技术

Java程序编译成字节码文件/jar包后，分发到不同的操作系统上，只要该系统中有jre，就可以运行此Java程序。它的运行流程大概是这样：通过Java虚拟机内部的类加载器，把字节码文件加载到虚拟机内部，然后将它们转化成Java对象，再通过运行Java对象的方法，启动整个Java程序

- 字节码文件
- 类加载器
- 虚拟机的内存管理（GC）

## 字节码文件

Java字节码由单字节的**指令**组成，理论上最多支持256个操作码（opcode）。实际上Java只使用了200左右的操作码，还有一些操作码则保留给调试操作

根据指令的性质，主要分为4个大类

- 栈操作指令，包括与局部变量交互的指令

  我们可以把Java虚拟机看作一台电脑，电脑执行指令有基于寄存器的，也有基于栈的，Java虚拟机就是基于栈的。这类指令跟我们写的Java代码并没有直接关系

- 程序流程控制指令，比如写业务代码经常会用到的循环、ifelse等等

- 对象操作指令，包括方法调用指令

- 算术运算以及类型转换指令

### .class文件

源文件

```java
public class HelloJavaByteCode {
    public static void main(String[] args) {
        HelloJavaByteCode obj = new HelloJavaByteCode();
    }
}
```

字节码

```java
public class com.learn.HelloJavaByteCode {
    //每个类默认的无参构造
    public com.learn.HelloJavaByteCode();
      //虚拟机会依次执行这些操作指令，0、1、4都是字节的偏移量
      Code:
         //栈操作指令，将本地变量表中的第0个位置的变量load到栈中。a表示这是个引用变量
         0: aload_0
         //调用其父类Object类的init方法，#1是常量池中的一个常量
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
 
    public static void main(java.lang.String[]);
      Code:
         //从常量池中拿到标号2这个类型的名字，也就是HelloJavaByteCode这个类，将它new出来
         0: new           #2                  // class com/learn/HelloJavaByteCode
       	 //压栈
         3: dup
       	 //调用该类的init方法，#3是常量池中的一个常量
         4: invokespecial #3                  // Method "<init>":()V
         //将new出来的对象通过store命令，将它的引用放到本地变量表的标号为1的位置上，保存
         7: astore_1
         8: return
  }
```

先看第一段字节码，0、1、4都是字节的偏移量。第一条指令/操作码占了一个字节
第二个指令/操作码```invokespecial #1```，它占用的字节数为4-1=3，说明该指令除了一个字节的操作码之外，还可以有两个字节的操作数

### 字节码的运行时结构

<img src="https://cdn.jsdelivr.net/gh/N1ckeyQu/picBed/img/jvm%20stack.png" style="zoom: 50%;" />

JVM是一台基于栈的计算机，每个线程都有一个独属于自己的线程栈，用于存储栈帧，每一次方法调用，JVM都会自动创建一个栈帧

<img src="C:\Users\N1ckeyHouse\AppData\Roaming\Typora\typora-user-images\image-20210913122113631.png" alt="image-20210913122113631" style="zoom: 33%;" />

栈帧由操作数栈、局部变量数组以及一个class引用组成。class引用指向当前方法在运行时常量池中对应的class。可以看到局部变量数组就相当于磁盘，操作数栈就相当于CPU做计算，class引用又包含了当前使用到的所有常量的常量池

## 类加载器

### 类的生命周期

- 加载
- 验证
- 解析
- 准备
- 初始化
- 使用
- 卸载

验证~准备可以简化为链接（Linking），前五个步骤我们称为类的加载过程

### 类的加载时机

#### 显式加载

- 当虚拟机启动时，初始化用户指定的主类，就是启动执行的main方法所在的类
- 当遇到用以新建目标类实例的new指令时，初始化我们new的那个类
- 当遇到调用静态方法的指令时，初始化该静态方法所在的类
- 当遇到访问静态字段的指令时，初始化该静态字段所在的类

#### 隐式加载

- 子类的初始化会触发父类的初始化
- 如果接口定义了default方法，当该接口的实现类被初始化时，该接口也会被初始化
- 反射调用类时，需要初始化
- 初次调用MethodHandle实例时，初始化该MethodHandle指向的方法所在的类

### 三类加载器

- 启动类加载器 BootstrapClassLoader
- 扩展类加载器 ExtClassLoader
- 应用类加载器 AppClassLoader

它们的层级关系：启动类加载器 > 扩展类加载器 > 应用类加载器 > 自定义加载器

### 类加载器的特点

- 双亲委派

  比如我们现在在我们自己写的一个Java程序里run了main方法，理所当然的，我们需要先将此类进行加载。但应用类加载器不会直接加载该类，而是会先交给它的父类——扩展类加载器进行加载。同样的，扩展类加载器会先交给启动类加载器尝试，这样一层层的向上委托。如果父类加载器可以完成类的加载，就成功返回；否则子类加载器才会尝试自己去加载，这就是双亲委派

  它的好处在于通过这样一层层的向上委托，从而避免了多个类加载器重复加载同一个类的情况

- 缓存

- 负责依赖



## JVM内存模型



## JVM启动参数

- 系统属性参数
- 运行模式参数
- 堆内存设置参数
- GC设置参数
- 分析诊断参数
- JavaAgent参数