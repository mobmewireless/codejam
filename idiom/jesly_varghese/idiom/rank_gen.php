<?php
$stored_data = file_get_contents('data');
$stored_data = explode(':',$stored_data);
$i=2;
$max_score =  0;
$rank_list = array(); #data will be stored as index = word; index+1 = score
$rank_pointer = 1;
#initialize rank_list[]
$i=0;
while($i<count($stored_data))
	{
		
		$rank_list[$i] = -99999999999999;
		$i= $i+1;
	}
$i=2;
while(count($stored_data)>$i)
{	
	if($stored_data[$i]>$max_score)
	{
		$max_score = $stored_data[$i];
		$index = count($rank_list);
		while($index>1)
		{
			 $rank_list[$index] = $rank_list[$index-1];
			 $index--;
		}
		$rank_list[0] = $stored_data[$i-1];
		$rank_list[1] = $stored_data[$i];
	}
	else #find a suitable position in rank list
	{	
		$index = 3;
		while($rank_list[$index]>$stored_data[$i])
		{
			
			$index = $index+2;
		}
		$z_index = count($rank_list);
		while($z_index!=$index-1)
		{
			
			$rank_list[$z_index] = $rank_list[($z_index-2)]; #shift old values
			--$z_index;
			//print_r($rank_list);echo '<br/>';
		}
		
		$rank_list[$index-1] = $stored_data[$i-1];
		$rank_list[$index] = $stored_data[$i];
	}
	$i = $i+2;
}
$i=0;
$rank_no=1;
//print_r($rank_list);
while($i<count($rank_list)&&$rank_list[$i]!=-99999999999999)
{
	echo $rank_no.' '.$rank_list[$i].'<br/>';
	$i=$i+2;
	$rank_no++;
}
?>