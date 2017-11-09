package unitywsclient.principal;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import movimentacao.webservice.AtividadesDoDia;
import movimentacao.webservice.UnityWS;
import movimentacao.webservice.UnityWSServiceLocator;
import movimentacao.webservice.UsuarioWS;
import unitywsclient.enderecoRaiz.Constantes;
import unitywsclient.util.JavaMailApp;

public class AtividadesDoDiaEmail 
{
	private static JavaMailApp jMail = new JavaMailApp();
	private static AtividadesDoDia atividades = new AtividadesDoDia();
	private static boolean status = false;
	private static List<UsuarioWS> listaUsuario = new ArrayList<UsuarioWS>();
	private static List<AtividadesDoDia> atividadesDoDia = new ArrayList<AtividadesDoDia>();
	
	@SuppressWarnings({ "static-access" })
	public void enviaRelatorio() throws IOException
	{
		int minutoAtual = Integer.parseInt(formatMin(new Date()));
		if(formatHour(new Date()).equals("8") && minutoAtual < 10)
		{
			UnityWSServiceLocator service = null;
			UnityWS unityWS = null;
			try
			{
				service = new UnityWSServiceLocator();
				unityWS = service.getUnityWSPort(
						new URL(Constantes.enderecoAplicacao));
				atividadesDoDia = Arrays.asList(unityWS.ativDoDia());
				this.status = true;
			}
			catch (Exception e)
			{
				this.status = false;
				System.out.println("\n\n=======ATIVIDADES DO DIA E-MAIL: ERRO NA CONEXÃO COM O WEBSERVICE EM " + formatDateHour(new Date()));
				e.printStackTrace();
				System.out.println("===================================================================================================\n\n");
			}
			
			if(this.status == true)
			{
		    //Coletando os usuarios que possuem atividades e com HashSet eliminando os usuarios repetidos na listagem========
				for(int z = 0; z < atividadesDoDia.size(); z++)
				{
					this.listaUsuario.add(atividadesDoDia.get(z).getUsuario());
				}
				HashSet<UsuarioWS> usuarioUnico = new HashSet<UsuarioWS>();
				usuarioUnico.addAll(this.listaUsuario);
				this.listaUsuario.clear();
				this.listaUsuario.addAll(usuarioUnico);
			//================================================================================================================
			//Rodando os fors para enviar as atividades para cada usuario=====================================================	
				for(int x = 0; x < this.listaUsuario.size(); x++)
				{
					String textAtividades = "";
					for(int y = 0; y < this.atividadesDoDia.size(); y++)
					{
						if(this.atividadesDoDia.get(y).getUsuario().equals(this.listaUsuario.get(x)))
						{
							this.atividades = atividadesDoDia.get(y);
							textAtividades = "<b>Cliente:</b> " + this.atividades.getCliente()
											+ "<br><b>Ação:</b> " + this.atividades.getAcao()
											+ "<br><b>Prazo:</b> " + formatDateHour(this.atividades.getPrazo())
											+ "<br><b>Valor:</b> " + String.format("R$%.2f", this.atividades.getValor())
											+ "<br><b>Obs:</b> " + this.atividades.getObs()
											+ "<br><h3>::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::</h3><br>"
											+ textAtividades;
						}
						
					}
										
					jMail.setDestinatario(this.listaUsuario.get(x).getEmail());
					jMail.setAssunto("Unity - Atividades de Hoje");
					jMail.setMsg("<center><h2>Unity - Atividades de Hoje</h2></center>"
								+"<br>Olá "+ this.listaUsuario.get(x).getNome() + "," 
								+"<br><br>Abaixo estão as suas atividades de hoje ("+ formatDate(new Date()) + "):"
								+"<br><br>"
								+ textAtividades
								+ "<br><br>Atenciosamente,"
								+ "<br><br><b><i>Equipe Performancelab</i></b>");
				
					jMail.sendMail();
					
					jMail = new JavaMailApp();
				}
			}
		}
	}
	
	private String formatDate(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(data);
	}
	
	private String formatDateHour(Date date) 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - H:mm");
		
		return dateFormat.format(date);
	}
	
	private static String formatHour(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("H");
		
		return dateFormat.format(data);
	}
	
	private static String formatMin(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("m");
		
		return dateFormat.format(data);
	}
}

