<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/bootstrap/css/bootstrap.css">
  <link rel="stylesheet" href="../css/fontawesome/css/all.css">
  <!-- <link rel="stylesheet" href="../css/default.css"> -->
  <link rel="stylesheet" href="../css/main.css">
   <script src="../js/bootstrap.bundle.js"></script>
  <title>Dashboard</title>
</head>
<body>

<!--Header-->
<c:import url = "components/incl/header.jsp"/>

<!--Transact Offcanvas: Pulls from the Left-->
<c:import url = "components/transact_offcanvas.jsp"/>

<!--Add Account Offcanvas: Pulls from the Right-->
<c:import url = "components/add_account_offcanvas.jsp"/>

  <!--Container-->
    <div class = "container">
      <!--Display Message -->
             <c:if test="${success !=null}">
               <div class="alert alert-info text-center border border-info">
                <b>${success}</b>
               </div>
             </c:if>
        <!--End of Display Message -->

        <!--Display Message -->
            <c:if test="${error !=null}">
              <div class="alert alert-danger text-center border border-danger">
               <b>${error}</b>
              </div>
            </c:if>
        <!--End of Display Message -->
      </div>
  <!--End Of Container-->

    <c:choose>
            <c:when test="${fn:length(userAccounts) > 0 }">
                <!-- Display Accounts --->
                <c:import url="components/accounts_display.jsp"/>
            </c:when>
            <c:otherwise>
                <!-- Do not Display Accounts -->
                <c:import url="components/no_accounts_display.jsp"/>
            </c:otherwise>
     </c:choose>




<!--Footer-->
<c:import url = "components/incl/footer.jsp"/>


