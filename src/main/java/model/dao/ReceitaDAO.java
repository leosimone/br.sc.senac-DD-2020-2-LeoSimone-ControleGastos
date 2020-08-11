package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.ReceitaVO;

public class ReceitaDAO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public int cadastrarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "INSERT INTO receita (idusuario, descricao, valor, datareceita) VALUES ("
				+ receitaVO.getIdUsuario() + ", '"
				+ receitaVO.getDescricao() + "', "
				+ receitaVO.getValor() + ", '"
				+ receitaVO.getDataReceita() + "')";				
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro de receita");
			System.out.println("\nErro: "+e.getMessage());;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}
	

	public boolean existeRegistroPorIdReceita(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;		
		
		String query = "SELECT idreceita FROM receita WHERE idreceita = '" + id + "' ";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a verificação da existência de receita por ID");
			System.out.println("\nErro: "+ e.getMessage());			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "UPDATE receita SET "
				+ "idusuario = "+receitaVO.getIdUsuario() + ", "
				+ "descricao = '"+receitaVO.getDescricao() + "', "
				+ "valor = "+receitaVO.getValor() + ", "
				+ "datareceita = '"+receitaVO.getDataReceita() + "' WHERE idreceita = "+receitaVO.getId();			
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização de receita");
			System.out.println("Erro: "+e.getMessage());;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}

	public int excluirReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "DELETE FROM receita WHERE idreceita = "+receitaVO.getId();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de exclusão de receita ");
			System.out.println("\nErro: "+e.getMessage());;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;		
	}

	public ArrayList<ReceitaVO> consultarReceitasUsuarioDAO(ReceitaVO receitaVO) {
		
		return null;
	}

	public ReceitaVO consultarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;	
		ReceitaVO receita = null;			
		
		String query = "SELECT idreceita, idusuario, descricao, valor, datareceita "
				+"FROM receita WHERE idreceita = "+receitaVO.getId();
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				receita = new ReceitaVO();
				receita.setId(Integer.parseInt(resultado.getString(1)));
				receita.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				receita.setDescricao(resultado.getString(3));
				receita.setValor(Double.parseDouble(resultado.getString(4)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(5), dataFormatter));
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de uma receita específica");
			System.out.println("\nErro: "+e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}		
		return receita;
	}

}