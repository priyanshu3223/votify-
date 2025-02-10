//package com.app.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.app.dao.RegisterRepository;
//import com.app.entity.Register;
//
//@Service
//public class RegisterService {
//
//    @Autowired
//    private RegisterRepository registerRepository;
//
//    @Autowired
//    private EmailService emailService;
//
//    private boolean isVoterAuthentic(String voterIdNumber, String aadhaar) {
//        Long count = registerRepository.countByVoterIdNumberAndAadhaar(voterIdNumber, aadhaar);
//        return count != null && count > 0;
//    }
//
//    public String addRegister(Register register) {
//        // Check if voter ID or Aadhaar already exists in VoterDetail table
//        if (registerRepository.existsByVoterIdNumber(register.getVoterIdNumber())) {
//            return "Voter ID already registered.";
//        }
//        if (registerRepository.existsByAadhaar(register.getAadhaar())) {
//            return "Aadhaar number already registered.";
//        }
//
//        // Verify voter authenticity using UserData table
//        if (!isVoterAuthentic(register.getVoterIdNumber(), register.getAadhaar())) {
//            return "Voter authenticity check failed.";
//        }
//
//        // Save voter details to VoterDetail table
//        registerRepository.save(register);
//        // Send email with user ID and password
//        String subject = "Welcome to the Online Voting System";
//        String text = "Dear " + register.getfName() + " " + register.getlName() + ",\n\n"
//                + "Your registration is successful.\n"
//                + "Username: " + register.getUsername() + "\n"
//                + "Password: " + register.getPassword() + "\n\n"
//                + "Please keep this information safe.";
//        emailService.sendEmail(register.getUsername(), subject, text);
//        return "Registration successful. Email sent.";
//    }
//
//    public Register getRegisterById(Long id) {
//        return registerRepository.findById(id).orElse(null);
//    }
//
//    public boolean loginCheck(Register reg) {
//        Register foundRegister = registerRepository.findByUsernameAndPassword(reg.getUsername(), reg.getPassword());
//        return foundRegister != null;
//    }
//}
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.RegisterRepository;
import com.app.entity.Register;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private EmailService emailService;

    private boolean isVoterAuthentic(String voterIdNumber, String aadhaar) {
        Long count = registerRepository.countByVoterIdNumberAndAadhaar(voterIdNumber, aadhaar);
        return count != null && count > 0;
    }

    public String addRegister(Register register) {
        // Check if voter ID or Aadhaar already exists in VoterDetail table
        if (registerRepository.existsByVoterIdNumber(register.getVoterIdNumber())) {
            return "Voter ID already registered.";
        }
        if (registerRepository.existsByAadhaar(register.getAadhaar())) {
            return "Aadhaar number already registered.";
        }

        // Verify voter authenticity using UserData table
        if (!isVoterAuthentic(register.getVoterIdNumber(), register.getAadhaar())) {
            return "Voter authenticity check failed.";
        }

        // Save voter details to VoterDetail table
        registerRepository.save(register);
        // Send email with user ID and password
        String subject = "Welcome to the Online Voting System";
        String text = "Dear " + register.getfName() + " " + register.getlName() + ",\n\n"
                + "Your registration is successful.\n"
                + "Username: " + register.getUsername() + "\n"
                + "Password: " + register.getPassword() + "\n\n"
                + "Please keep this information safe.";
        emailService.sendEmail(register.getUsername(), subject, text);
        return "Registration successful. Email sent.";
    }

    public Register getRegisterById(Long id) {
        return registerRepository.findById(id).orElse(null);
    }

    public boolean loginCheck(Register reg) {
        Register foundRegister = registerRepository.findByUsernameAndPassword(reg.getUsername(), reg.getPassword());
        return foundRegister != null;
    }
}