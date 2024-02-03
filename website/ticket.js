$(document).ready(function() {
        
    $(".eventamount").click(function() { 
      var amount = $(this).val();
      
      $("#event-price").val(amount);
    });
  });