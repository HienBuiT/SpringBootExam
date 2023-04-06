package lab3.model;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {	
	@NotBlank(message="{NotBlank.student.name}")
	String name;
	@NotBlank(message="{NotBlank.student.email}")
	@Email(message="{Email.student.email}")
	String email;
	@Min(0)
	@Max(10)
	@NotNull(message="{NotNull.student.mark}")
	Double marks;
	@NotNull(message="Please choose your gender!")
	Boolean gender;
	@NotBlank(message="Please choose your faculty!")
	String faculty;
	@NotEmpty(message="Please choose your hobby!")
	List<String> hobbies;
	
	MultipartFile imageFile;
	String imageUrl;
}
