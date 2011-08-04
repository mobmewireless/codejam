<?php

	include_once("search.php");
	function checkSpelling($Word,$WordArray,$UsedWords)
		{
			$BloomConverted = join('',bloomFilter($Word));
			//echo 'Spell rande';
			//print_r($WordArray);
					
			if(search($BloomConverted,$UsedWords)==True)
				{
					return True;
				}
			else if(search($BloomConverted,$WordArray)==True)
				{
					$UsedWords[] = $BloomConverted;
					$_SESSION['usedwords'] = $UsedWords;
					//echo 'Word in here:'.$Word.'<br/>';
					return True;
				}
			else
				{
					return False;
				}
		}
	?>


