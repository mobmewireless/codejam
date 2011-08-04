<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>temp</title>
	<meta name="generator" content="TextMate http://macromates.com/">
	<meta name="author" content="Manu Mathew Thomas">
	<!-- Date: 2011-06-17 -->
</head>
<body>
<?php
		function makeTrigram($str)
		{
			$tgram=array();
			$words=explode(" ",$str);
			
			for($i=0;$i<count($words)-2;$i++)
			{
				
				$tgram=concat1($words,$i,$i+3);
				
			}
				
	 		return $tgram;
		}
		
		
		function concat1($word,$start,$end)
		{
			$stack = array();
			for($i=$start;$i<$end;$i++)
			{
				array_push($stack,$word[$i]);
				echo " ";
			
			}
			echo implode(" ",$stack);
		}
		
		
		$file_content = file_get_contents('story.txt');
		
		
		$trigram=makeTrigram($file_content);
			for($i=0;$i<count($trigram)-2;$i++)
			{
				
			echo $trigram[$i];
				
			}
?>
</body>
</html>
