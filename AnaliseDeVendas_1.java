package package16_ProgramacaoFuncional.challenge.desafio_AnaliseDeVendas_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import package16_ProgramacaoFuncional.challenge.desafio_AnaliseDeVendas_1.entities.Sale;

public class AnaliseDeVendas_1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		System.out.print("Entre o caminho do arquivo: C:\\temp\\in.csv");

		String path = "C:\\temp\\in.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Sale> sales = new ArrayList<>();

			String line = br.readLine();

			while (line != null) {
				//@formatter:off
				String[] fields = line.split(",");
				sales.add(new Sale(Integer.parseInt(fields[0]),
								   Integer.parseInt(fields[1]),
								   fields[2],
								   Integer.parseInt(fields[3]),
								   Double.parseDouble(fields[4])));
				//@formatter:on
				line = br.readLine();
			}
			System.out.println("\n\nCinco primeiras vendas de 2016 de maior preço médio ");

			//@formatter:off
			List<String> report = sales.stream().filter(s -> s.getYear() == 2016)
												.sorted((s1,s2) -> s2.getAveragePrice().compareTo(s1.getAveragePrice()))
												.map(s -> s.getMonth() + "/" + s.getYear() +", "
														+ s.getSeller() +", " + s.getItems() + ", "
														+ String.format("%.2f", s.getTotal()) + ", pm = "
														+ String.format("%.2f", s.getAveragePrice()))
												.limit(5)
												.toList();
												//@formatter:on
			report.forEach(System.out::println);
			
			Double salesJanLogan = sales.stream().filter(s -> s.getSeller().equals("Logan"))
												 .filter(s -> s.getMonth() == 1 || s.getMonth() == 7)
												 .map(s -> s.getTotal())
												 .reduce(0.0, (x,y) -> x + y);
			
			System.out.println("\nValor total vendido pelo vendedor Logan nos meses 1 e 7 = " + salesJanLogan);
		
		} catch (IOException e) {
			System.out.println("Erro: c:\\in (O sistema não pode encontrar o arquivo especificado)");
		}
	}

}
