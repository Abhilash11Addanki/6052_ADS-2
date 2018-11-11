import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;
/**
 * Class for show energy.
 */
public final class ShowEnergy {
    /**
     * Constructs the object.
     */
    private ShowEnergy() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Picture picture = new Picture(args[0]);
        StdOut.printf("image is %d columns by %d rows\n",
                      picture.width(), picture.height());
        picture.show();
        SeamCarver sc = new SeamCarver(picture);

        StdOut.printf("Displaying energy calculated for each pixel.\n");
        SCUtility.showEnergy(sc);

    }

}
