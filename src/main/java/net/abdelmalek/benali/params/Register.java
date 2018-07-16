package net.abdelmalek.benali.params;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Register {
    String id;
	String firstName;
	String lastName;
	String adress;
	String zipCode;
	String town;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dateBirth;
	String email;
}
