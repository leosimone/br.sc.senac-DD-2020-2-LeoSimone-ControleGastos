package controller;

import java.util.ArrayList;

import model.bo.RelatorioBO;
import model.dto.LancamentoUsuarioDTO;

public class ControladoraRelatorio {


	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuarioController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalReceitasUsuario();
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuarioPorPeriodoController(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalReceitasUsuarioPorPeriodoBO(lancamentoUsuarioDTO);
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuarioController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalDespesasUsuario();
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuarioPorPeriodoController(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalDespesasUsuarioPorPeriodoBO(lancamentoUsuarioDTO);
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasAbertasUsuarioController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalDespesasAbertasUsuario();
	}

}
