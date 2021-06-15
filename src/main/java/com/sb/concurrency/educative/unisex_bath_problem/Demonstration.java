package com.sb.concurrency.educative.unisex_bath_problem;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        final UnisexBathroom unisexBathroom = new UnisexBathroom();

        Thread firstFemale = new Thread(() -> {
            try {
                unisexBathroom.femaleUseBathroom("Female1");
            } catch (InterruptedException ie) {
                //noop
            }
        });

        Thread firstMale = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("Male1");
            } catch (InterruptedException ie) {
                // noop
            }
        });

        Thread secondMale = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("Male2");
            } catch (InterruptedException ie) {
                // noop
            }
        });

        Thread thirdMale = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("Male3");
            } catch (InterruptedException ie) {
                // noop
            }
        });

        Thread fourthMale = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("Male4");
            } catch (InterruptedException ie) {
                // noop
            }
        });

        firstFemale.start();
        firstMale.start();
        secondMale.start();
        thirdMale.start();
        fourthMale.start();

        firstFemale.join();
        firstMale.join();
        secondMale.join();
        thirdMale.join();
        fourthMale.join();
    }
}
