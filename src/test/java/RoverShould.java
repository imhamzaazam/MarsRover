import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RoverShould {
    private Coordinate coordinate;
    private Rover rover;
    private char[] commands;

    private Sphere sphere;
    public final int MAX_WIDTH=5;

    @Before()
    public void beforeRoverTest() {
        coordinate = new Coordinate(0, 0, Direction.NORTH);
        sphere = new Sphere(5,5);
        rover = new Rover(coordinate, sphere);
        commands = new char[]{'L', 'R'};


    }
    @Test
    public void haveInitialStartingPoint() {
        assertThat(rover.getCoordinate()).isEqualToComparingFieldByField(coordinate);
    }
    @Test
    public void haveInitialDirection(){
        assertThat(rover.getCoordinate().getDirection()).isEqualTo(Direction.NORTH);
    }
    @Test
    public void receiveArrayOfCommands(){
        rover.followCommands(commands);
        assertThat(commands).isNotEmpty();
    }

    @Test
    public void moveForwardInNorthDirection(){
        char[] forwardCommand = new char[]{'F'};
        int expected = rover.getCoordinate().getyCoordinate()+1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveBackwardsInNorthDirection(){
        char[] backwardCommand = new char[]{'B'};
        int expected = 5;
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveForwardInSouthDirection(){
        char[] forwardCommand = new char[]{'F'};
        rover.getCoordinate().setDirection(Direction.SOUTH);
        int expected = 5;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);

    }
    @Test
    public void moveBackwardInSouthDirection(){
        char[] forwardCommand = new char[]{'B'};
        rover.getCoordinate().setDirection(Direction.SOUTH);
        int expected = rover.getCoordinate().getyCoordinate()+1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);

    }
    @Test
    public void moveForwardInEastDirection(){
        char[] forwardCommand = new char[]{'F'};
        rover.getCoordinate().setDirection(Direction.EAST);
        int expected = rover.getCoordinate().getxCoordinate()+1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveBackwardsInEastDirection(){
        char[] forwardCommand = new char[]{'B'};
        rover.getCoordinate().setDirection(Direction.EAST);
        int expected = 5;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveForwardInWestDirection(){
        char[] forwardCommand = new char[]{'F'};
        rover.getCoordinate().setDirection(Direction.WEST);
        int expected = 5;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }
    //check again
    @Test
    public void moveBackwardsInWestDirection(){
        char[] backwardCommand = new char[]{'B'};
        rover.getCoordinate().setDirection(Direction.WEST);
        int expected = rover.getCoordinate().getxCoordinate()+1;
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }

    @Test
    public void wrapWhenMovingBackwardInInitialPosition(){
        char[] backwardCommand = new char[]{'B'};
        rover.followCommands(backwardCommand);
        int expected = (rover.getCoordinate().getyCoordinate());
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);

    }
    @Test
    public void moveRightwhenNorth(){
        char[] backwardCommand = new char[]{'R'};
        rover.getCoordinate().setDirection(Direction.NORTH);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(1);
    }

    @Test
    public void moveLeftWhenNorth(){
        char[] backwardCommand = new char[]{'L'};
        rover.getCoordinate().setDirection(Direction.NORTH);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(5);
    }


    @Test
    public void moveRightwhenSouth(){
        char[] backwardCommand = new char[]{'R'};
        rover.getCoordinate().setDirection(Direction.SOUTH);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(5);
    }


    @Test
    public void moveLeftWhenSouth(){
        char[] backwardCommand = new char[]{'L'};
        rover.getCoordinate().setDirection(Direction.SOUTH);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(1);
    }

    @Test
    public void moveLeftWhenEast(){
        char[] backwardCommand = new char[]{'L'};
        rover.getCoordinate().setDirection(Direction.EAST);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(1);
    }

    @Test
    public void moveRightWhenWest(){
        char[] backwardCommand = new char[]{'R'};
        rover.getCoordinate().setDirection(Direction.WEST);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(1);
    }

    @Test
    public void moveRightWhenEast(){
        char[] backwardCommand = new char[]{'R'};
        rover.getCoordinate().setDirection(Direction.EAST);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(5);
    }

    @Test
    public void moveLeftWhenWest(){
        char[] backwardCommand = new char[]{'L'};
        rover.getCoordinate().setDirection(Direction.WEST);
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(5);
    }

    @Test
    public void moveMultipleCommands(){
        char[] backwardCommand = new char[]{'F', 'B', 'F', 'B'};
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(0);
    }
}
