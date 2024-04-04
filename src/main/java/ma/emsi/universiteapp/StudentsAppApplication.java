package ma.emsi.universiteapp;

import ma.emsi.universiteapp.entities.Product;
import ma.emsi.universiteapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
    @Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",43000,3));
        productRepository.save(new Product(null,"Printer",3000,3));
        productRepository.save(new Product(null,"Smart Phone",1000,3));
        List<Product> products =productRepository.findAll();
        products.forEach(p ->{
            System.out.println(p.toString());
        } );
        Product product = productRepository.findById(Long.valueOf(2)).get();
        System.out.println("+++++++++++++++++++");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuanitity());
        System.out.println("+++++++++++++++++++++");
        List<Product> productList=  productRepository.findByNameContains("C") ;
        productList.forEach(p -> {
            System.out.println(p);
        });
        System.out.println("+++++++++++++++++++++");
        List<Product> productList1=  productRepository.search("%C%") ;
        productList.forEach(p -> {
            System.out.println(p);
        });
        System.out.println("+++++++++++++++++++++");
        List<Product> productList2=  productRepository.findByPriceGreaterThan(3000) ;
        productList.forEach(p -> {
            System.out.println(p);
        });

    }
}
