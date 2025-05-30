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

				int changedTOSepiaRed = (int) ((red * 0.393) + (green * 0.769) + (blue * 0.189));
				int changedToSepiaGreen = (int) ((red * 0.349) + (green * 0.686) + (blue * 0.168));
				int changedToSepiaBlue = (int) ((red * 0.272) + (green * 0.534) + (blue * 0.131));

				int withinBoundariesSepiaRed = rgbBoundaries(changedTOSepiaRed);
				int withinBoundariesSepiaGreen = rgbBoundaries(changedToSepiaGreen);
				int withinBoundariesSepiaBlue = rgbBoundaries(changedToSepiaBlue);


				int newRaw= Pixel.generateRaw(withinBoundariesSepiaRed,withinBoundariesSepiaGreen,withinBoundariesSepiaBlue,pixel.getAlpha());

				bi.setRGB(x, y, newRaw);

			}
		}
    
	return bi;

	}

	private int rgbBoundaries(int value) {
		if (value < 0) {
			value = 0;
		} else if (value > 255) {
			value = 255;
		}
		return value;

	}

	@Override
	public List<Parameter> getParameters() {
		return Arrays.asList();
	}
}
