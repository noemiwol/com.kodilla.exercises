package com.kodilla.agnet;

import net.bytebuddy.asm.Advice;

public class MyMethodMonitor {
    @Advice.OnMethodEnter
    public static void enter(@Advice.Origin Class clazz, @Advice.Origin("#m") String methodName) {
        System.out.println("The user agent is running: " + methodName);
    }

    @Advice.OnMethodExit
    public static void exit() {
        System.out.println("Done.");
    }
}
