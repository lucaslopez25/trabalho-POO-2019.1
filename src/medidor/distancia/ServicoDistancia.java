package medidor.distancia;

import java.util.Collection;

import entidades.Pigmento;
import entidades.Rgb;

public interface ServicoDistancia {
	public Pigmento getMenorDistancia(Collection<Pigmento> pigmentos, Rgb corUserRGB);
	public double calcularDistancia(Rgb corUserRGB, Rgb cor);
}