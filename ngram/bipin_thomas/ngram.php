<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
  <title>Ngram</title>
</head>

<body>

<?php
        $file_input= file_get_contents('filename.txt');
        while(!feof($file_input))
             {
               $words=explode(" ",$file_input);
             }

        $ngram=makeTrigram($file_input);
	  	function makeTrigram($str)
	   	{
			$tg=array();
			for($i=0;$i<count($words)-2;$i++)
			{
                $tgram=concaten($words,$i,$i+3);
            }

	 		return $tg;
		}


		function concaten($word,$start,$end)
		{
			$stack = array();
			for($i=$start;$i<$end;$i++)
			{
				array_push($stack,$word[$i]);
				echo " ";

			}
			echo implode(" ",$stack);
		}

          	for($i=0;$i<count($ngram)-2;$i++)
			{
            echo $ngram[$i];
			}
?>
</body>

</html>
