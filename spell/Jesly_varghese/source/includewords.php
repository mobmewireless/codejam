<?php
	include("../lib/bloomfilter.php");
	set_time_limit(600);
	$WordArray = file("../dictionary/dictionary.txt");
	$BloomedArray = array();
	foreach($WordArray as $Word)
			{			
				unset($BloomString);
				$BloomString = bloomFilter($Word);
				$BloomedArray[] = join('',$BloomString);
			}
	sort($BloomedArray);
	print_r($BloomedArray);
	$BloomedArray = array_unique($BloomedArray);
	file_put_contents("../dictionary/bloomed.txt",join("\r\n",$BloomedArray));
?>