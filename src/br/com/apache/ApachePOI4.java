package br.com.apache;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class ApachePOI4 {

    public static void main(String[] args) throws Exception {

        File arquivo = new File("C:\\Users\\PICHAU\\Documents\\arquivo_xls.xls");

        FileInputStream entrada = new FileInputStream(arquivo);

        HSSFWorkbook wb = new HSSFWorkbook(entrada);
        HSSFSheet planilha = wb.getSheetAt(0);

        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext()) {
            Row linha = linhaIterator.next();

            String celValor = linha.getCell(0).getStringCellValue();
            linha.getCell(0).setCellValue(celValor + " Valor gravado na aula");
        }
        entrada.close();
        FileOutputStream saida = new FileOutputStream(arquivo);
        wb.write(saida);
        saida.flush();
        saida.close();


        System.out.println("Planilha atualizada");
    }


}