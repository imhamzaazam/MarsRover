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
                if(direction.equals(Direction.NORTH)) {
                    updateYCoordinate(moveForwardOnYAxis());
                }
                if(direction.equals(Direction.SOUTH)){
                    updateYCoordinate(moveBackwardOnYAxis());
                }if(direction.equals(Direction.EAST)){
                    updateXCoordinate(moveForwardOnXAxis());
                }if(direction.equals(Direction.WEST)){
                updateXCoordinate(moveBackwardsOnXAxis());
            }
                break;
            case 'B':
                if(direction.equals(Direction.NORTH)) {
                    updateYCoordinate(moveBackwardOnYAxis());
                }
                if(direction.equals(Direction.SOUTH)){
                    updateYCoordinate(moveForwardOnYAxis());
                }
                if(direction.equals(Direction.EAST)){
                updateXCoordinate(moveBackwardsOnXAxis());
                }
                if(direction.equals(Direction.WEST)) {
                    updateXCoordinate(moveForwardOnXAxis());
                }
                break;
        }
    }

    private void updateYCoordinate(int yCoordinate){
        this.coordinate.setyCoordinate(yCoordinate);
    }
    private void updateXCoordinate(int xCoordinate){
        this.coordinate.setxCoordinate(xCoordinate);
    }

    private int moveForwardOnYAxis() {
        return (this.getCoordinate().getyCoordinate() + 1);
    }
    private int moveForwardOnXAxis() {
        return (this.getCoordinate().getxCoordinate() + 1);
    }
    private int moveBackwardOnYAxis() {
        return (this.getCoordinate().getyCoordinate() - 1);
    }
    private int moveBackwardsOnXAxis() {
        return (this.getCoordinate().getxCoordinate() - 1);
    }




}
