<?php 
  $random_num = mt_rand(10000, 99999) . mt_rand(10000, 99999) ;   //to overcome the maximum limit.
  
  
  $numbers_list = "testFile.txt";

  $handle = fopen($numbers_list, 'a') or die("can't open file");
  fwrite($handle, "-".$random_num);
  fclose($handle);
  echo $random_num;

?>