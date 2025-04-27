package filters;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import pixels.Pixel;

public class ThresholdFilter implements Filter {
	@Override
	public String getFilterName() {
		return "Threshold Filter";
	}

	@Override
	public Image runFilter(BufferedImage image, Map<String, Parameter> parameters) {
		int threshold = ((Parameter) parameters.get("threshold")).getValue();
		BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		int whitePixel = Pixel.generateRaw(255, 255, 255, 255);
		int blackPixel = Pixel.generateRaw(0, 0, 0, 255);

		/* @TODO Place your implementation here */

		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getHeight(); y++) {
				Pixel pixel = new Pixel(image.getRGB(x, y));

				int gray = (pixel.getR() + pixel.getG() + pixel.getB()) / 3;

				if(threshold > gray) {
					bi.setRGB(x, y, whitePixel);
				}else{
					bi.setRGB(x, y, blackPixel);
				}

			}
		}

		return bi;
	}

	@Override
	public List<Parameter> getParameters() {
		Parameter p = new Parameter("threshold", 128, 0, 255);
		return Arrays.asList(p);
	}
}
