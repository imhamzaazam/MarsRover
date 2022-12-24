public class Sphere {
    private int maxHeight;
    private int maxWidth;

    public Sphere(int maxHeight, int maxWidth){
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public boolean XCoordinateWithinSphere(Coordinate coordinate){
        return coordinate.getxCoordinate()>=0 && coordinate.getxCoordinate()<=getMaxWidth();
    }
    public boolean YCoordinateWithinSphere(Coordinate coordinate){
        return coordinate.getyCoordinate()<0 && coordinate.getyCoordinate()>getMaxHeight();
    }
}
