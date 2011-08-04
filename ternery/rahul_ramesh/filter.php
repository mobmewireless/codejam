<html>
  <head>
    <script language="javascript" type="text/javascript" src="jquery.js"></script>
  </head>
  <body>

  
  <p>Please open pages in this order:</br>1. <a href="index.php" target="_blank">Home page</a></br>2. <a href="filter.php" target="_blank">Filter Page</a></br>3. <a href="count.php" target="_blank">Counting page</a>. Keep all the pages open at the same time and you can see the realtime data. </p>
  Data from "testFile.text" is read, filtered and wrote in corresponding files and is delted from "testFile.txt".
  <div id="output"></div>

  <script id="source" language="javascript" type="text/javascript">



  $( setInterval(function () 
  {
    $.ajax({                                      
      url: 'filter_process.php',                    
      success: function(data)          
      {
        var id = data;
   
        $('#output').html("<p>"+id+"</p>"); 
      } 
    });
  },1000));


   

  </script>
  </body>
</html>