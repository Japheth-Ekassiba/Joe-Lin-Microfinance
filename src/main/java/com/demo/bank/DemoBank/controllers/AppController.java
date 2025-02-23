package com.demo.bank.DemoBank.controllers;

import com.demo.bank.DemoBank.model.Account;
import com.demo.bank.DemoBank.model.PaymentHistory;
import com.demo.bank.DemoBank.model.TransactionHistory;
import com.demo.bank.DemoBank.model.User;
import com.demo.bank.DemoBank.repository.AccountRepository;
import com.demo.bank.DemoBank.repository.PaymentHistoryRepository;
import com.demo.bank.DemoBank.repository.TransactHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

@Autowired
    private AccountRepository accountRepository;

@Autowired
   private PaymentHistoryRepository paymentHistoryRepository;

@Autowired
    private TransactHistoryRepository transactHistoryRepository;


   User user;
    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session){
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

       //Get the Details Of The LoggedIn User
        user = (User)session.getAttribute("user");

        //Get the Accounts Of The LoggedIn User:
       List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());

        //Get Balance:
        BigDecimal totalAccountBalance = accountRepository.getTotalBalance(user.getUser_id());


        //Set Objects:
       getDashboardPage.addObject("userAccounts", getUserAccounts);
       getDashboardPage.addObject("totalBalance", totalAccountBalance);

        return getDashboardPage;
    }

    @GetMapping("/payment_history")
    public ModelAndView getPaymentHistory(HttpSession session){
        // Set View:
        ModelAndView getPaymentHistoryPage = new ModelAndView("paymentHistory");

        // Get Logged In User:\
        user = (User) session.getAttribute("user");

        // Get Payment History / Records:
        List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getUser_id());

        getPaymentHistoryPage.addObject("payment_history", userPaymentHistory);

        return getPaymentHistoryPage;

    }

    @GetMapping("/transact_history")
    public ModelAndView getTransactHistory(HttpSession session){
        // Set View:
        ModelAndView getTransactHistoryPage = new ModelAndView("transactHistory");

        // Get Logged In User:\
        user = (User) session.getAttribute("user");

        // Get Payment History / Records:
        List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordsById(user.getUser_id());

        getTransactHistoryPage.addObject("transact_history", userTransactHistory);

        return getTransactHistoryPage;

    }
}
