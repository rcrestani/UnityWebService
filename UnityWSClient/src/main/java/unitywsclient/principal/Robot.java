package unitywsclient.principal;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import movimentacao.webservice.UnityWS;
import movimentacao.webservice.UnityWSServiceLocator;
import unitywsclient.enderecoRaiz.Constantes;

public class Robot implements ServletContextListener
{
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public static void telegramBot()
	{	
		UnityWSServiceLocator service = null;
		UnityWS unityWS = null;
		try
		{
			service = new UnityWSServiceLocator();
			unityWS = service.getUnityWSPort(
					new URL(Constantes.enderecoAplicacao));
		}
		catch (Exception e)
		{
			System.out.println("\n\n=======ATIVIDADES ALERTA TG: ERRO NA CONEX�O COM O WEBSERVICE EM " + formatDateHour(new Date()));
			e.printStackTrace();
			System.out.println("=======================================================================\n\n");
		}
		
		//Criação do objeto bot com as informações de acesso
		TelegramBot bot = TelegramBotAdapter.build("344152536:AAGkvoBIMyNaMyfu7ijntUmVMAFv2OYVn4A");
		//bot.execute(new SendMessage(125735555 , "\n\n*TESTE UNITY* \n\nP/ ENVIAR MENSAGEM\n\n=="));
		
		System.out.println("TelegramBot Ativado!");
		
		//objeto responsável por receber as mensagens
		GetUpdatesResponse updatesResponse;
		//objeto responsável por gerenciar o envio de respostas
		SendResponse sendResponse;
		//objeto responsável por gerenciar o envio de ações do chat
		BaseResponse baseResponse;
				
		//controle de off-set, isto é, a partir deste ID será lido as mensagens pendentes na fila
		int m=0;
    	
    	
		//loop infinito pode ser alterado por algum timer de intervalo curto
		while (true)
		{
	    	//executa comando no Telegram para obter as mensagens pendentes a partir de um off-set (limite inicial)
			updatesResponse =  bot.execute(new GetUpdates().limit(100).offset(m));
			
			//lista de mensagens
			List<Update> updates = updatesResponse.updates();
			
			//análise de cada ação da mensagem
			for (Update update : updates) {
				
				//atualização do off-set
				m = update.updateId()+1;
				
				String partes[] = update.message().text().split(" ");
				String itemMenu = partes[0];
				
				if(update.message().text().equals("menu"))
				{
					System.out.println("ID: " + update.message().chat().id());
					//envio de "Escrevendo" antes de enviar a resposta
					baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
					//verificação de ação de chat foi enviada com sucesso
					//System.out.println("Resposta de Chat Action Enviada?" + baseResponse.isOk());
					
					//envio da mensagem de resposta
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Bem-vindo ao Unity-Bot!"));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
							"Menu, escolha a op��o apenas digitando o n�mero:"));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"1 - Pesquisar Cart�es de Visita"));
					//verificação de mensagem enviada com sucesso
					System.out.println("Mensagem Enviada?" +sendResponse.isOk());
					sendResponse = null;
				}
				else if(update.message().text().equals("1"))
				{
					//envio de "Escrevendo" antes de enviar a resposta
					baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
					//verificação de ação de chat foi enviada com sucesso
					System.out.println("Resposta de Chat Action Enviada?" + baseResponse.isOk());
					
					//envio da mensagem de resposta
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Cart�es de Visita:"));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
							"Digite CV [espa�o] e digite o nome ou a Empresa, pode ser qualquer parte destes"));
					//sendResponse = bot.execute(new SendDocument(update.message().chat().id(), new File("/home/rcrestani/Pictures/Batman.jpg")));
					//verificação de mensagem enviada com sucesso
					System.out.println("Mensagem Enviada?" +sendResponse.isOk());
					sendResponse = null;
				}
				else if(itemMenu.equals("CV"))
				{
					int id = Integer.parseInt(String.format("%d", update.message().chat().id()));
					
					try
					{
						unityWS.listaCartaoVisita(update.message().text(), id);
					}
					catch (RemoteException e)
					{
						e.printStackTrace();
					}
				}
				else if(itemMenu.equals("CVID"))
				{
					boolean control = false;
					Integer id = null;
					try
					{
						id = Integer.parseInt(partes[1]);
						control = true;
					}
					catch(Exception e)
					{
						control = false;
						e.getMessage();
					}
					
					if(control == true)
					{
						int idTel = Integer.parseInt(String.format("%d", update.message().chat().id()));
						
						try
						{
							unityWS.cartaoPorId(id, idTel);
						}
						catch (RemoteException e)
						{
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			
	    }
            
	}  
		
	public static void executarTask()
	{		
		 //beep task
        final Runnable beeper = new Runnable() {
            public void run() 
            {
            	try
            	{
            		System.out.println("\n\n..:: ROBOT TELEGRAM INICIOU EM "
							+ formatDateHour(new Date()) + " ::..");
            		telegramBot();
            		System.out.println("=========================================================================================\n\n");
				}
            	catch (Exception e)
            	{
            		System.out.println("\n\n..:: ERRO NA EXECU��O DO ROBOT TELEGRAM EM "
							+ formatDateHour(new Date()) + " ::..");
					e.printStackTrace();
					System.out.println("=========================================================================================\n\n");
				}
            }
        };
        
      
        
        //beep each hour
        /*final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, (Long) null , TimeUnit.MINUTES);*/
        final ScheduledFuture<?> beeperHandle = scheduler.schedule(beeper, 1, TimeUnit.MINUTES);
        //cancel beep task
        @SuppressWarnings("unused")
		final Runnable canceler = new Runnable() {
            public void run() {
                beeperHandle.cancel(false);
            }
        };

        //stop beep after 1 day
        //scheduler.schedule(canceler, 1, TimeUnit.DAYS);
    }
	
	private static String formatDateHour(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy - HH:mm");
		
		return dateFormat.format(data);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		try
		{
			executarTask();
		}
		catch (Exception e)
		{
			 System.err.println(e.getMessage());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		
	}

}
