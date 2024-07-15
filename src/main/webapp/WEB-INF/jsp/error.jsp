<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Errors</title>
  <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css">
  <link rel="stylesheet" href="css/fontawesome/css/all.css">
   <style>
    *{
        box-sizing: border-box;
        font-family:Comfortaa;
      }
    body{
      height:100vh;
      background-image: url("./images/background.PNG");
      background-size: cover;
      background-position: center center;
      background-repeat: no-repeat;
    }
    .card{
      box-shadow: 0px 3px 6px rgb(0,14,53);
    }
    .card .card-text{
      font-size:16px;
    }
   </style>
</head>
<body class="d-flex align-items-center justify-content-center text-danger">
  <!-- Card: Card Error -->
    <div class="card col-4 alert alert-danger border border-danger">
      <!-- Card Title -->
      <h3 class="card-title">
        <i class="fa fa-window-close me-2"></i>Errors:

      </h3>
      <!-- End of Card Title -->
      <hr>
        <!-- Card Body -->
        <div class="card-body">
          <!-- Card Text -->
          <p class="card-text">
             <!--Display Message -->
                  <c:if test="${requestScope.error !=null}">
                    <div class="alert alert-danger text-center border border-danger">
                     <b>${requestScope.error}</b>
                    </div>
                  </c:if>
             <!--End of Display Message -->
          </p>
          <!-- End of Card Text -->
          <hr>
          <!-- Back To Login Page -->
          <a href="/login" class="btn btn-sm btn-danger">
            <i class="fa fa-arrow-alt-circle-left me-1"></i>Back
          </a>
          <!-- End of  Back To Login Page -->
        </div>
        <!-- End of Card Body -->
    </div>

  <!-- End of Card: Card Error -->
</body>
</html>