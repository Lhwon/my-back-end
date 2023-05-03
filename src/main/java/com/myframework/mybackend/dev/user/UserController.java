package com.myframework.mybackend.dev.user;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "UserController", description = "회원정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/frame/user")
public class UserController {

	private final UserService userService;
	
	@Operation(summary="회원정보 조회 ", description="회원정보를 조회한다.")
	@GetMapping("/frame/user/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	@Operation(summary="회원정보 추가 ", description="회원정보를 추가한다.")
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "패스워드가 일치하지 않습니다.");
			return "signup_form";
		}
		
		userService.createUser(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
		
		return "redirect:/";
	}
}
