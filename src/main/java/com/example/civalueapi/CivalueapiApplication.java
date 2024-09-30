package com.example.civalueapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CivalueapiApplication {

/*	@Autowired
	private ShopperRepository shopperRepository;

	@Autowired
	private ProductRepository productRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(CivalueapiApplication.class, args);
	}

	/*// Method that runs after Spring Boot application startup
	@Override
	public void run(String... args) throws Exception {
		// Initialize product data
		productRepository.saveAll(Arrays.asList(
				new Product("BB-20", "babies", "Babyom"),
				new Product("BG-65", "babies", "Girlds"),
				new Product("BB-12", "babies", "Babyom"),
				new Product("BG-38", "babies", "Girlds"),
				new Product("BM-40", "babies", "Mommers")
		));

		// Initialize shopper data with shelves
		Shopper shopper1 = new Shopper();
		shopper1.setShopperId("S-100");
		shopper1.setShelves(Arrays.asList(
				new Shelf(1L,"MB-20", 31.02, shopper1),
				new Shelf(2L,"BB-15", 51.65, shopper1),
				new Shelf(3L,"MB-30", 53.85, shopper1)
		));

		Shopper shopper2 = new Shopper();
		shopper2.setShopperId("S-101");
		shopper2.setShelves(Arrays.asList(
				new Shelf(4L,"MB-55", 20.05, shopper2),
				new Shelf(5L,"BB-35", 67.65, shopper2),
				new Shelf(6L,"MB-75", 11.08, shopper2)
		));

		shopperRepository.saveAll(Arrays.asList(shopper1, shopper2));

		System.out.println("Initialized data on startup!");
	}*/
}
