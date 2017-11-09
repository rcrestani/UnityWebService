package unitywsclient.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import unitywsclient.principal.AtividadesAlertaTG;
import unitywsclient.principal.AtividadesDoDiaEmail;
import unitywsclient.principal.ProdutoTaskEnvio;

public class CentralTask implements ServletContextListener
{
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private static ProdutoTaskEnvio pdtTask = null;
	private static AtividadesDoDiaEmail atividadesDoDia = null;
	private static AtividadesAlertaTG atividadesAlertaTG = null;
	private static int minutoAtual = 0;
	private static int auxDelay = 0;
	
	public static void executarTask()
	{		
		 //beep task
        final Runnable beeper = new Runnable() {
            public void run() 
            {
            	try 
            	{
            		System.out.println("\n\n..:: CENTRAL TASK EXECUTOU ENVIO DA POSIÇÃO DO ESTOQUE EM "
										+ formatDateHour(new Date()) + " ::.." + "\n" + "DELAY = " + auxDelay);
					pdtTask = new ProdutoTaskEnvio();
					pdtTask.enviaRelatorio();
					
				} 
            	catch (Exception e) 
            	{
            		System.out.println("\n\n..:: ERRO NO ENVIO DA POSIÇÃO DO ESTOQUE PELA CENTRAL TASK EM "
            							+ formatDateHour(new Date()) + " ::..");
            		e.printStackTrace();
            		System.out.println("========================================================================================\n\n");
				}
            	
            	try
            	{
            		System.out.println("\n\n..:: CENTRAL TASK EXECUTOU ENVIO DAS ATIVIDADES DO DIA POR USUÁRIO EM "
							+ formatDateHour(new Date()) + " ::..");
            		atividadesDoDia = new AtividadesDoDiaEmail();
            		atividadesDoDia.enviaRelatorio();
            	}
            	catch (Exception e) 
            	{
            		System.out.println("\n\n..:: ERRO NO ENVIO DAS ATIVIDADES DO DIA POR USUÁRIO PELA CENTRAL TASK EM "
            							+ formatDateHour(new Date()) + " ::..");
            		e.printStackTrace();
            		System.out.println("=========================================================================================\n\n");
				}
            	
            	try
            	{
            		System.out.println("\n\n..:: CENTRAL TASK EXECUTOU ENVIO DO ALERTA DE ATIVIDADES POR USUÁRIO VIA TELEGRAM EM "
							+ formatDateHour(new Date()) + " ::..");
            		atividadesAlertaTG = new AtividadesAlertaTG();
            		atividadesAlertaTG.enviaRelatorio();
            	}
            	catch (Exception e) 
            	{
            		System.out.println("\n\n..:: ERRO NO ENVIO DO ALERTA DE ATIVIDADES POR USUÁRIO VIA TELEGRAM PELA CENTRAL TASK EM "
            							+ formatDateHour(new Date()) + " ::..");
            		e.printStackTrace();
            		System.out.println("=========================================================================================\n\n");
				}
            	
            }
        };
        
        minutoAtual = Integer.parseInt(formatMin(new Date()));
        
        if(minutoAtual < 30)
        {
        	auxDelay = 30 - minutoAtual;
        }
        else if(minutoAtual >= 30)
        {
        	auxDelay = 60 - minutoAtual;
        }
        
        //beep each hour
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, auxDelay, 30 , TimeUnit.MINUTES);

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
	
	private static String formatMin(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("m");
		
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
