//Get Transaction Type
const transactType =document.querySelector("#transact-type");

//Get Transaction Form
const paymentCard =document.querySelector(".payment-card");
const transferCard =document.querySelector(".transfer-card");
const depositCard =document.querySelector(".deposit-card");
const withdrawalCard=document.querySelector(".withdrawal-card");
//Check for transaction type Event Listener
transactType.addEventListener("change", function(){
  // Check for transaction type and display form
  switch(transactType.value) {
     case"payment":
      paymentCard.style.display="block";
      paymentCard.nextElementSibling.style.display="none";
      depositCard.style.display="none";
      withdrawalCard.style.display="none";
     break;

     case"transfer":
     transferCard.previousElementSibling.style.display="none";
     transferCard.style.display="block";
     transferCard.nextElementSibling.style.display="none";
     withdrawalCard.style.display="none";
     break;

     case"deposit":
     paymentCard.style.display="none";
     depositCard.previousElementSibling.style.display="none";
     depositCard.style.display="block";
     depositCard.nextElementSibling.style.display="none";
     break;

     case"withdrawal":
     paymentCard.style.display="none";
     transferCard.style.display="none";
     withdrawalCard.previousElementSibling.style.display="none";
     withdrawalCard.style.display="block";
     break;
  }
   // Check for transaction type and display form
});
 // End of Check for transaction type Event Listener

 