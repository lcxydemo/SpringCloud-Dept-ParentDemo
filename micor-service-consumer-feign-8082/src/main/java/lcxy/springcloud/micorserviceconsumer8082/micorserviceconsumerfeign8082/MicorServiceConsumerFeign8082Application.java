package lcxy.springcloud.micorserviceconsumer8082.micorserviceconsumerfeign8082;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
//扫描服务降级的类
@SpringBootApplication(scanBasePackages = {"lcxy.springcloud.micorserviceapi.service","lcxy.springcloud.micorserviceconsumer8082.micorserviceconsumerfeign8082"})
//扫描FeignClient注解所标注的类
@EnableFeignClients(basePackages = {"lcxy.springcloud.micorserviceapi.service","lcxy.springcloud.micorserviceconsumer8082.micorserviceconsumerfeign8082"})
public class MicorServiceConsumerFeign8082Application {

	public static void main(String[] args) {
		SpringApplication.run(MicorServiceConsumerFeign8082Application.class, args);
	}

}
