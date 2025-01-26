package com.aida.controller;

import com.aida.model.VerificationCode;
import com.aida.repository.VerificationCodeRepository;
import com.aida.request.LoginRequest;
import com.aida.response.ApiResponse;
import com.aida.response.AuthResponse;
import com.aida.service.AuthService;
import com.aida.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;
    private final VerificationCodeRepository verificationCodeRepository;
    private final AuthService authService;


//    @PostMapping("/sent/login-otp")
//    public ResponseEntity<ApiResponse> sentOtpHandler(@RequestBody VerificationCode req) throws Exception {
//        authService.sentLoginOtp(req.getEmail());
//        ApiResponse res = new ApiResponse();
//        res.setMessage("otp send successfully");
//        return ResponseEntity.ok(res);
//
//    }




    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginSeller( @RequestBody LoginRequest req) throws Exception {

        String otp = req.getOtp();
        String email = req.getEmail();

        req.setEmail("seller_"+email);
        AuthResponse authResponse = authService.signing(req);


    return ResponseEntity.ok(authResponse);

    }




}
