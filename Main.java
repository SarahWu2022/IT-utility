import java.util.*;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        int input, decimal;
        while (true) {
            System.out.println("1. Decimal to binary\n2. Binary to decimal\n3. IP to binary\n4. Modulo tool\n5. Log2n calculator\n6. 2^n calculator\n7. SNR to S/N\n8. Exit\nChoose a tool.");
            input = scanner.nextInt();
            switch (input) {
                case (1):
                    System.out.println("What is the decimal number?");
                    decimal = scanner.nextInt();
                    toBinary(decimal);
                    break;
                case (2):
                    System.out.println("What is the binary number?");
                    String binary = scanner.next();
                    toDecimal(binary);
                    break;
                case (3):
                    System.out.println("What is the IP address?");
                    String ip = scanner.next();
                    toIP(ip);
                    break;
                case (4):
                    System.out.println("What is d and z? (separate with space)");
                    try {
                        int d = scanner.nextInt();
                        int z = scanner.nextInt();
                        moduloTool(d, z);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                        break;
                    }
                case (5):
                    System.out.println("What is n?");
                    try {
                        int n = scanner.nextInt();
                        log2n(n);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                        break;
                    }
                case (6):
                    System.out.println("What is n?");
                    try {
                        int n = scanner.nextInt();
                        twoPowerN(n);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                        break;
                    }
                case (7):
                    System.out.println("What is SRN?");
                    int snr = scanner.nextInt();
                    SNRtoSN(snr);
                    break;
                case (8):
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

    private void toBinary(int decimal) {
        String binary;
        binary = Integer.toBinaryString(decimal);
        System.out.println("The binary number is: " + binary + "\n");
    }

    private void toDecimal(String binary) {
        int decimal;
        decimal = Integer.parseInt(binary, 2);
        System.out.println("The decimal number is: " + decimal + "\n");
    }

    private void toIP(String ip) {
        String[] ipArray = ip.split("\\.");
        String ogBinary;
        ArrayList<Integer> decimal = new ArrayList<Integer>();
        ArrayList<String> binary = new ArrayList<String>();
        try {
            for (int i = 0; i < 4; i++) {
                decimal.add(Integer.parseInt(ipArray[i]));
            }
            for (int decimalNumber : decimal) {
                ogBinary = String.format("%8s", Integer.toBinaryString(decimalNumber)).replace(' ', '0');
                binary.add(ogBinary);
            }
            System.out.println("The binary IP address is: " + binary + "\n");
        } catch (Exception e) {
            System.out.println("Do it again.");
        }
    }

    private void moduloTool(int d, int z) {
        int[] e = {3, 5, 7, 11, 13};
        for (int j : e)
            if (j * d % z == 1) {
                System.out.println("The modulo is: " + j + "\n");
                break;
            }
    }

    private void log2n(int n) {
        double log2n = (Math.log(n) / Math.log(2));
        System.out.println("The log2n is: " + log2n + "\n");
    }

    private void twoPowerN(int n) {
        double twoPowerN = Math.pow(2, n);
        System.out.println("The 2^n is: " + twoPowerN + "\n");
    }

    private void SNRtoSN(int snr) {
        double sn = Math.pow(10, snr / 10);
        System.out.println("The SN is: " + sn + "\n");
    }

}
