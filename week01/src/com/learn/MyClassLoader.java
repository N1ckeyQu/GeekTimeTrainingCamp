package com.learn;

import java.util.Base64;

/**
 * @Class: MyClassLoader
 * @Description:
 * @Author: Jerry Qu
 * @Create: 2021-09-14 15:10:51
 */
public class MyClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {
        new MyClassLoader().findClass("com.learn.Hello").newInstance();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classStr = "yv66vgAAADQAHwoABgARCQASABMIABQKABUAFgcAFwcAGAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQARTGNvbS9sZWFybi9IZWxsbzsBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABkMABoAGwEAEuS9oOWlve+8jOS4lueVjO+8gQcAHAwAHQAeAQAPY29tL2xlYXJuL0hlbGxvAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACAABAAkAAAAvAAEAAQAAAAUqtwABsQAAAAIACgAAAAYAAQAAAAMACwAAAAwAAQAAAAUADAANAAAACAAOAAgAAQAJAAAAJQACAAAAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABQAIAAYAAQAPAAAAAgAQ";
        byte[] decode = Base64.getDecoder().decode(classStr);
        return defineClass(name, decode, 0, decode.length);
    }
}
