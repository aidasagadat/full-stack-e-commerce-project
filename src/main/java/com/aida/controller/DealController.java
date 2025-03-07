package com.aida.controller;

import com.aida.model.Deal;
import com.aida.response.ApiResponse;
import com.aida.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/deals")
public class DealController {
    private final DealService dealService;

    public ResponseEntity<Deal> createDeals(@RequestBody Deal deals){
        Deal createdDeals = dealService.createDeal(deals);
        return new ResponseEntity<>(createdDeals, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Deal> updateDeal(@PathVariable Long id, @RequestBody Deal deal) throws Exception {
        Deal updatedDeal = dealService.updateDeal(deal, id);
        return ResponseEntity.ok(updatedDeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteDeals(@PathVariable Long id) throws Exception {
        dealService.deleteDeal(id);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Deal deleted");

        return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);

    }

}
