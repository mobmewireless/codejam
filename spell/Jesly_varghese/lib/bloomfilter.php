<?php
	#Function to convert a given string into corresponding bloomFilter data
	function bloomFilter($Word)       
	{
		$HashAlgorithms = hash_algos(); #loads all hash function available in php
		$BloomedArray = array();
		$UsedIndex = array();
		for($i=0;$i<13;$i++)
			$BloomedArray[$i] = 0;
			
		foreach($HashAlgorithms as $CurrentHashAlgorithm)
			{
				$Index =  ((int)hash($CurrentHashAlgorithm,$Word))%13;
				if(!in_array($Index,$UsedIndex))
					{
						$UsedIndex[] = $Index;
						$BloomedArray[$Index] = 1; 
					}
			}
		
		return $BloomedArray;
	}
	?>