<?php
	set_time_limit(0);
	
	$iterations		= array();
	$iterations_map = array ();
	for( $i = 1000; $i <= 9998; $i++ ) {
		
		$digits[$i]["number"] = split_number($i);
		$digits[$i]["valid"] = validity_check($digits[$i]["number"]);
		$digits[$i]["desc"] = sort_desc($digits[$i]["number"]);
		$digits[$i]["asc"] = sort_asc($digits[$i]["number"]);  
		
		
		
		
		$digits[$i]["iterations"] = "";
		if ($digits[$i]["valid"] == true) {
			$digits[$i]["iterations"] = calculations($digits[$i]["desc"], $digits[$i]["asc"]);
		}
		if (in_array($digits[$i]["iterations"],$iterations) == true && $digits[$i]["valid"] == true){
			$iterations_map[array_search($digits[$i]["iterations"],$iterations)]++;
		} else if ($digits[$i]["valid"] == true) {
			array_push($iterations, $digits[$i]["iterations"]);
			$iterations_map[array_search($digits[$i]["iterations"],$iterations)] = 1;
		}

		
	}

?>