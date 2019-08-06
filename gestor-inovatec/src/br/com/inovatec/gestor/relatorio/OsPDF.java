package br.com.inovatec.gestor.relatorio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hibernate.cfg.Environment;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.inovatec.gestor.modelo.OsModel;

public class OsPDF {

	public void gerarOSPDF(List<OsModel> os) {
		Document document = new Document();
		try {
			File f = new File("C:\\Project\\inovatec\\os.pdf");
		
			if (f.exists()) {
				f.delete();
			}
			
			

			PdfWriter.getInstance(document, new FileOutputStream("C:\\Project\\inovatec\\os.pdf"));
			document.open();

			Image figura = Image.getInstance("C:\\Project\\inovatec\\img\\logo_rel.png");
			document.add(figura);

			document.add(new Paragraph(" "));
			
			 Font font = new Font(FontFamily.HELVETICA, 12, Font.BOLD);

			Paragraph p1 = new Paragraph("*** ORDEM DE SERVIÇO PARA ATENDIMENTO ***",font);
			p1.setAlignment(Element.ALIGN_CENTER);
			document.add(p1);
			document.add(new Paragraph(" "));

			document.add(new Paragraph("RAZÃO SOCIAL: " + os.get(0).getCliente().getRazaoSocial()));
			document.add(new Paragraph("NOME FANTASIA: " + os.get(0).getCliente().getNomeFantasia()));
			document.add(new Paragraph("CNPJ/CPF: " + os.get(0).getCliente().getCnpj_cpf()));
			document.add(new Paragraph("ENDEREÇO: " + os.get(0).getCliente().getEndereco() + " - "
					+ os.get(0).getCliente().getCidade() + " - " + os.get(0).getCliente().getEstado()));
			document.add(new Paragraph("CEP: " + os.get(0).getCliente().getCep()));
			document.add(new Paragraph("TELEFONE: " + os.get(0).getCliente().getTelefone()));
			document.add(new Paragraph("E-MAIL: " + os.get(0).getCliente().getEmail()));
			document.add(new Paragraph("CONTRATO: " + os.get(0).getCliente().getContrato()));

			document.add(new Paragraph(" "));

			document.add(new Paragraph("N° O.S: " + os.get(0).getOs_id()));
			document.add(new Paragraph("DATA ABERTURA: " + os.get(0).getData_abertura_os()));
			document.add(new Paragraph("MOTIVO: " + os.get(0).getMotivo()));
			document.add(new Paragraph("VALOR VISITA: " + os.get(0).getValor()));
			document.add(new Paragraph("VALOR HORA: " + os.get(0).getValor_hora()));
			
			document.add(new Paragraph(" "));
			
			Paragraph p2 = new Paragraph("SERVIÇO/OBSERVAÇÕES:",font);
			document.add(p2);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			
			
			Paragraph p3 = new Paragraph("HORA INÍCIO ATENDIMENTO:__________    /   HORA FIM ATENDIMENTO:__________",font);
			p3.setAlignment(Element.ALIGN_CENTER);
			document.add(p3);
			document.add(new Paragraph(" "));
			Paragraph p4 = new Paragraph("DATA:__ / __/____",font);
			document.add(p4);
			
			document.add(new Paragraph(" "));
			
			Paragraph p5 = new Paragraph("SUGESTÃO DO CLIENTE:",font);
			document.add(p5);
			
	
			try {
				java.awt.Desktop.getDesktop().open( new File( "C:\\Project\\inovatec\\os.pdf" ) );
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}
}
