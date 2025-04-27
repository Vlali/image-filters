package filters;

import pixels.Pixel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Subsampling implements Filter {

	@Override
	public String getFilterName() {
		return "Subsampling";
	}

	@Override
	public Image runFilter(BufferedImage image, Map<String, Parameter> parameters) {
		int rate = parameters.get("rate").getValue();
		BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	
		/* @TODO Place your implementation here */
		for(int x = 0; x < image.getWidth(); x+=rate) {
			for(int y = 0; y < image.getHeight(); y+=rate) {

				Pixel pixel = new Pixel(image.getRGB(x, y));
				pixel.getCb();
				pixel.getCr();





				int newRaw= Pixel.generateRaw(gray,gray,gray,pixel.getAlpha());

				bi.setRGB(x, y, newRaw);

			}
		}


		
		return bi;
	}

	@Override
	public List<Parameter> getParameters() {
		Parameter p = new Parameter("rate", 4, 1, 8);
		return Arrays.asList(p);
	}

}
