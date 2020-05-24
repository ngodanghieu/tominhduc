package com.payment.wallet.controller;

import com.payment.wallet.constant.RestApiConstant;
import com.payment.wallet.model.request.LinkBankRequest;
import com.payment.wallet.model.request.PaymentRequest;
import com.payment.wallet.model.request.TopUpRequest;
import com.payment.wallet.model.request.WithDrawalRequest;
import com.payment.wallet.model.response.CardResponse;
import com.payment.wallet.model.response.WalletResponse;
import com.payment.wallet.services.LinkBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestApiConstant.Base)
public class BankController {

    @Autowired
    LinkBankService linkBankService;

    @PostMapping("debit_card")
    ResponseEntity<?> debitCard(@RequestBody LinkBankRequest linkBankRequest){
        return linkBankService.linkBank(linkBankRequest);
    }

    @PostMapping("requests")
    ResponseEntity<?> requests(@RequestBody PaymentRequest paymentRequest){
        return linkBankService.creatPaymentRequest(paymentRequest);
    }

    @GetMapping("debit_card")
    ResponseEntity<List<CardResponse>> getCard(@RequestParam("user_id") Long userId){
        return linkBankService.getCard(userId);
    }
    @GetMapping("wallet")
    ResponseEntity<List<WalletResponse>> getWallet(@RequestParam("wallet_id") Long walletId){
        return linkBankService.getWallet(walletId);
    }

    @PostMapping("topup")
    ResponseEntity<?> topUp(@RequestBody TopUpRequest topUpRequest){
        return linkBankService.topUp(topUpRequest);
    }

    @GetMapping("transactions")
    ResponseEntity<?> getTransaction(@RequestParam("or") Long or){
        return linkBankService.getTransaction(or);
    }

    @PostMapping("withdrawal")
    ResponseEntity<?> withDrawal(@RequestBody WithDrawalRequest request){
        return linkBankService.withDrawal(request);
    }


}
