package ua;
import ua.FirstClass.FirstClass;
import ua.SecondClass.SecondClass;
import ua.ThirdClass.ThirdClass;

public class Main {

    public static void main(String[] args){
       // FirstClass A = new FirstClass();

        System.out.println(new FirstClass().getClass().getName());
        System.out.println(new SecondClass().getClass().getName());
        System.out.println(new ThirdClass().getClass().getName());
    }
}

