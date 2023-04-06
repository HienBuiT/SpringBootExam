package lab3.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import lab3.model.Student;

@Controller
public class StudentController {
	@RequestMapping("student/form")
	public String index(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}

	@Autowired
	ServletContext app;

	@RequestMapping("student/save")
	public String save(@Valid @ModelAttribute("student") Student student,BindingResult result)
			throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			
		}
		if(!student.getImageFile().isEmpty()) {
			try {
				String filename = student.getImageFile().getOriginalFilename();
				File file = new File(app.getRealPath("/images/" + filename));
				student.getImageFile().transferTo(file);
				student.setImageUrl("/images/" + filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return "form";
	}

	@ModelAttribute("genders")
	public Map<Boolean, String> getGenders() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Male");
		map.put(false, "Female");
		return map;
	}

	@ModelAttribute("faculties")
	public List<String> getFaculties() {
		return Arrays.asList("CNTT", "DLNHKS", "QTDN");
	}

	@ModelAttribute("hobbies")
	public Map<String, String> getHobbies() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "Travelling");
		map.put("M", "Music");
		map.put("F", "Food");
		map.put("O", "Other");
		return map;
	}
}
