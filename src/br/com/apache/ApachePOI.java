package br.com.apache;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePOI {

    public static void main(String[] args) throws IOException {

        File arquivo = new File("C:\\Users\\PICHAU\\Documents\\arquivo_xls.xls");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        pessoa pessoa1 = new pessoa();
        pessoa pessoa2 = new pessoa();
        pessoa pessoa3 = new pessoa();

        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(50);
        pessoa1.setNome("Aleatorio");

        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(30);
        pessoa2.setNome("Aleatorio 2");

        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(20);
        pessoa3.setNome("Aleatorio 3");

        List<pessoa> pessoas = new ArrayList<pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        HSSFWorkbook wb = new HSSFWorkbook(); /*método usado para criar planilha*/
        HSSFSheet criaPlanilha = wb.createSheet("Planilha de dados de pessoas");

        int criaLinha = 0;

        for (pessoa p : pessoas){
            Row linha = criaPlanilha.createRow(criaLinha++);

            int criaCelula = 0;

            Cell celulaNome = linha.createCell(criaCelula++);
            celulaNome.setCellValue(p.getNome());

            Cell celulaIdade = linha.createCell(criaCelula++);
            celulaIdade.setCellValue(p.getIdade());

            Cell celulaEmail = linha.createCell(criaCelula++);
            celulaEmail.setCellValue(p.getEmail());
        }

        FileOutputStream saida = new FileOutputStream(arquivo);
        wb.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Planilha criada com sucesso");

    }
}