package imageProc;

public class SpatialFilter implements ISpatialFilter {

  public static class Filter {
    private double[][] coeffs;

    Filter(double[][] coeffs) {     
      this.coeffs = coeffs;
    }
    
    public double[][] getCoeffs() {
      return coeffs;
    }
    
    public int getSize() {
      return this.coeffs.length;
    }
    
    public int getOffset() {
      return -(getSize() / 2);
    }
    
    // various filters
    public static class Smoothing extends Filter {
      public Smoothing() {
        super(new double[][]{
          {(double) 1/9,(double) 1/9,(double) 1/9},
          {(double) 1/9,(double) 1/9,(double) 1/9},
          {(double) 1/9,(double) 1/9,(double) 1/9}
        });
      }
    }
    
    public static class Sharpening extends Filter {
      public Sharpening() {
        super(new double[][]{
          {0,-1,0},
          {-1,5,-1},
          {0,-1,0}
        });
      }
    }
    
    public static class VerticalEdgeDetection extends Filter {
      public VerticalEdgeDetection() {
        super(new double[][]{
          {-1,0,1},
          {-1,0,1},
          {-1,0,1}
        });
      }
    }
    
    public static class HorizontalEdgeDetection extends Filter {
      public HorizontalEdgeDetection() {
        super(new double[][]{
          {-1,-1,-1},
          {0,0,0},
          {1,1,1}
        });
      }
    }
    // end filters    
  }
  
 /**
  * shows that it's impossible to calculate a pixel's color due to its position. 
  * 
  */
  private static class SpatialFilterPixelIsNotCalculatableException extends Exception {}
  
  private RGBImage image;
  private Filter filter;
  
  private int[][] red, green, blue;
  private int width, height;
  
  public SpatialFilter(RGBImage image) {
    this.image = image;
    
    int[][][] rgb = image.getRGBMask();
    red = rgb[0];
    green = rgb[1];
    blue = rgb[2];
    
    width = red.length;
    height = red[0].length;
  }
  
  public void setFilter(Filter filter) {
    this.filter = filter;
  }
  
  public void apply() {
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        handlePixel(x, y);
      }
    }
    
    image.updateArrays(red, green, blue);
  }
  
  private void handlePixel(int x, int y) {
    try {
      int[] rgb = calculatePixelColor(x, y);
      
      red[x][y] = rgb[0];
      green[x][y] = rgb[1];
      blue[x][y] = rgb[2];
    } catch (SpatialFilterPixelIsNotCalculatableException e) {
      // don't apply the filter to a pixel unless all cells correspond to a neighbor pixel,
    }
  }
  
  private int[] calculatePixelColor(int x, int y) throws SpatialFilterPixelIsNotCalculatableException {
    int[] rgb = new int[3];
    double[][] coeffs = filter.getCoeffs();
    
    int offset = filter.getOffset();
    
    try {
      for (int fx = 0; fx < coeffs.length; fx++) {
        for (int fy = 0; fy < coeffs[fx].length; fy++) {
          double coeff = coeffs[fx][fy];

          int xPos = x + offset + fx,
              yPos = y + offset + fy;

          rgb[0] += (int) (red[xPos][yPos] * coeff);
          rgb[1] += (int) (green[xPos][yPos] * coeff);
          rgb[2] += (int) (blue[xPos][yPos] * coeff);
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new SpatialFilterPixelIsNotCalculatableException();
    }
    
    // The result of the spatial filter may be less than 0 or greater than 255. 
    // Make sure anything out of range gets set to the appropriate maximum or minimum value
    for (int i = 0; i < rgb.length; i++) {
      if(rgb[i] > 255) {
        rgb[i] = 255;
      } else if(rgb[i] < 0) {
        rgb[i] = 0;
      }
    }
    
    return rgb;
  }
}
