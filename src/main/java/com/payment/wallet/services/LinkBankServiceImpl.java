package com.payment.wallet.services;

import com.payment.wallet.entities.LinkBank;
import com.payment.wallet.entities.Transaction;
import com.payment.wallet.entities.User;
import com.payment.wallet.entities.Wallet;
import com.payment.wallet.model.request.LinkBankRequest;
import com.payment.wallet.model.request.PaymentRequest;
import com.payment.wallet.model.request.TopUpRequest;
import com.payment.wallet.model.request.WithDrawalRequest;
import com.payment.wallet.model.response.CardResponse;
import com.payment.wallet.model.response.TransactionsResponse;
import com.payment.wallet.model.response.WalletResponse;
import com.payment.wallet.repository.LinkBankRepository;
import com.payment.wallet.repository.TransactionRepository;
import com.payment.wallet.repository.UserRepository;
import com.payment.wallet.repository.WalletRepository;
import com.payment.wallet.untils.Constant;
import com.payment.wallet.untils.JwtUltis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class LinkBankServiceImpl implements LinkBankService {

    @Autowired
    private LinkBankRepository linkBankRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public ResponseEntity<?> linkBank(LinkBankRequest linkBankRequest) {
        try {
            linkBankRepository.save(modelToEntity(linkBankRequest));
            return new ResponseEntity<String>(Constant.StatusCode.OK.getMessage(), HttpStatus.OK);
        } catch (Exception ex) {
        }
        return new ResponseEntity<String>(Constant.StatusCode.ERROR.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    @Transactional
    public ResponseEntity<?> creatPaymentRequest(PaymentRequest paymentRequest) {
        try {
            List<Wallet> userSender = walletRepository.findAllByWalletId(paymentRequest.getSender_wallet_id());
            List<Wallet> Beneficiary = walletRepository.findAllByWalletId(paymentRequest.getReceiver_wallet_id());

            if (!CollectionUtils.isEmpty(userSender) && !CollectionUtils.isEmpty(Beneficiary) && paymentRequest.getAmount() <= userSender.get(0).getMoney()) {
                transactionRepository.save(createTransaction(paymentRequest));
                Float amount = userSender.get(0).getMoney() - paymentRequest.getAmount();
                Wallet walletSender = userSender.get(0);
                walletSender.setMoney(amount);
                walletRepository.save(walletSender);
                Float amountBeneficiary = Beneficiary.get(0).getMoney() + paymentRequest.getAmount();
                Wallet walletBeneficiary = Beneficiary.get(0);
                walletBeneficiary.setMoney(amountBeneficiary);
                walletRepository.save(walletBeneficiary);
                return new ResponseEntity<String>(Constant.StatusCode.OK.getMessage(), HttpStatus.OK);
            }

        } catch (Exception ex) {

        }
        return new ResponseEntity<String>(Constant.StatusCode.ERROR.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    @Transactional
    public ResponseEntity<?> topUp(TopUpRequest topUpRequest) {
        List<Wallet> walletList = walletRepository.findAllByWalletId(topUpRequest.getReceiver_wallet_id());
        if (CollectionUtils.isEmpty(walletList)) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        } else {
            try {
                Wallet wallet = walletList.get(0);
                walletRepository.save(mapModelToEntity(wallet, topUpRequest));
                return new ResponseEntity<String>(Constant.StatusCode.OK.getMessage(), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<String>(Constant.StatusCode.ERROR.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }
    }

    @Override
    public ResponseEntity<?> withDrawal(WithDrawalRequest request) {
        List<Wallet> walletList = walletRepository.findAllByWalletId(request.getSender_wallet_id());
        if (CollectionUtils.isEmpty(walletList)) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        } else {
            try {
                Wallet wallet = walletList.get(0);
                Float amount = wallet.getMoney() - request.getAmount();
                wallet.setMoney(amount);
                walletRepository.save(wallet);
                return new ResponseEntity<String>(Constant.StatusCode.OK.getMessage(), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<String>(Constant.StatusCode.ERROR.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }
    }

    @Override
    public ResponseEntity<List<CardResponse>> getCard(Long userID) {
        try {
            List<LinkBank> linkBanks = linkBankRepository.findAllByUserId(userID);
            if (!CollectionUtils.isEmpty(linkBanks)) {

                return new ResponseEntity<>(Arrays.asList(EntityToModel(linkBanks.get(0))), HttpStatus.OK);
            }
        } catch (Exception ex) {
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<WalletResponse>> getWallet(Long walletId) {
        try {
            List<Wallet> walletList = walletRepository.findAllByUserId(walletId);
            if (!CollectionUtils.isEmpty(walletList)) {

                return new ResponseEntity<>(Arrays.asList(EntityToModel(walletList.get(0))), HttpStatus.OK);
            }
        } catch (Exception ex) {
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<TransactionsResponse>> getTransaction(Long or) {
        try {
            List<Transaction> transactionList = transactionRepository.findAllByTransactionId(or);
            if (!CollectionUtils.isEmpty(transactionList)) {
                List<User> sender = userRepository.findAllByUserId(transactionList.get(0).getSender_wallet_id());
                List<User> beneficiary = userRepository.findAllByUserId(transactionList.get(0).getBeneficiary_id());
                if (!CollectionUtils.isEmpty(sender) && CollectionUtils.isEmpty(beneficiary)) {
                    return new ResponseEntity<>(Arrays.asList(mapEntityToModel(transactionList.get(0),
                            sender.get(0), beneficiary.get(0))), HttpStatus.OK);
                }
            }
        } catch (Exception ex) {

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Wallet mapModelToEntity(Wallet wallet, TopUpRequest topUpRequest) {
        Float amount = wallet.getMoney() + topUpRequest.getAmount();
        wallet.setMoney(amount);
        return wallet;
    }

    private TransactionsResponse mapEntityToModel(Transaction transaction, User sender, User beneficiary) {
        TransactionsResponse transactionsResponse = new TransactionsResponse();
        transactionsResponse.setAmount(transaction.getAmount().toString());
        transactionsResponse.setMessage(transaction.getReason());
        transactionsResponse.setSender_full_name(sender.getName());
        transactionsResponse.setReceiver_full_name(beneficiary.getName());
        transactionsResponse.setReceiver_phone_number(beneficiary.getPhone());
        transactionsResponse.setReceiver_wallet_id(beneficiary.getWalletId().toString());
        transactionsResponse.setSender_phone_number(sender.getPhone());
        transactionsResponse.setSender_wallet_id(sender.getWalletId().toString());
        return transactionsResponse;
    }

    private WalletResponse EntityToModel(Wallet wallet) {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setBalance(wallet.getMoney().toString());
        walletResponse.setTimestamp(wallet.getTimestamp().toString());
        walletResponse.setUser_id(wallet.getUserId().toString());
        walletResponse.setWallet_id(wallet.getWalletId().toString());

        return walletResponse;

    }

    private CardResponse EntityToModel(LinkBank linkBank) {

        CardResponse cardResponse = new CardResponse();
        cardResponse.setBirthdate(linkBank.getBirthdate().toString());
        cardResponse.setCard_number(linkBank.getCard_number());
        cardResponse.setExpire_date(linkBank.getExpire_date() == null ? "" : linkBank.getExpire_date());
        cardResponse.setFull_name(linkBank.getName());
        cardResponse.setDebitcard_id(linkBank.getCard_number());
        cardResponse.setSex(linkBank.getSex());
        cardResponse.setStart_date(linkBank.getStart_date().toString());
        cardResponse.setTimestamp(linkBank.getTimestamp().toString());
        cardResponse.setUser_id(linkBank.getUserId().toString());

        return cardResponse;
    }


    private LinkBank modelToEntity(LinkBankRequest linkBankRequest) {
        LinkBank linkBank = new LinkBank();
        linkBank.setBirthdate(linkBankRequest.getBirthdate());
        String userId = JwtUltis.getUserId(linkBankRequest.getUser_id());
        linkBank.setCard_number(linkBankRequest.getCard_number());
        linkBank.setUserId(Long.valueOf(userId));
        linkBank.setSex(linkBankRequest.getSex());
        linkBank.setStart_date(linkBankRequest.getStart_date());
        linkBank.setTimestamp(linkBankRequest.getTimestamp());
        linkBank.setName(linkBankRequest.getFull_name());
        return linkBank;
    }

    private Transaction createTransaction(PaymentRequest paymentRequest) {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal(paymentRequest.getAmount()));
        transaction.setBeneficiary_id(paymentRequest.getReceiver_wallet_id());
        transaction.setSender_wallet_id(paymentRequest.getSender_wallet_id());
        transaction.setReason(paymentRequest.getMessage());
        transaction.setWallet_id(paymentRequest.getReceiver_wallet_id());
        transaction.setTimestamp(new Date());
        return transaction;
    }
}
