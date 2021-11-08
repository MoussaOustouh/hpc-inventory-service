package mo.spring.ms.hpcinventoryservice;

import mo.spring.ms.hpcinventoryservice.entities.Product;
import mo.spring.ms.hpcinventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class HpcInventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpcInventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Product.class);

        return args -> {
            productRepository.save(new Product(null, "Computer", 1000, 30));
            productRepository.save(new Product(null, "Monitor", 800, 20));
            productRepository.save(new Product(null, "Phone", 500, 50));

            productRepository.findAll().forEach(p -> System.out.println(p.toString()));
        };
    }
}
