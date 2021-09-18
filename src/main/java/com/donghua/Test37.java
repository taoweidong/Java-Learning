package com.donghua;

public class Test37 {

    public static void main(String[] args) throws Exception {

        Father father = new Child();
        father.say();

    }

}

class Father {

    public void say() {

        System.out.println("father");
    }
}

class Child extends Father {

    @Override
    public void say() {

        super.say();
        System.out.println("Child");
    }
}
