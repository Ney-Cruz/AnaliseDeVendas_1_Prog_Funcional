package package16_ProgramacaoFuncional.challenge.desafio_AnaliseDeVendas_1.entities;

public class Sale {
	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double total;

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}

	public Double averagePrice() {
		return total / items;
	}

	
	public Double getAveragePrice() {
		return averagePrice();
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		//@formatter:off
		return 	"\n"
				+ month + "/" 
				+ year + ", " 
				+ seller + ", " 
				+ items + ", "
				+ String.format("%.2f", total)
				+ " pm = " + String.format("%.2f", averagePrice());
				//@formatter:on
	}

}
