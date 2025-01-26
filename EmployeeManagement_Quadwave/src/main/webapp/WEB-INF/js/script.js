$(document).ready(function(){
    $("#myInput").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("#myTable tr").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });

  $(document).ready(function(){
    $('#open').click(function(){
        $('.model-container').css('transform','scale(1)');
    })

    $('#close').click(function(){
        $('.model-container').css('transform','scale(0)');
    })

    $('#closebtn').click(function(){
        $('.model-container').css('transform','scale(0)');
    })
  })


