package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        RoboticDog roboticDog = new RoboticDog();
        Human human = new Human();
        Runner cat = new Cat();

        ArrayList<Runner> arrayList = new ArrayList<>();
        arrayList.add(roboticDog);
        arrayList.add(human);
        arrayList.add(cat);

        // Runner.type = "haha hacked!";
        for (Runner runner: arrayList) {
            runner.run();
            System.out.println(runner.type);
        }
    }
}
