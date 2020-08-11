package model.bo;

import java.util.ArrayList;

import model.dao.RelatorioDAO;
import model.dto.LancamentoUsuarioDTO;

public class RelatorioBO {

	
	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuario() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO.gerarRelatorioTotalReceitasUsuarioDAO();
		if(listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de Lançamentos está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}
	
	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuario() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO.gerarRelatorioTotalDespesasUsuarioDAO();
		if(listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de Lançamentos está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}



	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuarioPorPeriodoBO(
			LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO.gerarRelatorioTotalReceitasUsuariosPorPeriodoDAO(lancamentoUsuarioDTO);
		if(listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de Lançamentos está vazia.");
		}
		return listaLancamentoUsuarioDTO;
		
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuarioPorPeriodoBO(
			LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO.gerarRelatorioTotalDespesasUsuariosPorPeriodoDAO(lancamentoUsuarioDTO);
		if(listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de Lançamentos está vazia.");
		}
		return listaLancamentoUsuarioDTO;
		
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasAbertasUsuario() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO.gerarRelatorioTotalDespesasAbertasUsuarioDAO();
		if(listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de Lançamentos está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}

}
