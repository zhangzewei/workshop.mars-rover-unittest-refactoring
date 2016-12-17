import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private static final List<String> VALID_COMMANDS = Arrays.asList("L", "R", "M", "B");
    private static final List<String> DIRECTIONS = Arrays.asList("N", "E", "S", "W");

    private static final int Y = 1;
    private static final int X = 0;

    public String d;
    // position which contains startingX and startingY
    private int[] p;

    public MarsRover(int startingX, int startingY, String direction) {
        this.p = new int[]{startingX, startingY};
        this.d = direction;
    }

    public String run(String input) {
        String[] commandArray = input.split("");

        validateCommands(input, commandArray);

        String[] commands = commandArray;

       for (String command : commands) {

            switch (command) {

                case "M":
                    move();
                    break;
                case "B":
                    turnRight();
                    turnRight();
                    move();
                    turnRight();
                    turnRight();
                    break;
                case "R":
                   turnRight();
                    break;
                case "L":
                    turnLeft();
                    break;
            }
        }

        return asString();
    }


    private void move() {
        if (d.equals("N")) {
            p[Y] += +1;
        } else if (d.equals("S")) {
            p[Y] += -1;
        } else if (d.equals("E")) {
            p[X] += +1;
        } else if (d.equals("W")) {
            p[X] += -1;
        }
    }

    private void turnLeft() {
        d = DIRECTIONS.get((DIRECTIONS.indexOf(d) + 3) % DIRECTIONS.size());
    }

    private void turnRight() {
        d = DIRECTIONS.get((DIRECTIONS.indexOf(d) + 1) % DIRECTIONS.size());
    }

    public static void validateCommands(String input, String[] commandArray) {
        for (String command : commandArray) {
            if (!VALID_COMMANDS.contains(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
    }

    private String asString() {
        return p[X] + " " + p[Y] + " " + d;
    }
}