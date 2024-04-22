import java.awt.Image;
import java.awt.image.DirectColorModel;
import java.awt.image.MemoryImageSource;

public class Base {
    private static MemoryImageSource imgSrc;
    private static DirectColorModel  imgCm = new  DirectColorModel(32,0xff0000,0xff00,0xff); 
    private static Image             img;
    private static int               xsize = 256;
    private static int               ysize = 256;
    private static int               pixels[];
    private static int               appLeft = 0;
    private static int               appTop  = 0;
   
    public Base() { // initialize
      imgSrc = new MemoryImageSource(xsize, ysize, pixels, 0, xsize);
      img    = createImage(imgSrc);
      imgSrc.setAnimated(true);
      imgSrc.newPixels(pixels, imgCm, 0, xsize);
      appLeft = getInsets().left;
      appTop  = getInsets().top;
    }
   
    public void run() {
     Graphics g;
     for(;;) {
      // .... render something here
      // then...
      g = getGraphics();
      imgSrc.newPixels();              // NOTE: renders array to image
      g.drawImage(scr, appLeft, appTop, this);
      g.dispose();
     }
    }
}
