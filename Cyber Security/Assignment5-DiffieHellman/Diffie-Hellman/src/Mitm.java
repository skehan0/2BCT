
class Mitm {
    private static long power(long a, long b, long p) {
        if (b == 1)
            return a;
        else
            return (((long) Math.pow(a, b)) % p);
    }

    public static void main(String[] args) {
        long P, G, x, a, y, b, z, c, w, d, ga, gb, gc, gd, S1, S2;

        // A prime number P is taken
        P = 13;
        System.out.println("The value of P: " + P);

        // A primitive root for P, G is taken
        G = 6;
        System.out.println("The value of G: " + G + "\n");

        // Alice will choose the private key a
        // a is the chosen private key
        a = 5;
        System.out.println("The private key a for Alice(a): " + a);

        // Gets the generated key
        x = power(G, a, P);

        // Bob will choose the private key b
        // b is the chosen private key
        b = 2;
        System.out.println("The private key b for Bob(b): " + b + "\n");

        // Gets the generated key
        y = power(G, b, P);


        // Mallory will choose two random numbers (c)
        c = 72;
        System.out.println("Mallory selected private number for Alice(c): " + c);

        // Gets the generated key
        z = power(G, c, P);

        // Mallory will choose two random numbers (d)
        d = 134;
        System.out.println("Mallory selected private number for Bob(d): " + d + "\n");

        // Gets the generated key
        w = power(G, d, P);

        ga = power(y, a, P); // Secret key for Alice
        gb = power(x, b, P); // Secret key for Bob
        gc = power(w, c, P); // Secret key from mallory for Alice
        gd = power(z, d, P); // Secret key from mallory for Bob

        S1 = power(G, d, a)%P; // Alice
        S2 = power(G, c, b)%P; // Bob

        System.out.println("Secret key for Alice is(ga): " + ga);
        System.out.println("Secret key for Bob is(gb): " + gb + "\n");
        System.out.println("Eve published value for Alice (gc): " + gc);
        System.out.println("Eve published value for Bob (gd): " + gd + "\n");
        System.out.println("Alice computed (S1): " + S1);
        System.out.println("Mallory computed key for Alice (S1): " + S1 + "\n");
        System.out.println("Bob computed (S2): " + S2);
        System.out.println("Mallory computed key for Bob (S2): " + S2);

    }
}