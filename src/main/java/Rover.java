public class Rover {
    private Coordinate coordinate;
    private Sphere sphere;

    public Rover() {
    }

    public Rover(Coordinate coordinate, Sphere sphere) {
        this.coordinate = coordinate;
        this.sphere = sphere;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }


    public void followCommands(char[] commands) {
        for (char command : commands) {
            followSingleCommand(command);
        }
    }

    private void followSingleCommand(char command) {
        switch (command) {
            case 'F':
                moveForward();
                break;
            case 'B':
                moveBackwards();
                break;
            case 'L':
                moveLeft();
                break;
            case 'R':
                moveRight();
                break;
            default:
                throw new IllegalArgumentException("Command not valid");
        }
    }

    private void moveRight() {
        if (coordinate.getDirection().equals(Direction.NORTH)) {
            this.coordinate.setDirection(Direction.EAST);
            updateXCoordinate(moveForwardOnXAxis());
            return;
        }
        if(coordinate.getDirection().equals(Direction.WEST)){
            this.coordinate.setDirection(Direction.NORTH);
            updateXCoordinate(moveForwardOnXAxis());
            return;
        }
        if(coordinate.getDirection().equals(Direction.SOUTH)){
            this.coordinate.setDirection(Direction.WEST);
            updateXCoordinate(moveBackwardsOnXAxis());
            return;
        }
        if(coordinate.getDirection().equals(Direction.EAST)){
            this.coordinate.setDirection(Direction.SOUTH);
            updateYCoordinate(moveBackwardOnYAxis());
            return;
        }
    }

    private void moveLeft() {
        if (coordinate.getDirection().equals(Direction.NORTH)) {
            this.coordinate.setDirection(Direction.WEST);
            updateXCoordinate(moveBackwardsOnXAxis());
            return;
        }
        if(coordinate.getDirection().equals(Direction.WEST)){
            this.coordinate.setDirection(Direction.SOUTH);
            updateYCoordinate(moveBackwardOnYAxis());
            return;
        }
        if(coordinate.getDirection().equals(Direction.SOUTH)){
            this.coordinate.setDirection(Direction.EAST);
            updateXCoordinate(moveForwardOnXAxis());
            return;
        }
        if(coordinate.getDirection().equals(Direction.EAST)){
            this.coordinate.setDirection(Direction.NORTH);
            updateYCoordinate(moveForwardOnYAxis());
            return;
        }
    }

    private void moveBackwards() {
        if (coordinate.getDirection().equals(Direction.NORTH)) {
            updateYCoordinate(moveBackwardOnYAxis());
        }
        if (coordinate.getDirection().equals(Direction.SOUTH)) {
            updateYCoordinate(moveForwardOnYAxis());
        }
        if (coordinate.getDirection().equals(Direction.EAST)) {
            updateXCoordinate(moveBackwardsOnXAxis());
        }
        if (coordinate.getDirection().equals(Direction.WEST)) {
            updateXCoordinate(moveForwardOnXAxis());
        }
    }

    private void moveForward() {
        if (coordinate.getDirection().equals(Direction.NORTH)) {
            updateYCoordinate(moveForwardOnYAxis());
        }
        if (coordinate.getDirection().equals(Direction.SOUTH)) {
            updateYCoordinate(moveBackwardOnYAxis());
        }
        if (coordinate.getDirection().equals(Direction.EAST)) {
            updateXCoordinate(moveForwardOnXAxis());
        }
        if (coordinate.getDirection().equals(Direction.WEST)) {
            updateXCoordinate(moveBackwardsOnXAxis());
        }
        return;
    }

    private void updateYCoordinate(int yCoordinate) {
        if (!(sphere.YCoordinateWithinSphere(coordinate))) {
            if (yCoordinate < 0) {
                this.coordinate.setyCoordinate(sphere.getMaxHeight());
            }
            if (yCoordinate > sphere.getMaxWidth()) {
                this.coordinate.setyCoordinate(yCoordinate % sphere.getMaxHeight());
            }
        }else{
            this.coordinate.setyCoordinate(yCoordinate);
        }
    }

    private void updateXCoordinate(int xCoordinate) {
        if (!(sphere.XCoordinateWithinSphere(coordinate))) {
            if (xCoordinate < 0) {
                this.coordinate.setxCoordinate(sphere.getMaxWidth());
            }
            if (xCoordinate > sphere.getMaxWidth()) {
                this.coordinate.setxCoordinate(xCoordinate % sphere.getMaxWidth());
            }
        } else {
            this.coordinate.setxCoordinate(xCoordinate);
        }
    }

    private int moveForwardOnYAxis() {
        int yCoordinate=  (this.getCoordinate().getyCoordinate() + 1);
        this.coordinate.setyCoordinate(yCoordinate);
        return yCoordinate;
    }

    private int moveForwardOnXAxis() {
        int xCoordinate= (this.getCoordinate().getxCoordinate() + 1);
        this.coordinate.setxCoordinate(xCoordinate);
        return xCoordinate;
    }

    private int moveBackwardOnYAxis() {
        int yCoordinate =  (this.getCoordinate().getyCoordinate() - 1);
        this.coordinate.setyCoordinate(yCoordinate);
        return yCoordinate;
    }

    private int moveBackwardsOnXAxis() {
        int xCoordinate=  (this.getCoordinate().getxCoordinate() - 1);
        this.coordinate.setxCoordinate(xCoordinate);
        return xCoordinate;
    }

}
