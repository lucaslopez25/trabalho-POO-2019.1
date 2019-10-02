package sql;

import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Cmyk;
import entidades.Pigmento;
import entidades.Rgb;
import persistence.PigmentoDAO;

public class PigmentoSQLDAO extends AbstractSQLDAO implements PigmentoDAO{

	private static final String INSERT_PIGMENTO = 
			"INSERT INTO PIGMENTO(id, nome, estoque, preco, tipo) " +
			"VALUES(?, ?, ?, ?, ?)";

	private static final String SELECT_PIGMENTO_NOME = 
			"SELECT id,nome,estoque,preco,tipo FROM PIGMENTO " +
			"WHERE nome = ?";
	
	private static final String UPDATE_PIGMENTO = 
			"UPDATE PIGMENTO " + 
			"SET estoque = ? " +
			"WHERE nome = ?";
	
	private static final String SELECT_PIGMENTO = 
			"SELECT id, nome, estoque, preco, tipo FROM PIGMENTO";
	
	@Override
	public void save(Pigmento p){
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(PigmentoSQLDAO.INSERT_PIGMENTO);
			stmt.setString(1, p.getId());
			stmt.setString(2, p.getNome());
			stmt.setDouble(3, p.getLitros());
			stmt.setDouble(4, p.getPreco());
			stmt.setInt(5, this.typeToInt(p));
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
		}
	}

	@Override
	public Pigmento findPigmentoByNome(String nome) {
		Pigmento p = null;
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(PigmentoSQLDAO.SELECT_PIGMENTO_NOME);
			stmt.setString(1, nome);
			ResultSet rSet = stmt.executeQuery();
			if(rSet.next()) {
				p = this.intToType(rSet.getInt("tipo"));
				p.setId(rSet.getString("id"));
				p.setNome(rSet.getString("nome"));
				p.setLitros(rSet.getDouble("estoque"));
				p.setPreco(rSet.getDouble("preco"));
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
		} 
		return p;
	}

	@Override
	public void update(Pigmento c) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(PigmentoSQLDAO.UPDATE_PIGMENTO);
			stmt.setDouble(1, c.getLitros());
			stmt.setString(2, c.getNome());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
		}
	}

	@Override
	public Collection<Pigmento> findAll() {
		// TODO Auto-generated method stub
		List<Pigmento> pigmentos = new ArrayList<Pigmento>();
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(PigmentoSQLDAO.SELECT_PIGMENTO);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				Pigmento p;
				p = this.intToType(rSet.getInt("tipo"));
				p.setId(rSet.getString("id"));
				p.setNome(rSet.getString("nome"));
				p.setLitros(rSet.getDouble("estoque"));
				p.setPreco(rSet.getDouble("preco"));
				pigmentos.add(p);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
		}
		return pigmentos;
	}
	
	private int typeToInt(Pigmento p) {
		if(p.getClass() == Rgb.class)
			return 1;
		else if(p.getClass() == Cmyk.class)
			return 2;
		return 0;
	}
	
	private Pigmento intToType(int i) {
		if(i == 1)
			return new Rgb();
		if(i == 2)
			return new Cmyk();
		return null;
	}

}