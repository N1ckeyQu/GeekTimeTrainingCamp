package homework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 * 第一周第二题
 */
public class XlassClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        //实例化
        Object hello = new XlassClassLoader().findClass("Hello").newInstance();
        //获取class
        Class<?> helloClass = hello.getClass();
        //获取类中的hello方法
        Method method = helloClass.getDeclaredMethod("hello", null);
        //public方法，直接invoke
        method.invoke(hello);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] readAllBytes = new byte[0];
        try {
            //获取文件中的字节流
            readAllBytes = Files.readAllBytes(new File("D:\\project\\GeekTimeTrainingCamp\\week01\\src\\homework\\Hello.xlass").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //解码
        for (int i = 0; i < readAllBytes.length; i++) {
            readAllBytes[i] = (byte) (255 - readAllBytes[i]);
        }
        return defineClass(name, readAllBytes, 0, readAllBytes.length);
    }
}
