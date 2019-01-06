import java.awt.*;
import java.util.Random;

public class MouseMover {
    private static final int SLEEP = 120000;
    private static int MAX_Y = 1;
    private static int MAX_X = 1;

    public static void main(String... args) throws Exception {
        Robot robot = new Robot();

        Point lastPoint = MouseInfo.getPointerInfo().getLocation();

        while (true) {

            Point newPoint = MouseInfo.getPointerInfo().getLocation();

            if(newPoint.equals(lastPoint)) {
                Random random = new Random();
                MAX_X = MAX_X * (random.nextInt()%2 == 0 ? 1 : -1);
                MAX_Y = MAX_Y * (random.nextInt()%2 == 0 ? 1 : -1);

                robot.mouseMove(newPoint.x+MAX_X ,  newPoint.y+MAX_Y);
                Thread.sleep(SLEEP);
            }

            lastPoint = newPoint;
        }
    }
}
