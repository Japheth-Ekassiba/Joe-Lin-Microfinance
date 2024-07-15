<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

  <!-- Main Page Header -->
  <header class="main-page-header mb-3 bg-primary">
    <!-- Container -->
    <div class="container d-flex align-items-center">
      <!-- Company Name -->
      <div class="company-name">
        Joe-Lin Bank
      </div>
      <!-- End Of Company Name -->

      <!-- Navigation -->
      <nav class="navigation">
       <li><a href="/app/dashboard">Dashboard</a></li>
       <li><a href="/app/payment_history">Payment History</a></li>
       <li><a href="/app/transact_history">Transaction History</a></li>
      </nav>
       <!-- End of Navigation -->

       <!-- Display Name -->
       <div class="display-name ms-auto text-white">
        <i class="fa fa-circle text-sucess me-2"></i> Welcome: <span>${user.first_name} ${user.last_name}</span>
       </div>
       <!-- End of  Display Name -->

       <!-- Log Out Button -->
       <a href="/logout" class="btn btn-sm text-white ms-2">
        <i class="fas fa-sign-out-alt" aria-hidden="true"></i> Sign Out
       </a>
       <!-- End Of Log Out Button -->


    </div>
    <!-- End of Container -->
  </header>
  <!-- End of Main Page Header -->