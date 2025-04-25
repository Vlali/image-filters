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
    
    
	return bi;

	}

	@Override
	public List<Parameter> getParameters() {
		return Arrays.asList();
	}
}
