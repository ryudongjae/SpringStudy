package ryudongjae.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private int age;
    private String name;

    public static void main(String[] args) {
        HelloLombok hl = new HelloLombok();

        hl.setAge(2);

        int age = hl.getAge();
        System.out.println("age = " + age);

    }
}
