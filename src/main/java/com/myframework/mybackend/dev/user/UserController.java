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

@Tag(name = "UserController", description = "ȸ������")
@RestController
@RequiredArgsConstructor
@RequestMapping("/frame/user")
public class UserController {

	private final UserService userService;
	
	@Operation(summary="ȸ������ ��ȸ ", description="ȸ�������� ��ȸ�Ѵ�.")
	@GetMapping("/frame/user/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	@Operation(summary="ȸ������ �߰� ", description="ȸ�������� �߰��Ѵ�.")
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "�н����尡 ��ġ���� �ʽ��ϴ�.");
			return "signup_form";
		}
		
		userService.createUser(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
		
		return "redirect:/";
	}
}
