<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Account Form -->
  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
    <div class="offcanvas-header text-white">
      <h5 class="offcanvas-title" id="offcanvasRightLabel" class="text-white">Create / Add an Account</h5>
      <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>

    <!-- Offcanvas Body: Account Form wrapper -->
    <div class="offcanvas-body">
     <!-- Card: Accounts Form Card -->
     <div class="card">
      <!-- Card Body -->
      <div class="card-body">
        <form action="/account/create_account" method = "POST" class="add-account-form">
          <!-- Form Group -->
          <div class="form-group mb-3">
            <label for="">Enter Account Name</label>
            <input type="text" name="account_name" class="form-control" placeholder="Enter Account Name...">
          </div>
          <!-- End Of Form Group -->

          <!-- Form Group -->
          <div class="form-group mb-3">
            <label for="">Select Account Type</label>
            <select name="account_type" id="" class="form-control">
              <option value="">-- Select Account Type --</option>
              <option value="current">Current</option>
              <option value="savings">Savings</option>
              <option value="business">Business</option>
            </select>
          </div>
          <!-- End Of Form Group -->

          <div class="form-group my-2">
            <button id="" class="btn btn-md transact-btn">Add Account</button>
          </div>
        </form>
      </div>
      <!-- End Of  Card Body -->
     </div>
     <!-- End Of Card: Accounts Form Card -->
    </div>
    <!-- End Of Offcanvas Body: Account Form wrapper -->
  </div>
  <!-- End Of Account Form -->
