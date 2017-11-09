package unitywsclient.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import unitywsclient.enderecoRaiz.Constantes;

public class RelatorioUtilStreamTask 
{
	public static final int	RELATORIO_PDF		= 1;
	public static final int	RELATORIO_EXCEL		= 2;
	public static final int	RELATORIO_HTML		= 3;
	public static final int	RELATORIO_PLANILHA_OPEN_OFFICE	= 4;
	
	public InputStream geraRelatorio(String nomeRelatorioJasper,
		String nomeRelatorioSaida, int tipoRelatorio, JRBeanCollectionDataSource cBean) throws UtilException 
	{ 
		InputStream conteudoRelatorio = null;
		try 
		{
			String caminhoRelatorios = Constantes.CAMINHO_SERVIDOR + "/relatorios";
			
			String caminhoArquivoJasper = caminhoRelatorios + File.separator + nomeRelatorioJasper	+ ".jasper"; 
			
			String caminhoArquivoRelatorio = caminhoRelatorios + File.separator + nomeRelatorioSaida;

			JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivoJasper);
			//JRBeanCollectionDataSource classeBean = new JRBeanCollectionDataSource((Collection<?>) cBean);

			JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, null , cBean);
				//(relatorioJasper, parametrosRelatorio);

			String extensao = null;
			File arquivoGerado = null;

			switch (tipoRelatorio) 
			{
				case RelatorioUtilStreamTask.RELATORIO_PDF:
					JRPdfExporter pdfExportado = new JRPdfExporter(); 
					extensao = "pdf";
					arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
					pdfExportado.setExporterInput(new SimpleExporterInput(	impressoraJasper));
					pdfExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivoGerado));
					pdfExportado.exportReport();
					arquivoGerado.deleteOnExit();
					break;
				case RelatorioUtilStreamTask.RELATORIO_HTML:
					HtmlExporter htmlExportado = new HtmlExporter();
					extensao = "html";
					arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
					htmlExportado.setExporterInput(new SimpleExporterInput(impressoraJasper));
					htmlExportado.setExporterOutput(new SimpleHtmlExporterOutput(arquivoGerado));
					htmlExportado.exportReport();
					arquivoGerado.deleteOnExit();
				break;
				case RelatorioUtilStreamTask.RELATORIO_EXCEL:
					JRXlsExporter xlsExportado = new JRXlsExporter();
					extensao = "xls";
					arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
					xlsExportado.setExporterInput(new SimpleExporterInput(	impressoraJasper));
					xlsExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivoGerado));
					xlsExportado.exportReport();
					arquivoGerado.deleteOnExit();
					break;
				case RelatorioUtilStreamTask.RELATORIO_PLANILHA_OPEN_OFFICE:
					JROdtExporter openExportado = new JROdtExporter();
					extensao = "ods";
					arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
					openExportado.setExporterInput(new SimpleExporterInput(impressoraJasper));
					openExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivoGerado));
					openExportado.exportReport();
					arquivoGerado.deleteOnExit();
					break;
			}			

			conteudoRelatorio = new FileInputStream(arquivoGerado);

		} catch (JRException e) {
			throw new UtilException("N�o foi poss�vel gerar o relat�rio." + e, e);
		} catch (FileNotFoundException e) {
			throw new UtilException("Arquivo do relat�rio n�o encontrado." + e, e);
		}
		return conteudoRelatorio;
	}
}
