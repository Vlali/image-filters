package filters;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import pixels.Pixel;

public class GrayScaleFilter implements Filter {
	@Override
	public String getFilterName() {
		return "Grayscale Filter";
	}

	@Override
	public Image runFilter(BufferedImage image, Map<String, Parameter> parameters) {
		BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getHeight(); y++) {
				Pixel pixel = new Pixel(image.getRGB(x, y));


				int gray = (pixel.getR() + pixel.getG() + pixel.getB()) / 3;

				int newRaw= Pixel.generateRaw(gray,gray,gray,pixel.getAlpha());

				bi.setRGB(x, y, newRaw);

			}
		}

		/* @TODO Place your implementation here */


		return bi;
	}

	@Override
	public List<Parameter> getParameters() {
		return Arrays.asList();
	}
}
