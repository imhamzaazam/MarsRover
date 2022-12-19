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
    public void receivesArrayOfCommands(){
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
    public void moveForwardInSouthDirection(){
        char[] forwardCommand = new char[]{'F'};
        rover.setDirection(Direction.SOUTH);
        int expected = rover.getCoordinate().getyCoordinate()-1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);

    }
    @Test
    public void moveBackwardInSouthDirection(){
        char[] forwardCommand = new char[]{'B'};
        rover.setDirection(Direction.SOUTH);
        int expected = rover.getCoordinate().getyCoordinate()+1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getyCoordinate()).isEqualTo(expected);

    }
    @Test
    public void moveForwardInEastDirection(){
        char[] forwardCommand = new char[]{'F'};
        rover.setDirection(Direction.EAST);
        int expected = rover.getCoordinate().getxCoordinate()+1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveBackwardsInEastDirection(){
        char[] forwardCommand = new char[]{'B'};
        rover.setDirection(Direction.EAST);
        int expected = rover.getCoordinate().getxCoordinate()-1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveForwardInWestDirection(){
        char[] forwardCommand = new char[]{'F'};
        rover.setDirection(Direction.WEST);
        int expected = rover.getCoordinate().getxCoordinate()-1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }
    @Test
    public void moveBackwardsInWestDirection(){
        char[] forwardCommand = new char[]{'B'};
        rover.setDirection(Direction.WEST);
        int expected = rover.getCoordinate().getxCoordinate()+1;
        rover.followCommands(forwardCommand);
        assertThat(rover.getCoordinate().getxCoordinate()).isEqualTo(expected);
    }

}
