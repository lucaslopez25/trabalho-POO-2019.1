package persistence;

import java.util.Collection;

import entidades.Pigmento;

public interface PigmentoDAO {
	public void save(Pigmento p);
	public Pigmento findPigmentoByNome(String nome);
	public void update(Pigmento c);
	public Collection<Pigmento> findAll();
}