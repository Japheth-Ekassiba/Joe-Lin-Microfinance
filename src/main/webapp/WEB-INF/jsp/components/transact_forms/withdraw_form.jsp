<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>


  <!-- Card: Withdraw Card -->
          <div class="card withdrawal-card my-2">
            <!-- Card Body -->
            <div class="card-body">
               <form action = "/transact/withdraw" method = "POST">
                <!-- Form Group -->
                    <div class="form-group mb-2">
                      <label for="">Enter Withdrawal Amount</label>
                      <input type="text" name="withdrawal_amount"  class="form-control" placeholder="Enter Withdrawal Amount">
                    </div>
                <!-- End of  Form Group -->


                <!-- Form Group -->
                    <div class="form-group">
                        <label for="">Select Account</label>
                        <!-- Select Account Option -->
                        <select name="account_id" class="form-control" id="">
                            <option value="">-- Select Account --</option>
                            <c:if test="${userAccounts != null}">
                                <c:forEach items="${userAccounts}" var="selectAccount">
                                    <option value="${selectAccount.account_id}">${selectAccount.account_name}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <!-- End Select Account Option -->

                        <!-- Form Group -->
                        <div class="form-group my-2">
                          <button id="" class="btn btn-md transact-btn">Withdraw</button>
                    </div>
                <!-- End of  Form Group -->

                </div>
                <!-- End Of  Form Group -->
               </form>
            </div>
            <!-- End Of  Card Body -->
          </div>
          <!-- End Of Card: Withdraw Card -->