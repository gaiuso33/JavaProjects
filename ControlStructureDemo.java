public class ControlStructureDemo {

    public static void main(String[] args) {

        // 🔹 Sequential Control
        System.out.println("Sequential Control Structure:");
        int a = 10;
        int b = 5;
        int sum = a + b;
        System.out.println("Sum of " + a + " and " + b + " is " + sum);
        System.out.println();

        // 🔹 Selection Control - if, if-else, switch
        System.out.println("Selection Control Structure:");

        if (a > b) {
            System.out.println(a + " is greater than " + b);
        } else {
            System.out.println(b + " is greater or equal to " + a);
        }

        int grade = 85;
        if (grade >= 90) {
            System.out.println("Grade: A");
        } else if (grade >= 80) {
            System.out.println("Grade: B");
        } else {
            System.out.println("Grade: C or lower");
        }

        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Today is Monday");
                break;
            case 2:
                System.out.println("Today is Tuesday");
                break;
            case 3:
                System.out.println("Today is Wednesday");
                break;
            default:
                System.out.println("Another day");
        }
        System.out.println();

        // 🔹 Iteration Control - for, while, do-while
        System.out.println("Iteration Control Structure:");

        // for loop
        System.out.println("For Loop:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }

        // while loop
        System.out.println("While Loop:");
        int j = 1;
        while (j <= 3) {
            System.out.println("j = " + j);
            j++;
        }

        // do-while loop
        System.out.println("Do-While Loop:");
        int k = 1;
        do {
            System.out.println("k = " + k);
            k++;
        } while (k <= 3);
        System.out.println();

        // 🔹 Branching Control - break, continue, return
        System.out.println("Branching Control Structure:");

        // break
        for (int x = 1; x <= 5; x++) {
            if (x == 3) {
                System.out.println("Break at x = " + x);
                break;
            }
            System.out.println("x = " + x);
        }

        // continue
        for (int y = 1; y <= 5; y++) {
            if (y == 3) {
                System.out.println("Skip y = " + y);
                continue;
            }
            System.out.println("y = " + y);
        }

        // return
        System.out.println("Calling methodWithReturn:");
        methodWithReturn();

        System.out.println("Program Ended Normally");
    }

    static void methodWithReturn() {
        System.out.println("Inside methodWithReturn");
        return;
    }
}
