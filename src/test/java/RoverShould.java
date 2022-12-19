import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RoverShould {
    private Coordinate coordinate;
    private Rover rover;
    private char[] commands;

    @Before()
    public void beforeRoverTest() {
        coordinate = new Coordinate(0, 0);
        rover = new Rover(coordinate, Direction.NORTH);
        commands = new char[]{'L', 'R'};

    }
    @Test
    public void hasInitialStartingPoint() {
        assertThat(rover.getCoordinate()).isEqualToComparingFieldByField(coordinate);
    }
    @Test
    public void hasInitialDirection(){
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }
    @Test
    public void recievesArrayOfCommands(){
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
        int expected = rover.getCoordinate().getyCoordinate()-1;
        rover.followCommands(backwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveFowardInSouthDirection(){
        char[] forwardCommand = new char[]{'F'};
        int expected = rover.getCoordinate().getyCoordinate()-1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);

    }
}
