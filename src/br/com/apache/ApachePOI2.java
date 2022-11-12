package br.com.apache;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePOI2 {

    public static void main(String[] args) throws IOException {

        FileInputStream arquivo = new FileInputStream(new File("C:\\Users\\PICHAU\\Documents\\arquivo_xls.xls"));

        HSSFWorkbook wb = new HSSFWorkbook(arquivo);
        HSSFSheet planilha = wb.getSheetAt(0);

        Iterator<Row> linhaIterator = planilha.iterator();

        List<pessoa> pessoas = new ArrayList<pessoa>();

        while (linhaIterator.hasNext()) {
            Row linha = linhaIterator.next();

            Iterator<Cell> celulas = linha.iterator();

            pessoa pessoa = new pessoa();

            while (celulas.hasNext()){
            Cell celula = celulas.next();

            switch (celula.getColumnIndex()){
                case 0 : pessoa.setNome(celula.getStringCellValue());
                break;
                case 1 : pessoa.setIdade(Double.valueOf(celula.getNumericCellValue()).intValue());
                break;
                case 2 : pessoa.setEmail(celula.getStringCellValue());
            }

            }
            pessoas.add(pessoa);
        }

        arquivo.close();

        for (pessoa pessoa : pessoas ) {
            System.out.println(pessoa);
        }
    }
}