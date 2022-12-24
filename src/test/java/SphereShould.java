import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SphereShould {
    private Sphere sphere;
    private Coordinate coordinate;
    @Before()
    public void beforeSphereTest() {
        sphere = new Sphere(5,5);
        coordinate = new Coordinate(6, 6, Direction.NORTH);
    }
    @Test
    public void haveXCoordinateWithinSphere() {
        assertThat(sphere.XCoordinateWithinSphere(coordinate)).isFalse();
    }
    @Test
    public void haveYCoordinateWithinSphere() {
        assertThat(sphere.YCoordinateWithinSphere(coordinate)).isFalse();
    }
}
