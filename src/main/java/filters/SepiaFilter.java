package filters;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import pixels.Pixel;

public class SepiaFilter implements Filter {

	@Override
	public String getFilterName() {
		return "Sepia Filter";
	}

	@Override
  public Image runFilter(BufferedImage image, Map<String, Parameter> parameters) {
    BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

    /* @TODO Place your implementation here */
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getHeight(); y++) {
				Pixel pixel = new Pixel(image.getRGB(x, y));

				int red= pixel.getR();
				int green = pixel.getG();
				int blue = pixel.getB();

				double changedRed = (red * 0.393) + (green * 0.769) + (blue * 0.189);
				double changedGreen = (red * 0.349) + (green * 0.686) + (blue * 0.168);
				double changedBlue = (red * 0.272) + (green * 0.534) + (blue * 0.131);

				int newRaw= Pixel.generateRaw((int)changedRed,(int)changedGreen,(int)changedBlue,pixel.getAlpha());

				bi.setRGB(x, y, newRaw);

			}
		}
    
	return bi;

	}

	@Override
	public List<Parameter> getParameters() {
		return Arrays.asList();
	}
}
