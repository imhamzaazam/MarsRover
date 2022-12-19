public class Rover {
    private Coordinate coordinate;
    private Direction direction;

    public Rover() {
    }

    public Rover(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void followCommands(char[] commands) {
        for(char command: commands){
            followSingleCommand(command);
        }
    }

    private void followSingleCommand(char command) {
        switch (command){
            case 'F':
                if(direction.equals(Direction.NORTH))
                    updateYCoordinate(moveForward());
                    break;
            case 'B':
                if(direction.equals(Direction.NORTH))
                    updateYCoordinate(moveBackward());
                    break;
        }
    }

    private void updateYCoordinate(int yCoordinate){
        this.coordinate.setyCoordinate(yCoordinate);
    }

    private int moveBackward() {
        return (this.getCoordinate().getyCoordinate() - 1);
    }

    private int moveForward() {
        return (this.getCoordinate().getyCoordinate() + 1);
    }
}
