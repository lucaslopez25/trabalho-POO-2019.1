package medidor.distancia;

import java.util.Collection;
import java.util.Iterator;

import conversor.cores.ConversorCoresApp;
import conversor.cores.ServicoConversorCores;
import entidades.Cmyk;
import entidades.Pigmento;
import entidades.Rgb;

public class Distancia implements ServicoDistancia{

		@Override
		public double calcularDistancia(Rgb corUserRGB, Rgb cor) {
			return Math.sqrt(Math.pow((Math.abs(corUserRGB.getRed()-cor.getRed())),2) + Math.pow((Math.abs(corUserRGB.getGreen()-cor.getGreen())),2) + Math.pow((Math.abs(corUserRGB.getBlue()-cor.getBlue())),2));
		}

		@Override
		public Pigmento getMenorDistancia(Collection<Pigmento> pigmentos, Rgb corUserRGB) {
			// TODO Auto-generated method stub
			ServicoConversorCores conversor = new ConversorCoresApp();
			Pigmento menor = null;
			if(!pigmentos.isEmpty()) {
				
				Pigmento pigmento;
				double menorDistancia = 100000000;
				Iterator<Pigmento> itr = pigmentos.iterator();
				
				while(itr.hasNext()){
					pigmento = itr.next();
					if(pigmento.getClass() == Rgb.class) {
						if(this.calcularDistancia(corUserRGB, (Rgb)pigmento) < menorDistancia) {
							menorDistancia = this.calcularDistancia(corUserRGB, (Rgb)pigmento);
							menor = pigmento;
						}
					}else if(pigmento.getClass() == Cmyk.class) {
						Rgb novo = conversor.cmykToRgb((Cmyk)pigmento);
						if(this.calcularDistancia(corUserRGB, novo) < menorDistancia) {
							menorDistancia = this.calcularDistancia(corUserRGB, novo);
							menor = pigmento;
						}
					}
				}
				
			}
			return menor;
		}
}
