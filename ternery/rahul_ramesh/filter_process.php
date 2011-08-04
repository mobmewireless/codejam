<?php



$numbers_list = "testFile.txt";
$file_content = file_get_contents ($numbers_list);
$numbers = explode("-", $file_content);

    $handle = fopen($numbers_list, 'w') or die("can't open file");
  	fclose($handle);

function distribute($filtered_file, $filtered_number)
{
	$handle = fopen($filtered_file, 'a') or die("can't open file");
	fwrite($handle, "-".$filtered_number);
	fclose($handle);
	
}


	foreach ( $numbers as $id => $number)
	{
		$first_digits[$id] = substr($number,0,1);
		
		switch ($first_digits[$id]) {
	    case 1:
	        distribute("1.txt", $number);
	        break;
	    case 2:
	        distribute("2.txt", $number);
	        break;
	    case 3:
	        distribute("3.txt", $number);
	        break;
	    case 4:
	        distribute("4.txt", $number);
	        break;
	    case 5:
	        distribute("5.txt", $number);
	        break;
	    case 6:
	        distribute("6.txt", $number);
	        break;
	    case 7:
	        distribute("7.txt", $number);
	        break;
	    case 8:
	        distribute("8.txt", $number);
	        break;
	    case 9:
	        distribute("9.txt", $number);
	        break;
	}
}
print_r($first_digits);


?>