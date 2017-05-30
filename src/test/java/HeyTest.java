import servlets.Hey;

/**
 * Created by s.kremlev on 30.05.2017.
 */
public class HeyTest {
    public static void main(String[] args) throws InterruptedException {
        Hey hey = new Hey();
        hey.start();
        Thread.sleep(10000);
    }
}