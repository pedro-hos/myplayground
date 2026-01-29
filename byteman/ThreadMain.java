import java.util.Scanner;

class ThreadMain {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            //DataInputStream in = new DataInputStream(System.in);
            String next = in.next();

            while (next != null && next.length() > 0 && !next.contains("end")) {
                final String arg = next;
                Thread thread = new Thread(arg) {
                    public void run() {
                        System.out.println(arg);
                    }
                };

                thread.start();

                try {
                    thread.join();
                } catch (Exception e){
                    e.printStackTrace();
                }

                next = in.next();

            }

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}