package clewin;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * (c) Clewin Griffith 2013
 */
public class Image {
	
	public final int xres;
	public final int yres;
	public final double width;
	public final double height;
	public final double aspectRatio;
	private BufferedImage buffer;
	private WritableRaster r;

	public Image(int xres, int yres, double width, double height)
	{
		this.width = width;
		this.height = height;
		this.aspectRatio = width/height;
		this.xres = xres;
		this.yres = yres;
		buffer = new BufferedImage(xres, yres, BufferedImage.TYPE_INT_RGB);
		r = buffer.getRaster();
	}
	
	public double getAspectRatio() {
		return this.aspectRatio;
	}
	
	public void write(int x, int y, double grayscale)
	{
		r.setSample(x, y, 0, 255*grayscale);
	}

    public void write(int x, int y, Color color)
    {
        r.setPixel(x, y, color.getDoubleArray());
    }
	
	public void save() throws IOException
	{
		ImageIO.write(buffer,"PNG",new File("out/output.png"));
	}
}
