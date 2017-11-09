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

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.request.SendMessage;

import movimentacao.webservice.AtividadesDoDia;
import movimentacao.webservice.UnityWS;
import movimentacao.webservice.UnityWSServiceLocator;
import movimentacao.webservice.UsuarioWS;
import unitywsclient.enderecoRaiz.Constantes;

public class AtividadesAlertaTG 
{
	private static AtividadesDoDia atividades;
	private static boolean status = false;
	private static List<UsuarioWS> listaUsuario = new ArrayList<UsuarioWS>();
	private static List<AtividadesDoDia> atividadesDoDia = new ArrayList<AtividadesDoDia>();
	
	@SuppressWarnings({ "static-access" })
	public void enviaRelatorio() throws IOException
	{
		TelegramBot bot = TelegramBotAdapter.build("344152536:AAGkvoBIMyNaMyfu7ijntUmVMAFv2OYVn4A");
		UnityWSServiceLocator service = null;
		UnityWS unityWS = null;
		try
		{
			service = new UnityWSServiceLocator();
			unityWS = service.getUnityWSPort(
					new URL(Constantes.enderecoAplicacao));
			atividadesDoDia = Arrays.asList(unityWS.ativDoDia());
			this.atividades = new AtividadesDoDia();
			this.status = true;
		}
		catch (Exception e)
		{
			this.status = false;
			System.out.println("\n\n=======ATIVIDADES ALERTA TG: ERRO NA CONEXÃO COM O WEBSERVICE EM " + formatDateHour(new Date()));
			e.printStackTrace();
			System.out.println("=======================================================================\n\n");
		}
		
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
				//For das atividades do usuário===============================================================
				for(int y = 0; y < this.atividadesDoDia.size(); y++)
				{
					//Filtrando apenas as atividades do usuário==============================================
					if(this.atividadesDoDia.get(y).getUsuario().equals(this.listaUsuario.get(x)))
					{
						this.atividades = atividadesDoDia.get(y);
						textAtividades = "Cliente: " + this.atividades.getCliente()
										+ "\nAção: " + this.atividades.getAcao()
										+ "\nPrazo: " + formatDateHour(this.atividades.getPrazo())
										+ "\n\n"
										+ textAtividades;	
					}
					
				}
				
				//Convertendo horas e minutos em inteiros para enviar as mensagens de acordo com o horário das atividades========
				int horaAtividade = Integer.parseInt(formatHour(this.atividades.getPrazo()));
				int minutoAtividade = Integer.parseInt(formatMin(this.atividades.getPrazo()));
				
				int horaAtual = Integer.parseInt(formatHour(new Date()));
				int minutoAtual = Integer.parseInt(formatMin(new Date()));
				
				/*Verificando se o horário da atividade é igual ao horário atual
				 * Também controle com o booleano status se houve atividades na consulta*/
				if(horaAtual == horaAtividade && minutoAtual < (minutoAtividade + 10) && status == true)
				{					
					System.out.println("Envio p/ o Telegram de: " + this.listaUsuario.get(x).getNome() + " em " + formatDateHour(new Date())
							+ "\nTelegram ID: " + this.listaUsuario.get(x).getTelegramId());
					if(horaAtual > 6 && horaAtual < 12)
					{
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , this.listaUsuario.get(x).getNome() + ", Bom dia!!"));
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , "Alerta de Atividades a vencer:"));
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , textAtividades));
					}
					else if(horaAtual > 12 && horaAtual < 18)
					{
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , this.listaUsuario.get(x).getNome() + ", Boa tarde!!"));
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , "Alerta de Atividades a vencer:"));
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , textAtividades));
					}
					else if(horaAtual > 18 && horaAtual < 23)
					{
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , this.listaUsuario.get(x).getNome() + ", Boa noite!!"));
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , "Alerta de Atividades a vencer:"));
						bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , textAtividades));
					}
					
					bot.execute(new SendMessage(this.listaUsuario.get(x).getTelegramId() , "Até logo!"));
				}
				
				
			}
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
