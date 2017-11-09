package unitywsclient.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import unitywsclient.enderecoRaiz.Constantes;

public class ImpressoraTXT 
{
	private String enderecoArquivo = Constantes.CAMINHO_SERVIDOR + "download" + File.separator + formatDateHour(new Date()) + "_LogServidor.txt";
	
	public void gerarLog()
	{
		FileWriter arquivo = null;
		try {
			arquivo = new FileWriter(enderecoArquivo);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter gravaArquivo = new PrintWriter(arquivo);
		
		gravaArquivo.printf("..:: TESTE DE IMPRESSÃO ::..");
		System.out.println(enderecoArquivo);
		try {
			arquivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String formatDateHour(Date data) 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_-_HH:mm");
		
		return dateFormat.format(data);
	}
}
