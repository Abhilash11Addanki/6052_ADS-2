import java.awt.Color;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdRandom;
/**
 * Class for sc utility.
 */
public final class SCUtility {
    /**
     * Constructs the object.
     */
    private SCUtility() {
    }
    /**
     * randomPicture method.
     *
     * @param      width   The width
     * @param      height  The height
     *
     * @return     Picture.
     */
    public static Picture randomPicture(final int width, final int height) {
        Picture picture = new Picture(width, height);
        final int num = 255;
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int r = StdRandom.uniform(num);
                int g = StdRandom.uniform(num);
                int b = StdRandom.uniform(num);
                Color color = new Color(r, g, b);
                picture.set(col, row, color);
            }
        }
        return picture;
    }
    /**
     * toEnergyMatrix.
     *
     * @param      sc    The screen
     *
     * @return     matrix.
     */
    public static double[][] toEnergyMatrix(final SeamCarver sc) {
        double[][] returnDouble = new double[sc.width()][sc.height()];
        for (int col = 0; col < sc.width(); col++) {
            for (int row = 0; row < sc.height(); row++) {
                returnDouble[col][row] = sc.energy(col, row);
            }
        }

        return returnDouble;
    }
    /**
     * Shows the energy.
     * @param      sc    The screen
     */
    public static void showEnergy(final SeamCarver sc) {
        doubleToPicture(toEnergyMatrix(sc)).show();
    }
    /**
     * toEnergyPicture method.
     *
     * @param      sc    The screen
     *
     * @return     Picture.
     */
    public static Picture toEnergyPicture(final SeamCarver sc) {
        double[][] energyMatrix = toEnergyMatrix(sc);
        return doubleToPicture(energyMatrix);
    }
    /**
     * converts a double matrix of values into a normalized picture.
    // values are normalized by the maximum grayscale value
    (ignoring border pixels)
     *
     * @param      grayValues  The gray values
     *
     * @return     Picture.
     */
    public static Picture doubleToPicture(final double[][] grayValues) {

        // each 1D array in the matrix represents a single column, so number
        // of 1D arrays is the width, and length of each array is the height
        int width = grayValues.length;
        int height = grayValues[0].length;

        Picture picture = new Picture(width, height);

        // maximum grayscale value (ignoring border pixels)
        double maxVal = 0;
        for (int col = 1; col < width - 1; col++) {
            for (int row = 1; row < height - 1; row++) {
                if (grayValues[col][row] > maxVal) {
                    maxVal = grayValues[col][row];
                }
            }
        }

        if (maxVal == 0) {
            return picture; // return black picture
        }

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                float normalizedGrayValue = (float) grayValues[col][row]
                / (float) maxVal;
                if (normalizedGrayValue >= 1.0f) {
                    normalizedGrayValue = 1.0f;
                }
                picture.set(col, row, new Color(normalizedGrayValue,
                    normalizedGrayValue, normalizedGrayValue));
            }
        }

        return picture;
    }
    /**
     * This method is useful for debugging seams. It overlays red
    // pixels over the calculate seam. Due to the lack of a copy
    // constructor, it also alters the original picture.
     *
     * @param      picture      The picture
     * @param      horizontal   The horizontal
     * @param      seamIndices  The seam indices
     *
     * @return     Picture.
     */
    public static Picture seamOverlay(final Picture picture,
        final boolean horizontal, final int[] seamIndices) {
        Picture overlaid = new Picture(picture.width(), picture.height());
        int width = picture.width();
        int height = picture.height();

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                overlaid.set(col, row, picture.get(col, row));
            }
        }


        // if horizontal seam, then set one pixel in every column
        if (horizontal) {
            for (int col = 0; col < width; col++) {
                overlaid.set(col, seamIndices[col], Color.RED);
            }
        } else {
            for (int row = 0; row < height; row++) {
                overlaid.set(seamIndices[row], row, Color.RED);
            }
        }

        return overlaid;
    }

}

