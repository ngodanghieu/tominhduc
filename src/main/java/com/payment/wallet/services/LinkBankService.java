package com.payment.wallet.services;

import com.payment.wallet.model.request.LinkBankRequest;
import com.payment.wallet.model.request.PaymentRequest;
import com.payment.wallet.model.request.TopUpRequest;
import com.payment.wallet.model.request.UserRequest;
import com.payment.wallet.model.request.WithDrawalRequest;
import com.payment.wallet.model.response.CardResponse;
import com.payment.wallet.model.response.TransactionsResponse;
import com.payment.wallet.model.response.WalletResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LinkBankService {
    ResponseEntity<?> linkBank(LinkBankRequest linkBankRequest);

    ResponseEntity<?> creatPaymentRequest(PaymentRequest paymentRequest);

    ResponseEntity<?> topUp(TopUpRequest topUpRequest);

    ResponseEntity<?> withDrawal(WithDrawalRequest request);

    ResponseEntity<List<CardResponse>> getCard(Long userID);

    ResponseEntity<List<WalletResponse>> getWallet(Long walletId);

    ResponseEntity<List<TransactionsResponse>> getTransaction(Long or);

}
