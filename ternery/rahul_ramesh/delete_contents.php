<?php

	$numbers_list = "testFile.txt";
	$handle = fopen($numbers_list, 'w') or die("can't open file");
	fclose($handle);
	for ($i = 1; $i <= 9; $i++)
	{
		$handle = fopen($i.".txt", 'w') or die("can't open file");
  		fclose($handle);	
	}
?>