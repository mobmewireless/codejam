<?php
	session_start();
	#header("Content-Type: text/xml");
	
	#$Mistakes = "<Mistakes>";
	
	include_once("../lib/bloomfilter.php");
	$UsedWords = array();
	if(!isset($_SESSION['usedwords']))
		$UsedWords = array();
	else
		$UsedWords = $_SESSION['usedwords']; #Buffer to use  used words
	
	$WordArray = file("../dictionary/bloomed.txt");
	//echo 'BaseRange';
	//print_r($WordArray);
	include_once("checker.php");

	$Content = $_POST['text'];
	$Content = explode(' ',$Content);
		
	foreach($Content as $Word)
		{
			if(is_numeric($Word))
				continue;
			if(checkSpelling(strtolower($Word),$WordArray,$UsedWords)==False)
				echo $Word."<br/>";
				#$Mistakes = $Mistakes.'<Mistake>'.$Word.'</Mistake>'; 
		}
	
	#$Mistakes = $Mistakes.'</Mistakes>';
	
	#echo $Mistakes;
	?>