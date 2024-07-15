package com.demo.bank.DemoBank.controllers;

import com.demo.bank.DemoBank.model.User;
import com.demo.bank.DemoBank.repository.AccountRepository;
import com.demo.bank.DemoBank.repository.PaymentRepository;
import com.demo.bank.DemoBank.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/transact")
public class TransactController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TransactRepository transactRepository;

    User user;
    double currentBalance;
    double newBalance;
    LocalDateTime currentDateTime = LocalDateTime.now();

    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount") String depositAmount,
                          @RequestParam("account_id") String accountID,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {

        //TODO: CHECK FOR EMPTY STRINGS:
        if (depositAmount.isEmpty() || accountID.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Deposit Amount or Account Depositing to cannot be empty!");
            return "redirect:/app/dashboard";
        }
        //TODO: GET LOGGED IN USER:
        user = (User) session.getAttribute("user");

        //TODO: GET THE CURRENT ACCOUNT BALANCE:
        int acc_id = Integer.parseInt(accountID);

        double depositAmountValue = Double.parseDouble(depositAmount);


        //TODO: CHECK IF DEPOSIT AMOUNT IS 0 (ZERO):
        if (depositAmountValue == 0) {
            redirectAttributes.addFlashAttribute("error", "Deposit Amount cannot be of 0 (zero) value!");
            return "redirect:/app/dashboard";

        }

        //TODO: UPDATE BALANCE:
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);

        newBalance = currentBalance + depositAmountValue;

        //UPDATE ACCOUNT:
        accountRepository.changeAccountBalanceById(newBalance, acc_id);

        //Log Successful Transaction:
        transactRepository.logTransaction(acc_id, "deposit", depositAmountValue, "online", "success", "Deposit Transaction Successful",currentDateTime);

        redirectAttributes.addFlashAttribute("success", "Amount Deposited Successfully!");
        return "redirect:/app/dashboard";
    }
    //End Of Deposit Method.

    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from") String transfer_from,
                           @RequestParam("transfer_to") String transfer_to,
                           @RequestParam("transfer_amount") String transfer_amount,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        //Innit Error Message:
        String errorMessage;
        //TODO: CHECK FOR EMPTY FIELDS:
        if (transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()) {
            errorMessage = "The account transferring from and to along with the amount cannot be empty!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO: CONVERT VARIABLES:
        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        //TODO: CHECK IF TRANSFERRING INTO THE SAME ACCOUNT:
        if (transferFromId == transferToId) {
            errorMessage = "Cannot Transfer to the same account. Please select the appropriate account to perform transfer!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO: CHECK FOR 0 (ZERO) VALUES:
        if (transferAmount == 0) {
            errorMessage = "Cannot Transfer an amount of 0 (Zero), please enter a value greater than 0(Zero)!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }



        //TODO: GET LOGGED IN USER:
        user = (User) session.getAttribute("user");
        //TODO: GET THE CURRENT BALANCE:
        double currentBalanceOfAccountTransferringFrom = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        double currentBalanceOfAccountTransferringTo = accountRepository.getAccountBalance(user.getUser_id(), transferToId);

        //TODO: SET NEW BALANCE:
        double newBalanceOfAccountTransferringFrom = currentBalanceOfAccountTransferringFrom - transferAmount;


        //TODO: CHECK IF THE TRANSFER AMOUNT IS MORE THAN THE CURRENT BALANCE:
        if (newBalanceOfAccountTransferringFrom < transferAmount){
            errorMessage = "You have insufficient amount to perform this transfer!";

            //Log Failed Transaction:
            transactRepository.logTransaction(transferFromId, "Transfer", transferAmount, "online", "failed","Insufficient Funds", currentDateTime);
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        double newBalanceOfAccountTransferringTo = currentBalanceOfAccountTransferringTo + transferAmount;

        //Changed the balance of account transferring From:
        accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringFrom, transferFromId);

        //Changed the balance of account transferring To:
        accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringTo, transferToId);

        //Log Successful Transaction:
        transactRepository.logTransaction(transferFromId, "Transfer", transferAmount, "online", "success", "Transfer Transaction Successful",currentDateTime);

        String successMessage = "Amount Transferred Successfully!";
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";
    }
    //End Of Transfer Method.


    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("withdrawal_amount") String withdrawalAmount,
                           @RequestParam("account_id") String accountID,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        String errorMessage;
        String successMessage;
        //TODO: CHECK FOR EMPTY STRINGS:
        if (withdrawalAmount.isEmpty() || accountID.isEmpty()) {
            errorMessage = "Withdrawal Amount and Account Withdrawing From Cannot be Empty!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO: CONVERT VARIABLES:
        double withdrawal_amount = Double.parseDouble(withdrawalAmount);
        int account_id = Integer.parseInt(accountID);

        //TODO: CHECK FOR 0 (ZERO) VALUES:
        if (withdrawal_amount == 0) {
            errorMessage = "Withdrawal Amount Cannot be 0 (Zero). Please Enter a Value Greater than Zero(0)!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";

        }
        //TODO: GET LOGGED IN USER
        user = (User) session.getAttribute("user");

        //TODO: GET CURRENT BALANCE:
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), account_id);

        //TODO: CHECK IF THE WITHDRAW AMOUNT IS MORE THAN THE CURRENT BALANCE:
        if (currentBalance < withdrawal_amount){
            errorMessage = "You have insufficient amount to perform this transfer!";

            //Log Failed Transaction:
            transactRepository.logTransaction(account_id, "Withdrawal", withdrawal_amount, "online", "failed","Insufficient Funds", currentDateTime);
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO: SET NEW BALANCE:
        newBalance = currentBalance - withdrawal_amount;

        //TODO: UPDATE ACCOUNT BALANCE:
        accountRepository.changeAccountBalanceById(newBalance, account_id);

        //Log Successful Transaction:
        transactRepository.logTransaction(account_id, "Withdrawal", withdrawal_amount, "online", "success", "Withdrawal Transaction Successful",currentDateTime);


        successMessage = "Withdrawal Done Successfully!";
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";
    }

    //End Of Withdrawal Method.

    @PostMapping("/payment")
    public String payment(@RequestParam("beneficiary")String beneficiary,
                          @RequestParam("account_number")String account_number,
                          @RequestParam("account_id")String account_id,
                          @RequestParam("reference")String reference,
                          @RequestParam("payment_amount")String payment_amount,
                          HttpSession session,
                          RedirectAttributes redirectAttributes){

        String errorMessage;
        String successMessage;
        //TODO: CHECK FOR EMPTY VALUES:
        if (beneficiary.isEmpty() || account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()){
            errorMessage = "Beneficiary, Account Number, Account Paying From and Payment Amount Cannot be Empty!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO: CONVERT VARIABLES:
        int accountID = Integer.parseInt(account_id);
        double paymentAmount = Double.parseDouble(payment_amount);

        // TODO:CHECK FOR ZERO (0) VALUES:
        if (paymentAmount == 0){
            errorMessage = "Payment Amount Cannot be Zero (0), please enter a valid amount!";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO: GET LOGGED IN USER:
        user = (User) session.getAttribute("user");

        //TODO: GET CURRENT BALANCE:
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), accountID);

        //TODO: CHECK IF THE PAYMENT AMOUNT IS MORE THAN THE CURRENT BALANCE:
        if (currentBalance < paymentAmount){
            errorMessage = "You have insufficient amount to perform this payment!";
            String reasonCode = "Could not Process Payment due to Insufficient Funds!";

            paymentRepository.makePayment(accountID, beneficiary, account_number, paymentAmount, reference, "failed", reasonCode, currentDateTime);


            //Log Failed Transaction:
            transactRepository.logTransaction(accountID, "Payment", paymentAmount, "online", "failed","Insufficient Funds", currentDateTime);
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/app/dashboard";
        }

        //TODO: SET NEW BALANCE FOR ACCOUNT PAYING FROM:
        newBalance = currentBalance - paymentAmount;

        //TODO: MAKE PAYMENTS:
        String reasonCode = "Payment Processed Successfully!";

        paymentRepository.makePayment(accountID, beneficiary, account_number, paymentAmount, reference, "success", reasonCode , currentDateTime);


        //TODO: UPDATE ACCOUNT PAYING FOR:
        accountRepository.changeAccountBalanceById(newBalance, accountID);

        //Log Successful Transaction:
        transactRepository.logTransaction(accountID, "Payment", paymentAmount, "online", "success", "Payment Transaction Successful",currentDateTime);


        successMessage = reasonCode;
        redirectAttributes.addFlashAttribute("success", successMessage);
        return "redirect:/app/dashboard";

    }
}
