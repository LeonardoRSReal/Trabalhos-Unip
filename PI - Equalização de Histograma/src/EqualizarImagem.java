import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EqualizarImagem {	
	
	static int[] calHis(BufferedImage imgE) {
		int[] histograma = new int[256];
		for (int y = 0; y < imgE.getHeight(); y++) {
			for (int x = 0; x < imgE.getWidth(); x++) {
				Color color = new Color(imgE.getRGB(x, y));
				int red = color.getRed();
				histograma[red] += 1;
			}
		}
		return histograma;
	}

	public static int[] calHisAcum(int[] histograma) {
		int[] acumulado = new int[256];
		acumulado[0] = histograma[0];
		for (int i = 1; i < histograma.length; i++) {
			acumulado[i] = histograma[i] + acumulado[i - 1];
		}

		return acumulado;
	}

	private static int menorValor(int[] histograma) {
		for (int i = 0; i < histograma.length; i++) {
			if (histograma[i] != 0) {
				return histograma[i];
			}
		}
		return 0;
	}

	private static int[] calculaMapaCor(int[] histograma, int pixels) {
		int[] mapaCor = new int[256];
		int[] acumulado = calHisAcum(histograma);
		float menor = menorValor(histograma);
		for (int i = 0; i < histograma.length; i++) {
			mapaCor[i] = Math.round(((acumulado[i] - menor) / (pixels - menor)) * 255);
		}
		return mapaCor;
	}

	public static BufferedImage equalização(BufferedImage imgE) {
		int[] histograma = calHis(imgE);
		int[] mapaCor = calculaMapaCor(histograma, imgE.getWidth() * imgE.getHeight());

		BufferedImage out = new BufferedImage(imgE.getWidth(), imgE.getHeight(), BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < imgE.getHeight(); y++) {
			for (int x = 0; x < imgE.getWidth(); x++) {
				Color color = new Color(imgE.getRGB(x, y));
				int tom = color.getRed();
				int novoTom = mapaCor[tom];
				Color novoColor  = new Color(novoTom,novoTom,novoTom);
				out.setRGB(x, y, novoColor.getRGB());
			}
		}
		return out;
	}
	
}
