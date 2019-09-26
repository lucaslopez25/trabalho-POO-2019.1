package conversor.cores;

import entidades.Rgb;
import entidades.Cmyk;
import entidades.HexadecimalColor;

public interface ServicoConversorCores {
	public Rgb htmlToRgb (HexadecimalColor novo);
	public Cmyk htmlToCmyk (HexadecimalColor novo);
	public Rgb cmykToRgb (Rgb novo);
}
