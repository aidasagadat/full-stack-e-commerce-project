package com.aida.controller;

import com.aida.model.*;
import com.aida.response.ApiResponse;
import com.aida.response.PaymentLinkResponse;
import com.aida.service.PaymentService;
import com.aida.service.SellerReportService;
import com.aida.service.SellerService;
import com.aida.service.UserService;
import com.aida.service.impl.SellerReportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final UserService userService;
    private final SellerService sellerService;
    private final SellerReportServiceImpl sellerReportServiceImpl;
    private final SellerReportService sellerReportService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<ApiResponse> paymentSuccessHandler(
            @PathVariable String paymentId,
            @RequestParam String paymentLinkId,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        PaymentLinkResponse paymentResponse;

        PaymentOrder paymentOrder = paymentService
                .getPaymentOrderByPaymentId(paymentLinkId);

        boolean paymentSuccess = paymentService.ProceedPaymentOrder(
                paymentOrder, paymentId, paymentLinkId
        );

        if(paymentSuccess){
            for(Order order:paymentOrder.getOrders()){
                Seller seller = sellerService.getSellerById(order.getSellerId());
                SellerReport report = sellerReportService.getSellerReport(seller);
                report.setTotalOrders(report.getTotalOrders()+1);
                report.setTotalEarnings(report.getTotalEarnings()+order.getTotalSellingPrice());
                report.setTotalSales(report.getTotalSales()+order.getOrderItems().size());
                sellerReportService.updateSellerReport(report);

            }
        }

        ApiResponse res = new ApiResponse();
        res.setMessage("Payment successful");

        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

}
