package fv.monster;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@SpringBootApplication
public class FvBankSampahApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FvBankSampahApplication.class).run(args);
    }
    
    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
    
}
