package com.zzx.filterlistenerintercept;

import com.zzx.filterlistenerintercept.enums.Enums;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FilterlistenerinterceptApplication {

	public static void main(String[] args) {
		/*System.out.println(Enums.SF.code("申通"));
		System.out.println(Enums.SF.complay(456));
		System.out.println(Enums.SF.getCode());
		System.out.println(Enums.SF.getComplay());*/
		SpringApplication.run(FilterlistenerinterceptApplication.class, args);
	}
}
