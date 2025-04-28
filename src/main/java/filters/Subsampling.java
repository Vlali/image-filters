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

		// get the different blocks
		for(int x = 0; x < image.getWidth(); x+=rate) {
			for(int y = 0; y < image.getHeight(); y+=rate) {

				Pixel pixelWithinTheBlock = new Pixel(image.getRGB(x, y));

				int redColorInTheBlock=pixelWithinTheBlock.getR();
				int greenColorInTheBlock=pixelWithinTheBlock.getG();
				int blueColorInTheBlock=pixelWithinTheBlock.getB();
				int alphaColorInTheBlock=pixelWithinTheBlock.getAlpha();

				int newRaw=Pixel.generateRaw(redColorInTheBlock, greenColorInTheBlock, blueColorInTheBlock,alphaColorInTheBlock);


				// inside every single block
				for(int x1 = 0; x1 < rate; x1++) {
					for(int y1 = 0; y1 < rate; y1++) {

						int pixelBlockCoordinateX=x+x1;
						int pixelBlockCoordinateY=y+y1;

						if(pixelBlockCoordinateX< image.getWidth() && pixelBlockCoordinateY < image.getHeight()) {


							bi.setRGB(pixelBlockCoordinateX, pixelBlockCoordinateY, newRaw);

						}
					}
				}
			}
		}

		return bi;
	}

	@Override
	public List<Parameter> getParameters() {
		Parameter p = new Parameter("rate", 4, 1, 24);
		return Arrays.asList(p);
	}

}
