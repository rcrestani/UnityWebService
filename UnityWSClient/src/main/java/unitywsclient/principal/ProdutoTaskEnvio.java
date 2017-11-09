package unitywsclient.principal;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import movimentacao.webservice.*;
import unitywsclient.enderecoRaiz.Constantes;
import unitywsclient.util.JavaMailApp;
import unitywsclient.util.RelatorioUtilStreamTask;
import unitywsclient.util.UtilException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ProdutoTaskEnvio
{
	private static List<Produto> lista = new ArrayList<Produto>();
	private static List<ProdutoTask> listaProdTask = new ArrayList<ProdutoTask>();
	private static JavaMailApp jMail = new JavaMailApp();
	private static int tipoRelatorio;
	private static InputStream conteudoRetorno;
	
	private static Calendar calendar = Calendar.getInstance();
	
	private static int minutoAtual = 0;
	private static int horaAtual = 0;
	
	public void enviaRelatorio() throws UtilException, IOException, Exception
    {
		UnityWSServiceLocator service = null;
		UnityWS unityWS = null;
		try
		{
			service = new UnityWSServiceLocator();
			unityWS = service.getUnityWSPort(
					new URL(Constantes.enderecoAplicacao));
		    listaProdTask = Arrays.asList(unityWS.listaProdutoTask());
		}
		catch (Exception e)
		{
			System.out.println("\n\n=======ERRO NA CONEXÃO COM O WEBSERVICE EM " + formatDateHour(new Date()));
			e.printStackTrace();
			System.out.println("=======================================================================\n\n");
		}
		
	    		    	
	    for(int x = 0; x < listaProdTask.size(); x++)
	    {
	    	ProdutoTask produtoTask = new ProdutoTask();
	    	horaAtual = 0;
	    	minutoAtual = 0;
	    	
	    	produtoTask = listaProdTask.get(x);
	    	
	    	int diaSemanaAtual = calendar.get(Calendar.DAY_OF_WEEK);
	    	horaAtual = Integer.parseInt(formatHour(new Date()));
	    	minutoAtual = Integer.parseInt(formatMin(new Date()));
	    	
	    	List<String> dias = Arrays.asList(produtoTask.getDiasDaSemana());
	    	
	    	//Verificar se Ã© o dia da semana da tarefa========================================
	    	if(dias.contains(diaDaSemana(diaSemanaAtual)) && produtoTask.isStatus() == true)
	    	{
	    		//Verificar se Ã© a hora da tarefa=============================================
	    		if(produtoTask.getHora() == horaAtual && minutoAtual < 10)
	    		{
	    			tipoRelatorio = 1;
	    			
	    			lista = Arrays.asList(unityWS.listaProduto());
	    	    		    	    	
	    			String nomeRelatorioJasper = "PosicaoEstoque";
	    			String nomeRelatorioSaida = "PosicaoEstoque_" + formatDate(new Date());
	    			RelatorioUtilStreamTask relatorioUtilStream = new RelatorioUtilStreamTask();
	    			JRBeanCollectionDataSource cBean = new JRBeanCollectionDataSource(lista);	
	    			System.out.println("Carregou o Web Service");
	    			conteudoRetorno = relatorioUtilStream.geraRelatorio(nomeRelatorioJasper, nomeRelatorioSaida, tipoRelatorio, cBean);
	    			
	    			jMail.setDestinatario(produtoTask.getEmails());
	    			jMail.setAssunto(produtoTask.getNomeRelatorio());
	    			jMail.setMsg("Olá,<br><br>Segue em anexo o Relatório da posição do estoque, gerado em "
	    							+ formatDate(new Date()) + "."
	    							+ "<br><br>Atenciosamente,"
									+ "<br><br><b><i>Equipe Performancelab</i></b>");
	    					
	    			jMail.setArquivo(conteudoRetorno);
	    			jMail.setApplicationType("application/pdf");
	    			jMail.setNomeArquivo("PosicaoEstoque_" + formatDate(new Date()) + ".pdf");
	    		
	    			jMail.sendMail();
	    		}
	    	}
	    }	
    }
    
	private static String formatDateHour(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy - k:m");
		
		return dateFormat.format(data);
	}
	
    private static String formatDate(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		return dateFormat.format(data);
	}
    
	private static String formatHour(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("k");
		
		return dateFormat.format(data);
	}
	
	private static String formatMin(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("m");
		
		return dateFormat.format(data);
	}
	
	private static String diaDaSemana(int dia)
	{
		String diaDaSemana = "";
		
		switch (dia)
		{
			case 1:
				diaDaSemana = "domingo";
				break;
				
			case 2:
				diaDaSemana = "segunda";
				break;
			
			case 3:
				diaDaSemana = "terca";
				break;
				
			case 4:
				diaDaSemana = "quarta";
				break;
				
			case 5:
				diaDaSemana = "quinta";
				break;
				
			case 6:
				diaDaSemana = "sexta";
				break;
				
			case 7:
				diaDaSemana = "sabado";
				break;
		}
		
		return diaDaSemana;
	}
    
}
