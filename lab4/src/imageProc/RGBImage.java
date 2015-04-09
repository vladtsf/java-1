package imageProc;

public class RGBImage {

  // folder to look for image files
  private String defaultDirectory = "images";

    // The pixels are stored in three 2D arrays.
  // These are the data structures we will use to perform 
  // the actual image manipulation.
  private int red[][];
  private int green[][];
  private int blue[][];

  // Helper will do the 'ugly' Java stuff (saving images to files, etc)
  private RGBImageViewer myViewer;

  // Constructor, use an open file dialog to specify image
  public RGBImage() {
    myViewer = new RGBImageViewer(this, defaultDirectory);
  }

  // Constructor, String argument specifies filename of image
  public RGBImage(String filename) {
    myViewer = new RGBImageViewer(this, defaultDirectory, filename);
  }

    // this is called from Helper, when a new image is loaded from a file.  
  // You never need to call it.
  protected void updateArrays(int[][] red, int[][] green, int[][] blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  // Call this method to load a new image
  public void load() {
    myViewer.load(defaultDirectory);
  }

  // Call this method to save the image to the same file
  public void save() {
    myViewer.save();
  }

  // Call this method to save the image to a different file name
  public void saveAs(String filename) {
    myViewer.saveAs(filename);
  }

    // call this in case you closed the viewer, but want to see it again.
  // won't work with the default close action on the viewer, currently.
  public void show() {
    myViewer.show();
  }

    // This method should always be called after manipulating 
  // the pixels via the 2D arrays.  
  private void refresh() {
    myViewer.refresh(red, green, blue);
  }

    ///////////
  /////////// Image manipulation methods
  ///////////
  // Your code goes here.  
  // Don't forget to call refresh() after manipulating the red, green, and blue pixel arrays
  // Example: flips the image vertically.
  public void flipVertical() {
    int width = red.length;
    int height = red[0].length;

    int[][] temp = new int[width][height];

    // Flip the red channel.
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        temp[w][h] = red[w][height - h - 1];
      }
    }
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        red[w][h] = temp[w][h];
      }
    }

    // Flip the green channel.
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        temp[w][h] = green[w][height - h - 1];
      }
    }
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        green[w][h] = temp[w][h];
      }
    }

    // Flip the blue channel.
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        temp[w][h] = blue[w][height - h - 1];
      }
    }
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        blue[w][h] = temp[w][h];
      }
    }

    // Always do this after manipulating pixels.
    refresh();
  }

  public void makeGreyscale() {
    int width = red.length;
    int height = red[0].length;

    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        int avg = (red[w][h] + green[w][h] + blue[w][h]) / 3;
        red[w][h] = avg;
        green[w][h] = avg;
        blue[w][h] = avg;
      }
    }
    
    refresh();
  }

    // mirror image from a file by modifying one half of the picture so that it 
  // shows a 'reflection' of the other half. It will look as if half 
  // the picture is being held up to a mirror. (you'll be throwing out 
  // half the information in the picture, and won't see any effect if the image
  // is already mirrored.
  public void mirrorHorizontal() {
    int width = red.length;

    for (int x = ((int) width / 2); x > 0; x--) {
      red[x] = red[width - x];
      green[x] = green[width - x];
      blue[x] = blue[width - x];
    }

    refresh();
  }

  
  //  Honestly, I didn't get how I was supposed to deal with contrast,
  //  but I decided to allow the users to set the level of contrast.
  //  The algorithm is taken from the Internet (http://stackoverflow.com/questions/8990926/faster-contrast-algorithm-for-a-bitmap)
  //  and ported to JAVA.
  private int applyContrastToPixel(int pixelValue, double contrast) {
    double factor = (100 + contrast) / 100;
    
    double newPixel = pixelValue;
    newPixel /= 255;
    newPixel -= .5;
    newPixel *= factor;
    newPixel += .5;
    newPixel *= 255;
    
    if(newPixel < 0) {
      newPixel = 0;
    } else if(newPixel > 255) {
      newPixel = 255;
    }
    
    return (int) newPixel;
  }
  
  /* Images can often have low contrast because the values of their pixels 
   * only span part of the 0-255 range of possible values. This can make 
   * images "too dark" (if the values are all too low) or "washed out" (if 
   * the values are all too high). A simple way to increase the contrast 
   * in an image therefore is to scale the values so they fill this range. 
   */
  public void contrastStretch(double contrast) {
    int width = red.length;
    int height = red[0].length;

    for(int y = 0, x; y < height; y++) {
      for(x = 0; x < width; x++) {
        red[x][y] = applyContrastToPixel(red[x][y], contrast);
        green[x][y] = applyContrastToPixel(green[x][y], contrast);
        blue[x][y] = applyContrastToPixel(blue[x][y], contrast);
      }
    }
    
    refresh();
  }
  
  public void contrastStretch() {
    contrastStretch(50);
  }

  public void threshHolding(int threshhold) {
    int width = red.length;
    int height = red[0].length;

    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        int avg = (red[w][h] + green[w][h] + blue[w][h]) / 3;
        int newval;

        if (avg < threshhold) {
          newval = 0;
        } else {
          newval = 255;
        }
        red[w][h] = newval;
        green[w][h] = newval;
        blue[w][h] = newval;
      }
    }
    refresh();
  }

  // this adds a 5 pixel black border around the image, losing the 
  // information in those pixels. If the picture has a width or height
  // less than 5 pixels, this method must not crash!
  public void addBorder(int xBorder, int yBorder) {
    int width = red.length;
    int height = red[0].length;
    
    xBorder = xBorder > width ? width : xBorder;
    yBorder = yBorder > height ? height : yBorder;
    
    int points = 0;
    
    for(int y = 0, x; y < height; y++) {
      for(x = 0; x < width; x++) {
        
        if(x < xBorder || x >= width - xBorder - 1 || y < yBorder || y >= height - yBorder - 1) {
          red[x][y] = green[x][y] = blue[x][y] = 0;
        }
      }
    }
    

    refresh();
  }
  
  public void addBorder(int border) {
    addBorder(border, border);
  }
  
  public void addBorder() {
    addBorder(5);
  }
}
