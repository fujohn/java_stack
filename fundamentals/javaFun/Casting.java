class Casting {
    public static void main(String[] args) {
        double d = 35.25;
        double dd = 35.99;
        
        // casting the double d into a int
        int x = (int) d;
        
        // casting the double dd into a int (will always round down/trim decimals altogether)
        int ii = (int) dd;

        System.out.println(x);
        System.out.println(ii);


        int g = 35;
        float f = g;
        System.out.println("The number is: " + f);
    
        // long start = System.currentTimeMillis();
        // Integer sum = 0;
        // for (int i = 0; i < Integer.MAX_VALUE; i++) {
        //     sum += i;
        // }
        // System.out.println("Sum: " + sum);
        // long end = System.currentTimeMillis();
        // double total = (double) (end - start) / 1000;
        // System.out.println("Time of execution: " + total + " seconds");

        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        long end = System.currentTimeMillis();
        double total = (double) (end - start) / 1000;
        System.out.println("Time of execution: " + total + " seconds");

        Integer a = 10;
        int b = 10;
        a = null;
        // b = null; // not possible
    }
}

