<html>
  <head>
    <script language="javascript" type="text/javascript" src="jquery.js"></script>
  </head>
  <body>


  <p>Please open pages in this order:</br>1. <a href="index.php" target="_blank">Home page</a></br>2. <a href="filter.php" target="_blank">Filter Page</a></br>3. <a href="count.php" target="_blank">Counting page</a>. Keep all the pages open at the same time and you can see the realtime data. </p>
  Each of the nine files is read and the number of numbers is counted.
  <div id="output"></div>

  <script id="source" language="javascript" type="text/javascript">



  $( setInterval(function () 
  {
    
    $.ajax({                                      
      url: 'file_monitor.php',              //data format      
      success: function(data)          //on recieve of reply
      {
        var id = data;
        $('#output').html("<p>"+id+"</p>"); 
      } 
    });
  },1000));


   

  </script>
  </body>
</html>