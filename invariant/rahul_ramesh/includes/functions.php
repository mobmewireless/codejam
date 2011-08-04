<?php	
	function split_number ($number) {	
		$digits[0] = fmod($number, 10);
		$number = floor($number/10);
		$digits[1] = fmod($number, 10);
		$number = floor($number/10);
		$digits[2] = fmod($number, 10);
		$number = floor($number/10);
		$digits[3] =  fmod($number, 10);
		$number = floor($number/10);
		return $digits;
	}
	function join_number ($array) {;
		$number = "";
		foreach ( $array as $item ) {
			$number .= $item;
		}
		return $number;
	}
	function validity_check ($digits) {
			
		if ( $digits[0] == $digits[1] && $digits[0] == $digits[2] && $digits[0] == $digits[3] && $digits[1] == $digits[2] && $digits[1] == $digits[3] && $digits[2] == $digits[3] ) {
			return false;
		}
		else {
			return true;
		}
	}
	function sort_desc ($array) {
		array_multisort( $array, SORT_DESC);
		return $array;
	}
	function sort_asc ($array) {
		array_multisort( $array, SORT_ASC);
		return $array;
	}
	function calculations ($desc, $asc) {
		
		$result = 0;
		$iterations = 0;
		do {
			$iterations++;
			$desc = join_number($desc);
			$asc = join_number($asc);	
			$result = $desc - $asc;
			$result_split = split_number($result);
			$desc = sort_desc($result_split);
			$asc  = sort_asc($result_split);
		}while ($result != 6174);
		return $iterations;
	}

	function table_create ($iterations, $iterations_map) {
		foreach ( $iterations as $id => $item) {
			if ($item != "") {
				echo "<tr><th>".$item."</th><td>".$iterations_map[$id]."</td></tr>";
			}
		}	
	}
?>