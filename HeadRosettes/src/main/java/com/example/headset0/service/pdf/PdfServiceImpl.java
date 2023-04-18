package com.example.headset0.service.pdf;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.headset0.model.buy.BuyDAO;
import com.example.headset0.model.buy.BuyDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfServiceImpl implements PdfService {
	@Autowired
	BuyDAO buyDao;

	@Override
	public String createPdf() {
		String result="";
		try {
			Document document=new Document();
			PdfWriter.getInstance(document, new FileOutputStream("c:/work/주문내역.pdf"));
			document.open();
			BaseFont baseFont=BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font=new Font(baseFont, 12);
			PdfPTable table=new PdfPTable(8);
			Chunk chunk=new Chunk("주문내역 PDF", font);
			Paragraph ph=new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			PdfPCell cell1=new PdfPCell(new Phrase("주문자 아이디", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell1);
			
			PdfPCell cell2=new PdfPCell(new Phrase("주문자 이름", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell2);
			
			PdfPCell cell3=new PdfPCell(new Phrase("배송지 주소", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell3);
			
			PdfPCell cell4=new PdfPCell(new Phrase("주문자 연락처", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell4);
			
			PdfPCell cell5=new PdfPCell(new Phrase("주문자 이메일주소", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell5);
			
			PdfPCell cell6=new PdfPCell(new Phrase("주문날짜", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell6);
			
			PdfPCell cell7=new PdfPCell(new Phrase("주문금액", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell7);
			
			PdfPCell cell8=new PdfPCell(new Phrase("배송현황", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell8);
			
			List<BuyDTO> items = buyDao.total_buy_list();
			for (int i=0; i<items.size(); i++) {
				BuyDTO dto=items.get(i);
				
				PdfPCell cellM_id=new PdfPCell(new Phrase(dto.getM_id(), font));
				table.addCell(cellM_id);
				
				PdfPCell cellM_name=new PdfPCell(new Phrase(dto.getM_name(), font));
				table.addCell(cellM_name);
				
				PdfPCell cellAddress=new PdfPCell(new Phrase(dto.getAddress(), font));
				table.addCell(cellAddress);
				
				PdfPCell cellM_phone=new PdfPCell(new Phrase(dto.getM_phone(), font));
				table.addCell(cellM_phone);
				
				PdfPCell cellM_email=new PdfPCell(new Phrase(dto.getM_email(), font));
				table.addCell(cellM_email);
				
				PdfPCell cellB_date=new PdfPCell(new Phrase(""+dto.getB_date(), font));
				table.addCell(cellB_date);
				
				PdfPCell cellMoney=new PdfPCell(new Phrase(""+dto.getMoney(), font));
				table.addCell(cellMoney);	
				
				PdfPCell cellB_state=new PdfPCell(new Phrase(dto.getB_state(), font));
				table.addCell(cellB_state);
			}
				document.add(table);
				document.close();
				result="pdf 파일이 생성되었습니다.";
		} catch (Exception e) {
			e.printStackTrace();
			result="pdf 파일 생성 실패";
		}
		return result;
	}


}
