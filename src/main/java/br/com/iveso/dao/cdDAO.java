package br.com.iveso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.iveso.db.ConnectionFactory;
import br.com.iveso.exceptions.DAOException;
import br.com.iveso.model.CD;
import br.com.iveso.model.Categoria;

public class cdDAO {

	public void create(CD cd) throws DAOException {

		String sql = "INSERT INTO cd (NOME, CATEGORIA, CONTEUDO) VALUES (?, ?, ?)";

		try (Connection conn = new ConnectionFactory().getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, cd.getNome());
				stmt.setString(2, cd.getCategoria().toString());
				stmt.setString(3, cd.getConteudo());
				System.out.println("Dados Enviados!");
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	}

	public void delet(int id) {
		String sql = "DELETE FROM cd WHERE id = ?";

		try (Connection conn = new ConnectionFactory().getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	}

	public void update(CD cd) {
		String sql = "UPDATE cd SET NOME = ?, CATEGORIA = ?, CONTEUDO = ? WHERE ID = ?";

		try (Connection conn = new ConnectionFactory().getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, cd.getNome());
				stmt.setString(2, cd.getCategoria().toString());
				stmt.setString(3, cd.getConteudo());
				stmt.setInt(4, cd.getId());
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			new RuntimeException("Erro ao atualizar dados!");
		}
	}

	public CD load(int id) {
		String sql = "SELECT ID, NOME, CATEGORIA, CONTEUDO FROM CD WHERE ID = ?";
		ResultSet rs = null;

		try (Connection conn = new ConnectionFactory().getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id);
				rs = stmt.executeQuery();

				if (rs.next()) {
					return new CD(rs.getInt("ID"), rs.getString("NOME"),
							Categoria.getCategoria(rs.getString("CATEGORIA").charAt(0)), rs.getString("CONTEUDO"));
				}
			}
		} catch (SQLException e) {
			new RuntimeException("Não foi possível consultar dado no Bando de Dados! " + e);

		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public List<CD> findCDsByCategoria(Categoria categoria) {
		String sql = "SELECT ID, NOME, CATEGORIA, CONTEUDO FROM CD WHERE CATEGORIA = ?";
		ResultSet rs = null;

		try (Connection conn = new ConnectionFactory().getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, categoria.toString());
				rs = stmt.executeQuery();
				List<CD> list = new ArrayList<>();

				while (rs.next()) {
					list.add(new CD(rs.getInt("ID"), rs.getString("NOME"),
							Categoria.getCategoria(rs.getString("CATEGORIA").charAt(0)), rs.getString("CONTEUDO")));
				}
				return list;
			} catch (SQLException e) {
				new RuntimeException("Não foi possível obter a lista de CDs! " + e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;

	}
}
