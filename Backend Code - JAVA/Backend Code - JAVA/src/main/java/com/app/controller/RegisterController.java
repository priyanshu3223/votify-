//package com.app.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.app.entity.Register;
//import com.app.service.RegisterService;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletResponse;
//
//@CrossOrigin(origins = "http://localhost:3000") // Adjust if frontend runs on a different port
//@RestController
//@RequestMapping("/api/register")
//public class RegisterController {
//
//    @Autowired
//    private RegisterService registerService;
//
////    @PostMapping("/add")
////    public ResponseEntity<Register> addRegister(@RequestBody Register register) {
////        registerService.addRegister(register);
////        return ResponseEntity.ok(register);
////    }
//    @PostMapping("/add")
//    public ResponseEntity<?> addRegister(@RequestBody Register register) {
//        System.out.println("Received Registration Request: " + register);
//        
//        String result = registerService.addRegister(register);
//        System.out.println("Service Response: " + result);
//        
//        if (result.contains("successful")) {
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.status(400).body(result);
//        }
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Register reg, HttpServletResponse response) {
//        if (registerService.loginCheck(reg)) {
//            Cookie loginCookie = new Cookie("username", reg.getUsername());
//            loginCookie.setMaxAge(30 * 60); // Set cookie expiry to 30 minutes
//            response.addCookie(loginCookie);
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Register> getRegisterById(@PathVariable Long id) {
//        Register register = registerService.getRegisterById(id);
//        return ResponseEntity.ok(register);
//    }
//
//    @GetMapping("/vote")
//    public ResponseEntity<String> votingPage() {
//        return ResponseEntity.ok("You can vote now.");
//    }
//}
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.entity.Register;
import com.app.service.RegisterService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000") // Adjust if frontend runs on a different port
@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

//    @PostMapping("/add")
//    public ResponseEntity<Register> addRegister(@RequestBody Register register) {
//        registerService.addRegister(register);
//        return ResponseEntity.ok(register);
//    }
    @PostMapping("/add")
    public ResponseEntity<?> addRegister(@RequestBody Register register) {
        System.out.println("Received Registration Request: " + register);
        
        String result = registerService.addRegister(register);
        System.out.println("Service Response: " + result);
        
        if (result.contains("successful")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(400).body(result);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Register reg, HttpServletResponse response) {
        if (registerService.loginCheck(reg)) {
            Cookie loginCookie = new Cookie("username", reg.getUsername());
            loginCookie.setMaxAge(30 * 60); // Set cookie expiry to 30 minutes
            response.addCookie(loginCookie);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Register> getRegisterById(@PathVariable Long id) {
        Register register = registerService.getRegisterById(id);
        return ResponseEntity.ok(register);
    }

    @GetMapping("/vote")
    public ResponseEntity<String> votingPage() {
        return ResponseEntity.ok("You can vote now.");
    }
}
