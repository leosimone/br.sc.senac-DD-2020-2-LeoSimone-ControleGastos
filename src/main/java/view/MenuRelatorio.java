package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraRelatorio;
import model.dto.LancamentoUsuarioDTO;

public class MenuRelatorio {

			
			Scanner teclado = new Scanner(System.in);
			DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
			
			private static final int OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO = 1;
			private static final int OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO_POR_PERIODO = 2;
			private static final int OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO = 3;
			private static final int OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_POR_PERIODO = 4;
			private static final int OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_ABERTAS_POR_PERIODO = 5;
			private static final int OPCAO_MENU_RELATORIO_VOLTAR = 6;
			
						
			public void apresentarMenuRelatorio() {
				
				int opcao = this.apresentarOpcoesMenu();
				while (opcao != OPCAO_MENU_RELATORIO_VOLTAR) {
					switch (opcao) {

						case OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO: {
							this.gerarRelatorioTotalReceitasUsuario();
							break;
						}
						case OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO_POR_PERIODO: {
							this.gerarRelatorioTotalReceitasUsuarioPorPeriodo();
							break;
						}
						
						case OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO: {
							this.gerarRelatorioTotalDespesasUsuario();				
							break;
						}
						
						case OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_POR_PERIODO: {
							this.gerarRelatorioTotalDespesasUsuarioPorPeriodo();
							break;
						}
						
						case OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_ABERTAS_POR_PERIODO: {
							this.gerarRelatorioTotalDespesasAbertasPorPeriodo();
							break;
						}
			
						default: {
							System.out.println("\nOpção Inválida");
							
						}
					}
					opcao = this.apresentarOpcoesMenu();
					
				}
				
			}
			
			private int apresentarOpcoesMenu() {
				System.out.println("\nControle de Gastos \n -------------- Menu Relatorio -------------");
				System.out.println("\nOpções: ");
				System.out.println(OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO + " - Relatório - Total Receitas do Usuário ");
				System.out.println(OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO_POR_PERIODO + " - Relatório - Total de receitas do Usuário por Período");
				System.out.println(OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO + " - Relatório - Total de Despesas do Usuário");
				System.out.println(OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_ABERTAS_POR_PERIODO + " - Relatório - Total de Despesas do Usuário por Período");
				System.out.println(OPCAO_MENU_RELATORIO_VOLTAR + " - voltar");
				System.out.print("\nDigite a opção: ");
				
				return Integer.parseInt(teclado.nextLine());
				
			}
			
			private void gerarRelatorioTotalDespesasAbertasPorPeriodo() {
				ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
				ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalDespesasAbertasUsuarioController();
				
				System.out.print("\n------------ RELATÓRIO - TOTAL DE DESPESAS ABERTAS DOS USUÁRIOS ---------");
				System.out.printf("\n%3s  %-40s  %-10s   \n", "ID", "NOME", "TOTAL");
				 for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
					 listaLancamentosUsuarioDTO.get(i).imprimir();
				 }
			}

			private void gerarRelatorioTotalDespesasUsuarioPorPeriodo() {
				LancamentoUsuarioDTO lancamentoUsuarioDTO = new LancamentoUsuarioDTO();
				System.out.print("\nDigite a data de início do período de busca");
				lancamentoUsuarioDTO.setDataInicioPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
				System.out.print("\nDigite a data de fim do período de busca");
				lancamentoUsuarioDTO.setDataFimPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
				
				ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
				ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalDespesasUsuarioPorPeriodoController(lancamentoUsuarioDTO);
				
				System.out.print("\n------------ RELATÓRIO - TOTAL DE DESPESAS DOS USUÁRIOS POR PERÍODO ---------");
				System.out.printf("\n%3s  %-40s  %-10s   \n", "ID", "NOME", "TOTAL");
				 for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
					 listaLancamentosUsuarioDTO.get(i).imprimir();
					 }
				
			}

			private void gerarRelatorioTotalDespesasUsuario() {
				ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
				ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalDespesasUsuarioController();
				
				System.out.print("\n------------ RELATÓRIO - TOTAL DE DESPESAS DOS USUÁRIOS ---------");
				System.out.printf("\n%3s  %-40s  %-10s   \n", "ID", "NOME", "TOTAL");
				 for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
					 listaLancamentosUsuarioDTO.get(i).imprimir();
				 }
				
			}

			private void gerarRelatorioTotalReceitasUsuarioPorPeriodo() {
				LancamentoUsuarioDTO lancamentoUsuarioDTO = new LancamentoUsuarioDTO();
				System.out.print("\nDigite a data de início do período de busca");
				lancamentoUsuarioDTO.setDataInicioPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
				System.out.print("\nDigite a data de fim do período de busca");
				lancamentoUsuarioDTO.setDataFimPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
				
				ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
				ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalReceitasUsuarioPorPeriodoController(lancamentoUsuarioDTO);
				
				System.out.print("\n------------ RELATÓRIO - TOTAL DE RECEITAS DOS USUÁRIOS POR PERÍODO ---------");
				System.out.printf("\n%3s  %-40s  %-10s   \n", "ID", "NOME", "TOTAL");
				 for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
					 listaLancamentosUsuarioDTO.get(i).imprimir();
				 }
			}

			private void gerarRelatorioTotalReceitasUsuario() {
				ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
				ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalReceitasUsuarioController();
				
				System.out.print("\n------------ RELATÓRIO - TOTAL DE RECEITAS DOS USUÁRIOS ---------");
				System.out.printf("\n%3s  %-40s  %-10s   \n", "ID", "NOME", "TOTAL");
				 for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
					 listaLancamentosUsuarioDTO.get(i).imprimir();
				 }
			}
			
			
		}





		
	


