package cn.edu.seu.sky.aggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaotian on 2022/5/7
 */
@SpringBootApplication(scanBasePackages = {"cn.edu.seu.sky"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
